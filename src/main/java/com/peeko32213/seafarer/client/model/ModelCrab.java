package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityCrab;
import com.peeko32213.seafarer.common.entity.EntitySunfish;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelCrab extends GeoModel<EntityCrab>
{
    @Override
    public ResourceLocation getModelResource(EntityCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/crab.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/crab.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityCrab object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/crab.animation.json");
    }

}

