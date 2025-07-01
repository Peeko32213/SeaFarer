package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.entities.MantisShrimpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class MantisShrimpModel extends GeoModel<MantisShrimpEntity> {
    @Override
    public ResourceLocation getModelResource(MantisShrimpEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/mantis_shrimp.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MantisShrimpEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/mantis_shrimp.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MantisShrimpEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/mantis_shrimp.animation.json");
    }

}

