package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.MandarinGobyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MandarinGobyModel extends GeoModel<MandarinGobyEntity> {
    @Override
    public ResourceLocation getModelResource(MandarinGobyEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/mandarin_goby.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MandarinGobyEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/mandarin_goby.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MandarinGobyEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/mandarin_goby.animation.json");
    }

    @Override
    public void setCustomAnimations(MandarinGobyEntity entity, long uniqueID, AnimationState<MandarinGobyEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone swimControl = this.getAnimationProcessor().getBone("swim_control");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        swimControl.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }
}

