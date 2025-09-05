package com.peeko32213.seafarer.worldgen.feature.corals;

import com.mojang.serialization.Codec;
import com.peeko32213.seafarer.worldgen.feature.WarmCoralFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WarmCoralMushroomFeature extends WarmCoralFeature {

   public WarmCoralMushroomFeature(Codec<NoneFeatureConfiguration> configuration) {
      super(configuration);
   }

   protected boolean placeFeature(LevelAccessor level, RandomSource random, BlockPos pos, BlockState state) {
      int i = random.nextInt(3) + 3;
      int j = random.nextInt(3) + 3;
      int k = random.nextInt(3) + 3;
      int l = random.nextInt(3) + 1;
      BlockPos.MutableBlockPos mutable = pos.mutable();

      for (int i1 = 0; i1 <= j; ++i1) {
         for (int j1 = 0; j1 <= i; ++j1) {
            for (int k1 = 0; k1 <= k; ++k1) {
               mutable.set(i1 + pos.getX(), j1 + pos.getY(), k1 + pos.getZ());
               mutable.move(Direction.DOWN, l);
               if ((i1 != 0 && i1 != j || j1 != 0 && j1 != i) && (k1 != 0 && k1 != k || j1 != 0 && j1 != i) && (i1 != 0 && i1 != j || k1 != 0 && k1 != k) && (i1 == 0 || i1 == j || j1 == 0 || j1 == i || k1 == 0 || k1 == k) && !(random.nextFloat() < 0.1F) && !this.placeCoralBlock(level, random, mutable, state)) {
               }
            }
         }
      }
      return true;
   }
}