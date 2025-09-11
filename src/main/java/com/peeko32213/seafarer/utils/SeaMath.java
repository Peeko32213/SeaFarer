package com.peeko32213.seafarer.utils;

public class SeaMath {

    public static float sampleNoise3D(float x, float y, float z, float simplexSampleRate) {
        return (float) ((SeaSimplexNoise.noise((x + simplexSampleRate) / simplexSampleRate, (y + simplexSampleRate) / simplexSampleRate, (z + simplexSampleRate) / simplexSampleRate)));
    }
}
