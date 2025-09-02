package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.ParrotfishModel;
import com.peeko32213.seafarer.entities.Parrotfish;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class ParrotfishRenderer extends MobRenderer<Parrotfish, ParrotfishModel<Parrotfish>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/parrotfish.png");

    public ParrotfishRenderer(EntityRendererProvider.Context context) {
        super(context, new ParrotfishModel<>(context.bakeLayer(SeafarerModelLayers.PARROTFISH_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(Parrotfish entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Parrotfish entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}