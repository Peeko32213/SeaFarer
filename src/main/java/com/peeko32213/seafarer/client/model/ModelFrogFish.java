package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityFrogfish;
import com.peeko32213.seafarer.common.entity.EntitySexyShrimp;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelFrogFish extends GeoModel<EntityFrogfish> {
    @Override
    public ResourceLocation getModelResource(EntityFrogfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/frogfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFrogfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/frogfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFrogfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/frogfish.animation.json");
    }

}

