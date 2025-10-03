package com.peeko32213.seafarer.registry.worldgen;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.blocks.TallBeachPlantBlock;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import com.peeko32213.seafarer.registry.SeafarerFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class SeafarerConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> GORGONIANS = createKey("gorgonians");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STARFISH = createKey("starfish");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACH_FLOWERS = createKey("beach_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACHGRASS = createKey("beachgrass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASSY_BEACHGRASS = createKey("grassy_beachgrass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_BEACHGRASS = createKey("tall_beachgrass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_GLASS_SAND = createKey("sea_glass_sand");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(GORGONIANS, new ConfiguredFeature<>(SeafarerFeatures.GORGONIAN.get(), NoneFeatureConfiguration.NONE));
        context.register(STARFISH, new ConfiguredFeature<>(SeafarerFeatures.STARFISH.get(), NoneFeatureConfiguration.NONE));
        context.register(BEACH_FLOWERS, new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.createPlantPatch(64, Configs.createBeachFlowers())));
        context.register(BEACHGRASS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, Configs.createPlantPatch(32, Configs.createBeachgrass())));
        context.register(GRASSY_BEACHGRASS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 5, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, Configs.createBeachgrassTall()))));
        context.register(TALL_BEACHGRASS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 4, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SeafarerBlocks.TALL_BEACHGRASS.get()))))));

    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    private static class Configs {

        public static SimpleBlockConfiguration createBeachFlowers() {
            return new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(SeafarerBlocks.SEA_HOLLY.get().defaultBlockState(), 40)
                    .add(SeafarerBlocks.SEA_THRIFT.get().defaultBlockState(), 40)
                    .add(SeafarerBlocks.COASTAL_LAVENDER.get().defaultBlockState(), 30)
                    .add(SeafarerBlocks.COASTAL_WILDFLOWER.get().defaultBlockState(), 30))
            );
        }

        public static SimpleBlockConfiguration createBeachgrass() {
            return new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(SeafarerBlocks.BEACHGRASS.get().defaultBlockState(), 40)
                    .add(SeafarerBlocks.SHORT_BEACHGRASS.get().defaultBlockState(), 30))
            );
        }

        public static SimpleBlockConfiguration createBeachgrassTall() {
            return new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(SeafarerBlocks.BEACHGRASS.get().defaultBlockState(), 40)
                    .add(SeafarerBlocks.SHORT_BEACHGRASS.get().defaultBlockState(), 30)
                    .add(SeafarerBlocks.TALL_BEACHGRASS.get().defaultBlockState().setValue(TallBeachPlantBlock.HALF, DoubleBlockHalf.LOWER), 5))
            );
        }

        public static RandomPatchConfiguration createPlantPatch(int tries, BlockState state) {
            return createPlantPatch(tries, new SimpleBlockConfiguration(BlockStateProvider.simple(state)));
        }

        public static RandomPatchConfiguration createPlantPatch(int tries, SimpleBlockConfiguration config) {
            return new RandomPatchConfiguration(tries, 5, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, config));
        }
    }
}
