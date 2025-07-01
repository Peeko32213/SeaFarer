package com.peeko32213.seafarer.blocks;

import com.peeko32213.seafarer.registry.SeafarerBlocks;
import net.minecraft.world.level.block.*;

public class WakamePlantBlock extends KelpPlantBlock {

    public WakamePlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return SeafarerBlocks.WAKAME.get();
    }
}

