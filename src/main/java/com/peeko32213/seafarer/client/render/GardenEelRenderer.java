package com.peeko32213.seafarer.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.client.model.ModelGardenEel;
import com.peeko32213.seafarer.common.entity.EntityGardenEel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GardenEelRenderer extends GeoEntityRenderer<EntityGardenEel> {
    private static final ResourceLocation BLACK = new ResourceLocation(SeaFarer.MODID, "textures/entity/garden_eel_black.png");
    private static final ResourceLocation ORANGE = new ResourceLocation(SeaFarer.MODID, "textures/entity/garden_eel_orange.png");


    public GardenEelRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelGardenEel());
    }

    protected void scale(EntityGardenEel entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
    }


    public ResourceLocation getTextureLocation(EntityGardenEel entity) {
        return switch (entity.getVariant()) {
            case 1 -> BLACK;

            default -> ORANGE;
        };
    }
}
