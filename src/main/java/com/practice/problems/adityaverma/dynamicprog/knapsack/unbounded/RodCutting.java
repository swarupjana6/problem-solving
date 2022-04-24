package com.practice.problems.adityaverma.dynamicprog.knapsack.unbounded;

import lombok.extern.log4j.Log4j2;

import java.util.stream.IntStream;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMatrix;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length of the rod is 8 and the values of different pieces are given as the following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p><br/>
 * length   | 1   2   3   4   5   6   7   8<br/>
 * --------------------------------------------<br/>
 * price    | 1   5   8   9  10  17  17  20<br/>
 * And if the prices are as following,
 * then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * <p><br/>
 * length   | 1   2   3   4   5   6   7   8<br/>
 * --------------------------------------------<br/>
 * price    | 3   5   8   9  10  17  17  20<br/>
 **/

@Log4j2
public class RodCutting {

    public static void main(String[] args) {
        int rodLength = 4;
        int[] lengths = IntStream.rangeClosed(1, rodLength).toArray();
        int[] prices = {5, 6, 8, 8};
        log.info("Input:: Lengths: {}\t# Prices: {}\t# Knapsack Wt: {}", prices, lengths, rodLength);
        int maxPrice = solveKnapsack(lengths, prices, rodLength);
        log.info("Output:: Maximum Price: {}", maxPrice);
        assertTrue(maxPrice == 20);
    }

    public static int solveKnapsack(int[] lengths, int[] prices, int capacity) {
        return knapsack(lengths, prices, capacity, lengths.length);
    }

    private static int knapsack(int[] lengths, int[] prices, int capacity, int index) {
        int[][] results = new int[index + 1][capacity + 1];

        for (int i = 0; i <= index; i++) results[i][0] = 0;
        for (int i = 0; i <= capacity; i++) results[0][i] = 0;

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= capacity; j++) {

                int currValue = prices[i - 1];
                int currWeight = lengths[i - 1];
                if (currWeight > j)
                    results[i][j] = results[i - 1][j];
                else
                    results[i][j] = Math.max(results[i - 1][j], currValue + results[i][j - currWeight]);
            }
        }
        printMatrix(lengths, index, results, capacity);

        return results[index][capacity];
    }
}
