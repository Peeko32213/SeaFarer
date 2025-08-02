package com.peeko32213.seafarer.worldgen.feature;

import com.mojang.serialization.Codec;
import com.peeko32213.seafarer.worldgen.feature.util.FastNoiseLite;
import com.peeko32213.seafarer.registry.SeafarerBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;

import static net.minecraft.world.level.block.MultifaceBlock.getFaceProperty;

public class AlgaeBoulderFeature extends Feature<NoneFeatureConfiguration> {

    public AlgaeBoulderFeature(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    /**
     * Places the given feature at the given location.
     * During world generation, features are provided with a 3x3 region of chunks, centered on the chunk being generated,
     * that they can safely generate into.
     *
     * @param //pContext A context object with a reference to the level and the position the feature is being placed at
     */
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        BlockPos blockpos = context.origin();
        RandomSource random = context.random();
        FastNoiseLite noise = createNoise(worldgenlevel.getSeed(), 0.05F);
        FastNoiseLite noise2 = createNoise(worldgenlevel.getSeed(), 0.4F);
        FastNoiseLite noise3 = createNoise(worldgenlevel.getSeed(), 0.5F);
        //int randomNr = random.nextInt(0, 50);
        //boolean placeFeature = randomNr < 5;
        //if(!placeFeature){
        //   return false;
        //}

        double middleBlockZ = worldgenlevel.getChunk(blockpos.getX() >> 4, blockpos.getZ() >> 4).getPos().getMiddleBlockZ();
        double middleBlockX = worldgenlevel.getChunk(blockpos.getX() >> 4, blockpos.getZ() >> 4).getPos().getMiddleBlockX();
        double cornerBlockZ = worldgenlevel.getChunk(blockpos.getX() >> 4, blockpos.getZ() >> 4).getPos().getMinBlockZ();
        double cornerBlockX = worldgenlevel.getChunk(blockpos.getX() >> 4, blockpos.getZ() >> 4).getPos().getMinBlockX();


        BlockPos blockPosMid =  BlockPos.containing(middleBlockX, worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, (int) middleBlockX, (int) middleBlockZ), middleBlockZ);
        BlockPos blockPosCorner =  BlockPos.containing(cornerBlockX, worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, (int) cornerBlockX, (int) cornerBlockZ), cornerBlockZ);

        int radius = random.nextInt(5, 10);
        createSphere(worldgenlevel, random, blockPosMid, noise);
        addBushes(worldgenlevel, random, blockPosMid, noise3, radius);
        return true;
    }


    public static void createSphere(WorldGenLevel worldgenlevel, RandomSource rand, BlockPos origin, FastNoiseLite noise) {
        int height = rand.nextInt(2, 4);
        int radius = height;
        BlockState block = SeafarerBlocks.ALGAE_COBBLESTONE.get().defaultBlockState();
        BlockState block2 = SeafarerBlocks.ALGAE_BLOCK.get().defaultBlockState();
        BlockState block3 = Blocks.COBBLESTONE.defaultBlockState();
        //BlockState block3 = SFBlocks.GRAVELY_SAND.get().defaultBlockState();
        BlockState block4 = Blocks.SAND.defaultBlockState();
        origin = origin.offset(0,0,0);

        for (int x = -radius; x < radius; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = -radius; z < radius; z++) {
                    BlockPos pos = origin.offset(x, y, z);
                    BlockPos pos2 = origin.offset(x, -y, z);
                    double distance = distance(x, y, z, radius, height, radius);
                    float f = noise.GetNoise(x, y, z);
                    if (distance < 1) {
                        if (f < 0.3 && f >= -0.5) {
                            worldgenlevel.setBlock(pos, block, 3);
                            worldgenlevel.setBlock(pos2, block, 3);
                        } else if( f >= 0.3 &&  f < 0.5){
                            worldgenlevel.setBlock(pos, block2, 3);
                            worldgenlevel.setBlock(pos2, block2, 3);
                        }
                        else if( f >= 0.2 &&  f < 0.4){
                            worldgenlevel.setBlock(pos, block3, 3);
                            worldgenlevel.setBlock(pos2, block3, 3);
                        }
                        else if( f >= 0.7 &&  f < 0.9){
                            worldgenlevel.setBlock(pos, block4, 3);
                            worldgenlevel.setBlock(pos2, block4, 3);
                        }
                    }
                }
            }
        }
    }

    public static void addBushes(WorldGenLevel worldgenlevel, RandomSource rand, BlockPos origin, FastNoiseLite noise, int radius) {
        BlockState block = SeafarerBlocks.ALGAE_PLANT.get().defaultBlockState();
        BlockState block2 = SeafarerBlocks.ALGAE_CARPET.get().defaultBlockState().setValue(getFaceProperty(Direction.DOWN), Boolean.valueOf(true));

        for (int x = -radius; x < radius; x++) {
            for (int z = -radius; z < radius; z++) {
                BlockPos pos = origin.offset(x, 0, z);
                double yHeight = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, (int) pos.getX(), (int) pos.getZ());
                BlockPos pos2 =  BlockPos.containing(pos.getX(), yHeight, pos.getZ());
                double distance = distance(x, 0, z, radius, 1, radius);
                float f = noise.GetNoise(x, (float) yHeight, z);
                if (distance < 1) {
                    boolean isCorrectBlock = worldgenlevel.getBlockState(pos2).is(Blocks.AIR) || !worldgenlevel.getFluidState(pos2).isEmpty() || worldgenlevel.getBlockState(pos2.below()).is(BlockTags.BASE_STONE_OVERWORLD) || worldgenlevel.getBlockState(pos2.below()).is(SeafarerBlocks.ALGAE_COBBLESTONE.get());
                    if (f > 0 && f < 0.5 && isCorrectBlock) {
                        block = block.setValue(BlockStateProperties.WATERLOGGED, worldgenlevel.getFluidState(pos2).is(Fluids.WATER));
                        worldgenlevel.setBlock(pos2, block, 3);
                    }
                    if (f >= 0.5 && f < 1 && isCorrectBlock) {
                        block2 = block2.setValue(BlockStateProperties.WATERLOGGED, worldgenlevel.getFluidState(pos2).is(Fluids.WATER));
                        worldgenlevel.setBlock(pos2, block2, 3);
                    }
                }
            }
        }
    }

    public static void changeTerrain(WorldGenLevel worldgenlevel, RandomSource rand, BlockPos origin, FastNoiseLite noise, int radius) {
        BlockState block = SeafarerBlocks.GRAVELY_SAND.get().defaultBlockState();
        BlockState block2 = SeafarerBlocks.ROCKY_SAND.get().defaultBlockState();
        BlockState block3 = Blocks.COARSE_DIRT.defaultBlockState();
        for (int x = -radius; x < radius; x++) {
            for (int z = -radius; z < radius; z++) {
                BlockPos pos = origin.offset(x, 0, z);
                double yHeight = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, (int) pos.getX(), (int) pos.getZ()) - 1;
                BlockPos pos2 =  BlockPos.containing(pos.getX(), yHeight, pos.getZ());
                double distance = distance(x, 0, z, radius, 1, radius);
                float f = noise.GetNoise(x, (float) yHeight, z);
                if (distance < 1) {
                    boolean isCorrectBlock = worldgenlevel.getBlockState(pos2).is(BlockTags.DIRT) || worldgenlevel.getBlockState(pos2).is(BlockTags.SAND) ||  worldgenlevel.getBlockState(pos2).is(Blocks.GRAVEL);
                    if (f < 0 && f >= -0.4 && isCorrectBlock) {
                        worldgenlevel.setBlock(pos2, block, 3);
                    } else if(f > 0 && f < 0.2 && isCorrectBlock) {
                        worldgenlevel.setBlock(pos2, block2, 3);
                    }
                }
            }
        }
    }

    public static double distance(double x, double y, double z, double xRadius, double yRadius, double zRadius) {
        return Mth.square(x / (xRadius)) + Mth.square(y / (yRadius)) + Mth.square(z / (zRadius));
    }

    private static FastNoiseLite createNoise(long seed, float frequency) {
        FastNoiseLite noise = new FastNoiseLite((int) seed);
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
        noise.SetFrequency(frequency);
        return noise;
    }
}