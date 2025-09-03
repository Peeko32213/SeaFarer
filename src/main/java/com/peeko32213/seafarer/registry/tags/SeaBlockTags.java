package com.peeko32213.seafarer.registry.tags;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SeaBlockTags {

    public static final TagKey<Block> WARM_CORAL_BLOCKS = modBlockTag("warm_coral_blocks");
    public static final TagKey<Block> WARM_CORALS = modBlockTag("warm_corals");
    public static final TagKey<Block> WARM_WALL_CORALS = modBlockTag("warm_wall_corals");
    public static final TagKey<Block> WARM_CORAL_PLANTS = modBlockTag("warm_coral_plants");

    private static TagKey<Block> modBlockTag(String name) {
        return blockTag(Seafarer.MOD_ID, name);
    }

    private static TagKey<Block> forgeBlockTag(String name) {
        return blockTag("forge", name);
    }

    public static TagKey<Block> blockTag(String modid, String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(modid, name));
    }
}
