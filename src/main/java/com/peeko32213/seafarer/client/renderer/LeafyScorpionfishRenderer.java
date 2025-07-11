package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.HorseshoeCrabModel;
import com.peeko32213.seafarer.client.models.LeafyScorpionFishModel;
import com.peeko32213.seafarer.entities.HorseshoeCrab;
import com.peeko32213.seafarer.entities.LeafyScorpionfish;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class LeafyScorpionfishRenderer extends MobRenderer<LeafyScorpionfish, LeafyScorpionFishModel<LeafyScorpionfish>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/horseshoecrab.png");

    public LeafyScorpionfishRenderer(EntityRendererProvider.Context context) {
        super(context, new LeafyScorpionFishModel<>(context.bakeLayer(SeafarerModelLayers.LEAFY_SCORPIONFISH_LAYER)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(LeafyScorpionfish entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(LeafyScorpionfish entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}