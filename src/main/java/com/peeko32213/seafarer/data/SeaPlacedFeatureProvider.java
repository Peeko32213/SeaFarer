package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class SeaPlacedFeatureProvider {

    public static final ResourceKey<PlacedFeature> GORGONIANS = createKey("gorgonians");
    public static final ResourceKey<PlacedFeature> WARM_REEF_STARFISH = createKey("warm_reef_starfish");
    public static final ResourceKey<PlacedFeature> WARM_REEF_CORALS = createKey("warm_reef_corals");
    public static final ResourceKey<PlacedFeature> BEACH_STARFISH = createKey("beach_starfish");
    public static final ResourceKey<PlacedFeature> BEACH_FLOWERS = createKey("beach_flowers");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        register(context, GORGONIANS, SeaConfiguredFeatureProvider.GORGONIANS, CountPlacement.of(UniformInt.of(1, 2)), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
        register(context, WARM_REEF_STARFISH, SeaConfiguredFeatureProvider.STARFISH, CountPlacement.of(UniformInt.of(1, 2)), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
        register(context, WARM_REEF_CORALS, AquaticFeatures.WARM_OCEAN_VEGETATION, CountPlacement.of(UniformInt.of(4, 8)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
        register(context, BEACH_STARFISH, SeaConfiguredFeatureProvider.STARFISH, CountPlacement.of(UniformInt.of(1, 2)), RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
        register(context, BEACH_FLOWERS, SeaConfiguredFeatureProvider.BEACH_FLOWERS, VegetationPlacements.worldSurfaceSquaredWithCount(20));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(feature), modifiers));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        register(context, key, feature, List.of(modifiers));
    }

    private static void createPlantPatch(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, int onceEvery, ResourceKey<ConfiguredFeature<?, ?>> feature) {
        register(context, key, feature, List.of(RarityFilter.onAverageOnceEvery(onceEvery), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    private static List<PlacementModifier> treePlacement(PlacementModifier modifier) {
        return List.of(modifier, InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
    }
}
