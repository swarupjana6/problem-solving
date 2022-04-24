package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.lcs.MinimumNumberOfDeletionToMakePalindrome.lcsMinNoOfDeletionsToMakePalindrome;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string s. In one step you can insert any character at any index of the string.
 * <p><br\>
 * Return the minimum number of steps to make s palindrome.
 * <p><br\>
 * A Palindrome String is one that reads the same backward as well as forward.
 * <p><br\>
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 * <p><br\>
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * <p><br\>
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 * <br\><br\>
 **/

@Log4j2
public class MinimumNumberOfInsertionToMakePalindrome {

    public static void main(String[] args) {
        String input;

        input = "mbadm";
        print(input, palindrome -> assertEquals(2, palindrome));

        input = "AbA";
        print(input, palindrome -> assertEquals(0, palindrome));
    }

    private static void print(String input, Consumer<Integer> expected) {
        log.info("Input:: Input: {}\t", input);
        int noOfInsertions = lcsMinNoOfDeletionsToMakePalindrome(input);
        log.info("Output:: Number of insertion(s) to make palindrome is `{}`", noOfInsertions);
        expected.accept(noOfInsertions);
    }
}
