package com.peeko32213.seafarer.events;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.entities.*;
import com.peeko32213.seafarer.registry.SeaEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobEvents {

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(SeaEntities.HORSESHOE_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HorseshoeCrab::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeaEntities.MAGMAW.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Magmaw::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeaEntities.MANTA_RAY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MantaRay::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeaEntities.SHORE_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShoreCrab::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeaEntities.SNAKE_MACKEREL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnakeMackerel::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeaEntities.SUNFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Sunfish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SeaEntities.HORSESHOE_CRAB.get(), HorseshoeCrab.createAttributes().build());
        event.put(SeaEntities.MAGMAW.get(), Magmaw.createAttributes().build());
        event.put(SeaEntities.MANTA_RAY.get(), MantaRay.createAttributes().build());
        event.put(SeaEntities.SHORE_CRAB.get(), ShoreCrab.createAttributes().build());
        event.put(SeaEntities.SNAKE_MACKEREL.get(), SnakeMackerel.createAttributes().build());
        event.put(SeaEntities.SUNFISH.get(), Sunfish.createAttributes().build());
    }
}
