package com.peeko32213.seafarer.core.registry.world.config;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;

public class PatchFeatureForm implements FeatureForm {
    @Override
    public void placeForm(WorldGenLevel worldGenLevel, ChunkGenerator chunkGenerator, BlockPos origin, BlockPos offSet, BlockState state, BlockState filter, RandomSource randomSource) {
        // Define the radius of the patch
        int radius = 3;  // Example radius of 3 blocks

        // Loop through a square area centered at the origin
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                // Calculate the distance from the origin
                double distance = Math.sqrt(dx * dx + dz * dz);

                // If within the radius, place the block
                if (distance <= radius) {


                    BlockPos targetPos = origin.offset(dx, 0, dz);
                    BlockPos withY = worldGenLevel.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, targetPos);
                    BlockPos withOffSet = withY.below().offset(offSet);
                    BlockState placeState = worldGenLevel.getBlockState(withOffSet.below());
                    // You can add a check to ensure the block can be placed on this position, like on grass
                    if (placeState.isSolid() && (!filter.is(Blocks.AIR) && placeState.is(filter.getBlock()))) {
                        worldGenLevel.setBlock(withOffSet, state, 2);
                    } else if(placeState.isSolid()){
                        worldGenLevel.setBlock(withOffSet, state, 2);

                    }
                }
            }
        }
    }
}
