package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.lcs.LargestCommonSubsequenceTopDown.lcs;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.
 * If there are multiple valid strings, return any of them.
 * <p><br/>
 * A string s is a subsequence of string t
 * if deleting some number of characters from t (possibly 0) results in the string s.
 * <p><br/>
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 * <p><br/>
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * Output: "aaaaaaaa"
 * <p><br/>
 * Constraints:
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 * <br/><br/>
 **/

@Log4j2
public class PrintShortestCommonSuperSequence {

    public static void main(String[] args) {
        String first;
        String second;

        first = "abac";
        second = "cab";
        print(first, second, shortest -> assertEquals("cabac", shortest));

        first = "acbcf";
        second = "abcdaf";
        print(first, second, shortest -> assertEquals("acbcdaf", shortest));
    }

    private static void print(String first, String second, Consumer<String> expected) {
        log.info("Input:: First: {}\t | Second: {}", first, second);
        String subsequences = solveLCS(first, second);
        log.info("Output:: Shortest Common Super Sequence is `{}`", subsequences);
        expected.accept(subsequences);
    }

    public static String solveLCS(String first, String second) {
        int[][] results = lcs(first, second, first.length(), second.length());
        return getShortestCommonSuperSequenceString(results, first.toCharArray(), second.toCharArray());
    }

    public static String getShortestCommonSuperSequenceString(int[][] results, char[] first, char[] second) {
        StringBuffer result = new StringBuffer();
        int X = results.length - 1;
        int Y = results[0].length - 1;

        while (X > 0 && Y > 0) {
            if (first[X - 1] == second[Y - 1]) {
                result.append(first[X - 1]);
                X--;
                Y--;
            } else {
                if (results[X - 1][Y] > results[X][Y - 1]) {
                    result.append(first[X - 1]);
                    X--;
                } else {
                    result.append(second[Y - 1]);
                    Y--;
                }
            }
        }

        while (Y > 0) result.append(second[--Y]);
        while (X > 0) result.append(first[--X]);

        return result.reverse().toString();
    }
}
