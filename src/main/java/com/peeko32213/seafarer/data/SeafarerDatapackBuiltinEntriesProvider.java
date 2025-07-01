package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.registry.SeafarerBiomeModifiers;
import com.peeko32213.seafarer.registry.SeafarerConfiguredFeatures;
import com.peeko32213.seafarer.registry.SeafarerPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SeafarerDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, SeafarerConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, SeafarerPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, SeafarerBiomeModifiers::bootstrap)
    ;

    public SeafarerDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(SeaFarer.MODID));
    }
}
