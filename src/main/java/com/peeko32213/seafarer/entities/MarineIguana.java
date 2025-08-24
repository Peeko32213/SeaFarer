package com.peeko32213.seafarer.entities;

import com.peeko32213.seafarer.entities.ai.goal.*;
import com.peeko32213.seafarer.entities.interfaces.Brushable;
import com.peeko32213.seafarer.registry.SFItems;
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
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
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

import java.util.Collections;
import java.util.List;

public class MarineIguana extends Animal implements Brushable, IForgeShearable {

    private static final EntityDataAccessor<Integer> SALT = SynchedEntityData.defineId(MarineIguana.class, EntityDataSerializers.INT);

    private GrazeAlgaeGoal eatBlockGoal;
    private int eatAnimationTick;
    private int SaltTime = 0;

    private Level level;

    public MarineIguana(EntityType<? extends Animal> pEntityType, Level pLevel) {
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
        this.goalSelector.addGoal(4, new BigPanicGoal(this, 2.1D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1.0D, 60));
    }

    public float getStepHeight() {
        if (this.isInWater()) {
            return 1.0F;
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

    public static boolean checkMarineIguanaSpawnRules(EntityType<? extends MarineIguana> iguana, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource p_186242_) {
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
                ItemStack stack1 = SFItems.SEA_SALT.get().getDefaultInstance();
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
}
