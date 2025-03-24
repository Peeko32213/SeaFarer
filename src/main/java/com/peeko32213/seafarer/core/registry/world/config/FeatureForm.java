package com.peeko32213.seafarer.core.registry.world.config;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public interface FeatureForm {

    void placeForm(WorldGenLevel worldGenLevel, ChunkGenerator chunkGenerator, BlockPos origin, BlockPos offSet, BlockState state, BlockState filter, RandomSource randomSource);

}
