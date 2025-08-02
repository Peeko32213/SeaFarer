package com.peeko32213.seafarer.events;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeafarerItemProperties;
import com.peeko32213.seafarer.client.renderer.*;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import com.peeko32213.seafarer.registry.SeafarerEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(SeafarerItemProperties::addItemProperties);
    }

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AZURE_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.UMBER_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SEAFOAM_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AMBER_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.LILAC_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SCARLET_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CITRINE_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.ROSE_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CHARTREUSE_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PEARLY_SEA_GLASS.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AZURE_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.UMBER_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SEAFOAM_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AMBER_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.LILAC_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SCARLET_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CITRINE_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.ROSE_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CHARTREUSE_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PEARLY_SEA_GLASS_PANE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AZURE_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.UMBER_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SEAFOAM_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AMBER_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.LILAC_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SCARLET_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CITRINE_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PEARLY_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.ROSE_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CHARTREUSE_SEA_GLASS_PEBBLES.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.COMMON_ORANGE_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PINK_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.RED_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CHOCOLATE_CHIP_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.BLUE_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PURPLE_OCHRE_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.OCHRE_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.ROYAL_STARFISH.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AZURE_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.UMBER_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AMBER_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.LILAC_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PEARLY_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.ROSE_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CITRINE_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SEAFOAM_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SCARLET_SEA_GLASS_BOTTLE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CLAM_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.HORN_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SPIKY_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SPIRAL_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SWIRL_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PYRAMID_SHELL.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.FISHING_NET.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.ALGAE_PLANT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SEA_HOLLY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SEA_THRIFT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.BEACHGRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.BEACHGRASS_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.COASTAL_WILDFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.COASTAL_LAVENDER.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_AMBER_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AMBER_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AMBER_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.AMBER_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_AMBER_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_AMBER_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_CERULEAN_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CERULEAN_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CERULEAN_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CERULEAN_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_CERULEAN_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_CERULEAN_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_MAROON_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.MAROON_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.MAROON_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.MAROON_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_MAROON_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_MAROON_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_OLIVE_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.OLIVE_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.OLIVE_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.OLIVE_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_OLIVE_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_OLIVE_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_TURQUOISE_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.TURQUOISE_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.TURQUOISE_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.TURQUOISE_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_TURQUOISE_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_TURQUOISE_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_VERDANT_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.VERDANT_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.VERDANT_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.VERDANT_CORAL_WALL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_VERDANT_CORAL_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.DEAD_VERDANT_CORAL_WALL_FAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.CYAN_ZOA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.ORANGE_ZOA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.RED_ZOA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PURPLE_ZOA.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.ANTLER_GORGONIAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.TOWERING_GORGONIAN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.BLUE_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.BLACK_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.RED_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.YELLOW_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.WHITE_CHRISTMAS_TREE_WORM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.SEA_GRAPES_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.WAKAME.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.WAKAME_PLANT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.GHOUL_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.PALE_SPONGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SeafarerBlocks.TUBE_WORMS.get(), RenderType.cutout());

    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SeafarerEntities.CRAB.get(), CrabRenderer::new);
        event.registerEntityRenderer(SeafarerEntities.HORSESHOE_CRAB.get(), HorseshoeCrabRenderer::new);
        event.registerEntityRenderer(SeafarerEntities.MANTA_RAY.get(), MantaRayRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
    }
}
