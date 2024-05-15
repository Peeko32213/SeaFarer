package com.peeko32213.seafarer.datagen.loot;


import com.peeko32213.seafarer.core.registry.SFBlocks;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.HashSet;
import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {
    private final Set<Block> knownBlocks = new HashSet<>();
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    public BlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void add(Block pBlock, LootTable.Builder pBuilder) {
        super.add(pBlock, pBuilder);
        knownBlocks.add(pBlock);
    }

    @Override
    protected void generate() {
        dropSelf(SFBlocks.BLUE_SEAGLASS_BLOCK.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_PANE.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_BRICKS.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_BRICKS_SLAB.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_PEBBLED.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_TILES.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_TILES_SLAB.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_TILES_STAIRS.get());
        dropSelf(SFBlocks.BLUE_SEAGLASS_PEBBLES.get());

        dropSelf(SFBlocks.BROWN_SEAGLASS_BLOCK.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_PANE.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_BRICKS.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_BRICKS_SLAB.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_PEBBLED.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_TILES.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_TILES_SLAB.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_TILES_STAIRS.get());
        dropSelf(SFBlocks.BROWN_SEAGLASS_PEBBLES.get());

        dropSelf(SFBlocks.GREEN_SEAGLASS_BLOCK.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_PANE.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_BRICKS.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_BRICKS_SLAB.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_PEBBLED.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_TILES.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_TILES_SLAB.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_TILES_STAIRS.get());
        dropSelf(SFBlocks.GREEN_SEAGLASS_PEBBLES.get());

        dropSelf(SFBlocks.ORANGE_SEAGLASS_BLOCK.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_PANE.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_BRICKS.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_BRICKS_SLAB.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_PEBBLED.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_TILES.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_TILES_SLAB.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_TILES_STAIRS.get());
        dropSelf(SFBlocks.ORANGE_SEAGLASS_PEBBLES.get());

        dropSelf(SFBlocks.PURPLE_SEAGLASS_BLOCK.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_PANE.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_BRICKS.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_BRICKS_SLAB.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_PEBBLED.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_TILES.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_TILES_SLAB.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_TILES_STAIRS.get());
        dropSelf(SFBlocks.PURPLE_SEAGLASS_PEBBLES.get());

        dropSelf(SFBlocks.RED_SEAGLASS_BLOCK.get());
        dropSelf(SFBlocks.RED_SEAGLASS_PANE.get());
        dropSelf(SFBlocks.RED_SEAGLASS_BRICKS.get());
        dropSelf(SFBlocks.RED_SEAGLASS_BRICKS_SLAB.get());
        dropSelf(SFBlocks.RED_SEAGLASS_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.RED_SEAGLASS_PEBBLED.get());
        dropSelf(SFBlocks.RED_SEAGLASS_TILES.get());
        dropSelf(SFBlocks.RED_SEAGLASS_TILES_SLAB.get());
        dropSelf(SFBlocks.RED_SEAGLASS_TILES_STAIRS.get());
        dropSelf(SFBlocks.RED_SEAGLASS_PEBBLES.get());

        dropSelf(SFBlocks.WHITE_SEAGLASS_BLOCK.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_PANE.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_BRICKS.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_BRICKS_SLAB.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_PEBBLED.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_TILES.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_TILES_SLAB.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_TILES_STAIRS.get());
        dropSelf(SFBlocks.WHITE_SEAGLASS_PEBBLES.get());

        dropSelf(SFBlocks.YELLOW_SEAGLASS_BLOCK.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_PANE.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_BRICKS.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_BRICKS_SLAB.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_PEBBLED.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_TILES.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_TILES_SLAB.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_TILES_STAIRS.get());
        dropSelf(SFBlocks.YELLOW_SEAGLASS_PEBBLES.get());

        dropSelf(SFBlocks.FISHING_NET.get());

        dropSelf(SFBlocks.STARFISH_COMMON_ORANGE.get());
        dropSelf(SFBlocks.STARFISH_PINK.get());
        dropSelf(SFBlocks.STARFISH_RED.get());
        dropSelf(SFBlocks.STARFISH_CHOCOLATE_CHIP.get());
        dropSelf(SFBlocks.STARFISH_BIG_BLUE.get());
        dropSelf(SFBlocks.STARFISH_BIG_PURPLE_OCHRE.get());
        dropSelf(SFBlocks.STARFISH_BIG_ROYAL.get());
        dropSelf(SFBlocks.STARFISH_BIG_OCHRE.get());

        dropSelf(SFBlocks.ALGAE_BLOCK.get());
        dropSelf(SFBlocks.ALGAE_CARPET.get());
        dropSelf(SFBlocks.ALGAE_PLANT.get());

        dropSelf(SFBlocks.CLAM_SHELL.get());
        dropSelf(SFBlocks.HORN_SHELL.get());
        dropSelf(SFBlocks.SPIKY_SHELL.get());
        dropSelf(SFBlocks.SPIRAL_SHELL.get());
        dropSelf(SFBlocks.SWIRL_SHELL.get());
        dropSelf(SFBlocks.PYRAMID_SHELL.get());

        dropSelf(SFBlocks.PLANK_BLOCK.get());

        dropSelf(SFBlocks.BEACHGRASS_FAN.get());
        dropSelf(SFBlocks.BEACHGRASS.get());
        dropSelf(SFBlocks.SEA_THRIFT.get());
        dropSelf(SFBlocks.SEA_HOLLY.get());

        dropSelf(SFBlocks.CLAM_SHELL_BRICKS.get());
        dropSelf(SFBlocks.CLAM_SHELL_PILLAR.get());
        dropSelf(SFBlocks.CLAM_SHELL_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.CLAM_SHELL_BRICKS_SLAB.get());

        dropSelf(SFBlocks.HORN_SHELL_BRICKS.get());
        dropSelf(SFBlocks.HORN_SHELL_PILLAR.get());
        dropSelf(SFBlocks.HORN_SHELL_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.HORN_SHELL_BRICKS_SLAB.get());

        dropSelf(SFBlocks.SPIKY_SHELL_BRICKS.get());
        dropSelf(SFBlocks.SPIKY_SHELL_PILLAR.get());
        dropSelf(SFBlocks.SPIKY_SHELL_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.SPIKY_SHELL_BRICKS_SLAB.get());

        dropSelf(SFBlocks.SPIRAL_SHELL_BRICKS.get());
        dropSelf(SFBlocks.SPIRAL_SHELL_PILLAR.get());
        dropSelf(SFBlocks.SPIRAL_SHELL_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.SPIRAL_SHELL_BRICKS_SLAB.get());

        dropSelf(SFBlocks.SWIRL_SHELL_BRICKS.get());
        dropSelf(SFBlocks.SWIRL_SHELL_PILLAR.get());
        dropSelf(SFBlocks.SWIRL_SHELL_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.SWIRL_SHELL_BRICKS_SLAB.get());

        dropSelf(SFBlocks.PYRAMID_SHELL_BRICKS.get());
        dropSelf(SFBlocks.PYRAMID_SHELL_PILLAR.get());
        dropSelf(SFBlocks.PYRAMID_SHELL_BRICKS_STAIRS.get());
        dropSelf(SFBlocks.PYRAMID_SHELL_BRICKS_SLAB.get());

        dropSelf(SFBlocks.GRAVELY_SAND.get());
        dropSelf(SFBlocks.ROCKY_SAND.get());
        dropSelf(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get());
        dropSelf(SFBlocks.RED_MIXED_SPRINKLED_SAND.get());
        dropSelf(SFBlocks.BLUE_SPRINKLED_SAND.get());
        dropSelf(SFBlocks.PINK_SPRINKLED_SAND.get());
        dropSelf(SFBlocks.PURPLE_SPRINKLED_SAND.get());
        dropSelf(SFBlocks.RED_SPRINKLED_SAND.get());

        //TODO
        // Mixed Shelly Sands need their own datagen, as they drop themselves when silk touched however normally will have a 50/50 shot of dropping a different shell
        // Mixed Shelly Sand = Spiral + Swirl
        // Scattered Shelly Sand = Clam + Horn
        // Scattered Shelly Sand = Pyramid + Spiky

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

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }
}
