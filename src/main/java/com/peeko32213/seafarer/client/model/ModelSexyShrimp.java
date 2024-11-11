package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityGardenEel;
import com.peeko32213.seafarer.common.entity.EntitySexyShrimp;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelSexyShrimp extends GeoModel<EntitySexyShrimp> {
    @Override
    public ResourceLocation getModelResource(EntitySexyShrimp object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/sexy_shrimp.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySexyShrimp object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/sexy_shrimp.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySexyShrimp object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/sexy_shrimp.animation.json");
    }

}

