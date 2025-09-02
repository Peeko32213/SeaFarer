package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.ScallopModel;
import com.peeko32213.seafarer.entities.Scallop;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class ScallopRenderer extends MobRenderer<Scallop, ScallopModel<Scallop>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/scallop.png");

    public ScallopRenderer(EntityRendererProvider.Context context) {
        super(context, new ScallopModel<>(context.bakeLayer(SeafarerModelLayers.SCALLOP_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(Scallop entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Scallop entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}