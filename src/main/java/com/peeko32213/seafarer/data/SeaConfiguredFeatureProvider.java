package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.SeaFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class SeaConfiguredFeatureProvider {

    public static final ResourceKey<ConfiguredFeature<?, ?>> GORGONIANS = createKey("gorgonians");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STARFISH = createKey("starfish");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACH_FLOWERS = createKey("beach_flowers");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(GORGONIANS, new ConfiguredFeature<>(SeaFeatures.GORGONIAN.get(), NoneFeatureConfiguration.NONE));
        context.register(STARFISH, new ConfiguredFeature<>(SeaFeatures.STARFISH.get(), NoneFeatureConfiguration.NONE));
        context.register(BEACH_FLOWERS, new ConfiguredFeature<>(SeaFeatures.BEACH_FLOWERS.get(), NoneFeatureConfiguration.NONE));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    private static class Configs {
        public static RandomPatchConfiguration createPlantPatch(int tries, BlockState state) {
            return createPlantPatch(tries, new SimpleBlockConfiguration(BlockStateProvider.simple(state)));
        }

        public static RandomPatchConfiguration createPlantPatch(int tries, SimpleBlockConfiguration config) {
            return new RandomPatchConfiguration(tries, 5, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, config));
        }
    }
}
