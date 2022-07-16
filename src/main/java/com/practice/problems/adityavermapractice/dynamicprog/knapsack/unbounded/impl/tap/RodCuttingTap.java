package com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded.RodCutting;

import java.util.HashMap;
import java.util.Map;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMatrix;
import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMemoizedMap;

public class RodCuttingTap extends RodCutting {

    private int[] lengths;

    private int[] prices;

    @Override
    public Integer cutRod(int[] lengths, int[] prices, int rodLen) {
        this.lengths = lengths;
        this.prices = prices;
        //return knapsackM(lengths, prices, rodLen, lengths.length);
        return knapsack(rodLen, lengths.length);
    }

    private int knapsackM(int[] lengths, int[] prices, int rodLen, int index) {
        Map<String, Integer> results = new HashMap<>();

        for (int i = 0; i <= index; i++) results.put(i + "-" + 0, 0);
        for (int i = 0; i <= rodLen; i++) results.put(0 + "-" + i, 0);

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= rodLen; j++) {
                int currValue = prices[i - 1];
                int currWeight = lengths[i - 1];

                int val = results.get((i - 1) + "-" + j);
                if (currWeight <= j) {
                    int newVal = currValue + results.get((i) + "-" + (j - currWeight));
                    val = Math.max(val, newVal);
                }
                results.put(i + "-" + j, val);
            }
        }

        printMemoizedMap(lengths, index, results, rodLen);

        return results.get(index + "-" + rodLen);
    }

    private int knapsack(int rodLen, int index) {
        int[][] results = new int[index + 1][rodLen + 1];

        for(int cap = 0; cap < rodLen + 1; cap++) results[0][cap] = 0;
        for(int idx = 0; idx < index + 1; idx++) results[idx][0] = 0;

        for(int idx = 1; idx < index + 1; idx++) {
            for(int len = 1; len < rodLen + 1; len++) {
                int price = prices[idx - 1];
                int length = lengths[idx - 1];
                int previousResult = results[idx - 1][len];

                int result = previousResult;
                if (length <= len) {
                    int include = price + results[idx][len - length];
                    result = Math.max(result, include);
                }

                results[idx][len] = result;
            }
        }

        printMatrix(lengths, prices, index, results, rodLen);

        return results[index][rodLen];
    }
}

