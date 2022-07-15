package com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.impl.tap.CountSubsetSumTap;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        numbers = new int[]{1, 1, 2, 3};
        difference = 1;
        print(numbers, difference, minimum -> assertTrue(3 == minimum));

        numbers = new int[]{1, 1, 1, 1};
        difference = 1;
        print(numbers, difference, minimum -> assertTrue(4 == minimum));
    }

    private static void print(int[] numbers, int difference, Consumer<Integer> expected) {
        log.info("Input:: Numbers: {}\t | Difference: {}", numbers, difference);
        int minimum = solveKnapsack(numbers, difference);
        log.info("Output:: Count of subset with difference {} is `{}`", difference, minimum);
        expected.accept(minimum);
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
        log.debug("SUM :: {}", sum);
        int count = new CountSubsetSumTap().countingSubsetSum(numbers, sum);
        return count;
    }
}
