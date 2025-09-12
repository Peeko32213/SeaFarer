package com.peeko32213.seafarer.worldgen.structure;

import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.SeaStructurePieces;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import net.minecraft.world.ticks.ScheduledTick;

public class VolcanoStructurePiece extends StructurePiece {

    private final static int CALDERA_CUTOFF = 128;
    private final static int VOLCANO_TOP = CALDERA_CUTOFF - 7;
    public final static int VOLCANO_CRUST = VOLCANO_TOP - 3;
    public final int LAVA_LEVEL = CALDERA_CUTOFF - 16;
    private static final float STEEPNESS = 7.0F;

    private final int radiusX;
    private final int radiusZ;
    private final long noiseSeed;

    private final ImprovedNoise noise;

    protected VolcanoStructurePiece(LevelHeightAccessor heightAccessor, BlockPos pos, int radiusX, int radiusZ, long noiseSeed) {
        super(SeaStructurePieces.VOLCANO.get(), 0, boundingBox(heightAccessor, pos, radiusX, radiusZ));
        this.radiusX = radiusX;
        this.radiusZ = radiusZ;
        this.noiseSeed = noiseSeed;
        this.noise = createNoise(noiseSeed);
    }

    public VolcanoStructurePiece(StructurePieceSerializationContext context, CompoundTag compoundTag) {
        super(SeaStructurePieces.VOLCANO.get(), compoundTag);
        this.radiusX = compoundTag.getInt("radius_x");
        this.radiusZ = compoundTag.getInt("radius_z");
        this.noiseSeed = compoundTag.getLong("noise_seed");
        this.noise = createNoise(noiseSeed);
    }

    private static BoundingBox boundingBox(LevelHeightAccessor heightAccessor, BlockPos pos, int radiusX, int radiusZ) {
        return new BoundingBox(pos.getX() - radiusX - 1, pos.getY(), pos.getZ() - radiusZ - 1, pos.getX() + radiusX + 1, heightAccessor.getMaxBuildHeight(), pos.getZ() + radiusZ + 1);
    }

    private static ImprovedNoise createNoise(long seed) {
        return new ImprovedNoise(RandomSource.create(seed));
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag compoundTag) {
        compoundTag.putInt("radius_x", radiusX);
        compoundTag.putInt("radius_z", radiusZ);
        compoundTag.putLong("noise_seed", noiseSeed);
    }

    @Override
    public void postProcess(WorldGenLevel level, StructureManager structureManager, ChunkGenerator generator, RandomSource random, BoundingBox chunkBox, ChunkPos chunkPos, BlockPos pos) {
        int calderaCutoffY = pos.getY() + CALDERA_CUTOFF;
        int lavaY = pos.getY() + LAVA_LEVEL;
        int topY = pos.getY() + VOLCANO_TOP;
        int crustY = pos.getY() + VOLCANO_CRUST;

        for (int z = chunkBox.minZ(); z <= chunkBox.maxZ(); z++) {
            for (int x = chunkBox.minX(); x <= chunkBox.maxX(); x++) {
                float height = getColumnHeight(x - pos.getX(), z - pos.getZ());
                if (!Float.isNaN(height)) {
                    placeColumn(level, random, x, z, calderaCutoffY, lavaY, topY, crustY, height);
                }
            }
        }
    }

    private void placeColumn(WorldGenLevel level, RandomSource random, int x, int z, int calderaCutoffY, int lavaY, int topY, int crustY, float height) {
        BlockState volcanoState = SeaBlocks.VOLCANIC_BASALT.get().defaultBlockState();

        int terrainY = Math.min(level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, x, z), lavaY - 3);
        int lavaBottom = lavaY - 12 + random.nextInt(4);
        int volcanoBottom = lavaY - 108 + random.nextInt(4);

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int y = level.getMaxBuildHeight(); y > level.getMinBuildHeight(); y--) {
            mutablePos.set(x, y, z);

            if (height + terrainY < calderaCutoffY) {
                if (height + terrainY <= topY) {
                    if (y <= height + terrainY) {
                        if (y > terrainY) {
                            level.setBlock(mutablePos, volcanoState, 2);
                        } else if (y > terrainY - 2) {
                            level.setBlock(mutablePos, SeaBlocks.VOLCANIC_SAND.get().defaultBlockState(), 2);
                        }
                    }
                } else if (y == crustY - 1) {
                    level.setBlock(mutablePos, volcanoState, 2);
                } else if (y <= topY) {
                    level.setBlock(mutablePos, volcanoState, 2);
                }
            } else {
                if (y <= lavaY && y > lavaBottom) {
                    level.setBlock(mutablePos, Blocks.LAVA.defaultBlockState(), 2);
                    level.getFluidTicks().schedule(ScheduledTick.probe(level.getFluidState(mutablePos).getType(), mutablePos));
                } else if (y > lavaY) {
                    level.setBlock(mutablePos, Blocks.AIR.defaultBlockState(), 2);
                } else if (y > volcanoBottom) {
                    level.setBlock(mutablePos, volcanoState, 2);
                } else {
                    level.setBlock(mutablePos, level.getBlockState(mutablePos), 2);
                }
            }
        }
    }

    private float getColumnHeight(float x, float z) {
        float distanceSquared = (float) Mth.lengthSquared(x / radiusX, z / radiusZ);
        if (distanceSquared >= 1.0F) {
            return Float.NaN;
        }
        float noiseValue = (float) Math.abs(noise.noise(x * 0.21 + 0.01, 0.0, z * 0.21 + 0.01)) * 0.45F + 1.0F;
        return STEEPNESS / distanceSquared * noiseValue - STEEPNESS - 2.0F;
    }
}