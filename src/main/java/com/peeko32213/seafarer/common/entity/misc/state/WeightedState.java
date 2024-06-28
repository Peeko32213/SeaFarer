package com.peeko32213.seafarer.common.entity.misc.state;

public class WeightedState<T> {
    private T item;
    private int weight;

    public static <T> WeightedState<T> of(T item, int weight) {
        return new WeightedState<>(item, weight);
    }

    public WeightedState(T item, int weight) {
        this.item = item;
        this.weight = weight;
    }

    public T getItem() {
        return item;
    }

    public int getWeight() {
        return weight;
    }
}
