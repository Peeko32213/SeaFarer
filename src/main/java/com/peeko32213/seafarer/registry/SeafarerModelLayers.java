package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SeafarerModelLayers {

    public static final ModelLayerLocation CRAB_LAYER = main("crab");
    public static final ModelLayerLocation HORSESHOE_CRAB_LAYER = main("horseshoe_crab");
    public static final ModelLayerLocation MANTA_RAY_LAYER = main("manta_ray");
    public static final ModelLayerLocation MARINE_IGUANA_LAYER = main("marine_iguana");
    public static final ModelLayerLocation PARROTFISH_LAYER = main("parrotfish");
    public static final ModelLayerLocation SUNFISH_LAYER = main("sunfish");
    public static final ModelLayerLocation SARDINE_LAYER = main("sardine");
    public static final ModelLayerLocation SCALLOP_LAYER = main("scallop");
    public static final ModelLayerLocation FLOUNDER_LAYER = main("flounder");
    public static final ModelLayerLocation MAHI_MAHI_LAYER = main("mahi_mahi");
    public static final ModelLayerLocation SAILFISH_LAYER = main("sailfish");

    public static final ModelLayerLocation SHARK_LAYER = main("shark");
    public static final ModelLayerLocation SEA_CUCUMBER_LAYER = main("sea_cucumber");
    public static final ModelLayerLocation MAN_O_WAR_LAYER = main("man_o_war");
    public static final ModelLayerLocation THRESHER_SHARK_LAYER = main("thresher_shark");
    public static final ModelLayerLocation TUNA_LAYER = main("tuna_layer");
    public static final ModelLayerLocation BOWHEAD_WHALE_LAYER = main("bowhead_whale");
    public static final ModelLayerLocation LEAFY_SEA_DRAGON_LAYER = main("leafy_sea_dragon");
    public static final ModelLayerLocation WHALE_SHARK_LAYER = main("whale_shark");

    private static ModelLayerLocation register(String id, String name) {
        return new ModelLayerLocation(new ResourceLocation(Seafarer.MOD_ID, id), name);
    }

    private static ModelLayerLocation main(String id) {
        return register(id, "main");
    }
}
