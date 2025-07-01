package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.entities.FrogfishEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class FrogFishModel extends GeoModel<FrogfishEntity> {
    @Override
    public ResourceLocation getModelResource(FrogfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/frogfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrogfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/frogfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FrogfishEntity object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/frogfish.animation.json");
    }

}

