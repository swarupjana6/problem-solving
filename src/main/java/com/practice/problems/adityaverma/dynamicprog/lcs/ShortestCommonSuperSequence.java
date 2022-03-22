package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.lcs.LargestCommonSubsequenceTopDown.lcs;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two strings str1 and str2,
 * the task is to find the length of the shortest string that has both str1 and str2 as subsequences.
 * <p><br/>
 * Input:   str1 = "geek",  str2 = "eke"
 * Output: 5
 * Explanation:
 * String "geeke" has both string "geek"
 * and "eke" as subsequences.
 * <p><br/>
 * Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
 * Output:  9
 * Explanation:
 * String "AGXGTXAYB" has both string
 * "AGGTAB" and "GXTXAYB" as subsequences.
 * <br/>
 * <br/>
 **/

@Log4j2
public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String first;
        String second;

        first = "geek";
        second = "eke";
        print(first, second, maximum -> assertTrue(5 == maximum));

        first = "AGGTAB";
        second = "GXTXAYB";
        print(first, second, maximum -> assertTrue(9 == maximum));
    }

    private static void print(String first, String second, Consumer<Integer> expected) {
        log.info("Input:: Input1: {}\t | Input2: {}", first, second);
        int count = solveLCS(first, second);
        log.info("Output:: Count of shortest common super sequence is `{}`", count);
        expected.accept(count);
    }

    public static int solveLCS(String first, String second) {
        int[][] results = lcs(first, second, first.length(), second.length());
        int longestCommonSubsequenceCount = results[first.length()][second.length()];
        return first.length() + second.length() - longestCommonSubsequenceCount;
    }
}
