package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.SeaCucumberModel;
import com.peeko32213.seafarer.entities.SeaCucumber;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SeaCucumberRenderer extends MobRenderer<SeaCucumber, SeaCucumberModel<SeaCucumber>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/sea_cucumber.png");

    public SeaCucumberRenderer(EntityRendererProvider.Context context) {
        super(context, new SeaCucumberModel<>(context.bakeLayer(SeafarerModelLayers.SEA_CUCUMBER_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(SeaCucumber entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(SeaCucumber entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}