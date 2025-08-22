package com.peeko32213.seafarer.entities;

import com.peeko32213.seafarer.entities.ai.goal.AquaticLeapGoal;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MantaRay extends WaterAnimal {

    public float prevOnLandProgress;
    public float onLandProgress;

    public final AnimationState flopAnimationState = new AnimationState();

    public MantaRay(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 60, 2, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 2);
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new WaterBoundPathNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 14.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.8F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 10));
        this.goalSelector.addGoal(2, new MantaRayLeapGoal(this));
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions size) {
        return size.height * 0.5F;
    }

    @Override
    public void travel(Vec3 travelVec) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F, travelVec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVec);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        this.flopAnimationState.animateWhen(this.isAlive() && !this.isInWaterOrBubble(), this.tickCount);
    }

    @Override
    public void aiStep() {
        this.prevOnLandProgress = onLandProgress;
        boolean onLand = !this.isInWaterOrBubble() && this.onGround();
        if (onLand && onLandProgress < 10F) {
            onLandProgress++;
        }
        if (!onLand && onLandProgress > 0F) {
            onLandProgress--;
        }

        if (!isInWaterOrBubble() && this.isAlive()) {
            if (this.onGround() && random.nextFloat() < 0.05F) {
                this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.1F, 0.3D, (this.random.nextFloat() * 2.0F - 1.0F) * 0.1F));
                this.setYRot(this.random.nextFloat() * 360.0F);
                this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
            }
        }
        super.aiStep();
    }

    @Override
    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.TROPICAL_FISH_AMBIENT;
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.TROPICAL_FISH_DEATH;
    }

    @Override
    @Nullable
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.TROPICAL_FISH_HURT;
    }

    @Nullable
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    // goals
    static class MantaRayLeapGoal extends AquaticLeapGoal {

        private final MantaRay mantaRay;

        public MantaRayLeapGoal(MantaRay mantaRay) {
            super(mantaRay, 10);
            this.mantaRay = mantaRay;
        }

        @Override
        public void start() {
            Direction direction = mantaRay.getMotionDirection();
            mantaRay.setDeltaMovement(mantaRay.getDeltaMovement().add((double) direction.getStepX() * 1.25D, 0.9D, (double) direction.getStepZ() * 1.25D));
            mantaRay.getNavigation().stop();
        }
    }
}
