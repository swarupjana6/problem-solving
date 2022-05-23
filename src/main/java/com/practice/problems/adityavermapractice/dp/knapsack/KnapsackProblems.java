package com.practice.problems.adityavermapractice.dp.knapsack;

public class KnapsackProblems {
    public static boolean subsetSumRecursive(int[] inputs, int target) {
        return SubsetSum.recursion(inputs, target, inputs.length - 1);
    }

    public static boolean subsetSumTopdown(int[] inputs, int target) {
        return SubsetSum.topDown(inputs, target);
    }
}

class SubsetSum {
    public static boolean recursion(int[] numbers, int sum, int index) {
        if (index == 0) return true;
        if (sum == 0) return false;

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

        for (int index = 0; index <= orgIndex; index++) {
            results[index][0] = true;
        }
        for (int sum = 1; sum <= expectedSum; sum++) results[0][sum] = false;

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
