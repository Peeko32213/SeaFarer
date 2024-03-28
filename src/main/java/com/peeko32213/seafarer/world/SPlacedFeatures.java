package com.peeko32213.seafarer.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.peeko32213.seafarer.datagen.ItemModelGenerator.prefix;

public class SPlacedFeatures {
    public static final ResourceKey<PlacedFeature> BEACHGRASS_PLACED = registerKey("beachgrass_placed");

    public static final ResourceKey<PlacedFeature> BEACHGRASS_FAN_PLACED = registerKey("beachgrass_fan_placed");

    public static final ResourceKey<PlacedFeature> SEA_HOLLY_PLACED = registerKey("sea_holly");
    public static final ResourceKey<PlacedFeature> SEA_THRIFT_PLACED = registerKey("sea_thrift");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BEACHGRASS_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.BEACHGRASS), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
               PlacementUtils.FULL_RANGE,
               BiomeFilter.biome()
        ));

        register(context, BEACHGRASS_FAN_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.BEACHGRASS_FAN), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, SEA_HOLLY_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_HOLLY), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, SEA_THRIFT_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_THRIFT), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));
//
        //register(context, GARLIC_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.GARLIC), ImmutableList.of(
        //        RarityFilter.onAverageOnceEvery(2),
        //        InSquarePlacement.spread(),
        //        PlacementUtils.FULL_RANGE,
        //        BiomeFilter.biome()
        //));
//

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, prefix( name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
