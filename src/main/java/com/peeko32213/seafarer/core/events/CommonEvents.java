package com.peeko32213.seafarer.core.events;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.*;
import com.peeko32213.seafarer.core.registry.SFEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SeaFarer.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SFEntities.SUNFISH.get(), SunfishEntity.createAttributes().build());
        event.put(SFEntities.CRAB.get(), CrabEntity.createAttributes().build());
        event.put(SFEntities.HORSESHOE_CRAB.get(), HorseshoeCrabEntity.createAttributes().build());
        event.put(SFEntities.MARINE_IGUANA.get(), MarineIguanaEntity.createAttributes().build());
        event.put(SFEntities.GARDEN_EEL.get(), GardenEelEntity.createAttributes().build());
        event.put(SFEntities.MANDARIN_GOBY.get(), MandarinGobyEntity.createAttributes().build());
        event.put(SFEntities.SEXY_SHRIMP.get(), SexyShrimpEntity.createAttributes().build());
        event.put(SFEntities.FROG_FISH.get(), FrogfishEntity.createAttributes().build());
        event.put(SFEntities.BLUE_TANG.get(), BlueTangEntity.createAttributes().build());
        event.put(SFEntities.COPPERBAND_BUTTERFLY.get(), CopperbandButterflyfishEntity.createAttributes().build());
        event.put(SFEntities.MANTIS_SHRIMP.get(), MantisShrimpEntity.createAttributes().build());
        event.put(SFEntities.MANTA_RAY.get(), MantaRayEntity.createAttributes().build());
        event.put(SFEntities.PARROTFISH.get(), ParrotfishEntity.createAttributes().build());
        event.put(SFEntities.FILEFISH.get(), FilefishEntity.createAttributes().build());
        event.put(SFEntities.LEAFY_SCORPIONFISH.get(), LeafyScorpionFishEntity.createAttributes().build());
        event.put(SFEntities.ZEBRA_SHARK.get(), ZebraSharkEntity.createAttributes().build());
        event.put(SFEntities.CHIMAERA.get(), ChimaeraEntity.createAttributes().build());
        event.put(SFEntities.SPIDER_CRAB.get(), SpiderCrabEntity.createAttributes().build());
        event.put(SFEntities.BARRELEYE.get(), BarreleyeEntity.createAttributes().build());
        event.put(SFEntities.SQUIRRELFISH.get(), SquirrelfishEntity.createAttributes().build());
    }

}
