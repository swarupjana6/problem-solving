package com.practice.problems.adityaverma.dynamicprog.lcs;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.lcs.LargestCommonSubsequenceTopDown.lcs;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 **/

@Log4j2
public class SequencePatternMatching {

    public static void main(String[] args) {
        String first;
        String second;

        first = "AXY";
        second = "ADXCPY";
        print(first, second, maximum -> assertTrue(true));
    }

    private static void print(String first, String second, Consumer<Boolean> expected) {
        log.info("Input:: First: {}\t | Second: {}", first, second);
        boolean subsequences = solveLCS(first, second);
        log.info("Output:: Sequence Pattern Matched `{}`", subsequences);
        expected.accept(subsequences);
    }

    public static boolean solveLCS(String first, String second) {
        int[][] results = lcs(first, second, first.length(), second.length());
        String result = getLargestCommonSubsequence(results, first.toCharArray(), second.toCharArray());
        if (first.length() > second.length()) return result.equals(second);
        else return result.equals(first);
    }

    private static String getLargestCommonSubsequence(int[][] results, char[] first, char[] second) {
        StringBuilder result = new StringBuilder();
        int X = results.length - 1;
        int Y = results[0].length - 1;

        while (X > 0 && Y > 0) {
            if (first[X - 1] == second[Y - 1]) {
                result.append(first[X - 1]);
                X--;
                Y--;
            } else {
                if (results[X - 1][Y] > results[X][Y - 1]) X--;
                else Y--;
            }
        }
        return result.reverse().toString();
    }
}
