package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityCrab;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelCrab extends GeoModel<EntityCrab>
{
    @Override
    public ResourceLocation getModelResource(EntityCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/crab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/crab.animation.json");
    }

}

