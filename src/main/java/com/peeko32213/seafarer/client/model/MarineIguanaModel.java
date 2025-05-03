package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.MarineIguanaEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MarineIguanaModel extends GeoModel<MarineIguanaEntity> {
    @Override
    public ResourceLocation getModelResource(MarineIguanaEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/marine_iguana.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MarineIguanaEntity object) {
        if (object.canBeBrushed()) {
            return new ResourceLocation(SeaFarer.MODID, "textures/entity/marineiguana_salted.png");
        }
        else {
            return new ResourceLocation(SeaFarer.MODID, "textures/entity/marineiguana.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(MarineIguanaEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/marineiguana.animation.json");
    }

    @Override
    public void setCustomAnimations(MarineIguanaEntity entity, long uniqueID, AnimationState<MarineIguanaEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone swimControl = this.getAnimationProcessor().getBone("swim_control");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

    }
}

