package com.peeko32213.seafarer;

import com.peeko32213.seafarer.biolith.SeaBiomePlacements;
import com.peeko32213.seafarer.events.ClientEvents;
import com.peeko32213.seafarer.data.*;
import com.peeko32213.seafarer.registry.*;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.data.SeaBlockstateProvider;
import com.peeko32213.seafarer.data.SeaItemModelProvider;
import com.peeko32213.seafarer.data.SeaLanguageProvider;
import com.peeko32213.seafarer.data.SeaSoundDefinitionsProvider;
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
import net.minecraftforge.fml.common.Mod;
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
        bus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientEvents::init));
        bus.addListener(this::dataSetup);

        SeaBlocks.BLOCKS.register(bus);
        SeaItems.ITEMS.register(bus);
        SeafarerTab.CREATIVE_TABS.register(bus);
        SeaEntities.ENTITY_TYPES.register(bus);
        SeaFeatures.FEATURES.register(bus);
        SeaLootModifiers.LOOT_MODIFIERS.register(bus);
        SeaSoundEvents.SOUND_EVENTS.register(bus);
        SeaPaintings.PAINTING_VARIANTS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SeaBiomePlacements.register();
            addToComposter(SeaBlocks.COASTAL_LAVENDER, 0.7F);
            addToComposter(SeaBlocks.COASTAL_WILDFLOWER, 0.3F);
            addToComposter(SeaBlocks.SEA_THRIFT, 0.5F);
            addToComposter(SeaBlocks.SEA_HOLLY, 0.6F);
        });
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean server = event.includeServer();

        SeaDatapackBuiltinEntriesProvider datapackEntries = new SeaDatapackBuiltinEntriesProvider(output, provider);
        generator.addProvider(server, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        SeaBlockTagProvider blockTags = new SeaBlockTagProvider(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new SeaItemTagProvider(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(server, new SeaEntityTagProvider(output, provider, helper));
        generator.addProvider(server, new SeaBiomeTagProvider(output, provider, helper));
        generator.addProvider(server, new SeaPaintingTagProvider(output, provider, helper));
        generator.addProvider(server, new SeaRecipeGenerator(output));
        generator.addProvider(server, SeaLootProvider.create(output));
        generator.addProvider(server, new SeaChunkGeneratorModifierProvider(event, datapackEntries));

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
