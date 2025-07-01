package com.peeko32213.seafarer.entities.misc.interfaces;

public interface ISemiAquatic {

    boolean shouldEnterWater();

    boolean shouldLeaveWater();

    boolean shouldStopMoving();

    int getWaterSearchRange();
}
