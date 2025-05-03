package com.peeko32213.seafarer.common.block.shell;

import com.peeko32213.seafarer.common.block.SFWetFloorLayerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShellBlock extends SFWetFloorLayerBlock {

    public static final VoxelShape shellShape = Block.box(3, 0, 3, 13, 3, 13);

    public ShellBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return shellShape;
    }
}
