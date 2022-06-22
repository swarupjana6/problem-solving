package com.practice.problems.adityavermapractice.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * <p><br/>
 * A palindrome string is a string that reads the same backward as forward.
 * <p><br/>
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * <p><br/>
 * Input: s = "a"
 * Output: [["a"]]
 * <p><br/>
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * <p><br/>
 * "n i t i k"      ===        "N || I T I || K"
 **/

@Log4j2
public abstract class PalindromePartitioning {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer memoizedMCM(char[] arr);

    protected abstract Integer recursiveMCM(char[] arr);

    public void execute() {
        String inputStr;
        char[] input;
        Integer actualRecursive;
        Integer actualMemoized;
        Integer expected;

        inputStr = "NITIN";
        input = inputStr.toCharArray();
        expected = 0;
        actualRecursive = recursiveMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = memoizedMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);

        inputStr = "NITIK";
        input = inputStr.toCharArray();
        expected = 2;
        actualRecursive = recursiveMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = memoizedMCM(input);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);
    }
}
