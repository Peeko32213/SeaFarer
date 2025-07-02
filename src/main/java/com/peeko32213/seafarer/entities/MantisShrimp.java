package com.peeko32213.seafarer.entities;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.peeko32213.seafarer.entities.misc.StatedWaterAnimal;
import com.peeko32213.seafarer.entities.misc.goal.BottomWalkerPathfinder;
import com.peeko32213.seafarer.entities.misc.state.EntityAction;
import com.peeko32213.seafarer.entities.misc.state.StateHelper;
import com.peeko32213.seafarer.entities.misc.state.WeightedState;
import com.peeko32213.seafarer.registry.tags.SeafarerTags;
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

import java.util.EnumSet;
import java.util.List;

public class MantisShrimp extends StatedWaterAnimal {

    private static final EntityDataAccessor<Boolean> MANTIS_IDLE_SHAKE = SynchedEntityData.defineId(MantisShrimp.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> MANTIS_IDLE_MOVE_EYES = SynchedEntityData.defineId(MantisShrimp.class, EntityDataSerializers.BOOLEAN);

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

    public MantisShrimp(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.16F)
                .add(Attributes.ATTACK_DAMAGE, 300.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 5.0)
                .add(Attributes.ARMOR, 1.0D)
                ;

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MantisShrimp.WanderGoal());
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
        return SeafarerTags.MANTIS_SHRIMP_TARGETS;
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

    private class WanderGoal extends Goal {

        private double x;
        private double y;
        private double z;

        public WanderGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (MantisShrimp.this.getRandom().nextInt(50) != 0) {
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
            double dist = MantisShrimp.this.distanceToSqr(x, y, z);
            return dist > 4F;
        }

        public void tick() {
            MantisShrimp.this.getNavigation().moveTo(this.x, this.y, this.z, 1F);
        }

        public BlockPos findWaterBlock() {
            BlockPos result = null;
            RandomSource random = MantisShrimp.this.getRandom();
            int range = 10;
            for (int i = 0; i < 15; i++) {
                BlockPos blockPos = MantisShrimp.this.blockPosition().offset(random.nextInt(range) - range / 2, random.nextInt(range) - range / 2, random.nextInt(range) - range / 2);
                if (MantisShrimp.this.level().getFluidState(blockPos).is(FluidTags.WATER) && blockPos.getY() > level().getMinBuildHeight() + 1) {
                    result = blockPos;
                }
            }
            return result;
        }

        @javax.annotation.Nullable
        protected Vec3 getPosition() {
            BlockPos water = findWaterBlock();
            if (MantisShrimp.this.isInWaterOrBubble()) {
                if (water == null) {
                    return null;
                }
                while (MantisShrimp.this.level().getFluidState(water.below()).is(FluidTags.WATER) && water.getY() > level().getMinBuildHeight() + 1) {
                    water = water.below();
                }
                water = water.above();
                return Vec3.atCenterOf(water);
            } else {
                return water == null ? DefaultRandomPos.getPos(MantisShrimp.this, 7, 3) : Vec3.atCenterOf(water);

            }
        }
    }
    
}

