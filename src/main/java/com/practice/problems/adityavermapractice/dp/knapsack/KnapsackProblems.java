package com.practice.problems.adityavermapractice.dp.knapsack;

import java.util.Arrays;

public class KnapsackProblems {
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

    public static boolean executeSubsetSumRecursive(int[] inputs, int target) {
        return recursion(inputs, target, inputs.length - 1);
    }

    public static boolean executeSubsetSumTopdown(int[] inputs, int target) {
        return topDown(inputs, target);
    }

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
        boolean[][] results = subsetSum(numbers, expectedSum);
        return results[numbers.length][expectedSum];
    }

    public static boolean[][] subsetSum(int[] numbers, int expectedSum) {
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
        return results;
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

class CountOfSubsetSum {

    public static int recursion(int[] numbers, int sum, int index) {
        if (index == -1) return 0;
        if (sum == 0) return 1;

        int number = numbers[index];
        if (sum < number) {
            int exclude = recursion(numbers, sum, index - 1);
            return exclude;
        } else {
            int exclude = recursion(numbers, sum, index - 1);
            int include = recursion(numbers, sum - number, index - 1);
            return exclude + include;
        }
    }

    public static int topDown(int[] numbers, int expectedSum) {
        int numbersSum = Arrays.stream(numbers).sum();
        if (numbersSum < expectedSum) return 0;

        int orgIndex = numbers.length;

        int[][] results = new int[orgIndex + 1][expectedSum + 1];

        for (int index = 0; index <= orgIndex; index++) results[index][0] = 1;
        for (int sum = 1; sum <= expectedSum; sum++) results[0][sum] = 0;

        for (int index = 1; index <= orgIndex; index++) {
            for (int sum = 1; sum <= expectedSum; sum++) {

                int num = numbers[index - 1];
                if (sum < num) {
                    int exclude = results[index - 1][sum];
                    results[index][sum] = exclude;
                } else {
                    int exclude = results[index - 1][sum];
                    int include = results[index - 1][sum - num];
                    results[index][sum] += include + exclude;
                }
            }
        }

        return results[orgIndex][expectedSum];
    }
}

class MinimumSubsetSumSequence {
    public static int topDown(int[] numbers) {
        int expectedSum = Arrays.stream(numbers).sum();
        boolean[][] results = SubsetSum.subsetSum(numbers, expectedSum);
        int min = Integer.MAX_VALUE;

        for (int sum = 0; sum <= expectedSum / 2; sum++) {
            if (results[numbers.length][sum]) {
                int diff = (expectedSum - 2 * sum);
                min = Math.min(min, diff);
            }
        }
        return min;
    }
}

class CountOfSubsetSumWithDifference {
    public static int topDown(int[] numbers, int difference) {
        int sum = Arrays.stream(numbers).sum();
        if (sum < difference || (sum + difference) % 2 != 0) return 0;
        int subset1Sum = getSubset1Sum(difference, sum);
        return CountOfSubsetSum.topDown(numbers, subset1Sum);
    }

    public static int recursion(int[] numbers, int difference) {
        int sum = Arrays.stream(numbers).sum();
        if (sum < difference || (sum + difference) % 2 != 0) return 0;
        int subset1Sum = getSubset1Sum(difference, sum);
        return CountOfSubsetSum.recursion(numbers, subset1Sum, numbers.length - 1);
    }

    private static int getSubset1Sum(int difference, int sum) {
        /**
         subset1Sum + subset2Sum = sum;
         subset1Sum - subset2Sum = difference;
         -------------------------------
         2 * subset1Sum = sum + difference;
         subset1Sum     = (sum + difference)/2;
         **/
        int subset1Sum = (sum + difference) / 2;
        return subset1Sum;
    }
}

class TargetSum {
    public static int topDown(int[] numbers, int target) {
        int totalSum = Arrays.stream(numbers).sum();
        if (totalSum < target || (totalSum + target) % 2 != 0) return 0;
        int firstSubsetSum = (totalSum + target) / 2;
        return countOfSum(numbers, firstSubsetSum);
        //return CountOfSubsetSumWithDifference.topDown(numbers, firstSubsetSum);
    }

    private static int countOfSum(int[] numbers, int targetSum) {
        int counts[] = new int[targetSum + 1];
        counts[0] = 1;

        for (int index = 0; index < numbers.length; index++)
            for (int sum = targetSum; sum >= numbers[index]; sum--)
                counts[sum] = counts[sum] + counts[sum - numbers[index]];

        return counts[targetSum];
    }
}
