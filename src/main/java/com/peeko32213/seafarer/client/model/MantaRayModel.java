package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.MantaRayEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MantaRayModel extends GeoModel<MantaRayEntity> {
    @Override
    public ResourceLocation getModelResource(MantaRayEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/manta_ray.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MantaRayEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/manta_ray.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MantaRayEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/manta_ray.animation.json");
    }

    @Override
    public void setCustomAnimations(MantaRayEntity animatable, long instanceId, AnimationState<MantaRayEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone swimControl = this.getAnimationProcessor().getBone("swim_control");

        swimControl.setRotX(entityData.headPitch() * (Mth.DEG_TO_RAD));
//        swimControl.setRotZ(animatable.currentRoll);
    }
}

