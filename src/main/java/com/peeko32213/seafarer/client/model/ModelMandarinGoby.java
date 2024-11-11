package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityGardenEel;
import com.peeko32213.seafarer.common.entity.EntityMandarinGoby;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelMandarinGoby extends GeoModel<EntityMandarinGoby>
{
    @Override
    public ResourceLocation getModelResource(EntityMandarinGoby object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/mandarin_goby.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMandarinGoby object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/mandarin_goby.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMandarinGoby object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/mandarin_goby.animation.json");
    }

    @Override
    public void setCustomAnimations(EntityMandarinGoby animatable, long instanceId, AnimationState<EntityMandarinGoby> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        if (animationState == null) return;

        CoreGeoBone backBody = this.getAnimationProcessor().getBone("MidTail");
        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        backBody.setRotY(backBody.getRotY() + extraDataOfType.netHeadYaw() * ((float) Math.PI / 180F));

    }

}

