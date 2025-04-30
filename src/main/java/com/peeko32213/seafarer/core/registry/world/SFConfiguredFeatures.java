package com.peeko32213.seafarer.core.registry.world;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.blocks.SFBlocks;
import com.peeko32213.seafarer.core.registry.SFFeatures;
import com.peeko32213.seafarer.core.registry.SFTags;
import com.peeko32213.seafarer.core.registry.world.config.SFFeatureForms;
import com.peeko32213.seafarer.core.registry.world.config.TagBasedRandomFeatureConfig;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static com.peeko32213.seafarer.data.client.SFItemModelGenerator.prefix;

public class SFConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, SeaFarer.MODID);
    public static List<String> configuredFeatureList = new ArrayList<>();
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE_PATCH_PLANTS = registerKey("algae_patch_plants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE_PATCH_BONEMEAL = registerKey("algae_patch_bonemeal");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACHGRASS = registerKey("beachgrass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACHGRASS_FAN = registerKey("beachgrass_fan");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COASTAL_LAVENDER = registerKey("coastal_lavender");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COASTAL_WILDFLOWER = registerKey("coastal_wildflower");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_HOLLY = registerKey("sea_holly");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_THRIFT = registerKey("sea_thrift");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE_BOULDER = registerKey("algae_boulder");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_SHELLS = registerKey("sea_shells");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_GLASS = registerKey("sea_glass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_STARS = registerKey("sea_stars");

    public static final ResourceKey<ConfiguredFeature<?, ?>> JUMBLED_SHELLY_SAND_PATCH = registerKey("jumbled_shelly_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOATSOME = registerKey("floatsome");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCATTERED_SHELLY_SAND_PATCH = registerKey("scattered_shelly_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MIXED_SHELLY_SAND_PATCH = registerKey("mixed_shelly_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAVELY_SAND_PATCH = registerKey("gravely_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCKY_SAND_PATCH = registerKey("rocky_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SPRINKLED_SAND_PATCH = registerKey("red_sprinkled_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_SPRINKLED_SAND_PATCH = registerKey("purple_sprinkled_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_SPRINKLED_SAND_PATCH = registerKey("pink_sprinkled_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_SPRINKLED_SAND_PATCH = registerKey("blue_sprinkled_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_MIXED_SPRINKLED_SAND_PATCH = registerKey("blue_mixed_sprinkled_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MIXED_SPRINKLED_SAND_PATCH = registerKey("red_mixed_sprinkled_sand_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAND_TAG_PATCH = registerKey("sand_tag_patch");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {


        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, ALGAE_PATCH_PLANTS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(SFBlocks.ALGAE_PLANT.get().defaultBlockState(), 6).add(SFBlocks.ALGAE_CARPET.get().defaultBlockState(), 6))));

        final Holder<ConfiguredFeature<?, ?>> ALGAE_PATCH_PLANT = configuredFeatureGetter.getOrThrow(ALGAE_PATCH_PLANTS);

        register(context, ALGAE_PATCH_BONEMEAL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(SFBlocks.ALGAE_BLOCK.get()), PlacementUtils.inlinePlaced(ALGAE_PATCH_PLANT), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.4F, UniformInt.of(1, 2), 0.75F));
        register(context, BEACHGRASS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SFBlocks.BEACHGRASS.get().defaultBlockState()))));
        register(context, BEACHGRASS_FAN, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SFBlocks.BEACHGRASS_FAN.get().defaultBlockState()))));
        register(context, SEA_THRIFT, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SFBlocks.SEA_THRIFT.get().defaultBlockState()))));
        register(context, SEA_HOLLY, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SFBlocks.SEA_HOLLY.get().defaultBlockState()))));
        register(context, COASTAL_LAVENDER, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SFBlocks.COASTAL_LAVENDER.get().defaultBlockState()))));
        register(context, COASTAL_WILDFLOWER, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(SFBlocks.COASTAL_WILDFLOWER.get().defaultBlockState()))));
        register(context, ALGAE_BOULDER, SFFeatures.ALGAE_BOULDER.get(), new NoneFeatureConfiguration());

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
                                .add(SFBlocks.AZURE_SEA_GLASS_PEBBLES.get().defaultBlockState(), 20))),
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

        register(context, JUMBLED_SHELLY_SAND_PATCH, Feature.DISK, new DiskConfiguration(
               RuleBasedBlockStateProvider.simple(SFBlocks.JUMBLED_SHELLY_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));

        register(context, SCATTERED_SHELLY_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.SCATTERED_SHELLY_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, MIXED_SHELLY_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.MIXED_SHELLY_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, ROCKY_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.ROCKY_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, GRAVELY_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.GRAVELY_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));

        register(context, RED_SPRINKLED_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.RED_SPRINKLED_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, PURPLE_SPRINKLED_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.PURPLE_SPRINKLED_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, PINK_SPRINKLED_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.PINK_SPRINKLED_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, BLUE_SPRINKLED_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.BLUE_SPRINKLED_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, RED_MIXED_SPRINKLED_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.RED_MIXED_SPRINKLED_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, BLUE_MIXED_SPRINKLED_SAND_PATCH, Feature.DISK, new DiskConfiguration(
                RuleBasedBlockStateProvider.simple(SFBlocks.BLUE_MIXED_SPRINKLED_SAND.get()),
                BlockPredicate.matchesBlocks(List.of(Blocks.SAND)),
                UniformInt.of(2, 3), 1));


        register(context, FLOATSOME, Feature.RANDOM_PATCH,
                FeatureUtils.simpleRandomPatchConfiguration(1, PlacementUtils.filtered(SFFeatures.WATERLOGGABLE_BLOCK.get(),
                        new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                .add(SFBlocks.FLOATSOME.get().defaultBlockState(), 8))),
                        BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE)));


        register(context, SAND_TAG_PATCH, SFFeatures.TAG_FEATURE.get(), new TagBasedRandomFeatureConfig(
                SFTags.SPRINKLED_SAND,
                Optional.empty(),
                Optional.of(Blocks.SAND),
                Optional.of(new BlockPos(0,-1,0)),
                SFFeatureForms.PATCH_FEATURE_FORM));


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
