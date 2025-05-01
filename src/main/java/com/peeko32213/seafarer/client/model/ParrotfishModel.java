package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.ParrotfishEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ParrotfishModel extends GeoModel<ParrotfishEntity>
{
    @Override
    public ResourceLocation getModelResource(ParrotfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/parrotfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ParrotfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/parrotfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ParrotfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/parrotfish.animation.json");
    }

    @Override
    public void setCustomAnimations(ParrotfishEntity entity, long uniqueID, AnimationState<ParrotfishEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("Root");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }


}

