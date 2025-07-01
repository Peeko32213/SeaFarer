package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.entities.CrabEntity;
import com.peeko32213.seafarer.entities.HorseshoeCrabEntity;
import com.peeko32213.seafarer.entities.MarineIguanaEntity;
import com.peeko32213.seafarer.entities.SunfishEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class SeafarerEntityPlacement {

    public  static void entityPlacement() {
        //SpawnPlacements.register(UPEntities.STETHACANTHUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityStethacanthus::checkSurfaceWaterDinoSpawnRules);
        //SpawnPlacements.register(UPEntities.BEELZ.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityBaseDinosaurAnimal::checkSurfaceDinoSpawnRules);
        SpawnPlacements.register(SeafarerEntities.CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrabEntity::checkCrabSpawnRules);
        SpawnPlacements.register(SeafarerEntities.HORSESHOE_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HorseshoeCrabEntity::checkHorseshoeCrabSpawnRules);
        SpawnPlacements.register(SeafarerEntities.MARINE_IGUANA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MarineIguanaEntity::checkMarineIguanaSpawnRules);
        SpawnPlacements.register(SeafarerEntities.SUNFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SunfishEntity::checkSunfishSpawnRules);
    }

    public static boolean rollSpawn(int rolls, RandomSource random, MobSpawnType reason){
        if(reason == MobSpawnType.SPAWNER){
            return true;
        }else{
            return rolls <= 0 || random.nextInt(rolls) == 0;
        }
    }
}
