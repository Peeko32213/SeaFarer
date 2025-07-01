package com.peeko32213.seafarer.entities.base;

import com.peeko32213.seafarer.entities.misc.state.IStateAction;
import com.peeko32213.seafarer.entities.navigation.SmoothGroundNavigation;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class EnhancedAnimal extends Animal implements GeoAnimatable, GeoEntity, IStateAction {

    private static final EntityDataAccessor<Boolean> PERFORMING_ACTION = SynchedEntityData.defineId(EnhancedAnimal.class, EntityDataSerializers.BOOLEAN);

    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new SmoothGroundNavigation(this, level);
    }

    protected EnhancedAnimal(EntityType<? extends Animal> pEntityType, Level pLevel) {
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

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
}
