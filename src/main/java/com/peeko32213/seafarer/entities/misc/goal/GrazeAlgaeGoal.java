package com.peeko32213.seafarer.entities.misc.goal;

import com.peeko32213.seafarer.registry.SeafarerBlocks;
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

public class GrazeAlgaeGoal extends Goal {
    private static final int EAT_ANIMATION_TICKS = 40;
    private static final Predicate<BlockState> IS_TALL_GRASS = BlockStatePredicate.forBlock(Blocks.GRASS);
    /** The entity owner of this AITask */
    private final Mob mob;
    /** The world the grass eater entity is eating from */
    private final Level level;
    /** Number of ticks since the entity started to eat grass */
    private int eatAnimationTick;

    public GrazeAlgaeGoal(Mob pMob) {
        this.mob = pMob;
        this.level = pMob.level();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        if (this.mob.getRandom().nextInt(100) == 0) {
            BlockPos blockpos = this.mob.blockPosition();
            return this.level.getBlockState(blockpos.below()).is(SeafarerBlocks.ALGAE_BLOCK.get());
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
            if (IS_TALL_GRASS.test(this.level.getBlockState(blockpos))) {
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
                    this.level.destroyBlock(blockpos, false);
                }

                this.mob.ate();
            } else {
                BlockPos blockpos1 = blockpos.below();
                if (this.level.getBlockState(blockpos1).is(Blocks.GRASS_BLOCK)) {
                    if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
                        this.level.levelEvent(2001, blockpos1, Block.getId(Blocks.GRASS_BLOCK.defaultBlockState()));
                        this.level.setBlock(blockpos1, Blocks.DIRT.defaultBlockState(), 2);
                    }

                    this.mob.ate();
                }
            }

        }
    }
}

