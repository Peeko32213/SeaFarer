package com.peeko32213.seafarer.common.entity;

import com.peeko32213.seafarer.common.entity.base.EnhancedWaterAnimal;
import com.peeko32213.seafarer.common.entity.misc.goal.GroundseekingRandomSwimGoal;
import com.peeko32213.seafarer.common.entity.misc.util.SmartBodyHelper;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

public class ChimaeraEntity extends EnhancedWaterAnimal {

    private static final RawAnimation SWIM = RawAnimation.begin().thenLoop("animation.chimaera.swim");
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.chimaera.idle");
    private static final RawAnimation FLOP = RawAnimation.begin().thenLoop("animation.chimaera.flop");
    private static final RawAnimation EAT = RawAnimation.begin().thenLoop("animation.chimaera.attack");

    // Body control / navigation
    @Override
    protected @NotNull BodyRotationControl createBodyControl() {
        SmartBodyHelper helper = new SmartBodyHelper(this);
        helper.bodyLagMoving = 0.45F;
        helper.bodyLagStill = 0.24F;
        return helper;
    }

    public ChimaeraEntity(EntityType<? extends EnhancedWaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new SmoothSwimmingMoveControl(this, 40, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.7F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new GroundseekingRandomSwimGoal(this, 1, 20, 16, 24, 0.01));
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * 0.5F;
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
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

    public boolean checkSpawnObstruction(LevelReader pLevel) {
        return pLevel.isUnobstructed(this);
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::controller));
    }

    protected <E extends ChimaeraEntity> PlayState controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F) && this.isInWater()) {
            event.setAndContinue(SWIM);
            event.getController().setAnimationSpeed(1.0F);
            return PlayState.CONTINUE;
        }
        if (!this.isInWater()) {
            event.setAndContinue(FLOP);
            event.getController().setAnimationSpeed(1.0F);
            return PlayState.CONTINUE;
        }
        else if (this.isInWater()){
            event.setAndContinue(IDLE);
            event.getController().setAnimationSpeed(1.0F);
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }
}
