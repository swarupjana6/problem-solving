package com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.impl.tap.SubsetSumTap;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        numbers = new int[]{1, 6, 11, 5};
        log.info("Input:: Numbers: {}\t", numbers);
        minimum = solveKnapsack(numbers);
        log.info("Output:: Minimum possible subset sum difference: {}", minimum);
        assertEquals(minimum, 1);
    }

    public static int solveKnapsack(int[] numbers) {
        int range = Arrays.stream(numbers).sum();
        return knapsack(numbers, range);
    }

    private static int knapsack(int[] numbers, int range) {
        boolean[][] subsetSums = new SubsetSumTap().knapsack(numbers, range);

        int numsSize = numbers.length;
        int minimumSubsetSum = Integer.MAX_VALUE;
        int halfSubsetSumLength = subsetSums[numsSize].length / 2;
        for (int i = 0; i < halfSubsetSumLength; i++) {
            if (subsetSums[numsSize][i]) minimumSubsetSum = Math.min(range - 2 * i, minimumSubsetSum);
        }

        return minimumSubsetSum;
    }
}
