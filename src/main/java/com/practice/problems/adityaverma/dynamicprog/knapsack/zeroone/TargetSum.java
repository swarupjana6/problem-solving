package com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone.CountNumberOfSubsetsWithADifference.solveKnapsack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding
 * one of the symbols '+' and '-' before each integer in nums
 * and then concatenate all the integers.
 * <p><br/>
 * For example, if nums = [2, 1], you can add
 * a '+' before 2
 * and a '-' before 1
 * and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * <p><br/>
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p><br/>
 * Input: nums = [1], target = 1
 * Output: 1
 **/

@Log4j2
public class TargetSum {

    public static void main(String[] args) {
        int[] numbers;
        int difference;

        numbers = new int[]{1, 1, 2, 3};
        difference = 1;
        print(numbers, difference, minimum -> assertTrue(3 == minimum));
    }

    private static void print(int[] numbers, int difference, Consumer<Integer> expected) {
        log.info("Input:: Numbers: {}\t | Difference: {}", numbers, difference);
        int minimum = solveKnapsack(numbers, difference);
        log.info("Output:: Count of subset with difference {} is `{}`", difference, minimum);
        expected.accept(minimum);
    }
}
