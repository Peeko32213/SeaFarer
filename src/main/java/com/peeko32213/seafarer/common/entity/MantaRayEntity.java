package com.peeko32213.seafarer.common.entity;

import com.peeko32213.seafarer.common.entity.base.EnhancedWaterAnimal;
import com.peeko32213.seafarer.common.entity.misc.goal.CustomRandomSwimGoal;
import com.peeko32213.seafarer.common.entity.misc.goal.SFAquaticLeapGoal;
import com.peeko32213.seafarer.common.entity.misc.util.SmartBodyHelper;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

public class MantaRayEntity extends EnhancedWaterAnimal {

    private static final RawAnimation MANTA_SWIM = RawAnimation.begin().thenLoop("animation.manta_ray.swim");
    private static final RawAnimation MANTA_BEACHED = RawAnimation.begin().thenLoop("animation.manta_ray.beached");

    @Override
    protected @NotNull BodyRotationControl createBodyControl() {
        SmartBodyHelper helper = new SmartBodyHelper(this);
        helper.bodyLagMoving = 0.3F;
        helper.bodyLagStill = 0.2F;
        return helper;
    }

    public MantaRayEntity(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 20, 8, 0.02F, 0.1F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 4);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.25D)
                .add(Attributes.MOVEMENT_SPEED, 0.9F)
        ;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(0, new CustomRandomSwimGoal(this, 1.0, 1, 20, 20, 2));
        this.goalSelector.addGoal(2, new MantaRayLeapGoal());
    }

    @Override
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * 0.5F;
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.0D, 0.0D));
            }
        }
        if (this.isEyeInFluid(FluidTags.WATER) && this.isPathFinding()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.001, 0.0));
        }
        if (!this.isEyeInFluid(FluidTags.WATER) && this.isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.002, 0.0));
        }
        else {
            super.travel(pTravelVector);
        }
    }

    // Flop
    @Override
    public void aiStep() {
        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F, 0.4F, (this.random.nextFloat() * 2.0F - 1.0F) * 0.05F));
            this.setOnGround(false);
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }
        super.aiStep();
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.TROPICAL_FISH_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.TROPICAL_FISH_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_28281_) {
        return SoundEvents.TROPICAL_FISH_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::Controller));
    }

    protected <E extends MantaRayEntity> PlayState Controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (isInWater()) {
            event.setAndContinue(MANTA_SWIM);
            event.getController().setAnimationSpeed(1.0F);
        }
        else {
            event.setAndContinue(MANTA_BEACHED);
            event.getController().setAnimationSpeed(1.0F);
        }
        return PlayState.CONTINUE;
    }

    // Goals
    private class MantaRayLeapGoal extends SFAquaticLeapGoal {

        public MantaRayLeapGoal() {
            super(MantaRayEntity.this, 20);
        }

        @Override
        public void start() {
            Direction direction = MantaRayEntity.this.getMotionDirection();
            MantaRayEntity.this.setDeltaMovement(MantaRayEntity.this.getDeltaMovement().add((double) direction.getStepX() * 2.25D, 1.5D, (double) direction.getStepZ() * 2.25D));
            MantaRayEntity.this.getNavigation().stop();
        }
    }
}
