package com.peeko32213.seafarer.common.entity.goal.codec;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peeko32213.seafarer.common.entity.goal.FindWaterGoal;
import com.peeko32213.seafarer.common.entity.goal.NocturnalSleepingGoal;
import com.peeko32213.seafarer.common.entity.misc.AbstractSleepingAnimal;
import com.peeko32213.seafarer.common.entity.misc.interfaces.SemiAquatic;
import com.peeko32213.seafarer.core.registry.SFGoals;
import com.scouter.goalsmith.data.GoalCodec;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import org.slf4j.Logger;

public class NocturnalSleepingGoalCodec implements GoalCodec {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final Codec<NocturnalSleepingGoalCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("goal_priority").forGetter(NocturnalSleepingGoalCodec::getGoalPriority)
    ).apply(instance, NocturnalSleepingGoalCodec::new));
    private final int goalPriority;

    public NocturnalSleepingGoalCodec(int goalPriority) {
        this.goalPriority = goalPriority;
    }

    public int getGoalPriority() {
        return goalPriority;
    }

    @Override
    public Goal addGoal(PathfinderMob mob) {
        if(mob instanceof AbstractSleepingAnimal abstractSleepingAnimal) {
            NocturnalSleepingGoal goal = new NocturnalSleepingGoal(abstractSleepingAnimal);
            mob.goalSelector.addGoal(goalPriority, goal);
            return goal;
        }
        LOGGER.error("Unsupported Operation, Tried adding NocturnalSleepingGoal to non-AbstractSleepingAnimal!");
        return null ;
    }

    @Override
    public Codec<? extends GoalCodec> codec() {
        return SFGoals.NOCTURNAL_SLEEPING_GOAL.get();
    }
}
