package com.peeko32213.seafarer.client.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.peeko32213.seafarer.blocks.entity.SFNetBlockEntity;
import com.peeko32213.seafarer.registry.SeafarerItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class FishingNetEntityRenderer implements BlockEntityRenderer<SFNetBlockEntity> {
    public FishingNetEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    private static final ItemStack STACK = SeafarerItems.SEA_SALT.get().getDefaultInstance();

    @Override
    public void render(SFNetBlockEntity blockEntity , float partialtick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        int count  = blockEntity.getSaltCount();

        poseStack.pushPose();
        poseStack.translate(0.5, 0.0625F, 0.5);
        poseStack.scale(0.5F, 0.5F, 0.5F);

        poseStack.mulPose(Axis.XP.rotationDegrees((float) 90F));

        if(count >= SFNetBlockEntity.MAX_SALT) {
            itemRenderer.renderStatic(STACK, ItemDisplayContext.GUI, packedLight,
                    OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, blockEntity.getLevel(), 1);
        }
        poseStack.popPose();
    }
}