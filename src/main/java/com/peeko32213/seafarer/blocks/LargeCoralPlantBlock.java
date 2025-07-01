package com.peeko32213.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class LargeCoralPlantBlock extends BushBlock implements BonemealableBlock, LiquidBlockContainer, net.minecraftforge.common.IForgeShearable{
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D);
    public static final DirectionProperty FACING = DirectionalBlock.FACING;

    public LargeCoralPlantBlock(BlockBehaviour.Properties p_154496_) {
        super(p_154496_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }


    public VoxelShape getShape(BlockState p_154525_, BlockGetter p_154526_, BlockPos p_154527_, CollisionContext p_154528_) {
        return SHAPE;
    }

    public BlockState rotate(BlockState p_52716_, Rotation p_52717_) {
        return p_52716_.setValue(FACING, p_52717_.rotate(p_52716_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_52713_, Mirror p_52714_) {
        return p_52713_.rotate(p_52714_.getRotation(p_52713_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    protected boolean mayPlaceOn(BlockState p_154539_, BlockGetter p_154540_, BlockPos p_154541_) {
        return p_154539_.isFaceSturdy(p_154540_, p_154541_, Direction.UP) && !p_154539_.is(Blocks.MAGMA_BLOCK);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_154503_) {
        BlockState blockstate = super.getStateForPlacement(p_154503_);
        if (blockstate != null) {
            FluidState fluidstate = p_154503_.getLevel().getFluidState(p_154503_.getClickedPos().above());
            if (fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8) {
                return blockstate;
            }
        }

        return this.defaultBlockState().setValue(FACING, p_154503_.getNearestLookingDirection().getOpposite());
    }

    /**
     * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific direction passed in.
     */
    public BlockState updateShape(BlockState p_154530_, Direction p_154531_, BlockState p_154532_, LevelAccessor p_154533_, BlockPos p_154534_, BlockPos p_154535_) {
        BlockState blockstate = super.updateShape(p_154530_, p_154531_, p_154532_, p_154533_, p_154534_, p_154535_);
        if (!blockstate.isAir()) {
            p_154533_.scheduleTick(p_154534_, Fluids.WATER, Fluids.WATER.getTickDelay(p_154533_));
        }

        return blockstate;
    }

    /**
     * @return whether bonemeal can be used on this block
     */
    public boolean isValidBonemealTarget(LevelReader p_255857_, BlockPos p_154511_, BlockState p_154512_, boolean p_154513_) {
        return false;
    }

    public boolean isBonemealSuccess(Level p_222428_, RandomSource p_222429_, BlockPos p_222430_, BlockState p_222431_) {
        return false;
    }

    public FluidState getFluidState(BlockState p_154537_) {
        return Fluids.WATER.getSource(false);
    }

    public void performBonemeal(ServerLevel p_222423_, RandomSource p_222424_, BlockPos p_222425_, BlockState p_222426_) {

    }

    public boolean canPlaceLiquid(BlockGetter p_154505_, BlockPos p_154506_, BlockState p_154507_, Fluid p_154508_) {
        return false;
    }

    public boolean placeLiquid(LevelAccessor p_154520_, BlockPos p_154521_, BlockState p_154522_, FluidState p_154523_) {
        return false;
    }
}
