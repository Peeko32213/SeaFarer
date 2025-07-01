package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.entities.SpiderCrabEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class SpiderCrabModel extends GeoModel<SpiderCrabEntity> {
    @Override
    public ResourceLocation getModelResource(SpiderCrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/spider_crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpiderCrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/spider_crab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpiderCrabEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/spider_crab.animation.json");
    }

}

