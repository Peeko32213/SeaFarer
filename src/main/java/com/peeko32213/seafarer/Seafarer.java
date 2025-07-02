package com.peeko32213.seafarer;

import com.peeko32213.seafarer.events.ClientEvents;
import com.peeko32213.seafarer.data.*;
import com.peeko32213.seafarer.registry.*;
import com.peeko32213.seafarer.registry.SeafarerBlockEntities;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import com.peeko32213.seafarer.data.SeafarerBlockstateProvider;
import com.peeko32213.seafarer.data.SeafarerItemModelProvider;
import com.peeko32213.seafarer.data.SeafarerLanguageProvider;
import com.peeko32213.seafarer.data.SeafarerSoundDefinitionsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Mod(Seafarer.MOD_ID)
public class Seafarer {

    public static final String MOD_ID = "seafarer";
    private static int packetsRegistered;
    public static final Logger LOGGER = LogManager.getLogger();

    public Seafarer() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientEvents::init));
        bus.addListener(this::dataSetup);

        SeafarerBlocks.BLOCKS.register(bus);
        SeafarerItems.ITEMS.register(bus);
        SeafarerCreativeTab.DEF_REG.register(bus);
        SeafarerEntities.ENTITY_TYPES.register(bus);
        SeafarerFeatures.FEATURES.register(bus);
        SeafarerBlockEntities.BLOCK_ENTITIES.register(bus);
        SeafarerLootModifiers.LOOT_MODIFIERS.register(bus);
        SeafarerSoundEvents.DEF_REG.register(bus);
        SeafarerPaintings.PAINTING_VARIANTS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SeafarerEntityPlacement.entityPlacement();
            addToFlowerPot(SeafarerBlocks.COASTAL_LAVENDER, SeafarerBlocks.POTTED_COASTAL_LAVENDER);
            addToFlowerPot(SeafarerBlocks.COASTAL_WILDFLOWER, SeafarerBlocks.POTTED_COASTAL_WILDFLOWER);
            addToFlowerPot(SeafarerBlocks.SEA_THRIFT, SeafarerBlocks.POTTED_SEA_THRIFT);
            addToFlowerPot(SeafarerBlocks.SEA_HOLLY, SeafarerBlocks.POTTED_SEA_HOLLY);

            addToComposter(SeafarerBlocks.COASTAL_LAVENDER, 0.7F);
            addToComposter(SeafarerBlocks.COASTAL_WILDFLOWER, 0.3F);
            addToComposter(SeafarerBlocks.SEA_THRIFT, 0.5F);
            addToComposter(SeafarerBlocks.SEA_HOLLY, 0.6F);
        });
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean server = event.includeServer();
        boolean client = event.includeClient();

        SeafarerDatapackBuiltinEntriesProvider datapackEntries = new SeafarerDatapackBuiltinEntriesProvider(output, provider);
        generator.addProvider(server, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        // Server generators
        SeafarerBlockTagProvider blockTags = new SeafarerBlockTagProvider(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new SeafarerItemTagProvider(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(server, new SeafarerEntityTagProvider(output, provider, helper));
        generator.addProvider(server, new SeafarerBiomeTagProvider(output, provider, helper));
        generator.addProvider(server, new SeafarerPaintingTagProvider(output, provider, helper));
        generator.addProvider(server, new SeafarerRecipeGenerator(output));
        generator.addProvider(server, SeafarerLootProvider.create(output));

        // Client generators
        generator.addProvider(client, new SeafarerBlockstateProvider(output, helper));
        generator.addProvider(client, new SeafarerItemModelProvider(output, helper));
        generator.addProvider(client, new SeafarerLanguageProvider(output));
        generator.addProvider(client, new SeafarerSoundDefinitionsProvider(output, helper));
    }

    public static void addToFlowerPot(RegistryObject<Block> plantBlockLoc, Supplier<? extends Block> pottedPlantBlock){
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plantBlockLoc.getId(),pottedPlantBlock);
    }
    public static void addToComposter(RegistryObject<Block> item, float amountOfCompost){
        ComposterBlock.COMPOSTABLES.put(item.get().asItem(), amountOfCompost);
    }

    public static ResourceLocation modPrefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
