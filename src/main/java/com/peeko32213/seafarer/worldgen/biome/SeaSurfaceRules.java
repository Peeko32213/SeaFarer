package com.peeko32213.seafarer.worldgen.biome;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.worldgen.SeaBiomes;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class SeaSurfaceRules {

    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource CORALINE_SAND = makeStateRule(SeaBlocks.CORALINE_SAND.get());
    private static final SurfaceRules.RuleSource CORALINE_SANDSTONE = makeStateRule(SeaBlocks.CORALINE_SANDSTONE.get());
    private static final SurfaceRules.RuleSource VOLCANIC_SAND = makeStateRule(SeaBlocks.VOLCANIC_SAND.get());
    private static final SurfaceRules.RuleSource VOLCANIC_SANDSTONE = makeStateRule(SeaBlocks.VOLCANIC_SANDSTONE.get());
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);

    public static void register() {

        SurfaceRules.RuleSource sandy_beach = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeaBiomes.FLOWERING_BEACH, SeaBiomes.GRASSY_BEACH, SeaBiomes.GLASS_BEACH),
                SurfaceRules.ifTrue(abovePreliminarySurface(), beachSandRuleSource(SAND, SANDSTONE))
        );

        SurfaceRules.RuleSource coral_beach = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeaBiomes.CORAL_BEACH),
                SurfaceRules.ifTrue(abovePreliminarySurface(), beachSandRuleSource(CORALINE_SAND, CORALINE_SANDSTONE))
        );

        SurfaceRules.RuleSource volcanic_beach = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeaBiomes.VOLCANIC_BEACH),
                SurfaceRules.ifTrue(abovePreliminarySurface(), beachSandRuleSource(VOLCANIC_SAND, VOLCANIC_SANDSTONE))
        );

        SurfaceRules.RuleSource warm_reef = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeaBiomes.WARM_REEF),
                SurfaceRules.ifTrue(abovePreliminarySurface(), sequence(ifTrue(noiseRange(0.3F, 2.5F), oceanSandRuleSource(CORALINE_SAND, CORALINE_SANDSTONE)), oceanSandRuleSource(SAND, SANDSTONE)))
        );

        SurfaceRules.RuleSource tropical_river = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeaBiomes.TROPICAL_RIVER),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(surfaceNoiseAbove(1.25), SAND), SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)))
        ));

        SurfaceRules.RuleSource kelp_forest = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeaBiomes.KELP_FOREST),
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
                                        sandy_beach,
                                        coral_beach,
                                        volcanic_beach,
                                        warm_reef,
                                        tropical_river,
                                        kelp_forest,
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
