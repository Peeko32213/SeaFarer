package com.peeko32213.seafarer.data;


import com.peeko32213.seafarer.registry.SeaBlocks;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;

public class SeaBlockLootTableProvider extends BlockLootSubProvider {
    private final Set<Block> knownBlocks = new HashSet<>();
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    public SeaBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void add(Block pBlock, LootTable.Builder pBuilder) {
        super.add(pBlock, pBuilder);
        knownBlocks.add(pBlock);
    }

    @Override
    protected void generate() {
        dropWhenSilkTouch(SeaBlocks.LIGHT_BLUE_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.LIGHT_BLUE_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.LIGHT_BLUE_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.LIGHT_BLUE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.LIGHT_BLUE_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.BLACK_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.BLACK_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.BLACK_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.BLACK_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.BLACK_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.BLACK_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.GREEN_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.GREEN_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.GREEN_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.GREEN_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.GREEN_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.GREEN_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.ORANGE_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.ORANGE_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.ORANGE_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.ORANGE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.ORANGE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.ORANGE_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.MAGENTA_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.MAGENTA_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.MAGENTA_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.MAGENTA_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.MAGENTA_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.MAGENTA_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.RED_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.RED_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.RED_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.RED_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.RED_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.RED_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.WHITE_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.WHITE_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.WHITE_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.WHITE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.WHITE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.WHITE_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.YELLOW_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.YELLOW_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.YELLOW_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.YELLOW_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.YELLOW_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.YELLOW_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.PINK_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.PINK_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.PINK_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.PINK_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.PINK_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.PINK_PEBBLED_SEA_GLASS.get());

        dropWhenSilkTouch(SeaBlocks.LIME_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.LIME_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.LIME_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.LIME_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.LIME_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.LIME_PEBBLED_SEA_GLASS.get());

        dropSelf(SeaBlocks.FISHING_NET.get());

        dropSelf(SeaBlocks.CLAM_SHELL.get());
        dropSelf(SeaBlocks.HORN_SHELL.get());
        dropSelf(SeaBlocks.SPIKY_SHELL.get());
        dropSelf(SeaBlocks.SPIRAL_SHELL.get());
        dropSelf(SeaBlocks.SWIRL_SHELL.get());
        dropSelf(SeaBlocks.PYRAMID_SHELL.get());

        dropSelf(SeaBlocks.BEACHGRASS.get());
        dropSelf(SeaBlocks.SEA_THRIFT.get());
        dropSelf(SeaBlocks.SEA_HOLLY.get());
        dropSelf(SeaBlocks.COASTAL_LAVENDER.get());
        dropSelf(SeaBlocks.COASTAL_WILDFLOWER.get());

        dropSelf(SeaBlocks.CLAM_SHELL_BRICKS.get());
        dropSelf(SeaBlocks.CLAM_SHELL_PILLAR.get());
        dropSelf(SeaBlocks.CLAM_SHELL_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.CLAM_SHELL_BRICK_SLAB.get());

        dropSelf(SeaBlocks.HORN_SHELL_BRICKS.get());
        dropSelf(SeaBlocks.HORN_SHELL_PILLAR.get());
        dropSelf(SeaBlocks.HORN_SHELL_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.HORN_SHELL_BRICK_SLAB.get());

        dropSelf(SeaBlocks.SPIKY_SHELL_BRICKS.get());
        dropSelf(SeaBlocks.SPIKY_SHELL_PILLAR.get());
        dropSelf(SeaBlocks.SPIKY_SHELL_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.SPIKY_SHELL_BRICK_SLAB.get());

        dropSelf(SeaBlocks.SPIRAL_SHELL_BRICKS.get());
        dropSelf(SeaBlocks.SPIRAL_SHELL_PILLAR.get());
        dropSelf(SeaBlocks.SPIRAL_SHELL_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.SPIRAL_SHELL_BRICK_SLAB.get());

        dropSelf(SeaBlocks.SWIRL_SHELL_BRICKS.get());
        dropSelf(SeaBlocks.SWIRL_SHELL_PILLAR.get());
        dropSelf(SeaBlocks.SWIRL_SHELL_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.SWIRL_SHELL_BRICK_SLAB.get());

        dropSelf(SeaBlocks.PYRAMID_SHELL_BRICKS.get());
        dropSelf(SeaBlocks.PYRAMID_SHELL_PILLAR.get());
        dropSelf(SeaBlocks.PYRAMID_SHELL_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.PYRAMID_SHELL_BRICK_SLAB.get());

        dropSelf(SeaBlocks.CORALINE_SAND.get());

        createMultipleDrops(SeaBlocks.SHELLY_SAND.get(), SeaBlocks.SPIRAL_SHELL.get().asItem(), SeaBlocks.SWIRL_SHELL.get().asItem());

        createPotFlowerItemTable(SeaBlocks.POTTED_COASTAL_LAVENDER.get(), SeaBlocks.COASTAL_LAVENDER.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_SEA_HOLLY.get(), SeaBlocks.SEA_HOLLY.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_SEA_THRIFT.get(), SeaBlocks.SEA_THRIFT.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_COASTAL_WILDFLOWER.get(), SeaBlocks.COASTAL_WILDFLOWER.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_FIERY_DUSTER.get(), SeaBlocks.FIERY_DUSTER.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_SILK_LILIES.get(), SeaBlocks.SILK_LILIES.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_TWILIGHT_BLADE.get(), SeaBlocks.TWILIGHT_BLADE.get());
    }
    protected void createPotFlowerItemTable(Block flowerpotBlock, ItemLike pItem) {
        add(flowerpotBlock ,LootTable.lootTable()
                .withPool(this.applyExplosionCondition(Blocks.FLOWER_POT, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.FLOWER_POT))))
                .withPool(this.applyExplosionCondition(pItem, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(pItem)))));
    }


    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createMultipleDrops(Block pBlock, Item item1, Item item2) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .then(LootItem.lootTableItem(item2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createMultipleBlockDrops(Block pBlock, Block item1, Block item2) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                                LootItem.lootTableItem(item1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .then(LootItem.lootTableItem(item2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }
}
