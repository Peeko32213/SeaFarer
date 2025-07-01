package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.blocks.*;
import com.peeko32213.seafarer.blocks.shell.PyramidShellBlock;
import com.peeko32213.seafarer.blocks.shell.ShellBlock;
import com.peeko32213.seafarer.blocks.starfish.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SeafarerBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SeaFarer.MODID);
    public static List<RegistryObject<? extends Block>> AUTO_TRANSLATE = new ArrayList<>();

    public static final RegistryObject<Block> AZURE_SEA_GLASS_PEBBLES = registerBlock("azure_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> AZURE_PEBBLED_SEA_GLASS = registerBlock("azure_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> AZURE_SEA_GLASS = registerBlock("azure_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BLUE)));
    public static final RegistryObject<IronBarsBlock> AZURE_SEA_GLASS_PANE = registerBlock("azure_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> AZURE_SEA_GLASS_BRICKS = registerBlock("azure_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BLUE)));
    public static final RegistryObject<StairBlock> AZURE_SEA_GLASS_BRICK_STAIRS = registerBlock("azure_sea_glass_brick_stairs", () -> new StairBlock(() -> AZURE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(AZURE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> AZURE_SEA_GLASS_BRICK_SLAB = registerBlock("azure_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(AZURE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> AZURE_SEA_GLASS_TILES = registerBlock("azure_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BLUE)));
    public static final RegistryObject<StairBlock> AZURE_SEA_GLASS_TILE_STAIRS = registerBlock("azure_sea_glass_tile_stairs", () -> new StairBlock(() -> AZURE_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(AZURE_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> AZURE_SEA_GLASS_TILE_SLAB = registerBlock("azure_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(AZURE_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> AZURE_SEA_GLASS_LAMP = registerBlock("azure_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> AZURE_SEA_GLASS_BOTTLE = registerBlock("azure_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_BLUE)));

    public static final RegistryObject<Block> ROSE_SEA_GLASS_PEBBLES = registerBlock("rose_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_PEBBLED_SEA_GLASS = registerBlock("rose_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_SEA_GLASS = registerBlock("rose_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_PINK)));
    public static final RegistryObject<IronBarsBlock> ROSE_SEA_GLASS_PANE = registerBlock("rose_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_BRICKS = registerBlock("rose_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PINK)));
    public static final RegistryObject<StairBlock> ROSE_SEA_GLASS_BRICK_STAIRS = registerBlock("rose_sea_glass_brick_stairs", () -> new StairBlock(() -> ROSE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ROSE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> ROSE_SEA_GLASS_BRICK_SLAB = registerBlock("rose_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ROSE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_TILES = registerBlock("rose_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PINK)));
    public static final RegistryObject<StairBlock> ROSE_SEA_GLASS_TILE_STAIRS = registerBlock("rose_sea_glass_tile_stairs", () -> new StairBlock(() -> ROSE_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(ROSE_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> ROSE_SEA_GLASS_TILE_SLAB = registerBlock("rose_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ROSE_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_LAMP = registerBlock("rose_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_BOTTLE = registerBlock("rose_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_PINK)));

    public static final RegistryObject<Block> LILAC_SEA_GLASS_PEBBLES = registerBlock("lilac_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_PEBBLED_SEA_GLASS = registerBlock("lilac_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_SEA_GLASS = registerBlock("lilac_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<IronBarsBlock> LILAC_SEA_GLASS_PANE = registerBlock("lilac_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_BRICKS = registerBlock("lilac_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<StairBlock> LILAC_SEA_GLASS_BRICK_STAIRS = registerBlock("lilac_sea_glass_brick_stairs", () -> new StairBlock(() -> LILAC_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LILAC_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> LILAC_SEA_GLASS_BRICK_SLAB = registerBlock("lilac_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(LILAC_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_TILES = registerBlock("lilac_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<StairBlock> LILAC_SEA_GLASS_TILE_STAIRS = registerBlock("lilac_sea_glass_tile_stairs", () -> new StairBlock(() -> LILAC_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(LILAC_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> LILAC_SEA_GLASS_TILE_SLAB = registerBlock("lilac_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(LILAC_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_LAMP = registerBlock("lilac_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_BOTTLE = registerBlock("lilac_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_PURPLE)));

    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_PEBBLES = registerBlock("seafoam_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_PEBBLED_SEA_GLASS = registerBlock("seafoam_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS = registerBlock("seafoam_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_GREEN)));
    public static final RegistryObject<IronBarsBlock> SEAFOAM_SEA_GLASS_PANE = registerBlock("seafoam_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_BRICKS = registerBlock("seafoam_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_GREEN)));
    public static final RegistryObject<StairBlock> SEAFOAM_SEA_GLASS_BRICK_STAIRS = registerBlock("seafoam_sea_glass_brick_stairs", () -> new StairBlock(() -> SEAFOAM_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SEAFOAM_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> SEAFOAM_SEA_GLASS_BRICK_SLAB = registerBlock("seafoam_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SEAFOAM_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_TILES = registerBlock("seafoam_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_GREEN)));
    public static final RegistryObject<StairBlock> SEAFOAM_SEA_GLASS_TILE_STAIRS = registerBlock("seafoam_sea_glass_tile_stairs", () -> new StairBlock(() -> SEAFOAM_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(SEAFOAM_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> SEAFOAM_SEA_GLASS_TILE_SLAB = registerBlock("seafoam_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SEAFOAM_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_LAMP = registerBlock("seafoam_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_BOTTLE = registerBlock("seafoam_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_GREEN)));

    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_PEBBLES = registerBlock("chartreuse_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_PEBBLED_SEA_GLASS = registerBlock("chartreuse_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS = registerBlock("chartreuse_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<IronBarsBlock> CHARTREUSE_SEA_GLASS_PANE = registerBlock("chartreuse_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_BRICKS = registerBlock("chartreuse_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<StairBlock> CHARTREUSE_SEA_GLASS_BRICK_STAIRS = registerBlock("chartreuse_sea_glass_brick_stairs", () -> new StairBlock(() -> CHARTREUSE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CHARTREUSE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> CHARTREUSE_SEA_GLASS_BRICK_SLAB = registerBlock("chartreuse_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CHARTREUSE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_TILES = registerBlock("chartreuse_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<StairBlock> CHARTREUSE_SEA_GLASS_TILE_STAIRS = registerBlock("chartreuse_sea_glass_tile_stairs", () -> new StairBlock(() -> CHARTREUSE_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(CHARTREUSE_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> CHARTREUSE_SEA_GLASS_TILE_SLAB = registerBlock("chartreuse_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CHARTREUSE_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_LAMP = registerBlock("chartreuse_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_BOTTLE = registerBlock("chartreuse_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_LIGHT_GREEN)));

    public static final RegistryObject<Block> CITRINE_SEA_GLASS_PEBBLES = registerBlock("citrine_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_PEBBLED_SEA_GLASS = registerBlock("citrine_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS = registerBlock("citrine_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<IronBarsBlock> CITRINE_SEA_GLASS_PANE = registerBlock("citrine_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_BRICKS = registerBlock("citrine_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<StairBlock> CITRINE_SEA_GLASS_BRICK_STAIRS = registerBlock("citrine_sea_glass_brick_stairs", () -> new StairBlock(() -> CITRINE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CITRINE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> CITRINE_SEA_GLASS_BRICK_SLAB = registerBlock("citrine_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CITRINE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_TILES = registerBlock("citrine_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<StairBlock> CITRINE_SEA_GLASS_TILE_STAIRS = registerBlock("citrine_sea_glass_tile_stairs", () -> new StairBlock(() -> CITRINE_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(CITRINE_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> CITRINE_SEA_GLASS_TILE_SLAB = registerBlock("citrine_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CITRINE_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_LAMP = registerBlock("citrine_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_BOTTLE = registerBlock("citrine_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> AMBER_SEA_GLASS_PEBBLES = registerBlock("amber_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_PEBBLED_SEA_GLASS = registerBlock("amber_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_SEA_GLASS = registerBlock("amber_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<IronBarsBlock> AMBER_SEA_GLASS_PANE = registerBlock("amber_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_BRICKS = registerBlock("amber_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<StairBlock> AMBER_SEA_GLASS_BRICK_STAIRS = registerBlock("amber_sea_glass_brick_stairs", () -> new StairBlock(() -> AMBER_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(AMBER_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> AMBER_SEA_GLASS_BRICK_SLAB = registerBlock("amber_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(AMBER_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_TILES = registerBlock("amber_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<StairBlock> AMBER_SEA_GLASS_TILE_STAIRS = registerBlock("amber_sea_glass_tile_stairs", () -> new StairBlock(() -> AMBER_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(AMBER_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> AMBER_SEA_GLASS_TILE_SLAB = registerBlock("amber_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(AMBER_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_LAMP = registerBlock("amber_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_BOTTLE = registerBlock("amber_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_ORANGE)));

    public static final RegistryObject<Block> SCARLET_SEA_GLASS_PEBBLES = registerBlock("scarlet_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_PEBBLED_SEA_GLASS = registerBlock("scarlet_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS = registerBlock("scarlet_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_RED)));
    public static final RegistryObject<IronBarsBlock> SCARLET_SEA_GLASS_PANE = registerBlock("scarlet_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_BRICKS = registerBlock("scarlet_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_RED)));
    public static final RegistryObject<StairBlock> SCARLET_SEA_GLASS_BRICK_STAIRS = registerBlock("scarlet_sea_glass_brick_stairs", () -> new StairBlock(() -> SCARLET_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCARLET_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> SCARLET_SEA_GLASS_BRICK_SLAB = registerBlock("scarlet_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCARLET_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_TILES = registerBlock("scarlet_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_RED)));
    public static final RegistryObject<StairBlock> SCARLET_SEA_GLASS_TILE_STAIRS = registerBlock("scarlet_sea_glass_tile_stairs", () -> new StairBlock(() -> SCARLET_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCARLET_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> SCARLET_SEA_GLASS_TILE_SLAB = registerBlock("scarlet_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCARLET_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_LAMP = registerBlock("scarlet_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_BOTTLE = registerBlock("scarlet_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_RED)));

    public static final RegistryObject<Block> UMBER_SEA_GLASS_PEBBLES = registerBlock("umber_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_PEBBLED_SEA_GLASS = registerBlock("umber_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_SEA_GLASS = registerBlock("umber_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BROWN)));
    public static final RegistryObject<IronBarsBlock> UMBER_SEA_GLASS_PANE = registerBlock("umber_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_BRICKS = registerBlock("umber_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BROWN)));
    public static final RegistryObject<StairBlock> UMBER_SEA_GLASS_BRICK_STAIRS = registerBlock("umber_sea_glass_brick_stairs", () -> new StairBlock(() -> UMBER_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(UMBER_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> UMBER_SEA_GLASS_BRICK_SLAB = registerBlock("umber_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(UMBER_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_TILES = registerBlock("umber_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BROWN)));
    public static final RegistryObject<StairBlock> UMBER_SEA_GLASS_TILE_STAIRS = registerBlock("umber_sea_glass_tile_stairs", () -> new StairBlock(() -> UMBER_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(UMBER_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> UMBER_SEA_GLASS_TILE_SLAB = registerBlock("umber_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(UMBER_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_LAMP = registerBlock("umber_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_BOTTLE = registerBlock("umber_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_BROWN)));

    public static final RegistryObject<Block> PEARLY_SEA_GLASS_PEBBLES = registerBlock("pearly_sea_glass_pebbles", () -> new FloorLayerBlock(SeafarerBlockProperties.seaGlassPebbles(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_PEBBLED_SEA_GLASS = registerBlock("pearly_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS = registerBlock("pearly_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<IronBarsBlock> PEARLY_SEA_GLASS_PANE = registerBlock("pearly_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_BRICKS = registerBlock("pearly_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<StairBlock> PEARLY_SEA_GLASS_BRICK_STAIRS = registerBlock("pearly_sea_glass_brick_stairs", () -> new StairBlock(() -> PEARLY_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PEARLY_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<SlabBlock> PEARLY_SEA_GLASS_BRICK_SLAB = registerBlock("pearly_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PEARLY_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_TILES = registerBlock("pearly_sea_glass_tiles", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<StairBlock> PEARLY_SEA_GLASS_TILE_STAIRS = registerBlock("pearly_sea_glass_tile_stairs", () -> new StairBlock(() -> PEARLY_SEA_GLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(PEARLY_SEA_GLASS_TILES.get())));
    public static final RegistryObject<SlabBlock> PEARLY_SEA_GLASS_TILE_SLAB = registerBlock("pearly_sea_glass_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PEARLY_SEA_GLASS_TILES.get())));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_LAMP = registerBlock("pearly_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_BOTTLE = registerBlock("pearly_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeafarerBlockProperties.seaGlassBottle(MapColor.COLOR_LIGHT_GRAY)));

    public static final RegistryObject<Block> OLD_BOARDS = registerBlock("old_boards", () -> new OldBoardsBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).ignitedByLava().strength(0.1F).mapColor(MapColor.WOOD)));

    public static final RegistryObject<Block> FISHING_NET = registerPlaceOnWaterBlockItem("fishing_net", () -> new FishingNet(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().strength(0.2F).sound(SoundType.LADDER)));

    public static final RegistryObject<Block> COMMON_ORANGE_STARFISH = registerBlock("common_orange_starfish", () -> new CommonOrangeStarfish(SeafarerBlockProperties.starfish(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> PINK_STARFISH = registerBlock("pink_starfish", () -> new PinkStarfish(SeafarerBlockProperties.starfish(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> RED_STARFISH = registerBlock("red_starfish", () -> new RedStarfish(SeafarerBlockProperties.starfish(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> CHOCOLATE_CHIP_STARFISH = registerBlock("chocolate_chip_starfish", () -> new ChocolateChipStarfish(SeafarerBlockProperties.starfish(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BLUE_STARFISH = registerBlock("blue_starfish", () -> new BlueStarfish(SeafarerBlockProperties.starfish(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PURPLE_OCHRE_STARFISH = registerBlock("purple_ochre_starfish", () -> new PurpleOchreStarfish(SeafarerBlockProperties.starfish(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> ROYAL_STARFISH = registerBlock("royal_starfish", () -> new RoyalStarfish(SeafarerBlockProperties.starfish(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> OCHRE_STARFISH = registerBlock("ochre_starfish", () -> new OchreStarfish(SeafarerBlockProperties.starfish(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> ALGAE_BLOCK = registerBlock("algae_block",
            () -> new AlgaeBlock(BlockBehaviour.Properties
                    .copy(Blocks.MOSS_BLOCK)
                    .strength(3.0F, 1.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> ALGAE_CARPET = registerBlock("algae_carpet",
            () -> new AlageCarpetBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.MOSS_CARPET)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ALGAE_PLANT = registerBlock("algae_plant", () ->
            new AlgaePlantBlock(BlockBehaviour.Properties.
                    copy(Blocks.LILY_PAD)
                    .noCollission()
                    .instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> BEACHGRASS_FAN = registerBlock("beachgrass_fan",
            () -> new LandFanBlock(BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                    .noCollission().instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> BEACHGRASS = registerBlock("beachgrass", () ->
            new SeafarerCropLikePlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .replaceable().noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEA_THRIFT = registerBlock("sea_thrift", () ->
            new SeafarerCropLikePlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.COLOR_PINK)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> POTTED_SEA_THRIFT = registerBlockNoItem("potted_sea_thrift",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SeafarerBlocks.SEA_THRIFT, BlockBehaviour
                    .Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));



    public static final RegistryObject<Block> SEA_HOLLY = registerBlock("sea_holly", () ->
            new SandPlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> POTTED_SEA_HOLLY = registerBlockNoItem("potted_sea_holly",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SeafarerBlocks.SEA_HOLLY, BlockBehaviour
                    .Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> COASTAL_LAVENDER = registerBlock("coastal_lavender", () ->
            new SandPlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.COLOR_PURPLE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> POTTED_COASTAL_LAVENDER = registerBlockNoItem("potted_coastal_lavender",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SeafarerBlocks.COASTAL_LAVENDER, BlockBehaviour
                    .Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));


    public static final RegistryObject<Block> COASTAL_WILDFLOWER = registerBlock("coastal_wildflower", () ->
            new SandPlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> POTTED_COASTAL_WILDFLOWER = registerBlockNoItem("potted_coastal_wildflower",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SeafarerBlocks.COASTAL_WILDFLOWER, BlockBehaviour
                    .Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> SALT_BLOCK = register("salt_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 1.0F)
                    .requiresCorrectToolForDrops()
            ));

    // Shells
    public static final RegistryObject<Block> CLAM_SHELL = registerBlock("clam_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> HORN_SHELL = registerBlock("horn_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SPIKY_SHELL = registerBlock("spiky_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SPIRAL_SHELL = registerBlock("spiral_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SWIRL_SHELL = registerBlock("swirl_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PYRAMID_SHELL = registerBlock("pyramid_shell", () -> new PyramidShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> CLAM_SHELL_BRICKS = register("clam_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> CLAM_SHELL_BRICKS_SLAB = registerBlock("clam_shell_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(CLAM_SHELL_BRICKS.get())));

    public static final RegistryObject<StairBlock> CLAM_SHELL_BRICKS_STAIRS = registerBlock("clam_shell_bricks_stairs",
            () -> new StairBlock(() -> CLAM_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(CLAM_SHELL_BRICKS.get())));

    public static final RegistryObject<RotatedPillarBlock> CLAM_SHELL_PILLAR = register("clam_shell_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(SeafarerBlocks.CLAM_SHELL_BRICKS.get())
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HORN_SHELL_BRICKS = register("horn_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> HORN_SHELL_BRICKS_SLAB = registerBlock("horn_shell_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(HORN_SHELL_BRICKS.get())));

    public static final RegistryObject<StairBlock> HORN_SHELL_BRICKS_STAIRS = registerBlock("horn_shell_bricks_stairs",
            () -> new StairBlock(() -> HORN_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(HORN_SHELL_BRICKS.get())));

    public static final RegistryObject<RotatedPillarBlock> HORN_SHELL_PILLAR = register("horn_shell_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(SeafarerBlocks.HORN_SHELL_BRICKS.get())
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> SPIKY_SHELL_BRICKS = register("spiky_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> SPIKY_SHELL_BRICKS_SLAB = registerBlock("spiky_shell_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(SPIKY_SHELL_BRICKS.get())));

    public static final RegistryObject<StairBlock> SPIKY_SHELL_BRICKS_STAIRS = registerBlock("spiky_shell_bricks_stairs",
            () -> new StairBlock(() -> SPIKY_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(SPIKY_SHELL_BRICKS.get())));

    public static final RegistryObject<RotatedPillarBlock> SPIKY_SHELL_PILLAR = register("spiky_shell_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(SeafarerBlocks.SPIKY_SHELL_BRICKS.get())
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> SPIRAL_SHELL_BRICKS = register("spiral_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> SPIRAL_SHELL_BRICKS_SLAB = registerBlock("spiral_shell_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(SPIRAL_SHELL_BRICKS.get())));

    public static final RegistryObject<StairBlock> SPIRAL_SHELL_BRICKS_STAIRS = registerBlock("spiral_shell_bricks_stairs",
            () -> new StairBlock(() -> SPIRAL_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(SPIRAL_SHELL_BRICKS.get())));

    public static final RegistryObject<RotatedPillarBlock> SPIRAL_SHELL_PILLAR = register("spiral_shell_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(SeafarerBlocks.SPIRAL_SHELL_BRICKS.get())
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> SWIRL_SHELL_BRICKS = register("swirl_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> SWIRL_SHELL_BRICKS_SLAB = registerBlock("swirl_shell_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(SWIRL_SHELL_BRICKS.get())));

    public static final RegistryObject<StairBlock> SWIRL_SHELL_BRICKS_STAIRS = registerBlock("swirl_shell_bricks_stairs",
            () -> new StairBlock(() -> SWIRL_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(SWIRL_SHELL_BRICKS.get())));

    public static final RegistryObject<RotatedPillarBlock> SWIRL_SHELL_PILLAR = register("swirl_shell_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(SeafarerBlocks.SWIRL_SHELL_BRICKS.get())
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> BLUE_MIXED_SPRINKLED_SAND = register("blue_mixed_sprinkled_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> RED_MIXED_SPRINKLED_SAND = register("red_mixed_sprinkled_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> BLUE_SPRINKLED_SAND = register("blue_sprinkled_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> PINK_SPRINKLED_SAND = register("pink_sprinkled_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> PURPLE_SPRINKLED_SAND = register("purple_sprinkled_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> RED_SPRINKLED_SAND = register("red_sprinkled_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> GRAVELY_SAND = register("gravely_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> ROCKY_SAND = register("rocky_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block>  MIXED_SHELLY_SAND = register("mixed_shelly_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> SCATTERED_SHELLY_SAND = register("scattered_shelly_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> JUMBLED_SHELLY_SAND = register("jumbled_shelly_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> PYRAMID_SHELL_BRICKS = register("pyramid_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> PYRAMID_SHELL_BRICKS_SLAB = registerBlock("pyramid_shell_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(PYRAMID_SHELL_BRICKS.get())));

    public static final RegistryObject<StairBlock> PYRAMID_SHELL_BRICKS_STAIRS = registerBlock("pyramid_shell_bricks_stairs",
            () -> new StairBlock(() -> PYRAMID_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(PYRAMID_SHELL_BRICKS.get())));

    public static final RegistryObject<RotatedPillarBlock> PYRAMID_SHELL_PILLAR = register("pyramid_shell_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(SeafarerBlocks.PYRAMID_SHELL_BRICKS.get())
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> FLOATSOME = register("floatsome", () -> new FloorLayerBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.CHERRY_WOOD).noCollission().noOcclusion().replaceable().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ALGAE_COBBLESTONE = register("algae_cobblestone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.COBBLESTONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> ALGAE_COBBLESTONE_SLAB = registerBlock("algae_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(ALGAE_COBBLESTONE.get())));

    public static final RegistryObject<StairBlock> ALGAE_COBBLESTONE_STAIRS = registerBlock("algae_cobblestone_stairs",
            () -> new StairBlock(() -> ALGAE_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(ALGAE_COBBLESTONE.get())));

    public static final RegistryObject<Block> DEAD_AMBER_CORAL = registerBlock("dead_amber_coral", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> AMBER_CORAL = registerBlock("amber_coral", () ->
            new CoralPlantBlock(DEAD_AMBER_CORAL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .noCollission().instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_AMBER_CORAL_BLOCK = register("dead_amber_coral_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)));

    public static final RegistryObject<Block> AMBER_CORAL_BLOCK = register("amber_coral_block",
            () -> new CoralBlock(DEAD_AMBER_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
                    .sound(SoundType.CORAL_BLOCK)));

    public static final RegistryObject<Block> DEAD_AMBER_CORAL_FAN = BLOCKS.register("dead_amber_coral_fan", () ->
            new BaseCoralFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> DEAD_AMBER_CORAL_WALL_FAN = BLOCKS.register("dead_amber_coral_wall_fan", () ->
            new BaseCoralWallFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission().instabreak()
                    .dropsLike(DEAD_AMBER_CORAL_FAN.get())));

    public static final RegistryObject<Block> AMBER_CORAL_FAN = BLOCKS.register("amber_coral_fan", () ->
            new CoralFanBlock(DEAD_AMBER_CORAL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> AMBER_CORAL_WALL_FAN = BLOCKS.register("amber_coral_wall_fan", () ->
            new CoralWallFanBlock(DEAD_AMBER_CORAL_WALL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_WALL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .dropsLike(AMBER_CORAL_FAN.get())));

    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL = registerBlock("dead_cerulean_coral", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> CERULEAN_CORAL = registerBlock("cerulean_coral", () ->
            new CoralPlantBlock(DEAD_CERULEAN_CORAL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .noCollission().instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_BLOCK = register("dead_cerulean_coral_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)));

    public static final RegistryObject<Block> CERULEAN_CORAL_BLOCK = register("cerulean_coral_block",
            () -> new CoralBlock(DEAD_CERULEAN_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
                    .sound(SoundType.CORAL_BLOCK)));

    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_FAN = BLOCKS.register("dead_cerulean_coral_fan", () ->
            new BaseCoralFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_WALL_FAN = BLOCKS.register("dead_cerulean_coral_wall_fan", () ->
            new BaseCoralWallFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission().instabreak()
                    .dropsLike(DEAD_CERULEAN_CORAL_FAN.get())));

    public static final RegistryObject<Block> CERULEAN_CORAL_FAN = BLOCKS.register("cerulean_coral_fan", () ->
            new CoralFanBlock(DEAD_CERULEAN_CORAL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> CERULEAN_CORAL_WALL_FAN = BLOCKS.register("cerulean_coral_wall_fan", () ->
            new CoralWallFanBlock(DEAD_CERULEAN_CORAL_WALL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_WALL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .dropsLike(AMBER_CORAL_FAN.get())));

    public static final RegistryObject<Block> DEAD_MAROON_CORAL = registerBlock("dead_maroon_coral", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> MAROON_CORAL = registerBlock("maroon_coral", () ->
            new CoralPlantBlock(DEAD_MAROON_CORAL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission().instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_MAROON_CORAL_BLOCK = register("dead_maroon_coral_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)));

    public static final RegistryObject<Block> MAROON_CORAL_BLOCK = register("maroon_coral_block",
            () -> new CoralBlock(DEAD_MAROON_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
                    .sound(SoundType.CORAL_BLOCK)));

    public static final RegistryObject<Block> DEAD_MAROON_CORAL_FAN = BLOCKS.register("dead_maroon_coral_fan", () ->
            new BaseCoralFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> DEAD_MAROON_CORAL_WALL_FAN = BLOCKS.register("dead_maroon_coral_wall_fan", () ->
            new BaseCoralWallFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission().instabreak()
                    .dropsLike(DEAD_MAROON_CORAL_FAN.get())));

    public static final RegistryObject<Block> MAROON_CORAL_FAN = BLOCKS.register("maroon_coral_fan", () ->
            new CoralFanBlock(DEAD_MAROON_CORAL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> MAROON_CORAL_WALL_FAN = BLOCKS.register("maroon_coral_wall_fan", () ->
            new CoralWallFanBlock(DEAD_MAROON_CORAL_WALL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_WALL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .dropsLike(MAROON_CORAL_FAN.get())));

    public static final RegistryObject<Block> DEAD_OLIVE_CORAL = registerBlock("dead_olive_coral", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> OLIVE_CORAL = registerBlock("olive_coral", () ->
            new CoralPlantBlock(DEAD_OLIVE_CORAL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission().instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_BLOCK = register("dead_olive_coral_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)));

    public static final RegistryObject<Block> OLIVE_CORAL_BLOCK = register("olive_coral_block",
            () -> new CoralBlock(DEAD_OLIVE_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
                    .sound(SoundType.CORAL_BLOCK)));

    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_FAN = BLOCKS.register("dead_olive_coral_fan", () ->
            new BaseCoralFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_WALL_FAN = BLOCKS.register("dead_olive_coral_wall_fan", () ->
            new BaseCoralWallFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission().instabreak()
                    .dropsLike(DEAD_OLIVE_CORAL_FAN.get())));

    public static final RegistryObject<Block> OLIVE_CORAL_FAN = BLOCKS.register("olive_coral_fan", () ->
            new CoralFanBlock(DEAD_OLIVE_CORAL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> OLIVE_CORAL_WALL_FAN = BLOCKS.register("olive_coral_wall_fan", () ->
            new CoralWallFanBlock(DEAD_OLIVE_CORAL_WALL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_WALL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .dropsLike(OLIVE_CORAL_FAN.get())));

    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL = registerBlock("dead_turquoise_coral", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> TURQUOISE_CORAL = registerBlock("turquoise_coral", () ->
            new CoralPlantBlock(DEAD_TURQUOISE_CORAL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .noCollission().instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_BLOCK = register("dead_turquoise_coral_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)));

    public static final RegistryObject<Block> TURQUOISE_CORAL_BLOCK = register("turquoise_coral_block",
            () -> new CoralBlock(DEAD_TURQUOISE_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
                    .sound(SoundType.CORAL_BLOCK)));

    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_FAN = BLOCKS.register("dead_turquoise_coral_fan", () ->
            new BaseCoralFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_WALL_FAN = BLOCKS.register("dead_turquoise_coral_wall_fan", () ->
            new BaseCoralWallFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission().instabreak()
                    .dropsLike(DEAD_TURQUOISE_CORAL_FAN.get())));

    public static final RegistryObject<Block> TURQUOISE_CORAL_FAN = BLOCKS.register("turquoise_coral_fan", () ->
            new CoralFanBlock(DEAD_TURQUOISE_CORAL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> TURQUOISE_CORAL_WALL_FAN = BLOCKS.register("turquoise_coral_wall_fan", () ->
            new CoralWallFanBlock(DEAD_TURQUOISE_CORAL_WALL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_WALL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .dropsLike(TURQUOISE_CORAL_FAN.get())));

    public static final RegistryObject<Block> DEAD_VERDANT_CORAL = registerBlock("dead_verdant_coral", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> VERDANT_CORAL = registerBlock("verdant_coral", () ->
            new CoralPlantBlock(DEAD_TURQUOISE_CORAL.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .noCollission().instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_BLOCK = register("dead_verdant_coral_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)));

    public static final RegistryObject<Block> VERDANT_CORAL_BLOCK = register("verdant_coral_block",
            () -> new CoralBlock(DEAD_VERDANT_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
                    .sound(SoundType.CORAL_BLOCK)));

    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_FAN = BLOCKS.register("dead_verdant_coral_fan", () ->
            new BaseCoralFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_WALL_FAN = BLOCKS.register("dead_verdant_coral_wall_fan", () ->
            new BaseCoralWallFanBlock(BlockBehaviour.Properties
                    .copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN)
                    .requiresCorrectToolForDrops()
                    .noCollission().instabreak()
                    .dropsLike(DEAD_VERDANT_CORAL_FAN.get())));

    public static final RegistryObject<Block> VERDANT_CORAL_FAN = BLOCKS.register("verdant_coral_fan", () ->
            new CoralFanBlock(DEAD_VERDANT_CORAL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> VERDANT_CORAL_WALL_FAN = BLOCKS.register("verdant_coral_wall_fan", () ->
            new CoralWallFanBlock(DEAD_VERDANT_CORAL_WALL_FAN.get(), BlockBehaviour.Properties
                    .copy(Blocks.BRAIN_CORAL_WALL_FAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .dropsLike(VERDANT_CORAL_FAN.get())));

    public static final RegistryObject<Block> CYAN_ZOA = registerBlock("cyan_zoa",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ORANGE_ZOA = registerBlock("orange_zoa",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> RED_ZOA = registerBlock("red_zoa",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> PURPLE_ZOA = registerBlock("purple_zoa",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ANTLER_GORGONIAN = registerBlock("antler_gorgonian",() ->
            new LargeCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> TOWERING_GORGONIAN = registerBlock("towering_gorgonian",() ->
            new LargeCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> BLUE_CHRISTMAS_TREE_WORM = registerBlock("blue_christmas_tree_worm",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> BLACK_CHRISTMAS_TREE_WORM = registerBlock("black_christmas_tree_worm",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> RED_CHRISTMAS_TREE_WORM = registerBlock("red_christmas_tree_worm",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> YELLOW_CHRISTMAS_TREE_WORM = registerBlock("yellow_christmas_tree_worm",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> WHITE_CHRISTMAS_TREE_WORM = registerBlock("white_christmas_tree_worm",() ->
            new FloweryCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> CORAL_SAND = register("coraline_sand",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final RegistryObject<Block> CORALINE_SANDSTONE = register("coraline_sandstone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.SANDSTONE)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> CORALINE_SANDSTONE_SLAB = registerBlock("coraline_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(CORALINE_SANDSTONE.get())));

    public static final RegistryObject<StairBlock> CORALINE_SANDSTONE_STAIRS = registerBlock("coraline_sandstone_stairs",
            () -> new StairBlock(() -> CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(CORALINE_SANDSTONE.get())));

    public static final RegistryObject<Block> CUT_CORALINE_SANDSTONE = register("cut_coraline_sandstone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.SANDSTONE)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> CUT_CORALINE_SANDSTONE_SLAB = registerBlock("cut_coraline_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(CUT_CORALINE_SANDSTONE.get())));

    public static final RegistryObject<StairBlock> CUT_CORALINE_SANDSTONE_STAIRS = registerBlock("cut_coraline_sandstone_stairs",
            () -> new StairBlock(() -> CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(CUT_CORALINE_SANDSTONE.get())));

    public static final RegistryObject<Block> CHISELED_CORALINE_SANDSTONE = register("chiseled_coraline_sandstone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.SANDSTONE)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> SMOOTH_CORALINE_SANDSTONE = register("smooth_coraline_sandstone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.SANDSTONE)
                    .strength(3.0F, 2.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> SMOOTH_CORALINE_SANDSTONE_SLAB = registerBlock("smooth_coraline_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(SMOOTH_CORALINE_SANDSTONE.get())));

    public static final RegistryObject<StairBlock> SMOOTH_CORALINE_SANDSTONE_STAIRS = registerBlock("smooth_coraline_sandstone_stairs",
            () -> new StairBlock(() -> CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(SMOOTH_CORALINE_SANDSTONE.get())));

    public static final RegistryObject<Block> SEA_GRAPES_CROP = BLOCKS.register("sea_grapes_crop",
            () -> new SeaGrapesCropBlock(Block.Properties.copy(Blocks.CARROTS).strength(0.2F)));

    public static final RegistryObject<KelpBlock> WAKAME = BLOCKS.register("wakame_block",
            () -> new WakameBlock(BlockBehaviour.Properties.copy(Blocks.KELP)));

    public static final RegistryObject<KelpPlantBlock> WAKAME_PLANT = BLOCKS.register("wakame_plant",
            () -> new WakamePlantBlock(BlockBehaviour.Properties.copy(Blocks.KELP_PLANT)));

    public static final RegistryObject<Block> SEA_URCHIN = registerBlockWithoutItem("sea_urchin_block", () -> new SeaUrchinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY).strength(1.0F)));

    public static final RegistryObject<Block> GHOUL_CORAL = registerBlock("ghoul_coral", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> PALE_SPONGE = registerBlock("pale_sponge", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    public static final RegistryObject<Block> TUBE_WORMS = registerBlock("tube_worms", () ->
            new BaseCoralPlantBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .noCollission()
                    .instabreak()));

    private static <B extends Block> RegistryObject<B> createBlockNoLang(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeafarerItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeafarerItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeafarerItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        AUTO_TRANSLATE.add(block);
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerPlaceOnWaterBlockItem(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeafarerItems.ITEMS.register(name, () -> new PlaceOnWaterBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerBlockNoItem(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerBlockWithoutItem(String name, Supplier<B> block) {
        return BLOCKS.register(name, block);
    }
}
