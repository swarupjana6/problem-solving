package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class ClimbingStairs {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract int noOfWays(int stairs);

    public void execute() {
        int stairs;
        Integer actual;
        Integer expected;

        stairs = 2;
        actual = noOfWays(stairs);
        expected = 2;
        log.debug(LOG_STR, getClass().getSimpleName(), stairs, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        stairs = 4;
        expected = 5;
        actual = noOfWays(stairs);
        log.debug(LOG_STR, getClass().getSimpleName(), stairs, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
