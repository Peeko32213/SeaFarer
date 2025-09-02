package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.WhaleSharkModel;
import com.peeko32213.seafarer.entities.WhaleShark;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class WhaleSharkRenderer extends MobRenderer<WhaleShark, WhaleSharkModel<WhaleShark>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/whale_shark.png");

    public WhaleSharkRenderer(EntityRendererProvider.Context context) {
        super(context, new WhaleSharkModel<>(context.bakeLayer(SeafarerModelLayers.WHALE_SHARK_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(WhaleShark entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(WhaleShark entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}