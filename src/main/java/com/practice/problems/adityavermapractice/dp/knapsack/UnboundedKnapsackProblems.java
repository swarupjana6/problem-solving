package com.practice.problems.adityavermapractice.dp.knapsack;

public class UnboundedKnapsackProblems {

    public static int rodCuttingProblemRecursive(int[] rods, int[] values, int index, int rodLength) {
        return RodCuttingProblem.recursion(rods, values, rodLength, index);
    }

    public static int rodCuttingProblemTopdown(int[] rods, int[] values, int index, int rodLength) {
        return RodCuttingProblem.topDown(rods, values, index, rodLength);
    }
}


class RodCuttingProblem {

    public static int recursion(int[] rods, int[] values, int index, int capacity) {
        return 0;
    }

    public static int topDown(int[] lengths, int[] values, int index, int capacity) {
        int[][] results = new int[index + 1][capacity + 1];

        for (int length = 0; length <= index; length++) results[length][0] = 0;
        for (int cap = 0; cap <= capacity; cap++) results[0][cap] = 0;

        for (int length = 1; length <= index; length++) {
            for (int cap = 1; cap <= capacity; cap++) {

                int rodLength = lengths[length - 1];
                int rodValue = values[length - 1];

                if (rodLength > cap) {
                    int exclude = results[length - 1][cap];
                    results[length][cap] = exclude;
                } else {
                    int include = rodValue + results[length][cap - rodLength];
                    int exclude = results[length - 1][cap];
                    results[length][cap] = Math.max(include, exclude);
                }
            }
        }

        return results[index][capacity];
    }
}

class CoinChange1MaximumNumberOfWays {

    public static int recursion(int[] coins, int index, int capacity) {
        return 0;
    }

    public static int topDown(int[] coins, int indices, int amount) {
        int[][] results = new int[amount + 1][indices + 1];

        for (int sum = 0; sum <= amount; sum++) results[sum][0] = 0;
        for (int index = 1; index <= indices; index++) results[0][index] = 1;


        for (int index = 1; index <= indices; index++) {
            for (int sum = 1; sum <= amount; sum++) {
                int coin = coins[index - 1];

                if (coin > sum) {
                    int exclude = results[sum][index - 1];
                    results[sum][index] = exclude;
                } else {
                    int include = results[sum][index - 1];
                    int exclude = results[sum - coin][index];
                    results[sum][index] = include + exclude;
                }
            }
        }

        return results[amount][indices];
    }
}

class CoinChange2MinimumNoOfCoins {

    public static int recursion(int[] coins, int index, int capacity) {
        return 0;
    }

    public static int topDown(int[] coins, int indices, int amount) {
        int[][] results = new int[amount + 1][indices + 1];


        for (int sum = 0; sum <= amount; sum++) results[sum][0] = Integer.MAX_VALUE - 1;
        for (int index = 0; index <= indices; index++) results[0][index] = 0;
        for (int sum = 1; sum <= amount; sum++)
            results[sum][1] = (sum % coins[0] == 0) ? sum / coins[0] : Integer.MAX_VALUE - 1;

        for (int index = 1; index <= indices; index++) {
            for (int sum = 1; sum <= amount; sum++) {
                int coin = coins[index - 1];

                if (coin > sum) {
                    int exclude = results[sum][index - 1];
                    results[sum][index] = exclude;
                } else {
                    int include = 1 + results[sum - coin][index];
                    int exclude = results[sum][index - 1];
                    results[sum][index] = Math.min(include, exclude);
                }
            }
        }

        return results[amount][indices];
    }
}
