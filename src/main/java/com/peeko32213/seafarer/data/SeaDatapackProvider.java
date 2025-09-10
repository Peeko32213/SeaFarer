package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.registry.worldgen.SeaBiomeModifierProvider;
import com.peeko32213.seafarer.registry.worldgen.SeaBiomes;
import com.peeko32213.seafarer.registry.worldgen.SeaConfiguredFeatures;
import com.peeko32213.seafarer.registry.worldgen.SeaPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SeaDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, SeaConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, SeaPlacedFeatures::bootstrap)
            .add(Registries.BIOME, SeaBiomes::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, SeaBiomeModifierProvider::bootstrap)
    ;

    public SeaDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(Seafarer.MOD_ID));
    }
}
