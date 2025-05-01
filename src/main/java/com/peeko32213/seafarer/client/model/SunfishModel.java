package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.SunfishEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SunfishModel extends GeoModel<SunfishEntity> {
    @Override
    public ResourceLocation getModelResource(SunfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/sunfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SunfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/sunfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SunfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/sunfish.animation.json");
    }

    @Override
    public void setCustomAnimations(SunfishEntity animatable, long instanceId, AnimationState<SunfishEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone swimControl = this.getAnimationProcessor().getBone("swim_control");

        swimControl.setRotX(entityData.headPitch() * (Mth.DEG_TO_RAD));
    }
}

