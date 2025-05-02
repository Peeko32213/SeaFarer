package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.CopperbandButterflyfishEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CopperbandButterflyfishModel extends GeoModel<CopperbandButterflyfishEntity> {
    @Override
    public ResourceLocation getModelResource(CopperbandButterflyfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/copperband_butterfly.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CopperbandButterflyfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/copperband_butterfly.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CopperbandButterflyfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/copperband_butterfly.animation.json");
    }

    @Override
    public void setCustomAnimations(CopperbandButterflyfishEntity entity, long uniqueID, AnimationState<CopperbandButterflyfishEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("swim_control");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }
}

