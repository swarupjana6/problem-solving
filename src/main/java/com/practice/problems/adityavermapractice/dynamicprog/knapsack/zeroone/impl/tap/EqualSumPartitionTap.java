package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.EqualSumPartition;

import java.util.Arrays;

public class EqualSumPartitionTap extends EqualSumPartition {

    private int[] numbers;

    private int sum;

    @Override
    public boolean calculateEqualSumPartition(int[] numbers) {
        int total = Arrays.stream(numbers).sum();;
        this.numbers = numbers;
        this.sum = total / 2;
        return total % 2 == 0 ? equalSumPartition(numbers.length, sum) : false;
        //return total % 2 == 0 ? equalSumPartitionR(numbers.length - 1, sum) : false;
    }

    public boolean equalSumPartitionR(int index, int sum) {
        if(sum == 0) return true;
        if(index == -1) return false;

        boolean resultValue;
        int number = numbers[index];
        boolean prevValue = equalSumPartitionR(index - 1, sum);
        if(number <= sum) resultValue = prevValue || equalSumPartitionR(index - 1, sum - number);
        else resultValue = prevValue;

        return resultValue;
    }

    public boolean equalSumPartition(int index, int sum) {
        return new SubsetSumTap().calculateSubsetSum(numbers, sum);
    }
}
