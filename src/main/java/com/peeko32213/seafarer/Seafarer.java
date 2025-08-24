package com.peeko32213.seafarer;

import com.peeko32213.seafarer.events.ClientEvents;
import com.peeko32213.seafarer.data.*;
import com.peeko32213.seafarer.registry.*;
import com.peeko32213.seafarer.registry.SFBlocks;
import com.peeko32213.seafarer.data.SFBlockstateProvider;
import com.peeko32213.seafarer.data.SFItemModelProvider;
import com.peeko32213.seafarer.data.SFLanguageProvider;
import com.peeko32213.seafarer.data.SFSoundDefinitionsProvider;
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

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Mod(Seafarer.MOD_ID)
public class Seafarer {

    public static final String MOD_ID = "seafarer";

    public Seafarer() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientEvents::init));
        bus.addListener(this::dataSetup);

        SFBlocks.BLOCKS.register(bus);
        SFItems.ITEMS.register(bus);
        SeafarerTab.DEF_REG.register(bus);
        SFEntities.ENTITY_TYPES.register(bus);
        SFFeatures.FEATURES.register(bus);
        SFLootModifiers.LOOT_MODIFIERS.register(bus);
        SFSoundEvents.DEF_REG.register(bus);
        SFPaintings.PAINTING_VARIANTS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
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

        SFBlockTagProvider blockTags = new SFBlockTagProvider(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new SFItemTagProvider(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(server, new SFEntityTagProvider(output, provider, helper));
        generator.addProvider(server, new SFBiomeTagProvider(output, provider, helper));
        generator.addProvider(server, new SFPaintingTagProvider(output, provider, helper));
        generator.addProvider(server, new SFRecipeGenerator(output));
        generator.addProvider(server, SFLootProvider.create(output));

        generator.addProvider(client, new SFBlockstateProvider(output, helper));
        generator.addProvider(client, new SFItemModelProvider(output, helper));
        generator.addProvider(client, new SFLanguageProvider(output));
        generator.addProvider(client, new SFSoundDefinitionsProvider(output, helper));
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
