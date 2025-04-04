package com.peeko32213.seafarer.core.registry.world;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFEntities;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddSpawnsBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.RemoveFeaturesBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.RemoveSpawnsBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SFBiomeModifiers {

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        // Add features
        addFeature(context, "beachgrass", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.BEACHGRASS_PLACED);
        addFeature(context, "beachgrass_fan", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.BEACHGRASS_FAN_PLACED);
        addFeature(context, "sea_thrift", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.SEA_THRIFT_PLACED);
        addFeature(context, "sea_holly", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.SEA_HOLLY_PLACED);
        addFeature(context, "coastal_lavender", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.COASTAL_LAVENDER_PLACED);
        addFeature(context, "coastal_wildflower", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.COASTAL_WILDFLOWER_PLACED);
        addFeature(context, "land_sea_stars", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.SEA_STAR_LAND);
        addFeature(context, "land_sea_shells", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.SEA_SHELL_LAND);
        addFeature(context, "seaglass", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.SEA_GLASS);
        addFeature(context, "floatsome", SFTags.IS_SANDY_BEACH_BIOME, Decoration.VEGETAL_DECORATION, SFPlacedFeatures.FLOATSOME);
        addFeature(context, "algae_boulder", SFTags.IS_ALGAE_BOULDER_BIOME, Decoration.SURFACE_STRUCTURES, SFPlacedFeatures.ALGAE_BOULDER_PLACED);
        addFeature(context, "jumbled_shelly_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.JUMBLED_SHELLY_SAND_PATCH);
        addFeature(context, "scattered_shelly_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.SCATTERED_SHELLY_SAND_PATCH_PLACED);
        addFeature(context, "mixed_shelly_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.MIXED_SHELLY_SAND_PATCH_PLACED);
        addFeature(context, "gravely_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.GRAVELY_SAND_PATCH_PLACED);
        addFeature(context, "rocky_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.ROCKY_SAND_PATCH_PLACED);
        addFeature(context, "red_sprinkled_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.RED_SPRINKLED_SAND_PATCH_PLACED);
        addFeature(context, "purple_sprinkled_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.PURPLE_SPRINKLED_SAND_PATCH_PLACED);
        addFeature(context, "pink_sprinkled_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.PINK_SPRINKLED_SAND_PATCH_PLACED);
        addFeature(context, "blue_sprinkled_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.BLUE_SPRINKLED_SAND_PATCH_PLACED);
        addFeature(context, "blue_mixed_sprinkled_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.BLUE_MIXED_SPRINKLED_SAND_PATCH_PLACED);
        addFeature(context, "red_mixed_sprinkled_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.RED_MIXED_SPRINKLED_SAND_PATCH_PLACED);
        addFeature(context, "mixed_sand", SFTags.IS_SANDY_BEACH_BIOME, Decoration.UNDERGROUND_ORES, SFPlacedFeatures.SAND_TAG_PATCH_PLACED);

        // Remove features
        removeFeatureNoTag(context, "remove_coral", Biomes.WARM_OCEAN, Decoration.VEGETAL_DECORATION, AquaticPlacements.WARM_OCEAN_VEGETATION);

        // Add spawns
        addSpawn(context, "crab", SFTags.IS_CRAB_BIOME, new MobSpawnSettings.SpawnerData(SFEntities.CRAB.get(), 25, 1, 3));
        addSpawn(context, "horseshoe_crab", SFTags.IS_HORSECRAB_BIOME, new MobSpawnSettings.SpawnerData(SFEntities.HORSESHOE_CRAB.get(), 25, 1, 3));
        addSpawn(context, "marine_iguana", SFTags.IS_MARINE_IGUANA_BIOME, new MobSpawnSettings.SpawnerData(SFEntities.MARINE_IGUANA.get(), 20, 1, 2));
        addSpawn(context, "sunfish", SFTags.IS_SUNFISH_BIOME, new MobSpawnSettings.SpawnerData(SFEntities.SUNFISH.get(), 10, 1, 1));
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
        context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SeaFarer.MODID, name)), modifier.get());
    }

    @SafeVarargs
    private static HolderSet<PlacedFeature> featureSet(BootstapContext<?> context, ResourceKey<PlacedFeature>... features) {
        return HolderSet.direct(Stream.of(features).map(placedFeatureKey -> context.lookup(Registries.PLACED_FEATURE).getOrThrow(placedFeatureKey)).collect(Collectors.toList()));
    }
}