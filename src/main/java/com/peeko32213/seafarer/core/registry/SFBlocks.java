package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.block.AlgaeBlock;
import com.peeko32213.seafarer.common.block.AlgaePlantBlock;
import com.peeko32213.seafarer.common.block.SFWallBlock;
import com.peeko32213.seafarer.common.block.SFFloorLayerBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

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
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

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
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

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
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

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
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

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
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

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
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

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
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));

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

    public static final RegistryObject<Block> BLUE_SEAGLASS_PEBBLES = register("blue_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> BROWN_SEAGLASS_PEBBLES = register("brown_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> GREEN_SEAGLASS_PEBBLES = register("green_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ORANGE_SEAGLASS_PEBBLES = register("orange_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> PURPLE_SEAGLASS_PEBBLES = register("purple_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> RED_SEAGLASS_PEBBLES = register("red_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));


    public static final RegistryObject<Block> YELLOW_SEAGLASS_PEBBLES = register("yellow_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> WHITE_SEAGLASS_PEBBLES = register("white_seaglass_pebbles",
            () -> new SFFloorLayerBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> FISHING_NET = registerBlock("fishing_net",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .copy(Blocks.STONE)
                    .noCollission()
                    .strength(0.2F)
                    .sound(SoundType.LADDER)));


    public static final RegistryObject<Block> STARFISH_BLUE = register("starfish_blue",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_GREEN = register("starfish_green",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_PINK = register("starfish_pink",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_PURPLE = register("starfish_purple",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_RED = register("starfish_red",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STARFISH_YELLOW = register("starfish_yellow",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_STARFISH_BLUE = register("dead_starfish_blue",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_STARFISH_GREEN = register("dead_starfish_green",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_STARFISH_PINK = register("dead_starfish_pink",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_STARFISH_PURPLE = register("dead_starfish_purple",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_STARFISH_RED = register("dead_starfish_red",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DEAD_STARFISH_YELLOW = register("dead_starfish_yellow",
            () -> new SFWallBlock(BlockBehaviour.Properties
                    .of()
                    .instabreak()
                    .sound(SoundType.CORAL_BLOCK)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SHELL_BLOCK_CLAMS = register("shell_block_clams",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> SHELL_BLOCK_CLAMS_SLAB = registerBlock("shell_block_clams_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(SHELL_BLOCK_CLAMS.get())));

    public static final RegistryObject<StairBlock> SHELL_BLOCK_CLAMS_STAIRS = registerBlock("shell_block_clams_stairs",
            () -> new StairBlock(() -> SHELL_BLOCK_CLAMS.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(SHELL_BLOCK_CLAMS.get())));


    public static final RegistryObject<Block> SHELL_BLOCK_MOSAIC = register("shell_block_mosaic",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> SHELL_BLOCK_MOSAIC_SLAB = registerBlock("shell_block_mosaic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(SHELL_BLOCK_MOSAIC.get())));

    public static final RegistryObject<StairBlock> SHELL_BLOCK_MOSAIC_STAIRS = registerBlock("shell_block_mosaic_stairs",
            () -> new StairBlock(() -> SHELL_BLOCK_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(SHELL_BLOCK_MOSAIC.get())));

    public static final RegistryObject<RotatedPillarBlock> SHELL_BLOCK_PILLAR = register("shell_block_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> SHELL_BLOCK_SHINGLES = register("shell_block_shingles",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> SHELL_BLOCK_SHINGLES_SLAB = registerBlock("shell_block_shingles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(SHELL_BLOCK_SHINGLES.get())));

    public static final RegistryObject<StairBlock> SHELL_BLOCK_SHINGLES_STAIRS = registerBlock("shell_block_shingles_stairs",
            () -> new StairBlock(() -> SHELL_BLOCK_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(SHELL_BLOCK_SHINGLES.get())));
    public static final RegistryObject<Block> SHELL_BLOCK_SPIRAL = register("shell_block_spiral",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.BONE_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<SlabBlock> SHELL_BLOCK_SPIRAL_SLAB = registerBlock("shell_block_spiral_slab",
            () -> new SlabBlock(BlockBehaviour.Properties
                    .copy(SHELL_BLOCK_SPIRAL.get())));

    public static final RegistryObject<StairBlock> SHELL_BLOCK_SPIRAL_STAIRS = registerBlock("shell_block_spiral_stairs",
            () -> new StairBlock(() -> SHELL_BLOCK_SPIRAL.get().defaultBlockState(), BlockBehaviour.Properties
                    .copy(SHELL_BLOCK_SPIRAL.get())));

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
                    .sound(SoundType.WET_GRASS)));


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
}
