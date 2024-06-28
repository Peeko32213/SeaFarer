package com.peeko32213.seafarer.common.entity.goal.codec;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peeko32213.seafarer.common.entity.goal.FindWaterGoal;
import com.peeko32213.seafarer.common.entity.misc.interfaces.SemiAquatic;
import com.peeko32213.seafarer.core.registry.SFGoals;
import com.scouter.goalsmith.data.GoalCodec;
import com.scouter.goalsmith.data.GoalRegistry;
import com.scouter.goalsmith.data.goalcodec.TryFindWaterGoalCodec;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import org.slf4j.Logger;

public class FindWaterGoalCodec implements GoalCodec {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final Codec<FindWaterGoalCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("goal_priority").forGetter(FindWaterGoalCodec::getGoalPriority)
    ).apply(instance, FindWaterGoalCodec::new));
    private final int goalPriority;

    public FindWaterGoalCodec(int goalPriority) {
        this.goalPriority = goalPriority;
    }

    public int getGoalPriority() {
        return goalPriority;
    }

    @Override
    public Goal addGoal(PathfinderMob mob) {
        if(mob instanceof SemiAquatic) {
            FindWaterGoal goal = new FindWaterGoal(mob);
            mob.goalSelector.addGoal(goalPriority, goal);
            return goal;
        }
        LOGGER.error("Unsupported Operation, Tried adding FindWaterGoal to non-SemiAquatic!");
        return null ;
    }

    @Override
    public Codec<? extends GoalCodec> codec() {
        return SFGoals.FIND_WATER_GOAL.get();
    }


}