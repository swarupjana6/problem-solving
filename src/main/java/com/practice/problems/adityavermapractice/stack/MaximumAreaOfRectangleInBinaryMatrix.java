package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class MaximumAreaOfRectangleInBinaryMatrix {

    final BiConsumer<Integer, Integer> IS_ACTUAL_LIST_VALID = Assertions::assertEquals;

    protected String LOG_STR = """
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract Integer maximumAreaOfRectangleInBinaryMatrix(List<List<Integer>> matrix);

    public void execute() {
        List<List<Integer>> matrix = List.of(List.of(0, 1, 1, 0)
                , List.of(0, 1, 1, 0)
                , List.of(0, 1, 1, 0)
                , List.of(0, 1, 1, 0));
        Integer actual = maximumAreaOfRectangleInBinaryMatrix(matrix);
        Integer expected = 8;

        log.debug(LOG_STR, matrix, actual, expected);
        IS_ACTUAL_LIST_VALID.accept(actual, expected);
    }
}
