package com.peeko32213.seafarer.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.BarreleyeModel;
import com.peeko32213.seafarer.entities.Barreleye;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BarreleyeLensLayer<T extends Barreleye, M extends BarreleyeModel<T>> extends RenderLayer<T, M> {

    private static final RenderType LENS_TEXTURE = RenderType.entityTranslucent(new ResourceLocation(Seafarer.MOD_ID, "textures/entity/barreleye/barreleye_lens.png"));

    public BarreleyeLensLayer(RenderLayerParent<T, M> parentModel) {
        super(parentModel);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T entity, float f, float g, float h, float j, float k, float l) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(LENS_TEXTURE);
        this.getParentModel().renderToBuffer(poseStack, vertexConsumer, 0xF00000, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.25F);
    }
}


