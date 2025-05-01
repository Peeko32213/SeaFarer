package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.LeafyScorpionFishEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class LeafyScorpionfishModel extends GeoModel<LeafyScorpionFishEntity> {
    @Override
    public ResourceLocation getModelResource(LeafyScorpionFishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/leafy_scorpionfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LeafyScorpionFishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/leafy_scorpionfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LeafyScorpionFishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/leafy_scorpionfish.animation.json");
    }

}

