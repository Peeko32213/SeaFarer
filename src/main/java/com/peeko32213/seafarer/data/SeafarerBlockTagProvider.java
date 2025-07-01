package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import com.peeko32213.seafarer.registry.tags.SeafarerTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SeafarerBlockTagProvider extends BlockTagsProvider {
    public SeafarerBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SeaFarer.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(SeafarerTags.BEACH_PLANT_BLOCKS)
                .addTag(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
                .add(SeafarerBlocks.BLUE_MIXED_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.PURPLE_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.RED_MIXED_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.PINK_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.BLUE_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.RED_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.JUMBLED_SHELLY_SAND.get())
                .add(SeafarerBlocks.SCATTERED_SHELLY_SAND.get())
                .add(SeafarerBlocks.MIXED_SHELLY_SAND.get())
                .add(SeafarerBlocks.CORAL_SAND.get())
        ;

        tag(SeafarerTags.SHELLS)
                .add(SeafarerBlocks.CLAM_SHELL.get())
                .add(SeafarerBlocks.SWIRL_SHELL.get())
                .add(SeafarerBlocks.HORN_SHELL.get())
                .add(SeafarerBlocks.PYRAMID_SHELL.get())
                .add(SeafarerBlocks.SPIKY_SHELL.get())
        ;

        tag(SeafarerTags.STARFISH)
                .add(SeafarerBlocks.ROYAL_STARFISH.get())
                .add(SeafarerBlocks.PURPLE_OCHRE_STARFISH.get())
                .add(SeafarerBlocks.BLUE_STARFISH.get())
                .add(SeafarerBlocks.OCHRE_STARFISH.get())
                .add(SeafarerBlocks.RED_STARFISH.get())
                .add(SeafarerBlocks.PINK_STARFISH.get())
                .add(SeafarerBlocks.COMMON_ORANGE_STARFISH.get())
                .add(SeafarerBlocks.CHOCOLATE_CHIP_STARFISH.get())
        ;

        tag(BlockTags.BEE_GROWABLES)
                .add(SeafarerBlocks.COASTAL_WILDFLOWER.get())
                .add(SeafarerBlocks.COASTAL_LAVENDER.get())
                .add(SeafarerBlocks.SEA_HOLLY.get())
                .add(SeafarerBlocks.SEA_THRIFT.get())
        ;

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(SeafarerBlocks.BLUE_MIXED_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.RED_MIXED_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.BLUE_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.PINK_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.PURPLE_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.RED_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.GRAVELY_SAND.get())
                .add(SeafarerBlocks.ROCKY_SAND.get())
                .add(SeafarerBlocks.MIXED_SHELLY_SAND.get())
                .add(SeafarerBlocks.SCATTERED_SHELLY_SAND.get())
                .add(SeafarerBlocks.JUMBLED_SHELLY_SAND.get())
                .add(SeafarerBlocks.CORAL_SAND.get())
        ;

        tag(SeafarerTags.SPRINKLED_SAND)
                .add(SeafarerBlocks.BLUE_MIXED_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.BLUE_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.JUMBLED_SHELLY_SAND.get())
                .add(SeafarerBlocks.SCATTERED_SHELLY_SAND.get())
                .add(SeafarerBlocks.GRAVELY_SAND.get())
                .add(SeafarerBlocks.PINK_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.RED_SPRINKLED_SAND.get())
                .add(SeafarerBlocks.MIXED_SHELLY_SAND.get())

        ;

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SeafarerBlocks.AZURE_SEA_GLASS.get())
                .add(SeafarerBlocks.AZURE_SEA_GLASS_PANE.get())
                .add(SeafarerBlocks.AZURE_SEA_GLASS_BRICKS.get())
                .add(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get())
                .add(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get())
                .add(SeafarerBlocks.AZURE_SEA_GLASS_TILES.get())
                .add(SeafarerBlocks.AZURE_SEA_GLASS_TILE_SLAB.get())
                .add(SeafarerBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get())

                .add(SeafarerBlocks.SALT_BLOCK.get())

                .add(SeafarerBlocks.CLAM_SHELL_BRICKS.get())
                .add(SeafarerBlocks.CLAM_SHELL_BRICKS_SLAB.get())
                .add(SeafarerBlocks.CLAM_SHELL_BRICKS_STAIRS.get())
                .add(SeafarerBlocks.CLAM_SHELL_PILLAR.get())

                .add(SeafarerBlocks.HORN_SHELL_BRICKS.get())
                .add(SeafarerBlocks.HORN_SHELL_BRICKS_SLAB.get())
                .add(SeafarerBlocks.HORN_SHELL_BRICKS_STAIRS.get())
                .add(SeafarerBlocks.HORN_SHELL_PILLAR.get())

                .add(SeafarerBlocks.SPIKY_SHELL_BRICKS.get())
                .add(SeafarerBlocks.SPIKY_SHELL_BRICKS_SLAB.get())
                .add(SeafarerBlocks.SPIKY_SHELL_BRICKS_STAIRS.get())
                .add(SeafarerBlocks.SPIKY_SHELL_PILLAR.get())

                .add(SeafarerBlocks.SPIRAL_SHELL_BRICKS.get())
                .add(SeafarerBlocks.SPIRAL_SHELL_BRICKS_SLAB.get())
                .add(SeafarerBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get())
                .add(SeafarerBlocks.SPIRAL_SHELL_PILLAR.get())

                .add(SeafarerBlocks.SWIRL_SHELL_BRICKS.get())
                .add(SeafarerBlocks.SWIRL_SHELL_BRICKS_SLAB.get())
                .add(SeafarerBlocks.SWIRL_SHELL_BRICKS_STAIRS.get())
                .add(SeafarerBlocks.SWIRL_SHELL_PILLAR.get())

                .add(SeafarerBlocks.PYRAMID_SHELL_BRICKS.get())
                .add(SeafarerBlocks.PYRAMID_SHELL_BRICKS_SLAB.get())
                .add(SeafarerBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get())
                .add(SeafarerBlocks.PYRAMID_SHELL_PILLAR.get())

                .add(SeafarerBlocks.ALGAE_COBBLESTONE.get())
                .add(SeafarerBlocks.ALGAE_COBBLESTONE_SLAB.get())
                .add(SeafarerBlocks.ALGAE_COBBLESTONE_STAIRS.get())
        ;

        tag(BlockTags.CORAL_BLOCKS)
                .add(SeafarerBlocks.AMBER_CORAL_BLOCK.get())
                .add(SeafarerBlocks.CERULEAN_CORAL_BLOCK.get())
                .add(SeafarerBlocks.MAROON_CORAL_BLOCK.get())
                .add(SeafarerBlocks.OLIVE_CORAL_BLOCK.get())
                .add(SeafarerBlocks.TURQUOISE_CORAL_BLOCK.get())
                .add(SeafarerBlocks.VERDANT_CORAL_BLOCK.get())
        ;

        tag(BlockTags.CORAL_PLANTS)
                .add(SeafarerBlocks.AMBER_CORAL.get())
                .add(SeafarerBlocks.CERULEAN_CORAL.get())
                .add(SeafarerBlocks.MAROON_CORAL.get())
                .add(SeafarerBlocks.OLIVE_CORAL.get())
                .add(SeafarerBlocks.TURQUOISE_CORAL.get())
                .add(SeafarerBlocks.VERDANT_CORAL.get())
                .add(SeafarerBlocks.CYAN_ZOA.get())
                .add(SeafarerBlocks.ORANGE_ZOA.get())
                .add(SeafarerBlocks.PURPLE_ZOA.get())
                .add(SeafarerBlocks.RED_ZOA.get())
                .add(SeafarerBlocks.ANTLER_GORGONIAN.get())
                .add(SeafarerBlocks.TOWERING_GORGONIAN.get())
                .add(SeafarerBlocks.BLUE_CHRISTMAS_TREE_WORM.get())
                .add(SeafarerBlocks.BLACK_CHRISTMAS_TREE_WORM.get())
                .add(SeafarerBlocks.RED_CHRISTMAS_TREE_WORM.get())
                .add(SeafarerBlocks.YELLOW_CHRISTMAS_TREE_WORM.get())
                .add(SeafarerBlocks.WHITE_CHRISTMAS_TREE_WORM.get())
        ;

        tag(BlockTags.CORALS)
                .add(SeafarerBlocks.AMBER_CORAL_FAN.get())
                .add(SeafarerBlocks.CERULEAN_CORAL_FAN.get())
                .add(SeafarerBlocks.MAROON_CORAL_FAN.get())
                .add(SeafarerBlocks.OLIVE_CORAL_FAN.get())
                .add(SeafarerBlocks.TURQUOISE_CORAL_FAN.get())
                .add(SeafarerBlocks.VERDANT_CORAL_FAN.get())
        ;

        tag(BlockTags.WALL_CORALS)
                .add(SeafarerBlocks.AMBER_CORAL_WALL_FAN.get())
                .add(SeafarerBlocks.CERULEAN_CORAL_WALL_FAN.get())
                .add(SeafarerBlocks.MAROON_CORAL_WALL_FAN.get())
                .add(SeafarerBlocks.OLIVE_CORAL_WALL_FAN.get())
                .add(SeafarerBlocks.TURQUOISE_CORAL_WALL_FAN.get())
                .add(SeafarerBlocks.VERDANT_CORAL_WALL_FAN.get())
        ;

    }


    @Override
    public String getName() {
        return SeaFarer.MODID + " Block Tags";
    }
}
