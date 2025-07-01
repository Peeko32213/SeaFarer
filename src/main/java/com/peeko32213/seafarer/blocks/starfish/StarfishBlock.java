package com.peeko32213.seafarer.blocks.starfish;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class StarfishBlock extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING;
    protected static final VoxelShape EAST_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape UP_AABB;
    protected static final VoxelShape DOWN_AABB;

    public StarfishBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false).setValue(FACING, Direction.UP));
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case DOWN -> DOWN_AABB;
            case UP -> UP_AABB;
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case WEST -> WEST_AABB;
            case EAST -> EAST_AABB;
        };
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        BlockPos pos = pPos.relative(direction.getOpposite());
        return pLevel.getBlockState(pos).isFaceSturdy(pLevel, pos, direction);
    }

    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        return pDirection == pState.getValue(FACING).getOpposite() && !pState.canSurvive(pLevel, pPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelAccessor level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        return this.defaultBlockState().setValue(WATERLOGGED, level.getFluidState(pos).getType() == Fluids.WATER).setValue(FACING, pContext.getClickedFace());
    }

    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, FACING);
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        FACING = BlockStateProperties.FACING;

        UP_AABB = Block.box(3, 0.0F, 3, 13, 3, 13);
        DOWN_AABB = Block.box(3, 13, 3, 13, 16.0F, 13);

        NORTH_AABB = Block.box(3, 3, 13, 13, 13, 16.0F);
        SOUTH_AABB = Block.box(3, 3, 0.0F, 13, 13, 3);

        EAST_AABB = Block.box(0.0F, 3, 3, 3, 13, 13);
        WEST_AABB = Block.box(13, 3, 3, 16.0F, 13, 13);
    }
}
