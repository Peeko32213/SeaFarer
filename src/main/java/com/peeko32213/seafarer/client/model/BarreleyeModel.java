package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.entities.BarreleyeEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class BarreleyeModel extends GeoModel<BarreleyeEntity> {
    @Override
    public ResourceLocation getModelResource(BarreleyeEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/barreleye.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BarreleyeEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/barreleye.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BarreleyeEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/barreleye.animation.json");
    }

    @Override
    public void setCustomAnimations(BarreleyeEntity entity, long uniqueID, AnimationState<BarreleyeEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("swim_control");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }
}

