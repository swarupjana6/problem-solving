package com.practice.problems.adityaverma.dynamicprog.knapsack.unbounded;

import lombok.extern.log4j.Log4j2;

import java.util.function.Consumer;

import static com.practice.problems.adityaverma.dynamicprog.knapsack.PrintDPMatrix.printMatrix;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given a value N, if we want to make change for N cents,
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 * <p>
 * For example, for N = 4 and S = {1,2,3},
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4.
 * <p>
 * For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 **/

@Log4j2
public class CoinChangeMaxNoOfWays {

    public static void main(String[] args) {
        print(new int[]{1, 2, 3}, 5, count -> assertTrue(5 == count));
        print(new int[]{1, 2, 3}, 4, count -> assertTrue(4 == count));
        print(new int[]{2, 3, 5, 6}, 10, count -> assertTrue(5 == count));
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
        for (int x = 0; x <= amount; x++) results[0][x] = 0;
        for (int x = 0; x <= index; x++) results[x][0] = 1;

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= amount; j++) {

                int indexSum = coins[i - 1];

                if (indexSum > j) {
                    results[i][j] = results[i - 1][j];
                } else {
                    results[i][j] = results[i - 1][j] + results[i][j - indexSum];
                }
            }
        }

        printMatrix(coins, index, results, amount);

        return results;
    }
}
