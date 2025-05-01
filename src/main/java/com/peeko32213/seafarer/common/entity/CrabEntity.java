package com.peeko32213.seafarer.common.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.peeko32213.seafarer.common.entity.misc.goal.GrazeAlgaeGoal;
import com.peeko32213.seafarer.common.entity.misc.StatedAnimal;
import com.peeko32213.seafarer.common.entity.misc.state.*;
import com.peeko32213.seafarer.core.registry.blocks.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.List;

public class CrabEntity extends StatedAnimal implements GeoAnimatable, Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(CrabEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation CRAB_IDLE = RawAnimation.begin().thenLoop("animation.crab.idle");
    private static final RawAnimation CRAB_WALK = RawAnimation.begin().thenLoop("animation.crab.walk");
    private static final RawAnimation CRAB_SPRINT_1 = RawAnimation.begin().thenLoop("animation.crab.sprint1");
    private static final RawAnimation CRAB_SPRINT_2 = RawAnimation.begin().thenLoop("animation.crab.sprint2");
    private static final RawAnimation CRAB_SWIM = RawAnimation.begin().thenLoop("animation.crab.swim");

    private static final RawAnimation CRAB_GRAZE = RawAnimation.begin().thenLoop("animation.crab.graze");


    private static final RawAnimation CRAB_DANCE = RawAnimation.begin().thenLoop("animation.crab.dance");
    private static final RawAnimation CRAB_BLINK = RawAnimation.begin().thenLoop("animation.crab.blink");
    private static final RawAnimation CRAB_CLAW = RawAnimation.begin().thenLoop("animation.crab.claw");
    private static final RawAnimation CRAB_WAVE = RawAnimation.begin().thenLoop("animation.crab.wave");
    private static final EntityDataAccessor<Boolean> GRAZE = SynchedEntityData.defineId(CrabEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> WAVING = SynchedEntityData.defineId(CrabEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CRAB_CLAWING = SynchedEntityData.defineId(CrabEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CRAB_BLINKING = SynchedEntityData.defineId(CrabEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityAction CRAB_WAVE_ACTION = new EntityAction(0, (e) -> { return; } ,1);

    private static final StateHelper CRAB_WAVE_STATE =
            StateHelper.Builder.state(WAVING, "crab_waving")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(CRAB_WAVE_ACTION)
                    .build();

    private static final EntityAction CRAB_CLAW_ACTION = new EntityAction(0, (e) -> { return; } ,1);

    private static final StateHelper CRAB_CLAW_STATE =
            StateHelper.Builder.state(CRAB_CLAWING, "crab_clawing")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .entityAction(CRAB_CLAW_ACTION)
                    .build();

    private static final EntityAction CRAB_BLINK_ACTION = new EntityAction(0, (e) -> { return; } ,1);


    private static final StateHelper CRAB_BLINK_STATE =
            StateHelper.Builder.state(CRAB_BLINKING, "crab_blinking")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(CRAB_BLINK_ACTION)
                    .build();



    private GrazeAlgaeGoal eatBlockGoal;
    private int eatAnimationTick;
    public CrabEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.15D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 2.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
    }

    @Override
    protected void registerGoals() {
        this.eatBlockGoal = new GrazeAlgaeGoal(this);
        this.goalSelector.addGoal(2, this.eatBlockGoal);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 5.0F, 2.5D, 2.7D, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new RandomStateGoal<>(this));

    }

    protected void playStepSound(BlockPos p_28301_, BlockState p_28302_) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }


    @Override
    public void aiStep() {
        super.aiStep();

        if (this.level().isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }
    }

    public InteractionResult mobInteract(Player p_27477_, InteractionHand p_27478_) {
        return Bucketable.bucketMobPickup(p_27477_, p_27478_, this).orElse(super.mobInteract(p_27477_, p_27478_));
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

    private boolean isStillEnough() {
        return this.getDeltaMovement().horizontalDistance() < 0.05;
    }

    public static boolean canDig(LivingEntity entity) {
        BlockPos pos = entity.getOnPos();
        return (entity.level().getBlockState(pos).is(SFBlocks.ALGAE_BLOCK.get()));
    }

    protected <E extends CrabEntity> PlayState Controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F) && !this.isInWater()) {
            if (this.isSprinting()) {
                event.setAndContinue(CRAB_SPRINT_1);
                event.getController().setAnimationSpeed(2.0F);
                return PlayState.CONTINUE;
            } else  {
                event.setAndContinue(CRAB_WALK);
                return PlayState.CONTINUE;
            }
        }
        if (this.isInWater()) {
            event.setAndContinue(CRAB_SWIM);
            event.getController().setAnimationSpeed(1.0F);
            return PlayState.CONTINUE;
        }

        if(getBooleanState(CRAB_BLINKING)) {
            return event.setAndContinue(CRAB_BLINK);
        }
        if(getBooleanState(CRAB_CLAWING)) {
            return event.setAndContinue(CRAB_CLAW);
        }
        if(getBooleanState(WAVING)) {
            return event.setAndContinue(CRAB_WAVE);
        }


        return event.setAndContinue(CRAB_IDLE);
    }

    protected <E extends CrabEntity> PlayState eatController(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (this.isEating()) {
            event.setAndContinue(CRAB_GRAZE);
            return PlayState.CONTINUE;
        }
        event.getController().forceAnimationReset();
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::Controller));
        controllers.add(new AnimationController<>(this, "Graze", 5, this::eatController));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object o) {
        return tickCount;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
        this.entityData.define(CRAB_BLINKING, false);
        this.entityData.define(CRAB_CLAWING, false);
        this.entityData.define(WAVING, false);

    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromBucket", this.fromBucket());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }


    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean p_203706_1_) {
        this.entityData.set(FROM_BUCKET, p_203706_1_);
    }

    @Override
    public void saveToBucketTag(ItemStack bucket) {
        CompoundTag compoundnbt = bucket.getOrCreateTag();
        Bucketable.saveDefaultDataToBucketTag(this, bucket);
        compoundnbt.putFloat("Health", this.getHealth());
        if (this.hasCustomName()) {
            bucket.setHoverName(this.getCustomName());
        }
    }
    public void loadFromBucketTag(CompoundTag pTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, pTag);
    }

    @Override
    public ItemStack getBucketItemStack() {
        ItemStack stack = new ItemStack(SFItems.SHORE_CRAB_BUCKET.get());
        if (this.hasCustomName()) {
            stack.setHoverName(this.getCustomName());
        }
        return stack;
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_EMPTY_FISH;
    }

    @javax.annotation.Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType spawnType, @javax.annotation.Nullable SpawnGroupData spawnGroupData, @javax.annotation.Nullable CompoundTag tag) {
        spawnGroupData = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, spawnGroupData, tag);
        return spawnGroupData;
    }

    public static boolean checkCrabSpawnRules(EntityType<? extends CrabEntity> dino, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource p_186242_) {
        return isBrightEnoughToSpawn(level, pos);
    }




    @Override
    public ImmutableMap<String, StateHelper> getStates() {
        return ImmutableMap.of(
                CRAB_BLINK_STATE.getName(), CRAB_BLINK_STATE,
                CRAB_CLAW_STATE.getName(), CRAB_CLAW_STATE,
                CRAB_WAVE_STATE.getName(), CRAB_WAVE_STATE
        );
    }

    @Override
    public List<WeightedState<StateHelper>> getWeightedStatesToPerform() {
        return ImmutableList.of(
                WeightedState.of(CRAB_BLINK_STATE, 77),
                WeightedState.of(CRAB_CLAW_STATE, 15),
                WeightedState.of(CRAB_WAVE_STATE, 10)
        );
    }
}
