package com.peeko32213.seafarer.common.entity.goal.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peeko32213.seafarer.common.entity.goal.GrazeGoal;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFGoals;
import com.scouter.goalsmith.data.GoalCodec;
import com.scouter.goalsmith.data.PredicateCodec;
import com.scouter.goalsmith.data.predicates.IsBlockStatePredicate;
import com.scouter.goalsmith.data.predicates.TruePredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;

public class GrazeGoalCodec implements GoalCodec {
    public static final Codec<GrazeGoalCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("goal_priority").forGetter(GrazeGoalCodec::getGoalPriority),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("can_use_block").forGetter(GrazeGoalCodec::getCanUse),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("other_block").forGetter(GrazeGoalCodec::getOtherBlock),
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("other_block_replacement").forGetter(GrazeGoalCodec::getOtherBlockReplacement),
            PredicateCodec.DIRECT_CODEC.fieldOf("blockstate_predicate").forGetter(GrazeGoalCodec::getBlockState)
            ).apply(instance, ((integer, block, block2, block3, predicateCodec) -> new GrazeGoalCodec(integer, block, block2, block3, (PredicateCodec<BlockState>) predicateCodec))));
    private final int goalPriority;
    private final Block canUse;
    private final Block otherBlock;
    private final Block otherBlockReplacement;
    private final PredicateCodec<BlockState> blockState;


    public GrazeGoalCodec(int goalPriority) {
        this(goalPriority, SFBlocks.ALGAE_BLOCK.get(), Blocks.GRASS_BLOCK, Blocks.DIRT, new IsBlockStatePredicate(Blocks.GRASS));
    }

    public GrazeGoalCodec(int goalPriority, Block canUse, Block otherBlock, Block otherBlockReplacement, PredicateCodec<BlockState> blockState) {
        this.goalPriority = goalPriority;
        this.canUse = canUse;
        this.otherBlock = otherBlock;
        this.blockState =blockState;
        this.otherBlockReplacement = otherBlockReplacement;
    }

    public int getGoalPriority() {
        return goalPriority;
    }

    public Block getCanUse() {
        return canUse;
    }

    public Block getOtherBlock() {
        return otherBlock;
    }

    public Block getOtherBlockReplacement() {
        return otherBlockReplacement;
    }

    public PredicateCodec<BlockState> getBlockState() {
        return blockState;
    }

    @Override
    public Goal addGoal(PathfinderMob pathfinderMob) {
        GrazeGoal goal = new GrazeGoal(pathfinderMob, canUse, otherBlock, otherBlockReplacement, blockState);
        pathfinderMob.goalSelector.addGoal(goalPriority, goal);
        return goal;
    }

    @Override
    public Codec<? extends GoalCodec> codec() {
        return SFGoals.GRAZE_GOAL.get();
    }
}
