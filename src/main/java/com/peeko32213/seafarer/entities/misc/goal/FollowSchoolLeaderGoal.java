package com.peeko32213.seafarer.entities.misc.goal;

import com.mojang.datafixers.DataFixUtils;
import com.peeko32213.seafarer.entities.base.EnhancedSchoolingWaterAnimal;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class FollowSchoolLeaderGoal extends Goal {

    private final EnhancedSchoolingWaterAnimal mob;
    private int timeToRecalcPath;
    private int nextStartTick;

    public FollowSchoolLeaderGoal(EnhancedSchoolingWaterAnimal fish) {
        this.mob = fish;
        this.nextStartTick = this.nextStartTick(fish);
    }

    protected int nextStartTick(EnhancedSchoolingWaterAnimal fish) {
        return reducedTickDelay(200 + fish.getRandom().nextInt(200) % 20);
    }

    public boolean canUse() {
        if (this.mob.hasFollowers()) {
            return false;
        } else if (this.mob.isFollower()) {
            return true;
        } else if (this.nextStartTick > 0) {
            --this.nextStartTick;
            return false;
        } else {
            this.nextStartTick = this.nextStartTick(this.mob);
            Predicate<EnhancedSchoolingWaterAnimal> predicate = (fish1) -> fish1.canBeFollowed() || !fish1.isFollower();
            List<? extends EnhancedSchoolingWaterAnimal> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(10.0D, 10.0D, 10.0D), predicate);
            EnhancedSchoolingWaterAnimal schoolingWaterAnimal = DataFixUtils.orElse(list.stream().filter(EnhancedSchoolingWaterAnimal::canBeFollowed).findAny(), this.mob);
            schoolingWaterAnimal.addFollowers(list.stream().filter((fish2) -> !fish2.isFollower()));
            return this.mob.isFollower();
        }
    }

    public boolean canContinueToUse() {
        return this.mob.isFollower() && this.mob.inRangeOfLeader();
    }

    public void start() {
        this.timeToRecalcPath = 0;
    }

    public void stop() {
        this.mob.stopFollowing();
    }

    public void tick() {
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = this.adjustedTickDelay(10);
            this.mob.pathToLeader();
        }
    }
}
