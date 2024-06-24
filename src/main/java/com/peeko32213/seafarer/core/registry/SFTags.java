package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class SFTags {


    //public static final TagKey<Instrument> OCARINA_WHISTLE = registerInstrument("ocarina_whistle");
    //public static final TagKey<EntityType<?>> ANURO_EGG_TRAMPLERS = registerEntityTag("anuro_egg_tramplers");
    //public static final TagKey<Item> ALLOWED_FRIDGE_ITEMS = registerItemTag("allowed_fridge_items");
    //public static final TagKey<Block> CLUB_WHITELIST_BLOCKS = registerBlockTag("club_whitelist_blocks");
    //public static final TagKey<Biome> IS_STETHA_BIOME = registerBiomeTag("is_stetha_biome");


// Blocks
    public static final TagKey<Block> BEACH_PLANT_BLOCKS = registerBlockTag("beach_plant_blocks");

    public static final TagKey<Block> SHELLS = registerBlockTag("shells");
    public static final TagKey<Block> STARFISH = registerBlockTag("starfish");
    public static final TagKey<Block> BEACH_GLASS = registerBlockTag("beach_glass");



    // Spawn Biomes
    public static final TagKey<Biome> IS_CRAB_BIOME = registerBiomeTag("is_crab_biome");
    public static final TagKey<Biome> IS_HORSECRAB_BIOME = registerBiomeTag("is_horseshoe_crab_biome");
    public static final TagKey<Biome> IS_MARINE_IGUANA_BIOME = registerBiomeTag("is_marine_iguana_biome");
    public static final TagKey<Biome> IS_SUNFISH_BIOME = registerBiomeTag("is_sunfish_biome");

    public static final TagKey<Biome> IS_BEACH_BIOME = registerBiomeTag("is_beach_biome");


    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(SeaFarer.MODID, name));
    }

    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(SeaFarer.MODID, name));
    }

    private static TagKey<EntityType<?>> registerEntityTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(SeaFarer.MODID, name));
    }

    private static TagKey<Instrument> registerInstrument(String name) {
        return TagKey.create(Registries.INSTRUMENT, new ResourceLocation(SeaFarer.MODID, name));
    }

    private static TagKey<Biome> registerBiomeTag(String name){
        return TagKey.create(Registries.BIOME, new ResourceLocation(SeaFarer.MODID, name));

    }
}
