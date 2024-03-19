package com.peeko32213.seafarer.datagen;

import com.mojang.logging.LogUtils;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

public class BlockstateGenerator extends BlockStateProvider {
    public BlockstateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SeaFarer.MODID, exFileHelper);
    }

    private static final Logger LOGGER = LogUtils.getLogger();

    private String blockName(Block block) {
        return block.getLootTable().getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    private String getName(Block block) {
        return key(block).toString().replace(SeaFarer.MODID + ":", "");
    }
    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(SeaFarer.MODID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    public void simpleBlockItem(Block block, ModelFile model) {
        itemModels().getBuilder(key(block).getPath()).parent(model);
    }

    @Override
    protected void registerStatesAndModels() {
        /**Example**/
        //simpleBlock(UPBlocks.STRIPPED_GINKGO_LOG.get());
        //logBlock(UPBlocks.GINKGO_LOG.get());
        //simpleBlockItem(UPBlocks.STRIPPED_PETRIFIED_WOOD.get(), existingModel((getName(UPBlocks.STRIPPED_PETRIFIED_WOOD.get()))));
        //trapdoorBlock(UPBlocks.PETRIFIED_WOOD_TRAPDOOR.get(), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_wood_trapdoor"), true);
        //slabBlock(UPBlocks.PETRIFIED_WOOD_SLAB.get(), resourceBlock(getName(UPBlocks.PETRIFIED_WOOD_PLANKS.get())), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_planks"));
        //stairsBlock(UPBlocks.PETRIFIED_WOOD_STAIRS.get(), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_planks"));
        //doorBlock(UPBlocks.PETRIFIED_WOOD_DOOR.get(), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_wood_door_bottom"),new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_wood_door_top"));
        //pressurePlateBlock(UPBlocks.PETRIFIED_WOOD_PRESSURE_PLATE.get(), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_planks"));
        //buttonBlock(UPBlocks.PETRIFIED_WOOD_BUTTON.get(), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_planks"));
        //fenceBlock(UPBlocks.PETRIFIED_WOOD_FENCE.get(), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_planks"));
        //fenceGateBlock(UPBlocks.PETRIFIED_WOOD_FENCE_GATE.get(), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_planks"));
        //signBlock((StandingSignBlock) UPBlocks.PETRIFIED_WOOD_SIGN.get(), (WallSignBlock) UPBlocks.PETRIFIED_WOOD_WALL_SIGN.get(), new ResourceLocation(UnusualPrehistory.MODID, "block/petrified_wood_sign"));

        logBlock(SFBlocks.SHELL_BLOCK_PILLAR.get());
        simpleBlockItem(SFBlocks.SHELL_BLOCK_PILLAR.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_PILLAR.get()))));

        simpleBlock(SFBlocks.SHELL_BLOCK_CLAMS.get());
        simpleBlockItem(SFBlocks.SHELL_BLOCK_CLAMS.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_CLAMS.get()))));

        simpleBlock(SFBlocks.SHELL_BLOCK_MOSAIC.get());
        simpleBlockItem(SFBlocks.SHELL_BLOCK_MOSAIC.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_MOSAIC.get()))));

        simpleBlock(SFBlocks.SHELL_BLOCK_SHINGLES.get());
        simpleBlockItem(SFBlocks.SHELL_BLOCK_SHINGLES.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_SHINGLES.get()))));

        simpleBlock(SFBlocks.SHELL_BLOCK_SPIRAL.get());
        simpleBlockItem(SFBlocks.SHELL_BLOCK_SPIRAL.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_SPIRAL.get()))));

        simpleBlock(SFBlocks.ALGAE_BLOCK.get());
        simpleBlockItem(SFBlocks.ALGAE_BLOCK.get(), existingModel((getName(SFBlocks.ALGAE_BLOCK.get()))));

        // Blue Seaglass

        simpleBlock(SFBlocks.BLUE_SEAGLASS_TILES.get());
        simpleBlockItem(SFBlocks.BLUE_SEAGLASS_TILES.get(), existingModel((getName(SFBlocks.BLUE_SEAGLASS_TILES.get()))));

        slabBlock(SFBlocks.BLUE_SEAGLASS_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.BLUE_SEAGLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/blue_seaglass_bricks"));
        simpleBlockItem(SFBlocks.BLUE_SEAGLASS_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.BLUE_SEAGLASS_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.BLUE_SEAGLASS_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/blue_seaglass_bricks"));
        simpleBlockItem(SFBlocks.BLUE_SEAGLASS_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.BLUE_SEAGLASS_BRICKS_STAIRS.get()))));

        slabBlock(SFBlocks.BLUE_SEAGLASS_TILES_SLAB.get(), resourceBlock(getName(SFBlocks.BLUE_SEAGLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/blue_seaglass_tiles"));
        simpleBlockItem(SFBlocks.BLUE_SEAGLASS_TILES_SLAB.get(), existingModel((getName(SFBlocks.BLUE_SEAGLASS_TILES_SLAB.get()))));

        stairsBlock(SFBlocks.BLUE_SEAGLASS_TILES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/blue_seaglass_tiles"));
        simpleBlockItem(SFBlocks.BLUE_SEAGLASS_TILES_STAIRS.get(), existingModel((getName(SFBlocks.BLUE_SEAGLASS_TILES_STAIRS.get()))));

        // Brown Seaglass

        simpleBlock(SFBlocks.BROWN_SEAGLASS_TILES.get());
        simpleBlockItem(SFBlocks.BLUE_SEAGLASS_TILES.get(), existingModel((getName(SFBlocks.BLUE_SEAGLASS_TILES.get()))));

        slabBlock(SFBlocks.BROWN_SEAGLASS_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.BROWN_SEAGLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/brown_seaglass_bricks"));
        simpleBlockItem(SFBlocks.BROWN_SEAGLASS_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.BROWN_SEAGLASS_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.BROWN_SEAGLASS_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/brown_seaglass_bricks"));
        simpleBlockItem(SFBlocks.BROWN_SEAGLASS_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.BROWN_SEAGLASS_BRICKS_STAIRS.get()))));

        slabBlock(SFBlocks.BROWN_SEAGLASS_TILES_SLAB.get(), resourceBlock(getName(SFBlocks.BROWN_SEAGLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/brown_seaglass_tiles"));
        simpleBlockItem(SFBlocks.BROWN_SEAGLASS_TILES_SLAB.get(), existingModel((getName(SFBlocks.BROWN_SEAGLASS_TILES_SLAB.get()))));

        stairsBlock(SFBlocks.BROWN_SEAGLASS_TILES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/brown_seaglass_tiles"));
        simpleBlockItem(SFBlocks.BROWN_SEAGLASS_TILES_STAIRS.get(), existingModel((getName(SFBlocks.BROWN_SEAGLASS_TILES_STAIRS.get()))));


        // Green Seaglass

        simpleBlock(SFBlocks.GREEN_SEAGLASS_TILES.get());
        simpleBlockItem(SFBlocks.GREEN_SEAGLASS_TILES.get(), existingModel((getName(SFBlocks.GREEN_SEAGLASS_TILES.get()))));

        slabBlock(SFBlocks.GREEN_SEAGLASS_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.GREEN_SEAGLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/green_seaglass_bricks"));
        simpleBlockItem(SFBlocks.GREEN_SEAGLASS_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.GREEN_SEAGLASS_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.GREEN_SEAGLASS_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/green_seaglass_bricks"));
        simpleBlockItem(SFBlocks.GREEN_SEAGLASS_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.GREEN_SEAGLASS_BRICKS_STAIRS.get()))));

        slabBlock(SFBlocks.GREEN_SEAGLASS_TILES_SLAB.get(), resourceBlock(getName(SFBlocks.GREEN_SEAGLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/green_seaglass_tiles"));
        simpleBlockItem(SFBlocks.GREEN_SEAGLASS_TILES_SLAB.get(), existingModel((getName(SFBlocks.GREEN_SEAGLASS_TILES_SLAB.get()))));

        stairsBlock(SFBlocks.GREEN_SEAGLASS_TILES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/green_seaglass_tiles"));
        simpleBlockItem(SFBlocks.GREEN_SEAGLASS_TILES_STAIRS.get(), existingModel((getName(SFBlocks.GREEN_SEAGLASS_TILES_STAIRS.get()))));


        // Orange Seaglass

        simpleBlock(SFBlocks.ORANGE_SEAGLASS_TILES.get());
        simpleBlockItem(SFBlocks.ORANGE_SEAGLASS_TILES.get(), existingModel((getName(SFBlocks.ORANGE_SEAGLASS_TILES.get()))));

        slabBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.ORANGE_SEAGLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/orange_seaglass_bricks"));
        simpleBlockItem(SFBlocks.ORANGE_SEAGLASS_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.ORANGE_SEAGLASS_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.ORANGE_SEAGLASS_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/orange_seaglass_bricks"));
        simpleBlockItem(SFBlocks.ORANGE_SEAGLASS_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.ORANGE_SEAGLASS_BRICKS_STAIRS.get()))));

        slabBlock(SFBlocks.ORANGE_SEAGLASS_TILES_SLAB.get(), resourceBlock(getName(SFBlocks.ORANGE_SEAGLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/orange_seaglass_tiles"));
        simpleBlockItem(SFBlocks.ORANGE_SEAGLASS_TILES_SLAB.get(), existingModel((getName(SFBlocks.ORANGE_SEAGLASS_TILES_SLAB.get()))));

        stairsBlock(SFBlocks.ORANGE_SEAGLASS_TILES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/orange_seaglass_tiles"));
        simpleBlockItem(SFBlocks.ORANGE_SEAGLASS_TILES_STAIRS.get(), existingModel((getName(SFBlocks.ORANGE_SEAGLASS_TILES_STAIRS.get()))));


        // Purple Seaglass

        simpleBlock(SFBlocks.PURPLE_SEAGLASS_TILES.get());
        simpleBlockItem(SFBlocks.PURPLE_SEAGLASS_TILES.get(), existingModel((getName(SFBlocks.PURPLE_SEAGLASS_TILES.get()))));

        slabBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.PURPLE_SEAGLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/purple_seaglass_bricks"));
        simpleBlockItem(SFBlocks.PURPLE_SEAGLASS_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.PURPLE_SEAGLASS_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.PURPLE_SEAGLASS_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/purple_seaglass_bricks"));
        simpleBlockItem(SFBlocks.PURPLE_SEAGLASS_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.PURPLE_SEAGLASS_BRICKS_STAIRS.get()))));

        slabBlock(SFBlocks.PURPLE_SEAGLASS_TILES_SLAB.get(), resourceBlock(getName(SFBlocks.PURPLE_SEAGLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/purple_seaglass_tiles"));
        simpleBlockItem(SFBlocks.PURPLE_SEAGLASS_TILES_SLAB.get(), existingModel((getName(SFBlocks.PURPLE_SEAGLASS_TILES_SLAB.get()))));

        stairsBlock(SFBlocks.PURPLE_SEAGLASS_TILES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/purple_seaglass_tiles"));
        simpleBlockItem(SFBlocks.PURPLE_SEAGLASS_TILES_STAIRS.get(), existingModel((getName(SFBlocks.PURPLE_SEAGLASS_TILES_STAIRS.get()))));

        // Red Seaglass

        simpleBlock(SFBlocks.RED_SEAGLASS_TILES.get());
        simpleBlockItem(SFBlocks.RED_SEAGLASS_TILES.get(), existingModel((getName(SFBlocks.RED_SEAGLASS_TILES.get()))));

        slabBlock(SFBlocks.RED_SEAGLASS_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.RED_SEAGLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/red_seaglass_bricks"));
        simpleBlockItem(SFBlocks.RED_SEAGLASS_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.RED_SEAGLASS_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.RED_SEAGLASS_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/red_seaglass_bricks"));
        simpleBlockItem(SFBlocks.RED_SEAGLASS_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.RED_SEAGLASS_BRICKS_STAIRS.get()))));

        slabBlock(SFBlocks.RED_SEAGLASS_TILES_SLAB.get(), resourceBlock(getName(SFBlocks.RED_SEAGLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/red_seaglass_tiles"));
        simpleBlockItem(SFBlocks.RED_SEAGLASS_TILES_SLAB.get(), existingModel((getName(SFBlocks.RED_SEAGLASS_TILES_SLAB.get()))));

        stairsBlock(SFBlocks.RED_SEAGLASS_TILES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/red_seaglass_tiles"));
        simpleBlockItem(SFBlocks.RED_SEAGLASS_TILES_STAIRS.get(), existingModel((getName(SFBlocks.RED_SEAGLASS_TILES_STAIRS.get()))));

        // White Seaglass

        simpleBlock(SFBlocks.WHITE_SEAGLASS_BLOCK.get());
        simpleBlockItem(SFBlocks.WHITE_SEAGLASS_BLOCK.get(), existingModel((getName(SFBlocks.WHITE_SEAGLASS_BLOCK.get()))));
        simpleBlock(SFBlocks.WHITE_SEAGLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.WHITE_SEAGLASS_BRICKS.get(), existingModel((getName(SFBlocks.WHITE_SEAGLASS_BRICKS.get()))));
        simpleBlock(SFBlocks.WHITE_SEAGLASS_PEBBLED.get());
        simpleBlockItem(SFBlocks.WHITE_SEAGLASS_PEBBLED.get(), existingModel((getName(SFBlocks.WHITE_SEAGLASS_PEBBLED.get()))));
        simpleBlock(SFBlocks.WHITE_SEAGLASS_TILES.get());
        simpleBlockItem(SFBlocks.WHITE_SEAGLASS_TILES.get(), existingModel((getName(SFBlocks.WHITE_SEAGLASS_TILES.get()))));

        slabBlock(SFBlocks.WHITE_SEAGLASS_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.WHITE_SEAGLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/white_seaglass_bricks"));
        simpleBlockItem(SFBlocks.WHITE_SEAGLASS_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.WHITE_SEAGLASS_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.WHITE_SEAGLASS_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/white_seaglass_bricks"));
        simpleBlockItem(SFBlocks.WHITE_SEAGLASS_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.WHITE_SEAGLASS_BRICKS_STAIRS.get()))));

        slabBlock(SFBlocks.WHITE_SEAGLASS_TILES_SLAB.get(), resourceBlock(getName(SFBlocks.WHITE_SEAGLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/white_seaglass_tiles"));
        simpleBlockItem(SFBlocks.WHITE_SEAGLASS_TILES_SLAB.get(), existingModel((getName(SFBlocks.WHITE_SEAGLASS_TILES_SLAB.get()))));

        stairsBlock(SFBlocks.WHITE_SEAGLASS_TILES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/white_seaglass_tiles"));
        simpleBlockItem(SFBlocks.WHITE_SEAGLASS_TILES_STAIRS.get(), existingModel((getName(SFBlocks.WHITE_SEAGLASS_TILES_STAIRS.get()))));


        // Yellow Seaglass

        simpleBlock(SFBlocks.YELLOW_SEAGLASS_TILES.get());
        simpleBlockItem(SFBlocks.YELLOW_SEAGLASS_TILES.get(), existingModel((getName(SFBlocks.YELLOW_SEAGLASS_TILES.get()))));

        slabBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.YELLOW_SEAGLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/yellow_seaglass_bricks"));
        simpleBlockItem(SFBlocks.YELLOW_SEAGLASS_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.YELLOW_SEAGLASS_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.YELLOW_SEAGLASS_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/yellow_seaglass_bricks"));
        simpleBlockItem(SFBlocks.YELLOW_SEAGLASS_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.YELLOW_SEAGLASS_BRICKS_STAIRS.get()))));

        slabBlock(SFBlocks.YELLOW_SEAGLASS_TILES_SLAB.get(), resourceBlock(getName(SFBlocks.YELLOW_SEAGLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/yellow_seaglass_tiles"));
        simpleBlockItem(SFBlocks.YELLOW_SEAGLASS_TILES_SLAB.get(), existingModel((getName(SFBlocks.YELLOW_SEAGLASS_TILES_SLAB.get()))));

        stairsBlock(SFBlocks.YELLOW_SEAGLASS_TILES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/yellow_seaglass_tiles"));
        simpleBlockItem(SFBlocks.YELLOW_SEAGLASS_TILES_STAIRS.get(), existingModel((getName(SFBlocks.YELLOW_SEAGLASS_TILES_STAIRS.get()))));

        // Shells

        slabBlock(SFBlocks.SHELL_BLOCK_CLAMS_SLAB.get(), resourceBlock(getName(SFBlocks.SHELL_BLOCK_CLAMS_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/shell_block_clams"));
        simpleBlockItem(SFBlocks.SHELL_BLOCK_CLAMS_SLAB.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_CLAMS_SLAB.get()))));

        stairsBlock(SFBlocks.SHELL_BLOCK_CLAMS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/shell_block_clams"));
        simpleBlockItem(SFBlocks.SHELL_BLOCK_CLAMS_STAIRS.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_CLAMS_STAIRS.get()))));


        slabBlock(SFBlocks.SHELL_BLOCK_MOSAIC_SLAB.get(), resourceBlock(getName(SFBlocks.SHELL_BLOCK_MOSAIC_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/shell_block_mosaic"));
        simpleBlockItem(SFBlocks.SHELL_BLOCK_MOSAIC_SLAB.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_MOSAIC_SLAB.get()))));

        stairsBlock(SFBlocks.SHELL_BLOCK_MOSAIC_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/shell_block_mosaic"));
        simpleBlockItem(SFBlocks.SHELL_BLOCK_MOSAIC_STAIRS.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_MOSAIC_STAIRS.get()))));


        slabBlock(SFBlocks.SHELL_BLOCK_SHINGLES_SLAB.get(), resourceBlock(getName(SFBlocks.SHELL_BLOCK_SHINGLES_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/shell_block_shingles"));
        simpleBlockItem(SFBlocks.SHELL_BLOCK_SHINGLES_SLAB.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_SHINGLES_SLAB.get()))));

        stairsBlock(SFBlocks.SHELL_BLOCK_SHINGLES_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/shell_block_shingles"));
        simpleBlockItem(SFBlocks.SHELL_BLOCK_SHINGLES_STAIRS.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_SHINGLES_STAIRS.get()))));

        slabBlock(SFBlocks.SHELL_BLOCK_SPIRAL_SLAB.get(), resourceBlock(getName(SFBlocks.SHELL_BLOCK_SPIRAL_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/shell_block_spiral"));
        simpleBlockItem(SFBlocks.SHELL_BLOCK_SPIRAL_SLAB.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_SPIRAL_SLAB.get()))));

        stairsBlock(SFBlocks.SHELL_BLOCK_SPIRAL_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/shell_block_spiral"));
        simpleBlockItem(SFBlocks.SHELL_BLOCK_SPIRAL_STAIRS.get(), existingModel((getName(SFBlocks.SHELL_BLOCK_SPIRAL_STAIRS.get()))));
    }

    @Override
    public String getName() {
        return "Block States: " + SeaFarer.MODID;
    }
}
