package com.peeko32213.seafarer.entities;

import com.google.common.collect.ImmutableMap;
import com.peeko32213.seafarer.entities.misc.StatedWaterAnimal;
import com.peeko32213.seafarer.entities.misc.goal.BottomWalkerFindWaterGoal;
import com.peeko32213.seafarer.entities.misc.goal.BottomWalkerPathfinder;
import com.peeko32213.seafarer.entities.misc.state.StateHelper;
import com.peeko32213.seafarer.entities.misc.state.WeightedState;
import com.peeko32213.seafarer.registry.tags.SeafarerTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;

public class LeafyScorpionfish extends StatedWaterAnimal {

    private static final EntityDataAccessor<Boolean> IS_SWALLOWING = SynchedEntityData.defineId(LeafyScorpionfish.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LURE = SynchedEntityData.defineId(LeafyScorpionfish.class, EntityDataSerializers.BOOLEAN);

    private int eatCooldown = 0;

    public LeafyScorpionfish(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 3.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.10D);

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new BottomWalkerFindWaterGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(2, new LeafyScorpionfish.EatFoodGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, false, false, entity -> entity.getType().is(getTargetTag())));
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

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_SWALLOWING, false);
        this.entityData.define(LURE, false);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setIsSwallowing(compound.getBoolean("swallowing"));

    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("swallowing", this.isSwallowing());
    }

    public boolean isSwallowing() {
        return this.entityData.get(IS_SWALLOWING);
    }

    public void setIsSwallowing(boolean swallowing) {
        this.entityData.set(IS_SWALLOWING, swallowing);
    }


    protected TagKey<EntityType<?>> getTargetTag() {
        return SeafarerTags.FROGFISH_TARGETS;
    }

    public void tick() {
        super.tick();
        if(eatCooldown > 0){
            eatCooldown--;
        }
    }

    @Override
    public ImmutableMap<String, StateHelper> getStates() {
        return null;
    }

    @Override
    public List<WeightedState<StateHelper>> getWeightedStatesToPerform() {
        return null;
    }


    class EatFoodGoal extends Goal {

        private final LeafyScorpionfish beelzebufo;
        private Entity food;

        private int executionCooldown = 50;


        public EatFoodGoal (LeafyScorpionfish beelzebufo){
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
            this.beelzebufo = beelzebufo;
        }

        @Override
        public boolean canUse() {
            if (beelzebufo.eatCooldown > 0) {
                return false;
            }
            if (executionCooldown > 0) {
                executionCooldown--;
            } else {
                executionCooldown = 50 + random.nextInt(50);
                final List<Entity> list = beelzebufo.level().getEntitiesOfClass(Entity.class, beelzebufo.getBoundingBox().inflate(8, 8, 8), EntitySelector.NO_SPECTATORS.and(entity -> entity != beelzebufo && beelzebufo.isFood(entity)));
                if (!list.isEmpty()) {
                    food = list.get(0);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean canContinueToUse() {
            return food != null && food.isAlive();
        }

        public void stop() {
            executionCooldown = 5;
            setIsSwallowing(false);
        }

        @Override
        public void tick() {
            beelzebufo.getNavigation().moveTo(food.getX(), food.getY(0.5F), food.getZ(), 1.0F);
            beelzebufo.lookAt(food, 10F, 10F);
            final float eatDist = beelzebufo.getBbWidth() * 0.65F + food.getBbWidth();
            if (beelzebufo.distanceTo(food) < eatDist + 3 && beelzebufo.hasLineOfSight(food)) {
                //final Vec3 delta = beelzebufo.getMouthVec().subtract(food.position()).normalize().scale(0.1F);
                //food.setDeltaMovement(food.getDeltaMovement().add(delta));
                if (beelzebufo.distanceTo(food) < eatDist) {
                    if (food instanceof Player) {
                        food.hurt(this.beelzebufo.damageSources().mobAttack(beelzebufo), 12000);
                    } else if (beelzebufo.swallowEntity(food)) {
                        beelzebufo.gameEvent(GameEvent.EAT);
                        beelzebufo.playSound(SoundEvents.GENERIC_EAT, beelzebufo.getSoundVolume(), beelzebufo.getVoicePitch());
                        food.discard();
                    }
                }
            }
        }

    }

    private boolean isFood(Entity entity) {
        return entity instanceof Mob && !(entity instanceof LeafyScorpionfish) && entity.getBbHeight() <= 1.0F;
    }

    public boolean swallowEntity(Entity entity) {
        this.setIsSwallowing(true);
        if (entity instanceof final LivingEntity mob) {
            if(!entity.level().isClientSide) {
                ExperienceOrb.award((ServerLevel) entity.level(), entity.position(), ((LivingEntity) entity).getExperienceReward());
                mob.remove(RemovalReason.KILLED);
            }
            this.gameEvent(GameEvent.EAT);
            this.playSound(SoundEvents.GENERIC_EAT, this.getSoundVolume(), this.getVoicePitch());
            //setIsSwallowing(false);
            return true;
        }
        if (entity instanceof final ItemEntity item) {
            this.pickUpItem(item);
        }
        return false;
    }
}
