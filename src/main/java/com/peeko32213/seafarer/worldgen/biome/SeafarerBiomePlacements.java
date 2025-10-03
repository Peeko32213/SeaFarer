package com.peeko32213.seafarer.worldgen.biome;

import com.peeko32213.seafarer.SeafarerConfig;
import com.peeko32213.seafarer.registry.worldgen.SeafarerBiomes;
import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.SubBiomeMatcher;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;

public class SeafarerBiomePlacements {

    public static final SubBiomeMatcher.Criterion NEAR_BORDER = SubBiomeMatcher.Criterion.ofMax(SubBiomeMatcher.CriterionTargets.EDGE, SubBiomeMatcher.CriterionTypes.RATIO, 1.25F);

    public static void register() {

        if (SeafarerConfig.FLOWERING_BEACH.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.BEACH,
                    SeafarerBiomes.FLOWERING_BEACH,
                    0.05D
            );
        }

        if (SeafarerConfig.GLASS_BEACH.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.BEACH,
                    SeafarerBiomes.GLASS_BEACH,
                    0.01D
            );
        }

        if (SeafarerConfig.GRASSY_BEACH.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.BEACH,
                    SeafarerBiomes.GRASSY_BEACH,
                    0.08D
            );
        }

        if (SeafarerConfig.KELP_FOREST.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.LUKEWARM_OCEAN,
                    SeafarerBiomes.KELP_FOREST,
                    0.1D
            );
        }

        if (SeafarerConfig.TROPICAL_RIVER.get()) {
            BiomePlacement.addSubOverworld(
                    Biomes.RIVER,
                    SeafarerBiomes.TROPICAL_RIVER,
                    SubBiomeMatcher.of(NEAR_BORDER, SubBiomeMatcher.Criterion.ofBiome(SubBiomeMatcher.CriterionTargets.NEIGHBOR, BiomeTags.IS_JUNGLE, false)
            ));
        }

        if (SeafarerConfig.VOLCANIC_ISLAND.get()) {
            BiomePlacement.addSubOverworld(
                    Biomes.MUSHROOM_FIELDS,
                    SeafarerBiomes.VOLCANIC_ISLAND,
                    SubBiomeMatcher.of(
                            SubBiomeMatcher.Criterion.ofRange(SubBiomeMatcher.CriterionTargets.TEMPERATURE, SubBiomeMatcher.CriterionTypes.VALUE, 0.2F, 1.0F, false)
                    ));
        }

        if (SeafarerConfig.WARM_REEF.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.WARM_OCEAN,
                    SeafarerBiomes.WARM_REEF,
                    0.45D
            );
        }
    }
}
