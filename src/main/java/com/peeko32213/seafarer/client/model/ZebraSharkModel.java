package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.ZebraSharkEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ZebraSharkModel extends GeoModel<ZebraSharkEntity>
{
    @Override
    public ResourceLocation getModelResource(ZebraSharkEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/zebrashark.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ZebraSharkEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/zebrashark.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ZebraSharkEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/zebrashark.animation.json");
    }

    @Override
    public void setCustomAnimations(ZebraSharkEntity entity, long uniqueID, AnimationState<ZebraSharkEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("root");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }


}

