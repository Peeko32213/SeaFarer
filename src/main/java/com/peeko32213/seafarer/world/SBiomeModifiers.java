package com.peeko32213.seafarer.world;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import static com.peeko32213.seafarer.datagen.ItemModelGenerator.prefix;

public class SBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_BEACHGRASS = registerKey("add_beachgrass");
    public static final ResourceKey<BiomeModifier> ADD_SEA_THRIFT = registerKey("add_sea_thrift");
    public static final ResourceKey<BiomeModifier> ADD_SEA_HOLLY = registerKey("add_sea_holly");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_BEACHGRASS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BEACH),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.BEACHGRASS_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SEA_THRIFT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BEACH),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.SEA_THRIFT_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SEA_HOLLY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BEACH),
                HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.SEA_HOLLY_PLACED)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
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
    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, prefix( name));
    }
}
