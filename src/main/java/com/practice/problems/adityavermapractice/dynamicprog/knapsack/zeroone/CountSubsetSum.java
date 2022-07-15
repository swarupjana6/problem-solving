package com.practice.problems.adityavermapractice.dynamicprog.knapsack.zeroone;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class CountSubsetSum {
    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Arr         :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;


    public abstract Integer countingSubsetSum(int[] numbers, int sum);

    public void execute() {
        int[] numbers;
        Integer expected;
        Integer actual;
        Integer sum;

        numbers = new int[]{2, 3, 5, 6, 8, 10};
        sum = 10;
        expected = 3;
        actual = countingSubsetSum(numbers, sum);
        log.debug(LOG_STR, getClass().getSimpleName(), numbers, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
