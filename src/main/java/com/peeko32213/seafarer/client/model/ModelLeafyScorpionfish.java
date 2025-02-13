package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityFrogfish;
import com.peeko32213.seafarer.common.entity.EntityLeafyScorpionFish;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelLeafyScorpionfish extends GeoModel<EntityLeafyScorpionFish> {
    @Override
    public ResourceLocation getModelResource(EntityLeafyScorpionFish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/leafy_scorpionfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityLeafyScorpionFish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/leafy_scorpionfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityLeafyScorpionFish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/leafy_scorpionfish.animation.json");
    }

}

