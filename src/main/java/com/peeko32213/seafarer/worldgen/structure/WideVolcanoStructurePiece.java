package com.peeko32213.seafarer.worldgen.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;

public class WideVolcanoStructurePiece extends VolcanoStructurePiece {

    public WideVolcanoStructurePiece(LevelHeightAccessor heightAccessor, BlockPos pos, int radiusX, int radiusZ, long noiseSeed, boolean overgrown) {
        super(heightAccessor, pos, radiusX, radiusZ, noiseSeed, overgrown);
    }

    public WideVolcanoStructurePiece(StructurePieceSerializationContext context, CompoundTag compoundTag) {
        super(context, compoundTag);
    }

    @Override
    public int getCalderaHeight() {
        return 92;
    }

    @Override
    public int getLavaLevel() {
        return 78;
    }
}