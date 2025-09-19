package com.peeko32213.seafarer;

import com.peeko32213.seafarer.worldgen.biome.*;
import com.peeko32213.seafarer.events.*;
import com.peeko32213.seafarer.data.*;
import com.peeko32213.seafarer.registry.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Mod(Seafarer.MOD_ID)
public class Seafarer {

    public static final String MOD_ID = "seafarer";

    public Seafarer() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();

        bus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientEvents::init));
        bus.addListener(this::dataSetup);

        context.registerConfig(ModConfig.Type.COMMON, SeafarerConfig.COMMON_CONFIG);

        SeaItems.ITEMS.register(bus);
        SeaBlocks.BLOCKS.register(bus);
        SeaBlockEntities.BLOCK_ENTITIES.register(bus);
        SeafarerTab.CREATIVE_TABS.register(bus);
        SeaEntities.ENTITY_TYPES.register(bus);
        SeaFeatures.FEATURES.register(bus);
        SeaStructureTypes.STRUCTURE_TYPES.register(bus);
        SeaStructurePieces.STRUCTURE_PIECES.register(bus);
        SeaLootModifiers.LOOT_MODIFIERS.register(bus);
        SeaSoundEvents.SOUND_EVENTS.register(bus);
        SeaParticles.PARTICLE_TYPES.register(bus);
        SeaPaintings.PAINTING_VARIANTS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            if (SeafarerConfig.BIOMES.get()) SeaBiomePlacements.register();
            SeaSurfaceRules.register();
            addToComposter(SeaBlocks.COASTAL_LAVENDER, 0.7F);
            addToComposter(SeaBlocks.COASTAL_WILDFLOWER, 0.3F);
            addToComposter(SeaBlocks.SEA_THRIFT, 0.5F);
            addToComposter(SeaBlocks.SEA_HOLLY, 0.6F);
            addToComposter(SeaBlocks.FIERY_DUSTER, 0.6F);
            addToComposter(SeaBlocks.SILK_LILIES, 0.6F);
            addToComposter(SeaBlocks.TWILIGHT_BLADE, 0.6F);
            addToComposter(SeaBlocks.DAWNFLAME, 0.7F);

        });
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean server = event.includeServer();

        SeaDatapackProvider datapackEntries = new SeaDatapackProvider(output, provider);
        generator.addProvider(server, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        SeaBlockTagProvider blockTags = new SeaBlockTagProvider(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new SeaItemTagProvider(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(server, new SeaEntityTagProvider(output, provider, helper));
        generator.addProvider(server, new SeaBiomeTagProvider(output, provider, helper));
        generator.addProvider(server, new SeaPaintingTagProvider(output, provider, helper));
        generator.addProvider(server, new SeaRecipeProvider(output));
        generator.addProvider(server, SeaLootProvider.create(output));

        boolean client = event.includeClient();

        generator.addProvider(client, new SeaBlockstateProvider(output, helper));
        generator.addProvider(client, new SeaItemModelProvider(output, helper));
        generator.addProvider(client, new SeaLanguageProvider(output));
        generator.addProvider(client, new SeaSoundDefinitionsProvider(output, helper));
    }

    public static void addToComposter(RegistryObject<Block> item, float amountOfCompost){
        ComposterBlock.COMPOSTABLES.put(item.get().asItem(), amountOfCompost);
    }

    public static ResourceLocation modPrefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
