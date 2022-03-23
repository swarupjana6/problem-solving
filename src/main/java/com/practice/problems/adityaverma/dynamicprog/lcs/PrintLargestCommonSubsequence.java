package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.lcs.LargestCommonSubsequenceTopDown.lcs;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return "".
 * <p><br/>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * <p><br/>
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p><br/>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: "ace"
 * Explanation: The longest common subsequence is "ace".
 * <p><br/>
 * Input: text1 = "abc", text2 = "abc"
 * Output: "abc"
 * Explanation: The longest common subsequence is "abc".
 * <p><br/>
 * Constraints:
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 **/

@Log4j2
public class PrintLargestCommonSubsequence {

    public static void main(String[] args) {
        String first;
        String second;

        first = "acbcf";
        second = "abcdaf";
        print(first, second, maximum -> assertEquals("abcf", maximum));

        first = "abcde";
        second = "ac";
        print(first, second, maximum -> assertEquals("ac", maximum));

        first = "abc";
        second = new StringBuilder(first).reverse().toString();
        print(first, second, maximum -> assertEquals("c", maximum));
    }

    private static void print(String first, String second, Consumer<String> expected) {
        log.info("Input:: Input1: {}\t | Input2: {}", first, second);
        String subsequences = getLCS(first, second);
        log.info("Output:: Largest Common Subsequence is `{}`", subsequences);
        expected.accept(subsequences);
    }

    public static String getLCS(String first, String second) {
        int[][] results = lcs(first, second, first.length(), second.length());
        return getLCSString(results, first.toCharArray(), second.toCharArray());
    }

    public static String getLCSString(int[][] results, char[] first, char[] second) {
        StringBuffer result = new StringBuffer();
        int X = results.length - 1;
        int Y = results[0].length - 1;

        while (X > 0 && Y > 0) {
            if (first[X - 1] == second[Y - 1]) {
                result.append(first[X - 1]);
                X--;
                Y--;
            } else {
                if (results[X - 1][Y] > results[X][Y - 1]) X--;
                else Y--;
            }
        }

        return result.reverse().toString();
    }
}
