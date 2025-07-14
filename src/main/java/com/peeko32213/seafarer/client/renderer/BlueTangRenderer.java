package com.peeko32213.seafarer.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.unimplemented.BlueTangModel;
import com.peeko32213.seafarer.entities.misc.unimplemented.BlueTang;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class BlueTangRenderer extends MobRenderer<BlueTang, BlueTangModel<BlueTang>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/blue_tang.png");

    public BlueTangRenderer(EntityRendererProvider.Context context) {
        super(context, new BlueTangModel<>(context.bakeLayer(SeafarerModelLayers.BLUE_TANG_LAYER)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(BlueTang entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(BlueTang entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

    @Override
    public void setupRotations(BlueTang entity, PoseStack matrixStack, float f, float g, float h) {
        super.setupRotations(entity, matrixStack, f, g, h);
        matrixStack.scale(0.75F, 0.75F, 0.75F);

        if (!entity.isInWater()) {
            matrixStack.translate(0.2, 0.2, 0);
            matrixStack.mulPose(Axis.ZP.rotationDegrees(90.0f));
        }
    }
}