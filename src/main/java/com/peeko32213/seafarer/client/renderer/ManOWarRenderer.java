package com.peeko32213.seafarer.client.renderer;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.client.models.ManOWarModel;
import com.peeko32213.seafarer.entities.ManOWar;
import com.peeko32213.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class ManOWarRenderer extends MobRenderer<ManOWar, ManOWarModel<ManOWar>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/man_o_war.png");

    public ManOWarRenderer(EntityRendererProvider.Context context) {
        super(context, new ManOWarModel<>(context.bakeLayer(SeafarerModelLayers.MAN_O_WAR_LAYER)), 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(ManOWar entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(ManOWar entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}