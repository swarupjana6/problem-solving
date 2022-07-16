package com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded.CoinChangeMinimumNoOfCoins;

public class CoinChangeMinimumNoOfCoinsTap extends CoinChangeMinimumNoOfCoins {

    private int[] coins;

    private int amount;

    @Override
    public Integer countChange(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;
        int index = coins.length;
        int noOfWays = ubKnapsack(index, amount);
        return noOfWays;
    }

    public int ubKnapsack(int index, int amount) {
        int[][] results = new int[index + 1][amount + 1];

        for(int amt = 0; amt < amount + 1; amt++) results[0][amount] = Integer.MAX_VALUE - 1;
        for(int amt = 0; amt < amount + 1; amt++) results[1][amount] = (amt % coins[0] == 0) ? amt/coins[0] : Integer.MAX_VALUE - 1;
        for(int idx = 0; idx < index + 1; idx++) results[idx][0] = 0;


        for(int idx = 1; idx < index + 1; idx++) {
            for(int amt = 1; amt < amount + 1; amt++) {
                int coin = coins[idx - 1];
                int previousMinCoins = results[idx - 1][amt];

                if(coin <= amt) results[idx][amt] = Math.min(previousMinCoins , results[idx][amt - coin] + 1);
                else results[idx][amt] = previousMinCoins;
            }
        }

        return results[index][amount];
    }
}
