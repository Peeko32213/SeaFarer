package com.peeko32213.seafarer.datagen;

import com.peeko32213.seafarer.SeaFarer;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;


public class RecipeGenerator extends SFRecipeProvider implements IConditionBuilder {
    public RecipeGenerator(PackOutput pGenerator) {
        super(pGenerator);
    }
    public static final int FAST_COOKING = 100;		// 5 seconds
    public static final int NORMAL_COOKING = 200;	// 10 seconds
    public static final int SLOW_COOKING = 400;		// 20 seconds
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Foxxi
        // makePlanks(UPBlocks.FOXXI_PLANKS, UPTags.FOXXI).save(consumer);
        // makeWood(UPBlocks.FOXXI_WOOD, UPBlocks.FOXXI_LOG).save(consumer);
        // makeStairs(UPBlocks.FOXXI_STAIRS, UPBlocks.FOXXI_PLANKS).save(consumer);

        // makeSlab(UPBlocks.FOXXI_SLAB, UPBlocks.FOXXI_PLANKS).save(consumer);

        //  makeFence(UPBlocks.FOXXI_FENCE, UPBlocks.FOXXI_PLANKS).save(consumer);

        // makeFenceGate(UPBlocks.FOXXI_FENCE_GATE, UPBlocks.FOXXI_PLANKS).save(consumer);

        // makeDoor(UPBlocks.FOXXI_DOOR, UPBlocks.FOXXI_PLANKS).save(consumer);

        // makeTrapdoor(UPBlocks.FOXXI_TRAPDOOR, UPBlocks.FOXXI_PLANKS).save(consumer);

        // makeButton(UPBlocks.FOXXI_BUTTON, UPBlocks.FOXXI_PLANKS).save(consumer);

        // makePressurePlate(UPBlocks.FOXXI_PRESSURE_PLATE, UPBlocks.FOXXI_PLANKS).save(consumer);

        // makeSign(UPBlocks.FOXXI_SIGN, UPBlocks.FOXXI_PLANKS).save(consumer);

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
