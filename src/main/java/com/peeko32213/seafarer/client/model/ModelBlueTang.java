package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityBlueTang;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelBlueTang extends GeoModel<EntityBlueTang>
{
    @Override
    public ResourceLocation getModelResource(EntityBlueTang object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/blue_tang.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityBlueTang object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/blue_tang.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityBlueTang object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/blue_tang.animation.json");
    }

    @Override
    public void setCustomAnimations(EntityBlueTang entity, long uniqueID, AnimationState<EntityBlueTang> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("Root");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }


}

