package com.peeko32213.seafarer.world;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.world.feature.AlgaeBoulderFeature;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.peeko32213.seafarer.datagen.ItemModelGenerator.prefix;

public class SConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, SeaFarer.MODID);
    public static List<String> configuredFeatureList = new ArrayList<>();
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE_PATCH_PLANTS = registerKey("algae_patch_plants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE_PATCH_BONEMEAL = registerKey("algae_patch_bonemeal");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACHGRASS = registerKey("beachgrass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACHGRASS_FAN = registerKey("beachgrass_fan");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_HOLLY = registerKey("sea_holly");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_THRIFT = registerKey("sea_thrift");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE_BOULDER = registerKey("algae_boulder");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_SHELLS = registerKey("sea_shells");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_GLASS = registerKey("sea_glass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_STARS = registerKey("sea_stars");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {


        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ALGAE_PATCH_PLANTS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(SFBlocks.ALGAE_PLANT.get().defaultBlockState(), 6).add(SFBlocks.ALGAE_CARPET.get().defaultBlockState(), 6))));

        final Holder<ConfiguredFeature<?, ?>> ALGAE_PATCH_PLANT = configuredFeatureGetter.getOrThrow(ALGAE_PATCH_PLANTS);

        register(context, ALGAE_PATCH_BONEMEAL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(SFBlocks.ALGAE_BLOCK.get()), PlacementUtils.inlinePlaced(ALGAE_PATCH_PLANT), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.4F, UniformInt.of(1, 2), 0.75F));


        FeatureUtils.register(context, BEACHGRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(SFBlocks.BEACHGRASS.get().defaultBlockState()), 16));


        FeatureUtils.register(context, BEACHGRASS_FAN, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(SFBlocks.BEACHGRASS_FAN.get().defaultBlockState()), 16));


        register(context, SEA_THRIFT, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SFBlocks.SEA_THRIFT.get().defaultBlockState()))));


        register(context, SEA_HOLLY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SFBlocks.SEA_HOLLY.get().defaultBlockState()))));

        register(context, ALGAE_BOULDER, Feature.FOREST_ROCK,
                new BlockStateConfiguration(SFBlocks.ALGAE_BLOCK.get().defaultBlockState()));

        register(context, SEA_SHELLS, Feature.RANDOM_PATCH,
                FeatureUtils.simpleRandomPatchConfiguration(2, PlacementUtils.filtered(SFFeatures.WATERLOGGABLE_BLOCK.get(),
                        new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(SFBlocks.CLAM_SHELL.get().defaultBlockState(), 20)
                                .add(SFBlocks.SPIKY_SHELL.get().defaultBlockState(), 20)
                                .add(SFBlocks.SPIRAL_SHELL.get().defaultBlockState(), 15)
                                .add(SFBlocks.SWIRL_SHELL.get().defaultBlockState(), 15)
                                .add(SFBlocks.PYRAMID_SHELL.get().defaultBlockState(), 8))), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE)));

        register(context, SEA_GLASS, Feature.RANDOM_PATCH,
                FeatureUtils.simpleRandomPatchConfiguration(4, PlacementUtils.filtered(SFFeatures.WATERLOGGABLE_BLOCK.get(),
                        new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(SFBlocks.WHITE_SEAGLASS_PEBBLES.get().defaultBlockState(), 20)
                                .add(SFBlocks.YELLOW_SEAGLASS_PEBBLES.get().defaultBlockState(), 20)
                                .add(SFBlocks.RED_SEAGLASS_PEBBLES.get().defaultBlockState(), 20)
                                .add(SFBlocks.PURPLE_SEAGLASS_PEBBLES.get().defaultBlockState(), 20)
                                .add(SFBlocks.ORANGE_SEAGLASS_PEBBLES.get().defaultBlockState(), 20)
                                .add(SFBlocks.GREEN_SEAGLASS_PEBBLES.get().defaultBlockState(), 20)
                                .add(SFBlocks.BROWN_SEAGLASS_PEBBLES.get().defaultBlockState(), 20)
                                .add(SFBlocks.BLUE_SEAGLASS_PEBBLES.get().defaultBlockState(), 20))),
                        BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE)));

        register(context, SEA_STARS, Feature.RANDOM_PATCH,
                FeatureUtils.simpleRandomPatchConfiguration(1, PlacementUtils.filtered(SFFeatures.WATERLOGGABLE_BLOCK.get(),
                        new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(SFBlocks.STARFISH_RED.get().defaultBlockState(), 15)
                                .add(SFBlocks.STARFISH_PINK.get().defaultBlockState(), 15)
                                .add(SFBlocks.STARFISH_COMMON_ORANGE.get().defaultBlockState(), 20)
                                .add(SFBlocks.STARFISH_CHOCOLATE_CHIP.get().defaultBlockState(), 5)
                                .add(SFBlocks.STARFISH_BIG_BLUE.get().defaultBlockState(), 20)
                                .add(SFBlocks.STARFISH_BIG_OCHRE.get().defaultBlockState(), 15)
                                .add(SFBlocks.STARFISH_BIG_PURPLE_OCHRE.get().defaultBlockState(), 10)
                                .add(SFBlocks.STARFISH_BIG_ROYAL.get().defaultBlockState(), 5))),
                        BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE)));


    }

    public static RegistryObject<ConfiguredFeature<?, ?>> registerConfiguredFeature(String name, Supplier<ConfiguredFeature<?, ?>> feature) {
        configuredFeatureList.add(name);
        return CONFIGURED_FEATURES.register(name, feature);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, prefix(name));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int pTries) {
        return FeatureUtils.simpleRandomPatchConfiguration(pTries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
