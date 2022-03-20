package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.
 * <p>
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 * <p>
 * Input: arr[] = {1, 1, 1, 1}, X = 1
 * Output: 4
 **/

@Log4j2
public class CountOfSubsetSumWithGivenSum {

    public static void main(String[] args) {
        int[] numbers;
        int sum;
        int count;

        numbers = new int[]{2, 3, 5, 6, 8, 10};
        sum = 10;
        log.info("Input:: Numbers: {}\t# Sum: {}", numbers, sum);
        count = solveKnapsack(numbers, sum);
        log.info("Output:: Count of subsets: {}", count);
        assertTrue(count == 3);

        numbers = new int[]{2, 3, 5, 6, 8, 10};
        sum = 101;
        log.info("Input:: Numbers: {}\t# Sum: {}", numbers, sum);
        count = solveKnapsack(numbers, sum);
        log.info("Output:: Count of subsets: {}", count);
        assertFalse(count == 3);
    }

    public static int solveKnapsack(int[] numbers, int sum) {
        return knapsack(numbers, sum, numbers.length);
    }

    private static int knapsack(int[] numbers, int sum, int index) {
        int[][] cachedResult = new int[numbers.length + 1][sum + 1];

        for (int i = 0; i <= index; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    cachedResult[i][j] = 1;
                    continue;
                }

                if (i == 0 && j != 0) {
                    cachedResult[i][j] = 0;
                    continue;
                }

                int indexSum = numbers[i - 1];

                if (indexSum > j) {
                    cachedResult[i][j] = cachedResult[i - 1][j];
                } else {
                    cachedResult[i][j] = cachedResult[i - 1][j] + cachedResult[i - 1][j - indexSum];
                }

            }
        }

        return cachedResult[index][sum];
    }
}
