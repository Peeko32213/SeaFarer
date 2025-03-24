package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.world.feature.AlgaeBoulderFeature;
import com.peeko32213.seafarer.common.world.feature.WaterloggableBlockFeature;
import com.peeko32213.seafarer.core.registry.world.config.TagBasedRandomFeature;
import com.peeko32213.seafarer.core.registry.world.config.TagBasedRandomFeatureConfig;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SeaFarer.MODID);

    public static final RegistryObject<Feature<SimpleBlockConfiguration>> WATERLOGGABLE_BLOCK = FEATURES.register("waterloggable_block", () -> new WaterloggableBlockFeature(SimpleBlockConfiguration.CODEC));
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> ALGAE_BOULDER = FEATURES.register("algae_boulder", () -> new AlgaeBoulderFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<Feature<TagBasedRandomFeatureConfig>> TAG_FEATURE = FEATURES.register("tag_feature", () -> new TagBasedRandomFeature<>(TagBasedRandomFeatureConfig.CODEC));

}
