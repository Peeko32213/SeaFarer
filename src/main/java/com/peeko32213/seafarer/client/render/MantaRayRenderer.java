package com.peeko32213.seafarer.client.render;

import com.peeko32213.seafarer.client.model.MantaRayModel;
import com.peeko32213.seafarer.entities.MantaRayEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MantaRayRenderer extends GeoEntityRenderer<MantaRayEntity> {

    public MantaRayRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MantaRayModel());
    }

//    @Override
//    protected void applyRotations(MantaRayEntity animatable, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {
//        super.applyRotations(animatable, poseStack, ageInTicks, rotationYaw, partialTick);
//        if (animatable.isInWater()){
//            poseStack.mulPose(Axis.ZP.rotationDegrees(animatable.currentRoll * 360 / 4));
//        }
//    }
}
