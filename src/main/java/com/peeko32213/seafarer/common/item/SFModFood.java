package com.peeko32213.seafarer.common.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class SFModFood {
    //Raw
    public static final FoodProperties RAW_SQUIRRELFISH = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().fast().effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 1), 1.0F).build();
    public static final FoodProperties RAW_SHORE_CRAB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();


    //Cooked
    public static final FoodProperties COOKED_SQUIRRELFISH = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties COOKED_SHORE_CRAB = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).meat().build();

}
