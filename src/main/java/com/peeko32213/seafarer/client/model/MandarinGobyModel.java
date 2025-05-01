package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.MandarinGobyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class MandarinGobyModel extends GeoModel<MandarinGobyEntity>
{
    @Override
    public ResourceLocation getModelResource(MandarinGobyEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/mandarin_goby.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MandarinGobyEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/mandarin_goby.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MandarinGobyEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/mandarin_goby.animation.json");
    }

    @Override
    public void setCustomAnimations(MandarinGobyEntity animatable, long instanceId, AnimationState<MandarinGobyEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        if (animationState == null) return;

        CoreGeoBone backBody = this.getAnimationProcessor().getBone("MidTail");
        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        backBody.setRotY(backBody.getRotY() + extraDataOfType.netHeadYaw() * ((float) Math.PI / 180F));

    }

}

