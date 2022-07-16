package com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded.CoinChangeNoOfWays;

public class CoinChangeNoOfWaysTap extends CoinChangeNoOfWays {

    private int[] coins;
    @Override
    public Integer countChange(int[] coins, int amount) {
        this.coins = coins;
        int index = coins.length;
        int noOfWays = ubKnapsack(index, amount);
        return noOfWays;
    }

    private Integer ubKnapsack(int index, int amount) {
        int[][] results = new int[index + 1][amount + 1];

        for(int amt = 0; amt < amount + 1; amt++) results[0][amt] = 0;
        for(int idx = 0; idx < index + 1; idx++) results[idx][0] = 1;

        for(int idx = 1; idx < index + 1; idx++) {
            for(int amt = 1; amt < amount + 1; amt++) {
                int coin = coins[idx - 1];
                int previousWays = results[idx - 1][amt];

                if(coin <= amt) results[idx][amt] = previousWays + results[idx][amt - coin];
                else results[idx][amt] = previousWays;
            }
        }

        return results[index][amount];
    }
}
