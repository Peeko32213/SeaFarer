package com.peeko32213.seafarer.entities.pose;

import net.minecraft.world.entity.Pose;

public enum SeafarerPoses {

    ROLLING,
    LOOPING;

    public Pose get() {
        return Pose.valueOf(this.name());
    }
}
