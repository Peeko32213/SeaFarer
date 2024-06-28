package com.peeko32213.seafarer.common.entity.goal;

import com.peeko32213.seafarer.core.registry.SFBlocks;
import com.scouter.goalsmith.data.PredicateCodec;
import com.scouter.goalsmith.data.predicates.TruePredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;

import java.util.EnumSet;
import java.util.function.Predicate;

public class GrazeGoal extends Goal {
    private static final int EAT_ANIMATION_TICKS = 40;
    /** The entity owner of this AITask */
    private final Mob mob;
    /** The world the grass eater entity is eating from */
    private final Level level;
    /** Number of ticks since the entity started to eat grass */
    private int eatAnimationTick;
    private final Block canUse;
    private final Block otherBlock;
    private final Block otherBlockReplacement;
    private final PredicateCodec<BlockState> blockState;
    //public Predicate<BlockState> blockState

    public GrazeGoal(Mob pMob) {
        this(pMob, SFBlocks.ALGAE_BLOCK.get(), Blocks.GRASS_BLOCK, Blocks.DIRT, new TruePredicate<>());
    }

    public GrazeGoal(Mob pMob, Block canUse, Block otherBlock, Block otherBlockReplacement, PredicateCodec<BlockState> blockState) {
        this.mob = pMob;
        this.level = pMob.level();
        this.canUse = canUse;
        this.otherBlock = otherBlock;
        this.blockState =blockState;
        this.otherBlockReplacement = otherBlockReplacement;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        if (this.mob.getRandom().nextInt(100) == 0) {
            BlockPos blockpos = this.mob.blockPosition();
            return this.level.getBlockState(blockpos.below()).is(canUse);
        } else {
            return false;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        this.eatAnimationTick = this.adjustedTickDelay(40);
        this.level.broadcastEntityEvent(this.mob, (byte)10);
        this.mob.getNavigation().stop();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        this.eatAnimationTick = 0;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean canContinueToUse() {
        return this.eatAnimationTick > 0;
    }

    /**
     * Number of ticks since the entity started to eat grass
     */
    public int getEatAnimationTick() {
        return this.eatAnimationTick;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        if (this.eatAnimationTick == this.adjustedTickDelay(4)) {
            BlockPos blockpos = this.mob.blockPosition();
            if (blockState.getPredicate().test(this.level.getBlockState(blockpos))) {
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
                    this.level.destroyBlock(blockpos, false);
                }

                this.mob.ate();
            } else {
                BlockPos blockpos1 = blockpos.below();
                if (this.level.getBlockState(blockpos1).is(otherBlock)) {
                    if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
                        this.level.levelEvent(2001, blockpos1, Block.getId(otherBlock.defaultBlockState()));
                        this.level.setBlock(blockpos1, otherBlockReplacement.defaultBlockState(), 2);
                    }

                    this.mob.ate();
                }
            }

        }
    }
}

