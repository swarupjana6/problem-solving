package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class EqualSumPartition {
    final BiConsumer<Boolean, Boolean> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Arr         :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;


    public abstract boolean calculateEqualSumPartition(int[] numbers);

    public void execute() {
        int[] numbers;
        boolean expected;
        boolean actual;

        numbers = new int[]{1, 5, 11, 5};
        expected = true;
        actual = calculateEqualSumPartition(numbers);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        numbers = new int[]{3, 5, 11, 5};
        expected = false;
        actual = calculateEqualSumPartition(numbers);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
