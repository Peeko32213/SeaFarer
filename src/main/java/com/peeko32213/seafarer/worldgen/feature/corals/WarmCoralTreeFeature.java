package com.peeko32213.seafarer.worldgen.feature.corals;

import com.mojang.serialization.Codec;
import java.util.List;

import com.peeko32213.seafarer.worldgen.feature.WarmCoralFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WarmCoralTreeFeature extends WarmCoralFeature {

   public WarmCoralTreeFeature(Codec<NoneFeatureConfiguration> configuration) {
      super(configuration);
   }

   protected boolean placeFeature(LevelAccessor level, RandomSource random, BlockPos pos, BlockState state) {
      BlockPos.MutableBlockPos mutable = pos.mutable();
      int i = random.nextInt(3) + 1;

      for (int j = 0; j < i; ++j) {
         if (!this.placeCoralBlock(level, random, mutable, state)) {
            return true;
         }
         mutable.move(Direction.UP);
      }

      BlockPos blockpos = mutable.immutable();
      int k = random.nextInt(3) + 2;
      List<Direction> list = Direction.Plane.HORIZONTAL.shuffledCopy(random);

      for (Direction direction : list.subList(0, k)) {
         mutable.set(blockpos);
         mutable.move(direction);
         int l = random.nextInt(5) + 2;
         int i1 = 0;

         for (int j1 = 0; j1 < l && this.placeCoralBlock(level, random, mutable, state); ++j1) {
            ++i1;
            mutable.move(Direction.UP);
            if (j1 == 0 || i1 >= 2 && random.nextFloat() < 0.25F) {
               mutable.move(direction);
               i1 = 0;
            }
         }
      }

      return true;
   }
}