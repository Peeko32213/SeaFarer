package com.peeko32213.seafarer.worldgen.feature;

import com.mojang.serialization.Codec;
import com.peeko32213.seafarer.blocks.StarfishBlock;
import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.tags.SeaBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Optional;

public class StarfishFeature extends Feature<NoneFeatureConfiguration> {

    public StarfishFeature(Codec<NoneFeatureConfiguration> configuration) {
        super(configuration);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        Optional<Block> starfish = BuiltInRegistries.BLOCK.getTag(SeaBlockTags.STARFISH).flatMap((holders) -> holders.getRandomElement(level.getRandom())).map(Holder::value);

        int i = 0;

        BlockState block = starfish.map(Block::defaultBlockState).orElseGet(SeaBlocks.ORANGE_STARFISH.get()::defaultBlockState).setValue(StarfishBlock.FACING, Direction.UP).setValue(StarfishBlock.WATERLOGGED, true);
        for (int j = 0; j < 10; j++) {
            BlockPos blockpos = pos.offset(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (level.getFluidState(blockpos).is(FluidTags.WATER) && blockpos.getY() < 255 && block.canSurvive(level, blockpos)) {
                Direction direction = Direction.getRandom(random);
                while (!block.setValue(StarfishBlock.FACING, direction).canSurvive(level, blockpos)) {
                    direction = Direction.getRandom(random);
                }
                level.setBlock(blockpos, block.setValue(StarfishBlock.FACING, direction).setValue(StarfishBlock.WATERLOGGED, true), 2);
                i++;
            }
        }
        return i > 0;
    }
}
