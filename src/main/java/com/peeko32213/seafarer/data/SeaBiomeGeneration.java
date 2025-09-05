package com.peeko32213.seafarer.data;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class SeaBiomeGeneration {
    public static void warmReef(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addWaterTrees(generation);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        BiomeDefaultFeatures.addDefaultGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatureProvider.WARM_REEF_CORALS);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatureProvider.GORGONIANS);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatureProvider.WARM_REEF_STARFISH);
    }

    public static void floweringBeach(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addWaterTrees(generation);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        BiomeDefaultFeatures.addDefaultGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatureProvider.BEACH_STARFISH);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatureProvider.BEACH_FLOWERS);
    }
}
