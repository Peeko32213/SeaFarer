package com.peeko32213.seafarer.common.entity;

import com.peeko32213.seafarer.common.entity.misc.goal.BottomSwimmingGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class EntityBarreleye extends WaterAnimal implements GeoAnimatable {
    private static final EntityDataAccessor<Boolean> DATA_ID_MOVING = SynchedEntityData.defineId(EntityBarreleye.class, EntityDataSerializers.BOOLEAN);
    private static final RawAnimation SWIM = RawAnimation.begin().thenLoop("animation.barreleye.swim");
    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.barreleye.idle");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean clientSideTouchedGround;
    @Nullable
    protected BottomSwimmingGoal randomStrollGoal;


    public EntityBarreleye(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.moveControl = new EntityBarreleye.BarreleyeMoveControl(this);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.13F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new EntityBarreleye.BarreleyeAvoidPlayerGoal<>(this, Player.class, 45.0F, 1.33D, 1.33D));
        this.goalSelector.addGoal(4, new BottomSwimmingGoal(this, 0.6D, 40));
    }

    static class BarreleyeAvoidPlayerGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
        private final EntityBarreleye ocelot;

        public BarreleyeAvoidPlayerGoal(EntityBarreleye pOcelot, Class<T> pEntityClassToAvoid, float pMaxDist, double pWalkSpeedModifier, double pSprintSpeedModifier) {
            super(pOcelot, pEntityClassToAvoid, pMaxDist, pWalkSpeedModifier, pSprintSpeedModifier, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test);
            this.ocelot = pOcelot;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            return super.canUse();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }
    }

    protected PathNavigation createNavigation(Level pLevel) {
        return new WaterBoundPathNavigation(this, pLevel);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_MOVING, false);
    }


    public MobType getMobType() {
        return MobType.WATER;
    }

    public boolean isMoving() {
        return this.entityData.get(DATA_ID_MOVING);
    }

    void setMoving(boolean pMoving) {
        this.entityData.set(DATA_ID_MOVING, pMoving);
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * 0.5F;
    }

    public float getWalkTargetValue(BlockPos pPos, LevelReader pLevel) {
        return pLevel.getFluidState(pPos).is(FluidTags.WATER) ? 10.0F + pLevel.getPathfindingCostFromLightLevels(pPos) : super.getWalkTargetValue(pPos, pLevel);
    }

    public void aiStep() {
        if (this.isAlive()) {
            if (this.level().isClientSide) {
                if (!this.isInWater()) {
                    Vec3 vec3 = this.getDeltaMovement();
                    if (vec3.y > 0.0D && this.clientSideTouchedGround && !this.isSilent()) {
                        this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getFlopSound(), this.getSoundSource(), 1.0F, 1.0F, false);
                    }

                    this.clientSideTouchedGround = vec3.y < 0.0D && this.level().loadedAndEntityCanStandOn(this.blockPosition().below(), this);
                }
            }

            if (this.isInWaterOrBubble()) {
                this.setAirSupply(300);
            } else if (this.onGround()) {
                this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F), 0.5D, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F)));
                this.setYRot(this.random.nextFloat() * 360.0F);
                this.setOnGround(false);
                this.hasImpulse = true;
            }
        }

        super.aiStep();
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.GUARDIAN_FLOP;
    }

    public boolean checkSpawnObstruction(LevelReader pLevel) {
        return pLevel.isUnobstructed(this);
    }

    public int getMaxHeadXRot() {
        return 180;
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isControlledByLocalInstance() && this.isInWater()) {
            this.moveRelative(0.1F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (!this.isMoving() && this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(pTravelVector);
        }

    }

    static class BarreleyeMoveControl extends MoveControl {
        private final EntityBarreleye guardian;

        public BarreleyeMoveControl(EntityBarreleye pGuardian) {
            super(pGuardian);
            this.guardian = pGuardian;
        }

        public void tick() {
            if (this.guardian.isInWater()) {
                this.guardian.setDeltaMovement(this.guardian.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
            }

            if (this.operation == Operation.MOVE_TO && !this.guardian.getNavigation().isDone()) {
                double d0 = this.wantedX - this.guardian.getX();
                double d1 = this.wantedY - this.guardian.getY();
                double d2 = this.wantedZ - this.guardian.getZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                if (d3 < (double) 2.5000003E-7F) {
                    this.mob.setZza(0.0F);
                } else {
                    float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                    this.guardian.setYRot(this.rotlerp(this.guardian.getYRot(), f, 10.0F));
                    this.guardian.yBodyRot = this.guardian.getYRot();
                    this.guardian.yHeadRot = this.guardian.getYRot();
                    float f1 = (float) (this.speedModifier * this.guardian.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    if (this.guardian.isInWater()) {
                        this.guardian.setSpeed(f1 * 0.02F);
                        float f2 = -((float) (Mth.atan2(d1, Mth.sqrt((float) (d0 * d0 + d2 * d2))) * (double) (180F / (float) Math.PI)));
                        f2 = Mth.clamp(Mth.wrapDegrees(f2), -85.0F, 85.0F);
                        this.guardian.setXRot(this.rotlerp(this.guardian.getXRot(), f2, 5.0F));
                        float f3 = Mth.cos(this.guardian.getXRot() * ((float) Math.PI / 180F));
                        float f4 = Mth.sin(this.guardian.getXRot() * ((float) Math.PI / 180F));
                        this.guardian.zza = f3 * f1;
                        this.guardian.yya = -f4 * f1;
                    } else {
                        this.guardian.setSpeed(f1 * 0.1F);
                    }

                }
            } else {
                this.guardian.setSpeed(0.0F);
                this.guardian.setXxa(0.0F);
                this.guardian.setYya(0.0F);
                this.guardian.setZza(0.0F);
            }
        }
    }

    protected <E extends EntityBarreleye> PlayState controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F)) {
            event.setAndContinue(SWIM);
            event.getController().setAnimationSpeed(1.8D);
        } else {
            event.setAndContinue(IDLE);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::controller));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object o) {
        return tickCount;
    }
}
