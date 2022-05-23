package com.practice.problems.adityavermapractice.dp.knapsack;

import java.util.Arrays;

public class KnapsackProblems {
    public static boolean subsetSumRecursive(int[] inputs, int target) {
        return SubsetSum.recursion(inputs, target, inputs.length - 1);
    }

    public static boolean subsetSumTopdown(int[] inputs, int target) {
        return SubsetSum.topDown(inputs, target);
    }

    public static boolean equalSumPartitionRecursive(int[] inputs) {
        int target = Arrays.stream(inputs).mapToObj(e -> Integer.valueOf(e)).reduce(0, Integer::sum);
        if (target % 2 != 0) return false;
        return EqualSumPartition.recursion(inputs, target / 2, inputs.length - 1);
    }

    public static boolean equalSumPartitionTopdown(int[] inputs) {
        int target = Arrays.stream(inputs).mapToObj(e -> Integer.valueOf(e)).reduce(0, Integer::sum);
        if (target % 2 != 0) return false;
        return EqualSumPartition.topDown(inputs, target / 2);
    }
}

class SubsetSum {
    public static boolean recursion(int[] numbers, int sum, int index) {
        if (index == -1) return false;
        if (sum == 0) return true;

        int number = numbers[index];
        if (sum < number) {
            boolean exclude = recursion(numbers, sum, index - 1);
            return exclude;
        } else {
            boolean exclude = recursion(numbers, sum, index - 1);
            boolean include = recursion(numbers, sum - number, index - 1);
            return exclude || include;
        }
    }

    public static boolean topDown(int[] numbers, int expectedSum) {
        int orgIndex = numbers.length;
        boolean[][] results = new boolean[orgIndex + 1][expectedSum + 1];

        for (int index = 0; index <= orgIndex; index++) results[index][0] = true;   // Since sum is ZERO hence true
        for (int sum = 1; sum <= expectedSum; sum++) results[0][sum] = false;       // Since number is ZERO hence false

        for (int sum = 1; sum <= expectedSum; sum++) {
            for (int index = 1; index <= orgIndex; index++) {

                int number = numbers[index - 1];
                if (sum < number) {
                    boolean exclude = results[index - 1][sum];
                    results[index][sum] = exclude;
                } else {
                    boolean exclude = results[index - 1][sum];
                    boolean include = results[index - 1][sum - number];
                    results[index][sum] = exclude || include;
                }
            }
        }

        return results[orgIndex][expectedSum];
    }
}

class EqualSumPartition {
    public static boolean recursion(int[] numbers, int sum, int index) {
        return SubsetSum.recursion(numbers, sum, index);
    }

    public static boolean topDown(int[] numbers, int expectedSum) {
        return SubsetSum.topDown(numbers, expectedSum);
    }
}
