package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.SailfishModel;
import com.peeko32213.seafarer.entities.Sailfish;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SailfishRenderer extends MobRenderer<Sailfish, SailfishModel<Sailfish>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/sailfish.png");

    public SailfishRenderer(EntityRendererProvider.Context context) {
        super(context, new SailfishModel<>(context.bakeLayer(SeafarerModelLayers.SAILFISH_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(Sailfish entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Sailfish entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}