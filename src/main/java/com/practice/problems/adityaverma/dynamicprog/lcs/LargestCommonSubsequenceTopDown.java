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

    public static void main(String[] args) {
        String first;
        String second;

        first = "abcdgh";
        second = "abedfhr";
        print(first, second, maximum -> assertTrue(4 == maximum));

        first = "acbcf";
        second = "abcdaf";
        print(first, second, maximum -> assertTrue(4 == maximum));
    }

    private static void print(String first, String second, Consumer<Integer> expected) {
        log.info("Input:: Input1: {}\t | Input2: {}", first, second);
        int count = solveKnapsack(first, second);
        log.info("Output:: Largest Common Subsequence is `{}`", count);
        expected.accept(count);
    }

    public static int solveKnapsack(String first, String second) {
        int[][] results = knapsack(first, second, first.length(), second.length());
        return results[first.length()][second.length()];
    }

    public static int[][] knapsack(String first, String second, int firstIndices, int secondIndices) {
        int[][] results = new int[firstIndices + 1][secondIndices + 1];
        if (firstIndices == 0 || secondIndices == 0) return results;

        //printMatrix(first.toCharArray(), second.toCharArray(), results);

        for (int Y = 0; Y <= firstIndices; Y++) results[Y][0] = 0;
        for (int X = 0; X <= secondIndices; X++) results[0][X] = 0;

        for (int Y = 1; Y <= firstIndices; Y++) {
            for (int X = 1; X <= secondIndices; X++) {

                if (first.toCharArray()[Y - 1] == second.toCharArray()[X - 1]) {
                    results[Y][X] = 1 + results[Y - 1][X - 1];
                } else {
                    results[Y][X] = Math.max(results[Y - 1][X], results[Y][X - 1]);
                }
            }
        }

        printMatrix(first.toCharArray(), second.toCharArray(), results);

        return results;
    }
}
