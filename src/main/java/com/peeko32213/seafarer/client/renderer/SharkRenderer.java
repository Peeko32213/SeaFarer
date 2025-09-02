package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.SharkModel;
import com.peeko32213.seafarer.entities.Shark;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SharkRenderer extends MobRenderer<Shark, SharkModel<Shark>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/shark.png");

    public SharkRenderer(EntityRendererProvider.Context context) {
        super(context, new SharkModel<>(context.bakeLayer(SeafarerModelLayers.SHARK_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(Shark entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Shark entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}