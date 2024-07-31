package com.peeko32213.seafarer.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SFSeaGlassBottleBlock extends Block {

    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 10.0D, 10.0D, 10.0D);
    private final VoxelShape bottleHitbox;

    public SFSeaGlassBottleBlock(Properties properties) {
        this(SHAPE, properties);
    }

    public SFSeaGlassBottleBlock(VoxelShape bottleHitbox,Properties pProperties) {
        super(pProperties);
        this.bottleHitbox  =bottleHitbox;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return bottleHitbox;
    }

}
