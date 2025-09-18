package com.peeko32213.seafarer.blocks.blockentity;

import com.peeko32213.seafarer.blocks.VolcanicCoreBlock;
import com.peeko32213.seafarer.registry.SeaBlockEntities;
import com.peeko32213.seafarer.registry.SeaParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VolcanicCoreBlockEntity extends BlockEntity {

    public VolcanicCoreBlockEntity(BlockPos pos, BlockState state) {
        super(SeaBlockEntities.VOLCANIC_CORE.get(), pos, state);
    }

    public static void particleTick(Level level, BlockPos pos, BlockState state, VolcanicCoreBlockEntity blockEntity) {
        RandomSource random = level.getRandom();
        if (state.getValue(VolcanicCoreBlock.ACTIVE)) {
            if (random.nextFloat() < 0.04F) {
                float x = (random.nextFloat() - 0.5F) * 0.5F;
                float z = (random.nextFloat() - 0.5F) * 0.5F;
                if (random.nextFloat() <= 0.3F) {
                    if (random.nextFloat() <= 0.7F) {
                        level.addAlwaysVisibleParticle(SeaParticles.BIG_VOLCANIC_SMOKE.get(), true, pos.getX() + 0.5F + x, pos.getY() + 0.5F, pos.getZ() + 0.5F + z, x * 0.15F, 0.2F + random.nextFloat() * 0.03F, z * 0.15F);
                    } else {
                        level.addAlwaysVisibleParticle(SeaParticles.GIANT_VOLCANIC_SMOKE.get(), true, pos.getX() + 0.5F + x, pos.getY() + 0.5F, pos.getZ() + 0.5F + z, x * 0.15F, 0.2F + random.nextFloat() * 0.03F, z * 0.15F);
                    }
                } else {
                    if (random.nextBoolean()) {
                        level.addAlwaysVisibleParticle(SeaParticles.SMALL_VOLCANIC_SMOKE.get(), true, pos.getX() + 0.5F + x, pos.getY() + 0.5F, pos.getZ() + 0.5F + z, x * 0.15F, 0.2F + random.nextFloat() * 0.03F, z * 0.15F);
                    } else {
                        level.addAlwaysVisibleParticle(SeaParticles.MEDIUM_VOLCANIC_SMOKE.get(), true, pos.getX() + 0.5F + x, pos.getY() + 0.5F, pos.getZ() + 0.5F + z, x * 0.15F, 0.2F + random.nextFloat() * 0.03F, z * 0.15F);
                    }
                }
            }
        }
    }
}
