package com.peeko32213.seafarer.common.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class SFFood {
    // Raw
    public static final FoodProperties RAW_SHORE_CRAB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties RAW_HORSESHOE_CRAB = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.HEAL, 600, 3), 0.3F).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).fast().build();
    public static final FoodProperties RAW_MARINE_IGUANA = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().build();
    public static final FoodProperties RAW_SQUIRRELFISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties RAW_BLUE_TANG = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties RAW_COPPERBAND_BUTTERFLYFISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties RAW_FROGFISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties RAW_GARDEN_EEL = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties RAW_MANDARINFISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();
    public static final FoodProperties RAW_SEXY_SHRIMP = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().fast().build();

    // Salted
    public static final FoodProperties SALT = (new FoodProperties.Builder()).nutrition(0).saturationMod(1.0F).meat().fast().build();

    public static final FoodProperties SALTED_COD = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.2F).meat().fast().build();

    public static final FoodProperties SALTED_SALMON = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.2F).meat().fast().build();

    public static final FoodProperties SALTED_TROPICAL_FISH = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.2F).meat().fast().build();

    public static final FoodProperties SALTED_STARFISH = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().build();

    // Cooked
    public static final FoodProperties COOKED_SHORE_CRAB = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).meat().build();
    public static final FoodProperties COOKED_HORSESHOE_CRAB = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).meat().build();
    public static final FoodProperties COOKED_MARINE_IGUANA = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();
    public static final FoodProperties COOKED_SQUIRRELFISH = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();
    public static final FoodProperties COOKED_BLUE_TANG = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();
    public static final FoodProperties COOKED_COPPERBAND_BUTTERFLYFISH = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();
    public static final FoodProperties COOKED_FROGFISH = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();
    public static final FoodProperties COOKED_GARDEN_EEL = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();
    public static final FoodProperties COOKED_MANDARINFISH = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();
    public static final FoodProperties COOKED_SEXY_SHRIMP = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).meat().build();

    public static final FoodProperties COOKED_STARFISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().build();

    // Condiment
    public static final FoodProperties SOY_SAUCE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0).build();

}
