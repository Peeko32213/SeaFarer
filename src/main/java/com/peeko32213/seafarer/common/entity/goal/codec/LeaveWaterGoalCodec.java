package com.peeko32213.seafarer.common.entity.goal.codec;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peeko32213.seafarer.common.entity.goal.FindWaterGoal;
import com.peeko32213.seafarer.common.entity.goal.LeaveWaterGoal;
import com.peeko32213.seafarer.common.entity.misc.interfaces.SemiAquatic;
import com.peeko32213.seafarer.core.registry.SFGoals;
import com.scouter.goalsmith.data.GoalCodec;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import org.slf4j.Logger;

public class LeaveWaterGoalCodec implements GoalCodec {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final Codec<LeaveWaterGoalCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("goal_priority").forGetter(LeaveWaterGoalCodec::getGoalPriority)
    ).apply(instance, LeaveWaterGoalCodec::new));
    private final int goalPriority;

    public LeaveWaterGoalCodec(int goalPriority) {
        this.goalPriority = goalPriority;
    }

    public int getGoalPriority() {
        return goalPriority;
    }

    @Override
    public Goal addGoal(PathfinderMob pathfinderMob) {
        if(pathfinderMob instanceof SemiAquatic) {
            LeaveWaterGoal goal = new LeaveWaterGoal(pathfinderMob);
            pathfinderMob.goalSelector.addGoal(goalPriority, goal);
            return goal;
        }
        LOGGER.error("Unsupported Operation, Tried adding LeaveWaterGoal to non-SemiAquatic!");
        return null ;
    }

    @Override
    public Codec<? extends GoalCodec> codec() {
        return SFGoals.LEAVE_WATER_GOAL.get();
    }
}
