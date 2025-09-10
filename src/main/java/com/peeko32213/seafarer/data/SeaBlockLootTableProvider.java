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
        dropWhenSilkTouch(SeaBlocks.AZURE_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.AZURE_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.AZURE_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.AZURE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.AZURE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.AZURE_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.AZURE_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.AZURE_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.AZURE_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.AZURE_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.AZURE_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.UMBER_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.UMBER_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.UMBER_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.UMBER_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.UMBER_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.UMBER_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.UMBER_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.UMBER_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.UMBER_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.UMBER_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.UMBER_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.SEAFOAM_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.SEAFOAM_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.SEAFOAM_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.SEAFOAM_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.SEAFOAM_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.SEAFOAM_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.SEAFOAM_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.SEAFOAM_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.SEAFOAM_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.SEAFOAM_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.SEAFOAM_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.AMBER_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.AMBER_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.AMBER_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.AMBER_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.AMBER_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.AMBER_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.AMBER_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.AMBER_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.AMBER_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.AMBER_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.AMBER_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.LILAC_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.LILAC_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.LILAC_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.LILAC_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.LILAC_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.LILAC_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.LILAC_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.LILAC_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.LILAC_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.LILAC_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.LILAC_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.SCARLET_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.SCARLET_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.SCARLET_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.SCARLET_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.SCARLET_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.SCARLET_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.SCARLET_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.SCARLET_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.SCARLET_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.SCARLET_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.SCARLET_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.PEARLY_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.PEARLY_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.PEARLY_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.PEARLY_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.PEARLY_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.PEARLY_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.PEARLY_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.PEARLY_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.PEARLY_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.PEARLY_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.PEARLY_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.CITRINE_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.CITRINE_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.CITRINE_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.CITRINE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.CITRINE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.CITRINE_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.CITRINE_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.CITRINE_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.CITRINE_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.CITRINE_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.CITRINE_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.ROSE_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.ROSE_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.ROSE_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.ROSE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.ROSE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.ROSE_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.ROSE_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.ROSE_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.ROSE_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.ROSE_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.ROSE_SEA_GLASS_BOTTLE.get());

        dropWhenSilkTouch(SeaBlocks.CHARTREUSE_SEA_GLASS.get());
        dropWhenSilkTouch(SeaBlocks.CHARTREUSE_SEA_GLASS_PANE.get());
        dropSelf(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICKS.get());
        dropSelf(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICK_SLAB.get());
        dropSelf(SeaBlocks.CHARTREUSE_SEA_GLASS_BRICK_STAIRS.get());
        dropSelf(SeaBlocks.CHARTREUSE_PEBBLED_SEA_GLASS.get());
        dropSelf(SeaBlocks.CHARTREUSE_SEA_GLASS_TILES.get());
        dropSelf(SeaBlocks.CHARTREUSE_SEA_GLASS_TILE_SLAB.get());
        dropSelf(SeaBlocks.CHARTREUSE_SEA_GLASS_TILE_STAIRS.get());
        dropSelf(SeaBlocks.CHARTREUSE_SEA_GLASS_PEBBLES.get());
        dropSelf(SeaBlocks.CHARTREUSE_SEA_GLASS_BOTTLE.get());

        dropSelf(SeaBlocks.FISHING_NET.get());

        dropSelf(SeaBlocks.ORANGE_STARFISH.get());
        dropSelf(SeaBlocks.PINK_STARFISH.get());
        dropSelf(SeaBlocks.RED_STARFISH.get());
        dropSelf(SeaBlocks.CHOCOLATE_CHIP_STARFISH.get());
        dropSelf(SeaBlocks.BLUE_STARFISH.get());
        dropSelf(SeaBlocks.PURPLE_OCHRE_STARFISH.get());
        dropSelf(SeaBlocks.ROYAL_STARFISH.get());
        dropSelf(SeaBlocks.OCHRE_STARFISH.get());

        dropSelf(SeaBlocks.ALGAE_BLOCK.get());
        dropWhenSilkTouch(SeaBlocks.ALGAE_CARPET.get());
        dropWhenSilkTouch(SeaBlocks.ALGAE_PLANT.get());
        dropSelf(SeaBlocks.ALGAE_COBBLESTONE.get());
        dropSelf(SeaBlocks.ALGAE_COBBLESTONE_STAIRS.get());
        dropSelf(SeaBlocks.ALGAE_COBBLESTONE_SLAB.get());

        dropSelf(SeaBlocks.CLAM_SHELL.get());
        dropSelf(SeaBlocks.HORN_SHELL.get());
        dropSelf(SeaBlocks.SPIKY_SHELL.get());
        dropSelf(SeaBlocks.SPIRAL_SHELL.get());
        dropSelf(SeaBlocks.SWIRL_SHELL.get());
        dropSelf(SeaBlocks.PYRAMID_SHELL.get());

        dropSelf(SeaBlocks.OLD_BOARDS.get());

        dropSelf(SeaBlocks.BEACHGRASS.get());
        dropSelf(SeaBlocks.SEA_THRIFT.get());
        dropSelf(SeaBlocks.SEA_HOLLY.get());
        dropSelf(SeaBlocks.COASTAL_LAVENDER.get());
        dropSelf(SeaBlocks.COASTAL_WILDFLOWER.get());

        dropSelf(SeaBlocks.SALT_BLOCK.get());

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

        dropSelf(SeaBlocks.GRAVELLY_SAND.get());
        dropSelf(SeaBlocks.SPRINKLED_SAND.get());
        dropSelf(SeaBlocks.CORALINE_SAND.get());

        createMultipleDrops(SeaBlocks.SHELLY_SAND.get(), SeaBlocks.SPIRAL_SHELL.get().asItem(), SeaBlocks.SWIRL_SHELL.get().asItem());

        createPotFlowerItemTable(SeaBlocks.POTTED_COASTAL_LAVENDER.get(), SeaBlocks.COASTAL_LAVENDER.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_SEA_HOLLY.get(), SeaBlocks.SEA_HOLLY.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_SEA_THRIFT.get(), SeaBlocks.SEA_THRIFT.get());
        createPotFlowerItemTable(SeaBlocks.POTTED_COASTAL_WILDFLOWER.get(), SeaBlocks.COASTAL_WILDFLOWER.get());

        dropSelf(SeaBlocks.ALGAE_COBBLESTONE.get());
        dropSelf(SeaBlocks.ALGAE_COBBLESTONE_SLAB.get());
        dropSelf(SeaBlocks.ALGAE_COBBLESTONE_STAIRS.get());

        dropSelf(SeaBlocks.WAKAME.get());


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
