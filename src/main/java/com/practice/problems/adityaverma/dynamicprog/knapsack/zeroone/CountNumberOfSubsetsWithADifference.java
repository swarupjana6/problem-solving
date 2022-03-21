package com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array arr[] of length N and an integer X,
 * the task is to find the number of subsets with a sum equal to X.
 * <p><br/>
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 * <p><br/>
 * Input: arr[] = {1, 1, 1, 1}, X = 1
 * Output: 4
 **/

@Log4j2
public class CountNumberOfSubsetsWithADifference {

    public static void main(String[] args) {
        int[] numbers;
        int difference;
        int minimum;

        numbers = new int[]{1, 1, 2, 3};
        difference = 1;
        log.info("Input:: Numbers: {}\t | Difference: {}", numbers, difference);
        minimum = solveKnapsack(numbers, difference);
        log.info("Output:: Count of subset with difference {} is `{}`", difference, minimum);
        assertEquals(minimum, 3);
    }

    public static int solveKnapsack(int[] numbers, int difference) {
        /*
        sum(subset1) - sum(subset2) = diff;
        sum(subset1) + sum(subset2) = sumArr;
        ======================================
        2 x sum(subset1) = diff + sumArr;

         ---------------------------------
        |sum(subset1) = (diff + sumArr)/2;|
         ---------------------------------
        */
        int sum = (difference + Arrays.stream(numbers).sum()) / 2;
        int count = CountOfSubsetSumWithGivenSum.solveKnapsack(numbers, sum);
        return count;
    }
}
