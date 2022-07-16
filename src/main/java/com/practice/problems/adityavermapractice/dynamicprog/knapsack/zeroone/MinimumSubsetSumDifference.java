package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

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
public abstract class MinimumSubsetSumDifference {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Arr         :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;


    public abstract int calculateSubsetSum(int[] numbers);

    public void execute() {
        int[] numbers;
        int expected;
        int actual;

        numbers = new int[]{1, 6, 11, 5};
        expected = 1;
        actual = calculateSubsetSum(numbers);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        numbers = new int[]{5, 5, 5, 5};
        expected = 0;
        actual = calculateSubsetSum(numbers);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
