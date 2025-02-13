package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityMantisShrimp;
import com.peeko32213.seafarer.common.entity.EntitySpiderCrab;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelSpiderCrab extends GeoModel<EntitySpiderCrab> {
    @Override
    public ResourceLocation getModelResource(EntitySpiderCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/spider_crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySpiderCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/spider_crab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySpiderCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/spider_crab.animation.json");
    }

}

