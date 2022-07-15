package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.SubsetSum;

public class SubsetSumTap extends SubsetSum {

    private int[] numbers;

    private int sum;

    @Override
    public boolean calculateSubsetSum(int[] numbers, int sum) {
        this.numbers = numbers;
        this.sum = sum;
        boolean[][] results = knapsack(numbers, sum);
        return results[numbers.length][sum];
        //return knapsackR(numbers.length - 1, sum);
    }

    private boolean knapsackR(int index, int sum) {
        if (sum == 0) return true;
        if (index == -1) return false;

        int number = numbers[index];
        boolean prevResult = knapsackR(index - 1, sum);
        boolean result;

        if (number <= sum) result = prevResult || knapsackR(index - 1, sum - number);
        else result = prevResult;

        return result;
    }

    public boolean[][] knapsack(int[] numbers, int total) {
        int index = numbers.length;
        boolean[][] results = new boolean[index + 1][total + 1];

        for (int idx = 0; idx < index + 1; idx++) results[idx][0] = true;
        for (int sum = 1; sum < total + 1; sum++) results[0][sum] = false;

        for (int idx = 1; idx < index + 1; idx++) {
            for (int sum = 1; sum < total + 1; sum++) {
                int number = numbers[idx - 1];

                boolean result = results[idx - 1][sum];
                if (sum >= number) result = result || results[idx - 1][sum - number];

                results[idx][sum] = result;
            }
        }

        //printMatrix(numbers, results, sum);
        return results;
    }
}
