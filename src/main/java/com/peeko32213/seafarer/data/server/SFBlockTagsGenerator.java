package com.peeko32213.seafarer.data.server;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.blocks.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SFBlockTagsGenerator extends BlockTagsProvider {
    public SFBlockTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SeaFarer.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(SFTags.BEACH_PLANT_BLOCKS)
                .addTag(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
                .add(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get())
                .add(SFBlocks.PURPLE_SPRINKLED_SAND.get())
                .add(SFBlocks.RED_MIXED_SPRINKLED_SAND.get())
                .add(SFBlocks.PINK_SPRINKLED_SAND.get())
                .add(SFBlocks.BLUE_SPRINKLED_SAND.get())
                .add(SFBlocks.RED_SPRINKLED_SAND.get())
                .add(SFBlocks.JUMBLED_SHELLY_SAND.get())
                .add(SFBlocks.SCATTERED_SHELLY_SAND.get())
                .add(SFBlocks.MIXED_SHELLY_SAND.get())
                .add(SFBlocks.CORAL_SAND.get())
        ;

        tag(SFTags.SHELLS)
                .add(SFBlocks.CLAM_SHELL.get())
                .add(SFBlocks.SWIRL_SHELL.get())
                .add(SFBlocks.HORN_SHELL.get())
                .add(SFBlocks.PYRAMID_SHELL.get())
                .add(SFBlocks.SPIKY_SHELL.get())
        ;

        tag(SFTags.STARFISH)
                .add(SFBlocks.STARFISH_BIG_ROYAL.get())
                .add(SFBlocks.STARFISH_BIG_PURPLE_OCHRE.get())
                .add(SFBlocks.STARFISH_BIG_BLUE.get())
                .add(SFBlocks.STARFISH_BIG_OCHRE.get())
                .add(SFBlocks.STARFISH_RED.get())
                .add(SFBlocks.STARFISH_PINK.get())
                .add(SFBlocks.STARFISH_COMMON_ORANGE.get())
                .add(SFBlocks.STARFISH_CHOCOLATE_CHIP.get())
        ;

        tag(BlockTags.BEE_GROWABLES)
                .add(SFBlocks.COASTAL_WILDFLOWER.get())
                .add(SFBlocks.COASTAL_LAVENDER.get())
                .add(SFBlocks.SEA_HOLLY.get())
                .add(SFBlocks.SEA_THRIFT.get())
        ;

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get())
                .add(SFBlocks.RED_MIXED_SPRINKLED_SAND.get())
                .add(SFBlocks.BLUE_SPRINKLED_SAND.get())
                .add(SFBlocks.PINK_SPRINKLED_SAND.get())
                .add(SFBlocks.PURPLE_SPRINKLED_SAND.get())
                .add(SFBlocks.RED_SPRINKLED_SAND.get())
                .add(SFBlocks.GRAVELY_SAND.get())
                .add(SFBlocks.ROCKY_SAND.get())
                .add(SFBlocks.MIXED_SHELLY_SAND.get())
                .add(SFBlocks.SCATTERED_SHELLY_SAND.get())
                .add(SFBlocks.JUMBLED_SHELLY_SAND.get())
                .add(SFBlocks.CORAL_SAND.get())
        ;

        tag(SFTags.SPRINKLED_SAND)
                .add(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get())
                .add(SFBlocks.BLUE_SPRINKLED_SAND.get())
                .add(SFBlocks.JUMBLED_SHELLY_SAND.get())
                .add(SFBlocks.SCATTERED_SHELLY_SAND.get())
                .add(SFBlocks.GRAVELY_SAND.get())
                .add(SFBlocks.PINK_SPRINKLED_SAND.get())
                .add(SFBlocks.RED_SPRINKLED_SAND.get())
                .add(SFBlocks.MIXED_SHELLY_SAND.get())

        ;

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SFBlocks.BLUE_SEAGLASS_BLOCK.get())
                .add(SFBlocks.BLUE_SEAGLASS_PANE.get())
                .add(SFBlocks.BLUE_SEAGLASS_BRICKS.get())
                .add(SFBlocks.BLUE_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.BLUE_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.BLUE_SEAGLASS_TILES.get())
                .add(SFBlocks.BLUE_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.BLUE_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.BROWN_SEAGLASS_BLOCK.get())
                .add(SFBlocks.BROWN_SEAGLASS_PANE.get())
                .add(SFBlocks.BROWN_SEAGLASS_BRICKS.get())
                .add(SFBlocks.BROWN_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.BROWN_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.BROWN_SEAGLASS_TILES.get())
                .add(SFBlocks.BROWN_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.BROWN_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.GREEN_SEAGLASS_BLOCK.get())
                .add(SFBlocks.GREEN_SEAGLASS_PANE.get())
                .add(SFBlocks.GREEN_SEAGLASS_BRICKS.get())
                .add(SFBlocks.GREEN_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.GREEN_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.GREEN_SEAGLASS_TILES.get())
                .add(SFBlocks.GREEN_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.GREEN_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.ORANGE_SEAGLASS_BLOCK.get())
                .add(SFBlocks.ORANGE_SEAGLASS_PANE.get())
                .add(SFBlocks.ORANGE_SEAGLASS_BRICKS.get())
                .add(SFBlocks.ORANGE_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.ORANGE_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.ORANGE_SEAGLASS_TILES.get())
                .add(SFBlocks.ORANGE_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.ORANGE_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.PURPLE_SEAGLASS_BLOCK.get())
                .add(SFBlocks.PURPLE_SEAGLASS_PANE.get())
                .add(SFBlocks.PURPLE_SEAGLASS_BRICKS.get())
                .add(SFBlocks.PURPLE_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.PURPLE_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.PURPLE_SEAGLASS_TILES.get())
                .add(SFBlocks.PURPLE_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.PURPLE_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.RED_SEAGLASS_BLOCK.get())
                .add(SFBlocks.RED_SEAGLASS_PANE.get())
                .add(SFBlocks.RED_SEAGLASS_BRICKS.get())
                .add(SFBlocks.RED_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.RED_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.RED_SEAGLASS_TILES.get())
                .add(SFBlocks.RED_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.RED_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.WHITE_SEAGLASS_BLOCK.get())
                .add(SFBlocks.WHITE_SEAGLASS_PANE.get())
                .add(SFBlocks.WHITE_SEAGLASS_BRICKS.get())
                .add(SFBlocks.WHITE_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.WHITE_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.WHITE_SEAGLASS_TILES.get())
                .add(SFBlocks.WHITE_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.WHITE_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.YELLOW_SEAGLASS_BLOCK.get())
                .add(SFBlocks.YELLOW_SEAGLASS_PANE.get())
                .add(SFBlocks.YELLOW_SEAGLASS_BRICKS.get())
                .add(SFBlocks.YELLOW_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.YELLOW_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.YELLOW_SEAGLASS_TILES.get())
                .add(SFBlocks.YELLOW_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.YELLOW_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.PINK_SEAGLASS_BLOCK.get())
                .add(SFBlocks.PINK_SEAGLASS_PANE.get())
                .add(SFBlocks.PINK_SEAGLASS_BRICKS.get())
                .add(SFBlocks.PINK_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.PINK_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.PINK_SEAGLASS_TILES.get())
                .add(SFBlocks.PINK_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.PINK_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.LIME_SEAGLASS_BLOCK.get())
                .add(SFBlocks.LIME_SEAGLASS_PANE.get())
                .add(SFBlocks.LIME_SEAGLASS_BRICKS.get())
                .add(SFBlocks.LIME_SEAGLASS_BRICKS_SLAB.get())
                .add(SFBlocks.LIME_SEAGLASS_BRICKS_STAIRS.get())
                .add(SFBlocks.LIME_SEAGLASS_TILES.get())
                .add(SFBlocks.LIME_SEAGLASS_TILES_SLAB.get())
                .add(SFBlocks.LIME_SEAGLASS_TILES_STAIRS.get())

                .add(SFBlocks.SALT_BLOCK.get())

                .add(SFBlocks.CLAM_SHELL_BRICKS.get())
                .add(SFBlocks.CLAM_SHELL_BRICKS_SLAB.get())
                .add(SFBlocks.CLAM_SHELL_BRICKS_STAIRS.get())
                .add(SFBlocks.CLAM_SHELL_PILLAR.get())

                .add(SFBlocks.HORN_SHELL_BRICKS.get())
                .add(SFBlocks.HORN_SHELL_BRICKS_SLAB.get())
                .add(SFBlocks.HORN_SHELL_BRICKS_STAIRS.get())
                .add(SFBlocks.HORN_SHELL_PILLAR.get())

                .add(SFBlocks.SPIKY_SHELL_BRICKS.get())
                .add(SFBlocks.SPIKY_SHELL_BRICKS_SLAB.get())
                .add(SFBlocks.SPIKY_SHELL_BRICKS_STAIRS.get())
                .add(SFBlocks.SPIKY_SHELL_PILLAR.get())

                .add(SFBlocks.SPIRAL_SHELL_BRICKS.get())
                .add(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB.get())
                .add(SFBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get())
                .add(SFBlocks.SPIRAL_SHELL_PILLAR.get())

                .add(SFBlocks.SWIRL_SHELL_BRICKS.get())
                .add(SFBlocks.SWIRL_SHELL_BRICKS_SLAB.get())
                .add(SFBlocks.SWIRL_SHELL_BRICKS_STAIRS.get())
                .add(SFBlocks.SWIRL_SHELL_PILLAR.get())

                .add(SFBlocks.PYRAMID_SHELL_BRICKS.get())
                .add(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB.get())
                .add(SFBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get())
                .add(SFBlocks.PYRAMID_SHELL_PILLAR.get())

                .add(SFBlocks.ALGAE_COBBLESTONE.get())
                .add(SFBlocks.ALGAE_COBBLESTONE_SLAB.get())
                .add(SFBlocks.ALGAE_COBBLESTONE_STAIRS.get())
        ;

        tag(BlockTags.CORAL_BLOCKS)
                .add(SFBlocks.AMBER_CORAL_BLOCK.get())
                .add(SFBlocks.CERULEAN_CORAL_BLOCK.get())
                .add(SFBlocks.MAROON_CORAL_BLOCK.get())
                .add(SFBlocks.OLIVE_CORAL_BLOCK.get())
                .add(SFBlocks.TURQUOISE_CORAL_BLOCK.get())
                .add(SFBlocks.VERDANT_CORAL_BLOCK.get())
        ;

        tag(BlockTags.CORAL_PLANTS)
                .add(SFBlocks.AMBER_CORAL.get())
                .add(SFBlocks.CERULEAN_CORAL.get())
                .add(SFBlocks.MAROON_CORAL.get())
                .add(SFBlocks.OLIVE_CORAL.get())
                .add(SFBlocks.TURQUOISE_CORAL.get())
                .add(SFBlocks.VERDANT_CORAL.get())
                .add(SFBlocks.CYAN_ZOA.get())
                .add(SFBlocks.ORANGE_ZOA.get())
                .add(SFBlocks.PURPLE_ZOA.get())
                .add(SFBlocks.RED_ZOA.get())
                .add(SFBlocks.ANTLER_GORGONIAN.get())
                .add(SFBlocks.TOWERING_GORGONIAN.get())
                .add(SFBlocks.BLUE_CHRISTMAS_TREE_WORM.get())
                .add(SFBlocks.BLACK_CHRISTMAS_TREE_WORM.get())
                .add(SFBlocks.RED_CHRISTMAS_TREE_WORM.get())
                .add(SFBlocks.YELLOW_CHRISTMAS_TREE_WORM.get())
                .add(SFBlocks.WHITE_CHRISTMAS_TREE_WORM.get())
        ;

        tag(BlockTags.CORALS)
                .add(SFBlocks.AMBER_CORAL_FAN.get())
                .add(SFBlocks.CERULEAN_CORAL_FAN.get())
                .add(SFBlocks.MAROON_CORAL_FAN.get())
                .add(SFBlocks.OLIVE_CORAL_FAN.get())
                .add(SFBlocks.TURQUOISE_CORAL_FAN.get())
                .add(SFBlocks.VERDANT_CORAL_FAN.get())
        ;

        tag(BlockTags.WALL_CORALS)
                .add(SFBlocks.AMBER_CORAL_WALL_FAN.get())
                .add(SFBlocks.CERULEAN_CORAL_WALL_FAN.get())
                .add(SFBlocks.MAROON_CORAL_WALL_FAN.get())
                .add(SFBlocks.OLIVE_CORAL_WALL_FAN.get())
                .add(SFBlocks.TURQUOISE_CORAL_WALL_FAN.get())
                .add(SFBlocks.VERDANT_CORAL_WALL_FAN.get())
        ;

    }


    @Override
    public String getName() {
        return SeaFarer.MODID + " Block Tags";
    }
}
