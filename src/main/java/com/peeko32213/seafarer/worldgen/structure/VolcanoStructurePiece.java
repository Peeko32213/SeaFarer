package com.peeko32213.seafarer.worldgen.structure;

import com.peeko32213.seafarer.registry.SeaBlocks;
import com.peeko32213.seafarer.registry.SeaStructurePieces;
import com.peeko32213.seafarer.utils.SimpleRadialNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.material.Fluids;

public class VolcanoStructurePiece extends StructurePiece {

    private final SimpleRadialNoise radiusNoise;

    private final int height;
    private final int radius;
    private final int lavaHeight;
    private final int lavaTubeLength;
    private final int baseY;
    private final int chamberHeight;
    private final boolean underwater;

    private final int centerX;
    private final int centerZ;

    VolcanoStructurePiece(RandomSource random, int centerX, int centerZ, IntProvider heightProvider, int baseY, boolean thinIfTall) {
        super(SeaStructurePieces.VOLCANO.get(), 0, null);
        this.setOrientation(null);

        this.centerX = centerX;
        this.centerZ = centerZ;

        radiusNoise = new SimpleRadialNoise(16, random.nextLong(), 0.75, 0.5);

        this.height = heightProvider.sample(random);
        this.baseY = baseY;

        radius = random.nextInt(height / 2) + height / 2;

        lavaHeight = (int) (height * shape(0.2));
        lavaTubeLength = Math.min(22, baseY - 20);

        // Make sure that the chamber doesn't go too deep
        int potentialChamberHeight = random.nextInt(Math.max(baseY - lavaTubeLength - 10, 0) + 1);
        chamberHeight = Math.max(potentialChamberHeight, 10);

        underwater = baseY + lavaHeight < 64;

        int radiusBound = Mth.ceil(radius * 1.5);

        this.boundingBox = new BoundingBox(centerX - radiusBound, 1, centerZ - radiusBound, centerX + radiusBound, 62 + height, centerZ + radiusBound);
    }

    public VolcanoStructurePiece(StructurePieceSerializationContext context, CompoundTag compoundTag) {
        super(SeaStructurePieces.VOLCANO.get(), compoundTag);

        radiusNoise = new SimpleRadialNoise(16, compoundTag.getLong("VRN"), 0.75, 0.5);

        height = compoundTag.getInt("VH");
        radius = compoundTag.getInt("VR");
        lavaHeight = compoundTag.getInt("VL");
        lavaTubeLength = compoundTag.getInt("VLT");
        baseY = compoundTag.getInt("Y");
        chamberHeight = compoundTag.getInt("VCH");
        underwater = compoundTag.getBoolean("VU");

        centerX = compoundTag.getInt("CX");
        centerZ = compoundTag.getInt("CZ");
    }

    private static double positionToAngle(double dist, double dX, double dZ) {
        double angle = 0.5 * Math.asin(dX / dist) / Math.PI + 0.25;

        if (dZ < 0) {
            angle = 1.0 - angle;
        }

        return angle;
    }

    private static double shape(double scaled) {
        scaled = Math.max(scaled, 0.0);

        double curve = curve(1.0 - scaled);

        if (scaled <= 0.3) {
            curve -= (0.3 - scaled) * 2;
        }

        return curve;
    }

    private static double curve(double progress) {
        progress = Math.min(progress, 1.0);

        if (progress < 0.1) {
            return 2 * (progress - 0.1);
        } else if (progress <= 0.5) {
            return 2 * progress * progress;
        } else {
            double progressUntil = 1.0 - progress;
            return 1 - 2 * progressUntil * progressUntil;
        }
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag compoundTag) {
        compoundTag.putLong("VRN", radiusNoise.getSeed());
        compoundTag.putInt("VH", height);
        compoundTag.putInt("VR", radius);
        compoundTag.putInt("VL", lavaHeight);
        compoundTag.putInt("VLT", lavaTubeLength);
        compoundTag.putInt("Y", baseY);
        compoundTag.putInt("VCH", chamberHeight);
        compoundTag.putBoolean("VU", underwater);
        compoundTag.putInt("CX", centerX);
        compoundTag.putInt("CZ", centerZ);
    }

    @Override
    public void postProcess(WorldGenLevel world, StructureManager structureManager, ChunkGenerator generator, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos blockPos) {
        if (box.minY() > this.boundingBox.minY() || box.maxY() < this.boundingBox.maxY()) {
            throw new IllegalArgumentException("Unexpected bounding box Y range in " + box + ", the Y range is smaller than the one we expected");
        }

        int chamberMiddle = baseY - lavaTubeLength - chamberHeight / 2;

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int z = box.minZ(); z <= box.maxZ(); z++) {
            for (int x = box.minX(); x <= box.maxX(); x++) {
                int dX = centerX - x;
                int dZ = centerZ - z;

                double dist = Math.sqrt(dZ * dZ + dX * dX);
                double angle = positionToAngle(dist, dX, dZ);

                double noise = radiusNoise.sample(angle);

                double scaled = (dist / radius) * noise;
                int columnHeight = (int) (shape(scaled) * height);
                BlockState top = SeaBlocks.VOLCANIC_SANDSTONE.get().defaultBlockState();

                if (columnHeight + baseY <= 0) {
                    continue;
                }

                if (scaled > 0.2 && scaled < 0.35) {
                    columnHeight += random.nextInt(2);
                } else if (scaled >= 0.35 && scaled <= 0.8 && random.nextInt(4) == 0) {
                    columnHeight += 1;
                }

                if (scaled > 0.3) {
                    top = SeaBlocks.VOLCANIC_SANDSTONE.get().defaultBlockState();
                }

                int startY = world.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR_WG, new BlockPos(x, 0, z)).getY() - baseY;

                for (int dY = startY; dY < columnHeight - 1; dY++) {
                    pos.set(x, baseY + dY, z);

                    if (world.getBlockState(pos).isAir() || world.getFluidState(pos).getType() == Fluids.WATER) {
                        world.setBlock(pos, SeaBlocks.VOLCANIC_SANDSTONE.get().defaultBlockState(), 2);
                    }
                }

                if ((Math.abs(dX) == 1 && Math.abs(dZ) == 1) || (Math.abs(dX) == 2 && dZ == 0) || (dX == 0 && Math.abs(dZ) == 2)) {
                    startY = chamberMiddle;
                    int endY = baseY + columnHeight - 1;

                    for (int y = startY; y < endY; y++) {
                        pos.set(x, y, z);

                        world.setBlock(pos, SeaBlocks.VOLCANIC_SANDSTONE.get().defaultBlockState(), 2);
                    }

                    pos.move(Direction.UP);
                    world.setBlock(pos, Blocks.LAVA.defaultBlockState(), 2);
                }

                pos.set(x, baseY + columnHeight, z);

                pos.move(Direction.DOWN);

                if ((world.getBlockState(pos).isAir() || world.getFluidState(pos).getType() == Fluids.WATER) && startY < columnHeight) {
                    world.setBlock(pos, top, 2);
                }

                if (scaled <= 0.3) {
                    for (int dY = columnHeight; dY < lavaHeight; dY++) {
                        pos.set(x, baseY + dY, z);
                        world.setBlock(pos, Blocks.LAVA.defaultBlockState(), 2);
                    }
                }
            }
        }
    }
}