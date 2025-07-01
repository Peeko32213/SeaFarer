package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.entities.BlueTangEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BlueTangModel extends GeoModel<BlueTangEntity> {
    @Override
    public ResourceLocation getModelResource(BlueTangEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/blue_tang.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueTangEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/blue_tang.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlueTangEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/blue_tang.animation.json");
    }

    @Override
    public void setCustomAnimations(BlueTangEntity entity, long uniqueID, AnimationState<BlueTangEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("swim_control");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }
}

