package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class StockSpanProblem {

    final BiConsumer<List<Integer>, List<Integer>> IS_ACTUAL_LIST_VALID = Assertions::assertEquals;

    protected String LOG_STR = """
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract List<Integer> stockSpan(List<Integer> inputList);

    public void execute() {
        List<Integer> input = List.of(100, 80, 60, 70, 60, 75, 85);
        List<Integer> actual = stockSpan(input);
        List<Integer> expected = List.of(1, 1, 1, 2, 1, 4, 6);

        log.debug(LOG_STR, input, actual, expected);
        IS_ACTUAL_LIST_VALID.accept(actual, expected);
    }
}
