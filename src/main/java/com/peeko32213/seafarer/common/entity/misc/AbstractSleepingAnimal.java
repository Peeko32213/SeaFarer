package com.peeko32213.seafarer.common.entity.misc;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class AbstractSleepingAnimal extends Animal {

    private static final EntityDataAccessor<Boolean> ASLEEP = SynchedEntityData.defineId(AbstractSleepingAnimal.class, EntityDataSerializers.BOOLEAN);
    public int alertTicks = 0;

    public AbstractSleepingAnimal(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ASLEEP, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("IsAsleep", this.isAsleep());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setAsleep(compound.getBoolean("IsAsleep"));
    }

    public boolean isAsleep() {
        return this.entityData.get(ASLEEP);
    }

    public void setAsleep(boolean isAsleep) {
        this.entityData.set(ASLEEP, isAsleep);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAsleep()) this.navigation.setSpeedModifier(0);
        if (!this.level().isClientSide) {
            if (this.alertTicks != 0) alertTicks--;
        }
    }

    public void setAwakeTicks(int ticks) {
        if (!this.level().isClientSide) {
            this.alertTicks = ticks;
        }
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }
}
