package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class FruitIntoBaskets {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer totalFruits(int[] fruits, int type);

    public void execute() {
        int[] fruits;
        int count = 2;
        Integer actual;
        Integer expected;

        fruits = new int[]{1, 2, 1};
        expected = 3;
        actual = totalFruits(fruits, count);
        log.debug(LOG_STR, getClass().getSimpleName(), fruits, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        fruits = new int[]{0, 1, 2, 2};
        expected = 3;
        actual = totalFruits(fruits, count);
        log.debug(LOG_STR, getClass().getSimpleName(), fruits, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        fruits = new int[]{0};
        expected = 1;
        actual = totalFruits(fruits, count);
        log.debug(LOG_STR, getClass().getSimpleName(), fruits, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
