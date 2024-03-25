package com.peeko32213.seafarer.common.entity.misc.util.boids;

import com.peeko32213.seafarer.common.entity.misc.EntitySFBoidFish;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.entity.ai.goal.Goal;

public class LimitSpeedAndLookInVelocityDirectionGoal extends Goal {
    private final EntitySFBoidFish mob;
    private final float minSpeed;
    private final float maxSpeed;

    public LimitSpeedAndLookInVelocityDirectionGoal(EntitySFBoidFish mob, float minSpeed, float maxSpeed) {
        this.mob = mob;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean canUse() {
        return  mob.isInWaterOrBubble() && (mob.isFollower() || mob.hasFollowers());
    }

    @Override
    public void tick() {
        var velocity = mob.getDeltaMovement();
        var speed = velocity.length();

        if (speed < minSpeed)
            velocity = velocity.normalize().scale(minSpeed);
        if (speed > maxSpeed)
            velocity = velocity.normalize().scale(maxSpeed);

        mob.setDeltaMovement(velocity);
        mob.lookAt(EntityAnchorArgument.Anchor.EYES, mob.position().add(velocity.scale(3)));
    }
}
