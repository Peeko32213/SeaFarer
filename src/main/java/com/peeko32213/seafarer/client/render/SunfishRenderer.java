package com.peeko32213.seafarer.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.peeko32213.seafarer.client.model.SunfishModel;
import com.peeko32213.seafarer.entities.SunfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SunfishRenderer extends GeoEntityRenderer<SunfishEntity> {

    public SunfishRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SunfishModel());
    }

    @Override
    protected void applyRotations(SunfishEntity animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {
        super.applyRotations(animatable, poseStack, ageInTicks, rotationYaw, partialTick);
//        if (animatable.isInWater()){
//            poseStack.mulPose(Axis.ZP.rotationDegrees(animatable.currentRoll * 360 / 4));
//        }
    }
}
