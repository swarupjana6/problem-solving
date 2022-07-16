package com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class CoinChangeMinimumNoOfCoins {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Coins       :: {}
            I/P Amount      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract Integer countChange(int[] coins, int amount);

    public void execute() {
        int[] coins;
        int amount;
        int actual;
        int expected;

        coins = new int[]{1, 2, 3};
        amount = 5;
        expected = 2;
        actual = countChange(coins, amount);
        log.debug(LOG_STR, getClass().getSimpleName(), coins, amount, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        coins = new int[]{1, 2, 3};
        amount = 4;
        expected = 2;
        actual = countChange(coins, amount);
        log.debug(LOG_STR, getClass().getSimpleName(), coins, amount, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        coins = new int[]{2, 3, 5, 6};
        amount = 10;
        expected = 2;
        actual = countChange(coins, amount);
        log.debug(LOG_STR, getClass().getSimpleName(), coins, amount, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
