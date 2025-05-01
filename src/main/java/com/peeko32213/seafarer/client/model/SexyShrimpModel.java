package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.SexyShrimpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class SexyShrimpModel extends GeoModel<SexyShrimpEntity> {
    @Override
    public ResourceLocation getModelResource(SexyShrimpEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/sexy_shrimp.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SexyShrimpEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/sexy_shrimp.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SexyShrimpEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/sexy_shrimp.animation.json");
    }

}

