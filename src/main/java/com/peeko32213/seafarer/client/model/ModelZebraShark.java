package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityZebraShark;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ModelZebraShark extends GeoModel<EntityZebraShark>
{
    @Override
    public ResourceLocation getModelResource(EntityZebraShark object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/zebrashark.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityZebraShark object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/zebrashark.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityZebraShark object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/zebrashark.animation.json");
    }

    @Override
    public void setCustomAnimations(EntityZebraShark entity, long uniqueID, AnimationState<EntityZebraShark> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("root");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }


}

