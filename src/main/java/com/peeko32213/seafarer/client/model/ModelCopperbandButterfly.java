package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityBlueTang;
import com.peeko32213.seafarer.common.entity.EntityCopperbandButterfly;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelCopperbandButterfly extends GeoModel<EntityCopperbandButterfly>
{
    @Override
    public ResourceLocation getModelResource(EntityCopperbandButterfly object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/copperband_butterfly.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityCopperbandButterfly object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/copperband_butterfly.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityCopperbandButterfly object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/copperband_butterfly.animation.json");
    }

    @Override
    public void setCustomAnimations(EntityCopperbandButterfly entity, long uniqueID, AnimationState<EntityCopperbandButterfly> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("Body");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }


}

