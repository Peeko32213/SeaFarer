package com.peeko32213.seafarer.events;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.*;
import com.peeko32213.seafarer.registry.SeafarerItemProperties;
import com.peeko32213.seafarer.client.renderer.*;
import com.peeko32213.seafarer.registry.SeafarerEntities;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
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
        event.enqueueWork(SeafarerItemProperties::addItemProperties);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SeafarerEntities.CRAB.get(), CrabRenderer::new);
        event.registerEntityRenderer(SeafarerEntities.HORSESHOE_CRAB.get(), HorseshoeCrabRenderer::new);
        event.registerEntityRenderer(SeafarerEntities.MANTA_RAY.get(), MantaRayRenderer::new);
        event.registerEntityRenderer(SeafarerEntities.SUNFISH.get(), SunfishRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SeafarerModelLayers.CRAB, CrabModel::createBodyLayer);
        event.registerLayerDefinition(SeafarerModelLayers.HORSESHOE_CRAB, HorseshoeCrabModel::createBodyLayer);
        event.registerLayerDefinition(SeafarerModelLayers.MANTA_RAY, MantaRayModel::createBodyLayer);
        event.registerLayerDefinition(SeafarerModelLayers.SUNFISH, SunfishModel::createBodyLayer);
    }
}
