package com.peeko32213.seafarer.events;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.*;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.SeaEntities;
import com.peeko32213.seafarer.registry.SeaItemProperties;
import com.peeko32213.seafarer.client.renderer.*;
import com.peeko32213.seafarer.registry.SeaModelLayers;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(SeaItemProperties::addItemProperties);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, world, pos, tintIndex) -> {
                    if (world == null || pos == null) {
                        return FoliageColor.getDefaultColor();
                    }
                    return BiomeColors.getAverageFoliageColor(world, pos);
                },
                SeaBlocks.WHITE_FLOWERING_JUNGLE_LEAVES.get(),
                SeaBlocks.ORANGE_FLOWERING_JUNGLE_LEAVES.get(),
                SeaBlocks.YELLOW_FLOWERING_JUNGLE_LEAVES.get(),
                SeaBlocks.BLUE_FLOWERING_JUNGLE_LEAVES.get(),
                SeaBlocks.MAGENTA_FLOWERING_JUNGLE_LEAVES.get()
        );
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
                    BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                    return event.getBlockColors().getColor(blockstate, null, null, tintIndex);
                },
                SeaBlocks.WHITE_FLOWERING_JUNGLE_LEAVES.get(),
                SeaBlocks.ORANGE_FLOWERING_JUNGLE_LEAVES.get(),
                SeaBlocks.YELLOW_FLOWERING_JUNGLE_LEAVES.get(),
                SeaBlocks.BLUE_FLOWERING_JUNGLE_LEAVES.get(),
                SeaBlocks.MAGENTA_FLOWERING_JUNGLE_LEAVES.get()
        );
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SeaEntities.HORSESHOE_CRAB.get(), HorseshoeCrabRenderer::new);
        event.registerEntityRenderer(SeaEntities.MANTA_RAY.get(), MantaRayRenderer::new);
        event.registerEntityRenderer(SeaEntities.SHORE_CRAB.get(), ShoreCrabRenderer::new);
        event.registerEntityRenderer(SeaEntities.SUNFISH.get(), SunfishRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SeaModelLayers.HORSESHOE_CRAB, HorseshoeCrabModel::createBodyLayer);
        event.registerLayerDefinition(SeaModelLayers.MANTA_RAY, MantaRayModel::createBodyLayer);
        event.registerLayerDefinition(SeaModelLayers.SHORE_CRAB, ShoreCrabModel::createBodyLayer);
        event.registerLayerDefinition(SeaModelLayers.SUNFISH, SunfishModel::createBodyLayer);
    }
}
