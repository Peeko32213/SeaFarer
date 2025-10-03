package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.worldgen.SeafarerBiomeModifierProvider;
import com.peeko32213.seafarer.registry.worldgen.SeafarerBiomes;
import com.peeko32213.seafarer.registry.worldgen.SeafarerConfiguredFeatures;
import com.peeko32213.seafarer.registry.worldgen.SeaPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SeafarerDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, SeafarerConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, SeaPlacedFeatures::bootstrap)
            .add(Registries.BIOME, SeafarerBiomes::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, SeafarerBiomeModifierProvider::bootstrap)
    ;

    public SeafarerDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(Seafarer.MOD_ID));
    }
}
