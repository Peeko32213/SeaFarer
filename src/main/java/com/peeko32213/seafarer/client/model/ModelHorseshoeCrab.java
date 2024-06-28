package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityHorseshoeCrab;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelHorseshoeCrab extends GeoModel<EntityHorseshoeCrab>
{
    @Override
    public ResourceLocation getModelResource(EntityHorseshoeCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/horseshoecrab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityHorseshoeCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/horseshoecrab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityHorseshoeCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/horseshoecrab.animation.json");
    }

}

