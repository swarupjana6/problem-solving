package com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMatrix;
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
        log.info("Output:: Is subset possible: {}\n", isPresent);
        assertTrue(isPresent);

        numbers = new int[]{2, 3, 7, 8, 10};
        sum = 101;
        log.info("Input:: Numbers: {}\t# Sum: {}", numbers, sum);
        isPresent = solveKnapsack(numbers, sum);
        log.info("Output:: Is subset possible: {}", isPresent);
        assertFalse(isPresent);
    }

    public static boolean solveKnapsack(int[] numbers, int sum) {
        int index = numbers.length;
        boolean[][] cachedResult = getKnapsackResults(numbers, sum);
        return cachedResult[index][sum];
    }

    public static boolean[][] getKnapsackResults(int[] numbers, int sum) {
        return knapsack(numbers, sum);
    }

    public static boolean[][] knapsack(int[] numbers, int expectSum) {
        int index = numbers.length;
        boolean[][] results = new boolean[numbers.length + 1][expectSum + 1];

        for (int x = 0; x <= expectSum; x++) results[0][x] = false;
        for (int x = 0; x <= index; x++) results[x][0] = true;

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= expectSum; j++) {
                int currNumber = numbers[i - 1];

                if (currNumber > j) {
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = results[i - 1][j] || results[i - 1][j - currNumber];
                }
            }
        }

        printMatrix(numbers, results, expectSum);
        return results;
    }
}
