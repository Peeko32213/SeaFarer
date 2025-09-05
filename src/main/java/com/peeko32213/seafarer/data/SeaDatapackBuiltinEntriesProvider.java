package com.peeko32213.seafarer.data;

import com.peeko32213.seafarer.Seafarer;
import com.teamabnormals.blueprint.core.registry.BlueprintDataPackRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SeaDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, SeaConfiguredFeatureProvider::bootstrap)
            .add(Registries.PLACED_FEATURE, SeaPlacedFeatureProvider::bootstrap)
            .add(Registries.BIOME, SeaBiomeProvider::bootstrap)
            .add(BlueprintDataPackRegistries.MODDED_BIOME_SLICES, SeaBiomeSliceProvider::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, SeaBiomeModifierProvider::bootstrap)
    ;

    public SeaDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of(Seafarer.MOD_ID));
    }
}
