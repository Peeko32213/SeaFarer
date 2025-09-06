package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.Nullable;

public class SeaBiomeProvider {

    public static final ResourceKey<Biome> WARM_REEF = createKey("warm_reef");
    public static final ResourceKey<Biome> FLOWERING_BEACH = createKey("flowering_beach");
    public static final ResourceKey<Biome> GRASSY_BEACH = createKey("grassy_beach");
    public static final ResourceKey<Biome> CORAL_BEACH = createKey("coral_beach");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> features = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(WARM_REEF, warmReef(features, carvers));
        context.register(FLOWERING_BEACH, floweringBeach(features, carvers));
        context.register(GRASSY_BEACH, grassyBeach(features, carvers));
        context.register(CORAL_BEACH, coralBeach(features, carvers));
    }

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(Seafarer.MOD_ID, name));
    }

    private static Biome warmReef(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(features, carvers);
        SeaBiomeGeneration.warmReef(generation);

        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.warmOceanSpawns(spawns, 10, 4);
        spawns.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 15, 1, 3));
        return biome(true, 0.5F, 0.5F, 4445678, 270131, spawns, generation, null);
    }

    private static Biome floweringBeach(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(features, carvers);
        SeaBiomeGeneration.floweringBeach(generation);

        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 5, 2, 5));
        return biome(true, 0.8F, 0.4F, 4159204, 329011, spawns, generation, null);
    }

    private static Biome grassyBeach(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(features, carvers);
        SeaBiomeGeneration.grassyBeach(generation);

        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 5, 2, 5));
        return biome(true, 0.8F, 0.4F, 4159204, 329011, spawns, generation, null);
    }

    private static Biome coralBeach(HolderGetter<PlacedFeature> features, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder(features, carvers);
        SeaBiomeGeneration.coralBeach(generation);

        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 5, 2, 5));
        return biome(true, 0.8F, 0.4F, 4159204, 329011, spawns, generation, null);
    }

    private static Biome biome(boolean precipitation, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawns, BiomeGenerationSettings.Builder generation, @Nullable Music music) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(precipitation)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects((new BiomeSpecialEffects.Builder())
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .fogColor(12638463)
                .skyColor(calculateSkyColor(temperature))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(music).build())
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build()).build();
    }

    private static int calculateSkyColor(float temperature) {
        float clampedTemp = Mth.clamp(temperature / 3.0F, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - clampedTemp * 0.05F, 0.5F + clampedTemp * 0.1F, 1.0F);
    }
}
