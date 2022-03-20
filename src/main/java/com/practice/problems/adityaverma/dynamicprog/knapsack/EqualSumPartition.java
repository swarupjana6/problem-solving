package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 * such that the sum of elements in both subsets is the same.
 * <p>
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 * <p>
 * arr[] = {1, 5, 3}
 * Output: false
 * The array cannot be partitioned into equal sum sets.
 **/

@Log4j2
public class EqualSumPartition {

    public static void main(String[] args) {
        int[] numbers;
        boolean isPresent;

        numbers = new int[]{1, 5, 11, 5};
        log.info("Input:: Numbers: {}\t", numbers);
        isPresent = solveKnapsack(numbers);
        log.info("Output:: Is subset possible: {}", isPresent);
        assertTrue(isPresent);
    }

    public static boolean solveKnapsack(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return sum % 2 == 0 ? SubsetSum.solveKnapsack(numbers, sum / 2) : false;
    }
}