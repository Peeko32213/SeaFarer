package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import com.peeko32213.seafarer.registry.SeafarerItems;
import com.peeko32213.seafarer.registry.tags.SeafarerTags;
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


public class SeafarerRecipeGenerator extends SeafarerRecipeProvider implements IConditionBuilder {

    public SeafarerRecipeGenerator(PackOutput output) {
        super(output);
    }

    public static final int FAST_COOKING = 100;        // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;        // 20 seconds

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Azure Sea Glass
        makeSeaGlass(SeafarerBlocks.AZURE_SEA_GLASS, SeafarerBlocks.AZURE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.AZURE_SEA_GLASS_BRICKS, SeafarerBlocks.AZURE_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.AZURE_PEBBLED_SEA_GLASS, SeafarerBlocks.AZURE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.AZURE_SEA_GLASS_TILES, SeafarerBlocks.AZURE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.AZURE_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.AZURE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.AZURE_SEA_GLASS_TILE_SLAB, SeafarerBlocks.AZURE_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.AZURE_SEA_GLASS_PANE, SeafarerBlocks.AZURE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.AZURE_SEA_GLASS_BOTTLE, SeafarerBlocks.AZURE_SEA_GLASS).save(consumer);

        // Umber Sea Glass
        makeSeaGlass(SeafarerBlocks.UMBER_SEA_GLASS, SeafarerBlocks.UMBER_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.UMBER_SEA_GLASS_BRICKS, SeafarerBlocks.UMBER_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.UMBER_PEBBLED_SEA_GLASS, SeafarerBlocks.UMBER_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.UMBER_SEA_GLASS_TILES, SeafarerBlocks.UMBER_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.UMBER_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.UMBER_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.UMBER_SEA_GLASS_TILE_SLAB, SeafarerBlocks.UMBER_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.UMBER_SEA_GLASS_PANE, SeafarerBlocks.UMBER_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.UMBER_SEA_GLASS_BOTTLE, SeafarerBlocks.UMBER_SEA_GLASS).save(consumer);

        // Seafoam Sea Glass
        makeSeaGlass(SeafarerBlocks.SEAFOAM_SEA_GLASS, SeafarerBlocks.SEAFOAM_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS, SeafarerBlocks.SEAFOAM_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.SEAFOAM_PEBBLED_SEA_GLASS, SeafarerBlocks.SEAFOAM_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES, SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB, SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.SEAFOAM_SEA_GLASS_PANE, SeafarerBlocks.SEAFOAM_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.SEAFOAM_SEA_GLASS_BOTTLE, SeafarerBlocks.SEAFOAM_SEA_GLASS).save(consumer);

        // Amber Sea Glass
        makeSeaGlass(SeafarerBlocks.AMBER_SEA_GLASS, SeafarerBlocks.AMBER_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.AMBER_SEA_GLASS_BRICKS, SeafarerBlocks.AMBER_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.AMBER_PEBBLED_SEA_GLASS, SeafarerBlocks.AMBER_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.AMBER_SEA_GLASS_TILES, SeafarerBlocks.AMBER_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.AMBER_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.AMBER_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.AMBER_SEA_GLASS_TILE_SLAB, SeafarerBlocks.AMBER_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.AMBER_SEA_GLASS_PANE, SeafarerBlocks.AMBER_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.AMBER_SEA_GLASS_BOTTLE, SeafarerBlocks.AMBER_SEA_GLASS).save(consumer);

        // Lilac Sea Glass
        makeSeaGlass(SeafarerBlocks.LILAC_SEA_GLASS, SeafarerBlocks.LILAC_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.LILAC_SEA_GLASS_BRICKS, SeafarerBlocks.LILAC_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.LILAC_PEBBLED_SEA_GLASS, SeafarerBlocks.LILAC_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.LILAC_SEA_GLASS_TILES, SeafarerBlocks.LILAC_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.LILAC_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.LILAC_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.LILAC_SEA_GLASS_TILE_SLAB, SeafarerBlocks.LILAC_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.LILAC_SEA_GLASS_PANE, SeafarerBlocks.LILAC_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.LILAC_SEA_GLASS_BOTTLE, SeafarerBlocks.LILAC_SEA_GLASS).save(consumer);

        // Scarlet Sea Glass
        makeSeaGlass(SeafarerBlocks.SCARLET_SEA_GLASS, SeafarerBlocks.SCARLET_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS, SeafarerBlocks.SCARLET_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.SCARLET_PEBBLED_SEA_GLASS, SeafarerBlocks.SCARLET_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.SCARLET_SEA_GLASS_TILES, SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.SCARLET_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_SLAB, SeafarerBlocks.SCARLET_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.SCARLET_SEA_GLASS_PANE, SeafarerBlocks.SCARLET_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.SCARLET_SEA_GLASS_BOTTLE, SeafarerBlocks.SCARLET_SEA_GLASS).save(consumer);

        // Pearly Sea Glass
        makeSeaGlass(SeafarerBlocks.PEARLY_SEA_GLASS, SeafarerBlocks.PEARLY_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS, SeafarerBlocks.PEARLY_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.PEARLY_PEBBLED_SEA_GLASS, SeafarerBlocks.PEARLY_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.PEARLY_SEA_GLASS_TILES, SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.PEARLY_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_SLAB, SeafarerBlocks.PEARLY_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.PEARLY_SEA_GLASS_PANE, SeafarerBlocks.PEARLY_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.PEARLY_SEA_GLASS_BOTTLE, SeafarerBlocks.PEARLY_SEA_GLASS).save(consumer);

        // Citrine Sea Glass
        makeSeaGlass(SeafarerBlocks.CITRINE_SEA_GLASS, SeafarerBlocks.CITRINE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS, SeafarerBlocks.CITRINE_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.CITRINE_PEBBLED_SEA_GLASS, SeafarerBlocks.CITRINE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.CITRINE_SEA_GLASS_TILES, SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.CITRINE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_SLAB, SeafarerBlocks.CITRINE_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.CITRINE_SEA_GLASS_PANE, SeafarerBlocks.CITRINE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.CITRINE_SEA_GLASS_BOTTLE, SeafarerBlocks.CITRINE_SEA_GLASS).save(consumer);


        // Rose Sea Glass
        makeSeaGlass(SeafarerBlocks.ROSE_SEA_GLASS, SeafarerBlocks.ROSE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.ROSE_SEA_GLASS_BRICKS, SeafarerBlocks.ROSE_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.ROSE_PEBBLED_SEA_GLASS, SeafarerBlocks.ROSE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.ROSE_SEA_GLASS_TILES, SeafarerBlocks.ROSE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.ROSE_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.ROSE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.ROSE_SEA_GLASS_TILE_SLAB, SeafarerBlocks.ROSE_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.ROSE_SEA_GLASS_PANE, SeafarerBlocks.ROSE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.ROSE_SEA_GLASS_BOTTLE, SeafarerBlocks.ROSE_SEA_GLASS).save(consumer);

        // Chartreuse Sea Glass
        makeSeaGlass(SeafarerBlocks.CHARTREUSE_SEA_GLASS, SeafarerBlocks.CHARTREUSE_SEA_GLASS_PEBBLES).save(consumer);
        makeBricks(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS, SeafarerBlocks.CHARTREUSE_SEA_GLASS).save(consumer);
        makeStairs(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS, SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB, SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);

        makeCondensedToBlock(SeafarerBlocks.CHARTREUSE_PEBBLED_SEA_GLASS, SeafarerBlocks.CHARTREUSE_SEA_GLASS_PEBBLES).save(consumer);

        makeBricks(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES, SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS, SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES).save(consumer);
        makeSlab(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB, SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES).save(consumer);
        makePanes(SeafarerBlocks.CHARTREUSE_SEA_GLASS_PANE, SeafarerBlocks.CHARTREUSE_SEA_GLASS).save(consumer);

        makeGlasstoBottle(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BOTTLE, SeafarerBlocks.CHARTREUSE_SEA_GLASS).save(consumer);


        // Algae Block
        makeBricks(SeafarerBlocks.ALGAE_BLOCK, SeafarerBlocks.ALGAE_PLANT).save(consumer);
        makCarpet(SeafarerBlocks.ALGAE_CARPET, SeafarerBlocks.ALGAE_PLANT).save(consumer);

        makeStairs(SeafarerBlocks.ALGAE_COBBLESTONE_STAIRS, SeafarerBlocks.ALGAE_COBBLESTONE).save(consumer);
        makeSlab(SeafarerBlocks.ALGAE_COBBLESTONE_SLAB, SeafarerBlocks.ALGAE_COBBLESTONE).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SeafarerBlocks.ALGAE_COBBLESTONE.get()).requires(Blocks.COBBLESTONE).requires(SeafarerBlocks.ALGAE_PLANT.get()).group("mossy_cobblestone").unlockedBy("has_vine", has(Blocks.VINE));


        // Clam Blockset
        makeSeaGlass(SeafarerBlocks.CLAM_SHELL_BRICKS, SeafarerBlocks.CLAM_SHELL).save(consumer);
        makeBricks(SeafarerBlocks.CLAM_SHELL_PILLAR, SeafarerBlocks.CLAM_SHELL_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.CLAM_SHELL_BRICKS_STAIRS, SeafarerBlocks.CLAM_SHELL_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.CLAM_SHELL_BRICKS_SLAB, SeafarerBlocks.CLAM_SHELL_BRICKS).save(consumer);

        // Horn Blockset
        makeSeaGlass(SeafarerBlocks.HORN_SHELL_BRICKS, SeafarerBlocks.HORN_SHELL).save(consumer);
        makeBricks(SeafarerBlocks.HORN_SHELL_PILLAR, SeafarerBlocks.HORN_SHELL_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.HORN_SHELL_BRICKS_STAIRS, SeafarerBlocks.HORN_SHELL_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.HORN_SHELL_BRICKS_SLAB, SeafarerBlocks.HORN_SHELL_BRICKS).save(consumer);

        // Spiky Blockset
        makeSeaGlass(SeafarerBlocks.SPIKY_SHELL_BRICKS, SeafarerBlocks.SPIKY_SHELL).save(consumer);
        makeBricks(SeafarerBlocks.SPIKY_SHELL_PILLAR, SeafarerBlocks.SPIKY_SHELL_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.SPIKY_SHELL_BRICKS_STAIRS, SeafarerBlocks.SPIKY_SHELL_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.SPIKY_SHELL_BRICKS_SLAB, SeafarerBlocks.SPIKY_SHELL_BRICKS).save(consumer);

        // Spiral Blockset
        makeSeaGlass(SeafarerBlocks.SPIRAL_SHELL_BRICKS, SeafarerBlocks.SPIRAL_SHELL).save(consumer);
        makeBricks(SeafarerBlocks.SPIRAL_SHELL_PILLAR, SeafarerBlocks.SPIRAL_SHELL_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.SPIRAL_SHELL_BRICKS_STAIRS, SeafarerBlocks.SPIRAL_SHELL_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.SPIRAL_SHELL_BRICKS_SLAB, SeafarerBlocks.SPIRAL_SHELL_BRICKS).save(consumer);

        // Swirl Blockset
        makeSeaGlass(SeafarerBlocks.SWIRL_SHELL_BRICKS, SeafarerBlocks.SWIRL_SHELL).save(consumer);
        makeBricks(SeafarerBlocks.SWIRL_SHELL_PILLAR, SeafarerBlocks.SWIRL_SHELL_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.SWIRL_SHELL_BRICKS_STAIRS, SeafarerBlocks.SWIRL_SHELL_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.SWIRL_SHELL_BRICKS_SLAB, SeafarerBlocks.SWIRL_SHELL_BRICKS).save(consumer);

        // Pyramid Blockset
        makeSeaGlass(SeafarerBlocks.PYRAMID_SHELL_BRICKS, SeafarerBlocks.PYRAMID_SHELL).save(consumer);
        makeBricks(SeafarerBlocks.PYRAMID_SHELL_PILLAR, SeafarerBlocks.PYRAMID_SHELL_BRICKS).save(consumer);
        makeStairs(SeafarerBlocks.PYRAMID_SHELL_BRICKS_STAIRS, SeafarerBlocks.PYRAMID_SHELL_BRICKS).save(consumer);
        makeSlab(SeafarerBlocks.PYRAMID_SHELL_BRICKS_SLAB, SeafarerBlocks.PYRAMID_SHELL_BRICKS).save(consumer);

        makeIngotToBlock(SeafarerBlocks.SALT_BLOCK, SeafarerItems.SEA_SALT).save(consumer);

        makeBlockPickaxe(SeafarerItems.HORN_PICKAXE, SeafarerBlocks.HORN_SHELL).save(consumer);
        makeBlockShovel(SeafarerItems.CLAM_SHOVEL, SeafarerBlocks.CLAM_SHELL).save(consumer);
        makeBlockSword(SeafarerItems.SPIKY_SWORD, SeafarerBlocks.SPIKY_SHELL).save(consumer);
        makeBlockHoe(SeafarerItems.SPIRAL_HOE, SeafarerBlocks.SPIRAL_SHELL).save(consumer);
        makeBlockAxe(SeafarerItems.SWIRL_AXE, SeafarerBlocks.SWIRL_SHELL).save(consumer);

        smeltingRecipe(SeafarerItems.COOKED_SHORE_CRAB_LEG.get(), SeafarerItems.RAW_SHORE_CRAB_LEG.get(), 10, 1).save(consumer);

        smeltingRecipe(SeafarerItems.COOKED_HORSESHOE_CRAB.get(), SeafarerItems.RAW_HORSESHOE_CRAB.get(), 10, 1).save(consumer);

        smeltingRecipe(SeafarerItems.COOKED_MARINE_IGUANA_TAIL.get(), SeafarerItems.RAW_MARINE_IGUANA_TAIL.get(), 10, 1).save(consumer);

        makeDye(consumer, Items.YELLOW_DYE, SeafarerBlocks.COASTAL_WILDFLOWER.get());
        makeDye(consumer, Items.PURPLE_DYE, SeafarerBlocks.COASTAL_LAVENDER.get());
        makeDye(consumer, Items.BLUE_DYE, SeafarerBlocks.SEA_HOLLY.get());
        makeDye(consumer, Items.PINK_DYE, SeafarerBlocks.SEA_THRIFT.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SeafarerItems.SALTED_SALMON.get())
                .define('s', SeafarerItems.SEA_SALT.get())
                .define('l', Items.SALMON)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(Items.SALMON.asItem()), has(Items.SALMON))
                .unlockedBy(getHasName(SeafarerItems.SEA_SALT.get().asItem()), has(SeafarerItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SeafarerItems.SALTED_SALMON.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SeafarerItems.SALTED_COD.get())
                .define('s', SeafarerItems.SEA_SALT.get())
                .define('l', Items.COD)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(Items.COD.asItem()), has(Items.COD))
                .unlockedBy(getHasName(SeafarerItems.SEA_SALT.get().asItem()), has(SeafarerItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SeafarerItems.SALTED_COD.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SeafarerItems.SALTED_STARFISH.get())
                .define('s', SeafarerItems.SEA_SALT.get())
                .define('l', SeafarerTags.STARFISH_ITEM)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(SeafarerItems.SEA_SALT.get().asItem()), has(SeafarerItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SeafarerItems.SALTED_STARFISH.get()));


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SeafarerItems.SALTED_TROPICAL_FISH.get())
                .define('s', SeafarerItems.SEA_SALT.get())
                .define('l', Items.TROPICAL_FISH)
                .pattern(" s ")
                .pattern("sls")
                .pattern(" s ")
                .unlockedBy(getHasName(SeafarerItems.SEA_SALT.get().asItem()), has(SeafarerItems.SEA_SALT.get().asItem()))
                .save(consumer, key(SeafarerItems.SALTED_TROPICAL_FISH.get()));

        smeltingRecipes(consumer);
    }


    private void smeltingRecipes(Consumer<FinishedRecipe> consumer) {
        foodSmeltingRecipes(key(SeafarerBlocks.BLUE_STARFISH.get()).getPath(), SeafarerBlocks.BLUE_STARFISH.get().asItem(), SeafarerItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeafarerBlocks.OCHRE_STARFISH.get()).getPath(), SeafarerBlocks.OCHRE_STARFISH.get().asItem(), SeafarerItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeafarerBlocks.PURPLE_OCHRE_STARFISH.get()).getPath(), SeafarerBlocks.PURPLE_OCHRE_STARFISH.get().asItem(), SeafarerItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeafarerBlocks.PINK_STARFISH.get()).getPath(), SeafarerBlocks.PINK_STARFISH.get().asItem(), SeafarerItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeafarerBlocks.RED_STARFISH.get()).getPath(), SeafarerBlocks.RED_STARFISH.get().asItem(), SeafarerItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeafarerBlocks.ROYAL_STARFISH.get()).getPath(), SeafarerBlocks.ROYAL_STARFISH.get().asItem(), SeafarerItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeafarerBlocks.CHOCOLATE_CHIP_STARFISH.get()).getPath(), SeafarerBlocks.CHOCOLATE_CHIP_STARFISH.get().asItem(), SeafarerItems.COOKED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeafarerBlocks.COMMON_ORANGE_STARFISH.get()).getPath(), SeafarerBlocks.COMMON_ORANGE_STARFISH.get().asItem(), SeafarerItems.COOKED_STARFISH.get(),250,consumer);
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

