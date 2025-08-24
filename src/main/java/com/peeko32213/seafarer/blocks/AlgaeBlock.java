package com.peeko32213.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MossBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class AlgaeBlock extends MossBlock implements BonemealableBlock {

    public AlgaeBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pLevel.getBlockState(pPos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level p_153802_, RandomSource p_153803_, BlockPos p_153804_, BlockState p_153805_)
    {
        return true;
    }

//    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
//        pLevel.registryAccess().registry(Registries.CONFIGURED_FEATURE).flatMap((configuredFeatures) -> configuredFeatures.getHolder(SFConfiguredFeatures.ALGAE_PATCH_BONEMEAL)).ifPresent((featureReference) -> featureReference.value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRandom, pPos.above()));
//    }

}
