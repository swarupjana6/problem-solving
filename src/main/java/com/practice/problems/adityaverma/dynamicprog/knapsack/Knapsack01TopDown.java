package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
public class Knapsack01TopDown {

    private static int[][] memoizedData;

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int sackWt = 7;
        init(weights.length, sackWt);
        log.info("Input:: Weights: {}\t# Values: {}\t# Knapsack Wt: {}", weights, values, sackWt, weights.length);
        log.info("Output:: Filled Weight: {}", knapsackIterative(weights, values, sackWt, weights.length));
        log.info("After memoization {}", Arrays.deepToString(memoizedData));
    }

    private static void init(int n, int sackWt) {
        memoizedData = new int[n + 1][sackWt + 1];
        for (int i = 1; i <= n; i++) {
            int wt = sackWt;
            while (wt >= 1) memoizedData[i][wt--] = -1;
        }
        log.info("Before memoization {}", Arrays.deepToString(memoizedData));
    }

    public static int knapsackIterative(int[] weight, int[] value, int sackWt, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sackWt; j++) {
                if (i == 0 || j == 0) {
                    memoizedData[i][j] = 0;
                    continue;
                }

                int current = i - 1;
                int currentValue = value[current];
                int currentWeight = weight[current];

                int exclude = memoizedData[current][j];
                if (currentWeight <= j) {  // IF >>>>> current weight is LESS THAN knapsack weight it is INCLUDED
                    int include = currentValue + memoizedData[current][j - currentWeight];
                    memoizedData[i][j] = Math.max(include, exclude);
                } else {  // ELSE >>>>> current weight is MORE THAN knapsack weight it EXCLUDED
                    memoizedData[i][j] = exclude;
                }
            }
        }

        return memoizedData[n][sackWt];
    }
}
