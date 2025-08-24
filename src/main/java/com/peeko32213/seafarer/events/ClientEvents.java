package com.peeko32213.seafarer.events;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.*;
import com.peeko32213.seafarer.registry.SFEntities;
import com.peeko32213.seafarer.registry.SFItemProperties;
import com.peeko32213.seafarer.client.renderer.*;
import com.peeko32213.seafarer.registry.SFEntityModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(SFItemProperties::addItemProperties);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SFEntities.HORSESHOE_CRAB.get(), HorseshoeCrabRenderer::new);
        event.registerEntityRenderer(SFEntities.MANTA_RAY.get(), MantaRayRenderer::new);
        event.registerEntityRenderer(SFEntities.SHORE_CRAB.get(), ShoreCrabRenderer::new);
        event.registerEntityRenderer(SFEntities.SUNFISH.get(), SunfishRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SFEntityModelLayers.HORSESHOE_CRAB, HorseshoeCrabModel::createBodyLayer);
        event.registerLayerDefinition(SFEntityModelLayers.MANTA_RAY, MantaRayModel::createBodyLayer);
        event.registerLayerDefinition(SFEntityModelLayers.SHORE_CRAB, ShoreCrabModel::createBodyLayer);
        event.registerLayerDefinition(SFEntityModelLayers.SUNFISH, SunfishModel::createBodyLayer);
    }
}
