package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.knapsack.PrintDPMatrix.printMatrix;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * <p><br/>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * <p><br/>
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p><br/>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * <p><br/>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * <p><br/>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * <p><br/>
 * Constraints:
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 **/

@Log4j2
public class LargestCommonSubsequenceTopDown {

    private static int[][] results;

    public static void main(String[] args) {
        String first;
        String second;

        first = "abcdgh";
        second = "abedfhr";
        print(first, second, maximum -> assertTrue(4 == maximum));
    }

    private static void init(String first, String second) {
        results = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++)
            for (int j = 0; j <= second.length(); j++) results[i][j] = -1;
        printMatrix(first.toCharArray(), second.toCharArray(), results);
    }

    private static void print(String first, String second, Consumer<Integer> expected) {
        init(first, second);
        log.info("Input:: Input1: {}\t | Input2: {}", first, second);
        int count = solveKnapsack(first, second);
        log.info("Output:: Largest Common Subsequence is `{}`", count);
        printMatrix(first.toCharArray(), second.toCharArray(), results);
        expected.accept(count);
    }

    public static int solveKnapsack(String first, String second) {
        return knapsack(first, second, first.length(), second.length());
    }

    public static int knapsack(String first, String second, int firstIndices, int secondIndices) {
        if (firstIndices == 0 || secondIndices == 0) return 0;

        for (int i = 0; i <= firstIndices; i++) results[i][0] = 0;
        for (int j = 0; j <= secondIndices; j++) results[0][j] = 0;

        for (int i = 1; i <= firstIndices; i++) {
            for (int j = 1; j <= secondIndices; j++) {

                if (first.toCharArray()[i - 1] == second.toCharArray()[j - 1]) {
                    results[i][j] = 1 + results[i - 1][j - 1];
                } else {
                    results[i][j] = Math.max(results[i - 1][j], results[i][j - 1]);
                }
            }
        }

        return results[firstIndices][secondIndices];
    }
}
