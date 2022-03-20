package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
public class Knapsack01TopDown {

    private static int[][] cachedResult;

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 5};
        int[] values = {1, 6, 10, 16};
        int capacity = 7;
        cachedResult = new int[weights.length + 1][capacity + 1];
        log.info("Input:: Weights: {}\t# Values: {}\t# Knapsack Wt: {}", weights, values, capacity);
        int total = solveKnapsack(weights, values, capacity);
        log.info("Output:: Total knapsack: {}", total);
        assertTrue(total == 22);

        capacity = 6;
        log.info("Input:: Weights: {}\t# Values: {}\t# Knapsack Wt: {}", weights, values, capacity);
        total = solveKnapsack(weights, values, capacity);
        log.info("Output:: Total knapsack: {}", total);
        assertTrue(total == 17);
    }

    public static int solveKnapsack(int[] weights, int[] values, int capacity) {
        return knapsackIterativeMemoized(weights, values, capacity, weights.length);
    }

    private static int knapsackIterativeMemoized(int[] weights, int[] values, int capacity, int currentIndex) {
        for (int i = 0; i <= currentIndex; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    cachedResult[i][j] = 0;
                    continue;
                }

                int currentValue = values[i - 1];
                int currentWeight = weights[i - 1];
                if (currentWeight > j)
                    cachedResult[i][j] = cachedResult[i - 1][j];
                else
                    cachedResult[i][j] = Math.max(cachedResult[i - 1][j], currentValue + cachedResult[i - 1][j - currentWeight]);
            }
        }

        return cachedResult[currentIndex][capacity];
    }
}
