package com.peeko32213.seafarer.data;


import com.peeko32213.seafarer.registry.SeafarerBlocks;
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

public class SeafarerBlockLootTableProvider extends BlockLootSubProvider {
    private final Set<Block> knownBlocks = new HashSet<>();
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    public SeafarerBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void add(Block pBlock, LootTable.Builder pBuilder) {
        super.add(pBlock, pBuilder);
        knownBlocks.add(pBlock);
    }

    @Override
    protected void generate() {
        dropWhenSilkTouch(SeafarerBlocks.AZURE_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.AZURE_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.AZURE_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.AZURE_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.AZURE_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.AZURE_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.AZURE_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.AZURE_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.UMBER_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.UMBER_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.UMBER_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.UMBER_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.UMBER_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.UMBER_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.UMBER_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.UMBER_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.SEAFOAM_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.SEAFOAM_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.SEAFOAM_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.SEAFOAM_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.AMBER_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.AMBER_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.AMBER_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.AMBER_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.AMBER_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.AMBER_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.AMBER_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.AMBER_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.LILAC_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.LILAC_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.LILAC_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.LILAC_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.LILAC_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.LILAC_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.LILAC_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.LILAC_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.SCARLET_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.SCARLET_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.SCARLET_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.SCARLET_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.SCARLET_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.SCARLET_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.SCARLET_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.PEARLY_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.PEARLY_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.PEARLY_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.PEARLY_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.PEARLY_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.PEARLY_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.PEARLY_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.CITRINE_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.CITRINE_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.CITRINE_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.CITRINE_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.CITRINE_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.CITRINE_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.CITRINE_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.ROSE_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.ROSE_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.ROSE_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.ROSE_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.ROSE_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.ROSE_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.ROSE_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.ROSE_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeafarerBlocks.CHARTREUSE_SEA_GLASS.get());
        dropWhenSilkTouch(SeafarerBlocks.CHARTREUSE_SEA_GLASS_PANE.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILES.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_SEA_GLASS_PEBBLES.get());
        dropSelf(SeafarerBlocks.CHARTREUSE_SEA_GLASS_BOTTLE.get());

        dropSelf(SeafarerBlocks.FISHING_NET.get());

        dropSelf(SeafarerBlocks.COMMON_ORANGE_STARFISH.get());
        dropSelf(SeafarerBlocks.PINK_STARFISH.get());
        dropSelf(SeafarerBlocks.RED_STARFISH.get());
        dropSelf(SeafarerBlocks.CHOCOLATE_CHIP_STARFISH.get());
        dropSelf(SeafarerBlocks.BLUE_STARFISH.get());
        dropSelf(SeafarerBlocks.PURPLE_OCHRE_STARFISH.get());
        dropSelf(SeafarerBlocks.ROYAL_STARFISH.get());
        dropSelf(SeafarerBlocks.OCHRE_STARFISH.get());

        dropSelf(SeafarerBlocks.ALGAE_BLOCK.get());
        dropWhenSilkTouch(SeafarerBlocks.ALGAE_CARPET.get());
        dropWhenSilkTouch(SeafarerBlocks.ALGAE_PLANT.get());
        dropSelf(SeafarerBlocks.ALGAE_COBBLESTONE.get());
        dropSelf(SeafarerBlocks.ALGAE_COBBLESTONE_STAIRS.get());
        dropSelf(SeafarerBlocks.ALGAE_COBBLESTONE_SLAB.get());

        dropSelf(SeafarerBlocks.CLAM_SHELL.get());
        dropSelf(SeafarerBlocks.HORN_SHELL.get());
        dropSelf(SeafarerBlocks.SPIKY_SHELL.get());
        dropSelf(SeafarerBlocks.SPIRAL_SHELL.get());
        dropSelf(SeafarerBlocks.SWIRL_SHELL.get());
        dropSelf(SeafarerBlocks.PYRAMID_SHELL.get());

        dropSelf(SeafarerBlocks.OLD_BOARDS.get());

        dropSelf(SeafarerBlocks.BEACHGRASS_FAN.get());
        dropSelf(SeafarerBlocks.BEACHGRASS.get());
        dropSelf(SeafarerBlocks.SEA_THRIFT.get());
        dropSelf(SeafarerBlocks.SEA_HOLLY.get());
        dropSelf(SeafarerBlocks.COASTAL_LAVENDER.get());
        dropSelf(SeafarerBlocks.COASTAL_WILDFLOWER.get());

        dropSelf(SeafarerBlocks.SALT_BLOCK.get());

        dropSelf(SeafarerBlocks.CLAM_SHELL_BRICKS.get());
        dropSelf(SeafarerBlocks.CLAM_SHELL_PILLAR.get());
        dropSelf(SeafarerBlocks.CLAM_SHELL_BRICKS_STAIRS.get());
        dropSelf(SeafarerBlocks.CLAM_SHELL_BRICKS_SLAB.get());

        dropSelf(SeafarerBlocks.HORN_SHELL_BRICKS.get());
        dropSelf(SeafarerBlocks.HORN_SHELL_PILLAR.get());
        dropSelf(SeafarerBlocks.HORN_SHELL_BRICKS_STAIRS.get());
        dropSelf(SeafarerBlocks.HORN_SHELL_BRICKS_SLAB.get());

        dropSelf(SeafarerBlocks.SPIKY_SHELL_BRICKS.get());
        dropSelf(SeafarerBlocks.SPIKY_SHELL_PILLAR.get());
        dropSelf(SeafarerBlocks.SPIKY_SHELL_BRICKS_STAIRS.get());
        dropSelf(SeafarerBlocks.SPIKY_SHELL_BRICKS_SLAB.get());

        dropSelf(SeafarerBlocks.SPIRAL_SHELL_BRICKS.get());
        dropSelf(SeafarerBlocks.SPIRAL_SHELL_PILLAR.get());
        dropSelf(SeafarerBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get());
        dropSelf(SeafarerBlocks.SPIRAL_SHELL_BRICKS_SLAB.get());

        dropSelf(SeafarerBlocks.SWIRL_SHELL_BRICKS.get());
        dropSelf(SeafarerBlocks.SWIRL_SHELL_PILLAR.get());
        dropSelf(SeafarerBlocks.SWIRL_SHELL_BRICKS_STAIRS.get());
        dropSelf(SeafarerBlocks.SWIRL_SHELL_BRICKS_SLAB.get());

        dropSelf(SeafarerBlocks.PYRAMID_SHELL_BRICKS.get());
        dropSelf(SeafarerBlocks.PYRAMID_SHELL_PILLAR.get());
        dropSelf(SeafarerBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get());
        dropSelf(SeafarerBlocks.PYRAMID_SHELL_BRICKS_SLAB.get());

        dropSelf(SeafarerBlocks.GRAVELY_SAND.get());
        dropSelf(SeafarerBlocks.ROCKY_SAND.get());
        dropSelf(SeafarerBlocks.BLUE_MIXED_SPRINKLED_SAND.get());
        dropSelf(SeafarerBlocks.RED_MIXED_SPRINKLED_SAND.get());
        dropSelf(SeafarerBlocks.BLUE_SPRINKLED_SAND.get());
        dropSelf(SeafarerBlocks.PINK_SPRINKLED_SAND.get());
        dropSelf(SeafarerBlocks.PURPLE_SPRINKLED_SAND.get());
        dropSelf(SeafarerBlocks.RED_SPRINKLED_SAND.get());
        dropSelf(SeafarerBlocks.CORAL_SAND.get());

        createMultipleDrops(SeafarerBlocks.MIXED_SHELLY_SAND.get(), SeafarerBlocks.SPIRAL_SHELL.get().asItem(), SeafarerBlocks.SWIRL_SHELL.get().asItem());
        createMultipleDrops(SeafarerBlocks.SCATTERED_SHELLY_SAND.get(), SeafarerBlocks.CLAM_SHELL.get().asItem(), SeafarerBlocks.HORN_SHELL.get().asItem());
        createMultipleDrops(SeafarerBlocks.JUMBLED_SHELLY_SAND.get(), SeafarerBlocks.PYRAMID_SHELL.get().asItem(), SeafarerBlocks.SPIKY_SHELL.get().asItem());

        createPotFlowerItemTable(SeafarerBlocks.POTTED_COASTAL_LAVENDER.get(), SeafarerBlocks.COASTAL_LAVENDER.get());
        createPotFlowerItemTable(SeafarerBlocks.POTTED_SEA_HOLLY.get(), SeafarerBlocks.SEA_HOLLY.get());
        createPotFlowerItemTable(SeafarerBlocks.POTTED_SEA_THRIFT.get(), SeafarerBlocks.SEA_THRIFT.get());
        createPotFlowerItemTable(SeafarerBlocks.POTTED_COASTAL_WILDFLOWER.get(), SeafarerBlocks.COASTAL_WILDFLOWER.get());

        dropSelf(SeafarerBlocks.ALGAE_COBBLESTONE.get());
        dropSelf(SeafarerBlocks.ALGAE_COBBLESTONE_SLAB.get());
        dropSelf(SeafarerBlocks.ALGAE_COBBLESTONE_STAIRS.get());

        dropSelf(SeafarerBlocks.WAKAME.get());


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
