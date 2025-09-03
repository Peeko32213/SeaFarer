package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SeaModelLayers {

    public static final ModelLayerLocation SHORE_CRAB = main("shore_crab");
    public static final ModelLayerLocation HORSESHOE_CRAB = main("horseshoe_crab");
    public static final ModelLayerLocation MANTA_RAY = main("manta_ray");
    public static final ModelLayerLocation MARINE_IGUANA = main("marine_iguana");
    public static final ModelLayerLocation PARROTFISH = main("parrotfish");
    public static final ModelLayerLocation SUNFISH = main("sunfish");

    private static ModelLayerLocation register(String id, String name) {
        return new ModelLayerLocation(new ResourceLocation(Seafarer.MOD_ID, id), name);
    }

    private static ModelLayerLocation main(String id) {
        return register(id, "main");
    }
}
