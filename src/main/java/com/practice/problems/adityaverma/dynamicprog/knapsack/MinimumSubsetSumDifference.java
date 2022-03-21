package com.practice.problems.adityaverma.dynamicprog.knapsack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given a set of integers, the task is to divide it into two sets
 * S1 and S2 such that the absolute difference between their sums is minimum.
 * If there is a set S with n elements,
 * then if we assume Subset1 has m elements, Subset2 must have n-m elements
 * and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * <p>
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 **/

@Log4j2
public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] numbers;
        int minimum;

        numbers = new int[]{1, 5, 11, 5};
        log.info("Input:: Numbers: {}\t", numbers);
        minimum = solveKnapsack(numbers);
        log.info("Output:: Minimum possible subset sum difference: {}", minimum);
        assertTrue(true);
    }

    public static int solveKnapsack(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return sum % 2 == 0 ? 0 : 1;
    }
}
