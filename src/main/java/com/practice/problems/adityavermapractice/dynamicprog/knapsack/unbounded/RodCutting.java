package com.practice.problems.adityavermapractice.dynamicprog.knapsack.unbounded;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

@Log4j2
public abstract class RodCutting {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            Lengths         :: {}
            Prices          :: {}
            RodLength       :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract Integer cutRod(int[] lengths, int[] prices, int capacity);

    public void execute() {
        int rodLength;
        int[] lengths;
        int[] prices;
        int actual;
        int expected;

        rodLength = 4;
        lengths = IntStream.rangeClosed(1, rodLength).toArray();
        prices = new int[]{5, 6, 8, 8};
        expected = 20;
        actual = cutRod(lengths, prices, rodLength);
        log.debug(LOG_STR, getClass().getSimpleName(), lengths, prices, rodLength, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
