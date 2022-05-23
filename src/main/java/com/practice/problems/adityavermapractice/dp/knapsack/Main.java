package com.practice.problems.adityavermapractice.dp.knapsack;

import java.util.Arrays;
import java.util.List;

import static com.practice.problems.adityavermapractice.dp.knapsack.KnapsackProblems.subsetSumTopdown;
import static com.practice.problems.adityavermapractice.dp.knapsack.ParentKnapsack.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    public static void main(String[] args) {
        //executeSolve01Knapsack();
        executeSubsetSum();
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

    private static void executeSolve01Knapsack() {
        List<Item> items = List.of(new Item(1, 1), new Item(2, 6), new Item(3, 10), new Item(5, 16));
        assertTrue(solve01KnapsackRecursive(items, 7) == 22);
        assertTrue(solve01KnapsackMemoized(items, 7) == 22);
        assertTrue(solve01KnapsackTopDown(items, 7) == 22);
    }
}
