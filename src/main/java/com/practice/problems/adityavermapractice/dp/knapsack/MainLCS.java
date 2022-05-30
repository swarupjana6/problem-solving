package com.practice.problems.adityavermapractice.dp.knapsack;

import static com.practice.problems.adityavermapractice.dp.knapsack.LCSProblems.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainLCS {

    public static void main(String[] args) {
        assertEquals(exeLongestCommonSubsequenceRecursive("abcdgh", "abedfhr"), 4);
        assertEquals(exeLongestCommonSubsequenceMemoized("abcdgh", "abedfhr"), 4);
        assertEquals(exeLongestCommonSubsequenceTopDown("abcdgh", "abedfhr"), 4);

        assertEquals(exeLongestCommonSubStringRecursive("abcde", "abfde"), 2);
        assertEquals(exeLongestCommonSubStringTopDown("abcde", "abfde"), 2);
        assertEquals(exeLongestCommonSubStringMemoized("abcde", "abfde"), 2);

        assertEquals(exePrintLongestCommonSubsequenceTopDown("acbcf", "abcdaf"), "abcf");

        assertEquals(exePrintShortestCommonSuperSequenceTopDown("AGGTAB", "GXTXAYB"), "AGGXTXAYB");
    }
}
