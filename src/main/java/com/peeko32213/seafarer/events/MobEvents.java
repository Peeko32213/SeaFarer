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
        event.put(SeafarerEntities.BARRELEYE.get(), Barreleye.createAttributes().build());

//        event.put(SeafarerEntities.SUNFISH.get(), SunfishEntity.createAttributes().build());
//        event.put(SeafarerEntities.CRAB.get(), CrabEntity.createAttributes().build());
//        event.put(SeafarerEntities.HORSESHOE_CRAB.get(), HorseshoeCrabEntity.createAttributes().build());
//        event.put(SeafarerEntities.MARINE_IGUANA.get(), MarineIguanaEntity.createAttributes().build());
//        event.put(SeafarerEntities.GARDEN_EEL.get(), GardenEelEntity.createAttributes().build());
//        event.put(SeafarerEntities.MANDARIN_GOBY.get(), MandarinGobyEntity.createAttributes().build());
//        event.put(SeafarerEntities.SEXY_SHRIMP.get(), SexyShrimpEntity.createAttributes().build());
//        event.put(SeafarerEntities.FROG_FISH.get(), FrogfishEntity.createAttributes().build());
//        event.put(SeafarerEntities.BLUE_TANG.get(), BlueTang.createAttributes().build());
//        event.put(SeafarerEntities.COPPERBAND_BUTTERFLY.get(), CopperbandButterflyfishEntity.createAttributes().build());
//        event.put(SeafarerEntities.MANTIS_SHRIMP.get(), MantisShrimpEntity.createAttributes().build());
//        event.put(SeafarerEntities.MANTA_RAY.get(), MantaRayEntity.createAttributes().build());
//        event.put(SeafarerEntities.PARROTFISH.get(), ParrotfishEntity.createAttributes().build());
//        event.put(SeafarerEntities.FILEFISH.get(), FilefishEntity.createAttributes().build());
//        event.put(SeafarerEntities.LEAFY_SCORPIONFISH.get(), LeafyScorpionFishEntity.createAttributes().build());
//        event.put(SeafarerEntities.ZEBRA_SHARK.get(), ZebraSharkEntity.createAttributes().build());
//        event.put(SeafarerEntities.CHIMAERA.get(), Chimaera.createAttributes().build());
//        event.put(SeafarerEntities.SPIDER_CRAB.get(), SpiderCrabEntity.createAttributes().build());
//        event.put(SeafarerEntities.SQUIRRELFISH.get(), SquirrelfishEntity.createAttributes().build());
    }

}
