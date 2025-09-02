package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.FlounderModel;
import com.peeko32213.seafarer.entities.Flounder;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class FlounderRenderer extends MobRenderer<Flounder, FlounderModel<Flounder>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/flounder.png");

    public FlounderRenderer(EntityRendererProvider.Context context) {
        super(context, new FlounderModel<>(context.bakeLayer(SeafarerModelLayers.FLOUNDER_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(Flounder entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Flounder entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}