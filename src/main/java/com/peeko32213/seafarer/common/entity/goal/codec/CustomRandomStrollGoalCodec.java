package com.peeko32213.seafarer.common.entity.goal.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.goal.CustomRandomStrollGoal;
import com.peeko32213.seafarer.core.registry.SFGoals;
import com.scouter.goalsmith.codec.NullableFieldCodec;
import com.scouter.goalsmith.data.GoalCodec;
import com.scouter.goalsmith.data.goalcodec.RandomStrollGoalCodec;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class CustomRandomStrollGoalCodec implements GoalCodec {


    public static final Codec<CustomRandomStrollGoalCodec> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.INT.fieldOf("goal_priority").forGetter(codec -> codec.goalPriority),
            NullableFieldCodec.makeDefaultableField("speed_modifier", Codec.DOUBLE, 1.0D).forGetter(codec -> codec.speedModifier),
            NullableFieldCodec.makeDefaultableField("chance", Codec.INT, 30).forGetter(codec -> codec.chance),
            Codec.INT.fieldOf("xz_range").forGetter(codec -> codec.xzRange),
            Codec.INT.fieldOf("y_range").forGetter(codec -> codec.yRange)
    ).apply(builder, CustomRandomStrollGoalCodec::new));

    private final double speedModifier;
    private final int goalPriority;
    private final int xzRange;
    private final int yRange;
    private final int chance;

    public CustomRandomStrollGoalCodec(int goalPriority, double speedModifier, int chance, int xzRange, int yRange) {
        this.speedModifier = speedModifier;
        this.goalPriority = goalPriority;
        this.xzRange = xzRange;
        this.yRange = yRange;
        this.chance = chance;
    }

    @Override
    public Goal addGoal(PathfinderMob pathfinderMob) {
        CustomRandomStrollGoal goal = new CustomRandomStrollGoal(pathfinderMob, chance, speedModifier, xzRange, yRange);
        pathfinderMob.goalSelector.addGoal(goalPriority, goal);
        return goal;
    }

    @Override
    public Codec<? extends GoalCodec> codec() {
        return SFGoals.CUSTOM_RANDOM_STROLL_GOAL.get();
    }
}
