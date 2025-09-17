package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.MagmawModel;
import com.peeko32213.seafarer.entities.Magmaw;
import com.peeko32213.seafarer.registry.SeaModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class MagmawRenderer extends MobRenderer<Magmaw, MagmawModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/magmaw.png");

    public MagmawRenderer(EntityRendererProvider.Context context) {
        super(context, new MagmawModel(context.bakeLayer(SeaModelLayers.MAGMAW)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(Magmaw entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Magmaw entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }
}