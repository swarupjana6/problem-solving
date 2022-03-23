package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.knapsack.PrintDPMatrix.printMatrix;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given a string, find the length of the longest repeating subsequence
 * such that the two subsequences don’t have same string character at the same position,
 * i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 * <p><br/>
 * Input: str = "abc"
 * Output: 0
 * There is no repeating subsequence
 * <p><br/>
 * Input: str = "aab"
 * Output: 1
 * The two subsequence are 'a'(first) and 'a'(second).
 * Note that 'b' cannot be considered as part of subsequence
 * as it would be at same index in both.
 * <p><br/>
 * Input: str = "aabb"
 * Output: 2
 * <p><br/>
 * Input: str = "axxxy"
 * Output: 2
 * <br/><br/>
 **/

@Log4j2
public class LongestRepeatingSubsequence {

    public static void main(String[] args) {
        String input;

        input = "AABEBCDD";
        print(input, maximum -> assertTrue(3 == maximum));
    }

    private static void print(String input, Consumer<Integer> expected) {
        log.info("Input:: Input String: {}\t", input);
        int count = solveLCS(input, input);
        log.info("Output:: Longest Repeating Subsequence is `{}`", count);
        expected.accept(count);
    }

    public static int solveLCS(String first, String second) {
        int[][] results = lcs(first, second, first.length(), second.length());
        return results[first.length()][second.length()];
    }

    public static int[][] lcs(String first, String second, int firstIndices, int secondIndices) {
        int[][] results = new int[firstIndices + 1][secondIndices + 1];
        if (firstIndices == 0 || secondIndices == 0) return results;

        //printMatrix(first.toCharArray(), second.toCharArray(), results);

        for (int Y = 0; Y <= firstIndices; Y++) results[Y][0] = 0;
        for (int X = 0; X <= secondIndices; X++) results[0][X] = 0;

        for (int Y = 1; Y <= firstIndices; Y++) {
            for (int X = 1; X <= secondIndices; X++) {

                if (first.toCharArray()[Y - 1] == second.toCharArray()[X - 1] && X != Y) {
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
