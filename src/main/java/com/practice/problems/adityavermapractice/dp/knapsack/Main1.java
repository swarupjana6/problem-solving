package com.practice.problems.adityavermapractice.dp.knapsack;

import java.util.Arrays;
import java.util.List;

import static com.practice.problems.adityavermapractice.dp.knapsack.KnapsackProblems.equalSumPartitionRecursive;
import static com.practice.problems.adityavermapractice.dp.knapsack.KnapsackProblems.equalSumPartitionTopdown;
import static com.practice.problems.adityavermapractice.dp.knapsack.ParentKnapsack.*;
import static com.practice.problems.adityavermapractice.dp.knapsack.SubsetSum.executeSubsetSumRecursive;
import static com.practice.problems.adityavermapractice.dp.knapsack.SubsetSum.executeSubsetSumTopdown;
import static org.junit.jupiter.api.Assertions.*;

public class Main1 {

    public static void main(String[] args) {
        executeSolve01Knapsack();
        executeSubsetSum();
        executeEqualSumPartition();
        executeCountOfSubsetSum();
        executeMinimumSubsetSumSequence();
        executeCountOfSubsetSumWithDifference();
        executeTargetSum();
    }

    private static void executeTargetSum() {
        assertEquals(3, TargetSum.topDown(new int[]{1, 1, 2, 3}, 1));
        assertEquals(0, TargetSum.topDown(new int[]{1}, 2));
        //assertEquals(256, TargetSum.topDown(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }

    private static void executeCountOfSubsetSumWithDifference() {
        assertEquals(3, CountOfSubsetSumWithDifference.topDown(new int[]{1, 1, 2, 3}, 1));
        assertEquals(0, CountOfSubsetSumWithDifference.topDown(new int[]{1}, 2));

        //assertEquals(3, CountOfSubsetSumWithDifference.recursion(new int[]{1, 1, 2, 3}, 1));
        assertEquals(0, CountOfSubsetSumWithDifference.recursion(new int[]{1}, 2));
    }

    private static void executeMinimumSubsetSumSequence() {
        assertEquals(4, MinimumSubsetSumSequence.topDown(new int[]{1, 2, 7}));
        assertEquals(0, MinimumSubsetSumSequence.topDown(new int[]{1, 4, 5}));
        assertEquals(1, MinimumSubsetSumSequence.topDown(new int[]{12, 1, 10}));
    }

    private static void executeCountOfSubsetSum() {
        int[] inputs = new int[]{2, 3, 5, 6, 8, 10};
        assertEquals(3, CountOfSubsetSum.topDown(inputs, 10));
        //assertEquals(3, CountOfSubsetSum.recursion(inputs, 10, inputs.length - 1));
    }

    private static void executeSubsetSum() {
        int[] inputs = new int[]{2, 3, 7, 8, 11};

        int[] trueResults = {2, 0, 3, 7, 8, 11};
        Arrays.stream(trueResults).forEach(expectedResult -> assertTrue(executeSubsetSumTopdown(inputs, expectedResult)));
        //Arrays.stream(trueResults).forEach(expectedResult -> assertTrue(executeSubsetSumRecursive(inputs, expectedResult)));

        int[] falseResults = {100, 1, 32};
        Arrays.stream(falseResults).forEach(expectedResult -> assertFalse(executeSubsetSumTopdown(inputs, expectedResult)));
        Arrays.stream(falseResults).forEach(expectedResult -> assertFalse(executeSubsetSumRecursive(inputs, expectedResult)));
    }

    private static void executeEqualSumPartition() {
        int[][] trueInputs = {
                {1, 5, 11, 5},
                {0, 5, 10, 5},
                {3, 5, 13, 5}
        };
        Arrays.stream(trueInputs).forEach(input -> assertTrue(equalSumPartitionRecursive(input)));
        Arrays.stream(trueInputs).forEach(input -> assertTrue(equalSumPartitionTopdown(input)));


        int[][] falseInputs = {
                {2, 5, 11, 5},
                {1, 5, 10, 5},
                {3, 5, 1, 5}
        };
        Arrays.stream(falseInputs).forEach(input -> assertFalse(equalSumPartitionRecursive(input)));
        Arrays.stream(falseInputs).forEach(input -> assertFalse(equalSumPartitionTopdown(input)));
    }

    private static void executeSolve01Knapsack() {
        List<Item> items = List.of(
                new Item(1, 1)
                , new Item(2, 6)
                , new Item(3, 10)
                , new Item(5, 16));

        assertTrue(solve01KnapsackRecursive(items, 7) == 22);
        assertTrue(solve01KnapsackMemoized(items, 7) == 22);
        assertTrue(solve01KnapsackTopDown(items, 7) == 22);
    }
}
