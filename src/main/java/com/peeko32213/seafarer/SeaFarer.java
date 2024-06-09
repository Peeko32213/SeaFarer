package com.peeko32213.seafarer;

import com.peeko32213.seafarer.client.event.ClientEvents;
import com.peeko32213.seafarer.core.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        });
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }

}
