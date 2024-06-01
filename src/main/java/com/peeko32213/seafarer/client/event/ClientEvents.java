package com.peeko32213.seafarer.client.event;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.client.model.*;
import com.peeko32213.seafarer.client.render.LivingEntityRenderer;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SeaFarer.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    public static void init(FMLClientSetupEvent event) {
    }
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BLUE_SEAGLASS_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BROWN_SEAGLASS_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.GREEN_SEAGLASS_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ORANGE_SEAGLASS_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PURPLE_SEAGLASS_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.RED_SEAGLASS_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.YELLOW_SEAGLASS_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PINK_SEAGLASS_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.LIME_SEAGLASS_BLOCK.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BLUE_SEAGLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BROWN_SEAGLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.GREEN_SEAGLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ORANGE_SEAGLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PURPLE_SEAGLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.RED_SEAGLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.YELLOW_SEAGLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PINK_SEAGLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.LIME_SEAGLASS_PANE.get(), RenderType.translucent());


        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BLUE_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BROWN_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.GREEN_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ORANGE_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PURPLE_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.RED_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.YELLOW_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.WHITE_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PINK_SEAGLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.LIME_SEAGLASS_PEBBLES.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.STARFISH_COMMON_ORANGE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.STARFISH_PINK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.STARFISH_RED.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.STARFISH_CHOCOLATE_CHIP.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.STARFISH_BIG_BLUE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.STARFISH_BIG_PURPLE_OCHRE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.STARFISH_BIG_OCHRE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.STARFISH_BIG_ROYAL.get(), RenderType.translucent());



        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CLAM_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.HORN_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SPIKY_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SPIRAL_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SWIRL_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PYRAMID_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PLANK_BLOCK.get(), RenderType.cutout());


        ItemBlockRenderTypes.setRenderLayer(SFBlocks.FISHING_NET.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ALGAE_PLANT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEA_HOLLY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEA_THRIFT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BEACHGRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BEACHGRASS_FAN.get(), RenderType.cutout());


    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SFEntities.SUNFISH.get(), e -> new LivingEntityRenderer<>(e, new ModelSunfish()));
        event.registerEntityRenderer(SFEntities.CRAB.get(), e -> new LivingEntityRenderer<>(e, new ModelCrab()));
        event.registerEntityRenderer(SFEntities.HORSESHOE_CRAB.get(), e -> new LivingEntityRenderer<>(e, new ModelHorseshoeCrab()));
        event.registerEntityRenderer(SFEntities.MARINE_IGUANA.get(), e -> new LivingEntityRenderer<>(e, new ModelMarineIguana()));
    }

}
