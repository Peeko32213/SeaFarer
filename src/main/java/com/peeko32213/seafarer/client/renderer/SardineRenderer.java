package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.SardineModel;
import com.peeko32213.seafarer.entities.Sardine;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SardineRenderer extends MobRenderer<Sardine, SardineModel<Sardine>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/sardine.png");

    public SardineRenderer(EntityRendererProvider.Context context) {
        super(context, new SardineModel<>(context.bakeLayer(SeafarerModelLayers.SARDINE_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(Sardine entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Sardine entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}