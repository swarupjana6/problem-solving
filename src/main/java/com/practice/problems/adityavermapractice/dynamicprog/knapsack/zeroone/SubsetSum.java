package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class SubsetSum {
    final BiConsumer<Boolean, Boolean> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Arr         :: {}
            I/P Sum         :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;


    public abstract boolean calculateSubsetSum(int[] numbers, int sum);

    public void execute() {
        int[] numbers;
        int sum;
        boolean expected;
        boolean actual;

        numbers = new int[]{1, 2, 3, 5};
        sum = 11;
        expected = true;
        actual = calculateSubsetSum(numbers, sum);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, sum, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        numbers = new int[]{2, 3, 7, 8, 10};
        sum = 101;
        expected = false;
        actual = calculateSubsetSum(numbers, sum);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, sum, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
