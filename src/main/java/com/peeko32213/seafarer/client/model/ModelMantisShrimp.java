package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityMantisShrimp;
import com.peeko32213.seafarer.common.entity.EntitySexyShrimp;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMantisShrimp extends GeoModel<EntityMantisShrimp> {
    @Override
    public ResourceLocation getModelResource(EntityMantisShrimp object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/mantis_shrimp.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMantisShrimp object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/mantis_shrimp.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMantisShrimp object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/mantis_shrimp.animation.json");
    }

}

