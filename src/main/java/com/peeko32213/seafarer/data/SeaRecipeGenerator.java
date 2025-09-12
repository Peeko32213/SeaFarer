package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.SeaItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;


public class SeaRecipeGenerator extends SeaRecipeProvider implements IConditionBuilder {

    public SeaRecipeGenerator(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

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

        smeltingRecipe(SeaItems.COOKED_SHORE_CRAB_LEG.get(), SeaItems.RAW_SHORE_CRAB_LEG.get(), 10, 1).save(consumer);

        smeltingRecipe(SeaItems.COOKED_HORSESHOE_CRAB.get(), SeaItems.RAW_HORSESHOE_CRAB.get(), 10, 1).save(consumer);

        smeltingRecipe(SeaItems.COOKED_MARINE_IGUANA_TAIL.get(), SeaItems.RAW_MARINE_IGUANA_TAIL.get(), 10, 1).save(consumer);

        makeDye(consumer, Items.YELLOW_DYE, SeaBlocks.COASTAL_WILDFLOWER.get());
        makeDye(consumer, Items.PURPLE_DYE, SeaBlocks.COASTAL_LAVENDER.get());
        makeDye(consumer, Items.BLUE_DYE, SeaBlocks.SEA_HOLLY.get());
        makeDye(consumer, Items.ORANGE_DYE, SeaBlocks.FIERY_DUSTER.get());
        makeDye(consumer, Items.GRAY_DYE, SeaBlocks.SILK_LILIES.get());
        makeDye(consumer, Items.PURPLE_DYE, SeaBlocks.TWILIGHT_BLADE.get());
        makeDye(consumer, Items.BLUE_DYE, SeaBlocks.DAWNFLAME.get());

        smeltingRecipes(consumer);
    }


    private void smeltingRecipes(Consumer<FinishedRecipe> consumer) {
        foodSmeltingRecipes(key(SeaBlocks.BLUE_STARFISH.get()).getPath(), SeaBlocks.BLUE_STARFISH.get().asItem(), SeaItems.DRIED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.OCHRE_STARFISH.get()).getPath(), SeaBlocks.OCHRE_STARFISH.get().asItem(), SeaItems.DRIED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.PURPLE_OCHRE_STARFISH.get()).getPath(), SeaBlocks.PURPLE_OCHRE_STARFISH.get().asItem(), SeaItems.DRIED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.PINK_STARFISH.get()).getPath(), SeaBlocks.PINK_STARFISH.get().asItem(), SeaItems.DRIED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.RED_STARFISH.get()).getPath(), SeaBlocks.RED_STARFISH.get().asItem(), SeaItems.DRIED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.ROYAL_STARFISH.get()).getPath(), SeaBlocks.ROYAL_STARFISH.get().asItem(), SeaItems.DRIED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.CHOCOLATE_CHIP_STARFISH.get()).getPath(), SeaBlocks.CHOCOLATE_CHIP_STARFISH.get().asItem(), SeaItems.DRIED_STARFISH.get(),250,consumer);
        foodSmeltingRecipes(key(SeaBlocks.ORANGE_STARFISH.get()).getPath(), SeaBlocks.ORANGE_STARFISH.get().asItem(), SeaItems.DRIED_STARFISH.get(),250,consumer);
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

