package com.peeko32213.seafarer;

import net.minecraftforge.common.ForgeConfigSpec;

public class SeafarerConfig {

    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue BIOMES;

    public static ForgeConfigSpec.BooleanValue FLOWERING_BEACH;
    public static ForgeConfigSpec.BooleanValue GLASS_BEACH;
    public static ForgeConfigSpec.BooleanValue GRASSY_BEACH;
    public static ForgeConfigSpec.BooleanValue KELP_FOREST;
    public static ForgeConfigSpec.BooleanValue TROPICAL_RIVER;
    public static ForgeConfigSpec.BooleanValue VOLCANIC_ISLAND;
    public static ForgeConfigSpec.BooleanValue WARM_REEF;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.push("Biomes");

        BIOMES = COMMON_BUILDER
                .comment("If any custom biomes are enabled")
                .define("biomes", true);

        FLOWERING_BEACH = COMMON_BUILDER
                .comment("If the flowering beach sub-biome is enabled")
                .define("floweringBeach", true);

        GLASS_BEACH = COMMON_BUILDER
                .comment("If the glass beach sub-biome is enabled")
                .define("glassBeach", true);

        GRASSY_BEACH = COMMON_BUILDER
                .comment("If the grassy beach sub-biome is enabled")
                .define("grassyBeach", true);

        KELP_FOREST = COMMON_BUILDER
                .comment("If the kelp forest sub-biome is enabled (incomplete)")
                .define("kelpForest", false);

        TROPICAL_RIVER = COMMON_BUILDER
                .comment("If the tropical river sub-biome is enabled")
                .define("tropicalRiver", true);

        VOLCANIC_ISLAND = COMMON_BUILDER
                .comment("If the volcanic island biome is enabled")
                .define("volcanicBeach", true);

        WARM_REEF = COMMON_BUILDER
                .comment("If the warm reef sub-biome is enabled")
                .define("warmReef", true);

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

}
