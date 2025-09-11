package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.blocks.*;
import com.peeko32213.seafarer.blocks.PyramidShellBlock;
import com.peeko32213.seafarer.blocks.ShellBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.flag.FeatureFlag;
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

public class SeaBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Seafarer.MOD_ID);
    public static List<RegistryObject<? extends Block>> AUTO_TRANSLATE = new ArrayList<>();

    public static final RegistryObject<Block> LIGHT_BLUE_PEBBLED_SEA_GLASS = registerBlock("light_blue_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS = registerBlock("light_blue_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_PANE = registerBlock("light_blue_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_BRICKS = registerBlock("light_blue_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS = registerBlock("light_blue_sea_glass_brick_stairs", () -> new StairBlock(() -> LIGHT_BLUE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIGHT_BLUE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_GLASS_BRICK_SLAB = registerBlock("light_blue_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(LIGHT_BLUE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_LAMP = registerBlock("light_blue_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_BOTTLE = registerBlock("light_blue_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_BLUE)));

    public static final RegistryObject<Block> ROSE_PEBBLED_SEA_GLASS = registerBlock("rose_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_SEA_GLASS = registerBlock("rose_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_PANE = registerBlock("rose_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_BRICKS = registerBlock("rose_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_BRICK_STAIRS = registerBlock("rose_sea_glass_brick_stairs", () -> new StairBlock(() -> ROSE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ROSE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_BRICK_SLAB = registerBlock("rose_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ROSE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_LAMP = registerBlock("rose_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ROSE_SEA_GLASS_BOTTLE = registerBlock("rose_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_PINK)));

    public static final RegistryObject<Block> LILAC_PEBBLED_SEA_GLASS = registerBlock("lilac_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_SEA_GLASS = registerBlock("lilac_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_PANE = registerBlock("lilac_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_BRICKS = registerBlock("lilac_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_BRICK_STAIRS = registerBlock("lilac_sea_glass_brick_stairs", () -> new StairBlock(() -> LILAC_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LILAC_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_BRICK_SLAB = registerBlock("lilac_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(LILAC_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_LAMP = registerBlock("lilac_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> LILAC_SEA_GLASS_BOTTLE = registerBlock("lilac_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_PURPLE)));

    public static final RegistryObject<Block> SEAFOAM_PEBBLED_SEA_GLASS = registerBlock("seafoam_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS = registerBlock("seafoam_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_PANE = registerBlock("seafoam_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_BRICKS = registerBlock("seafoam_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_BRICK_STAIRS = registerBlock("seafoam_sea_glass_brick_stairs", () -> new StairBlock(() -> SEAFOAM_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SEAFOAM_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_BRICK_SLAB = registerBlock("seafoam_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SEAFOAM_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_LAMP = registerBlock("seafoam_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> SEAFOAM_SEA_GLASS_BOTTLE = registerBlock("seafoam_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_GREEN)));

    public static final RegistryObject<Block> CHARTREUSE_PEBBLED_SEA_GLASS = registerBlock("chartreuse_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS = registerBlock("chartreuse_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_PANE = registerBlock("chartreuse_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_BRICKS = registerBlock("chartreuse_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_BRICK_STAIRS = registerBlock("chartreuse_sea_glass_brick_stairs", () -> new StairBlock(() -> CHARTREUSE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CHARTREUSE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_BRICK_SLAB = registerBlock("chartreuse_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CHARTREUSE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_LAMP = registerBlock("chartreuse_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> CHARTREUSE_SEA_GLASS_BOTTLE = registerBlock("chartreuse_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_LIGHT_GREEN)));

    public static final RegistryObject<Block> CITRINE_PEBBLED_SEA_GLASS = registerBlock("citrine_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS = registerBlock("citrine_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_PANE = registerBlock("citrine_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_BRICKS = registerBlock("citrine_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_BRICK_STAIRS = registerBlock("citrine_sea_glass_brick_stairs", () -> new StairBlock(() -> CITRINE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CITRINE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_BRICK_SLAB = registerBlock("citrine_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CITRINE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_LAMP = registerBlock("citrine_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> CITRINE_SEA_GLASS_BOTTLE = registerBlock("citrine_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> AMBER_PEBBLED_SEA_GLASS = registerBlock("amber_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_SEA_GLASS = registerBlock("amber_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_PANE = registerBlock("amber_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_BRICKS = registerBlock("amber_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_BRICK_STAIRS = registerBlock("amber_sea_glass_brick_stairs", () -> new StairBlock(() -> AMBER_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(AMBER_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_BRICK_SLAB = registerBlock("amber_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(AMBER_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_LAMP = registerBlock("amber_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> AMBER_SEA_GLASS_BOTTLE = registerBlock("amber_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_ORANGE)));

    public static final RegistryObject<Block> SCARLET_PEBBLED_SEA_GLASS = registerBlock("scarlet_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS = registerBlock("scarlet_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_PANE = registerBlock("scarlet_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_BRICKS = registerBlock("scarlet_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_BRICK_STAIRS = registerBlock("scarlet_sea_glass_brick_stairs", () -> new StairBlock(() -> SCARLET_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCARLET_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_BRICK_SLAB = registerBlock("scarlet_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCARLET_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_LAMP = registerBlock("scarlet_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> SCARLET_SEA_GLASS_BOTTLE = registerBlock("scarlet_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_RED)));

    public static final RegistryObject<Block> UMBER_PEBBLED_SEA_GLASS = registerBlock("umber_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_SEA_GLASS = registerBlock("umber_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_PANE = registerBlock("umber_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_BRICKS = registerBlock("umber_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_BRICK_STAIRS = registerBlock("umber_sea_glass_brick_stairs", () -> new StairBlock(() -> UMBER_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(UMBER_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_BRICK_SLAB = registerBlock("umber_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(UMBER_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_LAMP = registerBlock("umber_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> UMBER_SEA_GLASS_BOTTLE = registerBlock("umber_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_BROWN)));

    public static final RegistryObject<Block> PEARLY_PEBBLED_SEA_GLASS = registerBlock("pearly_pebbled_sea_glass", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS = registerBlock("pearly_sea_glass", () -> new GlassBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_PANE = registerBlock("pearly_sea_glass_pane", () -> new IronBarsBlock(SeaBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_BRICKS = registerBlock("pearly_sea_glass_bricks", () -> new Block(SeaBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_BRICK_STAIRS = registerBlock("pearly_sea_glass_brick_stairs", () -> new StairBlock(() -> PEARLY_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PEARLY_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_BRICK_SLAB = registerBlock("pearly_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PEARLY_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_LAMP = registerBlock("pearly_sea_glass_lamp", () -> new SeaDirectionalBlock(SeaBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> PEARLY_SEA_GLASS_BOTTLE = registerBlock("pearly_sea_glass_bottle", () -> new SeaGlassBottleBlock(SeaBlockProperties.seaGlassBottle(MapColor.COLOR_LIGHT_GRAY)));

    public static final RegistryObject<Block> OLD_BOARDS = registerBlock("old_boards", () -> new OldBoardsBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).ignitedByLava().strength(0.1F).mapColor(MapColor.WOOD)));

    public static final RegistryObject<Block> FISHING_NET = registerPlaceOnWaterBlockItem("fishing_net", () -> new FishingNet(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().strength(0.2F).sound(SoundType.LADDER)));

    public static final RegistryObject<Block> ORANGE_STARFISH = registerBlock("orange_starfish", () -> new StarfishBlock(SeaBlockProperties.starfish(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> PINK_STARFISH = registerBlock("pink_starfish", () -> new StarfishBlock(SeaBlockProperties.starfish(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> RED_STARFISH = registerBlock("red_starfish", () -> new StarfishBlock(SeaBlockProperties.starfish(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> CHOCOLATE_CHIP_STARFISH = registerBlock("chocolate_chip_starfish", () -> new StarfishBlock(SeaBlockProperties.starfish(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BLUE_STARFISH = registerBlock("blue_starfish", () -> new StarfishBlock(SeaBlockProperties.starfish(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PURPLE_OCHRE_STARFISH = registerBlock("purple_ochre_starfish", () -> new StarfishBlock(SeaBlockProperties.starfish(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> ROYAL_STARFISH = registerBlock("royal_starfish", () -> new StarfishBlock(SeaBlockProperties.starfish(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> OCHRE_STARFISH = registerBlock("ochre_starfish", () -> new StarfishBlock(SeaBlockProperties.starfish(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> ALGAE_BLOCK = registerBlock("algae_block", () -> new AlgaeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.1F).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ALGAE_CARPET = registerBlock("algae_carpet", () -> new AlageCarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.1F).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY).noCollission().noOcclusion().replaceable()));
    public static final RegistryObject<Block> ALGAE_PLANT = registerBlock("algae_plant", () -> new AlgaePlantBlock(SeaBlockProperties.WATER_PLANT));

    public static final RegistryObject<Block> TALL_BEACHGRASS = registerBlock("tall_beachgrass", () -> new TallBeachgrassBlock(SeaBlockProperties.PLANT));

    public static final RegistryObject<Block> BEACHGRASS = registerBlock("beachgrass", () -> new BeachgrassBlock(SeaBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_BEACHGRASS = registerBlockWithoutItem("potted_beachgrass", () -> new FlowerPotBlock(SeaBlocks.BEACHGRASS.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SHORT_BEACHGRASS = registerBlock("short_beachgrass", () -> new BeachgrassBlock(SeaBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_SHORT_BEACHGRASS = registerBlockWithoutItem("potted_short_beachgrass", () -> new FlowerPotBlock(SeaBlocks.BEACHGRASS.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SEA_THRIFT = registerBlock("sea_thrift", () -> new SeaFlowerBlock(() -> MobEffects.DAMAGE_BOOST, 7, SeaBlockProperties.flower(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> POTTED_SEA_THRIFT = registerBlockWithoutItem("potted_sea_thrift", () -> new FlowerPotBlock(SeaBlocks.SEA_THRIFT.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SEA_HOLLY = registerBlock("sea_holly", () -> new SeaFlowerBlock(() -> MobEffects.MOVEMENT_SPEED, 7, SeaBlockProperties.flower(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> POTTED_SEA_HOLLY = registerBlockWithoutItem("potted_sea_holly", () -> new FlowerPotBlock(SeaBlocks.SEA_HOLLY.get(), registerFlowerPot()));

    public static final RegistryObject<Block> COASTAL_LAVENDER = registerBlock("coastal_lavender", () -> new SeaFlowerBlock(() -> MobEffects.SLOW_FALLING, 9, SeaBlockProperties.flower(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> POTTED_COASTAL_LAVENDER = registerBlockWithoutItem("potted_coastal_lavender", () -> new FlowerPotBlock(SeaBlocks.COASTAL_LAVENDER.get(), registerFlowerPot()));

    public static final RegistryObject<Block> COASTAL_WILDFLOWER = registerBlock("coastal_wildflower", () -> new SeaFlowerBlock(() -> MobEffects.DIG_SPEED, 9, SeaBlockProperties.flower(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> POTTED_COASTAL_WILDFLOWER = registerBlockWithoutItem("potted_coastal_wildflower", () -> new FlowerPotBlock(SeaBlocks.COASTAL_WILDFLOWER.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SALT_BLOCK = register("salt_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.XYLOPHONE).requiresCorrectToolForDrops().strength(1.0F).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> CLAM_SHELL = registerBlock("clam_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> HORN_SHELL = registerBlock("horn_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SPIKY_SHELL = registerBlock("spiky_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SPIRAL_SHELL = registerBlock("spiral_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SWIRL_SHELL = registerBlock("swirl_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PYRAMID_SHELL = registerBlock("pyramid_shell", () -> new PyramidShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> CLAM_SHELL_BRICKS = register("clam_shell_bricks", () -> new Block(SeaBlockProperties.shellBlock(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> CLAM_SHELL_BRICK_STAIRS = registerBlock("clam_shell_brick_stairs", () -> new StairBlock(() -> CLAM_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CLAM_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> CLAM_SHELL_BRICK_SLAB = registerBlock("clam_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CLAM_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> CLAM_SHELL_PILLAR = register("clam_shell_pillar", () -> new RotatedPillarBlock(SeaBlockProperties.shellBlock(MapColor.TERRACOTTA_YELLOW)));

    public static final RegistryObject<Block> HORN_SHELL_BRICKS = register("horn_shell_bricks", () -> new Block(SeaBlockProperties.shellBlock(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> HORN_SHELL_BRICK_STAIRS = registerBlock("horn_shell_brick_stairs", () -> new StairBlock(() -> HORN_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(HORN_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> HORN_SHELL_BRICK_SLAB = registerBlock("horn_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HORN_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> HORN_SHELL_PILLAR = register("horn_shell_pillar", () -> new RotatedPillarBlock(SeaBlockProperties.shellBlock(MapColor.TERRACOTTA_YELLOW)));

    public static final RegistryObject<Block> SPIKY_SHELL_BRICKS = register("spiky_shell_bricks", () -> new Block(SeaBlockProperties.shellBlock(MapColor.TERRACOTTA_PINK)));
    public static final RegistryObject<Block> SPIKY_SHELL_BRICK_STAIRS = registerBlock("spiky_shell_brick_stairs", () -> new StairBlock(() -> SPIKY_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SPIKY_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SPIKY_SHELL_BRICK_SLAB = registerBlock("spiky_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SPIKY_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SPIKY_SHELL_PILLAR = register("spiky_shell_pillar", () -> new RotatedPillarBlock(SeaBlockProperties.shellBlock(MapColor.TERRACOTTA_PINK)));

    public static final RegistryObject<Block> SPIRAL_SHELL_BRICKS = register("spiral_shell_bricks", () -> new Block(SeaBlockProperties.shellBlock(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> SPIRAL_SHELL_BRICK_STAIRS = registerBlock("spiral_shell_brick_stairs", () -> new StairBlock(() -> SPIRAL_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SPIRAL_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SPIRAL_SHELL_BRICK_SLAB = registerBlock("spiral_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SPIRAL_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SPIRAL_SHELL_PILLAR = register("spiral_shell_pillar", () -> new RotatedPillarBlock(SeaBlockProperties.shellBlock(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> SWIRL_SHELL_BRICKS = register("swirl_shell_bricks", () -> new Block(SeaBlockProperties.shellBlock(MapColor.TERRACOTTA_MAGENTA)));
    public static final RegistryObject<Block> SWIRL_SHELL_BRICK_STAIRS = registerBlock("swirl_shell_brick_stairs", () -> new StairBlock(() -> SWIRL_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SWIRL_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SWIRL_SHELL_BRICK_SLAB = registerBlock("swirl_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SWIRL_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SWIRL_SHELL_PILLAR = register("swirl_shell_pillar", () -> new RotatedPillarBlock(SeaBlockProperties.shellBlock(MapColor.TERRACOTTA_MAGENTA)));

    public static final RegistryObject<Block> PYRAMID_SHELL_BRICKS = register("pyramid_shell_bricks", () -> new Block(SeaBlockProperties.shellBlock(MapColor.SAND)));
    public static final RegistryObject<Block> PYRAMID_SHELL_BRICK_STAIRS = registerBlock("pyramid_shell_brick_stairs", () -> new StairBlock(() -> PYRAMID_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PYRAMID_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> PYRAMID_SHELL_BRICK_SLAB = registerBlock("pyramid_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PYRAMID_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> PYRAMID_SHELL_PILLAR = register("pyramid_shell_pillar", () -> new RotatedPillarBlock(SeaBlockProperties.shellBlock(MapColor.SAND)));

    public static final RegistryObject<Block> SHELLY_SAND = registerBlock("shelly_sand", () -> new SandBlock(14406560, SeaBlockProperties.SAND));
    public static final RegistryObject<Block> STARRY_SAND = registerBlock("starry_sand", () -> new SandBlock(14406560, SeaBlockProperties.SAND));
    public static final RegistryObject<Block> SEA_GLASS_SAND = registerBlock("sea_glass_sand", () -> new SandBlock(14406560, SeaBlockProperties.SAND));

    public static final RegistryObject<Block> FLOATSOME = register("floatsome", () -> new FloorLayerBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.CHERRY_WOOD).noCollission().noOcclusion().replaceable().pushReaction(PushReaction.DESTROY)));

    // amber
    public static final RegistryObject<Block> DEAD_AMBER_CORAL_BLOCK = registerBlock("dead_amber_coral_block", () -> new Block(SeaBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_AMBER_CORAL = registerBlock("dead_amber_coral", () -> new BaseCoralPlantBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_AMBER_CORAL_WALL_FAN = registerBlockWithoutItem("dead_amber_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_AMBER_CORAL_FAN = registerBlockWithoutItem("dead_amber_coral_fan", () -> new BaseCoralFanBlock(SeaBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> AMBER_CORAL_BLOCK = registerBlock("amber_coral_block", () -> new CoralBlock(DEAD_AMBER_CORAL_BLOCK.get(), SeaBlockProperties.coralBlock(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> AMBER_CORAL = registerBlock("amber_coral", () -> new CoralPlantBlock(DEAD_AMBER_CORAL.get(), SeaBlockProperties.coral(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> AMBER_CORAL_WALL_FAN = registerBlockWithoutItem("amber_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_AMBER_CORAL_WALL_FAN.get(), SeaBlockProperties.coral(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> AMBER_CORAL_FAN = registerBlockWithoutItem("amber_coral_fan", () -> new CoralFanBlock(DEAD_AMBER_CORAL_FAN.get(), SeaBlockProperties.coral(MapColor.TERRACOTTA_ORANGE)));

    // cerulean
    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_BLOCK = registerBlock("dead_cerulean_coral_block", () -> new Block(SeaBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL = registerBlock("dead_cerulean_coral", () -> new BaseCoralPlantBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_WALL_FAN = registerBlockWithoutItem("dead_cerulean_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_FAN = registerBlockWithoutItem("dead_cerulean_coral_fan", () -> new BaseCoralFanBlock(SeaBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> CERULEAN_CORAL_BLOCK = registerBlock("cerulean_coral_block", () -> new CoralBlock(DEAD_CERULEAN_CORAL_BLOCK.get(), SeaBlockProperties.coralBlock(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CERULEAN_CORAL = registerBlock("cerulean_coral", () -> new CoralPlantBlock(DEAD_CERULEAN_CORAL.get(), SeaBlockProperties.coral(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CERULEAN_CORAL_WALL_FAN = registerBlockWithoutItem("cerulean_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_CERULEAN_CORAL_WALL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CERULEAN_CORAL_FAN = registerBlockWithoutItem("cerulean_coral_fan", () -> new CoralFanBlock(DEAD_CERULEAN_CORAL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_BLUE)));

    // maroon
    public static final RegistryObject<Block> DEAD_MAROON_CORAL_BLOCK = registerBlock("dead_maroon_coral_block", () -> new Block(SeaBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_MAROON_CORAL = registerBlock("dead_maroon_coral", () -> new BaseCoralPlantBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_MAROON_CORAL_WALL_FAN = registerBlockWithoutItem("dead_maroon_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_MAROON_CORAL_FAN = registerBlockWithoutItem("dead_maroon_coral_fan", () -> new BaseCoralFanBlock(SeaBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> MAROON_CORAL_BLOCK = registerBlock("maroon_coral_block", () -> new CoralBlock(DEAD_MAROON_CORAL_BLOCK.get(), SeaBlockProperties.coralBlock(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> MAROON_CORAL = registerBlock("maroon_coral", () -> new CoralPlantBlock(DEAD_MAROON_CORAL.get(), SeaBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> MAROON_CORAL_WALL_FAN = registerBlockWithoutItem("maroon_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_MAROON_CORAL_WALL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> MAROON_CORAL_FAN = registerBlockWithoutItem("maroon_coral_fan", () -> new CoralFanBlock(DEAD_MAROON_CORAL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_RED)));

    // olive
    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_BLOCK = registerBlock("dead_olive_coral_block", () -> new Block(SeaBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_OLIVE_CORAL = registerBlock("dead_olive_coral", () -> new BaseCoralPlantBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_WALL_FAN = registerBlockWithoutItem("dead_olive_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_FAN = registerBlockWithoutItem("dead_olive_coral_fan", () -> new BaseCoralFanBlock(SeaBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> OLIVE_CORAL_BLOCK = registerBlock("olive_coral_block", () -> new CoralBlock(DEAD_OLIVE_CORAL_BLOCK.get(), SeaBlockProperties.coralBlock(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> OLIVE_CORAL = registerBlock("olive_coral", () -> new CoralPlantBlock(DEAD_OLIVE_CORAL.get(), SeaBlockProperties.coral(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> OLIVE_CORAL_WALL_FAN = registerBlockWithoutItem("olive_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_OLIVE_CORAL_WALL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> OLIVE_CORAL_FAN = registerBlockWithoutItem("olive_coral_fan", () -> new CoralFanBlock(DEAD_OLIVE_CORAL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_LIGHT_GREEN)));

    // turquoise
    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_BLOCK = registerBlock("dead_turquoise_coral_block", () -> new Block(SeaBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL = registerBlock("dead_turquoise_coral", () -> new BaseCoralPlantBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_WALL_FAN = registerBlockWithoutItem("dead_turquoise_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_FAN = registerBlockWithoutItem("dead_turquoise_coral_fan", () -> new BaseCoralFanBlock(SeaBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> TURQUOISE_CORAL_BLOCK = registerBlock("turquoise_coral_block", () -> new CoralBlock(DEAD_TURQUOISE_CORAL_BLOCK.get(), SeaBlockProperties.coralBlock(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> TURQUOISE_CORAL = registerBlock("turquoise_coral", () -> new CoralPlantBlock(DEAD_TURQUOISE_CORAL.get(), SeaBlockProperties.coral(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> TURQUOISE_CORAL_WALL_FAN = registerBlockWithoutItem("turquoise_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_TURQUOISE_CORAL_WALL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> TURQUOISE_CORAL_FAN = registerBlockWithoutItem("turquoise_coral_fan", () -> new CoralFanBlock(DEAD_TURQUOISE_CORAL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_CYAN)));

    // verdant
    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_BLOCK = registerBlock("dead_verdant_coral_block", () -> new Block(SeaBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_VERDANT_CORAL = registerBlock("dead_verdant_coral", () -> new BaseCoralPlantBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_WALL_FAN = registerBlockWithoutItem("dead_verdant_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeaBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_FAN = registerBlockWithoutItem("dead_verdant_coral_fan", () -> new BaseCoralFanBlock(SeaBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> VERDANT_CORAL_BLOCK = registerBlock("verdant_coral_block", () -> new CoralBlock(DEAD_VERDANT_CORAL_BLOCK.get(), SeaBlockProperties.coralBlock(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> VERDANT_CORAL = registerBlock("verdant_coral", () -> new CoralPlantBlock(DEAD_VERDANT_CORAL.get(), SeaBlockProperties.coral(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> VERDANT_CORAL_WALL_FAN = registerBlockWithoutItem("verdant_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_VERDANT_CORAL_WALL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> VERDANT_CORAL_FAN = registerBlockWithoutItem("verdant_coral_fan", () -> new CoralFanBlock(DEAD_VERDANT_CORAL_FAN.get(), SeaBlockProperties.coral(MapColor.COLOR_GREEN)));

    public static final RegistryObject<Block> CYAN_ZOA = registerBlock("cyan_zoa",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> ORANGE_ZOA = registerBlock("orange_zoa",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> RED_ZOA = registerBlock("red_zoa",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> PURPLE_ZOA = registerBlock("purple_zoa",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_PURPLE)));

    public static final RegistryObject<Block> ANTLER_GORGONIAN = registerBlock("antler_gorgonian",() -> new GorgonianCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> TOWERING_GORGONIAN = registerBlock("towering_gorgonian",() -> new GorgonianCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> ATTUM_GORGONIAN = registerBlock("attum_gorgonian",() -> new GorgonianCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_YELLOW)));

    public static final RegistryObject<Block> BLUE_CHRISTMAS_TREE_WORM = registerBlock("blue_christmas_tree_worm",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BLACK_CHRISTMAS_TREE_WORM = registerBlock("black_christmas_tree_worm",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> RED_CHRISTMAS_TREE_WORM = registerBlock("red_christmas_tree_worm",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> YELLOW_CHRISTMAS_TREE_WORM = registerBlock("yellow_christmas_tree_worm",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> WHITE_CHRISTMAS_TREE_WORM = registerBlock("white_christmas_tree_worm",() -> new FloweryCoralBlock(SeaBlockProperties.coral(MapColor.TERRACOTTA_WHITE)));

    public static final RegistryObject<Block> CORALINE_SAND = registerBlock("coraline_sand", () -> new SandBlock(15790058, SeaBlockProperties.SAND));
    public static final RegistryObject<Block> SHELLY_CORALINE_SAND = registerBlock("shelly_coraline_sand", () -> new SandBlock(15790058, SeaBlockProperties.SAND));
    public static final RegistryObject<Block> STARRY_CORALINE_SAND = registerBlock("starry_coraline_sand", () -> new SandBlock(15790058, SeaBlockProperties.SAND));

    public static final RegistryObject<Block> CORALINE_SANDSTONE = registerBlock("coraline_sandstone", () -> new Block(SeaBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> CORALINE_SANDSTONE_SLAB = registerBlock("coraline_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CORALINE_SANDSTONE_STAIRS = registerBlock("coraline_sandstone_stairs", () -> new StairBlock(() -> CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_CORALINE_SANDSTONE = registerBlock("cut_coraline_sandstone", () -> new Block(SeaBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> CUT_CORALINE_SANDSTONE_SLAB = registerBlock("cut_coraline_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CUT_CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_CORALINE_SANDSTONE_STAIRS = registerBlock("cut_coraline_sandstone_stairs", () -> new StairBlock(() -> CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CUT_CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CHISELED_CORALINE_SANDSTONE = registerBlock("chiseled_coraline_sandstone", () -> new Block(SeaBlockProperties.SANDSTONE));

    public static final RegistryObject<Block> SMOOTH_CORALINE_SANDSTONE = registerBlock("smooth_coraline_sandstone", () -> new Block(SeaBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_CORALINE_SANDSTONE_STAIRS = registerBlock("smooth_coraline_sandstone_stairs", () -> new StairBlock(() -> SMOOTH_CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_CORALINE_SANDSTONE_SLAB = registerBlock("smooth_coraline_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_CORALINE_SANDSTONE.get())));

    public static final RegistryObject<Block> ASHEN_SAND = registerBlock("ashen_sand", () -> new SandBlock(3487297, SeaBlockProperties.SAND));
    public static final RegistryObject<Block> ASHEN_SANDSTONE = registerBlock("ashen_sandstone", () -> new Block(SeaBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> ASHEN_SANDSTONE_SLAB = registerBlock("ashen_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> ASHEN_SANDSTONE_STAIRS = registerBlock("ashen_sandstone_stairs", () -> new StairBlock(() -> CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_ASHEN_SANDSTONE = registerBlock("cut_ashen_sandstone", () -> new Block(SeaBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> CUT_ASHEN_SANDSTONE_SLAB = registerBlock("cut_ashen_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CUT_CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_ASHEN_SANDSTONE_STAIRS = registerBlock("cut_ashen_sandstone_stairs", () -> new StairBlock(() -> CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CUT_CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CHISELED_ASHEN_SANDSTONE = registerBlock("chiseled_ashen_sandstone", () -> new Block(SeaBlockProperties.SANDSTONE));

    public static final RegistryObject<Block> SMOOTH_ASHEN_SANDSTONE = registerBlock("smooth_ashen_sandstone", () -> new Block(SeaBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_ASHEN_SANDSTONE_STAIRS = registerBlock("smooth_ashen_sandstone_stairs", () -> new StairBlock(() -> SMOOTH_CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_ASHEN_SANDSTONE_SLAB = registerBlock("smooth_ashen_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_CORALINE_SANDSTONE.get())));

    public static final RegistryObject<Block> SEA_URCHIN = registerBlockWithoutItem("sea_urchin_block", () -> new SeaUrchinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY).strength(1.0F)));

    public static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeaItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeaItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        AUTO_TRANSLATE.add(block);
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerPlaceOnWaterBlockItem(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeaItems.ITEMS.register(name, () -> new PlaceOnWaterBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerBlockWithoutItem(String name, Supplier<B> block) {
        return BLOCKS.register(name, block);
    }

    private static BlockBehaviour.Properties registerFlowerPot(FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }
        return properties;
    }
}
