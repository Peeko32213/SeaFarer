package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityBlueTang;
import com.peeko32213.seafarer.common.entity.EntityParrotfish;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelParrotfish extends GeoModel<EntityParrotfish>
{
    @Override
    public ResourceLocation getModelResource(EntityParrotfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/parrotfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityParrotfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/parrotfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityParrotfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/parrotfish.animation.json");
    }

    @Override
    public void setCustomAnimations(EntityParrotfish entity, long uniqueID, AnimationState<EntityParrotfish> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("Root");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }


}

