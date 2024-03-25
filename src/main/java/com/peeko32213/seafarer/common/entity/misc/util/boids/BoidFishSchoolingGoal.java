package com.peeko32213.seafarer.common.entity.misc.util.boids;

import com.peeko32213.seafarer.common.entity.misc.EntitySFBoidFish;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class BoidFishSchoolingGoal extends Goal {

    public final float separationInfluence;
    public final float separationRange;
    public final float alignmentInfluence;
    public final float cohesionInfluence;
    private final EntitySFBoidFish mob;

    public BoidFishSchoolingGoal(EntitySFBoidFish mob, float separationInfluence, float separationRange, float alignmentInfluence, float cohesionInfluence) {
        this.mob = mob;
        this.separationInfluence = separationInfluence;
        this.separationRange = separationRange;
        this.alignmentInfluence = alignmentInfluence;
        this.cohesionInfluence = cohesionInfluence;
    }

    @Override
    public boolean canUse() {
        return mob.isInWaterOrBubble() && (mob.isFollower() || mob.hasFollowers());
    }

    public void tick() {
        mob.addDeltaMovement(separation());
        mob.addDeltaMovement(random());
        mob.addDeltaMovement(cohesion());
        mob.addDeltaMovement(alignment());
    }

    public Vec3 random() {
        var velocity = mob.getDeltaMovement();

        if (Mth.abs((float) velocity.x) < 0.1 && Mth.abs((float) velocity.z) < 0.1)
            return new Vec3(randomSign() * 0.2, 0, randomSign() * 0.2);

        return Vec3.ZERO;
    }

    public int randomSign() {
        var isNegative = mob.getRandom().nextBoolean();

        if (isNegative) {
            return -1;
        }

        return 1;
    }

    public Vec3 separation() {
        var c = Vec3.ZERO;

        for (EntitySFBoidFish nearbyMob : mob.ownSchool) {
            if ((nearbyMob.position().subtract(mob.position()).length()) < separationRange && !nearbyMob.isDeadOrDying()) {
                c = c.subtract(nearbyMob.position().subtract(mob.position()));
            }
        }
        if (mob.isFollower()) {
            for (EntitySFBoidFish nearbyMob : mob.leader.ownSchool) {
                if ((nearbyMob.position().subtract(mob.position()).length()) < separationRange && !nearbyMob.isDeadOrDying()) {
                    c = c.subtract(nearbyMob.position().subtract(mob.position()));
                }
            }
        }

        return c.scale(separationInfluence);
    }

    public Vec3 alignment() {
        var c = Vec3.ZERO;

        for (EntitySFBoidFish nearbyMob : mob.ownSchool) {
            if (!nearbyMob.isDeadOrDying())
                c = c.add(nearbyMob.getDeltaMovement());
            c = c.scale(1f / mob.ownSchool.size());
        }
        if (mob.isFollower()) {
            for (EntitySFBoidFish nearbyMob : mob.leader.ownSchool) {
                if (!nearbyMob.isDeadOrDying())
                    c = c.add(nearbyMob.getDeltaMovement());
            }
            c = c.scale(1f / mob.leader.ownSchool.size());
        }

        c = c.subtract(mob.getDeltaMovement());
        return c.scale(alignmentInfluence);
    }

    public Vec3 cohesion() {
        var c = Vec3.ZERO;

        for (EntitySFBoidFish nearbyMob : mob.ownSchool) {
            if (!nearbyMob.isDeadOrDying())
                c = c.add(nearbyMob.position());
            c = c.scale(1f / mob.ownSchool.size());
        }
        if (mob.isFollower()) {
            for (EntitySFBoidFish nearbyMob : mob.leader.ownSchool) {
                if (!nearbyMob.isDeadOrDying())
                    c = c.add(nearbyMob.position());
            }
            c = c.scale(1f / mob.leader.ownSchool.size());
        }

        c = c.subtract(mob.position());
        return c.scale(cohesionInfluence);
    }
}
