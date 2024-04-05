package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.common.entity.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class SFEntityPlacement {

    public  static void entityPlacement() {
        //SpawnPlacements.register(UPEntities.STETHACANTHUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityStethacanthus::checkSurfaceWaterDinoSpawnRules);
        //SpawnPlacements.register(UPEntities.BEELZ.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityBaseDinosaurAnimal::checkSurfaceDinoSpawnRules);
        SpawnPlacements.register(SFEntities.CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityCrab::checkCrabSpawnRules);
        SpawnPlacements.register(SFEntities.HORSESHOE_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityHorseshoeCrab::checkHorseshoeCrabSpawnRules);
        SpawnPlacements.register(SFEntities.MARINE_IGUANA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityMarineIguana::checkMarineIguanaSpawnRules);
        SpawnPlacements.register(SFEntities.SUNFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntitySunfish::checkSunfishSpawnRules);
        SpawnPlacements.register(SFEntities.SQUIRRELFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntitySquirrelfish::checkSquirrelfishSpawnRules);

    }

    public static boolean rollSpawn(int rolls, RandomSource random, MobSpawnType reason){
        if(reason == MobSpawnType.SPAWNER){
            return true;
        }else{
            return rolls <= 0 || random.nextInt(rolls) == 0;
        }
    }
}
