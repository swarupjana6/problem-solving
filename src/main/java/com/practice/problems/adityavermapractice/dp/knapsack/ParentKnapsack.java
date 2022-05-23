package com.practice.problems.adityavermapractice.dp.knapsack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParentKnapsack {

    public static int solve01KnapsackRecursive(List<Item> weights, int capacity) {
        return new RecursiveKnapsack().knapsack(weights, capacity, weights.size() - 1);
    }

    public static int solve01KnapsackMemoized(List<Item> weights, int capacity) {
        return new MemoizedKnapsack().knapsack(weights, capacity, weights.size() - 1);
    }

    public static int solve01KnapsackTopDown(List<Item> weights, int capacity) {
        return new TopDownKnapsack().knapsack(weights, capacity, weights.size() - 1);
    }
}

record Item(int weight, int value) {
}

interface Knapsack {
    int knapsack(List<Item> weights, int capacity, int index);
}

class RecursiveKnapsack implements Knapsack {
    @Override
    public int knapsack(List<Item> weights, int capacity, int index) {
        if (capacity == 0 || index == 0) return 0;

        Item item = weights.get(index);

        if (item.weight() > capacity) {
            int excludeWeight = knapsack(weights, capacity, index - 1);
            return excludeWeight;
        } else {
            int excludeWeight = knapsack(weights, capacity, index - 1);
            int includeWeight = item.value() + knapsack(weights, capacity - item.weight(), index - 1);
            return Math.max(excludeWeight, includeWeight);
        }
    }
}

class MemoizedKnapsack implements Knapsack {
    @Override
    public int knapsack(List<Item> weights, int capacity, int index) {
        boolean isMap = false;
        int result = 0;
        if (isMap) {
            Map<String, Integer> cache = new HashMap<>();
            result = mapCached(weights, cache, capacity, index);
        } else {
            int[][] cache = new int[capacity + 1][index + 1];
            result = arrayCached(weights, cache, capacity, index);
        }

        return result;
    }

    private int arrayCached(List<Item> weights, int[][] cache, int capacity, int index) {
        if (capacity == 0 || index == 0) {
            cache[capacity][index] = 0;
            return cache[capacity][index];
        }

        Item item = weights.get(index);
        if (capacity < item.weight()) {
            int excludeWeight = arrayCached(weights, cache, capacity, index - 1);
            cache[capacity][index] = excludeWeight;
            return cache[capacity][index];
        } else {
            int includeWeight = item.value() + arrayCached(weights, cache, capacity - item.weight(), index - 1);
            int excludeWeight = arrayCached(weights, cache, capacity, index - 1);
            cache[capacity][index] = Math.max(includeWeight, excludeWeight);
            return cache[capacity][index];
        }
    }

    private int mapCached(List<Item> weights, Map<String, Integer> cache, int capacity, int index) {
        String key = capacity + "~" + index;
        if (capacity == 0 || index == 0) return 0;
        if (cache.containsKey(key)) return cache.get(key);

        Item item = weights.get(index);

        if (item.weight() > capacity) {
            int excludeWeight = mapCached(weights, cache, capacity, index - 1);
            return cache.computeIfAbsent(key, value -> excludeWeight);
        } else {
            int excludeWeight = mapCached(weights, cache, capacity, index - 1);
            int includeWeight = item.value() + mapCached(weights, cache, capacity - item.weight(), index - 1);
            return cache.computeIfAbsent(key, value -> Math.max(excludeWeight, includeWeight));
        }
    }
}

class TopDownKnapsack implements Knapsack {
    @Override
    public int knapsack(List<Item> weights, int orgCapacity, int orgIndex) {
        int[][] cache = new int[orgCapacity + 1][orgIndex + 1];

        for (int capacity = 0; capacity <= orgCapacity; capacity++) {
            for (int index = 0; index <= orgIndex; index++) {
                if (capacity == 0 || index == 0) {
                    cache[capacity][index] = 0;
                } else {
                    Item item = weights.get(index);
                    if (capacity < item.weight()) {
                        cache[capacity][index] = cache[capacity][index - 1];
                    } else {
                        int includeWeight = item.value() + cache[capacity - item.weight()][index - 1];
                        int excludeWeight = cache[capacity][index - 1];
                        cache[capacity][index] = Math.max(includeWeight, excludeWeight);
                    }
                }
            }
        }

        return cache[orgCapacity][orgIndex];
    }
}
