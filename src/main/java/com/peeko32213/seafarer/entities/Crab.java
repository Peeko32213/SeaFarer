package com.peeko32213.seafarer.entities;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.peeko32213.seafarer.entities.base.EnhancedAnimal;
import com.peeko32213.seafarer.entities.misc.goal.GrazeAlgaeGoal;
import com.peeko32213.seafarer.entities.misc.state.*;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import com.peeko32213.seafarer.registry.SeafarerItems;
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
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class Crab extends EnhancedAnimal implements Bucketable {

    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Boolean> WAVING = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CRAB_CLAWING = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CRAB_BLINKING = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.BOOLEAN);

    private static final EntityAction CRAB_WAVE_ACTION = new EntityAction(0, (e) -> {} ,1);

    private static final StateHelper CRAB_WAVE_STATE =
            StateHelper.Builder.state(WAVING, "crab_waving")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(CRAB_WAVE_ACTION)
                    .build();

    private static final EntityAction CRAB_CLAW_ACTION = new EntityAction(0, (e) -> {} ,1);
    private static final StateHelper CRAB_CLAW_STATE =
            StateHelper.Builder.state(CRAB_CLAWING, "crab_clawing")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .entityAction(CRAB_CLAW_ACTION)
                    .build();

    private static final EntityAction CRAB_BLINK_ACTION = new EntityAction(0, (e) -> {} ,1);
    private static final StateHelper CRAB_BLINK_STATE =
            StateHelper.Builder.state(CRAB_BLINKING, "crab_blinking")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(CRAB_BLINK_ACTION)
                    .build();

    private int eatAnimationTick;

    public Crab(EntityType<? extends EnhancedAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.15F)
                .add(Attributes.ARMOR, 3.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new RandomStateGoal<>(this));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new GrazeAlgaeGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 5.0F, 2.5D, 2.7D, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.08F, 1.25F);
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

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return Bucketable.bucketMobPickup(player, hand, this).orElse(super.mobInteract(player, hand));
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

    public static boolean canDig(LivingEntity entity) {
        BlockPos pos = entity.getOnPos();
        return (entity.level().getBlockState(pos).is(SeafarerBlocks.ALGAE_BLOCK.get()));
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
//        ItemStack stack = new ItemStack(SeafarerItems.CRAB_BUCKET.get());
//        if (this.hasCustomName()) {
//            stack.setHoverName(this.getCustomName());
//        }
//        return stack;
        return null;
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_EMPTY_FISH;
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag tag) {
        spawnGroupData = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, spawnGroupData, tag);
        return spawnGroupData;
    }

    public static boolean checkCrabSpawnRules(EntityType<? extends Crab> dino, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource p_186242_) {
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
