package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

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
public class LargestCommonSubsequenceRecursive {

    public static void main(String[] args) {
        String first;
        String second;

        first = "abcdgh";
        second = "abedfhr";
        print(first, second, maximum -> assertTrue(4 == maximum));
    }

    private static void print(String first, String second, Consumer<Integer> expected) {
        log.info("Input:: Input1: {}\t | Input2: {}", first, second);
        int count = solveKnapsack(first, second);
        log.info("Output:: Largest Common Subsequence is `{}`", count);
        expected.accept(count);
    }

    private static int solveKnapsack(String first, String second) {
        return knapsack(first, second, first.length(), second.length());
    }

    private static int knapsack(String first, String second, int firstIndices, int secondIndices) {
        // BASE CONDITION
        if (firstIndices == 0 || secondIndices == 0) return 0;

        // CHOICE DIAGRAM
        if (first.toCharArray()[firstIndices - 1] == second.toCharArray()[secondIndices - 1]) {
            return 1 + knapsack(first, second, firstIndices - 1, secondIndices - 1);
        } else {
            int smallerFirst = knapsack(first, second, firstIndices - 1, secondIndices);
            int smallerSecond = knapsack(first, second, firstIndices, secondIndices - 1);
            return Math.max(smallerFirst, smallerSecond);
        }
    }
}
