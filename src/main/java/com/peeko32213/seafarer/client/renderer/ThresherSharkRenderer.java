package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.ThresherSharkModel;
import com.peeko32213.seafarer.entities.ThresherShark;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class ThresherSharkRenderer extends MobRenderer<ThresherShark, ThresherSharkModel<ThresherShark>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/thresher_shark.png");

    public ThresherSharkRenderer(EntityRendererProvider.Context context) {
        super(context, new ThresherSharkModel<>(context.bakeLayer(SeafarerModelLayers.THRESHER_SHARK_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(ThresherShark entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(ThresherShark entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}