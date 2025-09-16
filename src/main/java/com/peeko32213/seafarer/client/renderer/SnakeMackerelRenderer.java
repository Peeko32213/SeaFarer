package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.SnakeMackerelModel;
import com.peeko32213.seafarer.client.renderer.layer.SnakeMackerelEyeLayer;
import com.peeko32213.seafarer.entities.SnakeMackerel;
import com.peeko32213.seafarer.registry.SeaModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SnakeMackerelRenderer extends MobRenderer<SnakeMackerel, SnakeMackerelModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/snake_mackerel/snake_mackerel.png");

    public SnakeMackerelRenderer(EntityRendererProvider.Context context) {
        super(context, new SnakeMackerelModel(context.bakeLayer(SeaModelLayers.SNAKE_MACKEREL)), 0.4F);
        this.addLayer(new SnakeMackerelEyeLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(SnakeMackerel entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(SnakeMackerel entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }
}