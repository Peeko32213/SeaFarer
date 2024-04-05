package com.peeko32213.seafarer.common.entity;

import com.peeko32213.seafarer.common.entity.goal.*;
import com.peeko32213.seafarer.common.entity.misc.controller.WaterMoveController;
import com.peeko32213.seafarer.common.entity.misc.interfaces.SemiAquatic;
import com.peeko32213.seafarer.common.entity.misc.navigator.SemiAquaticPathNavigation;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityMarineIguana extends Animal implements GeoAnimatable, SemiAquatic {
    private static final EntityDataAccessor<Integer> PREENING_TIME = SynchedEntityData.defineId(EntityMarineIguana.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> PREENING = SynchedEntityData.defineId(EntityMarineIguana.class, EntityDataSerializers.BOOLEAN);
    private static final RawAnimation MARINE_IGUANA_WALK = RawAnimation.begin().thenLoop("animation.marineiguana.walk");
    private static final RawAnimation MARINE_IGUANA_RUN = RawAnimation.begin().thenLoop("animation.marineiguana.run");
    private static final RawAnimation MARINE_IGUANA_IDLE = RawAnimation.begin().thenLoop("animation.marineiguana.idle");
    private static final RawAnimation MARINE_IGUANA_SIT1 = RawAnimation.begin().thenLoop("animation.marineiguana.sit1");
    private static final RawAnimation MARINE_IGUANA_SIT2 = RawAnimation.begin().thenLoop("animation.marineiguana.sit2");
    private static final RawAnimation MARINE_IGUANA_SIT3 = RawAnimation.begin().thenLoop("animation.marineiguana.sit3");
    private static final RawAnimation MARINE_IGUANA_SWIM = RawAnimation.begin().thenLoop("animation.marineiguana.swim");
    private static final RawAnimation MARINE_IGUANA_SWIM_IDLE = RawAnimation.begin().thenLoop("animation.marineiguana.swim_idle");
    private static final RawAnimation MARINE_IGUANA_SNEEZE = RawAnimation.begin().thenLoop("animation.marineiguana.sneeze");
    private static final RawAnimation MARINE_IGUANA_GRAZE = RawAnimation.begin().thenLoop("animation.marineiguana.graze");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public float prevSwimProgress;
    public float swimProgress;
    private int swimTimer = -1000;
    private boolean isLandNavigator;
    private GrazeAlgaeGoal eatBlockGoal;
    private int eatAnimationTick;

    public EntityMarineIguana(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
        switchNavigator(false);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 15.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0D)
                .add(Attributes.ARMOR, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.18D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
    }

    protected void registerGoals() {
        this.eatBlockGoal = new GrazeAlgaeGoal(this);
        this.goalSelector.addGoal(2, this.eatBlockGoal);
        this.goalSelector.addGoal(7, new FindWaterGoal(this));
        this.goalSelector.addGoal(7, new LeaveWaterGoal(this));
        this.goalSelector.addGoal(9, new SemiAquaticSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(3, new CustomRandomStrollGoal(this, 30, 1.0D, 100, 34));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl(this);
            this.navigation = new GroundPathNavigation(this, level());
            this.isLandNavigator = true;
        } else {
            this.moveControl = new WaterMoveController(this, 1.1F);
            this.navigation = new SemiAquaticPathNavigation(this, level());
            this.isLandNavigator = false;
        }
    }

    public void tick() {
        super.tick();
        this.prevSwimProgress = swimProgress;

        final boolean ground = !this.isInWaterOrBubble();

        if (!ground && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (ground && !this.isLandNavigator) {
            switchNavigator(true);
        }
        if (ground && swimProgress > 0) {
            swimProgress--;
        }
        if (!ground && swimProgress < 5F) {
            swimProgress++;
        }
        if (!this.level().isClientSide) {
            if (isInWater()) {
                swimTimer++;
            } else {
                swimTimer--;
            }
        }
    }

    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        }
        else {
            super.travel(travelVector);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.level().isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(pId);
        }
    }

    public boolean isEating() {
        return this.eatAnimationTick > 0;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("SwimTimer", this.swimTimer);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.swimTimer = compound.getInt("SwimTimer");
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean shouldEnterWater() {
        return !shouldLeaveWater() && swimTimer <= -1000;
    }

    public boolean shouldLeaveWater() {
        LivingEntity target = this.getTarget();
        if (target != null && !target.isInWater()) {
            return true;
        }
        return swimTimer > 600;
    }

    @Override
    public int getWaterSearchRange() {
        return 12;
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    protected <E extends EntityMarineIguana> PlayState Controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F) && !this.isInWater()) {
            if (this.isSprinting()) {
                event.setAndContinue(MARINE_IGUANA_RUN);
                event.getController().setAnimationSpeed(2.0F);
            } else {
                event.setAndContinue(MARINE_IGUANA_WALK);
            }
        }
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F) && this.isInWater()) {
            event.setAnimation(MARINE_IGUANA_SWIM);
            event.getController().setAnimationSpeed(1.0F);
            return PlayState.CONTINUE;
        }
        else if (this.isInWater()){
            event.setAnimation(MARINE_IGUANA_SWIM_IDLE);
            event.getController().setAnimationSpeed(1.0F);
            return PlayState.CONTINUE;
        }
        else if (random.nextInt(500) == 0){
            float rand = random.nextFloat();
            if (rand < 0.10F) {
                return event.setAndContinue(MARINE_IGUANA_SIT3);
            }
            if (rand < 0.15F) {
                return event.setAndContinue(MARINE_IGUANA_SIT2);
            }
            if (rand < 0.77F) {
                return event.setAndContinue(MARINE_IGUANA_SIT1);
            }
            if (rand < 0.9F) {
                event.setAndContinue(MARINE_IGUANA_IDLE);
            }
            event.getController().forceAnimationReset();
        }
        if (this.isEating()) {
            event.setAndContinue(MARINE_IGUANA_GRAZE);
            return PlayState.CONTINUE;
        }

        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::Controller));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object o) {
        return tickCount;
    }

    @javax.annotation.Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType spawnType, @javax.annotation.Nullable SpawnGroupData spawnGroupData, @javax.annotation.Nullable CompoundTag tag) {
        spawnGroupData = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, spawnGroupData, tag);
        return spawnGroupData;
    }

    public static boolean checkMarineIguanaSpawnRules(EntityType<? extends EntityMarineIguana> dino, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource p_186242_) {
        return isBrightEnoughToSpawn(level, pos);
    }

}
