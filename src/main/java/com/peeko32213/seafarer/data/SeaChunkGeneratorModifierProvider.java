package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.teamabnormals.blueprint.common.world.modification.chunk.ChunkGeneratorModifierProvider;
import com.teamabnormals.blueprint.common.world.modification.chunk.modifiers.SurfaceRuleModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.data.event.GatherDataEvent;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class SeaChunkGeneratorModifierProvider extends ChunkGeneratorModifierProvider {

    public SeaChunkGeneratorModifierProvider(GatherDataEvent event, SeaDatapackBuiltinEntriesProvider dataPack) {
        super(Seafarer.MOD_ID, event.getGenerator().getPackOutput(), dataPack.getRegistryProvider());
    }

    @Override
    protected void registerEntries(HolderLookup.Provider provider) {
        SurfaceRules.ConditionSource isWarmReef = isBiome(SeaBiomeProvider.WARM_REEF);
        SurfaceRules.ConditionSource isSandyBeach = isBiome(SeaBiomeProvider.FLOWERING_BEACH, SeaBiomeProvider.GRASSY_BEACH, SeaBiomeProvider.GLASS_BEACH);
        SurfaceRules.ConditionSource isCoralBeach = isBiome(SeaBiomeProvider.CORAL_BEACH);

        RuleSource sand = state(Blocks.SAND.defaultBlockState());
        RuleSource sandstone = state(Blocks.SANDSTONE.defaultBlockState());

        RuleSource coraline_sand = state(SeaBlocks.CORAL_SAND.get().defaultBlockState());
        RuleSource coraline_sandstone = state(SeaBlocks.CORALINE_SANDSTONE.get().defaultBlockState());

        RuleSource oceanSandRuleSource = oceanSandRuleSource(sand, sandstone);
        RuleSource oceanCoralineSandRuleSource = oceanSandRuleSource(coraline_sand, coraline_sandstone);

        RuleSource beachSandRuleSource = beachSandRuleSource(sand, sandstone);
        RuleSource coralBeachSandRuleSource = beachSandRuleSource(coraline_sand, coraline_sandstone);

        this.entry("seafarer_surface_rule").selects("minecraft:overworld")
                .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isWarmReef, sequence(ifTrue(noiseRange(0.3F, 2.5F), oceanCoralineSandRuleSource), oceanSandRuleSource))), false))
                .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isSandyBeach, beachSandRuleSource)), false))
                .addModifier(new SurfaceRuleModifier(ifTrue(abovePreliminarySurface(), ifTrue(isCoralBeach, coralBeachSandRuleSource)), false)
        );
    }

    private RuleSource oceanSandRuleSource(RuleSource sand, RuleSource sandstone) {
        return sequence(
                ifTrue(ON_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand)),
                ifTrue(UNDER_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand))
        );
    }

    private RuleSource beachSandRuleSource(RuleSource sand, RuleSource sandstone) {
        return sequence(
                ifTrue(ON_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand)),
                ifTrue(UNDER_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand))
        );
    }

    private static SurfaceRules.ConditionSource noiseRange(float low, float high) {
        return noiseCondition(Noises.SURFACE, low / 8.25F, high / 8.25F);
    }
}
