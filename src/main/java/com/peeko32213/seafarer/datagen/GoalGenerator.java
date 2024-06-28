package com.peeko32213.seafarer.datagen;

import com.peeko32213.seafarer.SeaFarer;
import com.peeko32213.seafarer.common.entity.goal.codec.*;
import com.peeko32213.seafarer.core.registry.SFEntities;
import com.scouter.goalsmith.data.goalcodec.*;
import com.scouter.goalsmith.data.goalcodec.targetgoalcodec.HurtByTargetGoalCodec;
import com.scouter.goalsmith.data.predicates.*;
import com.scouter.goalsmith.datagen.GoalDataBuilder;
import com.scouter.goalsmith.datagen.GoalDataProvider;
import com.scouter.goalsmith.util.GSTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import java.util.function.Consumer;

import static com.peeko32213.seafarer.SeaFarer.prefix;

public class GoalGenerator extends GoalDataProvider {
    public GoalGenerator(PackOutput pOutput) {
        super(pOutput, SeaFarer.MODID);
    }

    @Override
    protected void createGoalData(Consumer<GoalDataConsumer> consumer) {
        GoalDataConsumer sunfish = new GoalDataBuilder(SFEntities.SUNFISH.get())
                // .withTargetEntity(prefix("sunfish"))
                .addGoals(
                        new RandomLookAroundGoalCodec(4),
                        new LookAtEntityGoalCodec(5, GSTags.PLAYER, 6, 0.02F, false),
                        new TryFindWaterGoalCodec(0),
                        new RandomSwimmingGoalCodec(4, 0.6D, 40)
                )
                .buildGoalDataConsumer();


        GoalDataConsumer marineIguana = new GoalDataBuilder(SFEntities.MARINE_IGUANA.get())
                //.withTargetEntity(prefix("marine_iguana"))
                .addGoals(
                        new FindWaterGoalCodec(7),
                        new LeaveWaterGoalCodec(7),
                        new GrazeGoalCodec(2),
                        new SemiAquaticSwimmingGoalCodec(9, 1D, 10),
                        new CustomRandomStrollGoalCodec(3, 1, 30, 100, 34),
                        new RandomLookAroundGoalCodec(5),
                        new LookAtEntityGoalCodec(5, GSTags.PLAYER, 6, 0.02F, false)
                )
                .buildGoalDataConsumer();

        GoalDataConsumer horseshoeCrab = new GoalDataBuilder(SFEntities.HORSESHOE_CRAB.get())
                //.withTargetEntity(prefix("horseshoe_crab"))
                .addGoals(
                        new FloatGoalCodec(0),
                        new NocturnalSleepingGoalCodec(1),
                        new PanicGoalCodec(1, 1.25D, new OrPredicate(new OrPredicate(new NegatePredicate(new LastHurtByMobIsNullPredicate()), new IsFreezingPredicate()), new IsOnFirePredicate())),
                        new WaterAvoidingRandomStrollGoalCodec(6, 1D, 10),
                        new RandomLookAroundGoalCodec(8),
                        new LookAtEntityGoalCodec(7, GSTags.PLAYER, 6, 0.02F, false)
                        )
                .buildGoalDataConsumer();

        GoalDataConsumer crab = new GoalDataBuilder(SFEntities.CRAB.get())
                //.withTargetEntity(prefix("crab"))
                .addGoals(
                        new FloatGoalCodec(0),
                        new PanicGoalCodec(1, 1.25D, new OrPredicate(new OrPredicate(new NegatePredicate(new LastHurtByMobIsNullPredicate()), new IsFreezingPredicate()), new IsOnFirePredicate())),
                        new GrazeGoalCodec(2),
                        new WaterAvoidingRandomStrollGoalCodec(6, 1D, 10),
                        new RandomLookAroundGoalCodec(8),
                        new LookAtEntityGoalCodec(7, GSTags.PLAYER, 6, 0.02F, false),
                        new AvoidEntityGoalCodec(1, GSTags.PLAYER, new TruePredicate<>(),5,2.5D, 2.7D, new NoCreativeOrSpectatorPredicate()),
                        new RandomLookAroundGoalCodec(8)
                )
                .buildGoalDataConsumer();

        consumer.accept(sunfish);
        consumer.accept(marineIguana);
        consumer.accept(horseshoeCrab);
        consumer.accept(crab);
    }
}
