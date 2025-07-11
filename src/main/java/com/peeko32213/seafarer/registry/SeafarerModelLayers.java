package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SeafarerModelLayers {

    public static final ModelLayerLocation BARRELEYE_LAYER = main("barreleye");
    public static final ModelLayerLocation BLUE_TANG_LAYER = main("blue_tang");
    public static final ModelLayerLocation CHIMAERA_LAYER = main("chimaera");
    public static final ModelLayerLocation COPPERBAND_BUTTERFLY_LAYER = main("copperband_butterfly");
    public static final ModelLayerLocation CRAB_LAYER = main("crab");
    public static final ModelLayerLocation FILEFISH_LAYER = main("filefish");
    public static final ModelLayerLocation FROGFISH_LAYER = main("frogfish");
    public static final ModelLayerLocation GARDEN_EEL_LAYER = main("garden_eel");
    public static final ModelLayerLocation HORSESHOE_CRAB_LAYER = main("horseshoe_crab");
    public static final ModelLayerLocation LEAFY_SCORPIONFISH_LAYER = main("crab");
    public static final ModelLayerLocation MANDARIAN_FISH_LAYER = main("crab");
    public static final ModelLayerLocation MANTA_RAY_LAYER = main("crab");
    public static final ModelLayerLocation MANTIS_SHRIMP_LAYER = main("crab");
    public static final ModelLayerLocation MARINE_IGUANA_LAYER = main("crab");
    public static final ModelLayerLocation PARROT_FISH_LAYER = main("crab");
    public static final ModelLayerLocation SEXY_SHRIMP_LAYER = main("crab");
    public static final ModelLayerLocation SPIDER_CRAB_LAYER = main("crab");
    public static final ModelLayerLocation SQUIRREL_FISH_LAYER = main("crab");
    public static final ModelLayerLocation SUNFISH_LAYER = main("crab");
    public static final ModelLayerLocation ZEBRA_SHARK_LAYER = main("crab");

    private static ModelLayerLocation register(String id, String name) {
        return new ModelLayerLocation(new ResourceLocation(Seafarer.MOD_ID, id), name);
    }

    private static ModelLayerLocation main(String id) {
        return register(id, "main");
    }
}
