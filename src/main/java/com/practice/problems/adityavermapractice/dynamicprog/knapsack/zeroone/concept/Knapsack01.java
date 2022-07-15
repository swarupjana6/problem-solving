package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.concept;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Log4j2
public abstract class Knapsack01 {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Weights     :: {}
            I/P Values      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;


    public abstract int solveKnapsack(int[] weights, int[] values, int capacity);

    public void execute() {
        int[] weights;
        int[] values;
        int capacity;
        int expected;
        int actual;

        weights = new int[]{1, 2, 3, 5};
        values = new int[]{1, 6, 10, 16};
        capacity = 7;
        expected = 22;
        actual = solveKnapsack(weights, values, capacity);
        log.debug(LOG_STR, getClass().getSimpleName(), weights, values, actual, expected);
        IS_EXPECTED.accept(expected, actual);


        weights = new int[]{1, 2, 3, 5};
        values = new int[]{1, 6, 10, 16};
        capacity = 6;
        expected = 17;
        actual = solveKnapsack(weights, values, capacity);
        log.debug(LOG_STR, getClass().getSimpleName(), weights, values, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }

    public static void main(String[] args) {
        //Approach 1
        new Knapsack01Recursive().execute();
        //Approach 2
        new Knapsack01Memoized().execute();
        //Approach 3
        new Knapsack01TopDown().execute();
    }
}

class Knapsack01Recursive extends Knapsack01 {

    private int[] weights;
    private int[] values;

    @Override
    public int solveKnapsack(int[] weights, int[] values, int capacity) {
        this.weights = weights;
        this.values = values;
        return knapsack(capacity, weights.length - 1);
    }

    private int knapsack(int capacity, int index) {
        // IF >> index out of bound OR knapsack capacity ZERO
        if (index == -1 || capacity == 0) return 0;

        int result;
        int value = values[index];
        int weight = weights[index];

        int previousResult = knapsack(capacity, index - 1);
        if (weight > capacity) result = previousResult;
        else {
            int include = value + knapsack(capacity - weight, index - 1);
            result = Math.max(include, previousResult);
        }

        return result;
    }
}

class Knapsack01Memoized extends Knapsack01 {

    private int[] weights;
    private int[] values;
    private Map<String, Integer> results = new HashMap<>();

    @Override
    public int solveKnapsack(int[] weights, int[] values, int capacity) {
        this.weights = weights;
        this.values = values;
        return knapsack(capacity, weights.length - 1);
    }

    private int knapsack(int capacity, int index) {
        if (index == -1 || capacity == 0) return 0;
        String key = capacity + "-" + index;
        if (results.containsKey(key)) return results.get(key);

        int result;
        int value = values[index];
        int weight = weights[index];

        int previousResult = knapsack(capacity, index - 1);
        if (weight > capacity) result = previousResult;
        else {
            int include = value + knapsack(capacity - weight, index - 1);
            result = Math.max(include, previousResult);
        }

        results.put(key, result);
        return result;
    }
}

class Knapsack01TopDown extends Knapsack01 {

    private int[] weights;
    private int[] values;
    private int[][] results;

    @Override
    public int solveKnapsack(int[] weights, int[] values, int capacity) {
        this.weights = weights;
        this.values = values;
        return knapsack(capacity, weights.length);
    }

    private int knapsack(int capacity, int index) {
        results = new int[index + 1][capacity + 1];
        for (int idx = 0; idx < index + 1; idx++) results[idx][0] = 0;
        for (int cap = 0; cap < capacity + 1; cap++) results[0][cap] = 0;

        for (int idx = 1; idx < index + 1; idx++) {
            for (int cap = 1; cap < capacity + 1; cap++) {
                int value = values[idx - 1];
                int weight = weights[idx - 1];
                int previousResult = results[idx - 1][cap];

                int result = previousResult;
                if (cap >= weight) {
                    int include = value + results[idx - 1][cap - weight];
                    result = Math.max(result, include);
                }

                results[idx][cap] = result;
            }
        }

        return results[index][capacity];
    }
}
