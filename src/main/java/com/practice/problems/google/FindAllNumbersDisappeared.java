package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class FindAllNumbersDisappeared {

    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract List<Integer> disappearedNumbers(int[] digits);

    public void execute() {
        int[] digits;
        List<Integer> actual;
        List<Integer> expected;

        digits = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        expected = List.of(5, 6);
        actual = disappearedNumbers(digits);
        log.debug(LOG_STR, getClass().getSimpleName(), digits, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
