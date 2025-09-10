package com.peeko32213.seafarer.biolith;

import com.peeko32213.seafarer.data.SeaBiomeProvider;
import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.SubBiomeMatcher;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;

public class SeaBiomePlacements {

    public static final SubBiomeMatcher.Criterion NEAR_BORDER = SubBiomeMatcher.Criterion.ofMax(SubBiomeMatcher.CriterionTargets.EDGE, SubBiomeMatcher.CriterionTypes.RATIO, 1.0F);

    public static void register() {

        BiomePlacement.addSubOverworld(
                Biomes.BEACH,
                SeaBiomeProvider.CORAL_BEACH,
                SubBiomeMatcher.of(NEAR_BORDER, SubBiomeMatcher.Criterion.ofBiome(SubBiomeMatcher.CriterionTargets.NEIGHBOR, BiomeTags.IS_JUNGLE, false))
        );
    }
}
