package com.peeko32213.seafarer.data.server.modifiers;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.blocks.SFBlocks;
import com.peeko32213.seafarer.core.registry.world.SFBiomes;
import com.teamabnormals.blueprint.common.world.modification.chunk.ChunkGeneratorModifierProvider;
import com.teamabnormals.blueprint.common.world.modification.chunk.modifiers.SurfaceRuleModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class SFChunkGeneratorModifierProvider extends ChunkGeneratorModifierProvider {

    public SFChunkGeneratorModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
        super(SeaFarer.MODID, output, provider);
    }

    @Override
    protected void registerEntries(Provider provider) {
        ConditionSource isWarmReef = isBiome(SFBiomes.WARM_REEF);
        ConditionSource sandstoneCondition = (SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.CEILING));

        RuleSource warmReefSandstone = sequence(ifTrue(sandstoneCondition, state(Blocks.SANDSTONE.defaultBlockState())));
        RuleSource warmReefCoralineSandstone = sequence(ifTrue(sandstoneCondition, state(SFBlocks.CORALINE_SANDSTONE.get().defaultBlockState())));

        RuleSource warmReefSand = sequence(ifTrue(ON_FLOOR, state(Blocks.SAND.defaultBlockState())));
        RuleSource warmReefCoralineSand = sequence(ifTrue(ON_FLOOR, state(SFBlocks.CORAL_SAND.get().defaultBlockState())));

        RuleSource warmReefSurface1 = sequence(warmReefSandstone, warmReefSand);
        RuleSource warmReefSurface2 = sequence(warmReefCoralineSandstone, warmReefCoralineSand);

        this.entry("seafarer_surface_rules").selects("minecraft:overworld")
                .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isWarmReef, sequence(ifTrue(noiseRange(0.35F, 2.25F), warmReefSurface2), warmReefSurface1))), false))
        ;

    }

    private static ConditionSource noiseRange(double low, double high) {
        return noiseCondition(Noises.SURFACE, low / 8.25D, high / 8.25D);
    }

    private static ConditionSource surfaceNoiseAbove(double noise) {
        return noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
    }
}
