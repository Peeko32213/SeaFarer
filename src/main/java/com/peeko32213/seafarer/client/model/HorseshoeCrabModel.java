package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.entities.HorseshoeCrabEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class HorseshoeCrabModel extends GeoModel<HorseshoeCrabEntity>
{
    @Override
    public ResourceLocation getModelResource(HorseshoeCrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/horseshoecrab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HorseshoeCrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/horseshoecrab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HorseshoeCrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/horseshoecrab.animation.json");
    }

}

