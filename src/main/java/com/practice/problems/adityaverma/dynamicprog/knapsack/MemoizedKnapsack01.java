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
public class MemoizedKnapsack01 {

    private static int[][] memoizedData;

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int sackWt = 7;
        init(weights.length, sackWt);
        log.info("Input:: \nWeights:\t{} \nValues:\t\t{} \nKnapsack Wt:\t{}", weights, values, sackWt, weights.length);
        log.info("Output::\nFilled Weight:\t{}", knapsack(weights, values, sackWt, weights.length));
        System.out.println(Arrays.deepToString(memoizedData));
    }

    private static void init(int n, int knapsackWt) {
        memoizedData = new int[n + 1][knapsackWt + 1];
        for (int i = 1; i <= n; i++) {
            int wt = knapsackWt;
            while (wt >= 1) memoizedData[i][wt--] = -1;
        }
        System.out.println(Arrays.deepToString(memoizedData));
    }

    public static int knapsack(int[] weight, int[] value, int sackWt, int n) {
        // BASE CONDITION
        if (n == 0 || sackWt == 0)
            return 0;

        // MEMOIZED RETURN
        if (memoizedData[n][sackWt] != -1) {
            return memoizedData[n][sackWt];
        }

        // CHOICE DIAGRAM CODE
        if (weight[n - 1] <= sackWt) {
            int including = value[n - 1] + knapsack(weight, value, sackWt - weight[n - 1], n - 1);
            int withoutIncluding = knapsack(weight, value, sackWt, n - 1);
            memoizedData[n][sackWt] = Math.max(including, withoutIncluding);
            return memoizedData[n][sackWt];
        }

        memoizedData[n][sackWt] = knapsack(weight, value, sackWt, n - 1);
        return memoizedData[n][sackWt];
    }
}
