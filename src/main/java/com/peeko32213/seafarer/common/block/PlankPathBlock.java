package com.peeko32213.seafarer.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
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
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PlankPathBlock extends DirectionalBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape EAST_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape UP_AABB;
    protected static final VoxelShape DOWN_AABB;

    public PlankPathBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(FACING) == Direction.NORTH) {
            BlockPos northPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
            return level.getBlockState(northPos).isFaceSturdy(level, pos, Direction.SOUTH);

        } else if (state.getValue(FACING) == Direction.SOUTH) {
            BlockPos southPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
            return level.getBlockState(southPos).isFaceSturdy(level, pos, Direction.NORTH);

        } else if (state.getValue(FACING) == Direction.EAST) {
            BlockPos eastPos = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
            return level.getBlockState(eastPos).isFaceSturdy(level, pos, Direction.WEST);

        } else if (state.getValue(FACING) == Direction.WEST) {
            BlockPos westPos = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
            return level.getBlockState(westPos).isFaceSturdy(level, pos, Direction.EAST);

        } else if (state.getValue(FACING) == Direction.UP) {
            BlockPos upPos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
            return level.getBlockState(upPos).isFaceSturdy(level, pos, Direction.DOWN);

        } else {
            BlockPos downPos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
            return level.getBlockState(downPos).isFaceSturdy(level, pos, Direction.UP);
        }
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        return (!state.getCollisionShape(world, pos).getFaceShape(Direction.UP).isEmpty() || state.isFaceSturdy(world, pos, Direction.UP)) && !state.is(BlockTags.LEAVES);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            default:
                return UP_AABB;
            case DOWN:
                return DOWN_AABB;
            case UP:
                return UP_AABB;
            case NORTH:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
        }
    }
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }
    public BlockState mirror(BlockState state, Mirror flip) {
        return state.setValue(FACING, flip.mirror(state.getValue(FACING)));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext world) {

        Direction dir = world.getClickedFace();
        BlockState oppDir = world.getLevel().getBlockState(world.getClickedPos().relative(dir.getOpposite()));

        if (!this.scanForWater(world.getLevel(), world.getClickedPos())) {
            world.getLevel().scheduleTick(world.getClickedPos(), this, 60 + world.getLevel().getRandom().nextInt(40));
        }
        {
            FluidState fluidstate = world.getLevel().getFluidState(world.getClickedPos());
            boolean flag = fluidstate.getType() == Fluids.WATER;
            return super.getStateForPlacement(world).setValue(WATERLOGGED, Boolean.valueOf(flag));
        }
    }

    protected boolean scanForWater(BlockGetter pLevel, BlockPos pPos) {
        BlockState state = pLevel.getBlockState(pPos);
        for(Direction direction : Direction.values()) {
            FluidState fluidstate = pLevel.getFluidState(pPos.relative(direction));
            if (state.canBeHydrated(pLevel, pPos, fluidstate, pPos.relative(direction))) {
                return true;
            }
        }

        return false;
    }

    static {
        EAST_AABB = Block.box(0.0, 0.0, 0.0, 5.0, 16.0, 16.0);
        WEST_AABB = Block.box(11.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 5.0);
        NORTH_AABB = Block.box(0.0, 0.0, 11.0, 16.0, 16.0, 16.0);
        UP_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0);
        DOWN_AABB = Block.box(0.0, 11.0, 0.0, 16.0, 16.0, 16.0);
    }
}