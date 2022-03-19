package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

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
public class Knapsack01 {

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int knapsackWt = 7;
        log.info("Input:: \nWeights:\t{} \nValues:\t\t{} \nKnapsack Wt:\t{}", weights, values, knapsackWt, weights.length);
        log.info("Output::\nFilled Weight:\t{}", knapsack(weights, values, knapsackWt, weights.length));
    }

    public static int knapsack(int[] weight, int[] value, int knapsackWt, int n) {
        // BASE CONDITION
        if (n == 0 || knapsackWt == 0)
            return 0;

        // CHOICE DIAGRAM CODE
        if (weight[n - 1] <= knapsackWt) {
            int including = value[n - 1] + knapsack(weight, value, knapsackWt - weight[n - 1], n - 1);
            int withoutIncluding = knapsack(weight, value, knapsackWt, n - 1);
            return Math.max(including, withoutIncluding);
        }
        return knapsack(weight, value, knapsackWt, n - 1);
    }
}
