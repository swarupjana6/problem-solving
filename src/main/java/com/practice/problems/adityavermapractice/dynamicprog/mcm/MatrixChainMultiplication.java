package com.practice.problems.adityavermapractice.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Input: p[] = {40, 20, 30, 10, 30}
 * Output: 26000
 * There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
 * Let the input 4 matrices be A, B, C and D.  The minimum number of
 * multiplications are obtained by putting parenthesis in following way
 * (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
 * <p>
 * Input: p[] = {10, 20, 30, 40, 30}
 * Output: 30000
 * There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
 * Let the input 4 matrices be A, B, C and D.  The minimum number of
 * multiplications are obtained by putting parenthesis in following way
 * ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
 * <p>
 * Input: p[] = {10, 20, 30}
 * Output: 6000
 * There are only two matrices of dimensions 10x20 and 20x30. So there
 * is only one way to multiply the matrices, cost of which is 10*20*30
 **/

@Log4j2
public abstract class MatrixChainMultiplication {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer memoizedMCM(List<Integer> input);

    protected abstract Integer recursiveMCM(List<Integer> input);

    public void execute() {
        List<Integer> input;
        Integer actualRecursive;
        Integer actualMemoized;
        Integer expected;

        input = List.of(10, 20, 30);
        expected = 6000;
        actualRecursive = recursiveMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = memoizedMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);

        input = List.of(40, 20, 30, 10, 30);
        expected = 26000;
        actualRecursive = recursiveMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = memoizedMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);
    }
}
