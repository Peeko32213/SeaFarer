package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityCopperbandButterfly;
import com.peeko32213.seafarer.common.entity.EntityMantaRay;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelMantaRay extends GeoModel<EntityMantaRay>
{
    @Override
    public ResourceLocation getModelResource(EntityMantaRay object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/manta_ray.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMantaRay object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/manta_ray.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMantaRay object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/manta_ray.animation.json");
    }

    @Override
    public void setCustomAnimations(EntityMantaRay animatable, long instanceId, AnimationState<EntityMantaRay> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone swimControl = this.getAnimationProcessor().getBone("Body");

        swimControl.setRotX(((entityData.headPitch() * ((float) Math.PI / 180F))));
        swimControl.setRotZ(-((entityData.netHeadYaw() * ((float) Math.PI / 180F)) / 2));
    }

}

