package com.practice.problems.adityaverma.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class EvaluateExpressionToTrueParenthesization {

    public static void main(String[] args) {
        print("T^F&T", expressionValue -> assertTrue(expressionValue == 2));
        print("T|T&F^T", expressionValue -> assertTrue(expressionValue == 4));
        print("T|F&T^F", expressionValue -> assertTrue(expressionValue == 10));
    }

    private static void print(String inputStr, Consumer<Integer> expected) {
        char[] input = inputStr.toCharArray();
        log.info("Input:: {}\t ", input);
        int partitions = solveLowToHigh(input, 0, input.length - 1, true);
        log.info("Output:: Is string `{}` number of  `{}`", input, partitions);
        expected.accept(partitions);
    }

    public static int solveLowToHigh(char[] arr, int low, int high, boolean isTrue) {
        if (low > high) return 1;
        if (low == high) {
            if (isTrue) return 'T' == arr[low] ? 1 : 0;
            else return 'F' == arr[low] ? 1 : 0;
        }

        int minPartitions = 0;
        // Operand Operator Operand Operator....Example: True & True ^ True | False
        for (int operator = low + 1; operator < high; operator = operator + 2) {
            // Expression Left.....example: True & True
            int lowTrue = solveLowToHigh(arr, low, operator - 1, true);
            int lowFalse = solveLowToHigh(arr, low, operator - 1, false);

            // Expression Right....example: True | False
            int highTrue = solveLowToHigh(arr, operator + 1, high, true);
            int highFalse = solveLowToHigh(arr, operator + 1, high, false);

            switch (arr[operator]) {
                case '&' -> minPartitions += isTrue ? (lowTrue * highTrue) : ((lowFalse * highTrue) + (lowTrue * highFalse) + (lowFalse * highFalse));
                case '|' -> minPartitions += isTrue ? ((lowTrue * highTrue) + (lowTrue * highFalse) + (lowTrue * highFalse)) : (lowFalse * highFalse);
                case '^' -> minPartitions += isTrue ? ((lowFalse * highTrue) + (lowTrue * highFalse)) : ((lowFalse * highFalse) + (lowTrue * highTrue));
            }
        }

        String expression = IntStream.rangeClosed(low, high).mapToObj(i -> String.valueOf(arr[i])).collect(Collectors.joining(""));
        log.debug(" low {} - high {} || minPartitions {} || exp {} ", low, high, minPartitions, expression);
        return minPartitions;
    }
}
