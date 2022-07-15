package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.function.BiConsumer;

@Log4j2
public abstract class NumberOfIslands {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer noOfIslands(Integer[][] area);

    public void execute() {
        Integer[][] area;
        Integer actual;
        Integer expected;

        area = new Integer[][]{
                {1, 0, 0, 0}
                , {1, 1, 1, 0}
                , {0, 0, 0, 1}};
        expected = 2;
        actual = noOfIslands(Arrays.copyOf(area, area.length));
        log.debug(LOG_STR, getClass().getSimpleName(), area, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        area = new Integer[][]{
                {1, 0, 0, 0}
                , {1, 1, 1, 0}
                , {0, 0, 0, 1}
                , {0, 0, 1, 0}
                , {0, 1, 0, 0}
                };
        expected = 4;
        actual = noOfIslands(Arrays.copyOf(area, area.length));
        log.debug(LOG_STR, getClass().getSimpleName(), area, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
