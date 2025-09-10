package com.peeko32213.seafarer.worldgen.biome;

import com.peeko32213.seafarer.SeafarerConfig;
import com.peeko32213.seafarer.registry.worldgen.SeaBiomes;
import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.SubBiomeMatcher;
import net.minecraft.world.level.biome.Biomes;

public class SeaBiomePlacements {

    public static void register() {

        if (SeafarerConfig.ASHEN_BEACH.get()) {
            BiomePlacement.addSubOverworld(
                    Biomes.BEACH,
                    SeaBiomes.ASHEN_BEACH,
                    SubBiomeMatcher.of(
                            SubBiomeMatcher.Criterion.ofRange(SubBiomeMatcher.CriterionTargets.TEMPERATURE, SubBiomeMatcher.CriterionTypes.VALUE, 0.3F, 0.55F, false),
                            SubBiomeMatcher.Criterion.ofRange(SubBiomeMatcher.CriterionTargets.HUMIDITY, SubBiomeMatcher.CriterionTypes.VALUE, 0.1F, 1.0F, false)
                    ));
        }

        if (SeafarerConfig.CORAL_BEACH.get()) {
            BiomePlacement.addSubOverworld(
                    Biomes.BEACH,
                    SeaBiomes.CORAL_BEACH,
                    SubBiomeMatcher.of(
                            SubBiomeMatcher.Criterion.ofRange(SubBiomeMatcher.CriterionTargets.TEMPERATURE, SubBiomeMatcher.CriterionTypes.VALUE, 0.2F, 0.55F, false),
                            SubBiomeMatcher.Criterion.ofRange(SubBiomeMatcher.CriterionTargets.HUMIDITY, SubBiomeMatcher.CriterionTypes.VALUE, 0.2F, 1.0F, false)
                    ));
        }

        if (SeafarerConfig.FLOWERING_BEACH.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.BEACH,
                    SeaBiomes.FLOWERING_BEACH,
                    0.05D
            );
        }

        if (SeafarerConfig.GLASS_BEACH.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.BEACH,
                    SeaBiomes.GLASS_BEACH,
                    0.01D
            );
        }

        if (SeafarerConfig.GRASSY_BEACH.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.BEACH,
                    SeaBiomes.GRASSY_BEACH,
                    0.08D
            );
        }

        if (SeafarerConfig.KELP_FOREST.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.LUKEWARM_OCEAN,
                    SeaBiomes.KELP_FOREST,
                    0.1D
            );
        }

        if (SeafarerConfig.WARM_REEF.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.WARM_OCEAN,
                    SeaBiomes.WARM_REEF,
                    0.3D
            );
        }
    }
}
