package com.practice.problems.adityaverma.dynamicprog.knapsack.unbounded;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.PrintDPMatrix.printMatrix;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given a value V, if we want to make a change for V cents,
 * and we have an infinite supply of each of C = { C1, C2, .., Cm} valued coins,
 * what is the minimum number of coins to make the change? If it’s not possible to make a change, print -1.
 * <p><br/>
 * Input: coins[] = {25, 10, 5}, V = 30 <br/>
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 * <p><br/>
 * Input: coins[] = {9, 6, 5, 1}, V = 11 <br/>
 * Output: Minimum 2 coins required
 * We can use one coin of 6 cents and 1 coin of 5 cents
 **/

@Log4j2
public class CoinChangeMinimumNoOfCoins {

    public static void main(String[] args) {
        System.out.println(maximize(new int[]{2, 9, 4, 7, 5, 2}));
        System.out.println(maximize(new int[]{7, 4, 5, 2, 6, 5}));
        print(new int[]{1, 2, 3}, 5, count -> assertTrue(2 == count));
        print(new int[]{1, 2, 3}, 4, count -> assertTrue(2 == count));
        print(new int[]{2, 3, 5, 6}, 10, count -> assertTrue(2 == count));
    }

    private static void print(int[] coins, int amount, Consumer<Integer> expected) {
        int count;
        log.info("Input:: Coins: {}\t# Amount: {}", coins, amount);
        count = solveKnapsack(coins, amount);
        log.info("Output:: No of possible subsets: {}\n", count);
        expected.accept(count);
    }

    public static int solveKnapsack(int[] coins, int amount) {
        int[][] results = knapsack(coins, amount, coins.length);
        return results[coins.length][amount];
    }

    private static int[][] knapsack(int[] coins, int amount, int index) {
        var results = new int[index + 1][amount + 1];

        // Fill with: Number of ways get target amount
        for (int j = 0; j <= amount; j++) results[0][j] = Integer.MAX_VALUE - 1;
        for (int j = 0; j <= amount; j++) results[1][j] = (j % coins[0] == 0) ? j / coins[0] : Integer.MAX_VALUE - 1;
        for (int i = 0; i <= index; i++) results[i][0] = 0;

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= amount; j++) {

                int coinSum = coins[i - 1];

                if (coinSum > j) {
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = Math.min(results[i - 1][j], results[i][j - coinSum] + 1);
                }
            }
        }

        printMatrix(coins, index, results, amount);

        return results;
    }

    private static int maximize(int[] stacks) {
        int result = Integer.MIN_VALUE;
        Map<Integer, Integer> sums = new HashMap<>();

        for (int i = 0; i < stacks.length; i++) {
            int sum = stacks[i];
            int seed = stacks[i];
            for (int j = i; j > 0; j--) {
                --seed;
                if (stacks[j - 1] < stacks[j] && stacks[j - 1] < seed) {
                    if (sums.containsKey(j - 1)) {
                        sum += sums.get(j - 1);
                        break;
                    }
                }
                sum += seed;
            }
            sums.put(i, sum);
            result = Math.max(result, sum);
        }
        return result;
    }
}
