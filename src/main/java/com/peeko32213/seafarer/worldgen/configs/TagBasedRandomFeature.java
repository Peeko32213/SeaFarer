package com.peeko32213.seafarer.worldgen.configs;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;

public class TagBasedRandomFeature <T extends TagBasedRandomFeatureConfig> extends Feature<T> {
    public TagBasedRandomFeature(Codec<T> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<T> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        ChunkGenerator chunkGenerator = context.chunkGenerator();
        RandomSource randomSource = context.random();
        T config = context.config();
        BlockPos offSet = config.offSet().orElse(BlockPos.ZERO);
        Block fallback = config.fallback().orElse(Blocks.SAND);
        TagKey<Block> blockTagKey = config.tag();
        Optional<Block> block = ForgeRegistries.BLOCKS.tags().getTag(blockTagKey).getRandomElement(randomSource);
        Block placementBlock = block.orElse(fallback);
        FeatureForm featureForm = config.featureForm();
        Block filter = config.filter().orElse(Blocks.AIR);
        featureForm.placeForm(level, chunkGenerator, origin, offSet, placementBlock.defaultBlockState(), filter.defaultBlockState(),  randomSource);
        return true;
    }
}
