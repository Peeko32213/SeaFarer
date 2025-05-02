package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.SquirrelfishEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SquirrelfishModel extends GeoModel<SquirrelfishEntity> {
    @Override
    public ResourceLocation getModelResource(SquirrelfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/squirrelfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SquirrelfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/squirrelfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SquirrelfishEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/squirrelfish.animation.json");
    }

    @Override
    public void setCustomAnimations(SquirrelfishEntity entity, long uniqueID, AnimationState<SquirrelfishEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("swim_control");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }
}

