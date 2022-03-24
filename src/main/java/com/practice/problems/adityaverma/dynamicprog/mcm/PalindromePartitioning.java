package com.practice.problems.adityaverma.dynamicprog.mcm;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class PalindromePartitioning {

    public static void main(String[] args) {
        print("NITIN", expectedPartitions -> assertTrue(expectedPartitions == 0));
        print("NITIK", expectedPartitions -> assertEquals(2, expectedPartitions));
    }

    private static void print(String inputStr, Consumer<Integer> expected) {
        char[] input = inputStr.toCharArray();
        log.info("Input:: {}\t ", input);

        int partitions = getMinimumPartitions(input, 0, input.length - 1);

        log.info("Output:: Is string `{}` a palindrome `{}`", input, partitions);
        expected.accept(partitions);
    }

    public static int getMinimumPartitions(char[] arr, int low, int high) {
        if (low >= high) return 0;

        if (isPalindrome(arr, low, high)) return 0;

        int minimum = Integer.MAX_VALUE;
        for (int partition = low; partition < high; partition++) {
            int leftPartitions = getMinimumPartitions(arr, low, partition);
            int rightPartitions = getMinimumPartitions(arr, partition + 1, high);
            int currentPartition = 1;

            int totalPartitions = leftPartitions + currentPartition + rightPartitions;
            minimum = Math.min(minimum, totalPartitions);
        }

        return minimum;
    }

    private static boolean isPalindrome(char[] arr, int low, int high) {
        while (low < high) if (arr[low++] != arr[high--]) return false;
        return true;
    }
}
