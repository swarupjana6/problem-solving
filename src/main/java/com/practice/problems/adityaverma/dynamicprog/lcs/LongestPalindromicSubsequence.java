package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * <p><br/>
 * A subsequence is a sequence that can be derived from another sequence by deleting some
 * or no elements without changing the order of the remaining elements.
 * <p><br/>
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * <p><br/>
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 * <p><br/>
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 * <br/><br/>
 **/

@Log4j2
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String input;

        input = "agbcba";
        print(input, palindrome -> assertEquals("abcba", palindrome));
    }

    private static void print(String first, Consumer<String> expected) {
        log.info("Input:: Input1: {}\t | Input2: {}", first);
        String palindrome = solveLCS(first);
        log.info("Output:: Longest palindromic Subsequence is `{}`", palindrome);
        expected.accept(palindrome);
    }

    public static String solveLCS(String first) {
        String second = new StringBuilder(first).reverse().toString();
        return PrintLargestCommonSubsequence.solveLCS(first, second);
    }
}
