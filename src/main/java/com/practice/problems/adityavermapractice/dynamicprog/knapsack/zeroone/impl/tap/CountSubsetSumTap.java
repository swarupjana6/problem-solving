package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.CountSubsetSum;

public class CountSubsetSumTap extends CountSubsetSum {

    private int[] numbers;

    private int sum;

    @Override
    public Integer countingSubsetSum(int[] numbers, int sum) {
        this.numbers = numbers;
        this.sum = sum;
        return knapsackR(numbers.length - 1, sum);
    }

    private int knapsackR(int index, int sum) {
        if(sum == 0) return 1;
        if(index == -1) return 0;

        int count;
        int number = numbers[index];
        if(number <= sum) {
            int prevCount = knapsackR(index - 1, sum);
            int currentCount = knapsackR(index - 1, sum - number);
            count = prevCount + currentCount;
        } else {
            count = knapsackR(index - 1, sum);
        }

        return count;
    }
}
