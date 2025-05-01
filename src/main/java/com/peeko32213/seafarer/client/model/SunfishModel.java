package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.SunfishEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class SunfishModel extends GeoModel<SunfishEntity>
{
    @Override
    public ResourceLocation getModelResource(SunfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/sunfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SunfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/sunfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SunfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/sunfish.animation.json");
    }

    @Override
    public void setCustomAnimations(SunfishEntity animatable, long instanceId, AnimationState<SunfishEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone body = this.getAnimationProcessor().getBone("Body");
        CoreGeoBone tail = this.getAnimationProcessor().getBone("Tail");
        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        if (!animatable.isInWater()) {
            body.setRotZ(1.5708f);
        }
        AnimatableManager<GeoAnimatable> manager = animatable.getAnimatableInstanceCache().getManagerForId(instanceId);
        int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.isFirstTick() ? 1 : 0;
        tail.setRotY(tail.getRotY() + extraDataOfType.netHeadYaw() * ((float) Math.PI / 270F) * unpausedMultiplier);

    }

}

