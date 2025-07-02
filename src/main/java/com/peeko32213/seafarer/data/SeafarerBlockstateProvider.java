package com.peeko32213.seafarer.data;

import com.mojang.logging.LogUtils;
import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static com.peeko32213.seafarer.Seafarer.modPrefix;
import static net.minecraftforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class SeafarerBlockstateProvider extends BlockStateProvider {
    public SeafarerBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Seafarer.MOD_ID, exFileHelper);
    }

    private static final Logger LOGGER = LogUtils.getLogger();

    private String blockName(Block block) {
        return block.getLootTable().getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(Seafarer.MOD_ID, "block/" + path);
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
        this.simpleBlock(SeafarerBlocks.ALGAE_BLOCK.get());
        this.simpleBlockItem(SeafarerBlocks.ALGAE_BLOCK.get(), existingModel((getName(SeafarerBlocks.ALGAE_BLOCK.get()))));

        // Azure Sea glass
        this.simpleBlock(SeafarerBlocks.AZURE_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.AZURE_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.AZURE_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.AZURE_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.AZURE_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.AZURE_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.AZURE_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.AZURE_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.AZURE_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.AZURE_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/azure_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/azure_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.AZURE_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.AZURE_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.AZURE_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.AZURE_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.AZURE_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/azure_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.AZURE_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.AZURE_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/azure_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.AZURE_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.AZURE_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/azure_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/azure_sea_glass_pane_top"));

        // Rose Sea glass
        this.simpleBlock(SeafarerBlocks.ROSE_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.ROSE_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.ROSE_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.ROSE_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.ROSE_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.ROSE_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.ROSE_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.ROSE_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.ROSE_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.ROSE_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/rose_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/rose_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.ROSE_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.ROSE_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.ROSE_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.ROSE_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.ROSE_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/rose_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.ROSE_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.ROSE_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/rose_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.ROSE_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.ROSE_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/rose_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/rose_sea_glass_pane_top"));

        // Lilac Sea glass
        this.simpleBlock(SeafarerBlocks.LILAC_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.LILAC_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.LILAC_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.LILAC_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.LILAC_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.LILAC_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.LILAC_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.LILAC_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.LILAC_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.LILAC_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/lilac_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/lilac_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.LILAC_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.LILAC_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.LILAC_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.LILAC_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.LILAC_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/lilac_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.LILAC_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.LILAC_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/lilac_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.LILAC_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.LILAC_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/lilac_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/lilac_sea_glass_pane_top"));

        // Seafoam Sea glass
        this.simpleBlock(SeafarerBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.SEAFOAM_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.SEAFOAM_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/seafoam_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/seafoam_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/seafoam_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/seafoam_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.SEAFOAM_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/seafoam_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/seafoam_sea_glass_pane_top"));

        // Chartreuse Sea glass
        this.simpleBlock(SeafarerBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.CHARTREUSE_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/chartreuse_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/chartreuse_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/chartreuse_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/chartreuse_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.CHARTREUSE_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/chartreuse_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/chartreuse_sea_glass_pane_top"));

        // Citrine Sea glass
        this.simpleBlock(SeafarerBlocks.CITRINE_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.CITRINE_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.CITRINE_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.CITRINE_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.CITRINE_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.CITRINE_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/citrine_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/citrine_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.CITRINE_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.CITRINE_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.CITRINE_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.CITRINE_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/citrine_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/citrine_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.CITRINE_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.CITRINE_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/citrine_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/citrine_sea_glass_pane_top"));

        // Amber Sea glass
        this.simpleBlock(SeafarerBlocks.AMBER_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.AMBER_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.AMBER_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.AMBER_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.AMBER_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.AMBER_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.AMBER_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.AMBER_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.AMBER_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.AMBER_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/amber_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/amber_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.AMBER_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.AMBER_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.AMBER_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.AMBER_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.AMBER_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/amber_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.AMBER_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.AMBER_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/amber_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.AMBER_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.AMBER_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/amber_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/amber_sea_glass_pane_top"));

        // Scarlet Sea glass
        this.simpleBlock(SeafarerBlocks.SCARLET_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.SCARLET_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.SCARLET_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.SCARLET_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.SCARLET_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.SCARLET_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/scarlet_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/scarlet_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.SCARLET_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.SCARLET_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.SCARLET_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.SCARLET_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/scarlet_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/scarlet_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.SCARLET_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.SCARLET_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/scarlet_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/scarlet_sea_glass_pane_top"));

        // Umber Sea glass
        this.simpleBlock(SeafarerBlocks.UMBER_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.UMBER_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.UMBER_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.UMBER_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.UMBER_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.UMBER_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.UMBER_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.UMBER_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.UMBER_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.UMBER_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/umber_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/umber_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.UMBER_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.UMBER_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.UMBER_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.UMBER_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.UMBER_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/umber_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.UMBER_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.UMBER_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/umber_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.UMBER_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.UMBER_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/umber_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/umber_sea_glass_pane_top"));

        // Pearly Sea glass
        this.simpleBlock(SeafarerBlocks.PEARLY_PEBBLED_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.PEARLY_PEBBLED_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.PEARLY_PEBBLED_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.PEARLY_SEA_GLASS.get());
        this.simpleBlockItem(SeafarerBlocks.PEARLY_SEA_GLASS.get(), existingModel((getName(SeafarerBlocks.PEARLY_SEA_GLASS.get()))));

        this.simpleBlock(SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS.get());
        this.simpleBlockItem(SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS.get(), existingModel((getName(SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS.get()))));
        this.slabBlock(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get(), resourceBlock(getName(SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS.get())), new ResourceLocation(Seafarer.MOD_ID, "block/pearly_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get(), existingModel((getName(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/pearly_sea_glass_bricks"));
        this.simpleBlockItem(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get(), existingModel((getName(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get()))));

        this.simpleBlock(SeafarerBlocks.PEARLY_SEA_GLASS_TILES.get());
        this.simpleBlockItem(SeafarerBlocks.PEARLY_SEA_GLASS_TILES.get(), existingModel((getName(SeafarerBlocks.PEARLY_SEA_GLASS_TILES.get()))));
        this.slabBlock(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.PEARLY_SEA_GLASS_TILES.get())), new ResourceLocation(Seafarer.MOD_ID, "block/pearly_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get(), existingModel((getName(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get()))));
        this.stairsBlock(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/pearly_sea_glass_tiles"));
        this.simpleBlockItem(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get(), existingModel((getName(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get()))));
        this.directionalBlock(SeafarerBlocks.PEARLY_SEA_GLASS_LAMP);

        this.paneBlock(SeafarerBlocks.PEARLY_SEA_GLASS_PANE.get(), new ResourceLocation(Seafarer.MOD_ID, "block/pearly_sea_glass"), new ResourceLocation(Seafarer.MOD_ID, "block/pearly_sea_glass_pane_top"));

        //NEW SHELL BLOCKS

        //Clam

        logBlock(SeafarerBlocks.CLAM_SHELL_PILLAR.get());
        simpleBlockItem(SeafarerBlocks.CLAM_SHELL_PILLAR.get(), existingModel((getName(SeafarerBlocks.CLAM_SHELL_PILLAR.get()))));

        simpleBlock(SeafarerBlocks.CLAM_SHELL_BRICKS.get());
        simpleBlockItem(SeafarerBlocks.CLAM_SHELL_BRICKS.get(), existingModel((getName(SeafarerBlocks.CLAM_SHELL_BRICKS.get()))));

        slabBlock(SeafarerBlocks.CLAM_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SeafarerBlocks.CLAM_SHELL_BRICKS_SLAB.get())), new ResourceLocation(Seafarer.MOD_ID, "block/clam_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.CLAM_SHELL_BRICKS_SLAB.get(), existingModel((getName(SeafarerBlocks.CLAM_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SeafarerBlocks.CLAM_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/clam_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.CLAM_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SeafarerBlocks.CLAM_SHELL_BRICKS_STAIRS.get()))));

        //Horn

        logBlock(SeafarerBlocks.HORN_SHELL_PILLAR.get());
        simpleBlockItem(SeafarerBlocks.HORN_SHELL_PILLAR.get(), existingModel((getName(SeafarerBlocks.HORN_SHELL_PILLAR.get()))));

        simpleBlock(SeafarerBlocks.HORN_SHELL_BRICKS.get());
        simpleBlockItem(SeafarerBlocks.HORN_SHELL_BRICKS.get(), existingModel((getName(SeafarerBlocks.HORN_SHELL_BRICKS.get()))));

        slabBlock(SeafarerBlocks.HORN_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SeafarerBlocks.HORN_SHELL_BRICKS_SLAB.get())), new ResourceLocation(Seafarer.MOD_ID, "block/horn_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.HORN_SHELL_BRICKS_SLAB.get(), existingModel((getName(SeafarerBlocks.HORN_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SeafarerBlocks.HORN_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/horn_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.HORN_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SeafarerBlocks.HORN_SHELL_BRICKS_STAIRS.get()))));

        //Horn

        logBlock(SeafarerBlocks.SPIKY_SHELL_PILLAR.get());
        simpleBlockItem(SeafarerBlocks.SPIKY_SHELL_PILLAR.get(), existingModel((getName(SeafarerBlocks.SPIKY_SHELL_PILLAR.get()))));

        simpleBlock(SeafarerBlocks.SPIKY_SHELL_BRICKS.get());
        simpleBlockItem(SeafarerBlocks.SPIKY_SHELL_BRICKS.get(), existingModel((getName(SeafarerBlocks.SPIKY_SHELL_BRICKS.get()))));

        slabBlock(SeafarerBlocks.SPIKY_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SeafarerBlocks.SPIKY_SHELL_BRICKS_SLAB.get())), new ResourceLocation(Seafarer.MOD_ID, "block/spiky_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.SPIKY_SHELL_BRICKS_SLAB.get(), existingModel((getName(SeafarerBlocks.SPIKY_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SeafarerBlocks.SPIKY_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/spiky_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.SPIKY_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SeafarerBlocks.SPIKY_SHELL_BRICKS_STAIRS.get()))));

        //Spiral

        logBlock(SeafarerBlocks.SPIRAL_SHELL_PILLAR.get());
        simpleBlockItem(SeafarerBlocks.SPIRAL_SHELL_PILLAR.get(), existingModel((getName(SeafarerBlocks.SPIRAL_SHELL_PILLAR.get()))));

        simpleBlock(SeafarerBlocks.SPIRAL_SHELL_BRICKS.get());
        simpleBlockItem(SeafarerBlocks.SPIRAL_SHELL_BRICKS.get(), existingModel((getName(SeafarerBlocks.SPIRAL_SHELL_BRICKS.get()))));

        slabBlock(SeafarerBlocks.SPIRAL_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SeafarerBlocks.SPIRAL_SHELL_BRICKS_SLAB.get())), new ResourceLocation(Seafarer.MOD_ID, "block/spiral_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.SPIRAL_SHELL_BRICKS_SLAB.get(), existingModel((getName(SeafarerBlocks.SPIRAL_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SeafarerBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/spiral_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SeafarerBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get()))));

        //Swirl

        logBlock(SeafarerBlocks.SWIRL_SHELL_PILLAR.get());
        simpleBlockItem(SeafarerBlocks.SWIRL_SHELL_PILLAR.get(), existingModel((getName(SeafarerBlocks.SWIRL_SHELL_PILLAR.get()))));

        simpleBlock(SeafarerBlocks.SWIRL_SHELL_BRICKS.get());
        simpleBlockItem(SeafarerBlocks.SWIRL_SHELL_BRICKS.get(), existingModel((getName(SeafarerBlocks.SWIRL_SHELL_BRICKS.get()))));

        slabBlock(SeafarerBlocks.SWIRL_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SeafarerBlocks.SWIRL_SHELL_BRICKS_SLAB.get())), new ResourceLocation(Seafarer.MOD_ID, "block/swirl_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.SWIRL_SHELL_BRICKS_SLAB.get(), existingModel((getName(SeafarerBlocks.SWIRL_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SeafarerBlocks.SWIRL_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/swirl_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.SWIRL_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SeafarerBlocks.SWIRL_SHELL_BRICKS_STAIRS.get()))));

        //Pyramid


        logBlock(SeafarerBlocks.PYRAMID_SHELL_PILLAR.get());
        simpleBlockItem(SeafarerBlocks.PYRAMID_SHELL_PILLAR.get(), existingModel((getName(SeafarerBlocks.PYRAMID_SHELL_PILLAR.get()))));

        simpleBlock(SeafarerBlocks.PYRAMID_SHELL_BRICKS.get());
        simpleBlockItem(SeafarerBlocks.PYRAMID_SHELL_BRICKS.get(), existingModel((getName(SeafarerBlocks.PYRAMID_SHELL_BRICKS.get()))));

        slabBlock(SeafarerBlocks.PYRAMID_SHELL_BRICKS_SLAB.get(), resourceBlock(getName(SeafarerBlocks.PYRAMID_SHELL_BRICKS_SLAB.get())), new ResourceLocation(Seafarer.MOD_ID, "block/pyramid_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.PYRAMID_SHELL_BRICKS_SLAB.get(), existingModel((getName(SeafarerBlocks.PYRAMID_SHELL_BRICKS_SLAB.get()))));

        stairsBlock(SeafarerBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/pyramid_shell_bricks"));
        simpleBlockItem(SeafarerBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get(), existingModel((getName(SeafarerBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get()))));


        //Sand

        simpleBlock(SeafarerBlocks.BLUE_MIXED_SPRINKLED_SAND.get());
        simpleBlockItem(SeafarerBlocks.BLUE_MIXED_SPRINKLED_SAND.get(), existingModel((getName(SeafarerBlocks.BLUE_MIXED_SPRINKLED_SAND.get()))));

        simpleBlock(SeafarerBlocks.RED_MIXED_SPRINKLED_SAND.get());
        simpleBlockItem(SeafarerBlocks.RED_MIXED_SPRINKLED_SAND.get(), existingModel((getName(SeafarerBlocks.RED_MIXED_SPRINKLED_SAND.get()))));

        simpleBlock(SeafarerBlocks.BLUE_SPRINKLED_SAND.get());
        simpleBlockItem(SeafarerBlocks.BLUE_SPRINKLED_SAND.get(), existingModel((getName(SeafarerBlocks.BLUE_SPRINKLED_SAND.get()))));

        simpleBlock(SeafarerBlocks.PINK_SPRINKLED_SAND.get());
        simpleBlockItem(SeafarerBlocks.PINK_SPRINKLED_SAND.get(), existingModel((getName(SeafarerBlocks.PINK_SPRINKLED_SAND.get()))));

        simpleBlock(SeafarerBlocks.PURPLE_SPRINKLED_SAND.get());
        simpleBlockItem(SeafarerBlocks.PURPLE_SPRINKLED_SAND.get(), existingModel((getName(SeafarerBlocks.PURPLE_SPRINKLED_SAND.get()))));

        simpleBlock(SeafarerBlocks.RED_SPRINKLED_SAND.get());
        simpleBlockItem(SeafarerBlocks.RED_SPRINKLED_SAND.get(), existingModel((getName(SeafarerBlocks.RED_SPRINKLED_SAND.get()))));

        simpleBlock(SeafarerBlocks.GRAVELY_SAND.get());
        simpleBlockItem(SeafarerBlocks.GRAVELY_SAND.get(), existingModel((getName(SeafarerBlocks.GRAVELY_SAND.get()))));

        simpleBlock(SeafarerBlocks.ROCKY_SAND.get());
        simpleBlockItem(SeafarerBlocks.ROCKY_SAND.get(), existingModel((getName(SeafarerBlocks.ROCKY_SAND.get()))));

        simpleBlock(SeafarerBlocks.MIXED_SHELLY_SAND.get());
        simpleBlockItem(SeafarerBlocks.MIXED_SHELLY_SAND.get(), existingModel((getName(SeafarerBlocks.MIXED_SHELLY_SAND.get()))));

        simpleBlock(SeafarerBlocks.SCATTERED_SHELLY_SAND.get());
        simpleBlockItem(SeafarerBlocks.SCATTERED_SHELLY_SAND.get(), existingModel((getName(SeafarerBlocks.SCATTERED_SHELLY_SAND.get()))));

        simpleBlock(SeafarerBlocks.JUMBLED_SHELLY_SAND.get());
        simpleBlockItem(SeafarerBlocks.JUMBLED_SHELLY_SAND.get(), existingModel((getName(SeafarerBlocks.JUMBLED_SHELLY_SAND.get()))));

        simpleBlock(SeafarerBlocks.CORAL_SAND.get());
        simpleBlockItem(SeafarerBlocks.CORAL_SAND.get(), existingModel((getName(SeafarerBlocks.CORAL_SAND.get()))));



        simpleBlock(SeafarerBlocks.SALT_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.SALT_BLOCK.get(), existingModel((getName(SeafarerBlocks.SALT_BLOCK.get()))));

        createPottedPlant(SeafarerBlocks.SEA_THRIFT, SeafarerBlocks.POTTED_SEA_THRIFT, "cutout");
        createPottedPlant(SeafarerBlocks.SEA_HOLLY, SeafarerBlocks.POTTED_SEA_HOLLY, "cutout");
        createPottedPlant(SeafarerBlocks.COASTAL_LAVENDER, SeafarerBlocks.POTTED_COASTAL_LAVENDER, "cutout");
        createPottedPlant(SeafarerBlocks.COASTAL_WILDFLOWER, SeafarerBlocks.POTTED_COASTAL_WILDFLOWER, "cutout");


        simpleBlock(SeafarerBlocks.ALGAE_COBBLESTONE.get());
        simpleBlockItem(SeafarerBlocks.ALGAE_COBBLESTONE.get(), existingModel((getName(SeafarerBlocks.ALGAE_COBBLESTONE.get()))));

        slabBlock(SeafarerBlocks.ALGAE_COBBLESTONE_SLAB.get(), resourceBlock(getName(SeafarerBlocks.ALGAE_COBBLESTONE.get())), new ResourceLocation(Seafarer.MOD_ID, "block/algae_cobblestone"));
        simpleBlockItem(SeafarerBlocks.ALGAE_COBBLESTONE_SLAB.get(), existingModel((getName(SeafarerBlocks.ALGAE_COBBLESTONE_SLAB.get()))));

        stairsBlock(SeafarerBlocks.ALGAE_COBBLESTONE_STAIRS.get(), new ResourceLocation(Seafarer.MOD_ID, "block/algae_cobblestone"));
        simpleBlockItem(SeafarerBlocks.ALGAE_COBBLESTONE_STAIRS.get(), existingModel((getName(SeafarerBlocks.ALGAE_COBBLESTONE_STAIRS.get()))));

        //CORAL
        simpleBlock(SeafarerBlocks.DEAD_AMBER_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.DEAD_AMBER_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.DEAD_AMBER_CORAL_BLOCK.get()))));
        simpleBlock(SeafarerBlocks.AMBER_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.AMBER_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.AMBER_CORAL_BLOCK.get()))));

        simpleBlock(SeafarerBlocks.DEAD_CERULEAN_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.DEAD_CERULEAN_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.DEAD_CERULEAN_CORAL_BLOCK.get()))));
        simpleBlock(SeafarerBlocks.CERULEAN_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.CERULEAN_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.CERULEAN_CORAL_BLOCK.get()))));

        simpleBlock(SeafarerBlocks.DEAD_MAROON_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.DEAD_MAROON_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.DEAD_MAROON_CORAL_BLOCK.get()))));
        simpleBlock(SeafarerBlocks.MAROON_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.MAROON_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.MAROON_CORAL_BLOCK.get()))));

        simpleBlock(SeafarerBlocks.DEAD_OLIVE_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.DEAD_OLIVE_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.DEAD_OLIVE_CORAL_BLOCK.get()))));
        simpleBlock(SeafarerBlocks.OLIVE_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.OLIVE_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.OLIVE_CORAL_BLOCK.get()))));

        simpleBlock(SeafarerBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get()))));
        simpleBlock(SeafarerBlocks.TURQUOISE_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.TURQUOISE_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.TURQUOISE_CORAL_BLOCK.get()))));

        simpleBlock(SeafarerBlocks.DEAD_VERDANT_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.DEAD_VERDANT_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.DEAD_VERDANT_CORAL_BLOCK.get()))));
        simpleBlock(SeafarerBlocks.VERDANT_CORAL_BLOCK.get());
        simpleBlockItem(SeafarerBlocks.VERDANT_CORAL_BLOCK.get(), existingModel((getName(SeafarerBlocks.VERDANT_CORAL_BLOCK.get()))));

        simpleBlock(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE.get());
        simpleBlockItem(SeafarerBlocks.CUT_CORALINE_SANDSTONE.get(), existingModel((getName(SeafarerBlocks.CUT_CORALINE_SANDSTONE.get()))));
        simpleBlockItem(SeafarerBlocks.CHISELED_CORALINE_SANDSTONE.get(), existingModel((getName(SeafarerBlocks.CHISELED_CORALINE_SANDSTONE.get()))));
        simpleBlockItem(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE.get(), existingModel((getName(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE.get()))));
        simpleBlockItem(SeafarerBlocks.CORALINE_SANDSTONE.get(), existingModel((getName(SeafarerBlocks.CORALINE_SANDSTONE.get()))));

        simpleBlockItem(SeafarerBlocks.CORALINE_SANDSTONE_SLAB.get(), existingModel((getName(SeafarerBlocks.CORALINE_SANDSTONE_SLAB.get()))));

        simpleBlockItem(SeafarerBlocks.CORALINE_SANDSTONE_STAIRS.get(), existingModel((getName(SeafarerBlocks.CORALINE_SANDSTONE_STAIRS.get()))));

        simpleBlockItem(SeafarerBlocks.CUT_CORALINE_SANDSTONE_SLAB.get(), existingModel((getName(SeafarerBlocks.CUT_CORALINE_SANDSTONE_SLAB.get()))));

        simpleBlockItem(SeafarerBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get(), existingModel((getName(SeafarerBlocks.CUT_CORALINE_SANDSTONE_STAIRS.get()))));

        simpleBlockItem(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get(), existingModel((getName(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get()))));

        simpleBlockItem(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get(), existingModel((getName(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get()))));

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
        return generated(name(block), new ResourceLocation(Seafarer.MOD_ID, "registerItemNoLang/" + name(block)));
    }

    private BlockModelBuilder singleTex(Block block) {
        return singleTex(block,  name(block));
    }

    private BlockModelBuilder singleTex(Block block, String name) {
        return generated(name(block), new ResourceLocation(Seafarer.MOD_ID, "block/" + name));
    }

    private BlockModelBuilder generated(String name, ResourceLocation... layers) {
        BlockModelBuilder builder = models().withExistingParent("registerItemNoLang/" + name, "registerItemNoLang/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }


    public ModelFile createFlatWaterEgg(Block block, String modifier){
        String baseName = getName(block);
        return models().singleTexture("block/eggs/" + modifier + baseName.replace(Seafarer.MOD_ID + ":", ""), new ResourceLocation(Seafarer.MOD_ID, "block/template_eggs/template_flat_water_egg"), blockTextureEggs(block));
    }

    public ResourceLocation blockTextureEggs(Block block) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/eggs/" + name.getPath());
    }
    
    private String name(Block block) {
        return key(block).getPath();
    }

    private String getName(Block block) {
        return key(block).toString().replace(Seafarer.MOD_ID + ":", "");
    }

    public void block(Block block) {
        this.simpleBlock(block);
        this.blockItem(block);
    }

    public void block(RegistryObject<Block> block) {
        this.block(block.get());
    }

    public void blockItem(Block block) {
        this.simpleBlockItem(block, new ExistingModelFile(blockTexture(block), this.models().existingFileHelper));
    }

    public void blockItem(RegistryObject<Block> block) {
        this.blockItem(block.get());
    }

    public void directionalBlock(RegistryObject<Block> block, ResourceLocation sideTexture, ResourceLocation bottomTexture, ResourceLocation topTexture) {
        this.directionalBlock(block.get(), models().cubeBottomTop(name(block.get()), sideTexture, bottomTexture, topTexture));
        this.blockItem(block);
    }

    public void directionalBlock(RegistryObject<Block> block) {
        ResourceLocation blockTexture = blockTexture(block.get());
        this.directionalBlock(block, suffix(blockTexture, "_side"), suffix(blockTexture, "_bottom"), suffix(blockTexture, "_top"));
    }

    public static ResourceLocation suffix(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

    private Block getBlock(ResourceLocation resourceLocation) {
        return BuiltInRegistries.BLOCK.get(resourceLocation);
    }

    @Override
    public String getName() {
        return "Block States: " + Seafarer.MOD_ID;
    }
}
