package com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.knapsack.PrintDPMatrix.printMatrix;
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
        print(new int[]{2, 3, 5, 6, 8, 10}, 10, count -> assertTrue(3 == count));
        print(new int[]{2, 3, 5, 6, 8, 10}, 101, count -> assertFalse(3 == count));
    }

    private static void print(int[] numbers, int sum, Consumer<Integer> expected) {
        int count;
        log.info("Input:: Numbers: {}\t# Sum: {}", numbers, sum);
        count = solveKnapsack(numbers, sum);
        log.info("Output:: Count of subsets: {}", count);
        expected.accept(count);
    }

    public static int solveKnapsack(int[] numbers, int sum) {
        int[][] results = knapsack(numbers, sum, numbers.length);
        return results[numbers.length][sum];
    }

    private static int[][] knapsack(int[] numbers, int sum, int index) {
        int[][] results = new int[index + 1][sum + 1];

        for (int x = 0; x <= sum; x++) results[0][x] = 0;
        for (int x = 0; x <= index; x++) results[x][0] = 1;

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= sum; j++) {
                int indexSum = numbers[i - 1];

                if (indexSum > j) {
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = results[i - 1][j] + results[i - 1][j - indexSum];
                }
            }
        }

        printMatrix(numbers, index, results, sum);

        return results;
    }
}
