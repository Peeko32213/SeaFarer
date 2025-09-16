package com.peeko32213.seafarer.blocks;

import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FishingNetBlock extends Block {

    public static final BooleanProperty UP = PipeBlock.UP;
    public static final BooleanProperty NORTH = PipeBlock.NORTH;
    public static final BooleanProperty EAST = PipeBlock.EAST;
    public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
    public static final BooleanProperty WEST = PipeBlock.WEST;
    public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((p_57886_) -> p_57886_.getKey() != Direction.DOWN).collect(Util.toMap());
    private static final VoxelShape UP_AABB = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_AABB = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    private static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
    private final Map<BlockState, VoxelShape> shapesCache;

    public FishingNetBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(UP, false).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
        this.shapesCache = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), FishingNetBlock::calculateShape)));
    }

    private static VoxelShape calculateShape(BlockState state) {
        VoxelShape voxelshape = Shapes.empty();
        if (state.getValue(UP)) {
            voxelshape = UP_AABB;
        }

        if (state.getValue(NORTH)) {
            voxelshape = Shapes.or(voxelshape, NORTH_AABB);
        }

        if (state.getValue(SOUTH)) {
            voxelshape = Shapes.or(voxelshape, SOUTH_AABB);
        }

        if (state.getValue(EAST)) {
            voxelshape = Shapes.or(voxelshape, EAST_AABB);
        }

        if (state.getValue(WEST)) {
            voxelshape = Shapes.or(voxelshape, WEST_AABB);
        }

        return voxelshape.isEmpty() ? Shapes.block() : voxelshape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return this.shapesCache.get(state);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return this.hasFaces(this.getUpdatedState(state, level, pos));
    }

    private boolean hasFaces(BlockState state) {
        return this.countFaces(state) > 0;
    }

    private int countFaces(BlockState state) {
        int i = 0;
        for (BooleanProperty direction : PROPERTY_BY_DIRECTION.values()) {
            if (state.getValue(direction)) {
                ++i;
            }
        }
        return i;
    }

    private boolean canSupportAtFace(BlockGetter p_57888_, BlockPos p_57889_, Direction p_57890_) {
        if (p_57890_ == Direction.DOWN) {
            return false;
        } else {
            BlockPos blockpos = p_57889_.relative(p_57890_);
            if (isAcceptableNeighbour(p_57888_, blockpos, p_57890_)) {
                return true;
            } else if (p_57890_.getAxis() == Direction.Axis.Y) {
                return false;
            } else {
                BooleanProperty booleanproperty = PROPERTY_BY_DIRECTION.get(p_57890_);
                BlockState blockstate = p_57888_.getBlockState(p_57889_.above());
                return blockstate.is(this) && blockstate.getValue(booleanproperty);
            }
        }
    }

    public static boolean isAcceptableNeighbour(BlockGetter blockGetter, BlockPos pos, Direction direction) {
        return MultifaceBlock.canAttachTo(blockGetter, direction, pos, blockGetter.getBlockState(pos));
    }

    private BlockState getUpdatedState(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        BlockPos blockpos = pos.above();
        if (state.getValue(UP)) {
            state = state.setValue(UP, isAcceptableNeighbour(blockGetter, blockpos, Direction.DOWN));
        }

        BlockState blockstate = null;

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BooleanProperty booleanproperty = getPropertyForFace(direction);
            if (state.getValue(booleanproperty)) {
                boolean flag = this.canSupportAtFace(blockGetter, pos, direction);
                if (!flag) {
                    if (blockstate == null) {
                        blockstate = blockGetter.getBlockState(blockpos);
                    }

                    flag = blockstate.is(this) && blockstate.getValue(booleanproperty);
                }

                state = state.setValue(booleanproperty, flag);
            }
        }

        return state;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        if (direction == Direction.DOWN) {
            return super.updateShape(state, direction, blockState, level, pos, blockPos);
        } else {
            BlockState blockstate = this.getUpdatedState(state, level, pos);
            return !this.hasFaces(blockstate) ? Blocks.AIR.defaultBlockState() : blockstate;
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.is(this)) {
            return this.countFaces(blockstate) < PROPERTY_BY_DIRECTION.size();
        } else {
            return super.canBeReplaced(state, context);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        boolean flag = state.is(this);
        BlockState blockState = flag ? state : this.defaultBlockState();

        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction != Direction.DOWN) {
                BooleanProperty booleanproperty = getPropertyForFace(direction);
                boolean flag1 = flag && state.getValue(booleanproperty);
                if (!flag1 && this.canSupportAtFace(context.getLevel(), context.getClickedPos(), direction)) {
                    return blockState.setValue(booleanproperty, true);
                }
            }
        }

        return flag ? blockState : null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(UP, NORTH, EAST, SOUTH, WEST);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return switch (rotation) {
            case CLOCKWISE_180 ->
                    state.setValue(NORTH, state.getValue(SOUTH)).setValue(EAST, state.getValue(WEST)).setValue(SOUTH, state.getValue(NORTH)).setValue(WEST, state.getValue(EAST));
            case COUNTERCLOCKWISE_90 ->
                    state.setValue(NORTH, state.getValue(EAST)).setValue(EAST, state.getValue(SOUTH)).setValue(SOUTH, state.getValue(WEST)).setValue(WEST, state.getValue(NORTH));
            case CLOCKWISE_90 ->
                    state.setValue(NORTH, state.getValue(WEST)).setValue(EAST, state.getValue(NORTH)).setValue(SOUTH, state.getValue(EAST)).setValue(WEST, state.getValue(SOUTH));
            default -> state;
        };
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return switch (mirror) {
            case LEFT_RIGHT -> state.setValue(NORTH, state.getValue(SOUTH)).setValue(SOUTH, state.getValue(NORTH));
            case FRONT_BACK -> state.setValue(EAST, state.getValue(WEST)).setValue(WEST, state.getValue(EAST));
            default -> super.mirror(state, mirror);
        };
    }

    public static BooleanProperty getPropertyForFace(Direction direction) {
        return PROPERTY_BY_DIRECTION.get(direction);
    }
}
