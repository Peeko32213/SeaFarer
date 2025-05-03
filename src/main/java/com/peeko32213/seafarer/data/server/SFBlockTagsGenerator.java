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
                .add(SFBlocks.ROYAL_STARFISH.get())
                .add(SFBlocks.PURPLE_OCHRE_STARFISH.get())
                .add(SFBlocks.BLUE_STARFISH.get())
                .add(SFBlocks.OCHRE_STARFISH.get())
                .add(SFBlocks.RED_STARFISH.get())
                .add(SFBlocks.PINK_STARFISH.get())
                .add(SFBlocks.COMMON_ORANGE_STARFISH.get())
                .add(SFBlocks.CHOCOLATE_CHIP_STARFISH.get())
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
                .add(SFBlocks.AZURE_SEA_GLASS.get())
                .add(SFBlocks.AZURE_SEA_GLASS_PANE.get())
                .add(SFBlocks.AZURE_SEA_GLASS_BRICKS.get())
                .add(SFBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get())
                .add(SFBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get())
                .add(SFBlocks.AZURE_SEA_GLASS_TILES.get())
                .add(SFBlocks.AZURE_SEA_GLASS_TILE_SLAB.get())
                .add(SFBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get())

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
