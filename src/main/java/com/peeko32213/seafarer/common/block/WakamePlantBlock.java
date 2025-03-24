package com.peeko32213.seafarer.common.block;

import com.peeko32213.seafarer.core.registry.blocks.SFBlocks;
import net.minecraft.world.level.block.*;

public class WakamePlantBlock extends KelpPlantBlock {

    public WakamePlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return SFBlocks.WAKAME.get();
    }
}

