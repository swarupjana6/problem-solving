package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class KSortedArray {
    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract List<Integer> kSortedArray(List<Integer> inputList, int k);

    public void execute() {
        List<Integer> input = List.of(6, 5, 3, 2, 8, 10, 9);
        List<Integer> actual = kSortedArray(input, 3);
        List<Integer> expected = List.of(8, 9, 10);

        Collections.sort(actual);
        log.debug(LOG_STR, input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
