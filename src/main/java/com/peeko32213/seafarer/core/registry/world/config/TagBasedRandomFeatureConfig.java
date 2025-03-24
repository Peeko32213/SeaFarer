package com.peeko32213.seafarer.core.registry.world.config;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.Optional;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraftforge.registries.ForgeRegistries;

public record TagBasedRandomFeatureConfig(TagKey<Block> tag, Optional<Block> fallback, Optional<Block> filter,Optional<BlockPos> offSet, FeatureForm featureForm) implements FeatureConfiguration {
    public static final Codec<TagBasedRandomFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.codec(Registries.BLOCK).fieldOf("tag").forGetter(TagBasedRandomFeatureConfig::tag),
            ForgeRegistries.BLOCKS.getCodec().optionalFieldOf("fallback").forGetter(TagBasedRandomFeatureConfig::fallback),
            ForgeRegistries.BLOCKS.getCodec().optionalFieldOf("filter").forGetter(TagBasedRandomFeatureConfig::filter),
            BlockPos.CODEC.optionalFieldOf("offset").forGetter(TagBasedRandomFeatureConfig::offSet),
            SFFeatureForms.CODEC.fieldOf("feature_fom").forGetter(TagBasedRandomFeatureConfig::featureForm)
    ).apply(instance, TagBasedRandomFeatureConfig::new));
}

