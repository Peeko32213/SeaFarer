package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.world.feature.AlgaeBoulderFeature;
import com.peeko32213.seafarer.common.world.feature.WaterloggableBlockFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SeaFarer.MODID);

    public static final RegistryObject<Feature<SimpleBlockConfiguration>> WATERLOGGABLE_BLOCK = FEATURES.register("waterloggable_block", () -> new WaterloggableBlockFeature(SimpleBlockConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ALGAE_BOULDER = FEATURES.register("algae_boulder", () -> new AlgaeBoulderFeature(NoneFeatureConfiguration.CODEC));

}
