package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string of size ‘n’.
 * The task is to remove or delete the minimum number of characters
 * from the string so that the resultant string is a palindrome.
 * <p><br/>
 * Note: The order of characters should be maintained.
 * <p><br/>
 * Input : aebcbda
 * Output : 2
 * Remove characters 'e' and 'd'
 * Resultant string will be 'abcba'
 * which is a palindromic string
 * <p><br/>
 * Input : geeksforgeeks
 * Output : 8
 * <br/><br/>
 **/

@Log4j2
public class MinimumNumberOfDeletionToMakePalindrome {

    public static void main(String[] args) {
        String input;

        input = "agbcba";
        print(input, palindrome -> assertEquals(1, palindrome));

        input = "geeksforgeeks";
        print(input, palindrome -> assertEquals(8, palindrome));

        input = "aebcbda";
        print(input, palindrome -> assertEquals(2, palindrome));
    }

    private static void print(String input, Consumer<Integer> expected) {
        log.info("Input:: Input: {}\t", input);
        int noOfDeletion = solveLCS(input);
        log.info("Output:: Number of deletions to make palindrome is `{}`", noOfDeletion);
        expected.accept(noOfDeletion);
    }

    public static int solveLCS(String input) {
        String palindrome = LongestPalindromicSubsequence.solveLCS(input);
        return input.length() - palindrome.length();
    }
}
