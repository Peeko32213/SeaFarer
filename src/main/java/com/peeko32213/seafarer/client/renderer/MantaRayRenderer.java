package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.MantaRayModel;
import com.peeko32213.seafarer.entities.MantaRay;
import com.peeko32213.seafarer.registry.SFEntityModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class MantaRayRenderer extends MobRenderer<MantaRay, MantaRayModel<MantaRay>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/manta_ray/manta_ray.png");
    private static final ResourceLocation EVIL_TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/manta_ray/mantaaaaaa_ray.png");

    public MantaRayRenderer(EntityRendererProvider.Context context) {
        super(context, new MantaRayModel<>(context.bakeLayer(SFEntityModelLayers.MANTA_RAY)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(MantaRay entity) {
        if (entity.getName().getString().equalsIgnoreCase("evil")) return EVIL_TEXTURE;
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(MantaRay entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(getTextureLocation(entity));
    }
}