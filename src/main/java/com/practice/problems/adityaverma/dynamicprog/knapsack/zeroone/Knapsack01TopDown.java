package com.practice.problems.adityaverma.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.knapsack.PrintDPMatrix.printMatrix;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
public class Knapsack01TopDown {

    public static void main(String[] args) {
        int[] weights;
        int[] values;
        int capacity;

        weights = new int[]{1, 2, 3, 5};
        values = new int[]{1, 6, 10, 16};
        capacity = 7;
        print(weights, values, capacity, total -> assertTrue(22 == total));

        capacity = 6;
        print(weights, values, capacity, total -> assertTrue(17 == total));

        weights = new int[]{2, 3, 5, 7, 1, 4, 1};
        values = new int[]{10, 5, 15, 7, 6, 18, 3};
        capacity = 15;
        print(weights, values, capacity, total -> assertTrue(54 == total));
    }

    private static void print(int[] weights, int[] values, int capacity, Consumer<Integer> expected) {
        log.info("Input:: Weights: {}\t# Values: {}\t# Knapsack Wt: {}", weights, values, capacity);
        int total = solveKnapsack(weights, values, capacity);
        log.info("Output:: Total knapsack: {}", total);
        expected.accept(total);
    }

    public static int solveKnapsack(int[] weights, int[] values, int capacity) {
        return knapsack(weights, values, capacity, weights.length);
    }

    private static int knapsack(int[] weights, int[] values, int capacity, int index) {
        int[][] results = new int[index + 1][capacity + 1];

        for (int i = 0; i <= index; i++) results[i][0] = 0;
        for (int j = 0; j <= capacity; j++) results[0][j] = 0;

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= capacity; j++) {

                int currValue = values[i - 1];
                int currWeight = weights[i - 1];
                if (currWeight > j)
                    results[i][j] = results[i - 1][j];
                else
                    results[i][j] = Math.max(results[i - 1][j], currValue + results[i - 1][j - currWeight]);
            }
        }

        printMatrix(weights, values, index, results, capacity);

        return results[index][capacity];
    }
}
