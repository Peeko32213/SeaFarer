package com.peeko32213.seafarer.client.event;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.client.SFItemProperties;
import com.peeko32213.seafarer.client.block.FishingNetEntityRenderer;
import com.peeko32213.seafarer.client.model.*;
import com.peeko32213.seafarer.client.render.*;
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
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AZURE_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.UMBER_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAFOAM_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AMBER_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.LILAC_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SCARLET_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CITRINE_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ROSE_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CHARTREUSE_SEA_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PEARLY_SEA_GLASS.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AZURE_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.UMBER_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAFOAM_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AMBER_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.LILAC_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SCARLET_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CITRINE_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ROSE_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CHARTREUSE_SEA_GLASS_PANE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PEARLY_SEA_GLASS_PANE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AZURE_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.UMBER_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAFOAM_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AMBER_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.LILAC_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SCARLET_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CITRINE_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PEARLY_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ROSE_SEA_GLASS_PEBBLES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CHARTREUSE_SEA_GLASS_PEBBLES.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.COMMON_ORANGE_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PINK_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.RED_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CHOCOLATE_CHIP_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.BLUE_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PURPLE_OCHRE_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.OCHRE_STARFISH.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ROYAL_STARFISH.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AZURE_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.UMBER_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CHARTREUSE_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.AMBER_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.LILAC_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PEARLY_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.ROSE_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CITRINE_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SEAFOAM_SEA_GLASS_BOTTLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SCARLET_SEA_GLASS_BOTTLE.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.CLAM_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.HORN_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SPIKY_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SPIRAL_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.SWIRL_SHELL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PYRAMID_SHELL.get(), RenderType.cutout());

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

        ItemBlockRenderTypes.setRenderLayer(SFBlocks.GHOUL_CORAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.PALE_SPONGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SFBlocks.TUBE_WORMS.get(), RenderType.cutout());

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SFEntities.SUNFISH.get(), SunfishRenderer::new);
        event.registerEntityRenderer(SFEntities.CRAB.get(), e -> new LivingEntityRenderer<>(e, new CrabModel()));
        event.registerEntityRenderer(SFEntities.HORSESHOE_CRAB.get(), e -> new LivingEntityRenderer<>(e, new HorseshoeCrabModel()));
        event.registerEntityRenderer(SFEntities.MARINE_IGUANA.get(), e -> new LivingEntityRenderer<>(e, new MarineIguanaModel()));
        event.registerBlockEntityRenderer(SFBlockEntities.NET_BLOCK_ENTITY.get(), FishingNetEntityRenderer::new);
        event.registerEntityRenderer(SFEntities.GARDEN_EEL.get(), GardenEelRenderer::new);
        event.registerEntityRenderer(SFEntities.MANDARIN_GOBY.get(), e -> new LivingEntityRenderer<>(e, new MandarinGobyModel()));
        event.registerEntityRenderer(SFEntities.SEXY_SHRIMP.get(), e -> new LivingEntityRenderer<>(e, new SexyShrimpModel()));
        event.registerEntityRenderer(SFEntities.FROG_FISH.get(), e -> new FrogFishRenderer<>(e, new FrogFishModel()));
        event.registerEntityRenderer(SFEntities.BLUE_TANG.get(), e -> new LivingEntityRenderer<>(e, new BlueTangModel()));
        event.registerEntityRenderer(SFEntities.COPPERBAND_BUTTERFLY.get(), e -> new LivingEntityRenderer<>(e, new CopperbandButterflyfishModel()));
        event.registerEntityRenderer(SFEntities.MANTIS_SHRIMP.get(), e -> new LivingEntityRenderer<>(e, new MantisShrimpModel()));
        event.registerEntityRenderer(SFEntities.MANTA_RAY.get(), MantaRayRenderer::new);
        event.registerEntityRenderer(SFEntities.PARROTFISH.get(), e -> new LivingEntityRenderer<>(e, new ParrotfishModel()));
        event.registerEntityRenderer(SFEntities.FILEFISH.get(), e -> new LivingEntityRenderer<>(e, new FilefishModel()));
        event.registerEntityRenderer(SFEntities.LEAFY_SCORPIONFISH.get(), e -> new LivingEntityRenderer<>(e, new LeafyScorpionfishModel()));
        event.registerEntityRenderer(SFEntities.ZEBRA_SHARK.get(), e -> new LivingEntityRenderer<>(e, new ZebraSharkModel()));
        event.registerEntityRenderer(SFEntities.CHIMAERA.get(), e -> new LivingEntityRenderer<>(e, new ChimaeraModel()));
        event.registerEntityRenderer(SFEntities.SPIDER_CRAB.get(), e -> new LivingEntityRenderer<>(e, new SpiderCrabModel()));
        event.registerEntityRenderer(SFEntities.BARRELEYE.get(), e -> new BarreleyeRenderer<>(e, new BarreleyeModel()));
        event.registerEntityRenderer(SFEntities.SQUIRRELFISH.get(), e -> new LivingEntityRenderer<>(e, new SquirrelfishModel()));
    }

}
