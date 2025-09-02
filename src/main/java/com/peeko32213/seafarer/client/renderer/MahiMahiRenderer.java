package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.MahiMahiModel;
import com.peeko32213.seafarer.entities.MahiMahi;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class MahiMahiRenderer extends MobRenderer<MahiMahi, MahiMahiModel<MahiMahi>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/mahi_mahi.png");

    public MahiMahiRenderer(EntityRendererProvider.Context context) {
        super(context, new MahiMahiModel<>(context.bakeLayer(SeafarerModelLayers.MAHI_MAHI_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(MahiMahi entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(MahiMahi entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}