package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.FilefishEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FilefishModel extends GeoModel<FilefishEntity> {
    @Override
    public ResourceLocation getModelResource(FilefishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/filefish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FilefishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/filefish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FilefishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/filefish.animation.json");
    }

    @Override
    public void setCustomAnimations(FilefishEntity entity, long uniqueID, AnimationState<FilefishEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("swim_control");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }
}

