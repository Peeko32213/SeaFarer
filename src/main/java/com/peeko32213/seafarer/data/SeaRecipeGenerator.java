package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.SeaItems;
import com.peeko32213.seafarer.registry.tags.SeaTags;
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


public class SeaRecipeGenerator extends SeaRecipeProvider implements IConditionBuilder {

    public SeaRecipeGenerator(PackOutput output) {
        super(output);
    }

    public static final int FAST_COOKING = 100;        // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;        // 20 seconds

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Azure Sea Glass
        makeSeaGlass(SeaBlocks.AZURE_SEA_GLASS, SeaBlocks.AZURE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.AZURE_SEA_GLASS_BRICKS, SeaBlocks.AZURE_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.AZURE_SEA_GLASS_BRICK_STAIRS, SeaBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.AZURE_SEA_GLASS_BRICK_SLAB, SeaBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.AZURE_PEBBLED_SEA_GLASS, SeaBlocks.AZURE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.AZURE_SEA_GLASS_TILES, SeaBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.AZURE_SEA_GLASS_TILE_STAIRS, SeaBlocks.AZURE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.AZURE_SEA_GLASS_TILE_SLAB, SeaBlocks.AZURE_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.AZURE_SEA_GLASS_PANE, SeaBlocks.AZURE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.AZURE_SEA_GLASS_BOTTLE, SeaBlocks.AZURE_SEA_GLASS).save(consumer);

        // Umber Sea Glass
        makeSeaGlass(SeaBlocks.UMBER_SEA_GLASS, SeaBlocks.UMBER_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.UMBER_SEA_GLASS_BRICKS, SeaBlocks.UMBER_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.UMBER_SEA_GLASS_BRICK_STAIRS, SeaBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.UMBER_SEA_GLASS_BRICK_SLAB, SeaBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.UMBER_PEBBLED_SEA_GLASS, SeaBlocks.UMBER_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.UMBER_SEA_GLASS_TILES, SeaBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.UMBER_SEA_GLASS_TILE_STAIRS, SeaBlocks.UMBER_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.UMBER_SEA_GLASS_TILE_SLAB, SeaBlocks.UMBER_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.UMBER_SEA_GLASS_PANE, SeaBlocks.UMBER_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.UMBER_SEA_GLASS_BOTTLE, SeaBlocks.UMBER_SEA_GLASS).save(consumer);

        // Seafoam Sea Glass
        makeSeaGlass(SeaBlocks.SEAFOAM_SEA_GLASS, SeaBlocks.SEAFOAM_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.SEAFOAM_SEA_GLASS_BRICKS, SeaBlocks.SEAFOAM_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS, SeaBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB, SeaBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.SEAFOAM_PEBBLED_SEA_GLASS, SeaBlocks.SEAFOAM_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.SEAFOAM_SEA_GLASS_TILES, SeaBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS, SeaBlocks.SEAFOAM_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB, SeaBlocks.SEAFOAM_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.SEAFOAM_SEA_GLASS_PANE, SeaBlocks.SEAFOAM_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.SEAFOAM_SEA_GLASS_BOTTLE, SeaBlocks.SEAFOAM_SEA_GLASS).save(consumer);

        // Amber Sea Glass
        makeSeaGlass(SeaBlocks.AMBER_SEA_GLASS, SeaBlocks.AMBER_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.AMBER_SEA_GLASS_BRICKS, SeaBlocks.AMBER_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.AMBER_SEA_GLASS_BRICK_STAIRS, SeaBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.AMBER_SEA_GLASS_BRICK_SLAB, SeaBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.AMBER_PEBBLED_SEA_GLASS, SeaBlocks.AMBER_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.AMBER_SEA_GLASS_TILES, SeaBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.AMBER_SEA_GLASS_TILE_STAIRS, SeaBlocks.AMBER_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.AMBER_SEA_GLASS_TILE_SLAB, SeaBlocks.AMBER_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.AMBER_SEA_GLASS_PANE, SeaBlocks.AMBER_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.AMBER_SEA_GLASS_BOTTLE, SeaBlocks.AMBER_SEA_GLASS).save(consumer);

        // Lilac Sea Glass
        makeSeaGlass(SeaBlocks.LILAC_SEA_GLASS, SeaBlocks.LILAC_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.LILAC_SEA_GLASS_BRICKS, SeaBlocks.LILAC_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.LILAC_SEA_GLASS_BRICK_STAIRS, SeaBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.LILAC_SEA_GLASS_BRICK_SLAB, SeaBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.LILAC_PEBBLED_SEA_GLASS, SeaBlocks.LILAC_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.LILAC_SEA_GLASS_TILES, SeaBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.LILAC_SEA_GLASS_TILE_STAIRS, SeaBlocks.LILAC_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.LILAC_SEA_GLASS_TILE_SLAB, SeaBlocks.LILAC_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.LILAC_SEA_GLASS_PANE, SeaBlocks.LILAC_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.LILAC_SEA_GLASS_BOTTLE, SeaBlocks.LILAC_SEA_GLASS).save(consumer);

        // Scarlet Sea Glass
        makeSeaGlass(SeaBlocks.SCARLET_SEA_GLASS, SeaBlocks.SCARLET_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.SCARLET_SEA_GLASS_BRICKS, SeaBlocks.SCARLET_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS, SeaBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.SCARLET_SEA_GLASS_BRICK_SLAB, SeaBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.SCARLET_PEBBLED_SEA_GLASS, SeaBlocks.SCARLET_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.SCARLET_SEA_GLASS_TILES, SeaBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.SCARLET_SEA_GLASS_TILE_STAIRS, SeaBlocks.SCARLET_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.SCARLET_SEA_GLASS_TILE_SLAB, SeaBlocks.SCARLET_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.SCARLET_SEA_GLASS_PANE, SeaBlocks.SCARLET_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.SCARLET_SEA_GLASS_BOTTLE, SeaBlocks.SCARLET_SEA_GLASS).save(consumer);

        // Pearly Sea Glass
        makeSeaGlass(SeaBlocks.PEARLY_SEA_GLASS, SeaBlocks.PEARLY_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.PEARLY_SEA_GLASS_BRICKS, SeaBlocks.PEARLY_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS, SeaBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.PEARLY_SEA_GLASS_BRICK_SLAB, SeaBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.PEARLY_PEBBLED_SEA_GLASS, SeaBlocks.PEARLY_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.PEARLY_SEA_GLASS_TILES, SeaBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.PEARLY_SEA_GLASS_TILE_STAIRS, SeaBlocks.PEARLY_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.PEARLY_SEA_GLASS_TILE_SLAB, SeaBlocks.PEARLY_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.PEARLY_SEA_GLASS_PANE, SeaBlocks.PEARLY_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.PEARLY_SEA_GLASS_BOTTLE, SeaBlocks.PEARLY_SEA_GLASS).save(consumer);

        // Citrine Sea Glass
        makeSeaGlass(SeaBlocks.CITRINE_SEA_GLASS, SeaBlocks.CITRINE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.CITRINE_SEA_GLASS_BRICKS, SeaBlocks.CITRINE_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS, SeaBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.CITRINE_SEA_GLASS_BRICK_SLAB, SeaBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.CITRINE_PEBBLED_SEA_GLASS, SeaBlocks.CITRINE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.CITRINE_SEA_GLASS_TILES, SeaBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.CITRINE_SEA_GLASS_TILE_STAIRS, SeaBlocks.CITRINE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.CITRINE_SEA_GLASS_TILE_SLAB, SeaBlocks.CITRINE_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.CITRINE_SEA_GLASS_PANE, SeaBlocks.CITRINE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.CITRINE_SEA_GLASS_BOTTLE, SeaBlocks.CITRINE_SEA_GLASS).save(consumer);


        // Rose Sea Glass
        makeSeaGlass(SeaBlocks.ROSE_SEA_GLASS, SeaBlocks.ROSE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.ROSE_SEA_GLASS_BRICKS, SeaBlocks.ROSE_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.ROSE_SEA_GLASS_BRICK_STAIRS, SeaBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.ROSE_SEA_GLASS_BRICK_SLAB, SeaBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.ROSE_PEBBLED_SEA_GLASS, SeaBlocks.ROSE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.ROSE_SEA_GLASS_TILES, SeaBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.ROSE_SEA_GLASS_TILE_STAIRS, SeaBlocks.ROSE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.ROSE_SEA_GLASS_TILE_SLAB, SeaBlocks.ROSE_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.ROSE_SEA_GLASS_PANE, SeaBlocks.ROSE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.ROSE_SEA_GLASS_BOTTLE, SeaBlocks.ROSE_SEA_GLASS).save(consumer);

        // Chartreuse Sea Glass
        makeSeaGlass(SeaBlocks.CHARTREUSE_SEA_GLASS, SeaBlocks.CHARTREUSE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICKS, SeaBlocks.CHARTREUSE_SEA_GLASS).save(consumer);
        makeStairs(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS, SeaBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB, SeaBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeaBlocks.CHARTREUSE_PEBBLED_SEA_GLASS, SeaBlocks.CHARTREUSE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeaBlocks.CHARTREUSE_SEA_GLASS_TILES, SeaBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeaBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS, SeaBlocks.CHARTREUSE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeaBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB, SeaBlocks.CHARTREUSE_SEA_GLASS_TILES).save(consumer);
        makePanes(SeaBlocks.CHARTREUSE_SEA_GLASS_PANE, SeaBlocks.CHARTREUSE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeaBlocks.CHARTREUSE_SEA_GLASS_BOTTLE, SeaBlocks.CHARTREUSE_SEA_GLASS).save(consumer);


        // Algae Block
        makeBricks(SeaBlocks.ALGAE_BLOCK, SeaBlocks.ALGAE_PLANT).save(consumer);
        makCarpet(SeaBlocks.ALGAE_CARPET, SeaBlocks.ALGAE_PLANT).save(consumer);

        makeStairs(SeaBlocks.ALGAE_COBBLESTONE_STAIRS, SeaBlocks.ALGAE_COBBLESTONE).save(consumer);
        makeSlab(SeaBlocks.ALGAE_COBBLESTONE_SLAB, SeaBlocks.ALGAE_COBBLESTONE).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SeaBlocks.ALGAE_COBBLESTONE.get()).requires(Blocks.COBBLESTONE).requires(SeaBlocks.ALGAE_PLANT.get()).group("mossy_cobblestone").unlockedBy("has_vine", has(Blocks.VINE));


        // Clam Blockset
        makeSeaGlass(SeaBlocks.CLAM_SHELL_BRICKS, SeaBlocks.CLAM_SHELL).save(consumer);
        makeBricks(SeaBlocks.CLAM_SHELL_PILLAR, SeaBlocks.CLAM_SHELL_BRICKS).save(consumer);
        makeStairs(SeaBlocks.CLAM_SHELL_BRICK_STAIRS, SeaBlocks.CLAM_SHELL_BRICKS).save(consumer);
        makeSlab(SeaBlocks.CLAM_SHELL_BRICK_SLAB, SeaBlocks.CLAM_SHELL_BRICKS).save(consumer);

        // Horn Blockset
        makeSeaGlass(SeaBlocks.HORN_SHELL_BRICKS, SeaBlocks.HORN_SHELL).save(consumer);
        makeBricks(SeaBlocks.HORN_SHELL_PILLAR, SeaBlocks.HORN_SHELL_BRICKS).save(consumer);
        makeStairs(SeaBlocks.HORN_SHELL_BRICK_STAIRS, SeaBlocks.HORN_SHELL_BRICKS).save(consumer);
        makeSlab(SeaBlocks.HORN_SHELL_BRICK_SLAB, SeaBlocks.HORN_SHELL_BRICKS).save(consumer);

        // Spiky Blockset
        makeSeaGlass(SeaBlocks.SPIKY_SHELL_BRICKS, SeaBlocks.SPIKY_SHELL).save(consumer);
        makeBricks(SeaBlocks.SPIKY_SHELL_PILLAR, SeaBlocks.SPIKY_SHELL_BRICKS).save(consumer);
        makeStairs(SeaBlocks.SPIKY_SHELL_BRICK_STAIRS, SeaBlocks.SPIKY_SHELL_BRICKS).save(consumer);
        makeSlab(SeaBlocks.SPIKY_SHELL_BRICK_SLAB, SeaBlocks.SPIKY_SHELL_BRICKS).save(consumer);

        // Spiral Blockset
        makeSeaGlass(SeaBlocks.SPIRAL_SHELL_BRICKS, SeaBlocks.SPIRAL_SHELL).save(consumer);
        makeBricks(SeaBlocks.SPIRAL_SHELL_PILLAR, SeaBlocks.SPIRAL_SHELL_BRICKS).save(consumer);
        makeStairs(SeaBlocks.SPIRAL_SHELL_BRICK_STAIRS, SeaBlocks.SPIRAL_SHELL_BRICKS).save(consumer);
        makeSlab(SeaBlocks.SPIRAL_SHELL_BRICK_SLAB, SeaBlocks.SPIRAL_SHELL_BRICKS).save(consumer);

        // Swirl Blockset
        makeSeaGlass(SeaBlocks.SWIRL_SHELL_BRICKS, SeaBlocks.SWIRL_SHELL).save(consumer);
        makeBricks(SeaBlocks.SWIRL_SHELL_PILLAR, SeaBlocks.SWIRL_SHELL_BRICKS).save(consumer);
        makeStairs(SeaBlocks.SWIRL_SHELL_BRICK_STAIRS, SeaBlocks.SWIRL_SHELL_BRICKS).save(consumer);
        makeSlab(SeaBlocks.SWIRL_SHELL_BRICK_SLAB, SeaBlocks.SWIRL_SHELL_BRICKS).save(consumer);

        // Pyramid Blockset
        makeSeaGlass(SeaBlocks.PYRAMID_SHELL_BRICKS, SeaBlocks.PYRAMID_SHELL).save(consumer);
        makeBricks(SeaBlocks.PYRAMID_SHELL_PILLAR, SeaBlocks.PYRAMID_SHELL_BRICKS).save(consumer);
        makeStairs(SeaBlocks.PYRAMID_SHELL_BRICK_STAIRS, SeaBlocks.PYRAMID_SHELL_BRICKS).save(consumer);
        makeSlab(SeaBlocks.PYRAMID_SHELL_BRICK_SLAB, SeaBlocks.PYRAMID_SHELL_BRICKS).save(consumer);

        makeIngotToBlock(SeaBlocks.SALT_BLOCK, SeaItems.SEA_SALT).save(consumer);

        makeBlockPickaxe(SeaItems.HORN_PICKAXE, SeaBlocks.HORN_SHELL).save(consumer);
        makeBlockShovel(SeaItems.CLAM_SHOVEL, SeaBlocks.CLAM_SHELL).save(consumer);
        makeBlockSword(SeaItems.SPIKY_SWORD, SeaBlocks.SPIKY_SHELL).save(consumer);
        makeBlockHoe(SeaItems.SPIRAL_HOE, SeaBlocks.SPIRAL_SHELL).save(consumer);
        makeBlockAxe(SeaItems.SWIRL_AXE, SeaBlocks.SWIRL_SHELL).save(consumer);

        smeltingRecipe(SeaItems.COOKED_SHORE_CRAB_LEG.get(), SeaItems.RAW_SHORE_CRAB_LEG.get(), 10, 1).save(consumer);

        smeltingRecipe(SeaItems.COOKED_HORSESHOE_CRAB.get(), SeaItems.RAW_HORSESHOE_CRAB.get(), 10, 1).save(consumer);

        smeltingRecipe(SeaItems.COOKED_MARINE_IGUANA_TAIL.get(), SeaItems.RAW_MARINE_IGUANA_TAIL.get(), 10, 1).save(consumer);

        makeDye(consumer, Items.YELLOW_DYE, SeaBlocks.COASTAL_WILDFLOWER.get());
        makeDye(consumer, Items.PURPLE_DYE, SeaBlocks.COASTAL_LAVENDER.get());
        makeDye(consumer, Items.BLUE_DYE, SeaBlocks.SEA_HOLLY.get());
        makeDye(consumer, Items.PINK_DYE, SeaBlocks.SEA_THRIFT.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SeaItems.SALTED_SALMON.get())
                .define('s', SeaItems.SEA_SALT.get())
                .define('l', Items.SALMON)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(Items.SALMON.asItem()), has(Items.SALMON))
                .unlockedBy(getHasName(SeaItems.SEA_SALT.get().asItem()), has(SeaItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SeaItems.SALTED_SALMON.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SeaItems.SALTED_COD.get())
                .define('s', SeaItems.SEA_SALT.get())
                .define('l', Items.COD)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(Items.COD.asItem()), has(Items.COD))
                .unlockedBy(getHasName(SeaItems.SEA_SALT.get().asItem()), has(SeaItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SeaItems.SALTED_COD.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SeaItems.SALTED_STARFISH.get())
                .define('s', SeaItems.SEA_SALT.get())
                .define('l', SeaTags.STARFISH_ITEM)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(SeaItems.SEA_SALT.get().asItem()), has(SeaItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SeaItems.SALTED_STARFISH.get()));


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SeaItems.SALTED_TROPICAL_FISH.get())
                .define('s', SeaItems.SEA_SALT.get())
                .define('l', Items.TROPICAL_FISH)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(SeaItems.SEA_SALT.get().asItem()), has(SeaItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SeaItems.SALTED_TROPICAL_FISH.get()));

        smeltingRecipes(consumer);
    }


    private void smeltingRecipes(Consumer<FinishedRecipe> consumer) {
        foodSmeltingRecipes(key(SeaBlocks.BLUE_STARFISH.get()).getPath(), SeaBlocks.BLUE_STARFISH.get().asItem(), SeaItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.OCHRE_STARFISH.get()).getPath(), SeaBlocks.OCHRE_STARFISH.get().asItem(), SeaItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.PURPLE_OCHRE_STARFISH.get()).getPath(), SeaBlocks.PURPLE_OCHRE_STARFISH.get().asItem(), SeaItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.PINK_STARFISH.get()).getPath(), SeaBlocks.PINK_STARFISH.get().asItem(), SeaItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.RED_STARFISH.get()).getPath(), SeaBlocks.RED_STARFISH.get().asItem(), SeaItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.ROYAL_STARFISH.get()).getPath(), SeaBlocks.ROYAL_STARFISH.get().asItem(), SeaItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.CHOCOLATE_CHIP_STARFISH.get()).getPath(), SeaBlocks.CHOCOLATE_CHIP_STARFISH.get().asItem(), SeaItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.COMMON_ORANGE_STARFISH.get()).getPath(), SeaBlocks.COMMON_ORANGE_STARFISH.get().asItem(), SeaItems.COOKED_STARFISH.get(),250,consumer);
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

