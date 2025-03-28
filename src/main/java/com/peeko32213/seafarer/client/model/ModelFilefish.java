package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityCopperbandButterfly;
import com.peeko32213.seafarer.common.entity.EntityFileFish;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelFilefish extends GeoModel<EntityFileFish>
{
    @Override
    public ResourceLocation getModelResource(EntityFileFish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/filefish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFileFish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/filefish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFileFish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/filefish.animation.json");
    }

    @Override
    public void setCustomAnimations(EntityFileFish entity, long uniqueID, AnimationState<EntityFileFish> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("Root");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }


}

