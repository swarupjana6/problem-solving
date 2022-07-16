package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

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
 * {1} , {1} , {1} and {1}
 * Output: 4
 **/
@Log4j2
public abstract class CountNumberOfSubsetsWithADifference {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Arr         :: {}
            I/P Diff        :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;


    public abstract int countSubsets(int[] numbers, int difference);

    public void execute() {
        int[] numbers;
        int difference;
        int expected;
        int actual;

        numbers = new int[]{1, 2, 3, 3};
        difference = 6;
        expected = 3;
        actual = countSubsets(numbers, difference);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, difference, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        numbers = new int[]{1, 1, 2, 3};
        difference = 1;
        expected = 3;
        actual = countSubsets(numbers, difference);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, difference, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        /*numbers = new int[]{1, 1, 1, 1};
        difference = 1;
        expected = 4;
        actual = countSubsets(numbers, difference);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        numbers = new int[]{1, 1, 1, 1};
        difference = 5;
        expected = 0;
        actual = countSubsets(numbers, difference);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);*/
    }
}
