package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.MinimumSubsetSumDifference;

import java.util.Arrays;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMatrix;

public class MinimumSubsetSumDifferenceTap extends MinimumSubsetSumDifference {

    int[] numbers;

    @Override
    public int calculateSubsetSum(int[] numbers) {
        this.numbers = numbers;
        int total = Arrays.stream(numbers).sum();
        boolean[][] results = knapsack(numbers.length, total);

        int numsSize = numbers.length;
        int minimum = Integer.MAX_VALUE;
        int halfSubsetSumLength = results[numsSize].length / 2;
        for (int firstSum = 0; firstSum <= halfSubsetSumLength; firstSum++) {
            if (results[numsSize][firstSum]) {
                int secondSum = total - firstSum;
                int diff = Math.abs(secondSum - firstSum);
                minimum = Math.min(diff, minimum);
            }
        }

        return minimum;
    }

    private boolean[][] knapsack(int index, int expectedSum) {
        boolean[][] results = new boolean[numbers.length + 1][expectedSum + 1];

        for (int sum = 0; sum <= expectedSum; sum++) results[0][sum] = false;
        for (int idx = 0; idx <= index; idx++) results[idx][0] = true;

        for (int idx = 1; idx <= index; idx++) {
            for (int sum = 1; sum <= expectedSum; sum++) {
                int number = numbers[idx - 1];

                if (number > sum) {
                    results[idx][sum] = results[idx - 1][sum];
                } else {
                    results[idx][sum] = results[idx - 1][sum] || results[idx - 1][sum - number];
                }
            }
        }

        printMatrix(numbers, results, expectedSum);

        return results;
    }
}
