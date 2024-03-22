package com.peeko32213.seafarer.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import static com.peeko32213.seafarer.datagen.ItemModelGenerator.prefix;

public class SBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_WOLFSBANE = registerKey("add_wolfsbane");
    public static final ResourceKey<BiomeModifier> ADD_GARLIC = registerKey("add_garlic");
    public static final ResourceKey<BiomeModifier> ADD_CHESTNUT_TREE = registerKey("add_chestnut_tree");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //context.register(ADD_WOLFSBANE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
        //        biomes.getOrThrow(BiomeTags.IS_TAIGA),
        //        HolderSet.direct(placedFeatures.getOrThrow(SPlacedFeatures.WOLFSBANE_PLACED)),
        //        GenerationStep.Decoration.VEGETAL_DECORATION));
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
