package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SeafarerModelLayers {

    public static final ModelLayerLocation BARRELEYE_LAYER = main("barreleye");
    public static final ModelLayerLocation CHIMAERA_LAYER = main("chimaera");
    public static final ModelLayerLocation CRAB_LAYER = main("crab");
    public static final ModelLayerLocation HORSESHOE_CRAB_LAYER = main("horseshoe_crab");
    public static final ModelLayerLocation MANTA_RAY_LAYER = main("manta_ray");
    public static final ModelLayerLocation MARINE_IGUANA_LAYER = main("marine_iguana");
    public static final ModelLayerLocation PARROTFISH_LAYER = main("parrotfish");
    public static final ModelLayerLocation SUNFISH_LAYER = main("sunfish");

    private static ModelLayerLocation register(String id, String name) {
        return new ModelLayerLocation(new ResourceLocation(Seafarer.MOD_ID, id), name);
    }

    private static ModelLayerLocation main(String id) {
        return register(id, "main");
    }
}
