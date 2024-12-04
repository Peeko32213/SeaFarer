package com.peeko32213.seafarer.common.block;

import com.peeko32213.seafarer.core.registry.SFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WakameBlock extends KelpBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    public static final int MAX_AGE = 7;

    public WakameBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getBodyBlock() {
        return SFBlocks.WAKAME_PLANT.get();
    }
}