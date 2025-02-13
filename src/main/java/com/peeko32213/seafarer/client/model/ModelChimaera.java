package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityBlueTang;
import com.peeko32213.seafarer.common.entity.EntityChimaera;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelChimaera extends GeoModel<EntityChimaera>
{
    @Override
    public ResourceLocation getModelResource(EntityChimaera object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/chimaera.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityChimaera object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/chimaera.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityChimaera object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/chimaera.animation.json");
    }

    @Override
    public void setCustomAnimations(EntityChimaera entity, long uniqueID, AnimationState<EntityChimaera> customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        CoreGeoBone core = this.getAnimationProcessor().getBone("Body");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);

        core.setRotX(extraData.headPitch() * (Mth.DEG_TO_RAD));
    }


}

