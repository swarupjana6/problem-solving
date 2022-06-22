package com.practice.problems.adityavermapractice.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

/**
 * Given an expression, A, with operands and operators (OR , AND , XOR),
 * in how many ways can you evaluate the expression to true, by grouping in different ways?
 * Operands are only true and false.
 * Return the number of ways to evaluate the expression modulo 103 + 3.
 * <p><br\>
 * Input Format:
 * The first and the only argument of input will contain a string, A.
 * The string A, may contain these characters:
 * '|' will represent or operator
 * '&' will represent and operator
 * '^' will represent xor operator
 * 'T' will represent true operand
 * 'F' will false
 * <p><br\>
 * Output:
 * Return an integer, representing the number of ways to evaluate the string.
 * <p><br\>
 * Constraints:
 * 1 <= length(A) <= 150
 * <p><br\>
 * Input 1: A = "T|F"
 * <p><br\>
 * Output 1: 1
 * Explanation 1: The only way to evaluate the expression is: => (T|F) = T
 * <p><br\>
 * Input 2: A = "T^T^F"
 * <p><br\>
 * Output 2: 0
 * <p><br\>
 * Explanation 2: There is no way to evaluate A to a true statement.
 */

@Log4j2
public abstract class EvaluateExpressionToTrueParenthesization {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer memoizedMCM(char[] arr);

    protected abstract Integer recursiveMCM(char[] arr);

    public void execute() {
        char[] input;
        Integer actualRecursive;
        Integer actualMemoized;
        Integer expected;

        input = "T^F&T".toCharArray();
        expected = 2;
        actualRecursive = recursiveMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = memoizedMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);

        input = "T|T&F^T".toCharArray();
        expected = 4;
        actualRecursive = recursiveMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = memoizedMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);
    }
}
