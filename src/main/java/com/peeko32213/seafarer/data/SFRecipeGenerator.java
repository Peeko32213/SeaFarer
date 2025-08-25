package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SFBlocks;
import com.peeko32213.seafarer.registry.SFItems;
import com.peeko32213.seafarer.registry.tags.SFTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;


public class SFRecipeGenerator extends SFRecipeProvider implements IConditionBuilder {

    public SFRecipeGenerator(PackOutput output) {
        super(output);
    }

    public static final int FAST_COOKING = 100;        // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;        // 20 seconds

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Azure Sea Glass
        makeSeaGlass(SFBlocks.AZURE_SEA_GLASS, SFBlocks.AZURE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.AZURE_SEA_GLASS_BRICKS, SFBlocks.AZURE_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.AZURE_SEA_GLASS_BRICK_STAIRS, SFBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.AZURE_SEA_GLASS_BRICK_SLAB, SFBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.AZURE_PEBBLED_SEA_GLASS, SFBlocks.AZURE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.AZURE_SEA_GLASS_TILES, SFBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.AZURE_SEA_GLASS_TILE_STAIRS, SFBlocks.AZURE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.AZURE_SEA_GLASS_TILE_SLAB, SFBlocks.AZURE_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.AZURE_SEA_GLASS_PANE, SFBlocks.AZURE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.AZURE_SEA_GLASS_BOTTLE, SFBlocks.AZURE_SEA_GLASS).save(consumer);

        // Umber Sea Glass
        makeSeaGlass(SFBlocks.UMBER_SEA_GLASS, SFBlocks.UMBER_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.UMBER_SEA_GLASS_BRICKS, SFBlocks.UMBER_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.UMBER_SEA_GLASS_BRICK_STAIRS, SFBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.UMBER_SEA_GLASS_BRICK_SLAB, SFBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.UMBER_PEBBLED_SEA_GLASS, SFBlocks.UMBER_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.UMBER_SEA_GLASS_TILES, SFBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.UMBER_SEA_GLASS_TILE_STAIRS, SFBlocks.UMBER_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.UMBER_SEA_GLASS_TILE_SLAB, SFBlocks.UMBER_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.UMBER_SEA_GLASS_PANE, SFBlocks.UMBER_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.UMBER_SEA_GLASS_BOTTLE, SFBlocks.UMBER_SEA_GLASS).save(consumer);

        // Seafoam Sea Glass
        makeSeaGlass(SFBlocks.SEAFOAM_SEA_GLASS, SFBlocks.SEAFOAM_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.SEAFOAM_SEA_GLASS_BRICKS, SFBlocks.SEAFOAM_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS, SFBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB, SFBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.SEAFOAM_PEBBLED_SEA_GLASS, SFBlocks.SEAFOAM_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.SEAFOAM_SEA_GLASS_TILES, SFBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS, SFBlocks.SEAFOAM_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB, SFBlocks.SEAFOAM_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.SEAFOAM_SEA_GLASS_PANE, SFBlocks.SEAFOAM_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.SEAFOAM_SEA_GLASS_BOTTLE, SFBlocks.SEAFOAM_SEA_GLASS).save(consumer);

        // Amber Sea Glass
        makeSeaGlass(SFBlocks.AMBER_SEA_GLASS, SFBlocks.AMBER_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.AMBER_SEA_GLASS_BRICKS, SFBlocks.AMBER_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.AMBER_SEA_GLASS_BRICK_STAIRS, SFBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.AMBER_SEA_GLASS_BRICK_SLAB, SFBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.AMBER_PEBBLED_SEA_GLASS, SFBlocks.AMBER_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.AMBER_SEA_GLASS_TILES, SFBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.AMBER_SEA_GLASS_TILE_STAIRS, SFBlocks.AMBER_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.AMBER_SEA_GLASS_TILE_SLAB, SFBlocks.AMBER_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.AMBER_SEA_GLASS_PANE, SFBlocks.AMBER_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.AMBER_SEA_GLASS_BOTTLE, SFBlocks.AMBER_SEA_GLASS).save(consumer);

        // Lilac Sea Glass
        makeSeaGlass(SFBlocks.LILAC_SEA_GLASS, SFBlocks.LILAC_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.LILAC_SEA_GLASS_BRICKS, SFBlocks.LILAC_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.LILAC_SEA_GLASS_BRICK_STAIRS, SFBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.LILAC_SEA_GLASS_BRICK_SLAB, SFBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.LILAC_PEBBLED_SEA_GLASS, SFBlocks.LILAC_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.LILAC_SEA_GLASS_TILES, SFBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.LILAC_SEA_GLASS_TILE_STAIRS, SFBlocks.LILAC_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.LILAC_SEA_GLASS_TILE_SLAB, SFBlocks.LILAC_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.LILAC_SEA_GLASS_PANE, SFBlocks.LILAC_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.LILAC_SEA_GLASS_BOTTLE, SFBlocks.LILAC_SEA_GLASS).save(consumer);

        // Scarlet Sea Glass
        makeSeaGlass(SFBlocks.SCARLET_SEA_GLASS, SFBlocks.SCARLET_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.SCARLET_SEA_GLASS_BRICKS, SFBlocks.SCARLET_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS, SFBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.SCARLET_SEA_GLASS_BRICK_SLAB, SFBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.SCARLET_PEBBLED_SEA_GLASS, SFBlocks.SCARLET_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.SCARLET_SEA_GLASS_TILES, SFBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.SCARLET_SEA_GLASS_TILE_STAIRS, SFBlocks.SCARLET_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.SCARLET_SEA_GLASS_TILE_SLAB, SFBlocks.SCARLET_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.SCARLET_SEA_GLASS_PANE, SFBlocks.SCARLET_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.SCARLET_SEA_GLASS_BOTTLE, SFBlocks.SCARLET_SEA_GLASS).save(consumer);

        // Pearly Sea Glass
        makeSeaGlass(SFBlocks.PEARLY_SEA_GLASS, SFBlocks.PEARLY_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.PEARLY_SEA_GLASS_BRICKS, SFBlocks.PEARLY_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS, SFBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.PEARLY_SEA_GLASS_BRICK_SLAB, SFBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.PEARLY_PEBBLED_SEA_GLASS, SFBlocks.PEARLY_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.PEARLY_SEA_GLASS_TILES, SFBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.PEARLY_SEA_GLASS_TILE_STAIRS, SFBlocks.PEARLY_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.PEARLY_SEA_GLASS_TILE_SLAB, SFBlocks.PEARLY_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.PEARLY_SEA_GLASS_PANE, SFBlocks.PEARLY_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.PEARLY_SEA_GLASS_BOTTLE, SFBlocks.PEARLY_SEA_GLASS).save(consumer);

        // Citrine Sea Glass
        makeSeaGlass(SFBlocks.CITRINE_SEA_GLASS, SFBlocks.CITRINE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.CITRINE_SEA_GLASS_BRICKS, SFBlocks.CITRINE_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS, SFBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.CITRINE_SEA_GLASS_BRICK_SLAB, SFBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.CITRINE_PEBBLED_SEA_GLASS, SFBlocks.CITRINE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.CITRINE_SEA_GLASS_TILES, SFBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.CITRINE_SEA_GLASS_TILE_STAIRS, SFBlocks.CITRINE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.CITRINE_SEA_GLASS_TILE_SLAB, SFBlocks.CITRINE_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.CITRINE_SEA_GLASS_PANE, SFBlocks.CITRINE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.CITRINE_SEA_GLASS_BOTTLE, SFBlocks.CITRINE_SEA_GLASS).save(consumer);


        // Rose Sea Glass
        makeSeaGlass(SFBlocks.ROSE_SEA_GLASS, SFBlocks.ROSE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.ROSE_SEA_GLASS_BRICKS, SFBlocks.ROSE_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.ROSE_SEA_GLASS_BRICK_STAIRS, SFBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.ROSE_SEA_GLASS_BRICK_SLAB, SFBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.ROSE_PEBBLED_SEA_GLASS, SFBlocks.ROSE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.ROSE_SEA_GLASS_TILES, SFBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.ROSE_SEA_GLASS_TILE_STAIRS, SFBlocks.ROSE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.ROSE_SEA_GLASS_TILE_SLAB, SFBlocks.ROSE_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.ROSE_SEA_GLASS_PANE, SFBlocks.ROSE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.ROSE_SEA_GLASS_BOTTLE, SFBlocks.ROSE_SEA_GLASS).save(consumer);

        // Chartreuse Sea Glass
        makeSeaGlass(SFBlocks.CHARTREUSE_SEA_GLASS, SFBlocks.CHARTREUSE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS, SFBlocks.CHARTREUSE_SEA_GLASS).save(consumer);
        makeStairs(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS, SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SFBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB, SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SFBlocks.CHARTREUSE_PEBBLED_SEA_GLASS, SFBlocks.CHARTREUSE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SFBlocks.CHARTREUSE_SEA_GLASS_TILES, SFBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS, SFBlocks.CHARTREUSE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SFBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB, SFBlocks.CHARTREUSE_SEA_GLASS_TILES).save(consumer);
        makePanes(SFBlocks.CHARTREUSE_SEA_GLASS_PANE, SFBlocks.CHARTREUSE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SFBlocks.CHARTREUSE_SEA_GLASS_BOTTLE, SFBlocks.CHARTREUSE_SEA_GLASS).save(consumer);


        // Algae Block
        makeBricks(SFBlocks.ALGAE_BLOCK, SFBlocks.ALGAE_PLANT).save(consumer);
        makCarpet(SFBlocks.ALGAE_CARPET, SFBlocks.ALGAE_PLANT).save(consumer);

        makeStairs(SFBlocks.ALGAE_COBBLESTONE_STAIRS, SFBlocks.ALGAE_COBBLESTONE).save(consumer);
        makeSlab(SFBlocks.ALGAE_COBBLESTONE_SLAB, SFBlocks.ALGAE_COBBLESTONE).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SFBlocks.ALGAE_COBBLESTONE.get()).requires(Blocks.COBBLESTONE).requires(SFBlocks.ALGAE_PLANT.get()).group("mossy_cobblestone").unlockedBy("has_vine", has(Blocks.VINE));


        // Clam Blockset
        makeSeaGlass(SFBlocks.CLAM_SHELL_BRICKS, SFBlocks.CLAM_SHELL).save(consumer);
        makeBricks(SFBlocks.CLAM_SHELL_PILLAR, SFBlocks.CLAM_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.CLAM_SHELL_BRICK_STAIRS, SFBlocks.CLAM_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.CLAM_SHELL_BRICK_SLAB, SFBlocks.CLAM_SHELL_BRICKS).save(consumer);

        // Horn Blockset
        makeSeaGlass(SFBlocks.HORN_SHELL_BRICKS, SFBlocks.HORN_SHELL).save(consumer);
        makeBricks(SFBlocks.HORN_SHELL_PILLAR, SFBlocks.HORN_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.HORN_SHELL_BRICK_STAIRS, SFBlocks.HORN_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.HORN_SHELL_BRICK_SLAB, SFBlocks.HORN_SHELL_BRICKS).save(consumer);

        // Spiky Blockset
        makeSeaGlass(SFBlocks.SPIKY_SHELL_BRICKS, SFBlocks.SPIKY_SHELL).save(consumer);
        makeBricks(SFBlocks.SPIKY_SHELL_PILLAR, SFBlocks.SPIKY_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.SPIKY_SHELL_BRICK_STAIRS, SFBlocks.SPIKY_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.SPIKY_SHELL_BRICK_SLAB, SFBlocks.SPIKY_SHELL_BRICKS).save(consumer);

        // Spiral Blockset
        makeSeaGlass(SFBlocks.SPIRAL_SHELL_BRICKS, SFBlocks.SPIRAL_SHELL).save(consumer);
        makeBricks(SFBlocks.SPIRAL_SHELL_PILLAR, SFBlocks.SPIRAL_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.SPIRAL_SHELL_BRICK_STAIRS, SFBlocks.SPIRAL_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.SPIRAL_SHELL_BRICK_SLAB, SFBlocks.SPIRAL_SHELL_BRICKS).save(consumer);

        // Swirl Blockset
        makeSeaGlass(SFBlocks.SWIRL_SHELL_BRICKS, SFBlocks.SWIRL_SHELL).save(consumer);
        makeBricks(SFBlocks.SWIRL_SHELL_PILLAR, SFBlocks.SWIRL_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.SWIRL_SHELL_BRICK_STAIRS, SFBlocks.SWIRL_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.SWIRL_SHELL_BRICK_SLAB, SFBlocks.SWIRL_SHELL_BRICKS).save(consumer);

        // Pyramid Blockset
        makeSeaGlass(SFBlocks.PYRAMID_SHELL_BRICKS, SFBlocks.PYRAMID_SHELL).save(consumer);
        makeBricks(SFBlocks.PYRAMID_SHELL_PILLAR, SFBlocks.PYRAMID_SHELL_BRICKS).save(consumer);
        makeStairs(SFBlocks.PYRAMID_SHELL_BRICK_STAIRS, SFBlocks.PYRAMID_SHELL_BRICKS).save(consumer);
        makeSlab(SFBlocks.PYRAMID_SHELL_BRICK_SLAB, SFBlocks.PYRAMID_SHELL_BRICKS).save(consumer);

        makeIngotToBlock(SFBlocks.SALT_BLOCK, SFItems.SEA_SALT).save(consumer);

        makeBlockPickaxe(SFItems.HORN_PICKAXE, SFBlocks.HORN_SHELL).save(consumer);
        makeBlockShovel(SFItems.CLAM_SHOVEL, SFBlocks.CLAM_SHELL).save(consumer);
        makeBlockSword(SFItems.SPIKY_SWORD, SFBlocks.SPIKY_SHELL).save(consumer);
        makeBlockHoe(SFItems.SPIRAL_HOE, SFBlocks.SPIRAL_SHELL).save(consumer);
        makeBlockAxe(SFItems.SWIRL_AXE, SFBlocks.SWIRL_SHELL).save(consumer);

        smeltingRecipe(SFItems.COOKED_SHORE_CRAB_LEG.get(), SFItems.RAW_SHORE_CRAB_LEG.get(), 10, 1).save(consumer);

        smeltingRecipe(SFItems.COOKED_HORSESHOE_CRAB.get(), SFItems.RAW_HORSESHOE_CRAB.get(), 10, 1).save(consumer);

        smeltingRecipe(SFItems.COOKED_MARINE_IGUANA_TAIL.get(), SFItems.RAW_MARINE_IGUANA_TAIL.get(), 10, 1).save(consumer);

        makeDye(consumer, Items.YELLOW_DYE, SFBlocks.COASTAL_WILDFLOWER.get());
        makeDye(consumer, Items.PURPLE_DYE, SFBlocks.COASTAL_LAVENDER.get());
        makeDye(consumer, Items.BLUE_DYE, SFBlocks.SEA_HOLLY.get());
        makeDye(consumer, Items.PINK_DYE, SFBlocks.SEA_THRIFT.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SFItems.SALTED_SALMON.get())
                .define('s', SFItems.SEA_SALT.get())
                .define('l', Items.SALMON)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(Items.SALMON.asItem()), has(Items.SALMON))
                .unlockedBy(getHasName(SFItems.SEA_SALT.get().asItem()), has(SFItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SFItems.SALTED_SALMON.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SFItems.SALTED_COD.get())
                .define('s', SFItems.SEA_SALT.get())
                .define('l', Items.COD)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(Items.COD.asItem()), has(Items.COD))
                .unlockedBy(getHasName(SFItems.SEA_SALT.get().asItem()), has(SFItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SFItems.SALTED_COD.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SFItems.SALTED_STARFISH.get())
                .define('s', SFItems.SEA_SALT.get())
                .define('l', SFTags.STARFISH_ITEM)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(SFItems.SEA_SALT.get().asItem()), has(SFItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SFItems.SALTED_STARFISH.get()));


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SFItems.SALTED_TROPICAL_FISH.get())
                .define('s', SFItems.SEA_SALT.get())
                .define('l', Items.TROPICAL_FISH)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(SFItems.SEA_SALT.get().asItem()), has(SFItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SFItems.SALTED_TROPICAL_FISH.get()));

        smeltingRecipes(consumer);
    }


    private void smeltingRecipes(Consumer<FinishedRecipe> consumer) {
        foodSmeltingRecipes(key(SFBlocks.BLUE_STARFISH.get()).getPath(), SFBlocks.BLUE_STARFISH.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.OCHRE_STARFISH.get()).getPath(), SFBlocks.OCHRE_STARFISH.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.PURPLE_OCHRE_STARFISH.get()).getPath(), SFBlocks.PURPLE_OCHRE_STARFISH.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.PINK_STARFISH.get()).getPath(), SFBlocks.PINK_STARFISH.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.RED_STARFISH.get()).getPath(), SFBlocks.RED_STARFISH.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.ROYAL_STARFISH.get()).getPath(), SFBlocks.ROYAL_STARFISH.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.CHOCOLATE_CHIP_STARFISH.get()).getPath(), SFBlocks.CHOCOLATE_CHIP_STARFISH.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SFBlocks.COMMON_ORANGE_STARFISH.get()).getPath(), SFBlocks.COMMON_ORANGE_STARFISH.get().asItem(), SFItems.COOKED_STARFISH.get(),250,consumer);
    }

    //Wrappers for conditionals
    private void wrap(RecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, Seafarer.MOD_ID, name, consumer, conds);
    }

    protected static String getEntityName(EntityType<?> pItemLike) {
        return BuiltInRegistries.ENTITY_TYPE.getKey(pItemLike).getPath();
    }

    private ResourceLocation name(String name) {
        return new ResourceLocation(Seafarer.MOD_ID, name);
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

