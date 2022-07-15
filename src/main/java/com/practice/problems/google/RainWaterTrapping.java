package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class RainWaterTrapping {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer trap(int[] heights);

    public void execute() {
        int[] heights;
        Integer actual;
        Integer expected;

        heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        expected = 6;
        actual = trap(heights);
        log.debug(LOG_STR, getClass().getSimpleName(), heights, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        heights = new int[]{4, 2, 0, 3, 2, 5};
        expected = 9;
        actual = trap(heights);
        log.debug(LOG_STR, getClass().getSimpleName(), heights, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
