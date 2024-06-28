package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityMarineIguana;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMarineIguana extends GeoModel<EntityMarineIguana>
{
    @Override
    public ResourceLocation getModelResource(EntityMarineIguana object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/marine_iguana.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMarineIguana object)
    {
        if (object.readyForShearing()) {
            return new ResourceLocation(SeaFarer.MODID, "textures/entity/marineiguana_salted.png");
        }
        else {
            return new ResourceLocation(SeaFarer.MODID, "textures/entity/marineiguana.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMarineIguana object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/marineiguana.animation.json");
    }

}

