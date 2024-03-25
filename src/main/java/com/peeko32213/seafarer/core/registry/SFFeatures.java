package com.peeko32213.seafarer.core.registry;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.world.AlgaePatchFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.data.worldgen.features.FeatureUtils.createKey;

public class SFFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SeaFarer.MODID);
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE_PATCH_PLANTS = createKey("algae_patch_plants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALGAE_PATCH_BONEMEAL = createKey("algae_patch_bonemeal");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SFFeatures.ALGAE_PATCH_PLANTS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(SFBlocks.ALGAE_PLANT.get().defaultBlockState(), 6).add(SFBlocks.ALGAE_CARPET.get().defaultBlockState(), 6))));
        final Holder<ConfiguredFeature<?, ?>> ALGAE_PATCH_PLANTS = configuredFeatureGetter.getOrThrow(SFFeatures.ALGAE_PATCH_PLANTS);

        register(context, SFFeatures.ALGAE_PATCH_BONEMEAL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(SFBlocks.ALGAE_BLOCK.get()), PlacementUtils.inlinePlaced(ALGAE_PATCH_PLANTS), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.4F, UniformInt.of(1, 2), 0.75F));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, F feature, FC configuration)
    {
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration));
    }
}
