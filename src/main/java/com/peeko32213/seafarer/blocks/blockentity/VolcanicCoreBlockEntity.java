package com.peeko32213.seafarer.blocks.blockentity;

import com.peeko32213.seafarer.blocks.VolcanicCoreBlock;
import com.peeko32213.seafarer.registry.SeaBlockEntities;
import com.peeko32213.seafarer.registry.SeaParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VolcanicCoreBlockEntity extends BlockEntity {

    public VolcanicCoreBlockEntity(BlockPos pos, BlockState state) {
        super(SeaBlockEntities.VOLCANIC_CORE.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, VolcanicCoreBlockEntity volcanicCore) {
        if (state.getValue(VolcanicCoreBlock.ACTIVE)) {
            volcanicCore.push(level);
        }
    }

    private void push(Level level) {
        if (level == null) return;

        if (level.isClientSide()) {
            RandomSource random = level.getRandom();

            float x = (level.random.nextFloat() - 0.5F) * 0.5F;
            float z = (level.random.nextFloat() - 0.5F) * 0.5F;

            if (random.nextFloat() < 0.1F) {
                level.addAlwaysVisibleParticle(SeaParticles.VOLCANIC_SMOKE.get(), true, worldPosition.getX() + 0.5F + x, worldPosition.getY() + 6.0F, worldPosition.getZ() + 0.5F + z, x * 0.2F, 0.175F + level.random.nextFloat() * 0.05F, z * 0.2F);
            }
        }
    }
}
