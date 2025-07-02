package com.peeko32213.seafarer.registry;

import com.peeko32213.seafarer.Seafarer;
import com.peeko32213.seafarer.worldgen.feature.AlgaeBoulderFeature;
import com.peeko32213.seafarer.worldgen.feature.WaterloggableBlockFeature;
import com.peeko32213.seafarer.worldgen.configs.TagBasedRandomFeature;
import com.peeko32213.seafarer.worldgen.configs.TagBasedRandomFeatureConfig;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Seafarer.MOD_ID);

    public static final RegistryObject<Feature<SimpleBlockConfiguration>> WATERLOGGABLE_BLOCK = FEATURES.register("waterloggable_block", () -> new WaterloggableBlockFeature(SimpleBlockConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ALGAE_BOULDER = FEATURES.register("algae_boulder", () -> new AlgaeBoulderFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<TagBasedRandomFeatureConfig>> TAG_FEATURE = FEATURES.register("tag_feature", () -> new TagBasedRandomFeature<>(TagBasedRandomFeatureConfig.CODEC));

}
