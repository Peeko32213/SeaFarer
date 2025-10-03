package com.peeko32213.seafarer.worldgen.biome;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.worldgen.SeafarerBiomes;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class SeafarerSurfaceRules {

    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource CORALINE_SAND = makeStateRule(SeafarerBlocks.CORALINE_SAND.get());
    private static final SurfaceRules.RuleSource CORALINE_SANDSTONE = makeStateRule(SeafarerBlocks.CORALINE_SANDSTONE.get());
    private static final SurfaceRules.RuleSource VOLCANIC_SAND = makeStateRule(SeafarerBlocks.VOLCANIC_SAND.get());
    private static final SurfaceRules.RuleSource VOLCANIC_SANDSTONE = makeStateRule(SeafarerBlocks.VOLCANIC_SANDSTONE.get());
    private static final SurfaceRules.RuleSource SCORIA = makeStateRule(SeafarerBlocks.SCORIA.get());
    private static final SurfaceRules.RuleSource SMOOTH_BASALT = makeStateRule(Blocks.SMOOTH_BASALT);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);

    public static void register() {

        SurfaceRules.RuleSource sandy_beach = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeafarerBiomes.FLOWERING_BEACH, SeafarerBiomes.GRASSY_BEACH, SeafarerBiomes.GLASS_BEACH),
                SurfaceRules.ifTrue(abovePreliminarySurface(), beachSandRuleSource(SAND, SANDSTONE))
        );

        SurfaceRules.RuleSource volcanic_island = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeafarerBiomes.VOLCANIC_ISLAND),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(65), 0)), beachSandRuleSource(VOLCANIC_SAND, VOLCANIC_SANDSTONE)),
                        SurfaceRules.ifTrue(ON_FLOOR, sequence(ifTrue(noiseRange(1.5F, 2.5F), beachSandRuleSource(VOLCANIC_SAND, VOLCANIC_SANDSTONE)), GRASS_BLOCK)),
                        SurfaceRules.ifTrue(UNDER_FLOOR, DIRT)
        ));

        SurfaceRules.RuleSource warm_reef = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeafarerBiomes.WARM_REEF),
                SurfaceRules.ifTrue(abovePreliminarySurface(), sequence(ifTrue(noiseRange(0.3F, 2.5F), oceanSandRuleSource(CORALINE_SAND, CORALINE_SANDSTONE)), oceanSandRuleSource(SAND, SANDSTONE)))
        );

        SurfaceRules.RuleSource tropical_river = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeafarerBiomes.TROPICAL_RIVER),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(surfaceNoiseAbove(1.25), SAND), SurfaceRules.ifTrue(yBlockCheck(VerticalAnchor.absolute(60), 0),
                        SurfaceRules.ifTrue(not(yBlockCheck(VerticalAnchor.absolute(63), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)))
        ));

        SurfaceRules.RuleSource kelp_forest = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeafarerBiomes.KELP_FOREST),
                SurfaceRules.ifTrue(abovePreliminarySurface(), oceanSandRuleSource(SAND, SANDSTONE))
        );

        // vanilla biomes
        SurfaceRules.RuleSource lukewarm_ocean = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN),
                SurfaceRules.ifTrue(abovePreliminarySurface(), oceanSandRuleSource(SAND, SANDSTONE))
        );

        SurfaceGeneration.addOverworldSurfaceRules(
                Seafarer.modPrefix("rules/overworld"),
                SurfaceRules.ifTrue(
                        SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.sequence(
                                SurfaceRules.sequence(
                                        kelp_forest,
                                        sandy_beach,
                                        tropical_river,
                                        volcanic_island,
                                        warm_reef,
                                        lukewarm_ocean
                                )
                        )
                )
        );
    }

    private static RuleSource oceanSandRuleSource(RuleSource sand, RuleSource sandstone) {
        return sequence(
                ifTrue(ON_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand)),
                ifTrue(UNDER_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand))
        );
    }

    private static RuleSource beachSandRuleSource(RuleSource sand, RuleSource sandstone) {
        return sequence(
                ifTrue(ON_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand)),
                ifTrue(UNDER_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand))
        );
    }

    private static RuleSource makeStateRule(Block block) {
        return state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double value) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, value / 8.25, Double.MAX_VALUE);
    }

    private static ConditionSource noiseRange(float low, float high) {
        return noiseCondition(Noises.SURFACE, low / 8.25F, high / 8.25F);
    }
}
