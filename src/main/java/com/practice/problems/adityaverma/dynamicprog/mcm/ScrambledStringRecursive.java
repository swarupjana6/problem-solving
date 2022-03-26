package com.practice.problems.adityaverma.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class ScrambledStringRecursive {

    public static void main(String[] args) {
        print("abc", "abc", expressionValue -> assertTrue(expressionValue));
        print("a", "a", expressionValue -> assertTrue(expressionValue));
        print("ab", "ba", expressionValue -> assertTrue(expressionValue));
        print("abc", "bca", expressionValue -> assertTrue(expressionValue));
        print("great", "rgeat", expressionValue -> assertTrue(expressionValue));
        //print("great", "grtae", expressionValue -> assertTrue(expressionValue));
    }

    private static void print(String original, String scrambled, Consumer<Boolean> expected) {
        log.info("Input:: {}\t ", original);
        boolean isScrambled = solve(original, scrambled);
        log.info("Output:: Is string `{}` is scrambled `{}`  :: `{}`", scrambled, original, isScrambled);
        expected.accept(isScrambled);
    }

    public static boolean solve(String original, String scrambled) {
        if (original == null && scrambled == null) return true;
        if (original == null && scrambled != null || original != null && scrambled == null) return false;
        if (original.equals(scrambled)) return true;
        if (original.length() != scrambled.length()) return false;
        if (original.length() <= 1) return false;

        int length = original.length();
        boolean isScrambled = false;

        for (int partition = 1; partition < length; partition++) {
            if (firstCondition(original, scrambled, partition, length) || secondCondition(original, scrambled, partition, length)) {
                isScrambled = true;
                break;
            }
        }
        return isScrambled;
    }

    private static boolean firstCondition(String original, String scrambled, int partition, int length) {
        // Partitioned String Original
        String orgFirst = original.substring(0, partition);
        String orgSecond = original.substring(partition, length);

        // Partitioned String Scrambled
        String srcFirst = scrambled.substring(0, partition);
        String srcSecond = scrambled.substring(partition, length);

        return solve(orgFirst, srcFirst) && solve(orgSecond, srcSecond);
    }

    private static boolean secondCondition(String original, String scrambled, int partition, int length) {
        //[g, | r, e, a, t]
        //[0 ,1, 2, 3, 4]
        //[r, g, e, a,| t]
        //[0 ,1, 2, 3, 4]

        // Partitioned String Original
        //[g, | r, e, a, t]
        String orgFirst = original.substring(0, partition);
        String orgSecond = original.substring(partition, length);

        // Partitioned String Scrambled
        String srcFirst = scrambled.substring(0, length - partition);
        String srcSecond = scrambled.substring(length - partition, length);

        return solve(orgFirst, srcSecond) && solve(orgSecond, srcFirst);
    }
}
