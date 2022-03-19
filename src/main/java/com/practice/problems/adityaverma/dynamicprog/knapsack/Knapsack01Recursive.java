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
public class Knapsack01Recursive {

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int sackWt = 7;
        log.info("Input:: Weights: {}\t# Values: {}\t# Knapsack Wt: {}", weights, values, sackWt, weights.length);
        log.info("Output:: Filled Weight: {}", knapsack(weights, values, sackWt, weights.length));
    }

    public static int knapsack(int[] weight, int[] value, int sackWt, int n) {
        // BASE CONDITION
        if (n == 0 || sackWt == 0)
            return 0;

        // CHOICE DIAGRAM CODE
        // Either we have to include weight or not
        int currentValue = value[n - 1];
        int currentWeight = weight[n - 1];

        int exclude = knapsack(weight, value, sackWt, n - 1);
        if (currentWeight <= sackWt) { // IF >>>>> current weight is LESS THAN knapsack weight it is INCLUDED
            int newSackWt = sackWt - currentWeight;
            int include = currentValue + knapsack(weight, value, newSackWt, n - 1);
            return Math.max(include, exclude);
        } else { // ELSE >>>>> current weight is MORE THAN knapsack weight it EXCLUDED
            return exclude;
        }
    }
}
