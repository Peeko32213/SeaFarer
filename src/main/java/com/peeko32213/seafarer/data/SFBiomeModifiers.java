package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddSpawnsBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.RemoveFeaturesBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SFBiomeModifiers {

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        // Add features
//        addFeature(context, "beachgrass", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.BEACHGRASS_PLACED);
//        addFeature(context, "beachgrass_fan", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.BEACHGRASS_FAN_PLACED);
//        addFeature(context, "sea_thrift", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.SEA_THRIFT_PLACED);
//        addFeature(context, "sea_holly", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.SEA_HOLLY_PLACED);
//        addFeature(context, "coastal_lavender", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.COASTAL_LAVENDER_PLACED);
//        addFeature(context, "coastal_wildflower", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.COASTAL_WILDFLOWER_PLACED);
//        addFeature(context, "land_sea_stars", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.SEA_STAR_LAND);
//        addFeature(context, "land_sea_shells", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.SEA_SHELL_LAND);
//        addFeature(context, "seaglass", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.SEA_GLASS);
//        addFeature(context, "floatsome", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SeafarerPlacedFeatures.FLOATSOME);
//        addFeature(context, "algae_boulder", SeafarerTags.IS_ALGAE_BOULDER_BIOME, Decoration.SURFACE_STRUCTURES, SeafarerPlacedFeatures.ALGAE_BOULDER_PLACED);
//        addFeature(context, "jumbled_shelly_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.JUMBLED_SHELLY_SAND_PATCH);
//        addFeature(context, "scattered_shelly_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.SCATTERED_SHELLY_SAND_PATCH_PLACED);
//        addFeature(context, "mixed_shelly_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.MIXED_SHELLY_SAND_PATCH_PLACED);
//        addFeature(context, "gravely_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.GRAVELY_SAND_PATCH_PLACED);
//        addFeature(context, "rocky_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.ROCKY_SAND_PATCH_PLACED);
//        addFeature(context, "red_sprinkled_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.RED_SPRINKLED_SAND_PATCH_PLACED);
//        addFeature(context, "purple_sprinkled_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.PURPLE_SPRINKLED_SAND_PATCH_PLACED);
//        addFeature(context, "pink_sprinkled_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.PINK_SPRINKLED_SAND_PATCH_PLACED);
//        addFeature(context, "blue_sprinkled_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.BLUE_SPRINKLED_SAND_PATCH_PLACED);
//        addFeature(context, "blue_mixed_sprinkled_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.BLUE_MIXED_SPRINKLED_SAND_PATCH_PLACED);
//        addFeature(context, "red_mixed_sprinkled_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.RED_MIXED_SPRINKLED_SAND_PATCH_PLACED);
//        addFeature(context, "mixed_sand", SeafarerTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SeafarerPlacedFeatures.SAND_TAG_PATCH_PLACED);

        // Add spawns
//        addSpawn(context, "crab", SeafarerTags.IS_CRAB_BIOME, new MobSpawnSettings.SpawnerData(SeafarerEntities.SHORE_CRAB.get(), 25, 1, 3));
//        addSpawn(context, "horseshoe_crab", SeafarerTags.IS_HORSECRAB_BIOME, new MobSpawnSettings.SpawnerData(SeafarerEntities.HORSESHOE_CRAB.get(), 25, 1, 3));
//        addSpawn(context, "marine_iguana", SeafarerTags.IS_MARINE_IGUANA_BIOME, new MobSpawnSettings.SpawnerData(SeafarerEntities.MARINE_IGUANA.get(), 20, 1, 2));
//        addSpawn(context, "sunfish", SeafarerTags.IS_SUNFISH_BIOME, new MobSpawnSettings.SpawnerData(SeafarerEntities.SUNFISH.get(), 10, 1, 1));
    }

    @SafeVarargs
    private static void removeFeature(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "remove_feature/" + name, () -> new RemoveFeaturesBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomes), featureSet(context, features), Set.of(step)));
    }

    @SafeVarargs
    private static void removeFeatureNoTag(BootstapContext<BiomeModifier> context, String name, ResourceKey<Biome> biome, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "remove_feature/" + name, () -> new RemoveFeaturesBiomeModifier(HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(biome)), featureSet(context, features), Set.of(step)));
    }

    @SafeVarargs
    private static void addFeature(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "add_feature/" + name, () -> new AddFeaturesBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomes), featureSet(context, features), step));
    }

    @SafeVarargs
    private static void addFeatureNoTag(BootstapContext<BiomeModifier> context, String name, ResourceKey<Biome> biome, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "add_feature/" + name, () -> new AddFeaturesBiomeModifier(HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(biome)), featureSet(context, features), step));
    }

    private static void addSpawn(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, MobSpawnSettings.SpawnerData... spawns) {
        register(context, "add_spawn/" + name, () -> new AddSpawnsBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomes), List.of(spawns)));
    }

    private static void register(BootstapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
        context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Seafarer.MOD_ID, name)), modifier.get());
    }

    @SafeVarargs
    private static HolderSet<PlacedFeature> featureSet(BootstapContext<?> context, ResourceKey<PlacedFeature>... features) {
        return HolderSet.direct(Stream.of(features).map(placedFeatureKey -> context.lookup(Registries.PLACED_FEATURE).getOrThrow(placedFeatureKey)).collect(Collectors.toList()));
    }
}