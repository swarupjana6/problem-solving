package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given weights and values of n items,
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * <p>
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
 * which represent values and weights associated with n items respectively.
 * <p>
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 **/

@Log4j2
public class Knapsack01Memoized {

    private static int[][] cachedResult;

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 5};
        int[] values = {1, 6, 10, 16};
        int capacity = 7;
        init(weights.length, capacity);
        log.info("Input:: Weights: {}\t# Values: {}\t# Knapsack Wt: {}", weights, values, capacity);
        int total = solveKnapsack(weights, values, capacity);
        log.info("Output:: Total knapsack: {}", total);
        assertTrue(total == 22);

        capacity = 6;
        init(weights.length, capacity);
        log.info("Input:: Weights: {}\t# Values: {}\t# Knapsack Wt: {}", weights, values, capacity);
        total = solveKnapsack(weights, values, capacity);
        log.info("Output:: Total knapsack: {}", total);
        assertTrue(total == 17);
    }

    public static int solveKnapsack(int[] weights, int[] values, int capacity) {
        return knapsack(weights, values, capacity, weights.length - 1);
    }

    private static void init(int index, int capacity) {
        cachedResult = new int[index + 1][capacity + 1];
        for (int i = 0; i <= index; i++) {
            int tempCapacity = capacity;
            while (tempCapacity >= 0) cachedResult[i][tempCapacity--] = -1;
        }
        System.out.println(Arrays.deepToString(cachedResult));
    }

    private static int knapsack(int[] weights, int[] values, int capacity, int index) {
        // IF >> index out of bound OR knapsack capacity ZERO
        if (index == -1 || capacity == 0) return 0;

        // IF >> Result is cached then return
        if (cachedResult[index][capacity] != -1) return cachedResult[index][capacity];

        // Current Value and Weight
        int prevIndex = index - 1;
        int indexValue = values[index];
        int indexWeight = weights[index];

        // IF >> current weight goes beyond knapsack capacity it EXCLUDED
        int prevResult = knapsack(weights, values, capacity, prevIndex);
        if (indexWeight > capacity) {
            cachedResult[index][capacity] = prevResult;
        } else {
            // ELSE >> current weight is within knapsack capacity it is INCLUDED
            int include = indexValue + knapsack(weights, values, capacity - indexWeight, prevIndex);
            cachedResult[index][capacity] = Math.max(prevResult, include);
        }

        return cachedResult[index][capacity];
    }
}
