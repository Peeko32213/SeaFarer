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

          event.put(SeafarerEntities.CRAB.get(), Crab.createAttributes().build());
          event.put(SeafarerEntities.HORSESHOE_CRAB.get(), HorseshoeCrab.createAttributes().build());
          event.put(SeafarerEntities.MANTA_RAY.get(), MantaRay.createAttributes().build());
          event.put(SeafarerEntities.SUNFISH.get(), Sunfish.createAttributes().build());
        event.put(SeafarerEntities.SARDINE.get(), Sardine.createAttributes().build());
        event.put(SeafarerEntities.SCALLOP.get(), Scallop.createAttributes().build());
        event.put(SeafarerEntities.FLOUNDER.get(), Flounder.createAttributes().build());
        event.put(SeafarerEntities.MAHI_MAHI.get(), MahiMahi.createAttributes().build());
        event.put(SeafarerEntities.SHARK.get(), Shark.createAttributes().build());
        event.put(SeafarerEntities.SEA_CUCMBER.get(), SeaCucumber.createAttributes().build());
        event.put(SeafarerEntities.MAN_O_WAR.get(), ManOWar.createAttributes().build());
        event.put(SeafarerEntities.THRESHER_SHARK.get(), ThresherShark.createAttributes().build());
        event.put(SeafarerEntities.TUNA.get(), Tuna.createAttributes().build());
        event.put(SeafarerEntities.BOWHEAD_WHALE.get(), BowheadWhale.createAttributes().build());
        event.put(SeafarerEntities.SAILFISH.get(), Sailfish.createAttributes().build());
        event.put(SeafarerEntities.LEAFY_SEA_DRAGON.get(), LeafySeaDragon.createAttributes().build());
        event.put(SeafarerEntities.WHALE_SHARK.get(), WhaleShark.createAttributes().build());

    }

}
