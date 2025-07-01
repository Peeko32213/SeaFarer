package com.peeko32213.seafarer.entities;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.peeko32213.seafarer.entities.base.SemiAquaticAnimal;
import com.peeko32213.seafarer.entities.misc.goal.*;
import com.peeko32213.seafarer.entities.misc.interfaces.Brushable;
import com.peeko32213.seafarer.entities.misc.state.EntityAction;
import com.peeko32213.seafarer.entities.misc.state.RandomStateGoal;
import com.peeko32213.seafarer.entities.misc.state.StateHelper;
import com.peeko32213.seafarer.entities.misc.state.WeightedState;
import com.peeko32213.seafarer.entities.misc.util.SmartBodyHelper;
import com.peeko32213.seafarer.registry.SeafarerItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class MarineIguanaEntity extends SemiAquaticAnimal implements Brushable, IForgeShearable {

    private static final EntityDataAccessor<Integer> SALT = SynchedEntityData.defineId(MarineIguanaEntity.class, EntityDataSerializers.INT);

    private GrazeAlgaeGoal eatBlockGoal;
    private int eatAnimationTick;
    private int SaltTime = 0;

    private Level level;

    private static final RawAnimation MARINE_IGUANA_WALK = RawAnimation.begin().thenLoop("animation.marineiguana.walk");
    private static final RawAnimation MARINE_IGUANA_RUN = RawAnimation.begin().thenLoop("animation.marineiguana.run");
    private static final RawAnimation MARINE_IGUANA_IDLE = RawAnimation.begin().thenLoop("animation.marineiguana.idle");
    private static final RawAnimation MARINE_IGUANA_SIT1 = RawAnimation.begin().thenLoop("animation.marineiguana.sit1");
    private static final RawAnimation MARINE_IGUANA_SIT2 = RawAnimation.begin().thenLoop("animation.marineiguana.sit2");
    private static final RawAnimation MARINE_IGUANA_SIT3 = RawAnimation.begin().thenLoop("animation.marineiguana.sit3");
    private static final RawAnimation MARINE_IGUANA_SWIM = RawAnimation.begin().thenLoop("animation.marineiguana.swim");
    private static final RawAnimation MARINE_IGUANA_SWIM_IDLE = RawAnimation.begin().thenLoop("animation.marineiguana.swim_idle");
    private static final RawAnimation MARINE_IGUANA_SNEEZE = RawAnimation.begin().thenPlay("animation.marineiguana.sneeze");
    private static final RawAnimation MARINE_IGUANA_GRAZE = RawAnimation.begin().thenPlay("animation.marineiguana.graze");

    private static final EntityDataAccessor<Boolean> SIT_1 = SynchedEntityData.defineId(MarineIguanaEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SIT_2 = SynchedEntityData.defineId(MarineIguanaEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SIT_3 = SynchedEntityData.defineId(MarineIguanaEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SNEEZE = SynchedEntityData.defineId(MarineIguanaEntity.class, EntityDataSerializers.BOOLEAN);

    // Starting predicates
    private static final Predicate<LivingEntity> IGUANA_STARTING_PREDICATE = (e -> {
        if(e instanceof MarineIguanaEntity entity) {
            return !entity.isSprinting() && !entity.isInWater();
        }
        return false;
    });

    private static final Predicate<LivingEntity> IGUANA_SNEEZE_PREDICATE = (e -> {
        if(e instanceof MarineIguanaEntity entity) {
            return !entity.isSprinting() && !entity.isInWater() && entity.canBeBrushed();
        }
        return false;
    });

    private static final EntityAction IGUANA_SIT_1_ACTION = new EntityAction(0, (e) -> {} ,1);
    private static final StateHelper IGUANA_SIT_1_STATE =
            StateHelper.Builder.state(SIT_1, "iguana_sit_1")
                    .playTime(140)
                    .stopTime(280)
                    .startingPredicate(IGUANA_STARTING_PREDICATE)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(IGUANA_SIT_1_ACTION)
                    .build();

    private static final EntityAction IGUANA_SIT_2_ACTION = new EntityAction(0, (e) -> {} ,1);
    private static final StateHelper IGUANA_SIT_2_STATE =
            StateHelper.Builder.state(SIT_2, "iguana_sit_2")
                    .playTime(140)
                    .stopTime(280)
                    .startingPredicate(IGUANA_STARTING_PREDICATE)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(IGUANA_SIT_2_ACTION)
                    .build();

    private static final EntityAction IGUANA_SIT_3_ACTION = new EntityAction(0, (e) -> {} ,1);
    private static final StateHelper IGUANA_SIT_3_STATE =
            StateHelper.Builder.state(SIT_3, "iguana_sit_3")
                    .playTime(140)
                    .stopTime(280)
                    .startingPredicate(IGUANA_STARTING_PREDICATE)
                    .affectsAI(true)
                    .affectedFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK))
                    .entityAction(IGUANA_SIT_3_ACTION)
                    .build();

    private static final EntityAction IGUANA_SNEEZE_ACTION = new EntityAction(0, (e) -> {} ,1);
    private static final StateHelper IGUANA_SNEEZE_STATE =
            StateHelper.Builder.state(SNEEZE, "iguana_sneeze")
                    .playTime(20)
                    .stopTime(180)
                    .startingPredicate(IGUANA_SNEEZE_PREDICATE)
                    .entityAction(IGUANA_SNEEZE_ACTION)
                    .build();

    // Body control / navigation
    @Override
    protected @NotNull BodyRotationControl createBodyControl() {
        SmartBodyHelper helper = new SmartBodyHelper(this);
        helper.bodyLagMoving = 0.5F;
        helper.bodyLagStill = 0.25F;
        return helper;
    }

    public MarineIguanaEntity(EntityType<? extends SemiAquaticAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 16.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.12F);
    }

    protected void registerGoals() {
        this.eatBlockGoal = new GrazeAlgaeGoal(this);
        this.goalSelector.addGoal(2, this.eatBlockGoal);
        this.goalSelector.addGoal(0, new RandomStateGoal<>(this));
        this.goalSelector.addGoal(4, new BigPanicGoal(this, 2.1D));
        this.goalSelector.addGoal(7, new FindWaterGoal(this));
        this.goalSelector.addGoal(7, new LeaveWaterGoal(this));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(9, new SemiAquaticSwimmingGoal(this, 1.0D, 60));
        this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1.0D, 60));
    }

    public float getStepHeight() {
        if (this.isRunning() || this.isInWater()) {
            return 1.25F;
        }
        return 0.6F;
    }

    public void tick() {
        super.tick();

        if (this.isInWater()) {
            SaltTime++;
        }
        if (this.isAlive() && SaltTime > 2000) {
            SaltTime = 0;
            this.setSalt(Math.min(10, this.getSalt() + 1));
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
        this.entityData.define(SALT, 0);
        this.entityData.define(SIT_1, false);
        this.entityData.define(SIT_2, false);
        this.entityData.define(SIT_3, false);
        this.entityData.define(SNEEZE, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("SaltTime", this.SaltTime);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.SaltTime = compound.getInt("SaltTime");
    }

    public int getSalt() {
        return this.entityData.get(SALT);
    }

    public void setSalt(int Salt) {
        this.entityData.set(SALT, Salt);
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

    protected void playStepSound(BlockPos pos, BlockState state) {
        if (this.isInWater()) {

        }
        else {
            SoundType soundtype = state.getSoundType(this.level, pos, this);
            this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag tag) {
        spawnGroupData = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, spawnGroupData, tag);
        return spawnGroupData;
    }

    public static boolean checkMarineIguanaSpawnRules(EntityType<? extends MarineIguanaEntity> iguana, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource p_186242_) {
        return isBrightEnoughToSpawn(level, pos);
    }

    @Override
    public void startBrusing() {
    }

    @Override
    public void endBrushing() {
    }

    @Override
    public boolean isBrushable(Player player, @NotNull ItemStack item, Level level, BlockPos pos) {
        return canBeBrushed();
    }

    public boolean canBeBrushed() {
        return this.isAlive() && this.getSalt() > 0;
    }

    @Override
    public List<ItemStack> brush(long gameTime, Player player, Direction direction, ItemStack stack, Level level, BlockPos pos, int fortune) {
        level.playSound(null, this, SoundEvents.BRUSH_GENERIC, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
        this.gameEvent(GameEvent.ENTITY_INTERACT);
        if (!level.isClientSide()) {
            if (random.nextFloat() < this.getSalt() * 0.05F) {
                ItemStack stack1 = SeafarerItems.SEA_SALT.get().getDefaultInstance();
                stack1.setCount(getSalt());
                return Collections.singletonList(stack1);
            }
        }
        setSalt(0);
        return java.util.Collections.emptyList();
    }

    @Override
    public SoundEvent brushSound() {
        return SoundEvents.BRUSH_GENERIC;
    }

    @Override
    public ImmutableMap<String, StateHelper> getStates() {
        return ImmutableMap.of(
                IGUANA_SIT_1_STATE.getName(), IGUANA_SIT_1_STATE,
                IGUANA_SIT_2_STATE.getName(), IGUANA_SIT_2_STATE,
                IGUANA_SIT_3_STATE.getName(), IGUANA_SIT_3_STATE,
                IGUANA_SNEEZE_STATE.getName(), IGUANA_SNEEZE_STATE
        );
    }

    @Override
    public List<WeightedState<StateHelper>> getWeightedStatesToPerform() {
        return ImmutableList.of(
                WeightedState.of(IGUANA_SIT_1_STATE, 8),
                WeightedState.of(IGUANA_SIT_2_STATE, 8),
                WeightedState.of(IGUANA_SIT_3_STATE, 8),
                WeightedState.of(IGUANA_SNEEZE_STATE, 12)
        );
    }

    // Animation control
    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        AnimationController<MarineIguanaEntity> controller = new AnimationController<>(this, "controller", 5, this::predicate);
        controllers.add(controller);

        AnimationController<MarineIguanaEntity> idle = new AnimationController<>(this, "idleController", 5, this::idlePredicate);
        controllers.add(idle);
    }

    protected <E extends MarineIguanaEntity> PlayState predicate(final software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.06F && event.getLimbSwingAmount() < 0.06F) && !this.isInWater()) {
            if (this.isRunning()) {
                event.setAndContinue(MARINE_IGUANA_RUN);
            } else {
                event.setAndContinue(MARINE_IGUANA_WALK);
            }
            event.getController().setAnimationSpeed(1.0F);
            return PlayState.CONTINUE;
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
        if (getBooleanState(SIT_1)) {
            return event.setAndContinue(MARINE_IGUANA_SIT1);
        }
        if(getBooleanState(SIT_2)) {
            return event.setAndContinue(MARINE_IGUANA_SIT2);
        }
        if(getBooleanState(SIT_3)) {
            return event.setAndContinue(MARINE_IGUANA_SIT3);
        }
        if (this.isEating()) {
            event.setAndContinue(MARINE_IGUANA_GRAZE);
            return PlayState.CONTINUE;
        }
        return event.setAndContinue(MARINE_IGUANA_IDLE);
    }

    // Idle animations
    protected <E extends MarineIguanaEntity> PlayState idlePredicate(final AnimationState<E> event) {
        if (!this.isRunning()) {
            if (getBooleanState(SNEEZE)) {
                event.getController().setAnimation(MARINE_IGUANA_SNEEZE);
                return PlayState.CONTINUE;
            }
        }
        event.getController().forceAnimationReset();
        return PlayState.STOP;
    }
}
