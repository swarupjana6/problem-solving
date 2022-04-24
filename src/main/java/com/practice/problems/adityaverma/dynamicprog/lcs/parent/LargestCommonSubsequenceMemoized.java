package com.practice.problems.adityaverma.dynamicprog.lcs.parent;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMatrix;
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
public class LargestCommonSubsequenceMemoized {

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
        int count = solveLCS(first, second);
        log.info("Output:: Largest Common Subsequence is `{}`", count);
        printMatrix(first.toCharArray(), second.toCharArray(), results);
        expected.accept(count);
    }

    public static int solveLCS(String first, String second) {
        return lcs(first, second, first.length(), second.length());
    }

    public static int lcs(String first, String second, int firstIndices, int secondIndices) {
        // BASE CONDITION
        if (firstIndices == 0 || secondIndices == 0) return 0;

        // MEMOIZED RETURN
        if (results[firstIndices][secondIndices] != -1) return results[firstIndices][secondIndices];

        // CHOICE DIAGRAM
        if (first.toCharArray()[firstIndices - 1] == second.toCharArray()[secondIndices - 1]) {
            return results[firstIndices][secondIndices] = 1 + lcs(first, second, firstIndices - 1, secondIndices - 1);
        } else {
            int smallerFirst = lcs(first, second, firstIndices - 1, secondIndices);
            int smallerSecond = lcs(first, second, firstIndices, secondIndices - 1);
            return results[firstIndices][secondIndices] = Math.max(smallerFirst, smallerSecond);
        }
    }
}
