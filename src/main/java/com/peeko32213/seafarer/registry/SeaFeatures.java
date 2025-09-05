package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.worldgen.feature.*;
import com.peeko32213.seafarer.worldgen.feature.corals.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeaFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Seafarer.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WARM_CORAL_TREE = FEATURES.register("warm_coral_tree", () -> new WarmCoralTreeFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WARM_CORAL_MUSHROOM = FEATURES.register("warm_coral_mushroom", () -> new WarmCoralMushroomFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WARM_CORAL_CLAW = FEATURES.register("warm_coral_claw", () -> new WarmCoralClawFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GORGONIAN = FEATURES.register("gorgonian", () -> new GorgonianFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<SimpleBlockConfiguration>> SEAFARER_SIMPLE_BLOCK = FEATURES.register("seafarer_simple_block", () -> new SeaSimpleBlockFeature(SimpleBlockConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> STARFISH = FEATURES.register("starfish", () -> new StarfishFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> BEACH_FLOWERS = FEATURES.register("beach_flowers", () -> new BeachFlowerFeature(NoneFeatureConfiguration.CODEC));

}
