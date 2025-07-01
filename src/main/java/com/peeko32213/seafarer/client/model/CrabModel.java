package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.entities.CrabEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class CrabModel extends GeoModel<CrabEntity>
{
    @Override
    public ResourceLocation getModelResource(CrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/crab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/crab.animation.json");
    }

}

