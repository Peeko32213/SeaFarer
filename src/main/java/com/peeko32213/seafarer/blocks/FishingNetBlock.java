package com.peeko32213.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")
public class FishingNetBlock extends LadderBlock {

    public FishingNetBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.getAbilities().mayBuild) {
            if (!stack.isEmpty() && stack.is(this.asItem())) {
                Block block = Block.byItem(stack.getItem());
                while (level.getBlockState(pos).getBlock() == block) {
                    BlockPos below = pos.below();
                    if (level.isOutsideBuildHeight(below)) {
                        break;
                    }
                    BlockState belowState = level.getBlockState(below);
                    if (belowState.getBlock() == block) {
                        pos = below;
                    } else {
                        boolean water = belowState.getBlock() == Blocks.WATER;
                        if (water || belowState.isAir()) {
                            BlockState copyState = level.getBlockState(pos);
                            if (copyState.canSurvive(level, below)) {
                                level.setBlockAndUpdate(below, copyState.setValue(BlockStateProperties.WATERLOGGED, water));
                                level.playSound(null, below.getX(), below.getY(), below.getZ(), SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1F, 1F);
                                if (!player.getAbilities().instabuild) {
                                    stack.shrink(1);
                                }
                                return InteractionResult.sidedSuccess(level.isClientSide);
                            }
                        }
                        break;
                    }
                }
            }
            if (player.isCrouching() && (player.getAbilities().instabuild || player.getInventory().add(new ItemStack(this.asItem())))) {
                BlockPos.MutableBlockPos below = pos.mutable().move(Direction.DOWN);
                while (below.getY() >= level.getMinBuildHeight()) {
                    BlockState belowState = level.getBlockState(below);
                    if (belowState.is(this)) {
                        below.move(Direction.DOWN);
                    } else {
                        below.move(Direction.UP);
                        level.destroyBlock(below, false, player);
                        return InteractionResult.sidedSuccess(level.isClientSide);
                    }
                }
            }
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        if (!state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
        }
        return super.updateShape(state, direction, blockState, level, pos, blockPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockState = level.getBlockState(pos.relative(Direction.UP));
        return super.canSurvive(state, level, pos) || (blockState.is(this) && state.getValue(FACING).equals(blockState.getValue(FACING)));
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return true;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }
}
