package com.peeko32213.seafarer;

import com.peeko32213.seafarer.client.event.ClientEvents;
import com.peeko32213.seafarer.core.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

@Mod(SeaFarer.MODID)
public class SeaFarer {
        public static final String MODID = "seafarer";
        private static int packetsRegistered;
        public static final List<Runnable> CALLBACKS = new ArrayList<>();
        public static final Logger LOGGER = LogManager.getLogger();


    public SeaFarer()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(ClientEvents::init));

        SFBlocks.BLOCKS.register(modEventBus);
        SFItems.ITEMS.register(modEventBus);
        SFCreativeTabs.DEF_REG.register(modEventBus);
        SFEntities.ENTITIES.register(modEventBus);
        SFFeatures.FEATURES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
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
