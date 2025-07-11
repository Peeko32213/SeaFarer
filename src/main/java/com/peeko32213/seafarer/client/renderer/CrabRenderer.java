package com.peeko32213.seafarer.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.BlueTangModel;
import com.peeko32213.seafarer.client.models.CrabModel;
import com.peeko32213.seafarer.entities.BlueTang;
import com.peeko32213.seafarer.entities.Crab;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class CrabRenderer extends MobRenderer<Crab, CrabModel<Crab>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/crab.png");

    public CrabRenderer(EntityRendererProvider.Context context) {
        super(context, new CrabModel<>(context.bakeLayer(SeafarerModelLayers.CRAB_LAYER)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(Crab entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Crab entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}