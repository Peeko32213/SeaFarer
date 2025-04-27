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
        event.put(SFEntities.SUNFISH.get(), EntitySunfish.createAttributes().build());
        event.put(SFEntities.CRAB.get(), EntityCrab.createAttributes().build());
        event.put(SFEntities.HORSESHOE_CRAB.get(), EntityHorseshoeCrab.createAttributes().build());
        event.put(SFEntities.MARINE_IGUANA.get(), EntityMarineIguana.createAttributes().build());
        event.put(SFEntities.GARDEN_EEL.get(), EntityGardenEel.createAttributes().build());
        event.put(SFEntities.MANDARIN_GOBY.get(), EntityMandarinGoby.createAttributes().build());
        event.put(SFEntities.SEXY_SHRIMP.get(), EntitySexyShrimp.createAttributes().build());
        event.put(SFEntities.FROG_FISH.get(), EntityFrogfish.createAttributes().build());
        event.put(SFEntities.BLUE_TANG.get(), EntityBlueTang.createAttributes());
        event.put(SFEntities.COPPERBAND_BUTTERFLY.get(), EntityCopperbandButterfly.createAttributes());
        event.put(SFEntities.MANTIS_SHRIMP.get(), EntityMantisShrimp.createAttributes().build());
        event.put(SFEntities.MANTA_RAY.get(), EntityMantaRay.createAttributes().build());
        event.put(SFEntities.PARROTFISH.get(), EntityParrotfish.createAttributes());
        event.put(SFEntities.FILEFISH.get(), EntityFileFish.createAttributes().build());
        event.put(SFEntities.LEAFY_SCORPIONFISH.get(), EntityLeafyScorpionFish.createAttributes().build());
        event.put(SFEntities.ZEBRA_SHARK.get(), EntityFileFish.createAttributes().build());
        event.put(SFEntities.CHIMAERA.get(), EntityChimaera.createAttributes().build());
        event.put(SFEntities.SPIDER_CRAB.get(), EntitySpiderCrab.createAttributes().build());
        event.put(SFEntities.BARRELEYE.get(), EntityBarreleye.createAttributes().build());

    }

}
