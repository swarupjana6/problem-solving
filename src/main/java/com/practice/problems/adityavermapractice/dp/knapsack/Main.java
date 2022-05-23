package com.practice.problems.adityavermapractice.dp.knapsack;

import java.util.Arrays;
import java.util.List;

import static com.practice.problems.adityavermapractice.dp.knapsack.KnapsackProblems.*;
import static com.practice.problems.adityavermapractice.dp.knapsack.ParentKnapsack.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    public static void main(String[] args) {
        executeSolve01Knapsack();
        executeSubsetSum();
        executeEqualSumPartition();
    }

    private static void executeSubsetSum() {
        int[] inputs = new int[]{2, 3, 7, 8, 11};
        Arrays.stream(inputs).forEach(element -> assertTrue(SubsetSum.topDown(inputs, element)));
        assertTrue(subsetSumTopdown(inputs, 11));
        assertTrue(subsetSumTopdown(inputs, 2));
        assertTrue(subsetSumTopdown(inputs, 0));

        assertFalse(subsetSumTopdown(inputs, 100));
        assertFalse(subsetSumTopdown(inputs, 1));
        assertFalse(subsetSumTopdown(inputs, 32));
    }

    private static void executeEqualSumPartition() {
        assertTrue(equalSumPartitionRecursive(new int[]{1, 5, 11, 5}));
        assertTrue(equalSumPartitionRecursive(new int[]{0, 5, 10, 5}));
        assertTrue(equalSumPartitionRecursive(new int[]{3, 5, 13, 5}));
        assertTrue(equalSumPartitionTopdown(new int[]{1, 5, 11, 5}));
        assertTrue(equalSumPartitionTopdown(new int[]{0, 5, 10, 5}));
        assertTrue(equalSumPartitionTopdown(new int[]{3, 5, 13, 5}));

        assertFalse(equalSumPartitionRecursive(new int[]{2, 5, 11, 5}));
        assertFalse(equalSumPartitionRecursive(new int[]{1, 5, 10, 5}));
        assertFalse(equalSumPartitionRecursive(new int[]{3, 5, 1, 5}));
        assertFalse(equalSumPartitionTopdown(new int[]{2, 5, 11, 5}));
        assertFalse(equalSumPartitionTopdown(new int[]{1, 5, 10, 5}));
        assertFalse(equalSumPartitionTopdown(new int[]{3, 5, 1, 5}));
    }

    private static void executeSolve01Knapsack() {
        List<Item> items = List.of(new Item(1, 1), new Item(2, 6), new Item(3, 10), new Item(5, 16));
        assertTrue(solve01KnapsackRecursive(items, 7) == 22);
        assertTrue(solve01KnapsackMemoized(items, 7) == 22);
        assertTrue(solve01KnapsackTopDown(items, 7) == 22);
    }
}
