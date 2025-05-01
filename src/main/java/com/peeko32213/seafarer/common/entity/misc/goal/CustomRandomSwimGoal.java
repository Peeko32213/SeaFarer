package com.peeko32213.seafarer.common.entity.misc.goal;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class CustomRandomSwimGoal extends RandomStrollGoal {

    PathfinderMob fish;
    Vec3 wantedPos;

    int radius;
    int height;
    int prox;

    public CustomRandomSwimGoal(PathfinderMob fish, double spdmultiplier, int interval, int radius, int height, int proximity) {
        super(fish, spdmultiplier, interval);
        this.fish = fish;
        this.radius = radius;
        this.height = height;
        this.prox = proximity;
    }

    @Override
    public boolean canUse() {
        boolean canUse =super.canUse() && fish.isInWater();
        return canUse;
    }

    @Override
    public boolean canContinueToUse() {
        wantedPos = new Vec3(this.wantedX, this.wantedY, this.wantedZ);
        return super.canContinueToUse() && fish.isInWater() && !(this.wantedPos.distanceTo(this.fish.position()) <= this.fish.getBbWidth() * prox);
    }

    public void tick() {
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Nullable
    protected Vec3 getPosition() {
        return BehaviorUtils.getRandomSwimmablePos(this.mob, radius, height);
    }
}
