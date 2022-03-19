package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

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

    private static int[][] memoizedData;

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int sackWt = 7;
        init(weights.length, sackWt);
        log.info("Input:: Weights: {}\t# Values: {}\t# Knapsack Wt: {}", weights, values, sackWt, weights.length);
        log.info("Output:: Filled Weight: {}", knapsack(weights, values, sackWt, weights.length));
        System.out.println(Arrays.deepToString(memoizedData));
    }

    private static void init(int n, int knapsackWt) {
        memoizedData = new int[n + 1][knapsackWt + 1];
        for (int i = 0; i <= n; i++) {
            int wt = knapsackWt;
            while (wt >= 0) memoizedData[i][wt--] = -1;
        }
        System.out.println(Arrays.deepToString(memoizedData));
    }

    public static int knapsack(int[] weight, int[] value, int sackWt, int n) {
        // BASE CONDITION
        if (n == 0 || sackWt == 0)
            return 0;

        // CHOICE DIAGRAM CODE
        // Memoization of memoizedData[n][sackWt] will be done while doing this calculation to be used in future steps
        int current = n - 1;
        int currentValue = value[current];
        int currentWeight = weight[current];

        int exclude = knapsack(weight, value, sackWt, current);
        if (currentWeight <= sackWt) {  // IF >>>>> current weight is LESS THAN knapsack weight it is INCLUDED
            int newSackWt = sackWt - currentWeight;
            int include = currentValue + knapsack(weight, value, newSackWt, current);

            memoizedData[n][sackWt] = Math.max(include, exclude);
        } else { // ELSE >>>>> current weight is MORE THAN knapsack weight it EXCLUDED
            memoizedData[n][sackWt] = exclude;
        }

        return memoizedData[n][sackWt];
    }
}
