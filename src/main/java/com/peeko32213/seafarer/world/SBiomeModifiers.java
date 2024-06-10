package com.peeko32213.seafarer.world;

import com.peeko32213.seafarer.core.registry.SFEntities;
import com.peeko32213.seafarer.core.registry.SFTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

import static com.peeko32213.seafarer.datagen.ItemModelGenerator.prefix;

public class SBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_BEACHGRASS = registerKey("add_beachgrass");
    public static final ResourceKey<BiomeModifier> ADD_SEA_THRIFT = registerKey("add_sea_thrift");
    public static final ResourceKey<BiomeModifier> ADD_SEA_HOLLY = registerKey("add_sea_holly");
    public static final ResourceKey<BiomeModifier> ADD_COASTAL_LAVENDER = registerKey("add_coastal_lavender");
    public static final ResourceKey<BiomeModifier> ADD_COASTAL_WILDFLOWER = registerKey("add_coastal_wildflower");
    public static final ResourceKey<BiomeModifier> ADD_ALGAE_BOULDER = registerKey("add_algae_boulder");

    public static final ResourceKey<BiomeModifier> ADD_CRAB = registerKey("add_crab");
    public static final ResourceKey<BiomeModifier> ADD_HORSESHOE_CRAB = registerKey("add_horseshoe_crab");
    public static final ResourceKey<BiomeModifier> ADD_MARINE_IGUANA = registerKey("add_marine_iguana");
    public static final ResourceKey<BiomeModifier> ADD_SUNFISH = registerKey("add_sunfish");
    private static final ResourceKey<BiomeModifier> ADD_LAND_SEA_SHELLS = registerKey("add_land_sea_shells");
    private static final ResourceKey<BiomeModifier> ADD_WATER_SEA_SHELLS = registerKey("add_water_sea_shells");
    private static final ResourceKey<BiomeModifier> ADD_SEAGLASS = registerKey("add_seaglass");
    private static final ResourceKey<BiomeModifier> ADD_LAND_SEASTAR = registerKey("add_land_seastar");
    private static final ResourceKey<BiomeModifier> ADD_WATER_SEASTAR = registerKey("add_water_seastar");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_BEACHGRASS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.BEACHGRASS_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SEA_THRIFT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.SEA_THRIFT_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SEA_HOLLY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.SEA_HOLLY_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_COASTAL_LAVENDER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.COASTAL_LAVENDER_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_COASTAL_WILDFLOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.COASTAL_WILDFLOWER_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_ALGAE_BOULDER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.ALGAE_BOULDER_PLACED)),
                GenerationStep.Decoration.SURFACE_STRUCTURES));

        context.register(ADD_LAND_SEA_SHELLS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.SEA_SHELL_LAND)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SEAGLASS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.SEA_GLASS)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_LAND_SEASTAR, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(SFTags.IS_BEACH_BIOME),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.SEA_STAR_LAND)),
                GenerationStep.Decoration.VEGETAL_DECORATION));


        //  context.register(ADD_WATER_SEA_SHELLS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
      //          biomes.getOrThrow(BiomeTags.IS_OCEAN),
       //         HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.ALGAE_BOULDER_PLACED)),
       //         GenerationStep.Decoration.VEGETAL_DECORATION));
//
        //context.register(ADD_GARLIC, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //        biomes.getOrThrow(STags.IS_GARLIC_BIOME),
        //        HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.GARLIC_PLACED)),
        //        GenerationStep.Decoration.VEGETAL_DECORATION));
//
        //context.register(ADD_CHESTNUT_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
        //        HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.CHESTNUT_TREE_PLACED)),
        //        GenerationStep.Decoration.VEGETAL_DECORATION));

        // Mob Spawns

        MobSpawnSettings.SpawnerData crab = new MobSpawnSettings.SpawnerData(SFEntities.CRAB.get(), 25,1, 3);
        context.register(ADD_CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(SFTags.IS_CRAB_BIOME),
                List.of(crab)));

        MobSpawnSettings.SpawnerData horseshoe_crab = new MobSpawnSettings.SpawnerData(SFEntities.HORSESHOE_CRAB.get(), 25,1, 3);
        context.register(ADD_HORSESHOE_CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(SFTags.IS_HORSECRAB_BIOME),
                List.of(horseshoe_crab)));

        MobSpawnSettings.SpawnerData marine_iguana = new MobSpawnSettings.SpawnerData(SFEntities.MARINE_IGUANA.get(), 25,1, 3);
        context.register(ADD_MARINE_IGUANA, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(SFTags.IS_MARINE_IGUANA_BIOME),
                List.of(marine_iguana)));

        MobSpawnSettings.SpawnerData sunfish = new MobSpawnSettings.SpawnerData(SFEntities.SUNFISH.get(), 25,1, 2);
        context.register(ADD_SUNFISH, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(SFTags.IS_SUNFISH_BIOME),
                List.of(sunfish)));


    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, prefix( name));
    }
}
