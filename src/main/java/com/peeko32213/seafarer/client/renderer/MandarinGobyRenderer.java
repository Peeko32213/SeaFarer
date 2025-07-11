package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.MandarinGobyModel;
import com.peeko32213.seafarer.entities.MandarinGoby;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class MandarinGobyRenderer extends MobRenderer<MandarinGoby, MandarinGobyModel<MandarinGoby>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/mandarin_goby.png");

    public MandarinGobyRenderer(EntityRendererProvider.Context context) {
        super(context, new MandarinGobyModel<>(context.bakeLayer(SeafarerModelLayers.LEAFY_SCORPIONFISH_LAYER)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(MandarinGoby entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(MandarinGoby entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}