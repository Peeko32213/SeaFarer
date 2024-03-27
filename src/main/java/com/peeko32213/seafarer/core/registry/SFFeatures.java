package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.world.configuration.BeachPlantsConfiguration;
import com.peeko32213.seafarer.common.world.feature.BeachPlantsFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SeaFarer.MODID);
    public static final RegistryObject<Feature<BeachPlantsConfiguration>> BEACH_PLANTS = FEATURES.register("beach_plants", () -> new BeachPlantsFeature(BeachPlantsConfiguration.CODEC));

}
