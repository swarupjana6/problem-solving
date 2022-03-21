package com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
public class Knapsack01TopDown {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 5};
        int[] values = {1, 6, 10, 16};
        int capacity = 7;
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
        return knapsack(weights, values, capacity, weights.length);
    }

    private static int knapsack(int[] weights, int[] values, int capacity, int index) {
        int[][] result = new int[index + 1][capacity + 1];

        for (int i = 0; i <= index; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                    continue;
                }

                int currValue = values[i - 1];
                int currWeight = weights[i - 1];
                if (currWeight > j)
                    result[i][j] = result[i - 1][j];
                else
                    result[i][j] = Math.max(result[i - 1][j], currValue + result[i - 1][j - currWeight]);
            }
        }

        return result[index][capacity];
    }
}
