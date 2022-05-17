package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Log4j2
public abstract class NearestGreaterSmaller {

    final BiConsumer<List<Integer>, List<Integer>> IS_ACTUAL_LIST_VALID = Assertions::assertEquals;

    protected final String LOG_STR = """
            {}                             
            I/P List        :: {}
            O/P Indexes     :: {}
            O/P Elements    :: {}
            O/P Expected    :: {}
            """;

    public abstract void execute();

    protected void test(List<Integer> input, List<Integer> actual, String indexMovement, List<Integer> expected) {
        String outputStr = actual.stream().map(i -> i != -1 && i < actual.size() ? input.get(i) : i).collect(Collectors.toList()).toString();
        log.debug(LOG_STR, indexMovement, input, actual, expected, outputStr);
        IS_ACTUAL_LIST_VALID.accept(actual, expected);
    }
}
