package com.peeko32213.seafarer.registry.worldgen;

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
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.WARM_REEF_CORALS);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.GORGONIANS);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.WARM_REEF_STARFISH);
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
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.BEACH_STARFISH);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.BEACH_FLOWERS);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.FLOWERING_BEACHGRASS);
    }

    public static void grassyBeach(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addWaterTrees(generation);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        BiomeDefaultFeatures.addDefaultGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.BEACH_STARFISH);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.GRASSY_BEACHGRASS);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.TALL_BEACHGRASS);
    }

    public static void coralBeach(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addWaterTrees(generation);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        BiomeDefaultFeatures.addDefaultGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.BEACH_STARFISH);
    }

    public static void volcanicBeach(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addWaterTrees(generation);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        BiomeDefaultFeatures.addDefaultGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.BEACH_STARFISH);
    }

    public static void volcanicIsland(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addJungleTrees(generation);
        BiomeDefaultFeatures.addWarmFlowers(generation);
        BiomeDefaultFeatures.addJungleGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        BiomeDefaultFeatures.addJungleVines(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.BEACH_STARFISH);
    }

    public static void glassBeach(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addWaterTrees(generation);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        BiomeDefaultFeatures.addDefaultGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.BEACH_STARFISH);
    }

    public static void kelpForest(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addWaterTrees(generation);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        BiomeDefaultFeatures.addDefaultGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, SeaPlacedFeatures.KELP_FOREST_KELP);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
    }

    public static void tropicalRiver(BiomeGenerationSettings.Builder generation) {
        OverworldBiomes.globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addDefaultOres(generation);
        BiomeDefaultFeatures.addDefaultSoftDisks(generation);
        BiomeDefaultFeatures.addWaterTrees(generation);
        BiomeDefaultFeatures.addDefaultFlowers(generation);
        BiomeDefaultFeatures.addDefaultGrass(generation);
        BiomeDefaultFeatures.addDefaultMushrooms(generation);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generation);
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
    }
}
