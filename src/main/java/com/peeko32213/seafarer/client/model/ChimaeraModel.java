package com.peeko32213.seafarer.client.model;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.ChimaeraEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ChimaeraModel extends GeoModel<ChimaeraEntity> {
    @Override
    public ResourceLocation getModelResource(ChimaeraEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "geo/chimaera.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChimaeraEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/chimaera.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChimaeraEntity object) {
        return new ResourceLocation(SeaFarer.MODID, "animations/chimaera.animation.json");
    }

    @Override
    public void setCustomAnimations(ChimaeraEntity entity, long uniqueID, AnimationState<ChimaeraEntity> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("swim_control");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }
}

