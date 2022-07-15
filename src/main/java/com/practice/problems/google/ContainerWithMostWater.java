package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class ContainerWithMostWater {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer maxArea(int[] heights);

    public void execute() {
        int[] heights;
        Integer actual;
        Integer expected;

        heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        expected = 49;
        actual = maxArea(heights);
        log.debug(LOG_STR, getClass().getSimpleName(), heights, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        heights = new int[]{1, 1};
        expected = 1;
        actual = maxArea(heights);
        log.debug(LOG_STR, getClass().getSimpleName(), heights, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
