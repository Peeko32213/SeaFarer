package com.peeko32213.seafarer;

import com.peeko32213.seafarer.client.event.ClientEvents;
import com.peeko32213.seafarer.core.registry.*;
import com.peeko32213.seafarer.core.registry.blocks.SFBlockEntities;
import com.peeko32213.seafarer.core.registry.blocks.SFBlocks;
import com.peeko32213.seafarer.data.SFDatapackBuiltinEntriesProvider;
import com.peeko32213.seafarer.data.client.SFBlockstateGenerator;
import com.peeko32213.seafarer.data.client.SFItemModelGenerator;
import com.peeko32213.seafarer.data.client.SFLanguageGenerator;
import com.peeko32213.seafarer.data.server.*;
import com.peeko32213.seafarer.data.server.loot.SFLootGenerator;
import com.peeko32213.seafarer.data.server.modifiers.SFChunkGeneratorModifierProvider;
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

@Mod(SeaFarer.MODID)
public class SeaFarer {
        public static final String MODID = "seafarer";
        private static int packetsRegistered;
        public static final Logger LOGGER = LogManager.getLogger();


    public SeaFarer() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(ClientEvents::init));
        modEventBus.addListener(this::dataSetup);
        SFBlocks.BLOCKS.register(modEventBus);
        SFItems.ITEMS.register(modEventBus);
        SFCreativeTabs.DEF_REG.register(modEventBus);
        SFEntities.ENTITIES.register(modEventBus);
        SFFeatures.FEATURES.register(modEventBus);
        SFBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        SFLootModifiers.LOOT_MODIFIERS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SFEntityPlacement.entityPlacement();
            addToFlowerPot(SFBlocks.COASTAL_LAVENDER, SFBlocks.POTTED_COASTAL_LAVENDER);
            addToFlowerPot(SFBlocks.COASTAL_WILDFLOWER, SFBlocks.POTTED_COASTAL_WILDFLOWER);
            addToFlowerPot(SFBlocks.SEA_THRIFT, SFBlocks.POTTED_SEA_THRIFT);
            addToFlowerPot(SFBlocks.SEA_HOLLY, SFBlocks.POTTED_SEA_HOLLY);

            addToComposter(SFBlocks.COASTAL_LAVENDER, 0.7F);
            addToComposter(SFBlocks.COASTAL_WILDFLOWER, 0.3F);
            addToComposter(SFBlocks.SEA_THRIFT, 0.5F);
            addToComposter(SFBlocks.SEA_HOLLY, 0.6F);

        });
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        boolean server = event.includeServer();
        boolean client = event.includeClient();

        SFDatapackBuiltinEntriesProvider datapackEntries = new SFDatapackBuiltinEntriesProvider(output, provider);
        generator.addProvider(server, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        // Server generators
        SFBlockTagsGenerator blockTags = new SFBlockTagsGenerator(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new SFItemTagsGenerator(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(server, new SFEntityTagsGenerator(output, provider, helper));
        generator.addProvider(server, new SFBiomeTagsProvider(output, provider, helper));
        generator.addProvider(server, new SFRecipeGenerator(output));
        generator.addProvider(server, SFLootGenerator.create(output));
        generator.addProvider(server, new SFChunkGeneratorModifierProvider(output, provider));

        // Client generators
        generator.addProvider(client, new SFBlockstateGenerator(output, helper));
        generator.addProvider(client, new SFItemModelGenerator(output, helper));
        generator.addProvider(client, new SFLanguageGenerator(output));
    }

    public static void addToFlowerPot(RegistryObject<Block> plantBlockLoc, Supplier<? extends Block> pottedPlantBlock){
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(plantBlockLoc.getId(),pottedPlantBlock);
    }
    public static void addToComposter(RegistryObject<Block> item, float amountOfCompost){
        ComposterBlock.COMPOSTABLES.put(item.get().asItem(), amountOfCompost);
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }

}
