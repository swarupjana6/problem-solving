package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public abstract class StockSpanProblem {

    protected String LOG_STR = """
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract List<Integer> stockSpan(List<Integer> inputList);

    public void execute() {
        List<Integer> input = Arrays.asList(100, 80, 60, 70, 60, 75, 85);
        List<Integer> actual = stockSpan(input);
        List<Integer> expected = List.of(1, 1, 1, 2, 1, 4, 6);

        Consumer<List<Integer>> expectedValidator = actualOutput -> assertEquals(expected, actual);
        log.debug(LOG_STR, input, actual, expected);
        expectedValidator.accept(actual);
    }
}
