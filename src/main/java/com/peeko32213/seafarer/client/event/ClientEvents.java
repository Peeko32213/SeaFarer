package com.peeko32213.seafarer.client.event;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.client.SFItemProperties;
import com.peeko32213.seafarer.client.block.FishingNetEntityRenderer;
import com.peeko32213.seafarer.client.model.*;
import com.peeko32213.seafarer.client.render.FrogFishEntityRenderer;
import com.peeko32213.seafarer.client.render.GardenEelRenderer;
import com.peeko32213.seafarer.client.render.LivingEntityRenderer;
import com.peeko32213.seafarer.client.render.MantaRayEntityRenderer;
import com.peeko32213.seafarer.core.registry.SFBlockEntities;
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
        event.enqueueWork(SFItemProperties::addItemProperties);
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

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_BUST_BLUE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_BUST_BROWN.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_CURVY_LIME.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_CURVY_ORANGE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_FISHBOWL_PURPLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_FISHBOWL_WHITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_PIPE_PINK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_PIPE_YELLOW.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_THIN_GREEN.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAGLASS_BOTTLE_THIN_RED.get(), RenderType.translucent());


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
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.COASTAL_WILDFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.COASTAL_LAVENDER.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_AMBER_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AMBER_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AMBER_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AMBER_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_AMBER_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_AMBER_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_CERULEAN_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CERULEAN_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CERULEAN_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CERULEAN_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_CERULEAN_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_CERULEAN_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_MAROON_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.MAROON_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.MAROON_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.MAROON_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_MAROON_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_MAROON_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_OLIVE_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.OLIVE_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.OLIVE_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.OLIVE_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_OLIVE_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_OLIVE_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_TURQUOISE_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.TURQUOISE_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.TURQUOISE_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.TURQUOISE_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_TURQUOISE_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_TURQUOISE_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_VERDANT_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.VERDANT_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.VERDANT_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.VERDANT_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_VERDANT_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.DEAD_VERDANT_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CYAN_ZOA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ORANGE_ZOA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.RED_ZOA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PURPLE_ZOA.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ANTLER_GORGONIAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.TOWERING_GORGONIAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BLUE_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BLACK_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.RED_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.YELLOW_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.WHITE_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEA_GRAPES_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.WAKAME.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.WAKAME_PLANT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEA_URCHIN.get(), RenderType.cutout());

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SFEntities.SUNFISH.get(), e -> new LivingEntityRenderer<>(e, new ModelSunfish()));
        event.registerEntityRenderer(SFEntities.CRAB.get(), e -> new LivingEntityRenderer<>(e, new ModelCrab()));
        event.registerEntityRenderer(SFEntities.HORSESHOE_CRAB.get(), e -> new LivingEntityRenderer<>(e, new ModelHorseshoeCrab()));
        event.registerEntityRenderer(SFEntities.MARINE_IGUANA.get(), e -> new LivingEntityRenderer<>(e, new ModelMarineIguana()));
        event.registerBlockEntityRenderer(SFBlockEntities.NET_BLOCK_ENTITY.get(), FishingNetEntityRenderer::new);
        event.registerEntityRenderer(SFEntities.GARDEN_EEL.get(), GardenEelRenderer::new);
        event.registerEntityRenderer(SFEntities.MANDARIN_GOBY.get(), e -> new LivingEntityRenderer<>(e, new ModelMandarinGoby()));
        event.registerEntityRenderer(SFEntities.SEXY_SHRIMP.get(), e -> new LivingEntityRenderer<>(e, new ModelSexyShrimp()));
        event.registerEntityRenderer(SFEntities.FROG_FISH.get(), e -> new FrogFishEntityRenderer<>(e, new ModelFrogFish()));
        event.registerEntityRenderer(SFEntities.BLUE_TANG.get(), e -> new LivingEntityRenderer<>(e, new ModelBlueTang()));
        event.registerEntityRenderer(SFEntities.COPPERBAND_BUTTERFLY.get(), e -> new LivingEntityRenderer<>(e, new ModelCopperbandButterfly()));
        event.registerEntityRenderer(SFEntities.MANTIS_SHRIMP.get(), e -> new LivingEntityRenderer<>(e, new ModelMantisShrimp()));
        event.registerEntityRenderer(SFEntities.MANTA_RAY.get(), e -> new MantaRayEntityRenderer<>(e, new ModelMantaRay()));
        event.registerEntityRenderer(SFEntities.PARROTFISH.get(), e -> new LivingEntityRenderer<>(e, new ModelParrotfish()));

    }

}
