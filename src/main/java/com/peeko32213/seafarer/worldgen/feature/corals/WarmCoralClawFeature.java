package com.peeko32213.seafarer.worldgen.feature.corals;

import com.mojang.serialization.Codec;
import java.util.List;
import java.util.stream.Stream;

import com.peeko32213.seafarer.worldgen.feature.WarmCoralFeature;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WarmCoralClawFeature extends WarmCoralFeature {

   public WarmCoralClawFeature(Codec<NoneFeatureConfiguration> configuration) {
      super(configuration);
   }

   protected boolean placeFeature(LevelAccessor level, RandomSource random, BlockPos pos, BlockState state) {
      if (!this.placeCoralBlock(level, random, pos, state)) {
         return false;
      } else {
         Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
         int i = random.nextInt(2) + 2;
         List<Direction> list = Util.toShuffledList(Stream.of(direction, direction.getClockWise(), direction.getCounterClockWise()), random);

         for (Direction direction1 : list.subList(0, i)) {
            BlockPos.MutableBlockPos mutable = pos.mutable();
            int j = random.nextInt(2) + 1;
            mutable.move(direction1);
            int k;
            Direction direction2;
            if (direction1 == direction) {
               direction2 = direction;
               k = random.nextInt(3) + 2;
            } else {
               mutable.move(Direction.UP);
               Direction[] adirection = new Direction[]{direction1, Direction.UP};
               direction2 = Util.getRandom(adirection, random);
               k = random.nextInt(3) + 3;
            }

            for (int l = 0; l < j && this.placeCoralBlock(level, random, mutable, state); ++l) {
               mutable.move(direction2);
            }

            mutable.move(direction2.getOpposite());
            mutable.move(Direction.UP);

            for (int i1 = 0; i1 < k; ++i1) {
               mutable.move(direction);
               if (!this.placeCoralBlock(level, random, mutable, state)) {
                  break;
               }

               if (random.nextFloat() < 0.25F) {
                  mutable.move(Direction.UP);
               }
            }
         }
         return true;
      }
   }
}