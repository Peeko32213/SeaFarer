package com.peeko32213.seafarer.common.entity;

import com.peeko32213.seafarer.common.entity.misc.EntitySFBoidFish;
import com.peeko32213.seafarer.core.registry.SFItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nonnull;

public class EntitySquirrelfish extends EntitySFBoidFish implements Bucketable, GeoAnimatable{
    
    private static final RawAnimation SQUIRREL_FISH_SWIM = RawAnimation.begin().thenLoop("animation.squirrelfish.swim");
    private static final RawAnimation SQUIRREL_FISH_FLOP = RawAnimation.begin().thenLoop("animation.squirrelfish.idle_flopping");
    private static final RawAnimation SQUIRREL_FISH_IDLE = RawAnimation.begin().thenLoop("animation.squirrelfish.idle_inplace");

    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(EntitySquirrelfish.class, EntityDataSerializers.BOOLEAN);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


    public EntitySquirrelfish(EntityType<? extends EntitySFBoidFish> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02f, 0.1f, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0);
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {

        if (pEntity instanceof LivingEntity livingEntity && this.isAlive() && pEntity.isAlive()) {
            if (!(livingEntity instanceof EntitySquirrelfish)) {
                this.touch(livingEntity);
                return true;
            }
        }

        return super.canCollideWith(pEntity);
    }

    private void touch(LivingEntity pMob) {
        pMob.hurt(this.damageSources().mobAttack(this), (float) (5.0D));
    }

    @Override
    public int getMaxSchoolSize() {
        return 15;
    }

    protected InteractionResult mobInteract(Player p_27477_, InteractionHand p_27478_) {
        return Bucketable.bucketMobPickup(p_27477_, p_27478_, this).orElse(super.mobInteract(p_27477_, p_27478_));
    }

    @Override
    public ItemStack getBucketItemStack() {
        ItemStack stack = new ItemStack(SFItems.SQUIRRELFISH_BUCKET.get());
        if (this.hasCustomName()) {
            stack.setHoverName(this.getCustomName());
        }
        return stack;
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_EMPTY_FISH;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.COD_HURT;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }

    @Override
    public void saveToBucketTag(@Nonnull ItemStack bucket) {
        if (this.hasCustomName()) {
            bucket.setHoverName(this.getCustomName());
        }
        Bucketable.saveDefaultDataToBucketTag(this, bucket);
        CompoundTag compoundnbt = bucket.getOrCreateTag();
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

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
        return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }


    protected <E extends EntitySquirrelfish> PlayState Controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F) && this.isInWater()) {
            event.setAndContinue(SQUIRREL_FISH_SWIM);
            return PlayState.CONTINUE;
        }
        if (!this.isInWater()) {
            event.setAndContinue(SQUIRREL_FISH_FLOP);
            return PlayState.CONTINUE;
        }
        else {
            event.setAndContinue(SQUIRREL_FISH_IDLE);
            return PlayState.CONTINUE;
        }
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
}
