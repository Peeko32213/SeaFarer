package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
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

    public static final RegistryObject<Block> BLUE_SEAGLASS_PEBBLED = register("blue_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

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

    public static final RegistryObject<Block> BROWN_SEAGLASS_PEBBLED = register("brown_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

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

    public static final RegistryObject<Block> GREEN_SEAGLASS_PEBBLED = register("green_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

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

    public static final RegistryObject<Block> ORANGE_SEAGLASS_PEBBLED = register("orange_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

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

    public static final RegistryObject<Block> PURPLE_SEAGLASS_PEBBLED = register("purple_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

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

    public static final RegistryObject<Block> RED_SEAGLASS_PEBBLED = register("red_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));

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

    public static final RegistryObject<Block> YELLOW_SEAGLASS_PEBBLED = register("yellow_seaglass_pebbled",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.AMETHYST_BLOCK)
                    .strength(3.0F, 10.0F)
                    .requiresCorrectToolForDrops()));


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
