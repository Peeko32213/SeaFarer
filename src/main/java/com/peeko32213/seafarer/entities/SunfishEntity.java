package com.peeko32213.seafarer.entities;

import com.peeko32213.seafarer.entities.base.EnhancedWaterAnimal;
import com.peeko32213.seafarer.entities.misc.goal.CustomRandomSwimGoal;
import com.peeko32213.seafarer.entities.misc.goal.SFAquaticLeapGoal;
import com.peeko32213.seafarer.entities.misc.util.SmartBodyHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

public class SunfishEntity extends EnhancedWaterAnimal {

    private static final RawAnimation SUNFISH_SWIM = RawAnimation.begin().thenLoop("animation.sunfish.swim");
    private static final RawAnimation SUNFISH_BEACHED = RawAnimation.begin().thenLoop("animation.sunfish.beached");

    @Override
    protected @NotNull BodyRotationControl createBodyControl() {
        SmartBodyHelper helper = new SmartBodyHelper(this);
        helper.bodyLagMoving = 0.25F;
        helper.bodyLagStill = 0.1F;
        return helper;
    }

    public SunfishEntity(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 30, 4, 0.02F, 0.1F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 2);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.25D)
                .add(Attributes.MOVEMENT_SPEED, 0.7F)
        ;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(0, new CustomRandomSwimGoal(this, 1.0, 1, 40, 40, 2));
        this.goalSelector.addGoal(8, new SunfishLeapGoal());
    }

    @Override
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * 0.5F;
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

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.TROPICAL_FISH_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.TROPICAL_FISH_DEATH;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::Controller));
    }

    protected <E extends SunfishEntity> PlayState Controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (isInWater()) {
            event.setAndContinue(SUNFISH_SWIM);
            event.getController().setAnimationSpeed(1.0F);
        }
        else {
            event.setAndContinue(SUNFISH_BEACHED);
            event.getController().setAnimationSpeed(1.25F);
        }
        return PlayState.CONTINUE;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    public static boolean checkSunfishSpawnRules(EntityType<? extends SunfishEntity> pWaterAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        int i = pLevel.getSeaLevel();
        int j = i - 13;
        return pPos.getY() >= j && pPos.getY() <= i && pLevel.getFluidState(pPos.below()).is(FluidTags.WATER) && pLevel.getBlockState(pPos.above()).is(Blocks.WATER);
    }

    // Goals
    private class SunfishLeapGoal extends SFAquaticLeapGoal {

        public SunfishLeapGoal() {
            super(SunfishEntity.this, 5);
        }

        @Override
        public void start() {
            Direction direction = SunfishEntity.this.getMotionDirection();
            SunfishEntity.this.setDeltaMovement(SunfishEntity.this.getDeltaMovement().add((double) direction.getStepX() * 1.5D, 1.25D, (double) direction.getStepZ() * 1.5D));
            SunfishEntity.this.getNavigation().stop();
        }
    }
}
