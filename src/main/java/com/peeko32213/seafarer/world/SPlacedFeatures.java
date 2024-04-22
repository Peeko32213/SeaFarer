package com.peeko32213.seafarer.world;

import com.google.common.collect.ImmutableList;
import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.peeko32213.seafarer.datagen.ItemModelGenerator.prefix;

public class SPlacedFeatures {
    public static List<String> placedFeatureList = new ArrayList<>();

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, SeaFarer.MODID);


    public static final ResourceKey<PlacedFeature> BEACHGRASS_PLACED = registerKey("beachgrass_placed");
    public static final ResourceKey<PlacedFeature> BEACHGRASS_FAN_PLACED = registerKey("beachgrass_fan_placed");
    public static final ResourceKey<PlacedFeature> SEA_HOLLY_PLACED = registerKey("sea_holly_placed");
    public static final ResourceKey<PlacedFeature> SEA_THRIFT_PLACED = registerKey("sea_thrift_placed");
    public static final ResourceKey<PlacedFeature> ALGAE_BOULDER_PLACED = registerKey("algae_boulder_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> beachgrass_placed = configuredFeatures.getOrThrow(SConfiguredFeatures.BEACHGRASS);
        Holder<ConfiguredFeature<?, ?>> beachgrass_fan_placed = configuredFeatures.getOrThrow(SConfiguredFeatures.BEACHGRASS_FAN);

        register(context, BEACHGRASS_PLACED, beachgrass_placed, worldSurfaceSquaredWithCount(15));
        register(context, BEACHGRASS_FAN_PLACED, beachgrass_fan_placed, worldSurfaceSquaredWithCount(15));


        register(context, SEA_HOLLY_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_HOLLY), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(15),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, SEA_THRIFT_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_THRIFT), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(15),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, ALGAE_BOULDER_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.ALGAE_BOULDER), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(3),
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

    public static List<PlacementModifier> worldSurfaceSquaredWithCount(int pCount) {
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, prefix( name));
    }

    private static RegistryObject<PlacedFeature> registerPlacedFeature(String name, Supplier<PlacedFeature> feature) {
        placedFeatureList.add(name);
        return PLACED_FEATURES.register(name, feature);
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
