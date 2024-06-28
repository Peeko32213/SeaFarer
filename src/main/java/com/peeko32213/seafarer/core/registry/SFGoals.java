package com.peeko32213.seafarer.core.registry;

import com.mojang.serialization.Codec;
import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.goal.GrazeGoal;
import com.peeko32213.seafarer.common.entity.goal.SemiAquaticSwimmingGoal;
import com.peeko32213.seafarer.common.entity.goal.codec.*;
import com.scouter.goalsmith.GoalSmith;
import com.scouter.goalsmith.data.GoalCodec;
import com.scouter.goalsmith.data.PMRegistries;
import com.scouter.goalsmith.data.TargetGoalCodec;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SFGoals {
    public static final DeferredRegister<Codec<? extends GoalCodec>> GOAL_TYPE_SERIALIZER = DeferredRegister.create(PMRegistries.Keys.GOAL_TYPE_SERIALIZERS, SeaFarer.MODID);
    public static final DeferredRegister<Codec<? extends TargetGoalCodec>> TARGET_GOAL_TYPE_SERIALIZER = DeferredRegister.create(PMRegistries.Keys.TARGET_GOAL_TYPE_SERIALIZERS, GoalSmith.MODID);

    public static final RegistryObject<Codec<CustomRandomStrollGoalCodec>> CUSTOM_RANDOM_STROLL_GOAL = GOAL_TYPE_SERIALIZER.register("custom_random_stroll_goal", () -> CustomRandomStrollGoalCodec.CODEC);
    public static final RegistryObject<Codec<FindWaterGoalCodec>> FIND_WATER_GOAL = GOAL_TYPE_SERIALIZER.register("find_water_goal", () -> FindWaterGoalCodec.CODEC);
    public static final RegistryObject<Codec<LeaveWaterGoalCodec>> LEAVE_WATER_GOAL = GOAL_TYPE_SERIALIZER.register("leave_water_goal", () -> LeaveWaterGoalCodec.CODEC);
    public static final RegistryObject<Codec<GrazeGoalCodec>> GRAZE_GOAL = GOAL_TYPE_SERIALIZER.register("graze_goal", () -> GrazeGoalCodec.CODEC);
    public static final RegistryObject<Codec<NocturnalSleepingGoalCodec>> NOCTURNAL_SLEEPING_GOAL = GOAL_TYPE_SERIALIZER.register("nocturnal_sleeping_goal", () -> NocturnalSleepingGoalCodec.CODEC);
    public static final RegistryObject<Codec<SemiAquaticSwimmingGoalCodec>> SEMI_AQUATIC_SWIMMING_GOAL = GOAL_TYPE_SERIALIZER.register("semi_aquatic_swimming_goal", () -> SemiAquaticSwimmingGoalCodec.CODEC);


}
