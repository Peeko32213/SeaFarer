package com.peeko32213.seafarer.datagen;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.world.SBiomeModifiers;
import com.peeko32213.seafarer.world.SConfiguredFeatures;
import com.peeko32213.seafarer.world.SPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, SConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, SPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, SBiomeModifiers::bootstrap);

    public WorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SeaFarer.MODID));
    }
}
