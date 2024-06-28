package com.peeko32213.seafarer.common.entity.goal.codec;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peeko32213.seafarer.common.entity.goal.LeaveWaterGoal;
import com.peeko32213.seafarer.common.entity.goal.SemiAquaticSwimmingGoal;
import com.peeko32213.seafarer.common.entity.misc.interfaces.SemiAquatic;
import com.peeko32213.seafarer.core.registry.SFGoals;
import com.scouter.goalsmith.codec.NullableFieldCodec;
import com.scouter.goalsmith.data.GoalCodec;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;
import org.slf4j.Logger;

public class SemiAquaticSwimmingGoalCodec implements GoalCodec {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final Codec<SemiAquaticSwimmingGoalCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("goal_priority").forGetter(SemiAquaticSwimmingGoalCodec::getGoalPriority),
            NullableFieldCodec.makeDefaultableField("speed_modifier", Codec.DOUBLE, 1.0D).forGetter(codec -> codec.speedModifier),
            NullableFieldCodec.makeDefaultableField("chance", Codec.INT, 30).forGetter(codec -> codec.chance)
    ).apply(instance, SemiAquaticSwimmingGoalCodec::new));
    private final int goalPriority;

    private final double speedModifier;
    private final int chance;
    public SemiAquaticSwimmingGoalCodec(int goalPriority, double speedModifier, int chance) {
        this.goalPriority = goalPriority;
        this.speedModifier = speedModifier;
        this.chance = chance;
    }


    public int getGoalPriority() {
        return goalPriority;
    }


    @Override
    public Goal addGoal(PathfinderMob pathfinderMob) {
        if(pathfinderMob instanceof SemiAquatic) {
            SemiAquaticSwimmingGoal goal = new SemiAquaticSwimmingGoal(pathfinderMob, speedModifier, chance);
            pathfinderMob.goalSelector.addGoal(goalPriority, goal);
            return goal;
        }
        LOGGER.error("Unsupported Operation, Tried adding SemiAquaticSwimmingGoal to non-SemiAquatic!");
        return null ;
    }

    @Override
    public Codec<? extends GoalCodec> codec() {
        return SFGoals.SEMI_AQUATIC_SWIMMING_GOAL.get();
    }
}
