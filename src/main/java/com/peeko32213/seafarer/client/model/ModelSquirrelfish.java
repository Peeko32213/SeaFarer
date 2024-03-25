package com.peeko32213.seafarer.client.model;


import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.EntityCrab;
import com.peeko32213.seafarer.common.entity.EntitySquirrelfish;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class ModelSquirrelfish extends GeoModel<EntitySquirrelfish>
{
    @Override
    public ResourceLocation getModelResource(EntitySquirrelfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "geo/squirrelfish.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySquirrelfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "textures/entity/squirrelfish.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySquirrelfish object)
    {
        return new ResourceLocation(SeaFarer.MODID, "animations/squirrelfish.animation.json");
    }

    @Override
    public void setCustomAnimations(EntitySquirrelfish animatable, long instanceId, AnimationState<EntitySquirrelfish> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        if (animationState == null) return;
        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        CoreGeoBone root = this.getAnimationProcessor().getBone("root");
        root.setRotX(extraDataOfType.headPitch() * (Mth.DEG_TO_RAD / 180));
        root.setRotZ(Mth.clamp(Mth.lerp(0.1F, Mth.cos(animatable.yBodyRot * 0.1F) * 0.1F, 1.0F), -15F, 15F));
        root.setRotY(root.getRotY() + extraDataOfType.netHeadYaw() * ((float) Math.PI / 270F));
    }

}

