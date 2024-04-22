package com.peeko32213.seafarer.common.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class SFFood {
    //Raw
    public static final FoodProperties RAW_SHORE_CRAB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties RAW_HORSESHOE_CRAB = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.HEAL, 600, 3), 0.3F).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).fast().build();
    public static final FoodProperties RAW_MARINE_IGUANA = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().build();

    //Cooked Basic
    public static final FoodProperties COOKED_SHORE_CRAB = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).meat().build();
    public static final FoodProperties COOKED_HORSESHOE_CRAB = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).meat().build();
    public static final FoodProperties COOKED_MARINE_IGUANA = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();

    //Condiment
    public static final FoodProperties SOY_SAUCE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0).build();

}
