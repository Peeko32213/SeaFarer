package com.peeko32213.seafarer.blocks;

import com.peeko32213.seafarer.registry.SeafarerBlocks;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WakameBlock extends KelpBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    public static final int MAX_AGE = 7;

    public WakameBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getBodyBlock() {
        return SeafarerBlocks.WAKAME_PLANT.get();
    }
}