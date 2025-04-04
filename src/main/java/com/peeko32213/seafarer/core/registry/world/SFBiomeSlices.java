package com.peeko32213.seafarer.core.registry.world;

import com.mojang.datafixers.util.Pair;
import com.peeko32213.seafarer.SeaFarer;
import com.teamabnormals.blueprint.common.world.modification.ModdedBiomeSlice;
import com.teamabnormals.blueprint.core.registry.BlueprintDataPackRegistries;
import com.teamabnormals.blueprint.core.util.BiomeUtil.OverlayModdedBiomeProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.LevelStem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SFBiomeSlices {
    public static final ResourceKey<ModdedBiomeSlice> WARM_REEF = createKey("warm_reef");

    public static void bootstrap(BootstapContext<ModdedBiomeSlice> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        context.register(WARM_REEF, new ModdedBiomeSlice(40, new OverlayModdedBiomeProvider(List.of(Pair.of(HolderSet.direct(Stream.of(Biomes.WARM_OCEAN).map(biomes::getOrThrow).collect(Collectors.toList())), new FixedBiomeSource(Holder.direct(biomes.getOrThrow(SFBiomes.WARM_REEF)).get())))), LevelStem.OVERWORLD));
    }

    public static ResourceKey<ModdedBiomeSlice> createKey(String name) {
        return ResourceKey.create(BlueprintDataPackRegistries.MODDED_BIOME_SLICES, new ResourceLocation(SeaFarer.MODID, name));
    }
}
