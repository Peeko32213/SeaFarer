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
                LAGOON_STARFISH.get()
        );

        this.tag(SeaBlockTags.BEACH_FLOWERS).add(
                COASTAL_WILDFLOWER.get(),
                COASTAL_LAVENDER.get(),
                SEA_HOLLY.get(),
                SEA_THRIFT.get()
        );

        this.tag(SeaBlockTags.VOLCANIC_ISLAND_FLOWERS).add(
                FIERY_DUSTER.get(),
                SILK_LILIES.get(),
                TWILIGHT_BLADE.get(),
                DAWNFLAME.get()
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

        this.tag(SeaBlockTags.BEACH_PLANT_PLACEABLE).addTag(BlockTags.SAND);

        tag(BlockTags.BEE_GROWABLES)
                .add(SeaBlocks.COASTAL_WILDFLOWER.get())
                .add(SeaBlocks.COASTAL_LAVENDER.get())
                .add(SeaBlocks.SEA_HOLLY.get())
                .add(SeaBlocks.SEA_THRIFT.get())
        ;

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(SeaBlocks.SHELLY_SAND.get())
                .add(SeaBlocks.CORALINE_SAND.get())
        ;

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(SeaBlocks.LIGHT_BLUE_SEA_GLASS.get())
                .add(SeaBlocks.LIGHT_BLUE_SEA_GLASS_PANE.get())
                .add(SeaBlocks.LIGHT_BLUE_SEA_GLASS_BRICKS.get())
                .add(SeaBlocks.LIGHT_BLUE_GLASS_BRICK_SLAB.get())
                .add(SeaBlocks.LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS.get())

                .add(SeaBlocks.SALT_BLOCK.get())

                .add(SeaBlocks.CLAM_SHELL_BRICKS.get())
                .add(SeaBlocks.CLAM_SHELL_BRICK_SLAB.get())
                .add(SeaBlocks.CLAM_SHELL_BRICK_STAIRS.get())
                .add(SeaBlocks.CLAM_SHELL_PILLAR.get())

                .add(SeaBlocks.HORN_SHELL_BRICKS.get())
                .add(SeaBlocks.HORN_SHELL_BRICK_SLAB.get())
                .add(SeaBlocks.HORN_SHELL_BRICK_STAIRS.get())
                .add(SeaBlocks.HORN_SHELL_PILLAR.get())

                .add(SeaBlocks.SPIKY_SHELL_BRICKS.get())
                .add(SeaBlocks.SPIKY_SHELL_BRICK_SLAB.get())
                .add(SeaBlocks.SPIKY_SHELL_BRICK_STAIRS.get())
                .add(SeaBlocks.SPIKY_SHELL_PILLAR.get())

                .add(SeaBlocks.SPIRAL_SHELL_BRICKS.get())
                .add(SeaBlocks.SPIRAL_SHELL_BRICK_SLAB.get())
                .add(SeaBlocks.SPIRAL_SHELL_BRICK_STAIRS.get())
                .add(SeaBlocks.SPIRAL_SHELL_PILLAR.get())

                .add(SeaBlocks.SWIRL_SHELL_BRICKS.get())
                .add(SeaBlocks.SWIRL_SHELL_BRICK_SLAB.get())
                .add(SeaBlocks.SWIRL_SHELL_BRICK_STAIRS.get())
                .add(SeaBlocks.SWIRL_SHELL_PILLAR.get())

                .add(SeaBlocks.PYRAMID_SHELL_BRICKS.get())
                .add(SeaBlocks.PYRAMID_SHELL_BRICK_SLAB.get())
                .add(SeaBlocks.PYRAMID_SHELL_BRICK_STAIRS.get())
                .add(SeaBlocks.PYRAMID_SHELL_PILLAR.get())
        ;

        this.tag(BlockTags.WALLS).add(
                VOLCANIC_SANDSTONE_WALL.get(),
                CORALINE_SANDSTONE_WALL.get(),
                SCORIA_WALL.get(),
                POLISHED_SCORIA_WALL.get(),
                SCORIA_BRICK_WALL.get(),
                SMOOTH_SCORIA_WALL.get()
        );

    }


    @Override
    public String getName() {
        return Seafarer.MOD_ID + " Block Tags";
    }
}
