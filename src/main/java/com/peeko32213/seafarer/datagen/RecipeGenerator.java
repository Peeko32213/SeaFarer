package com.peeko32213.seafarer.datagen;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFItems;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;


public class RecipeGenerator extends SFRecipeProvider implements IConditionBuilder {
    public RecipeGenerator(PackOutput pGenerator) {
        super(pGenerator);
    }

    public static final int FAST_COOKING = 100;        // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;        // 20 seconds

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Blue Sea Glass
        makeSeaGlass(SFBlocks.BLUE_SEAGLASS_BLOCK, SFBlocks.BLUE_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.BLUE_SEAGLASS_BRICKS, SFBlocks.BLUE_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.BLUE_SEAGLASS_BRICKS_STAIRS, SFBlocks.BLUE_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.BLUE_SEAGLASS_BRICKS_SLAB, SFBlocks.BLUE_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.BLUE_SEAGLASS_PEBBLED, SFBlocks.BLUE_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.BLUE_SEAGLASS_TILES, SFBlocks.BLUE_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.BLUE_SEAGLASS_TILES_STAIRS, SFBlocks.BLUE_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.BLUE_SEAGLASS_TILES_SLAB, SFBlocks.BLUE_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.BLUE_SEAGLASS_PANE, SFBlocks.BLUE_SEAGLASS_BLOCK).save(consumer);

        // Brown Sea Glass
        makeSeaGlass(SFBlocks.BROWN_SEAGLASS_BLOCK, SFBlocks.BROWN_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.BROWN_SEAGLASS_BRICKS, SFBlocks.BROWN_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.BROWN_SEAGLASS_BRICKS_STAIRS, SFBlocks.BROWN_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.BROWN_SEAGLASS_BRICKS_SLAB, SFBlocks.BROWN_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.BROWN_SEAGLASS_PEBBLED, SFBlocks.BROWN_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.BROWN_SEAGLASS_TILES, SFBlocks.BROWN_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.BROWN_SEAGLASS_TILES_STAIRS, SFBlocks.BROWN_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.BROWN_SEAGLASS_TILES_SLAB, SFBlocks.BROWN_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.BROWN_SEAGLASS_PANE, SFBlocks.BROWN_SEAGLASS_BLOCK).save(consumer);

        // Green Sea Glass
        makeSeaGlass(SFBlocks.GREEN_SEAGLASS_BLOCK, SFBlocks.GREEN_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.GREEN_SEAGLASS_BRICKS, SFBlocks.GREEN_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.GREEN_SEAGLASS_BRICKS_STAIRS, SFBlocks.GREEN_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.GREEN_SEAGLASS_BRICKS_SLAB, SFBlocks.GREEN_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.GREEN_SEAGLASS_PEBBLED, SFBlocks.GREEN_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.GREEN_SEAGLASS_TILES, SFBlocks.GREEN_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.GREEN_SEAGLASS_TILES_STAIRS, SFBlocks.GREEN_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.GREEN_SEAGLASS_TILES_SLAB, SFBlocks.GREEN_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.GREEN_SEAGLASS_PANE, SFBlocks.GREEN_SEAGLASS_BLOCK).save(consumer);

        // Orange Sea Glass
        makeSeaGlass(SFBlocks.ORANGE_SEAGLASS_BLOCK, SFBlocks.ORANGE_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.ORANGE_SEAGLASS_BRICKS, SFBlocks.ORANGE_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.ORANGE_SEAGLASS_BRICKS_STAIRS, SFBlocks.ORANGE_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.ORANGE_SEAGLASS_BRICKS_SLAB, SFBlocks.ORANGE_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.ORANGE_SEAGLASS_PEBBLED, SFBlocks.ORANGE_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.ORANGE_SEAGLASS_TILES, SFBlocks.ORANGE_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.ORANGE_SEAGLASS_TILES_STAIRS, SFBlocks.ORANGE_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.ORANGE_SEAGLASS_TILES_SLAB, SFBlocks.ORANGE_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.ORANGE_SEAGLASS_PANE, SFBlocks.ORANGE_SEAGLASS_BLOCK).save(consumer);

        // Purple Sea Glass
        makeSeaGlass(SFBlocks.PURPLE_SEAGLASS_BLOCK, SFBlocks.PURPLE_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.PURPLE_SEAGLASS_BRICKS, SFBlocks.PURPLE_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.PURPLE_SEAGLASS_BRICKS_STAIRS, SFBlocks.PURPLE_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.PURPLE_SEAGLASS_BRICKS_SLAB, SFBlocks.PURPLE_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.PURPLE_SEAGLASS_PEBBLED, SFBlocks.PURPLE_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.PURPLE_SEAGLASS_TILES, SFBlocks.PURPLE_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.PURPLE_SEAGLASS_TILES_STAIRS, SFBlocks.PURPLE_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.PURPLE_SEAGLASS_TILES_SLAB, SFBlocks.PURPLE_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.PURPLE_SEAGLASS_PANE, SFBlocks.PURPLE_SEAGLASS_BLOCK).save(consumer);

        // Red Sea Glass
        makeSeaGlass(SFBlocks.RED_SEAGLASS_BLOCK, SFBlocks.RED_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.RED_SEAGLASS_BRICKS, SFBlocks.RED_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.RED_SEAGLASS_BRICKS_STAIRS, SFBlocks.RED_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.RED_SEAGLASS_BRICKS_SLAB, SFBlocks.RED_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.RED_SEAGLASS_PEBBLED, SFBlocks.RED_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.RED_SEAGLASS_TILES, SFBlocks.RED_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.RED_SEAGLASS_TILES_STAIRS, SFBlocks.RED_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.RED_SEAGLASS_TILES_SLAB, SFBlocks.RED_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.RED_SEAGLASS_PANE, SFBlocks.RED_SEAGLASS_BLOCK).save(consumer);

        // White Sea Glass
        makeSeaGlass(SFBlocks.WHITE_SEAGLASS_BLOCK, SFBlocks.WHITE_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.WHITE_SEAGLASS_BRICKS, SFBlocks.WHITE_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.WHITE_SEAGLASS_BRICKS_STAIRS, SFBlocks.WHITE_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.WHITE_SEAGLASS_BRICKS_SLAB, SFBlocks.WHITE_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.WHITE_SEAGLASS_PEBBLED, SFBlocks.WHITE_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.WHITE_SEAGLASS_TILES, SFBlocks.WHITE_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.WHITE_SEAGLASS_TILES_STAIRS, SFBlocks.WHITE_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.WHITE_SEAGLASS_TILES_SLAB, SFBlocks.WHITE_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.WHITE_SEAGLASS_PANE, SFBlocks.WHITE_SEAGLASS_BLOCK).save(consumer);

        // Yellow Sea Glass
        makeSeaGlass(SFBlocks.YELLOW_SEAGLASS_BLOCK, SFBlocks.YELLOW_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.YELLOW_SEAGLASS_BRICKS, SFBlocks.YELLOW_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.YELLOW_SEAGLASS_BRICKS_STAIRS, SFBlocks.YELLOW_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.YELLOW_SEAGLASS_BRICKS_SLAB, SFBlocks.YELLOW_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.YELLOW_SEAGLASS_PEBBLED, SFBlocks.YELLOW_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.YELLOW_SEAGLASS_TILES, SFBlocks.YELLOW_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.YELLOW_SEAGLASS_TILES_STAIRS, SFBlocks.YELLOW_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.YELLOW_SEAGLASS_TILES_SLAB, SFBlocks.YELLOW_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.YELLOW_SEAGLASS_PANE, SFBlocks.YELLOW_SEAGLASS_BLOCK).save(consumer);


        // Pink Sea Glass
        makeSeaGlass(SFBlocks.PINK_SEAGLASS_BLOCK, SFBlocks.PINK_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.PINK_SEAGLASS_BRICKS, SFBlocks.PINK_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.PINK_SEAGLASS_BRICKS_STAIRS, SFBlocks.PINK_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.PINK_SEAGLASS_BRICKS_SLAB, SFBlocks.PINK_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.PINK_SEAGLASS_PEBBLED, SFBlocks.PINK_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.PINK_SEAGLASS_TILES, SFBlocks.PINK_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.PINK_SEAGLASS_TILES_STAIRS, SFBlocks.PINK_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.PINK_SEAGLASS_TILES_SLAB, SFBlocks.PINK_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.PINK_SEAGLASS_PANE, SFBlocks.PINK_SEAGLASS_BLOCK).save(consumer);

        // Lime Sea Glass
        makeSeaGlass(SFBlocks.LIME_SEAGLASS_BLOCK, SFBlocks.LIME_SEAGLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.LIME_SEAGLASS_BRICKS, SFBlocks.LIME_SEAGLASS_BLOCK).save(consumer);
        makeStairs(SFBlocks.LIME_SEAGLASS_BRICKS_STAIRS, SFBlocks.LIME_SEAGLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.LIME_SEAGLASS_BRICKS_SLAB, SFBlocks.LIME_SEAGLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.LIME_SEAGLASS_PEBBLED, SFBlocks.LIME_SEAGLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.LIME_SEAGLASS_TILES, SFBlocks.LIME_SEAGLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.LIME_SEAGLASS_TILES_STAIRS, SFBlocks.LIME_SEAGLASS_TILES).save(consumer);
        makeSlab(SFBlocks.LIME_SEAGLASS_TILES_SLAB, SFBlocks.LIME_SEAGLASS_TILES).save(consumer);
        makePanes(SFBlocks.LIME_SEAGLASS_PANE, SFBlocks.LIME_SEAGLASS_BLOCK).save(consumer);


        // Algae Block
        makeBricks(SFBlocks.ALGAE_BLOCK, SFBlocks.ALGAE_PLANT).save(consumer);
        makCarpet(SFBlocks.ALGAE_CARPET, SFBlocks.ALGAE_PLANT).save(consumer);

        makeStairs(SFBlocks.ALGAE_COBBLESTONE_STAIRS, SFBlocks.ALGAE_COBBLESTONE).save(consumer);
        makeSlab(SFBlocks.ALGAE_COBBLESTONE_SLAB, SFBlocks.ALGAE_COBBLESTONE).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SFBlocks.ALGAE_COBBLESTONE.get()).requires(Blocks.COBBLESTONE).requires(SFBlocks.ALGAE_PLANT.get()).group("mossy_cobblestone").unlockedBy("has_vine", has(Blocks.VINE));


        // Clam Blockset
        makeSeaGlass(SFBlocks.CLAM_SHELL_BRICKS, SFBlocks.CLAM_SHELL).save(consumer);
        makeBricks(SFBlocks.CLAM_SHELL_PILLAR, SFBlocks.CLAM_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.CLAM_SHELL_BRICKS_STAIRS, SFBlocks.CLAM_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.CLAM_SHELL_BRICKS_SLAB, SFBlocks.CLAM_SHELL_BRICKS).save(consumer);

        // Horn Blockset
        makeSeaGlass(SFBlocks.HORN_SHELL_BRICKS, SFBlocks.HORN_SHELL).save(consumer);
        makeBricks(SFBlocks.HORN_SHELL_PILLAR, SFBlocks.HORN_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.HORN_SHELL_BRICKS_STAIRS, SFBlocks.HORN_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.HORN_SHELL_BRICKS_SLAB, SFBlocks.HORN_SHELL_BRICKS).save(consumer);

        // Spiky Blockset
        makeSeaGlass(SFBlocks.SPIKY_SHELL_BRICKS, SFBlocks.SPIKY_SHELL).save(consumer);
        makeBricks(SFBlocks.SPIKY_SHELL_PILLAR, SFBlocks.SPIKY_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.SPIKY_SHELL_BRICKS_STAIRS, SFBlocks.SPIKY_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.SPIKY_SHELL_BRICKS_SLAB, SFBlocks.SPIKY_SHELL_BRICKS).save(consumer);

        // Spiral Blockset
        makeSeaGlass(SFBlocks.SPIRAL_SHELL_BRICKS, SFBlocks.SPIRAL_SHELL).save(consumer);
        makeBricks(SFBlocks.SPIRAL_SHELL_PILLAR, SFBlocks.SPIRAL_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.SPIRAL_SHELL_BRICKS_STAIRS, SFBlocks.SPIRAL_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB, SFBlocks.SPIRAL_SHELL_BRICKS).save(consumer);

        // Swirl Blockset
        makeSeaGlass(SFBlocks.SWIRL_SHELL_BRICKS, SFBlocks.SWIRL_SHELL).save(consumer);
        makeBricks(SFBlocks.SWIRL_SHELL_PILLAR, SFBlocks.SWIRL_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.SWIRL_SHELL_BRICKS_STAIRS, SFBlocks.SWIRL_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.SWIRL_SHELL_BRICKS_SLAB, SFBlocks.SWIRL_SHELL_BRICKS).save(consumer);

        // Pyramid Blockset
        makeSeaGlass(SFBlocks.PYRAMID_SHELL_BRICKS, SFBlocks.PYRAMID_SHELL).save(consumer);
        makeBricks(SFBlocks.PYRAMID_SHELL_PILLAR, SFBlocks.PYRAMID_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.PYRAMID_SHELL_BRICKS_STAIRS, SFBlocks.PYRAMID_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB, SFBlocks.PYRAMID_SHELL_BRICKS).save(consumer);

        makeIngotToBlock(SFBlocks.SALT_BLOCK, SFItems.SALT).save(consumer);

        makeBlockPickaxe(SFItems.HORN_PICKAXE, SFBlocks.HORN_SHELL).save(consumer);
        makeBlockShovel(SFItems.CLAM_SHOVEL, SFBlocks.CLAM_SHELL).save(consumer);
        makeBlockSword(SFItems.SPIKY_SWORD, SFBlocks.SPIKY_SHELL).save(consumer);
        makeBlockHoe(SFItems.SPIRAL_HOE, SFBlocks.SPIRAL_SHELL).save(consumer);
        makeBlockAxe(SFItems.SWIRL_AXE, SFBlocks.SWIRL_SHELL).save(consumer);

        smeltingRecipe(SFItems.COOKED_SHORE_CRAB.get(), SFItems.RAW_SHORE_CRAB.get(), 10, 1).save(consumer);

        smeltingRecipe(SFItems.COOKED_HORSESHOE_CRAB.get(), SFItems.RAW_HORSESHOE_CRAB.get(), 10, 1).save(consumer);

        smeltingRecipe(SFItems.COOKED_MARINE_IGUANA.get(), SFItems.RAW_MARINE_IGUANA.get(), 10, 1).save(consumer);

        makeDye(consumer, Items.YELLOW_DYE, SFBlocks.COASTAL_WILDFLOWER.get());
        makeDye(consumer, Items.PURPLE_DYE, SFBlocks.COASTAL_LAVENDER.get());
        makeDye(consumer, Items.BLUE_DYE, SFBlocks.SEA_HOLLY.get());
        makeDye(consumer, Items.PINK_DYE, SFBlocks.SEA_THRIFT.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SFItems.SALTED_SALMON.get())
                .define('s', SFItems.SALT.get())
                .define('l', Items.SALMON)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(Items.SALMON.asItem()), has(Items.SALMON))
                .unlockedBy(getHasName(SFItems.SALT.get().asItem()), has(SFItems.SALT.get().asItem()))
                .save(consumer, key(SFItems.SALTED_SALMON.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SFItems.SALTED_COD.get())
                .define('s', SFItems.SALT.get())
                .define('l', Items.COD)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(Items.COD.asItem()), has(Items.COD))
                .unlockedBy(getHasName(SFItems.SALT.get().asItem()), has(SFItems.SALT.get().asItem()))
                .save(consumer, key(SFItems.SALTED_COD.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SFItems.SALTED_STARFISH.get())
                .define('s', SFItems.SALT.get())
                .define('l', SFTags.STARFISH_ITEM)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(SFItems.SALT.get().asItem()), has(SFItems.SALT.get().asItem()))
                .save(consumer, key(SFItems.SALTED_STARFISH.get()));


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SFItems.SALTED_TROPICAL_FISH.get())
                .define('s', SFItems.SALT.get())
                .define('l', SFItems.SALTED_TROPICAL_FISH.get())
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(SFItems.SALT.get().asItem()), has(SFItems.SALT.get().asItem()))
                .unlockedBy(getHasName(SFItems.SALTED_TROPICAL_FISH.get().asItem()), has(SFItems.SALTED_TROPICAL_FISH.get().asItem()))
                .save(consumer, key(SFItems.SALTED_TROPICAL_FISH.get()));

        smeltingRecipes(consumer);

        //Sea Glass Bottles
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_BUST_BLUE, SFBlocks.BLUE_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_BUST_BROWN, SFBlocks.BROWN_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_CURVY_LIME, SFBlocks.LIME_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_CURVY_ORANGE, SFBlocks.ORANGE_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_FISHBOWL_PURPLE, SFBlocks.PURPLE_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_FISHBOWL_WHITE, SFBlocks.WHITE_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_PIPE_PINK, SFBlocks.PINK_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_THIN_RED, SFBlocks.RED_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_THIN_GREEN, SFBlocks.GREEN_SEAGLASS_BLOCK).save(consumer);
        makeGlasstoBottle(SFBlocks.SEAGLASS_BOTTLE_PIPE_YELLOW, SFBlocks.YELLOW_SEAGLASS_BLOCK).save(consumer);

    }


    private void smeltingRecipes(Consumer<FinishedRecipe> consumer) {
        foodSmeltingRecipes(key(SFBlocks.STARFISH_BIG_BLUE.get()).getPath(),SFBlocks.STARFISH_BIG_BLUE.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.STARFISH_BIG_OCHRE.get()).getPath(),SFBlocks.STARFISH_BIG_OCHRE.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.STARFISH_BIG_PURPLE_OCHRE.get()).getPath(),SFBlocks.STARFISH_BIG_PURPLE_OCHRE.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.STARFISH_PINK.get()).getPath(),SFBlocks.STARFISH_PINK.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.STARFISH_RED.get()).getPath(),SFBlocks.STARFISH_RED.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.STARFISH_BIG_ROYAL.get()).getPath(),SFBlocks.STARFISH_BIG_ROYAL.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.STARFISH_CHOCOLATE_CHIP.get()).getPath(),SFBlocks.STARFISH_CHOCOLATE_CHIP.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.STARFISH_COMMON_ORANGE.get()).getPath(),SFBlocks.STARFISH_COMMON_ORANGE.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
    }

    //Wrappers for conditionals
    private void wrap(RecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, SeaFarer.MODID, name, consumer, conds);
    }

    protected static String getEntityName(EntityType<?> pItemLike) {
        return BuiltInRegistries.ENTITY_TYPE.getKey(pItemLike).getPath();
    }

    private ResourceLocation name(String name) {
        return new ResourceLocation(SeaFarer.MODID, name);
    }

    private void wrap(RecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = new ResourceLocation(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.save(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
                .generateAdvancement()
                .build(consumer, loc);
    }


}

