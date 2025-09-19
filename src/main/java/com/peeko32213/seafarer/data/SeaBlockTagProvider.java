package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.tags.SeaBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.peeko32213.seafarer.registry.SeaBlocks.*;

public class SeaBlockTagProvider extends BlockTagsProvider {

    public SeaBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Seafarer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.CORAL_PLANTS).add(
                AMBER_CORAL.get(),
                CERULEAN_CORAL.get(),
                MAROON_CORAL.get(),
                OLIVE_CORAL.get(),
                TURQUOISE_CORAL.get(),
                VERDANT_CORAL.get(),
                AMBER_CORAL_FAN.get(),
                CERULEAN_CORAL_FAN.get(),
                MAROON_CORAL_FAN.get(),
                OLIVE_CORAL_FAN.get(),
                TURQUOISE_CORAL_FAN.get(),
                VERDANT_CORAL_FAN.get(),
                CYAN_ZOA.get(),
                ORANGE_ZOA.get(),
                PURPLE_ZOA.get(),
                RED_ZOA.get(),
                BLUE_CHRISTMAS_TREE_WORM.get(),
                BLACK_CHRISTMAS_TREE_WORM.get(),
                YELLOW_CHRISTMAS_TREE_WORM.get(),
                WHITE_CHRISTMAS_TREE_WORM.get(),
                RED_CHRISTMAS_TREE_WORM.get()
        );

        this.tag(BlockTags.CORAL_BLOCKS).add(
                AMBER_CORAL_BLOCK.get(),
                CERULEAN_CORAL_BLOCK.get(),
                MAROON_CORAL_BLOCK.get(),
                OLIVE_CORAL_BLOCK.get(),
                TURQUOISE_CORAL_BLOCK.get(),
                VERDANT_CORAL_BLOCK.get()
        );

        this.tag(BlockTags.WALL_CORALS).add(
                AMBER_CORAL_WALL_FAN.get(),
                CERULEAN_CORAL_WALL_FAN.get(),
                MAROON_CORAL_WALL_FAN.get(),
                OLIVE_CORAL_WALL_FAN.get(),
                TURQUOISE_CORAL_WALL_FAN.get(),
                VERDANT_CORAL_WALL_FAN.get()
        );

        this.tag(SeaBlockTags.GORGONIANS).add(
                TOWERING_GORGONIAN.get(),
                ATTUM_GORGONIAN.get(),
                ANTLER_GORGONIAN.get()
        );

        this.tag(SeaBlockTags.STARFISH).add(
                CORAL_STARFISH.get(),
                LAGOON_STARFISH.get(),
                PLUMERIA_STARFISH.get(),
                SKY_BLUE_STARFISH.get(),
                SUNNY_STARFISH.get(),
                SUNSET_STARFISH.get()
        );

        this.tag(BlockTags.SAND).add(
                VOLCANIC_SAND.get(),
                SHELLY_VOLCANIC_SAND.get(),
                STARRY_VOLCANIC_SAND.get(),
                CORALINE_SAND.get(),
                SHELLY_CORALINE_SAND.get(),
                STARRY_CORALINE_SAND.get(),
                SHELLY_SAND.get(),
                STARRY_SAND.get()
        );

        this.tag(BlockTags.DIRT).add(
                MOSSY_SCORIA.get()
        );

        this.tag(SeaBlockTags.BEACH_PLANT_PLACEABLE)
                .addTag(BlockTags.SAND)
                .addTag(BlockTags.DIRT);

        this.tag(BlockTags.SMALL_FLOWERS).add(
                COASTAL_WILDFLOWER.get(),
                COASTAL_LAVENDER.get(),
                SEA_THRIFT.get(),
                SEA_HOLLY.get(),
                FIERY_DUSTER.get(),
                SILK_LILIES.get(),
                TWILIGHT_BLADE.get(),
                WIDOWBLOOM.get()
        );

        this.tag(BlockTags.FLOWER_POTS).add(
                POTTED_COASTAL_WILDFLOWER.get(),
                POTTED_COASTAL_LAVENDER.get(),
                POTTED_SEA_THRIFT.get(),
                POTTED_SEA_HOLLY.get(),
                POTTED_FIERY_DUSTER.get(),
                POTTED_SILK_LILIES.get(),
                POTTED_TWILIGHT_BLADE.get(),
                POTTED_WIDOWBLOOM.get(),
                POTTED_BEACHGRASS.get(),
                POTTED_SHORT_BEACHGRASS.get(),
                POTTED_YELLOW_VOLCANIC_GRASS.get(),
                POTTED_BLUE_VOLCANIC_GRASS.get(),
                POTTED_ORANGE_VOLCANIC_GRASS.get()
        );

        this.tag(BlockTags.TALL_FLOWERS).add(
                DAWNFLAME.get(),
                SAPPHIRE_COWBELL.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                SHELLY_SAND.get(),
                STARRY_SAND.get(),
                SEA_GLASS_SAND.get(),
                CORALINE_SAND.get(),
                SHELLY_CORALINE_SAND.get(),
                STARRY_CORALINE_SAND.get(),
                VOLCANIC_SAND.get(),
                SHELLY_VOLCANIC_SAND.get(),
                STARRY_VOLCANIC_SAND.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                SPIKY_SHELL_BRICKS.get(), SPIKY_SHELL_BRICK_STAIRS.get(), SPIKY_SHELL_BRICK_SLAB.get(), SPIKY_SHELL_PILLAR.get(),
                CLAM_SHELL_BRICKS.get(), CLAM_SHELL_BRICK_STAIRS.get(), CLAM_SHELL_BRICK_SLAB.get(), CLAM_SHELL_PILLAR.get(),
                HORN_SHELL_BRICKS.get(), HORN_SHELL_BRICK_STAIRS.get(), HORN_SHELL_BRICK_SLAB.get(), HORN_SHELL_PILLAR.get(),
                SWIRL_SHELL_BRICKS.get(), SWIRL_SHELL_BRICK_STAIRS.get(), SWIRL_SHELL_BRICK_SLAB.get(), SWIRL_SHELL_PILLAR.get(),
                SPIRAL_SHELL_BRICKS.get(), SPIRAL_SHELL_BRICK_STAIRS.get(), SPIRAL_SHELL_BRICK_SLAB.get(), SPIRAL_SHELL_PILLAR.get(),
                PYRAMID_SHELL_BRICKS.get(), PYRAMID_SHELL_BRICK_STAIRS.get(), PYRAMID_SHELL_BRICK_SLAB.get(), PYRAMID_SHELL_PILLAR.get(),

                CORALINE_SANDSTONE.get(), CORALINE_SANDSTONE_STAIRS.get(), CORALINE_SANDSTONE_SLAB.get(), CORALINE_SANDSTONE_WALL.get(),
                CHISELED_CORALINE_SANDSTONE.get(),
                SMOOTH_CORALINE_SANDSTONE.get(), SMOOTH_CORALINE_SANDSTONE_STAIRS.get(), SMOOTH_CORALINE_SANDSTONE_SLAB.get(),
                CUT_CORALINE_SANDSTONE.get(), CUT_CORALINE_SANDSTONE_SLAB.get(),

                VOLCANIC_SANDSTONE.get(), VOLCANIC_SANDSTONE_STAIRS.get(), VOLCANIC_SANDSTONE_SLAB.get(), VOLCANIC_SANDSTONE_WALL.get(),
                CHISELED_VOLCANIC_SANDSTONE.get(),
                SMOOTH_VOLCANIC_SANDSTONE.get(), SMOOTH_VOLCANIC_SANDSTONE_STAIRS.get(), SMOOTH_VOLCANIC_SANDSTONE_SLAB.get(),
                CUT_VOLCANIC_SANDSTONE.get(), CUT_VOLCANIC_SANDSTONE_SLAB.get(),

                MOLTEN_SCORIA.get(), MOSSY_SCORIA.get(),
                SCORIA.get(), SCORIA_STAIRS.get(), SCORIA_SLAB.get(), SCORIA_WALL.get(),
                POLISHED_SCORIA.get(), POLISHED_SCORIA_STAIRS.get(), POLISHED_SCORIA_SLAB.get(), POLISHED_SCORIA_WALL.get(),
                SCORIA_BRICKS.get(), SCORIA_BRICK_STAIRS.get(), SCORIA_BRICK_SLAB.get(), SCORIA_BRICK_WALL.get(),
                SMOOTH_SCORIA.get(), SMOOTH_SCORIA_STAIRS.get(), SMOOTH_SCORIA_SLAB.get(), SMOOTH_SCORIA_WALL.get(),
                CHISELED_SCORIA_BRICKS.get()
        );

        this.tag(BlockTags.WALLS).add(
                VOLCANIC_SANDSTONE_WALL.get(),
                CORALINE_SANDSTONE_WALL.get(),
                SCORIA_WALL.get(),
                POLISHED_SCORIA_WALL.get(),
                SCORIA_BRICK_WALL.get(),
                SMOOTH_SCORIA_WALL.get()
        );

        this.tag(BlockTags.CLIMBABLE).add(
                FISHING_NET.get()
        );
    }


    @Override
    public String getName() {
        return Seafarer.MOD_ID + " Block Tags";
    }
}
