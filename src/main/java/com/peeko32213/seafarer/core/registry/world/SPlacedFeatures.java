package com.peeko32213.seafarer.core.registry.world;

import com.google.common.collect.ImmutableList;
import com.peeko32213.seafarer.SeaFarer;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.peeko32213.seafarer.data.client.ItemModelGenerator.prefix;

public class SPlacedFeatures {
    public static List<String> placedFeatureList = new ArrayList<>();

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, SeaFarer.MODID);


    public static final ResourceKey<PlacedFeature> BEACHGRASS_PLACED = registerKey("beachgrass_placed");
    public static final ResourceKey<PlacedFeature> BEACHGRASS_FAN_PLACED = registerKey("beachgrass_fan_placed");
    public static final ResourceKey<PlacedFeature> SEA_HOLLY_PLACED = registerKey("sea_holly_placed");
    public static final ResourceKey<PlacedFeature> SEA_THRIFT_PLACED = registerKey("sea_thrift_placed");
    public static final ResourceKey<PlacedFeature> COASTAL_LAVENDER_PLACED = registerKey("coastal_lavender_placed");
    public static final ResourceKey<PlacedFeature> COASTAL_WILDFLOWER_PLACED = registerKey("coastal_wildflower_placed");
    public static final ResourceKey<PlacedFeature> ALGAE_BOULDER_PLACED = registerKey("algae_boulder_placed");
    public static final ResourceKey<PlacedFeature> SEA_SHELL_LAND = registerKey("sea_shell_land");
    public static final ResourceKey<PlacedFeature> SEA_SHELL_WATER = registerKey("sea_shell_water");
    public static final ResourceKey<PlacedFeature> SEA_GLASS = registerKey("sea_glass");
    public static final ResourceKey<PlacedFeature> SEA_STAR_LAND = registerKey("sea_star_land");
    public static final ResourceKey<PlacedFeature> SEA_STAR_WATER = registerKey("sea_star_water");
    public static final ResourceKey<PlacedFeature> JUMBLED_SHELLY_SAND_PATCH = registerKey("jumbled_shelly_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> FLOATSOME = registerKey("floatsome");
    public static final ResourceKey<PlacedFeature> SCATTERED_SHELLY_SAND_PATCH_PLACED = registerKey("scattered_shelly_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> MIXED_SHELLY_SAND_PATCH_PLACED = registerKey("mixed_shelly_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> GRAVELY_SAND_PATCH_PLACED = registerKey("gravely_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> ROCKY_SAND_PATCH_PLACED = registerKey("rocky_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> RED_SPRINKLED_SAND_PATCH_PLACED = registerKey("red_sprinkled_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> PURPLE_SPRINKLED_SAND_PATCH_PLACED = registerKey("purple_sprinkled_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> PINK_SPRINKLED_SAND_PATCH_PLACED = registerKey("pink_sprinkled_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> BLUE_SPRINKLED_SAND_PATCH_PLACED = registerKey("blue_sprinkled_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> BLUE_MIXED_SPRINKLED_SAND_PATCH_PLACED = registerKey("blue_mixed_sprinkled_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> RED_MIXED_SPRINKLED_SAND_PATCH_PLACED = registerKey("red_mixed_sprinkled_sand_patch_placed");
    public static final ResourceKey<PlacedFeature> SAND_TAG_PATCH_PLACED = registerKey("sand_tag_patch_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, BEACHGRASS_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.BEACHGRASS), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(16),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, BEACHGRASS_FAN_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.BEACHGRASS_FAN), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(16),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, SEA_HOLLY_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_HOLLY), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(6),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, SEA_THRIFT_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_THRIFT), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(6),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, COASTAL_LAVENDER_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.COASTAL_LAVENDER), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(6),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, COASTAL_WILDFLOWER_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.COASTAL_WILDFLOWER), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(1),
                InSquarePlacement.spread(),
                CountPlacement.of(6),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, ALGAE_BOULDER_PLACED, configuredFeatures.getOrThrow(SConfiguredFeatures.ALGAE_BOULDER), ImmutableList.of(
                RarityFilter.onAverageOnceEvery(8),
                InSquarePlacement.spread(),
                CountPlacement.of(1),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome()
        ));

        register(context, SEA_SHELL_LAND,  configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_SHELLS),
                VegetationPlacements.worldSurfaceSquaredWithCount(2));

      // register(context, SEA_SHELL_WATER,  configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_SHELLS),
       //         CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());

        register(context, SEA_GLASS,  configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_GLASS),
                VegetationPlacements.worldSurfaceSquaredWithCount(2));

        register(context, SEA_STAR_LAND,  configuredFeatures.getOrThrow(SConfiguredFeatures.SEA_STARS),
                VegetationPlacements.worldSurfaceSquaredWithCount(1));

        register(context, JUMBLED_SHELLY_SAND_PATCH,  configuredFeatures.getOrThrow(SConfiguredFeatures.JUMBLED_SHELLY_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                        ));
        register(context, SCATTERED_SHELLY_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.SCATTERED_SHELLY_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));
        register(context, MIXED_SHELLY_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.MIXED_SHELLY_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));
        register(context, GRAVELY_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.GRAVELY_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));
        register(context, ROCKY_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.ROCKY_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));
        register(context, RED_SPRINKLED_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.RED_SPRINKLED_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));
        register(context, PURPLE_SPRINKLED_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.PURPLE_SPRINKLED_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));
        register(context, PINK_SPRINKLED_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.PINK_SPRINKLED_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                        ));
        register(context, BLUE_SPRINKLED_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.BLUE_SPRINKLED_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));
        register(context, BLUE_MIXED_SPRINKLED_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.BLUE_MIXED_SPRINKLED_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));

        register(context, RED_MIXED_SPRINKLED_SAND_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.RED_MIXED_SPRINKLED_SAND_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(300),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.SAND)))
                ));


        register(context, SAND_TAG_PATCH_PLACED,  configuredFeatures.getOrThrow(SConfiguredFeatures.SAND_TAG_PATCH),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(1),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ));


        register(context, FLOATSOME,  configuredFeatures.getOrThrow(SConfiguredFeatures.FLOATSOME),
                VegetationPlacements.worldSurfaceSquaredWithCount(1));

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
