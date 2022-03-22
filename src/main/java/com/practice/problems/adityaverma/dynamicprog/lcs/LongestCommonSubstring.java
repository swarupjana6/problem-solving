package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.knapsack.PrintDPMatrix.printMatrix;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * <p><br>
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
 * Output : 5
 * Explanation: The longest common substring is “Geeks” and is of length 5.
 * <p><br>
 * Input : X = “abcdxyz”, y = “xyzabcd”
 * Output : 4
 * Explanation: The longest common substring is “abcd” and is of length 4.
 * <p><br>
 * Input : X = “zxabcdezy”, y = “yzabcdezx”
 * Output : 6
 * Explanation: The longest common substring is “abcdez” and is of length 6.
 **/

@Log4j2
public class LongestCommonSubstring {

    private static int[][] results;

    public static void main(String[] args) {
        String first;
        String second;

        first = "abcdgh";
        second = "abedfhr";
        print(first, second, maximum -> assertTrue(2 == maximum));
    }

    private static void init(String first, String second) {
        results = new int[first.length() + 1][second.length() + 1];
        printMatrix(first.toCharArray(), second.toCharArray(), results);
    }

    private static void print(String first, String second, Consumer<Integer> expected) {
        init(first, second);
        log.info("Input:: Input1: {}\t | Input2: {}", first, second);
        int count = solveKnapsack(first, second);
        log.info("Output:: Largest Common Substring is `{}`", count);
        printMatrix(first.toCharArray(), second.toCharArray(), results);
        expected.accept(count);
    }

    public static int solveKnapsack(String first, String second) {
        return knapsack(first, second, first.length(), second.length());
    }

    public static int knapsack(String first, String second, int firstIndices, int secondIndices) {
        if (firstIndices == 0 || secondIndices == 0) return 0;
        int max = 0;

        for (int X = 0; X <= firstIndices; X++) results[X][0] = 0;
        for (int Y = 0; Y <= secondIndices; Y++) results[0][Y] = 0;

        for (int X = 1; X <= firstIndices; X++) {
            for (int Y = 1; Y <= secondIndices; Y++) {

                if (first.toCharArray()[X - 1] == second.toCharArray()[Y - 1]) {
                    results[X][Y] = 1 + results[X - 1][Y - 1];
                    max = Math.max(results[X][Y], max);
                } else {
                    results[X][Y] = 0;
                }
            }
        }

        return max;
    }
}
