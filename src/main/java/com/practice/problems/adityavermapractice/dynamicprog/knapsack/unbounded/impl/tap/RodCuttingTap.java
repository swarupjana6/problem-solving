package com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded.RodCutting;

import java.util.HashMap;
import java.util.Map;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMemoizedMap;

public class RodCuttingTap extends RodCutting {
    @Override
    public Integer cutRod(int[] lengths, int[] prices, int capacity) {
        return knapsack(lengths, prices, capacity, lengths.length);
    }

    private static int knapsack(int[] lengths, int[] prices, int capacity, int index) {
        Map<String, Integer> results = new HashMap<>();

        for (int i = 0; i <= index; i++) results.put(i + "-" + 0, 0);
        for (int i = 0; i <= capacity; i++) results.put(0 + "-" + i, 0);

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= capacity; j++) {
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

        printMemoizedMap(lengths, index, results, capacity);

        return results.get(index + "-" + capacity);
    }
}

