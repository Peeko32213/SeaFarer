package com.peeko32213.seafarer.common.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.peeko32213.seafarer.common.entity.misc.StatedWaterAnimal;
import com.peeko32213.seafarer.common.entity.misc.goal.BottomWalkerPathfinder;
import com.peeko32213.seafarer.common.entity.misc.state.EntityAction;
import com.peeko32213.seafarer.common.entity.misc.state.StateHelper;
import com.peeko32213.seafarer.common.entity.misc.state.WeightedState;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
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

public class SpiderCrabEntity extends StatedWaterAnimal implements GeoAnimatable, GeoEntity {

    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.spider_crab.idle1");
    private static final RawAnimation GRAZING = RawAnimation.begin().thenLoop("animation.spider_crab.grazing");
    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.spider_crab.walk");
    private static final RawAnimation PUNCH = RawAnimation.begin().thenPlay("animation.spider_crab.attack");

    private static final EntityDataAccessor<Boolean> SPIDER_CRAB_GRAZE = SynchedEntityData.defineId(SpiderCrabEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityAction SPIDER_CRAB_GRAZING_ACTION = new EntityAction(0, (e) -> { return; } ,1);

    private static final StateHelper SPIDER_CRAB_SHAKE_STATE =
            StateHelper.Builder.state(SPIDER_CRAB_GRAZE, "grazing")
                    .playTime(60)
                    .stopTime(100)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(SPIDER_CRAB_GRAZING_ACTION)
                    .build();

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SpiderCrabEntity(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 45.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.2F)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0)
                .add(Attributes.ARMOR, 10.0D)
                ;

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new WanderGoal());
        this.goalSelector.addGoal(4, new SpiderCrabEntity.SpiderCrabMeleeAttackGoal());
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, false, false, entity -> entity.getType().is(getTargetTag())));

    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return pEntity.is(this);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SPIDER_CRAB_GRAZE, false);
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

    class SpiderCrabMeleeAttackGoal extends MeleeAttackGoal {
        public SpiderCrabMeleeAttackGoal() {
            super(SpiderCrabEntity.this, 1.0D, true);
        }

        protected double getAttackReachSqr(LivingEntity pAttackTarget) {
            float f = SpiderCrabEntity.this.getBbWidth() - 0.1F;
            return (double)(f * 2.0F * f * 2.0F + pAttackTarget.getBbWidth());
        }
    }

    protected TagKey<EntityType<?>> getTargetTag() {
        return SFTags.MANTIS_SHRIMP_TARGETS;
    }

    protected <E extends SpiderCrabEntity> PlayState controller(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F)) {
            event.setAndContinue(WALK);
            return PlayState.CONTINUE;
        }
        if(getBooleanState(SPIDER_CRAB_GRAZE)) {
            return event.setAndContinue(GRAZING);
        }

        return event.setAndContinue(IDLE);
    }

    protected <E extends SpiderCrabEntity> PlayState attackController(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
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
                SPIDER_CRAB_SHAKE_STATE.getName(), SPIDER_CRAB_SHAKE_STATE
        );
    }

    @Override
    public List<WeightedState<StateHelper>> getWeightedStatesToPerform() {
        return ImmutableList.of(
                WeightedState.of(SPIDER_CRAB_SHAKE_STATE, 77)
        );
    }

    private class WanderGoal extends Goal {

        private double x;
        private double y;
        private double z;

        public WanderGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (SpiderCrabEntity.this.getRandom().nextInt(50) != 0) {
                return false;
            }
            Vec3 target = this.getPosition();
            if (target == null) {
                return false;
            } else {
                this.x = target.x;
                this.y = target.y;
                this.z = target.z;
                return true;
            }
        }

        public boolean canContinueToUse() {
            double dist = SpiderCrabEntity.this.distanceToSqr(x, y, z);
            return dist > 4F;
        }

        public void tick() {
            SpiderCrabEntity.this.getNavigation().moveTo(this.x, this.y, this.z, 1F);
        }

        public BlockPos findWaterBlock() {
            BlockPos result = null;
            RandomSource random = SpiderCrabEntity.this.getRandom();
            int range = 10;
            for (int i = 0; i < 15; i++) {
                BlockPos blockPos = SpiderCrabEntity.this.blockPosition().offset(random.nextInt(range) - range / 2, random.nextInt(range) - range / 2, random.nextInt(range) - range / 2);
                if (SpiderCrabEntity.this.level().getFluidState(blockPos).is(FluidTags.WATER) && blockPos.getY() > level().getMinBuildHeight() + 1) {
                    result = blockPos;
                }
            }
            return result;
        }

        @javax.annotation.Nullable
        protected Vec3 getPosition() {
            BlockPos water = findWaterBlock();
            if (SpiderCrabEntity.this.isInWaterOrBubble()) {
                if (water == null) {
                    return null;
                }
                while (SpiderCrabEntity.this.level().getFluidState(water.below()).is(FluidTags.WATER) && water.getY() > level().getMinBuildHeight() + 1) {
                    water = water.below();
                }
                water = water.above();
                return Vec3.atCenterOf(water);
            } else {
                return water == null ? DefaultRandomPos.getPos(SpiderCrabEntity.this, 7, 3) : Vec3.atCenterOf(water);

            }
        }
    }
}

