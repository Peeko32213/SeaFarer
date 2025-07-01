package com.peeko32213.seafarer.entities.misc.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.JumpGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;


public class SFAquaticLeapGoal extends JumpGoal {

    private static final int[] STEPS_TO_CHECK = new int[]{0, 1, 4, 5, 6, 7};
    private final WaterAnimal entity;
    private final int interval;
    private boolean breached;

    public SFAquaticLeapGoal(WaterAnimal pEntity, int pInterval) {
        this.entity = pEntity;
        this.interval = reducedTickDelay(pInterval);
    }

    public boolean canUse() {
        if (this.entity.getRandom().nextInt(this.interval) != 0) {
            return false;
        } else {
            Direction direction = this.entity.getMotionDirection();
            int i = direction.getStepX();
            int j = direction.getStepZ();
            BlockPos pos = this.entity.blockPosition();

            for(int k : STEPS_TO_CHECK) {
                if (!this.waterIsClear(pos, i, j, k) || !this.surfaceIsClear(pos, i, j, k)) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean waterIsClear(BlockPos pPos, int pDx, int pDz, int pScale) {
        BlockPos $$4 = pPos.offset(pDx * pScale, 0, pDz * pScale);
        return this.entity.level().getFluidState($$4).is(FluidTags.WATER) && !this.entity.level().getBlockState($$4).blocksMotion();
    }

    private boolean surfaceIsClear(BlockPos pPos, int pDx, int pDz, int pScale) {
        return this.entity.level().getBlockState(pPos.offset(pDx * pScale, 1, pDz * pScale)).isAir() && this.entity.level().getBlockState(pPos.offset(pDx * pScale, 2, pDz * pScale)).isAir();
    }

    public boolean canContinueToUse() {
        double d0 = this.entity.getDeltaMovement().y;
        return (!(d0 * d0 < (double)0.03F) || this.entity.getXRot() == 0.0F || !(Math.abs(this.entity.getXRot()) < 10.0F) || !this.entity.isInWater()) && !this.entity.onGround();
    }

    public boolean isInterruptable() {
        return false;
    }

    public void start() {
        Direction direction = this.entity.getMotionDirection();
        this.entity.setDeltaMovement(this.entity.getDeltaMovement().add((double) direction.getStepX() * 1.5D, 1.2D, (double) direction.getStepZ() * 1.5D));
        this.entity.getNavigation().stop();
    }

    public void stop() {
        this.entity.setXRot(0.0F);
    }

    public void tick() {
        boolean flag = this.breached;
        if (!flag) {
            FluidState fluidstate = this.entity.level().getFluidState(this.entity.blockPosition());
            this.breached = fluidstate.is(FluidTags.WATER);
        }

        if (this.breached && !flag) {
            this.entity.playSound(SoundEvents.DOLPHIN_JUMP, 1.0F, 1.0F);
        }

        Vec3 vec3 = this.entity.getDeltaMovement();
        if (vec3.y * vec3.y < (double) 0.03F && this.entity.getXRot() != 0.0F) {
            this.entity.setXRot(Mth.rotLerp(0.2F, this.entity.getXRot(), 0.0F));
        } else if (vec3.length() > (double) 1.0E-5F) {
            double d0 = vec3.horizontalDistance();
            double d1 = Math.atan2(-vec3.y, d0) * (double) (180F / (float) Math.PI);
            this.entity.setXRot((float) d1);
        }
    }
}