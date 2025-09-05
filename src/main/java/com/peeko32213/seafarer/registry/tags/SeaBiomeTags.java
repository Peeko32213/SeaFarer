package com.peeko32213.seafarer.registry.tags;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class SeaBiomeTags {

    public static final TagKey<Biome> WARM_OCEANS = modBiomeTag("warm_oceans");

    private static TagKey<Biome> modBiomeTag(String name) {
        return biomeTag(Seafarer.MOD_ID, name);
    }

    private static TagKey<Biome> forgeBiomeTag(String name) {
        return biomeTag("forge", name);
    }

    public static TagKey<Biome> biomeTag(String modid, String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(modid, name));
    }
}
