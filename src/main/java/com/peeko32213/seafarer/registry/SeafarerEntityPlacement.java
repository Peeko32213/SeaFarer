package com.peeko32213.seafarer.registry;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;

public class SeafarerEntityPlacement {

    public  static void entityPlacement() {
    }

    public static boolean rollSpawn(int rolls, RandomSource random, MobSpawnType reason){
        if(reason == MobSpawnType.SPAWNER){
            return true;
        }else{
            return rolls <= 0 || random.nextInt(rolls) == 0;
        }
    }
}
