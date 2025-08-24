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

public class SFTags {
    // Blocks
    public static final TagKey<Block> BEACH_PLANT_BLOCKS = registerBlockTag("beach_plant_blocks");

    public static final TagKey<Block> SHELLS = registerBlockTag("shells");
    public static final TagKey<Block> STARFISH = registerBlockTag("starfish");
    public static final TagKey<Block> BEACH_GLASS = registerBlockTag("beach_glass");
    public static final TagKey<Block> SPRINKLED_SAND = registerBlockTag("sprinkled_sand");


    public static final TagKey<Item> STARFISH_ITEM = registerItemTag("starfish");


    // Spawn Biomes
    public static final TagKey<Biome> IS_CRAB_BIOME = registerBiomeTag("is_crab_biome");
    public static final TagKey<Biome> IS_HORSECRAB_BIOME = registerBiomeTag("is_horseshoe_crab_biome");
    public static final TagKey<Biome> IS_MARINE_IGUANA_BIOME = registerBiomeTag("is_marine_iguana_biome");
    public static final TagKey<Biome> IS_SUNFISH_BIOME = registerBiomeTag("is_sunfish_biome");

    public static final TagKey<Biome> IS_BEACH_BIOME = registerBiomeTag("is_beach_biome");
    public static final TagKey<Biome> IS_SANDY_BEACH_BIOME = registerBiomeTag("is_sandy_beach_biome");
    public static final TagKey<Biome> IS_ALGAE_BOULDER_BIOME = registerBiomeTag("is_algae_boulder_biome");

    public static final TagKey<EntityType<?>> FROGFISH_TARGETS = registerEntityTag("frogfish_targets");
    public static final TagKey<EntityType<?>> MANTIS_SHRIMP_TARGETS = registerEntityTag("mantis_shrimp_targets");
    public static final TagKey<EntityType<?>> SPIDER_CRAB_TARGETS = registerEntityTag("spider_crab_targets");


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
