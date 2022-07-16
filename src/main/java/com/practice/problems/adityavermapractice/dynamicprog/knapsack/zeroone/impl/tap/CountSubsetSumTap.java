package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.CountSubsetSum;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMatrix;

public class CountSubsetSumTap extends CountSubsetSum {

    private int[] numbers;

    private int total;

    @Override
    public Integer countingSubsetSum(int[] numbers, int sum) {
        this.numbers = numbers;
        this.total = sum;
        //return knapsackR(numbers.length - 1, sum);
        return knapsack(numbers.length, sum);
    }

    private int knapsackR(int index, int sum) {
        if (sum == 0) return 1;
        if (index == -1) return 0;

        int count;
        int number = numbers[index];
        if (number <= sum) {
            int prevCount = knapsackR(index - 1, sum);
            int currentCount = knapsackR(index - 1, sum - number);
            count = prevCount + currentCount;
        } else {
            count = knapsackR(index - 1, sum);
        }

        return count;
    }

    private int knapsack(int index, int expectedSum) {
        int[][] results = new int[index + 1][expectedSum + 1];

        for (int sum = 0; sum < expectedSum + 1; sum++) results[0][sum] = 0;
        for (int idx = 0; idx < index + 1; idx++) results[idx][0] = 1;

        for (int idx = 1; idx < index + 1; idx++) {
            for (int sum = 1; sum < expectedSum + 1; sum++) {
                int number = numbers[idx - 1];

                if (sum >= number) results[idx][sum] = results[idx - 1][sum - number] + results[idx - 1][sum];
                else results[idx][sum] = results[idx - 1][sum];
            }
        }

        printMatrix(numbers, index, results, expectedSum);

        return results[index][expectedSum];
    }
}
