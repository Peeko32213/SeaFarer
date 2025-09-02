package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.BowheadWhaleModel;
import com.peeko32213.seafarer.client.models.SunfishModel;
import com.peeko32213.seafarer.entities.BowheadWhale;
import com.peeko32213.seafarer.entities.Sunfish;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class BowheadWhaleRenderer extends MobRenderer<BowheadWhale, BowheadWhaleModel<BowheadWhale>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/bowhead_whale.png");

    public BowheadWhaleRenderer(EntityRendererProvider.Context context) {
        super(context, new BowheadWhaleModel<>(context.bakeLayer(SeafarerModelLayers.BOWHEAD_WHALE_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(BowheadWhale entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(BowheadWhale entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}