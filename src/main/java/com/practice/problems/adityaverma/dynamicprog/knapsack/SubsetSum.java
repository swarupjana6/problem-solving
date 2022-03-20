package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 * <p>
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * There is a subset (4, 5) with sum 9.
 * <p>
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.
 **/

@Log4j2
public class SubsetSum {

    public static void main(String[] args) {
        int[] numbers;
        int sum;
        boolean isPresent;

        numbers = new int[]{2, 3, 7, 8, 10};
        sum = 11;
        log.info("Input:: Numbers: {}\t# Sum: {}", numbers, sum);
        isPresent = solveKnapsack(numbers, sum);
        log.info("Output:: Is subset possible: {}", isPresent);
        assertTrue(isPresent);

        numbers = new int[]{2, 3, 7, 8, 10};
        sum = 101;
        log.info("Input:: Numbers: {}\t# Sum: {}", numbers, sum);
        isPresent = solveKnapsack(numbers, sum);
        log.info("Output:: Is subset possible: {}", isPresent);
        assertFalse(isPresent);
    }

    public static boolean solveKnapsack(int[] numbers, int capacity) {
        return knapsack(numbers, capacity, numbers.length);
    }

    private static boolean knapsack(int[] numbers, int sum, int index) {
        boolean[][] cachedResult = new boolean[numbers.length + 1][sum + 1];

        for (int i = 0; i <= index; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    cachedResult[i][j] = true;
                    continue;
                }

                if (i == 0 && j != 0) {
                    cachedResult[i][j] = false;
                    continue;
                }

                int indexSum = numbers[i - 1];

                if (indexSum > j) {
                    cachedResult[i][j] = cachedResult[i - 1][j];
                } else {
                    cachedResult[i][j] = cachedResult[i - 1][j] || cachedResult[i - 1][j - indexSum];
                }
            }
        }

        return cachedResult[index][sum];
    }
}
