package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.TunaModel;
import com.peeko32213.seafarer.entities.Tuna;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class TunaRenderer extends MobRenderer<Tuna, TunaModel<Tuna>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/pompous_bluefin.png");

    public TunaRenderer(EntityRendererProvider.Context context) {
        super(context, new TunaModel<>(context.bakeLayer(SeafarerModelLayers.TUNA_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(Tuna entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Tuna entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}