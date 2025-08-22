package com.peeko32213.seafarer.events;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.entities.*;
import com.peeko32213.seafarer.registry.SeafarerEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SeafarerEntities.SHORE_CRAB.get(), ShoreCrab.createAttributes().build());
        event.put(SeafarerEntities.HORSESHOE_CRAB.get(), HorseshoeCrab.createAttributes().build());
        event.put(SeafarerEntities.MANTA_RAY.get(), MantaRay.createAttributes().build());
        event.put(SeafarerEntities.PARROTFISH.get(), Parrotfish.createAttributes().build());
        event.put(SeafarerEntities.SUNFISH.get(), Sunfish.createAttributes().build());
    }
}
