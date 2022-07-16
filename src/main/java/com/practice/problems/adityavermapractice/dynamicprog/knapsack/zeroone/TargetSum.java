package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

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
public abstract class TargetSum {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Arr         :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;


    public abstract int calculateTargetSum(int[] numbers);

    public void execute() {
        int[] numbers;
        int expected;
        int actual;

        numbers = new int[]{1, 6, 11, 5};
        expected = 1;
        actual = calculateTargetSum(numbers);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
