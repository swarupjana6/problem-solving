package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class KLargestElement {
    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract List<Integer> kLargest(List<Integer> inputList, int k);

    public void execute() {
        List<Integer> input = List.of(7, 10, 4, 3, 20, 15);
        List<Integer> actual = kLargest(input, 3);
        List<Integer> expected = List.of(10, 15, 20);

        Collections.sort(actual);
        log.debug(LOG_STR, input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
