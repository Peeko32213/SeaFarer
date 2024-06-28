package com.peeko32213.seafarer.common.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.peeko32213.seafarer.common.entity.goal.NocturnalSleepingGoal;
import com.peeko32213.seafarer.common.entity.misc.AbstractSleepingAnimal;
import com.peeko32213.seafarer.common.entity.misc.state.StateHelper;
import com.peeko32213.seafarer.common.entity.misc.state.WeightedState;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class EntityHorseshoeCrab extends AbstractSleepingAnimal implements GeoAnimatable {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final RawAnimation HORSESHOE_CRAB_WALK = RawAnimation.begin().thenLoop("animation.horseshoecrab.walk");
    private static final RawAnimation HORSESHOE_CRAB_IDLE = RawAnimation.begin().thenLoop("animation.horseshoecrab.idle");
    private static final RawAnimation HORSESHOE_CRAB_BURROW = RawAnimation.begin().thenLoop("animation.horseshoecrab.burrow");
    private static final RawAnimation HORSESHOE_CRAB_BURROW_IDLE = RawAnimation.begin().thenLoop("animation.horseshoecrab.idle_burrow");



    public EntityHorseshoeCrab(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.13D)
                .add(Attributes.ARMOR, 10.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 10.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 5.5D);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    public void aiStep() {
        super.aiStep();
    }

        protected <E extends EntityHorseshoeCrab> PlayState Controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F && !this.isAsleep())) {
            event.setAndContinue(HORSESHOE_CRAB_WALK);
            return PlayState.CONTINUE;
        }
        if (!this.isAsleep()) {
            event.setAndContinue(HORSESHOE_CRAB_IDLE);
        }
        return PlayState.CONTINUE;
    }

    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.isAsleep()) {
            Entity entity = pSource.getDirectEntity();
            if (entity instanceof AbstractArrow) {
                return false;
            }
        }
        return super.hurt(pSource, pAmount);
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return this.isAsleep() ? SoundEvents.SHIELD_BLOCK : SoundEvents.SHIELD_BREAK;
    }


    protected <E extends EntityHorseshoeCrab> PlayState digController(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (this.isAsleep()) {
            event.setAndContinue(HORSESHOE_CRAB_BURROW_IDLE);
            return PlayState.CONTINUE;
        }
        event.getController().forceAnimationReset();
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::Controller));
        controllers.add(new AnimationController<>(this, "Dig", 5, this::digController));
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
        return super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, spawnGroupData, tag);
    }

    public static boolean checkHorseshoeCrabSpawnRules(EntityType<? extends EntityHorseshoeCrab> dino, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource p_186242_) {
        return isBrightEnoughToSpawn(level, pos);
    }

    @Override
    public ImmutableMap<String, StateHelper> getStates() {
        return ImmutableMap.of();
    }

    @Override
    public List<WeightedState<StateHelper>> getWeightedStatesToPerform() {
        return ImmutableList.of();
    }
}
