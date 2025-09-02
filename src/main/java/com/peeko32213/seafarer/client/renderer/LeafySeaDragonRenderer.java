package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.LeafySeaDragonModel;
import com.peeko32213.seafarer.entities.LeafySeaDragon;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class LeafySeaDragonRenderer extends MobRenderer<LeafySeaDragon, LeafySeaDragonModel<LeafySeaDragon>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/leafy_sea_dragon.png");

    public LeafySeaDragonRenderer(EntityRendererProvider.Context context) {
        super(context, new LeafySeaDragonModel<>(context.bakeLayer(SeafarerModelLayers.LEAFY_SEA_DRAGON_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(LeafySeaDragon entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(LeafySeaDragon entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}