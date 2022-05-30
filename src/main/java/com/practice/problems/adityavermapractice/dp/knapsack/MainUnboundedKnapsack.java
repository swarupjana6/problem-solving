package com.practice.problems.adityavermapractice.dp.knapsack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainUnboundedKnapsack {

    public static void main(String[] args) {
        executeRodCuttingProblem();
        executeCoinChange1();
        executeCoinChange2();
    }

    private static void executeRodCuttingProblem() {
        assertEquals(RodCuttingProblem.topDown(new int[]{1, 2, 3, 4}, new int[]{5, 6, 8, 8}, 4, 4), 20);
    }

    private static void executeCoinChange1() {
        assertEquals(CoinChange1MaximumNumberOfWays.topDown(new int[]{2, 3, 5, 6}, 4, 10), 5);
        assertEquals(CoinChange1MaximumNumberOfWays.topDown(new int[]{1, 2, 3,}, 3, 5), 5);
        assertEquals(CoinChange1MaximumNumberOfWays.topDown(new int[]{1, 2, 3,}, 3, 4), 4);
    }

    private static void executeCoinChange2() {
        assertEquals(CoinChange2MinimumNoOfCoins.topDown(new int[]{1, 2, 3}, 3, 5), 2);
        //assertEquals(CoinChange2MinimumNoOfCoins.topDown(new int[]{2}, 1, 3), 0);
    }
}
