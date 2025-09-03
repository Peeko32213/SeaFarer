package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.SunfishModel;
import com.peeko32213.seafarer.entities.Sunfish;
import com.peeko32213.seafarer.registry.SeaModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SunfishRenderer extends MobRenderer<Sunfish, SunfishModel<Sunfish>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/sunfish.png");

    public SunfishRenderer(EntityRendererProvider.Context context) {
        super(context, new SunfishModel<>(context.bakeLayer(SeaModelLayers.SUNFISH)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(Sunfish entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Sunfish entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }
}