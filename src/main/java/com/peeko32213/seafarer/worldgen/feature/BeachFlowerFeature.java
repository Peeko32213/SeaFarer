package com.peeko32213.seafarer.worldgen.feature;

import com.mojang.serialization.Codec;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.tags.SeaBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Optional;

public class BeachFlowerFeature extends Feature<NoneFeatureConfiguration> {

    public BeachFlowerFeature(Codec<NoneFeatureConfiguration> configuration) {
        super(configuration);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        for (BlockState blockstate = level.getBlockState(pos); (level.isEmptyBlock(pos) || blockstate.is(BlockTags.LEAVES)) && pos.getY() > 0; blockstate = level.getBlockState(pos)) {
            pos = pos.below();
        }

        Optional<Block> flower = BuiltInRegistries.BLOCK.getTag(SeaBlockTags.BEACH_FLOWERS).flatMap((holders) -> holders.getRandomElement(level.getRandom())).map(Holder::value);

        int flowersPlaced = 0;

        BlockState block = flower.map(Block::defaultBlockState).orElseGet(SeaBlocks.SEA_HOLLY.get()::defaultBlockState);
        BlockPos blockpos = pos.offset(random.nextInt(4) - random.nextInt(4), random.nextInt(4) - random.nextInt(4), random.nextInt(4) - random.nextInt(4));
        if (pos.getY() >= level.getSeaLevel() + 3) {
            for (int j = 0; j < 128; ++j) {
                if (level.isEmptyBlock(blockpos) && block.getBlock().defaultBlockState().canSurvive(level, blockpos)) {
                    level.setBlock(blockpos, block.getBlock().defaultBlockState(), 2);
                    flowersPlaced++;
                }
            }
        } else {
            return true;
        }

        return flowersPlaced > 0;
    }
}
