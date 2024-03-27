package com.peeko32213.seafarer.common.world;

import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
@SuppressWarnings("unused")
public class BeachPlantsGeneration {

    // Those are unused, but kept for reference just in case
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_BEACHGRASS = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SeaFarer.MODID, "beachgrass"));
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_SEA_THRIFT = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SeaFarer.MODID, "sea_thrift"));
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_SEA_HOLLY = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SeaFarer.MODID, "sea_holly"));
    
    public static ResourceKey<PlacedFeature> BEACHGRASS = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SeaFarer.MODID, "beachgrass"));
    public static ResourceKey<PlacedFeature> SEA_THRIFT = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SeaFarer.MODID, "sea_thrift"));
    public static ResourceKey<PlacedFeature> SEA_HOLLY = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SeaFarer.MODID, "sea_holly"));

    public static void load() {
    }
}
