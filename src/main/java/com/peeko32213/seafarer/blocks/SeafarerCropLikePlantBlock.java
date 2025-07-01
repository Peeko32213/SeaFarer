package com.peeko32213.seafarer.blocks;

import com.peeko32213.seafarer.registry.tags.SeafarerTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SeafarerCropLikePlantBlock extends SandPlantBlock {

    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public SeafarerCropLikePlantBlock(Properties pProperties) {
        super(pProperties);
    }


    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(SeafarerTags.BEACH_PLANT_BLOCKS);
    }

}
