package com.peeko32213.seafarer.world;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

import static com.peeko32213.seafarer.datagen.ItemModelGenerator.prefix;

public class SPlacedFeatures {
    public static final ResourceKey<PlacedFeature> WOLFSBANE_PLACED = registerKey("wolfsbane_placed");
    public static final ResourceKey<PlacedFeature> GARLIC_PLACED = registerKey("garlic_placed");
    public static final ResourceKey<PlacedFeature> CHESTNUT_TREE_PLACED = registerKey("chestnut_tree_placed");
    public static final ResourceKey<PlacedFeature> TREE_MUSHROOM_PLACED = registerKey("tree_mushroom_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //register(context, WOLFSBANE_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.WOLFSBANE), ImmutableList.of(
        //        RarityFilter.onAverageOnceEvery(2),
        //        InSquarePlacement.spread(),
        //        PlacementUtils.FULL_RANGE,
        //        BiomeFilter.biome()
        //));
//
        //register(context, GARLIC_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.GARLIC), ImmutableList.of(
        //        RarityFilter.onAverageOnceEvery(2),
        //        InSquarePlacement.spread(),
        //        PlacementUtils.FULL_RANGE,
        //        BiomeFilter.biome()
        //));
//
        //register(context, CHESTNUT_TREE_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.CHESTNUT_TREE),
        //        VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.01F, 2),
        //                SBlocks.CHESTNUT_SAPLING.get())
        //        );
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, prefix( name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
