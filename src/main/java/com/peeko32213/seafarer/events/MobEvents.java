package com.peeko32213.seafarer.events;


import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.entities.*;
import com.peeko32213.seafarer.entities.misc.unimplemented.*;
import com.peeko32213.seafarer.registry.SeafarerEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SeafarerEntities.BARRELEYE.get(), Barreleye.createAttributes().build());

//        event.put(SeafarerEntities.SUNFISH.get(), SunfishEntity.createAttributes().build());
          event.put(SeafarerEntities.CRAB.get(), Crab.createAttributes().build());
          event.put(SeafarerEntities.HORSESHOE_CRAB.get(), HorseshoeCrab.createAttributes().build());
//        event.put(SeafarerEntities.MARINE_IGUANA.get(), MarineIguanaEntity.createAttributes().build());
          event.put(SeafarerEntities.GARDEN_EEL.get(), GardenEel.createAttributes().build());
          event.put(SeafarerEntities.MANDARIN_GOBY.get(), MandarinGoby.createAttributes().build());
//        event.put(SeafarerEntities.SEXY_SHRIMP.get(), SexyShrimpEntity.createAttributes().build());
//        event.put(SeafarerEntities.FROG_FISH.get(), Frogfish.createAttributes().build());
//        event.put(SeafarerEntities.MANTIS_SHRIMP.get(), MantisShrimpEntity.createAttributes().build());
          event.put(SeafarerEntities.MANTA_RAY.get(), MantaRay.createAttributes().build());
//        event.put(SeafarerEntities.PARROTFISH.get(), ParrotfishEntity.createAttributes().build());
//       event.put(SeafarerEntities.FILEFISH.get(), Filefish.createAttributes().build());
//        event.put(SeafarerEntities.ZEBRA_SHARK.get(), ZebraSharkEntity.createAttributes().build());
//        event.put(SeafarerEntities.CHIMAERA.get(), Chimaera.createAttributes().build());
//        event.put(SeafarerEntities.SPIDER_CRAB.get(), SpiderCrabEntity.createAttributes().build());
//        event.put(SeafarerEntities.SQUIRRELFISH.get(), SquirrelfishEntity.createAttributes().build());
    }

}
