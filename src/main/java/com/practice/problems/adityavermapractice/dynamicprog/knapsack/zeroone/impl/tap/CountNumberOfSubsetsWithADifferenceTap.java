package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone.CountNumberOfSubsetsWithADifference;

import java.util.Arrays;

public class CountNumberOfSubsetsWithADifferenceTap extends CountNumberOfSubsetsWithADifference {

    @Override
    public int countSubsets(int[] numbers, int difference) {
        int total = Arrays.stream(numbers).sum();
        // firstSum - secondSum = diff
        // firstSum + secondSum = total
        // -----------------------------
        // 2 * firstSum  = total + diff
        // firstSum = (total + diff) / 2
        int firstSum = (total + difference) / 2;
        int count = new CountSubsetSumTap().countingSubsetSum(numbers, firstSum);

        return count;
    }
}
