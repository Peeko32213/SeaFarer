package com.peeko32213.seafarer.entities.misc.goal;

import com.mojang.datafixers.DataFixUtils;
import com.peeko32213.seafarer.entities.misc.AbstractCustomSchoolingFish;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class CustomFollowLeaderGoal extends Goal {
    private final AbstractCustomSchoolingFish mob;
    private int timeToRecalcPath;
    private int nextStartTick;

    public CustomFollowLeaderGoal(AbstractCustomSchoolingFish p_25249_) {
        this.mob = p_25249_;
        this.nextStartTick = this.nextStartTick(p_25249_);
    }

    protected int nextStartTick(AbstractCustomSchoolingFish p_25252_) {
        return reducedTickDelay(200 + p_25252_.getRandom().nextInt(200) % 20);
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
            Predicate<AbstractCustomSchoolingFish> predicate = (p_25258_) -> {
                return p_25258_.canBeFollowed() || !p_25258_.isFollower();
            };
            List<? extends AbstractCustomSchoolingFish> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(20.0D, 20.0D, 20.0D), predicate);
            AbstractCustomSchoolingFish schoolingWaterAnimal = DataFixUtils.orElse(list.stream().filter(AbstractCustomSchoolingFish::canBeFollowed).findAny(), this.mob);
            schoolingWaterAnimal.addFollowers(list.stream().filter((p_25255_) -> {
                return !p_25255_.isFollower();
            }));
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
