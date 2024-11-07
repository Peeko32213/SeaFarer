package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.block.*;
import com.peeko32213.seafarer.common.block.starfish.*;
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

import java.util.function.Supplier;

public class SFBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            SeaFarer.MODID);

    public static final RegistryObject<Block> BLUE_SEAGLASS_BLOCK = register("blue_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));


    public static final RegistryObject<IronBarsBlock> BLUE_SEAGLASS_PANE = register("blue_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));


    public static final RegistryObject<Block> BLUE_SEAGLASS_BRICKS = register("blue_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> BLUE_SEAGLASS_BRICKS_SLAB = registerBlock("blue_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(BLUE_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> BLUE_SEAGLASS_BRICKS_STAIRS = registerBlock("blue_seaglass_bricks_stairs",
            () -> new StairBlock(() -> BLUE_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(BLUE_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> BLUE_SEAGLASS_PEBBLED = register("blue_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BLUE_SEAGLASS_TILES = register("blue_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<SlabBlock> BLUE_SEAGLASS_TILES_SLAB = registerBlock("blue_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(BLUE_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> BLUE_SEAGLASS_TILES_STAIRS = registerBlock("blue_seaglass_tiles_stairs",
            () -> new StairBlock(() -> BLUE_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(BLUE_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> BROWN_SEAGLASS_BLOCK = register("brown_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

    public static final RegistryObject<IronBarsBlock> BROWN_SEAGLASS_PANE = register("brown_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));

    public static final RegistryObject<Block> BROWN_SEAGLASS_BRICKS = register("brown_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> BROWN_SEAGLASS_BRICKS_SLAB = registerBlock("brown_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(BROWN_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> BROWN_SEAGLASS_BRICKS_STAIRS = registerBlock("brown_seaglass_bricks_stairs",
            () -> new StairBlock(() -> BROWN_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(BROWN_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> BROWN_SEAGLASS_PEBBLED = register("brown_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BROWN_SEAGLASS_TILES = register("brown_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> BROWN_SEAGLASS_TILES_SLAB = registerBlock("brown_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(BROWN_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> BROWN_SEAGLASS_TILES_STAIRS = registerBlock("brown_seaglass_tiles_stairs",
            () -> new StairBlock(() -> BROWN_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(BROWN_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> GREEN_SEAGLASS_BLOCK = register("green_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

    public static final RegistryObject<IronBarsBlock> GREEN_SEAGLASS_PANE = register("green_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));

    public static final RegistryObject<Block> GREEN_SEAGLASS_BRICKS = register("green_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> GREEN_SEAGLASS_BRICKS_SLAB = registerBlock("green_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(GREEN_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> GREEN_SEAGLASS_BRICKS_STAIRS = registerBlock("green_seaglass_bricks_stairs",
            () -> new StairBlock(() -> GREEN_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(GREEN_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> GREEN_SEAGLASS_PEBBLED = register("green_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> GREEN_SEAGLASS_TILES = register("green_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> GREEN_SEAGLASS_TILES_SLAB = registerBlock("green_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(GREEN_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> GREEN_SEAGLASS_TILES_STAIRS = registerBlock("green_seaglass_tiles_stairs",
            () -> new StairBlock(() -> GREEN_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(GREEN_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> ORANGE_SEAGLASS_BLOCK = register("orange_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));
    public static final RegistryObject<IronBarsBlock> ORANGE_SEAGLASS_PANE = register("orange_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));

    public static final RegistryObject<Block> ORANGE_SEAGLASS_BRICKS = register("orange_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> ORANGE_SEAGLASS_BRICKS_SLAB = registerBlock("orange_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(ORANGE_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> ORANGE_SEAGLASS_BRICKS_STAIRS = registerBlock("orange_seaglass_bricks_stairs",
            () -> new StairBlock(() -> ORANGE_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(ORANGE_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> ORANGE_SEAGLASS_PEBBLED = register("orange_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> ORANGE_SEAGLASS_TILES = register("orange_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> ORANGE_SEAGLASS_TILES_SLAB = registerBlock("orange_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(ORANGE_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> ORANGE_SEAGLASS_TILES_STAIRS = registerBlock("orange_seaglass_tiles_stairs",
            () -> new StairBlock(() -> ORANGE_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(ORANGE_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> PURPLE_SEAGLASS_BLOCK = register("purple_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

    public static final RegistryObject<IronBarsBlock> PURPLE_SEAGLASS_PANE = register("purple_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));

    public static final RegistryObject<Block> PURPLE_SEAGLASS_BRICKS = register("purple_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> PURPLE_SEAGLASS_BRICKS_SLAB = registerBlock("purple_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(PURPLE_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> PURPLE_SEAGLASS_BRICKS_STAIRS = registerBlock("purple_seaglass_bricks_stairs",
            () -> new StairBlock(() -> ORANGE_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(ORANGE_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> PURPLE_SEAGLASS_PEBBLED = register("purple_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> PURPLE_SEAGLASS_TILES = register("purple_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> PURPLE_SEAGLASS_TILES_SLAB = registerBlock("purple_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(PURPLE_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> PURPLE_SEAGLASS_TILES_STAIRS = registerBlock("purple_seaglass_tiles_stairs",
            () -> new StairBlock(() -> PURPLE_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(PURPLE_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> RED_SEAGLASS_BLOCK = register("red_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

    public static final RegistryObject<IronBarsBlock> RED_SEAGLASS_PANE = register("red_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));

    public static final RegistryObject<Block> RED_SEAGLASS_BRICKS = register("red_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> RED_SEAGLASS_BRICKS_SLAB = registerBlock("red_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(RED_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> RED_SEAGLASS_BRICKS_STAIRS = registerBlock("red_seaglass_bricks_stairs",
            () -> new StairBlock(() -> RED_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(RED_SEAGLASS_BRICKS.get())));


    public static final RegistryObject<Block> RED_SEAGLASS_PEBBLED = register("red_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> RED_SEAGLASS_TILES = register("red_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> RED_SEAGLASS_TILES_SLAB = registerBlock("red_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(RED_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> RED_SEAGLASS_TILES_STAIRS = registerBlock("red_seaglass_tiles_stairs",
            () -> new StairBlock(() -> RED_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(RED_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> WHITE_SEAGLASS_BLOCK = register("white_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

    public static final RegistryObject<IronBarsBlock> WHITE_SEAGLASS_PANE = register("white_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));

    public static final RegistryObject<Block> WHITE_SEAGLASS_BRICKS = register("white_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> WHITE_SEAGLASS_BRICKS_SLAB = registerBlock("white_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(WHITE_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> WHITE_SEAGLASS_BRICKS_STAIRS = registerBlock("white_seaglass_bricks_stairs",
            () -> new StairBlock(() -> WHITE_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(WHITE_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> WHITE_SEAGLASS_PEBBLED = register("white_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> WHITE_SEAGLASS_TILES = register("white_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> WHITE_SEAGLASS_TILES_SLAB = registerBlock("white_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(WHITE_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> WHITE_SEAGLASS_TILES_STAIRS = registerBlock("white_seaglass_tiles_stairs",
            () -> new StairBlock(() -> WHITE_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(WHITE_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> YELLOW_SEAGLASS_BLOCK = register("yellow_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

    public static final RegistryObject<IronBarsBlock> YELLOW_SEAGLASS_PANE = register("yellow_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.GLASS)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));

    public static final RegistryObject<Block> YELLOW_SEAGLASS_BRICKS = register("yellow_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> YELLOW_SEAGLASS_BRICKS_SLAB = registerBlock("yellow_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(YELLOW_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> YELLOW_SEAGLASS_BRICKS_STAIRS = registerBlock("yellow_seaglass_bricks_stairs",
            () -> new StairBlock(() -> YELLOW_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(YELLOW_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> YELLOW_SEAGLASS_PEBBLED = register("yellow_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> YELLOW_SEAGLASS_TILES = register("yellow_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<SlabBlock> YELLOW_SEAGLASS_TILES_SLAB = registerBlock("yellow_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(YELLOW_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> YELLOW_SEAGLASS_TILES_STAIRS = registerBlock("yellow_seaglass_tiles_stairs",
            () -> new StairBlock(() -> YELLOW_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(YELLOW_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> PINK_SEAGLASS_BLOCK = register("pink_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));


    public static final RegistryObject<IronBarsBlock> PINK_SEAGLASS_PANE = register("pink_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));


    public static final RegistryObject<Block> PINK_SEAGLASS_BRICKS = register("pink_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> PINK_SEAGLASS_BRICKS_SLAB = registerBlock("pink_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(PINK_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> PINK_SEAGLASS_BRICKS_STAIRS = registerBlock("pink_seaglass_bricks_stairs",
            () -> new StairBlock(() -> PINK_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(PINK_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> PINK_SEAGLASS_PEBBLED = register("pink_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PINK_SEAGLASS_TILES = register("pink_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<SlabBlock> PINK_SEAGLASS_TILES_SLAB = registerBlock("pink_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(PINK_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> PINK_SEAGLASS_TILES_STAIRS = registerBlock("pink_seaglass_tiles_stairs",
            () -> new StairBlock(() -> PINK_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(PINK_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> LIME_SEAGLASS_BLOCK = register("lime_seaglass_block",
            () -> new GlassBlock(BlockBehaviour.Properties
                    .copy(Blocks.GLASS)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));


    public static final RegistryObject<IronBarsBlock> LIME_SEAGLASS_PANE = register("lime_seaglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties
                    .of()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(0.3F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));


    public static final RegistryObject<Block> LIME_SEAGLASS_BRICKS = register("lime_seaglass_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> LIME_SEAGLASS_BRICKS_SLAB = registerBlock("lime_seaglass_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(LIME_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<StairBlock> LIME_SEAGLASS_BRICKS_STAIRS = registerBlock("lime_seaglass_bricks_stairs",
            () -> new StairBlock(() -> LIME_SEAGLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(LIME_SEAGLASS_BRICKS.get())));

    public static final RegistryObject<Block> LIME_SEAGLASS_PEBBLED = register("lime_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LIME_SEAGLASS_TILES = register("lime_seaglass_tiles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<SlabBlock> LIME_SEAGLASS_TILES_SLAB = registerBlock("lime_seaglass_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(LIME_SEAGLASS_TILES.get())));

    public static final RegistryObject<StairBlock> LIME_SEAGLASS_TILES_STAIRS = registerBlock("lime_seaglass_tiles_stairs",
            () -> new StairBlock(() -> LIME_SEAGLASS_TILES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(LIME_SEAGLASS_TILES.get())));

    public static final RegistryObject<Block> BLUE_SEAGLASS_PEBBLES = register("blue_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> BROWN_SEAGLASS_PEBBLES = register("brown_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> GREEN_SEAGLASS_PEBBLES = register("green_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ORANGE_SEAGLASS_PEBBLES = register("orange_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> PURPLE_SEAGLASS_PEBBLES = register("purple_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> RED_SEAGLASS_PEBBLES = register("red_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> WHITE_SEAGLASS_PEBBLES = register("white_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> YELLOW_SEAGLASS_PEBBLES = register("yellow_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> PINK_SEAGLASS_PEBBLES = register("pink_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> LIME_SEAGLASS_PEBBLES = register("lime_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.AMETHYST)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> FISHING_NET = registerPlaceOnWaterBlockItem("fishing_net",
            () -> new SFNetBlock(BlockBehaviour.Properties
                    .copy(Blocks.STONE)
                    .noOcclusion()
                    .strength(0.2F)
                    .sound(SoundType.LADDER)));


    public static final RegistryObject<Block> STARFISH_COMMON_ORANGE = register("starfish_common_orange",
            () -> new StarfishCommonOrangeBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_PINK = register("starfish_pink",
            () -> new StarfishPinkBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_RED = register("starfish_red",
            () -> new StarfishRedBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_CHOCOLATE_CHIP = register("starfish_chocolate_chip",
            () -> new StarfishChocolateChipBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_BIG_BLUE = register("starfish_big_blue",
            () -> new StarfishBigBlueBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_BIG_PURPLE_OCHRE = register("starfish_big_purple_ochre",
            () -> new StarfishBigPurpleOchreBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_BIG_ROYAL = register("starfish_big_royal",
            () -> new StarfishBigRoyalBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_BIG_OCHRE = register("starfish_big_ochre",
            () -> new StarfishBigOchreBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ALGAE_BLOCK = register("algae_block",
            () -> new AlgaeBlock(BlockBehaviour.Properties
                    .copy(Blocks.MOSS_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> ALGAE_CARPET = register("algae_carpet",
            () -> new SFWallBlock(BlockBehaviour.Properties
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

    public static final RegistryObject<Block> CLAM_SHELL = register("clam_shell",
            () -> new SFWetFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> HORN_SHELL = register("horn_shell",
            () -> new SFWetFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SPIKY_SHELL = register("spiky_shell",
            () -> new SFWetFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SPIRAL_SHELL = register("spiral_shell",
            () -> new SFWetFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SWIRL_SHELL = register("swirl_shell",
            () -> new SFWetFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> PLANK_BLOCK = register("plank_block",
            () -> new SFPlankBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.WOOD)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> BEACHGRASS_FAN = register("beachgrass_fan",
            () -> new SFLandFanBlock(BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                    .noCollission().instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> BEACHGRASS = register("beachgrass", () ->
            new SFCropLikePlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .replaceable().noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEA_THRIFT = register("sea_thrift", () ->
            new SFCropLikePlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.COLOR_PURPLE)
                    .replaceable().noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> POTTED_SEA_THRIFT = registerBlockNoItem("potted_sea_thrift",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SFBlocks.SEA_THRIFT, BlockBehaviour
                    .Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));



    public static final RegistryObject<Block> SEA_HOLLY = register("sea_holly", () ->
            new SFSandPlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .replaceable().noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> POTTED_SEA_HOLLY = registerBlockNoItem("potted_sea_holly",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SFBlocks.SEA_HOLLY, BlockBehaviour
                    .Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> COASTAL_LAVENDER = register("coastal_lavender", () ->
            new SFSandPlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.COLOR_PURPLE)
                    .replaceable().noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> POTTED_COASTAL_LAVENDER = registerBlockNoItem("potted_coastal_lavender",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SFBlocks.COASTAL_LAVENDER, BlockBehaviour
                    .Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));


    public static final RegistryObject<Block> COASTAL_WILDFLOWER = register("coastal_wildflower", () ->
            new SFSandPlantBlock(BlockBehaviour.Properties
                    .of().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .replaceable().noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> POTTED_COASTAL_WILDFLOWER = registerBlockNoItem("potted_coastal_wildflower",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SFBlocks.COASTAL_WILDFLOWER, BlockBehaviour
                    .Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    public static final RegistryObject<Block> PYRAMID_SHELL = register("pyramid_shell",
            () -> new SFWetFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SALT_BLOCK = register("salt_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    // NEW SHELL BLOCKS

    public static final RegistryObject<Block> CLAM_SHELL_BRICKS = register("clam_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
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
                    .copy(SFBlocks.CLAM_SHELL_BRICKS.get())
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HORN_SHELL_BRICKS = register("horn_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> HORN_SHELL_BRICKS_SLAB = registerBlock("horn_shell_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(HORN_SHELL_BRICKS.get())));

    public static final RegistryObject<StairBlock> HORN_SHELL_BRICKS_STAIRS = registerBlock("horn_shell_bricks_stairs",
            () -> new StairBlock(() -> HORN_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(HORN_SHELL_BRICKS.get())));

    public static final RegistryObject<RotatedPillarBlock> HORN_SHELL_PILLAR = register("horn_shell_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(SFBlocks.HORN_SHELL_BRICKS.get())
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> SPIKY_SHELL_BRICKS = register("spiky_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
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
                    .copy(SFBlocks.SPIKY_SHELL_BRICKS.get())
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> SPIRAL_SHELL_BRICKS = register("spiral_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
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
                    .copy(SFBlocks.SPIRAL_SHELL_BRICKS.get())
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> SWIRL_SHELL_BRICKS = register("swirl_shell_bricks",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
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
                    .copy(SFBlocks.SWIRL_SHELL_BRICKS.get())
                    .strength(3.0F, 10.0F)
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
                    .strength(3.0F, 10.0F)
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
                    .copy(SFBlocks.PYRAMID_SHELL_BRICKS.get())
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SEAGLASS_BOTTLE_BUST_BLUE = register("seaglass_bottle_bust_blue",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEAGLASS_BOTTLE_BUST_BROWN = register("seaglass_bottle_bust_brown",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEAGLASS_BOTTLE_CURVY_LIME = register("seaglass_bottle_curvy_lime",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEAGLASS_BOTTLE_CURVY_ORANGE = register("seaglass_bottle_curvy_orange",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> SEAGLASS_BOTTLE_FISHBOWL_WHITE = register("seaglass_bottle_fishbowl_white",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEAGLASS_BOTTLE_FISHBOWL_PURPLE = register("seaglass_bottle_fishbowl_purple",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEAGLASS_BOTTLE_PIPE_YELLOW = register("seaglass_bottle_pipe_yellow",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEAGLASS_BOTTLE_PIPE_PINK = register("seaglass_bottle_pipe_pink",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> SEAGLASS_BOTTLE_THIN_GREEN = register("seaglass_bottle_thin_green",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SEAGLASS_BOTTLE_THIN_RED = register("seaglass_bottle_thin_red",
            () -> new SFSeaGlassBottleBlock(BlockBehaviour.Properties
                    .of()
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> FLOATSOME = register("floatsome",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

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
                    .strength(1.5F, 6.0F)));

    public static final RegistryObject<Block> AMBER_CORAL_BLOCK = register("amber_coral_block",
            () -> new CoralBlock(DEAD_AMBER_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
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
                    .strength(1.5F, 6.0F)));

    public static final RegistryObject<Block> CERULEAN_CORAL_BLOCK = register("cerulean_coral_block",
            () -> new CoralBlock(DEAD_CERULEAN_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
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
                    .strength(1.5F, 6.0F)));

    public static final RegistryObject<Block> MAROON_CORAL_BLOCK = register("maroon_coral_block",
            () -> new CoralBlock(DEAD_MAROON_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
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
                    .strength(1.5F, 6.0F)));

    public static final RegistryObject<Block> OLIVE_CORAL_BLOCK = register("olive_coral_block",
            () -> new CoralBlock(DEAD_OLIVE_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
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
                    .strength(1.5F, 6.0F)));

    public static final RegistryObject<Block> TURQUOISE_CORAL_BLOCK = register("turquoise_coral_block",
            () -> new CoralBlock(DEAD_TURQUOISE_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
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
                    .strength(1.5F, 6.0F)));

    public static final RegistryObject<Block> VERDANT_CORAL_BLOCK = register("verdant_coral_block",
            () -> new CoralBlock(DEAD_VERDANT_CORAL_BLOCK.get(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
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
            new ZoaCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ORANGE_ZOA = registerBlock("orange_zoa",() ->
            new ZoaCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> RED_ZOA = registerBlock("red_zoa",() ->
            new ZoaCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> PURPLE_ZOA = registerBlock("purple_zoa",() ->
            new ZoaCoralBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)));




    public static <T extends Block> RegistryObject<T> register(String name, Supplier<Block> block) {
        RegistryObject<? extends Block> ret = BLOCKS.register(name, block);
        SFItems.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties()));
        return (RegistryObject<T>) ret;
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SFItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerPlaceOnWaterBlockItem(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SFItems.ITEMS.register(name, () -> new PlaceOnWaterBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerBlockNoItem(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        return block;
    }
}
