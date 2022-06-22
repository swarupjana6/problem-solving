package com.practice.problems.adityavermapractice.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

/**
 * We can scramble a string s to get a string t using the following algorithm:
 * <p><br\>
 * If the length of the string is 1, stop.
 * If the length of the string is > 1, do the following:
 * Split the string into two non-empty substrings at a random index,
 * i.e., if the string is s, divide it to x and y where s = x + y.
 * <p><br\>
 * Randomly decide to swap the two substrings or to keep them in the same order.
 * i.e., after this step, s may become s = x + y or s = y + x.
 * <p><br\>
 * Apply step 1 recursively on each of the two substrings x and y.
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
 * <p><br\>
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Explanation: One possible scenario applied on s1 is:<br\>
 * "great" --> "gr/eat" // divide at random index.<br\>
 * "gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.<br\>
 * "gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at random index each of them.<br\>
 * "g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.<br\>
 * "r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".<br\>
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.<br\>
 * The algorithm stops now, and the result string is "rgeat" which is s2.<br\>
 * As one possible scenario led s1 to be scrambled to s2, we return true.<br\>
 * <p><br\>
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * <p><br\>
 * Input: s1 = "a", s2 = "a"
 * Output: true
 * <br\><br\>
 */

@Log4j2
public abstract class ScrambledString {

    final BiConsumer<Boolean, Boolean> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem             :: {}
            Original String     :: {}
            Scrambled String    :: {}
            O/P actual          :: {}
            O/P expected        :: {}
            """;

    protected abstract Boolean memoizedMCM(String original, String scrambled);

    protected abstract Boolean recursiveMCM(String original, String scrambled);

    public void execute() {
        String original;
        String scrambled;
        Boolean actualRecursive;
        Boolean actualMemoized;
        Boolean expected;

        original = "great";
        scrambled = "rgeat";
        expected = true;
        actualRecursive = recursiveMCM(original, scrambled);
        log.debug(LOG_STR, getClass().getSimpleName(), original, scrambled, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = memoizedMCM(original, scrambled);
        log.debug(LOG_STR, getClass().getSimpleName(), original, scrambled, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);

        original = "great";
        scrambled = "bgeat";
        expected = false;
        actualRecursive = recursiveMCM(original, scrambled);
        log.debug(LOG_STR, getClass().getSimpleName(), original, scrambled, actualRecursive, expected);
        IS_EXPECTED.accept(expected, actualRecursive);
        actualMemoized = memoizedMCM(original, scrambled);
        log.debug(LOG_STR, getClass().getSimpleName(), original, scrambled, actualMemoized, expected);
        IS_EXPECTED.accept(expected, actualMemoized);
    }
}
