package com.peeko32213.seafarer.common.world.feature;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.peeko32213.seafarer.common.world.feature.util.FastNoiseLite;
import com.peeko32213.seafarer.core.registry.SFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.slf4j.Logger;

public class AlgaeBoulderFeature extends Feature<NoneFeatureConfiguration> {
    private static final Logger LOGGER = LogUtils.getLogger();

    public AlgaeBoulderFeature(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    /**
     * Places the given feature at the given location.
     * During world generation, features are provided with a 3x3 region of chunks, centered on the chunk being generated,
     * that they can safely generate into.
     *
     * @param pContext A context object with a reference to the level and the position the feature is being placed at
     */
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        BlockPos blockpos = context.origin();
        RandomSource random = context.random();
        FastNoiseLite noise = createNoise(worldgenlevel.getSeed() + random.nextLong(), random.nextFloat());
        int randomNr = random.nextInt(0, 50);
        boolean placeFeature = randomNr < 5;
        if(!placeFeature){
           return false;
        }


        double middleBlockZ = worldgenlevel.getChunk(blockpos.getX() >> 4, blockpos.getZ() >> 4).getPos().getMiddleBlockZ();
        double middleBlockX = worldgenlevel.getChunk(blockpos.getX() >> 4, blockpos.getZ() >> 4).getPos().getMiddleBlockX();
        double cornerBlockZ = worldgenlevel.getChunk(blockpos.getX() >> 4, blockpos.getZ() >> 4).getPos().getMinBlockZ();
        double cornerBlockX = worldgenlevel.getChunk(blockpos.getX() >> 4, blockpos.getZ() >> 4).getPos().getMinBlockX();


        BlockPos blockPosMid =  BlockPos.containing(middleBlockX, worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, (int) middleBlockX, (int) middleBlockZ), middleBlockZ);
        BlockPos blockPosCorner =  BlockPos.containing(cornerBlockX, worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, (int) cornerBlockX, (int) cornerBlockZ), cornerBlockZ);

        int radius = random.nextInt(5, 25);

        addBushes(worldgenlevel, random, blockPosMid, noise, radius);
        createSphere(worldgenlevel, random, blockPosMid, noise);
        return true;
    }


    public static void createSphere(WorldGenLevel worldgenlevel, RandomSource rand, BlockPos origin, FastNoiseLite noise) {
        int height = rand.nextInt(2, 4);
        int radius = height;
        BlockState block = Blocks.MOSSY_COBBLESTONE.defaultBlockState();
        BlockState block2 = SFBlocks.ALGAE_BLOCK.get().defaultBlockState();
        origin = origin.offset(0,(-radius/2)-1,0);

        for (int x = -radius; x < radius; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = -radius; z < radius; z++) {
                    BlockPos pos = origin.offset(x, y, z);
                    BlockPos pos2 = origin.offset(x, -y, z);
                    double distance = distance(x, y, z, radius, height, radius);
                    float f = noise.GetNoise(x, y, z);
                    if (distance < 1) {
                        if (f < 0.5) {
                            worldgenlevel.setBlock(pos, block, 3);
                            worldgenlevel.setBlock(pos2, block, 3);
                        } else if( f > 0.6 &&  f < 0.8){
                            worldgenlevel.setBlock(pos, block2, 3);
                            worldgenlevel.setBlock(pos2, block2, 3);
                        }
                    }
                }
            }
        }
    }

    public static void addBushes(WorldGenLevel worldgenlevel, RandomSource rand, BlockPos origin, FastNoiseLite noise, int radius) {
        BlockState block = SFBlocks.ALGAE_PLANT.get().defaultBlockState();
        for (int x = -radius; x < radius; x++) {
            for (int z = -radius; z < radius; z++) {
                BlockPos pos = origin.offset(x, 0, z);
                double yHeight = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, (int) pos.getX(), (int) pos.getZ());
                BlockPos pos2 =  BlockPos.containing(pos.getX(), yHeight, pos.getZ());
                double distance = distance(x, 0, z, radius, 1, radius);
                float f = noise.GetNoise(x, (float) yHeight, z);
                if (distance < 1) {
                    boolean isCorrectBlock = worldgenlevel.getBlockState(pos2).is(Blocks.AIR);
                    if (f > 0 && f < 0.05 && isCorrectBlock) {
                        worldgenlevel.setBlock(pos2, block, 3);
                    }
                }
            }
        }
    }


    public static double distance(double x, double y, double z, double xRadius, double yRadius, double zRadius) {
        return Mth.square((double) x / (xRadius)) + Mth.square((double) y / (yRadius)) + Mth.square((double) z / (zRadius));
    }


    private static FastNoiseLite createNoise(long seed, float frequency) {
        FastNoiseLite noise = new FastNoiseLite((int) seed);
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
        noise.SetFrequency(frequency);
        return noise;
    }
}