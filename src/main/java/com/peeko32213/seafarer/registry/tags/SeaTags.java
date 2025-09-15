package com.peeko32213.seafarer.registry.tags;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class SeaTags {

    // Spawn Biomes
    public static final TagKey<Biome> IS_CRAB_BIOME = registerBiomeTag("is_crab_biome");
    public static final TagKey<Biome> IS_HORSECRAB_BIOME = registerBiomeTag("is_horseshoe_crab_biome");
    public static final TagKey<Biome> IS_SUNFISH_BIOME = registerBiomeTag("is_sunfish_biome");

    public static final TagKey<Biome> IS_BEACH_BIOME = registerBiomeTag("is_beach_biome");
    public static final TagKey<Biome> IS_SANDY_BEACH_BIOME = registerBiomeTag("is_sandy_beach_biome");
    public static final TagKey<Biome> IS_ALGAE_BOULDER_BIOME = registerBiomeTag("is_algae_boulder_biome");

    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    private static TagKey<EntityType<?>> registerEntityTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    private static TagKey<Instrument> registerInstrument(String name) {
        return TagKey.create(Registries.INSTRUMENT, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    private static TagKey<Biome> registerBiomeTag(String name){
        return TagKey.create(Registries.BIOME, new ResourceLocation(Seafarer.MOD_ID, name));

    }
}
