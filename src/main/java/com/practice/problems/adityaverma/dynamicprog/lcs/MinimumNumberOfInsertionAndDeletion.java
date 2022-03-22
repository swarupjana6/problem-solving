package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.lcs.LargestCommonSubsequenceTopDown.knapsack;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively.
 * The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2.
 * It could be possible that the same character
 * needs to be removed/deleted from one point of str1 and inserted to some another point.
 * <p><br/>
 * Input :
 * str1 = "heap", str2 = "pea"
 * Output :
 * Minimum Deletion = 2 and
 * Minimum Insertion = 1
 * Explanation:
 * p and h deleted from heap
 * Then, p is inserted at the beginning
 * One thing to note, though p was required yet
 * it was removed/deleted first from its position and
 * then it is inserted to some other position.
 * Thus, p contributes one to the deletion_count
 * and one to the insertion_count.
 * <br/><br/>
 * <p><br/>
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * <p><br/>
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 * <p><br/>
 * Constraints:
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 * <br/><br/>
 **/

@Log4j2
public class MinimumNumberOfInsertionAndDeletion {

    public static void main(String[] args) {
        String first;
        String second;

        first = "heap";
        second = "eap";
        print(first, second, maximum -> assertTrue(1 == maximum));

        first = "heap";
        second = "pea";
        print(first, second, maximum -> assertTrue(3 == maximum));

        first = "leetcode";
        second = "etco";
        print(first, second, maximum -> assertTrue(4 == maximum));
    }

    private static void print(String first, String second, Consumer<Integer> expected) {
        log.info("Input:: Input1: {}\t | Input2: {}", first, second);
        int count = solveKnapsack(first, second);
        log.info("Output:: Minimum number of insertions/deletion is `{}`", count);
        expected.accept(count);
    }

    public static int solveKnapsack(String first, String second) {
        int[][] results = knapsack(first, second, first.length(), second.length());
        int longestCommonSubsequenceCount = results[first.length()][second.length()];
        return first.length() - longestCommonSubsequenceCount + second.length() - longestCommonSubsequenceCount;
    }
}
