package com.peeko32213.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PyramidShellBlock extends WetFloorLayerBlock {

    public static final VoxelShape pyramidShellShape = Block.box(3, 0, 3, 13, 8, 13);

    public PyramidShellBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return pyramidShellShape;
    }
}
