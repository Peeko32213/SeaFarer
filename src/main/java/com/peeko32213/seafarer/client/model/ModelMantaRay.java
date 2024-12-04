package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityCopperbandButterfly;
import com.peeko32213.seafarer.common.entity.EntityMantaRay;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelMantaRay extends GeoModel<EntityMantaRay>
{
    @Override
    public ResourceLocation getModelResource(EntityMantaRay object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/manta_ray.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMantaRay object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/manta_ray.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMantaRay object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/manta_ray.animation.json");
    }


}

