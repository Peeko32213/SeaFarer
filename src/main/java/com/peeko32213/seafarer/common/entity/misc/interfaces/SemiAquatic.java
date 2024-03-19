package com.peeko32213.seafarer.common.entity.misc.interfaces;

public interface SemiAquatic {

    boolean shouldEnterWater();

    boolean shouldLeaveWater();

    boolean shouldStopMoving();

    int getWaterSearchRange();
}
