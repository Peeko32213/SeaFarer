package com.peeko32213.seafarer.core.registry.util;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.core.registry.SFFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class SFFeatureUtil {
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context)
    {
        SFFeatures.bootstrap(context);

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SeaFarer.MODID, name));
    }
}
