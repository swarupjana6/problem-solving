package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

@Log4j2
public abstract class KthSmallestElement {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;

    protected String LOG_STR = """
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    public abstract Integer kthSmallest(List<Integer> inputList, int k);

    public void execute() {
        List<Integer> input = List.of(7, 10, 4, 3, 20, 15);
        Integer actual = kthSmallest(input, 3);
        Integer expected = 7;

        log.debug(LOG_STR, input, actual, expected);
        IS_EXPECTED.accept(actual, expected);
    }
}
