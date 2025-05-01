package com.peeko32213.seafarer.data.client;

import com.mojang.logging.LogUtils;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.blocks.SFBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static com.peeko32213.seafarer.SeaFarer.modPrefix;
import static net.minecraftforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class SFBlockstateGenerator extends BlockStateProvider {
    public SFBlockstateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SeaFarer.MODID, exFileHelper);
    }

    private static final Logger LOGGER = LogUtils.getLogger();

    private String blockName(Block block) {
        return block.getLootTable().getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
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
        simpleBlock(SFBlocks.ALGAE_BLOCK.get());
        simpleBlockItem(SFBlocks.ALGAE_BLOCK.get(), existingModel((getName(SFBlocks.ALGAE_BLOCK.get()))));

        // Azure Sea glass
        simpleBlock(SFBlocks.AZURE_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.AZURE_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.AZURE_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.AZURE_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.AZURE_SEA_GLASS.get(), existingModel((getName(SFBlocks.AZURE_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.AZURE_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.AZURE_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.AZURE_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.AZURE_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/azure_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/azure_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.AZURE_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.AZURE_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.AZURE_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.AZURE_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.AZURE_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/azure_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.AZURE_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.AZURE_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/azure_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.AZURE_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/azure_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/azure_sea_glass_pane_top"));

        // Rose Sea glass
        simpleBlock(SFBlocks.ROSE_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.ROSE_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.ROSE_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.ROSE_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.ROSE_SEA_GLASS.get(), existingModel((getName(SFBlocks.ROSE_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.ROSE_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.ROSE_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.ROSE_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.ROSE_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/rose_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/rose_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.ROSE_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.ROSE_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.ROSE_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.ROSE_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.ROSE_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/rose_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.ROSE_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.ROSE_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/rose_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.ROSE_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/rose_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/rose_sea_glass_pane_top"));

        // Lilac Sea glass
        simpleBlock(SFBlocks.LILAC_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.LILAC_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.LILAC_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.LILAC_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.LILAC_SEA_GLASS.get(), existingModel((getName(SFBlocks.LILAC_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.LILAC_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.LILAC_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.LILAC_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.LILAC_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/lilac_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/lilac_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.LILAC_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.LILAC_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.LILAC_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.LILAC_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.LILAC_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/lilac_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.LILAC_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.LILAC_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/lilac_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.LILAC_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/lilac_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/lilac_sea_glass_pane_top"));

        // Seafoam Sea glass
        simpleBlock(SFBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.SEAFOAM_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.SEAFOAM_SEA_GLASS.get(), existingModel((getName(SFBlocks.SEAFOAM_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.SEAFOAM_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.SEAFOAM_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.SEAFOAM_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.SEAFOAM_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/seafoam_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/seafoam_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.SEAFOAM_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.SEAFOAM_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.SEAFOAM_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.SEAFOAM_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/seafoam_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/seafoam_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.SEAFOAM_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/seafoam_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/seafoam_sea_glass_pane_top"));

        // Chartreuse Sea glass
        simpleBlock(SFBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.CHARTREUSE_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.CHARTREUSE_SEA_GLASS.get(), existingModel((getName(SFBlocks.CHARTREUSE_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/chartreuse_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/chartreuse_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.CHARTREUSE_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.CHARTREUSE_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.CHARTREUSE_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.CHARTREUSE_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/chartreuse_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/chartreuse_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.CHARTREUSE_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/chartreuse_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/chartreuse_sea_glass_pane_top"));

        // Citrine Sea glass
        simpleBlock(SFBlocks.CITRINE_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.CITRINE_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.CITRINE_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.CITRINE_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.CITRINE_SEA_GLASS.get(), existingModel((getName(SFBlocks.CITRINE_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.CITRINE_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.CITRINE_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.CITRINE_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.CITRINE_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/citrine_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/citrine_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.CITRINE_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.CITRINE_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.CITRINE_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.CITRINE_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/citrine_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/citrine_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.CITRINE_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/citrine_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/citrine_sea_glass_pane_top"));

        // Amber Sea glass
        simpleBlock(SFBlocks.AMBER_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.AMBER_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.AMBER_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.AMBER_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.AMBER_SEA_GLASS.get(), existingModel((getName(SFBlocks.AMBER_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.AMBER_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.AMBER_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.AMBER_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.AMBER_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/amber_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/amber_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.AMBER_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.AMBER_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.AMBER_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.AMBER_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.AMBER_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/amber_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.AMBER_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.AMBER_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/amber_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.AMBER_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/amber_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/amber_sea_glass_pane_top"));

        // Scarlet Sea glass
        simpleBlock(SFBlocks.SCARLET_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.SCARLET_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.SCARLET_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.SCARLET_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.SCARLET_SEA_GLASS.get(), existingModel((getName(SFBlocks.SCARLET_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.SCARLET_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.SCARLET_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.SCARLET_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.SCARLET_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/scarlet_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/scarlet_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.SCARLET_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.SCARLET_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.SCARLET_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.SCARLET_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/scarlet_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/scarlet_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.SCARLET_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/scarlet_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/scarlet_sea_glass_pane_top"));

        // Umber Sea glass
        simpleBlock(SFBlocks.UMBER_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.UMBER_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.UMBER_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.UMBER_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.UMBER_SEA_GLASS.get(), existingModel((getName(SFBlocks.UMBER_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.UMBER_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.UMBER_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.UMBER_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.UMBER_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/umber_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/umber_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.UMBER_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.UMBER_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.UMBER_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.UMBER_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.UMBER_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/umber_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.UMBER_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.UMBER_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/umber_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.UMBER_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/umber_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/umber_sea_glass_pane_top"));

        // Pearly Sea glass
        simpleBlock(SFBlocks.PEARLY_PEBBLED_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.PEARLY_PEBBLED_SEA_GLASS.get(), existingModel((getName(SFBlocks.PEARLY_PEBBLED_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.PEARLY_SEA_GLASS.get());
        simpleBlockItem(SFBlocks.PEARLY_SEA_GLASS.get(), existingModel((getName(SFBlocks.PEARLY_SEA_GLASS.get()))));

        simpleBlock(SFBlocks.PEARLY_SEA_GLASS_BRICKS.get());
        simpleBlockItem(SFBlocks.PEARLY_SEA_GLASS_BRICKS.get(), existingModel((getName(SFBlocks.PEARLY_SEA_GLASS_BRICKS.get()))));
        slabBlock(SFBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SFBlocks.PEARLY_SEA_GLASS_BRICKS.get())), new ResourceLocation(SeaFarer.MODID, "block/pearly_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SFBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get()))));
        stairsBlock(SFBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/pearly_sea_glass_bricks"));
        simpleBlockItem(SFBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SFBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get()))));

        simpleBlock(SFBlocks.PEARLY_SEA_GLASS_TILES.get());
        simpleBlockItem(SFBlocks.PEARLY_SEA_GLASS_TILES.get(), existingModel((getName(SFBlocks.PEARLY_SEA_GLASS_TILES.get()))));
        slabBlock(SFBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SFBlocks.PEARLY_SEA_GLASS_TILES.get())), new ResourceLocation(SeaFarer.MODID, "block/pearly_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SFBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get()))));
        stairsBlock(SFBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/pearly_sea_glass_tiles"));
        simpleBlockItem(SFBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SFBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get()))));

        paneBlock(SFBlocks.PEARLY_SEA_GLASS_PANE.get(), new ResourceLocation(SeaFarer.MODID, "block/pearly_sea_glass"), new ResourceLocation(SeaFarer.MODID, "block/pearly_sea_glass_pane_top"));

        //NEW SHELL BLOCKS

        //Clam

        logBlock(SFBlocks.CLAM_SHELL_PILLAR.get());
        simpleBlockItem(SFBlocks.CLAM_SHELL_PILLAR.get(), existingModel((getName(SFBlocks.CLAM_SHELL_PILLAR.get()))));

        simpleBlock(SFBlocks.CLAM_SHELL_BRICKS.get());
        simpleBlockItem(SFBlocks.CLAM_SHELL_BRICKS.get(), existingModel((getName(SFBlocks.CLAM_SHELL_BRICKS.get()))));

        slabBlock(SFBlocks.CLAM_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.CLAM_SHELL_BRICKS_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/clam_shell_bricks"));
        simpleBlockItem(SFBlocks.CLAM_SHELL_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.CLAM_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.CLAM_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/clam_shell_bricks"));
        simpleBlockItem(SFBlocks.CLAM_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.CLAM_SHELL_BRICKS_STAIRS.get()))));

        //Horn

        logBlock(SFBlocks.HORN_SHELL_PILLAR.get());
        simpleBlockItem(SFBlocks.HORN_SHELL_PILLAR.get(), existingModel((getName(SFBlocks.HORN_SHELL_PILLAR.get()))));

        simpleBlock(SFBlocks.HORN_SHELL_BRICKS.get());
        simpleBlockItem(SFBlocks.HORN_SHELL_BRICKS.get(), existingModel((getName(SFBlocks.HORN_SHELL_BRICKS.get()))));

        slabBlock(SFBlocks.HORN_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.HORN_SHELL_BRICKS_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/horn_shell_bricks"));
        simpleBlockItem(SFBlocks.HORN_SHELL_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.HORN_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.HORN_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/horn_shell_bricks"));
        simpleBlockItem(SFBlocks.HORN_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.HORN_SHELL_BRICKS_STAIRS.get()))));

        //Horn

        logBlock(SFBlocks.SPIKY_SHELL_PILLAR.get());
        simpleBlockItem(SFBlocks.SPIKY_SHELL_PILLAR.get(), existingModel((getName(SFBlocks.SPIKY_SHELL_PILLAR.get()))));

        simpleBlock(SFBlocks.SPIKY_SHELL_BRICKS.get());
        simpleBlockItem(SFBlocks.SPIKY_SHELL_BRICKS.get(), existingModel((getName(SFBlocks.SPIKY_SHELL_BRICKS.get()))));

        slabBlock(SFBlocks.SPIKY_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.SPIKY_SHELL_BRICKS_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/spiky_shell_bricks"));
        simpleBlockItem(SFBlocks.SPIKY_SHELL_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.SPIKY_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.SPIKY_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/spiky_shell_bricks"));
        simpleBlockItem(SFBlocks.SPIKY_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.SPIKY_SHELL_BRICKS_STAIRS.get()))));

        //Spiral

        logBlock(SFBlocks.SPIRAL_SHELL_PILLAR.get());
        simpleBlockItem(SFBlocks.SPIRAL_SHELL_PILLAR.get(), existingModel((getName(SFBlocks.SPIRAL_SHELL_PILLAR.get()))));

        simpleBlock(SFBlocks.SPIRAL_SHELL_BRICKS.get());
        simpleBlockItem(SFBlocks.SPIRAL_SHELL_BRICKS.get(), existingModel((getName(SFBlocks.SPIRAL_SHELL_BRICKS.get()))));

        slabBlock(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/spiral_shell_bricks"));
        simpleBlockItem(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/spiral_shell_bricks"));
        simpleBlockItem(SFBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get()))));

        //Swirl

        logBlock(SFBlocks.SWIRL_SHELL_PILLAR.get());
        simpleBlockItem(SFBlocks.SWIRL_SHELL_PILLAR.get(), existingModel((getName(SFBlocks.SWIRL_SHELL_PILLAR.get()))));

        simpleBlock(SFBlocks.SWIRL_SHELL_BRICKS.get());
        simpleBlockItem(SFBlocks.SWIRL_SHELL_BRICKS.get(), existingModel((getName(SFBlocks.SWIRL_SHELL_BRICKS.get()))));

        slabBlock(SFBlocks.SWIRL_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.SWIRL_SHELL_BRICKS_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/swirl_shell_bricks"));
        simpleBlockItem(SFBlocks.SWIRL_SHELL_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.SWIRL_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.SWIRL_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/swirl_shell_bricks"));
        simpleBlockItem(SFBlocks.SWIRL_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.SWIRL_SHELL_BRICKS_STAIRS.get()))));

        //Pyramid


        logBlock(SFBlocks.PYRAMID_SHELL_PILLAR.get());
        simpleBlockItem(SFBlocks.PYRAMID_SHELL_PILLAR.get(), existingModel((getName(SFBlocks.PYRAMID_SHELL_PILLAR.get()))));

        simpleBlock(SFBlocks.PYRAMID_SHELL_BRICKS.get());
        simpleBlockItem(SFBlocks.PYRAMID_SHELL_BRICKS.get(), existingModel((getName(SFBlocks.PYRAMID_SHELL_BRICKS.get()))));

        slabBlock(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB.get())), new ResourceLocation(SeaFarer.MODID, "block/pyramid_shell_bricks"));
        simpleBlockItem(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB.get(), existingModel((getName(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SFBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/pyramid_shell_bricks"));
        simpleBlockItem(SFBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SFBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get()))));


        //Sand

        simpleBlock(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get());
        simpleBlockItem(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get(), existingModel((getName(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get()))));

        simpleBlock(SFBlocks.RED_MIXED_SPRINKLED_SAND.get());
        simpleBlockItem(SFBlocks.RED_MIXED_SPRINKLED_SAND.get(), existingModel((getName(SFBlocks.RED_MIXED_SPRINKLED_SAND.get()))));

        simpleBlock(SFBlocks.BLUE_SPRINKLED_SAND.get());
        simpleBlockItem(SFBlocks.BLUE_SPRINKLED_SAND.get(), existingModel((getName(SFBlocks.BLUE_SPRINKLED_SAND.get()))));

        simpleBlock(SFBlocks.PINK_SPRINKLED_SAND.get());
        simpleBlockItem(SFBlocks.PINK_SPRINKLED_SAND.get(), existingModel((getName(SFBlocks.PINK_SPRINKLED_SAND.get()))));

        simpleBlock(SFBlocks.PURPLE_SPRINKLED_SAND.get());
        simpleBlockItem(SFBlocks.PURPLE_SPRINKLED_SAND.get(), existingModel((getName(SFBlocks.PURPLE_SPRINKLED_SAND.get()))));

        simpleBlock(SFBlocks.RED_SPRINKLED_SAND.get());
        simpleBlockItem(SFBlocks.RED_SPRINKLED_SAND.get(), existingModel((getName(SFBlocks.RED_SPRINKLED_SAND.get()))));

        simpleBlock(SFBlocks.GRAVELY_SAND.get());
        simpleBlockItem(SFBlocks.GRAVELY_SAND.get(), existingModel((getName(SFBlocks.GRAVELY_SAND.get()))));

        simpleBlock(SFBlocks.ROCKY_SAND.get());
        simpleBlockItem(SFBlocks.ROCKY_SAND.get(), existingModel((getName(SFBlocks.ROCKY_SAND.get()))));

        simpleBlock(SFBlocks.MIXED_SHELLY_SAND.get());
        simpleBlockItem(SFBlocks.MIXED_SHELLY_SAND.get(), existingModel((getName(SFBlocks.MIXED_SHELLY_SAND.get()))));

        simpleBlock(SFBlocks.SCATTERED_SHELLY_SAND.get());
        simpleBlockItem(SFBlocks.SCATTERED_SHELLY_SAND.get(), existingModel((getName(SFBlocks.SCATTERED_SHELLY_SAND.get()))));

        simpleBlock(SFBlocks.JUMBLED_SHELLY_SAND.get());
        simpleBlockItem(SFBlocks.JUMBLED_SHELLY_SAND.get(), existingModel((getName(SFBlocks.JUMBLED_SHELLY_SAND.get()))));

        simpleBlock(SFBlocks.CORAL_SAND.get());
        simpleBlockItem(SFBlocks.CORAL_SAND.get(), existingModel((getName(SFBlocks.CORAL_SAND.get()))));



        simpleBlock(SFBlocks.SALT_BLOCK.get());
        simpleBlockItem(SFBlocks.SALT_BLOCK.get(), existingModel((getName(SFBlocks.SALT_BLOCK.get()))));

        createPottedPlant(SFBlocks.SEA_THRIFT, SFBlocks.POTTED_SEA_THRIFT, "cutout");
        createPottedPlant(SFBlocks.SEA_HOLLY, SFBlocks.POTTED_SEA_HOLLY, "cutout");
        createPottedPlant(SFBlocks.COASTAL_LAVENDER, SFBlocks.POTTED_COASTAL_LAVENDER, "cutout");
        createPottedPlant(SFBlocks.COASTAL_WILDFLOWER, SFBlocks.POTTED_COASTAL_WILDFLOWER, "cutout");


        simpleBlock(SFBlocks.ALGAE_COBBLESTONE.get());
        simpleBlockItem(SFBlocks.ALGAE_COBBLESTONE.get(), existingModel((getName(SFBlocks.ALGAE_COBBLESTONE.get()))));

        slabBlock(SFBlocks.ALGAE_COBBLESTONE_SLAB.get(), resourceBlock(getName(SFBlocks.ALGAE_COBBLESTONE.get())), new ResourceLocation(SeaFarer.MODID, "block/algae_cobblestone"));
        simpleBlockItem(SFBlocks.ALGAE_COBBLESTONE_SLAB.get(), existingModel((getName(SFBlocks.ALGAE_COBBLESTONE_SLAB.get()))));

        stairsBlock(SFBlocks.ALGAE_COBBLESTONE_STAIRS.get(), new ResourceLocation(SeaFarer.MODID, "block/algae_cobblestone"));
        simpleBlockItem(SFBlocks.ALGAE_COBBLESTONE_STAIRS.get(), existingModel((getName(SFBlocks.ALGAE_COBBLESTONE_STAIRS.get()))));

        //CORAL
        simpleBlock(SFBlocks.DEAD_AMBER_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.DEAD_AMBER_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.DEAD_AMBER_CORAL_BLOCK.get()))));
        simpleBlock(SFBlocks.AMBER_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.AMBER_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.AMBER_CORAL_BLOCK.get()))));

        simpleBlock(SFBlocks.DEAD_CERULEAN_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.DEAD_CERULEAN_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.DEAD_CERULEAN_CORAL_BLOCK.get()))));
        simpleBlock(SFBlocks.CERULEAN_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.CERULEAN_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.CERULEAN_CORAL_BLOCK.get()))));

        simpleBlock(SFBlocks.DEAD_MAROON_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.DEAD_MAROON_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.DEAD_MAROON_CORAL_BLOCK.get()))));
        simpleBlock(SFBlocks.MAROON_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.MAROON_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.MAROON_CORAL_BLOCK.get()))));

        simpleBlock(SFBlocks.DEAD_OLIVE_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.DEAD_OLIVE_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.DEAD_OLIVE_CORAL_BLOCK.get()))));
        simpleBlock(SFBlocks.OLIVE_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.OLIVE_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.OLIVE_CORAL_BLOCK.get()))));

        simpleBlock(SFBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get()))));
        simpleBlock(SFBlocks.TURQUOISE_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.TURQUOISE_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.TURQUOISE_CORAL_BLOCK.get()))));

        simpleBlock(SFBlocks.DEAD_VERDANT_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.DEAD_VERDANT_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.DEAD_VERDANT_CORAL_BLOCK.get()))));
        simpleBlock(SFBlocks.VERDANT_CORAL_BLOCK.get());
        simpleBlockItem(SFBlocks.VERDANT_CORAL_BLOCK.get(), existingModel((getName(SFBlocks.VERDANT_CORAL_BLOCK.get()))));

        simpleBlock(SFBlocks.SMOOTH_CORALINE_SANDSTONE.get());
        simpleBlockItem(SFBlocks.CUT_CORALINE_SANDSTONE.get(), existingModel((getName(SFBlocks.CUT_CORALINE_SANDSTONE.get()))));
        simpleBlockItem(SFBlocks.CHISELED_CORALINE_SANDSTONE.get(), existingModel((getName(SFBlocks.CHISELED_CORALINE_SANDSTONE.get()))));
        simpleBlockItem(SFBlocks.SMOOTH_CORALINE_SANDSTONE.get(), existingModel((getName(SFBlocks.SMOOTH_CORALINE_SANDSTONE.get()))));
        simpleBlockItem(SFBlocks.CORALINE_SANDSTONE.get(), existingModel((getName(SFBlocks.CORALINE_SANDSTONE.get()))));

        simpleBlockItem(SFBlocks.CORALINE_SANDSTONE_SLAB.get(), existingModel((getName(SFBlocks.CORALINE_SANDSTONE_SLAB.get()))));

        simpleBlockItem(SFBlocks.CORALINE_SANDSTONE_STAIRS.get(), existingModel((getName(SFBlocks.CORALINE_SANDSTONE_STAIRS.get()))));

        simpleBlockItem(SFBlocks.CUT_CORALINE_SANDSTONE_SLAB.get(), existingModel((getName(SFBlocks.CUT_CORALINE_SANDSTONE_SLAB.get()))));

        simpleBlockItem(SFBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get(), existingModel((getName(SFBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get()))));

        simpleBlockItem(SFBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get(), existingModel((getName(SFBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get()))));

        simpleBlockItem(SFBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get(), existingModel((getName(SFBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get()))));

    }



    private void createPottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pottedPlant, String renderType){
        ConfiguredModel cFfile = new ConfiguredModel(pottedPlant(name(pottedPlant.get()), blockTexture(plant.get()), renderType));
        getVariantBuilder(pottedPlant.get()).partialState().setModels(cFfile);
        //impleBlockItem(plant.get(), file);
    }

    public ModelFile pottedPlant(String name, ResourceLocation plant, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/flower_pot_cross", "plant", plant, renderType);
    }


    private void createWallFan(RegistryObject<Block> b, String renderType) {
        ModelFile file = new ConfiguredModel(wallCoral(name(b.get()), blockTexture(b.get()), renderType)).model;
        getVariantBuilder(b.get())
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(file)
                        .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                        .build()
                );
        simpleBlockItem(b.get(), file);
    }




    private void createTintedCross(RegistryObject<Block> b, String renderType) {
        getVariantBuilder(b.get()).partialState().setModels(new ConfiguredModel(tintedCross(name(b.get()), blockTexture(b.get()), renderType)));
    }

    public ModelFile tintedCross(String name, ResourceLocation cross, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/tinted_cross", "cross", cross, renderType);
    }
    private void createDoubleCross(RegistryObject<Block> b, String renderType) {
        String baseName = name(b.get());
        getVariantBuilder(b.get()).forAllStatesExcept(e -> {
            DoubleBlockHalf val = e.getValue(DoublePlantBlock.HALF);
            String mod = val == DoubleBlockHalf.LOWER ? "bottom" : "top";
            ResourceLocation texture = modPrefix("block/" + baseName + "_" + mod);
            ModelFile text = cross(baseName + "_" + mod, texture, renderType);
            return ConfiguredModel.builder().modelFile(text).build();
        });

        //ModelFile file = models().getExistingFile(modPrefix(baseName + "_top"));
        singleTex(b.get(), baseName + "_top");
    }

    private void createCross(RegistryObject<Block> b, String renderType) {
        ConfiguredModel cFfile = new ConfiguredModel(cross(name(b.get()), blockTexture(b.get()), renderType));
        ModelFile file = cFfile.model;
        String baseName = name(b.get());
        getVariantBuilder(b.get()).partialState().setModels(cFfile);

        singleTex(b.get(), baseName);
        //simpleBlockItem(b.get(), file);
    }

    public ModelFile cross(String name, ResourceLocation cross, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/cross", "cross", cross, renderType);
    }

    private ModelFile singleTexture(String name, String parent, String textureKey, ResourceLocation texture, String renderType) {
        return singleTexture(name, mcLoc(parent), textureKey, texture, renderType);
    }

    public ModelFile wallCoral(String name, ResourceLocation fan, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/coral_wall_fan", "fan", fan, renderType);
    }

    private void createCoralFan(RegistryObject<Block> b, String renderType) {
        getVariantBuilder(b.get()).partialState().setModels(new ConfiguredModel(coralFan(name(b.get()), blockTexture(b.get()), renderType)));
        singleTex(b.get());
    }

    public ModelFile coralFan(String name, ResourceLocation fan, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/coral_fan", "fan", fan, renderType);
    }

    public ModelFile singleTexture(String name, ResourceLocation parent, String textureKey, ResourceLocation texture, String renderType) {
        return models().withExistingParent(name, parent)
                .texture(textureKey, texture).renderType(renderType);
    }

    private BlockModelBuilder generatedWall(String name, ResourceLocation... layers) {
        BlockModelBuilder builder = models().withExistingParent("block/" + name, "block/wall_inventory");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private BlockModelBuilder generatedSlab(String name, ResourceLocation... layers) {
        BlockModelBuilder builder = models().withExistingParent("block/" + name, "block/slab");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private void blockWithTop(RegistryObject<Block> blockRegistryObject) {
        horizontalBlock(blockRegistryObject.get(), modPrefix("block/" + key(blockRegistryObject.get()).getPath()), modPrefix("block/" + key(blockRegistryObject.get()).getPath()), modPrefix("block/" + key(blockRegistryObject.get()).getPath() + "_top"));
        simpleBlockItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private BlockModelBuilder singleTexItem(Block block, ResourceLocation name) {
        return generated(name(block), name);
    }
    private BlockModelBuilder singleTexItem(Block block) {
        return generated(name(block), new ResourceLocation(SeaFarer.MODID, "item/" + name(block)));
    }

    private BlockModelBuilder singleTex(Block block) {
        return singleTex(block,  name(block));
    }

    private BlockModelBuilder singleTex(Block block, String name) {
        return generated(name(block), new ResourceLocation(SeaFarer.MODID, "block/" + name));
    }

    private BlockModelBuilder generated(String name, ResourceLocation... layers) {
        BlockModelBuilder builder = models().withExistingParent("item/" + name, "item/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }


    public ModelFile createFlatWaterEgg(Block block, String modifier){
        String baseName = getName(block);
        return models().singleTexture("block/eggs/" + modifier + baseName.replace(SeaFarer.MODID + ":", ""), new ResourceLocation(SeaFarer.MODID, "block/template_eggs/template_flat_water_egg"), blockTextureEggs(block));
    }

    public ResourceLocation blockTextureEggs(Block block) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/eggs/" + name.getPath());
    }
    
    private String name(Block block) {
        return key(block).getPath();
    }

    private String getName(Block block) {
        return key(block).toString().replace(SeaFarer.MODID + ":", "");
    }


    private Block getBlock(ResourceLocation resourceLocation) {
        return BuiltInRegistries.BLOCK.get(resourceLocation);
    }

    @Override
    public String getName() {
        return "Block States: " + SeaFarer.MODID;
    }
}
