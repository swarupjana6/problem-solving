package com.practice.problems.adityaverma.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

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
public class EvaluateExpressionToTrueParenthesizationMemoized {

    static Map<String, Integer> cached = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        print("T|F&T^F", expressionValue -> assertTrue(expressionValue == 1));
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

        String key = low + " " + high + " " + isTrue;
        if (cached.containsKey(key)) return cached.get(key);

        int minPartitions = 0;
        // Operand Operator Operand Operator....Example: True & True ^ True | False
        for (int opr = low + 1; opr < high; opr = opr + 2) {
            // Expression Left.....example: True & True
            int operator = opr;
            int lowTrue = cached.computeIfAbsent(low + " " + (operator - 1) + " " + true, (cKey) -> solveLowToHigh(arr, low, operator - 1, true));
            int lowFalse = cached.computeIfAbsent(low + " " + (operator - 1) + " " + false, (cKey) -> solveLowToHigh(arr, low, operator - 1, false));

            // Expression Right....example: True | False
            int highTrue = cached.computeIfAbsent((operator + 1) + " " + high + " " + true, (cKey) -> solveLowToHigh(arr, operator + 1, high, true));
            int highFalse = cached.computeIfAbsent((operator + 1) + " " + high + " " + false, (cKey) -> solveLowToHigh(arr, operator + 1, high, false));

            switch (arr[operator]) {
                case '&' -> minPartitions += isTrue ? (lowTrue * highTrue) : ((lowFalse * highTrue) + (lowTrue * highFalse) + (lowFalse * highFalse));
                case '|' -> minPartitions += isTrue ? ((lowTrue * highTrue) + (lowTrue * highFalse) + (lowTrue * highFalse)) : (lowFalse * highFalse);
                case '^' -> minPartitions += isTrue ? ((lowFalse * highTrue) + (lowTrue * highFalse)) : ((lowFalse * highFalse) + (lowTrue * highTrue));
            }
        }


        return minPartitions;
    }
}
