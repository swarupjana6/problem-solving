package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMatrix;
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

    public static void main(String[] args) {
        String first;
        String second;

        first = "abcdgh";
        second = "abedfhr";
        print(first, second, maximum -> assertTrue(2 == maximum));
    }

    private static void print(String first, String second, Consumer<Integer> expected) {
        log.info("Input:: Input1: {}\t | Input2: {}", first, second);
        int count = longestCommonSubstring(first, second);
        log.info("Output:: Largest Common Substring is `{}`", count);
        expected.accept(count);
    }

    public static int longestCommonSubstring(String first, String second) {
        int max = 0;
        int firstIndices = first.length();
        int secondIndices = second.length();
        int[][] results = new int[firstIndices + 1][secondIndices + 1];
        if (firstIndices == 0 || secondIndices == 0) return max;


        for (int Y = 0; Y <= firstIndices; Y++) results[Y][0] = 0;
        for (int X = 0; X <= secondIndices; X++) results[0][X] = 0;

        for (int Y = 1; Y <= firstIndices; Y++) {
            for (int X = 1; X <= secondIndices; X++) {

                if (first.toCharArray()[Y - 1] == second.toCharArray()[X - 1]) {
                    results[Y][X] = 1 + results[Y - 1][X - 1];
                    max = Math.max(results[X][Y], max);
                } else {
                    results[Y][X] = 0;
                }
            }
        }

        printMatrix(first.toCharArray(), second.toCharArray(), results);

        return max;
    }
}
