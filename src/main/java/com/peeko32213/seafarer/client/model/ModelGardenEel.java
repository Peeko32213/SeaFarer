package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityCrab;
import com.peeko32213.seafarer.common.entity.EntityGardenEel;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelGardenEel extends GeoModel<EntityGardenEel>
{
    @Override
    public ResourceLocation getModelResource(EntityGardenEel object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/garden_eel.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityGardenEel object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/garden_eel_black.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityGardenEel object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/garden_eel.animation.json");
    }

}

