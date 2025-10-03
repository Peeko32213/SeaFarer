package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.worldgen.feature.*;
import com.peeko32213.seafarer.worldgen.feature.config.LargeLakeFeatureConfig;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Seafarer.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GORGONIAN = FEATURES.register("gorgonian", () -> new GorgonianFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> STARFISH = FEATURES.register("starfish", () -> new StarfishFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<SimpleBlockConfiguration>> WATERLOGGABLE_SIMPLE_BLOCK = FEATURES.register("waterloggable_simple_block", () -> new WaterloggableSimpleBlockFeature(SimpleBlockConfiguration.CODEC));
    public static final RegistryObject<Feature<BlockStateConfiguration>> BOULDER = FEATURES.register("boulder", () -> new BoulderFeature(BlockStateConfiguration.CODEC));
    public static final RegistryObject<Feature<LargeLakeFeatureConfig>> LARGE_LAKE = FEATURES.register("large_lake", () -> new LargeLakeFeature(LargeLakeFeatureConfig.CODEC));

}
