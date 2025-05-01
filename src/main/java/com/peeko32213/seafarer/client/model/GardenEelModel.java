package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.GardenEelEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class GardenEelModel extends GeoModel<GardenEelEntity>
{
    @Override
    public ResourceLocation getModelResource(GardenEelEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/garden_eel.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GardenEelEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/garden_eel_black.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GardenEelEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/garden_eel.animation.json");
    }

}

