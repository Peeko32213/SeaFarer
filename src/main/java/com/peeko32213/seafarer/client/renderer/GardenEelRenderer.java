package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.GardenEelModel;
import com.peeko32213.seafarer.entities.GardenEel;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GardenEelRenderer extends MobRenderer<GardenEel, GardenEelModel<GardenEel>> {
    private static final ResourceLocation BLACK = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/garden_eel_black.png");
    private static final ResourceLocation ORANGE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/garden_eel_orange.png");

    public GardenEelRenderer(EntityRendererProvider.Context context) {
        super(context, new GardenEelModel<>(context.bakeLayer(SeafarerModelLayers.GARDEN_EEL_LAYER)), 0.4F);
    }

    public ResourceLocation getTextureLocation(GardenEel entity) {
        return switch (entity.getVariant()) {
            case 1 -> ORANGE;
            default -> BLACK;
        };
    }
}