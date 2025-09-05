package com.peeko32213.seafarer.worldgen.feature;

import com.mojang.serialization.Codec;
import com.peeko32213.seafarer.blocks.GorgonianCoralBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class GorgonianFeature extends Feature<SimpleBlockConfiguration> {

    public GorgonianFeature(Codec<SimpleBlockConfiguration> configuration) {
        super(configuration);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
        boolean placed = false;
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        SimpleBlockConfiguration configuration = context.config();

        BlockState blockstate = configuration.toPlace().getState(context.random(), pos);

        int x = random.nextInt(8) - random.nextInt(8);
        int z = random.nextInt(8) - random.nextInt(8);
        int heightMap = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX() + x, pos.getZ() + z);
        BlockPos newPos = new BlockPos(pos.getX() + x, heightMap, pos.getZ() + z);

        if (level.getBlockState(newPos).is(Blocks.WATER)) {
            if (blockstate.canSurvive(level, newPos)) {
                BlockState upperState = blockstate.setValue(GorgonianCoralBlock.HALF, DoubleBlockHalf.UPPER);
                BlockPos abovePos = newPos.above();
                if (level.getBlockState(abovePos).is(Blocks.WATER)) {
                    level.setBlock(newPos, blockstate, 2);
                    level.setBlock(abovePos, upperState, 2);
                }
                placed = true;
            }
        }
        return placed;
    }
}
