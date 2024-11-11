package com.peeko32213.seafarer.client.render;

import com.peeko32213.seafarer.common.entity.EntityFrogfish;
import com.peeko32213.seafarer.common.entity.EntitySexyShrimp;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FrogFishEntityRenderer<T extends LivingEntity & GeoAnimatable> extends GeoEntityRenderer<T> {

    public FrogFishEntityRenderer(EntityRendererProvider.Context context, GeoModel<T> model) {
        super(context, model);
    }


    @Override
    public RenderType getRenderType(T animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) { // lol.
        return animatable instanceof EntityFrogfish ? RenderType.entityTranslucent(getTextureLocation(animatable)) : RenderType.entityCutout(getTextureLocation(animatable));

    }
}
