package com.peeko32213.seafarer.world.config;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;

public class PatchFeatureForm implements FeatureForm {
    @Override
    public void placeForm(WorldGenLevel worldGenLevel, ChunkGenerator chunkGenerator, BlockPos origin, BlockPos offSet,BlockState state,RandomSource randomSource) {
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
                    // You can add a check to ensure the block can be placed on this position, like on grass
                    if (worldGenLevel.getBlockState(withOffSet.below()).isSolid()) {
                        worldGenLevel.setBlock(withOffSet, state, 2);
                    }
                }
            }
        }
    }
}
