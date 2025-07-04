package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SignBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.peeko32213.seafarer.Seafarer.modPrefix;
import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public abstract class SeafarerRecipeProvider extends RecipeProvider {


    public SeafarerRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public ShapelessRecipeBuilder makePlanks(Supplier<? extends Block> plankOut, TagKey<Item> logIn) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, plankOut.get(), 4)
                .requires(logIn)
                .group("planks")
                .unlockedBy("has_log", has(logIn));
    }

    public void makeDye(Consumer<FinishedRecipe> c, Item plankOut, Block logIn) {

        ResourceLocation rl = key(plankOut);
        ResourceLocation rl2 = key(logIn);

        String name = rl.getPath() + "_from_" + rl2.getPath();

         ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, plankOut, 4)
                 .requires(logIn)
                .unlockedBy("has_flower", has(logIn))
                .save(c, modPrefix(name));
    }

    public ShapedRecipeBuilder makeDoor(Supplier<? extends Block> doorOut, Supplier<? extends Block> plankIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, doorOut.get(), 3)
                .pattern("PP")
                .pattern("PP")
                .pattern("PP")
                .define('P', plankIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(plankIn.get()).getPath(), has(plankIn.get()));
    }

    public ShapedRecipeBuilder makeTrapdoor(Supplier<? extends Block> trapdoorOut, Supplier<? extends Block> plankIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, trapdoorOut.get(), 2)
                .pattern("PPP")
                .pattern("PPP")
                .define('P', plankIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(plankIn.get()).getPath(), has(plankIn.get()));
    }

    public ShapelessRecipeBuilder makeButton(Supplier<? extends Block> buttonOut, Supplier<? extends Block> blockIn) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, buttonOut.get())
                .requires(blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makePressurePlate(Supplier<? extends Block> pressurePlateOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pressurePlateOut.get())
                .pattern("BB")
                .define('B', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeStairs(Supplier<? extends Block> stairsOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairsOut.get(), 4)
                .pattern("M  ")
                .pattern("MM ")
                .pattern("MMM")
                .define('M', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makCarpet(Supplier<? extends Block> stairsOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairsOut.get(), 4)
                .pattern("   ")
                .pattern("   ")
                .pattern("MMM")
                .define('M', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makePanes(Supplier<? extends Block> stairsOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairsOut.get(), 16)
                .pattern("   ")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeSlab(Supplier<? extends Block> slabOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slabOut.get(), 6)
                .pattern("MMM")
                .define('M', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public static ShapelessRecipeBuilder shapeless(RecipeCategory pCategory, ItemLike pResult) {
        return new ShapelessRecipeBuilder(pCategory, pResult, 1);
    }

    public ShapedRecipeBuilder makeWall(Supplier<? extends Block> wallOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wallOut.get(), 6)
                .pattern("MMM")
                .pattern("MMM")
                .define('M', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeFence(Supplier<? extends Block> fenceOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fenceOut.get(), 6)
                .pattern("M/M")
                .pattern("M/M")
                .define('M', blockIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeFenceGate(Supplier<? extends Block> fenceGateOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fenceGateOut.get())
                .pattern("/M/")
                .pattern("/M/")
                .define('M', blockIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeBricks(Supplier<? extends Block> bricksOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksOut.get(), 4)
                .pattern("MM")
                .pattern("MM")
                .define('M', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeSeaGlass(Supplier<? extends Block> bricksOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksOut.get(), 8)
                .pattern("MM")
                .pattern("MM")
                .define('M', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeChiseledBricks(Supplier<? extends Block> bricksOut, Supplier<? extends Block> blockIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksOut.get())
                .pattern("M")
                .pattern("M")
                .define('M', blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeWood(Supplier<? extends Block> woodOut, Supplier<? extends Item> logIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, woodOut.get(), 4)
                .pattern("MM")
                .pattern("MM")
                .define('M', logIn.get())
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(logIn.get()).getPath(), has(logIn.get()));
    }


    public ShapedRecipeBuilder makeIngotToBlock(Supplier<? extends Block> blockOut, Supplier<? extends Item> ingotIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockOut.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingotIn.get())
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ingotIn.get()).getPath(), has(ingotIn.get()));
    }

    public ShapedRecipeBuilder makeGlasstoBottle(Supplier<? extends Block> blockOut, Supplier<? extends Block> ingotIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockOut.get())
                .pattern("   ")
                .pattern("# #")
                .pattern(" # ")
                .define('#', ingotIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(ingotIn.get()).getPath(), has(ingotIn.get()));
    }

    public ShapedRecipeBuilder makeCondensedToBlock(Supplier<? extends Block> blockOut, Supplier<? extends Block> logIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, blockOut.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', logIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(logIn.get()).getPath(), has(logIn.get()));
    }

    public ShapelessRecipeBuilder makeBlockToIngot(Supplier<? extends Item> ingotOut, Supplier<? extends Block> blockIn) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ingotOut.get(), 9)
                .requires(blockIn.get())
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(blockIn.get()).getPath(), has(blockIn.get()));
    }

    public ShapedRecipeBuilder makeNuggetToIngot(Supplier<? extends Item> ingotOut, Supplier<? extends Item> nuggetIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ingotOut.get(), 1)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', nuggetIn.get())
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(nuggetIn.get()).getPath(), has(nuggetIn.get()));
    }

    public ShapelessRecipeBuilder makeIngotToNugget(Supplier<? extends Item> nuggetOut, Supplier<? extends Item> ingotIn) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, nuggetOut.get(), 9)
                .requires(ingotIn.get())
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ingotIn.get()).getPath(), has(ingotIn.get()));
    }

    public ShapedRecipeBuilder makeSword(Supplier<? extends Item> swordOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, swordOut.get())
                .pattern("#")
                .pattern("#")
                .pattern("/")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makePickaxe(Supplier<? extends Item> pickaxeOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxeOut.get())
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeAxe(Supplier<? extends Item> axeOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axeOut.get())
                .pattern("##")
                .pattern("#/")
                .pattern(" /")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeShovel(Supplier<? extends Item> shovelOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovelOut.get())
                .pattern("#")
                .pattern("/")
                .pattern("/")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeHoe(Supplier<? extends Item> hoeOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoeOut.get())
                .pattern("##")
                .pattern(" /")
                .pattern(" /")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeBlockSword(Supplier<? extends Item> swordOut, Supplier<? extends Block> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, swordOut.get())
                .pattern("#")
                .pattern("#")
                .pattern("/")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeBlockPickaxe(Supplier<? extends Item> pickaxeOut, Supplier<? extends Block> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxeOut.get())
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeBlockAxe(Supplier<? extends Item> axeOut, Supplier<? extends Block> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axeOut.get())
                .pattern("##")
                .pattern("#/")
                .pattern(" /")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeBlockShovel(Supplier<? extends Item> shovelOut, Supplier<? extends Block> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovelOut.get())
                .pattern("#")
                .pattern("/")
                .pattern("/")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeBlockHoe(Supplier<? extends Item> hoeOut, Supplier<? extends Block> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoeOut.get())
                .pattern("##")
                .pattern(" /")
                .pattern(" /")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeHelmet(Supplier<? extends Item> helmetOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmetOut.get())
                .pattern("MMM")
                .pattern("M M")
                .define('M', materialIn.get())
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeChestplate(Supplier<? extends Item> helmetOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmetOut.get())
                .pattern("M M")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', materialIn.get())
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeLeggings(Supplier<? extends Item> helmetOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmetOut.get())
                .pattern("MMM")
                .pattern("M M")
                .pattern("M M")
                .define('M', materialIn.get())
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapedRecipeBuilder makeBoots(Supplier<? extends Item> helmetOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmetOut.get())
                .pattern("M M")
                .pattern("M M")
                .define('M', materialIn.get())
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public ShapelessRecipeBuilder makeStew(Supplier<? extends Item> stewOut, Supplier<? extends Block> mushroomIn) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, stewOut.get())
                .requires(Items.BOWL)
                .requires(mushroomIn.get(), 3)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(mushroomIn.get()).getPath(), has(mushroomIn.get()));
    }

    public ShapedRecipeBuilder makeBoat(Supplier<? extends Item> boatOut, Supplier<? extends Block> planksIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, boatOut.get())
                .pattern("P P")
                .pattern("PPP")
                .define('P', planksIn.get())
                .group("boat")
                .unlockedBy("in_water", insideOf(Blocks.WATER));
    }

    public ShapelessRecipeBuilder makeChestBoat(Supplier<? extends Item> chestBoatOut, Supplier<? extends Block> boatIn) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, chestBoatOut.get())
                .requires(boatIn.get())
                .requires(Tags.Items.CHESTS_WOODEN)
                .group("chest_boat")
                .unlockedBy("has_boat", has(ItemTags.BOATS));
    }

    public ShapedRecipeBuilder makeSign(Supplier<? extends SignBlock> signOut, Supplier<? extends Block> planksIn) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, signOut.get(), 3)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" / ")
                .define('P', planksIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(planksIn.get()).getPath(), has(planksIn.get()));
    }

    public void ore(ItemLike result, List<ItemLike> ingredients, float xp, String group, Consumer<FinishedRecipe> consumer) {
        oreSmeltingRecipe(result, ingredients, xp, group, consumer);
        oreBlastingRecipe(result, ingredients, xp, group, consumer);
    }

    public SimpleCookingRecipeBuilder smeltingRecipe(ItemLike result, ItemLike ingredient, float exp) {
        return smeltingRecipe(result, ingredient, exp, 1);
    }

    private void oreSmeltingRecipe(ItemLike result, List<ItemLike> ingredients, float xp, String group, Consumer<FinishedRecipe> consumer) {
        for (ItemLike ingredient : ingredients) {
            smeltingRecipe(result, ingredient, xp, 1).group(group).save(consumer, new ResourceLocation(Seafarer.MOD_ID, "smelt_" + ForgeRegistries.ITEMS.getKey(ingredient.asItem()).getPath()));
        }
    }

    public SimpleCookingRecipeBuilder smeltingRecipe(ItemLike result, ItemLike ingredient, float exp, int count) {
        return SimpleCookingRecipeBuilder.smelting(Ingredient.of(new ItemStack(ingredient, count)), RecipeCategory.MISC, result, exp, 200)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ingredient.asItem()), has(ingredient));
    }

    public SimpleCookingRecipeBuilder smeltingRecipeTag(ItemLike result, TagKey<Item> ingredient, float exp) {
        return smeltingRecipeTag(result, ingredient, exp, 1);
    }

    public SimpleCookingRecipeBuilder smeltingRecipeTag(ItemLike result, TagKey<Item> ingredient, float exp, int count) {
        return SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.MISC, result, exp, 200)
                .unlockedBy("has_" + ingredient, has(ingredient));
    }

    public SimpleCookingRecipeBuilder blastingRecipe(ItemLike result, ItemLike ingredient, float exp) {
        return blastingRecipe(result, ingredient, exp, 1);
    }

    private void oreBlastingRecipe(ItemLike result, List<ItemLike> ingredients, float xp, String group, Consumer<FinishedRecipe> consumer) {
        for (ItemLike ingredient : ingredients) {
            blastingRecipe(result, ingredient, xp, 1).group(group).save(consumer, new ResourceLocation(Seafarer.MOD_ID, "blast_" + ForgeRegistries.ITEMS.getKey(ingredient.asItem()).getPath()));
        }
    }

    public SimpleCookingRecipeBuilder blastingRecipe(ItemLike result, ItemLike ingredient, float exp, int count) {
        return SimpleCookingRecipeBuilder.blasting(Ingredient.of(new ItemStack(ingredient, count)), RecipeCategory.MISC, result, exp, 100)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ingredient.asItem()), has(ingredient));
    }

    public SimpleCookingRecipeBuilder blastingRecipeTag(ItemLike result, TagKey<Item> ingredient, float exp) {
        return blastingRecipeTag(result, ingredient, exp, 1);
    }

    public SimpleCookingRecipeBuilder blastingRecipeTag(ItemLike result, TagKey<Item> ingredient, float exp, int count) {
        return SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), RecipeCategory.MISC, result, exp, 100)
                .unlockedBy("has_" + ingredient, has(ingredient));
    }

    public SimpleCookingRecipeBuilder smokingRecipe(ItemLike result, ItemLike ingredient, float exp) {
        return smokingRecipe(result, ingredient, exp, 1);
    }

    public SimpleCookingRecipeBuilder smokingRecipe(ItemLike result, ItemLike ingredient, float exp, int count) {
        return SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(new ItemStack(ingredient, count)), RecipeCategory.BUILDING_BLOCKS, result, exp, 100)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(ingredient.asItem()), has(ingredient));
    }

    /*
    public UpgradeRecipeBuilder smithingRecipe(Supplier<Item> input, Supplier<Item> upgradeItem, Supplier<Item> result) {
        return Smit.smithing(Ingredient.of(input.get()), Ingredient.of(upgradeItem.get()), result.get())
                .unlocks("has_" + ForgeRegistries.ITEMS.getKey(upgradeItem.get()), has(upgradeItem.get()));
    }
*/
    public SingleItemRecipeBuilder stonecutting(Supplier<Block> input, ItemLike result) {
        return SingleItemRecipeBuilder.stonecutting(Ingredient.of(input.get()), RecipeCategory.BUILDING_BLOCKS, result)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(input.get()), has(input.get()));
    }

    public SingleItemRecipeBuilder stonecutting(Supplier<Block> input, ItemLike result, int resultAmount) {
        return SingleItemRecipeBuilder.stonecutting(Ingredient.of(input.get()), RecipeCategory.BUILDING_BLOCKS, result, resultAmount)
                .unlockedBy("has_" + ForgeRegistries.BLOCKS.getKey(input.get()), has(input.get()));
    }


    public void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
        String namePrefix = new ResourceLocation(Seafarer.MOD_ID, name).toString();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
                .unlockedBy(name, hasItems(ingredient)).save(consumer, modPrefix(name));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy(name, hasItems(ingredient))
                .save(consumer, modPrefix(name + "_from_campfire_cooking"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy(name, hasItems(ingredient))
                .save(consumer, modPrefix(name + "_from_smoking"));
    }

    public ResourceLocation key(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
    public ResourceLocation key(Block item) {
        return BuiltInRegistries.BLOCK.getKey(item);
    }
}
