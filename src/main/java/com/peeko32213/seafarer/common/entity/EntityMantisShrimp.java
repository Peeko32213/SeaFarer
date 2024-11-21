package com.peeko32213.seafarer.common.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.peeko32213.seafarer.common.entity.misc.StatedWaterAnimal;
import com.peeko32213.seafarer.common.entity.misc.goal.BottomWalkerFindWaterGoal;
import com.peeko32213.seafarer.common.entity.misc.goal.BottomWalkerPathfinder;
import com.peeko32213.seafarer.common.entity.misc.state.EntityAction;
import com.peeko32213.seafarer.common.entity.misc.state.StateHelper;
import com.peeko32213.seafarer.common.entity.misc.state.WeightedState;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.List;

public class EntityMantisShrimp extends StatedWaterAnimal implements GeoAnimatable, GeoEntity {

    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.mantis_shrimp.idle");
    private static final RawAnimation IDLE_SHAKE = RawAnimation.begin().thenLoop("animation.mantis_shrimp.idle_shake");
    private static final RawAnimation IDLE_MOVE_EYES = RawAnimation.begin().thenLoop("animation.mantis_shrimp.idle_move_eyes");
    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.mantis_shrimp.walk");
    private static final RawAnimation SWIM = RawAnimation.begin().thenLoop("animation.mantis_shrimp.swim");
    private static final RawAnimation RUN = RawAnimation.begin().thenLoop("animation.mantis_shrimp.run");
    private static final RawAnimation BOOST = RawAnimation.begin().thenLoop("animation.mantis_shrimp.boost");
    private static final RawAnimation PUNCH = RawAnimation.begin().thenPlay("animation.mantis_shrimp.punch");

    private static final EntityDataAccessor<Boolean> MANTIS_IDLE_SHAKE = SynchedEntityData.defineId(EntityMantisShrimp.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> MANTIS_IDLE_MOVE_EYES = SynchedEntityData.defineId(EntityMantisShrimp.class, EntityDataSerializers.BOOLEAN);

    private static final EntityAction MANTIS_IDLE_SHAKE_ACTION = new EntityAction(0, (e) -> { return; } ,1);

    private static final StateHelper MANTIS_IDLE_SHAKE_STATE =
            StateHelper.Builder.state(MANTIS_IDLE_SHAKE, "idle_shake")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(MANTIS_IDLE_SHAKE_ACTION)
                    .build();

    private static final EntityAction MANTIS_IDLE_MOVE_EYES_ACTION = new EntityAction(0, (e) -> { return; } ,1);

    private static final StateHelper MANTIS_IDLE_MOVE_EYES_STATE =
            StateHelper.Builder.state(MANTIS_IDLE_MOVE_EYES, "idle_shake")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(MANTIS_IDLE_MOVE_EYES_ACTION)
                    .build();

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public EntityMantisShrimp(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.26F)
                .add(Attributes.ATTACK_DAMAGE, 300.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 5.0)
                .add(Attributes.ARMOR, 1.0D)
                ;

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new BottomWalkerFindWaterGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, false, false, entity -> entity.getType().is(getTargetTag())));

    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.is(this);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MANTIS_IDLE_SHAKE, false);
        this.entityData.define(MANTIS_IDLE_MOVE_EYES, false);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        BottomWalkerPathfinder crab = new BottomWalkerPathfinder(this, worldIn) {
            public boolean isStableDestination(BlockPos pos) {
                return this.level.getBlockState(pos).getFluidState().isEmpty();
            }
        };
        return crab;
    }

    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.4D));
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.08D, 0.0D));
        } else {
            super.travel(travelVector);
        }

    }

    protected TagKey<EntityType<?>> getTargetTag() {
        return SFTags.MANTIS_SHRIMP_TARGETS;
    }

    protected <E extends EntityMantisShrimp> PlayState controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
            if (this.isSprinting()) {
                event.setAndContinue(RUN);
                event.getController().setAnimationSpeed(2.0D);
                return PlayState.CONTINUE;
            } else if (event.isMoving()) {
                event.setAndContinue(WALK);
                event.getController().setAnimationSpeed(1.0D);
                return PlayState.CONTINUE;
            }
        }
        if(getBooleanState(MANTIS_IDLE_MOVE_EYES)) {
            return event.setAndContinue(IDLE_MOVE_EYES);
        }
        if(getBooleanState(MANTIS_IDLE_SHAKE)) {
            return event.setAndContinue(IDLE_SHAKE);
        }

        return event.setAndContinue(IDLE);
    }

    protected <E extends EntityMantisShrimp> PlayState attackController(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (this.swinging) {
            event.setAndContinue(PUNCH);
            return PlayState.CONTINUE;

        }
        event.getController().forceAnimationReset();
        return PlayState.STOP;
    }



    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Normal", 5, this::controller));
        controllers.add(new AnimationController<>(this, "Attack", 5, this::attackController));
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
    public ImmutableMap<String, StateHelper> getStates() {
        return ImmutableMap.of(
                MANTIS_IDLE_SHAKE_STATE.getName(), MANTIS_IDLE_SHAKE_STATE,
                MANTIS_IDLE_MOVE_EYES_STATE.getName(), MANTIS_IDLE_MOVE_EYES_STATE
        );
    }

    @Override
    public List<WeightedState<StateHelper>> getWeightedStatesToPerform() {
        return ImmutableList.of(
                WeightedState.of(MANTIS_IDLE_MOVE_EYES_STATE, 77),
                WeightedState.of(MANTIS_IDLE_SHAKE_STATE, 15)
        );
    }
}

