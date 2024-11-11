package com.peeko32213.seafarer.common.entity.misc;

import com.peeko32213.seafarer.common.entity.misc.state.IStateAction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public abstract class StatedWaterAnimal extends WaterAnimal implements IStateAction {
    private static final EntityDataAccessor<Boolean> PERFORMING_ACTION = SynchedEntityData.defineId(StatedWaterAnimal.class, EntityDataSerializers.BOOLEAN);

    protected StatedWaterAnimal(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(PERFORMING_ACTION, false);
    }

    public boolean getBooleanState(EntityDataAccessor<Boolean> pKey) {
        return this.entityData.get(pKey);
    }

    public void setBooleanState(EntityDataAccessor<Boolean> pKey, boolean state) {
        this.entityData.set(pKey, state);
    }


    @Override
    public void travel(Vec3 pTravelVector) {
        if (this.getPerformingAction()) {
            if (this.getNavigation().getPath() != null) {
                this.getNavigation().stop();
            }
            pTravelVector = Vec3.ZERO;
        }
        super.travel(pTravelVector);
    }

    public boolean getPerformingAction() {
        return this.entityData.get(PERFORMING_ACTION);
    }

    public void setPerformingAction(boolean action) {
        this.entityData.set(PERFORMING_ACTION, action);
    }
    @Override
    public boolean getAction() {
        return getPerformingAction();
    }

    @Override
    public void setAction(boolean action) {
        setPerformingAction(action);
    }
}
