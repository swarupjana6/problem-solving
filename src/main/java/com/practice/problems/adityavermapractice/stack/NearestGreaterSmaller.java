package com.practice.problems.adityavermapractice.stack;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public abstract class NearestGreaterSmaller {

    protected String LOG_STR = """
            {}                             
            I/P List        :: {}
            O/P Indexes     :: {}
            O/P Elements    :: {}
            O/P Expected    :: {}
            """;

    protected abstract void execute();

    protected void test(List<Integer> input, List<Integer> actual, String indexMovement, List<Integer> expected) {
        Consumer<List<Integer>> expectedValidator = actualOutput -> assertEquals(expected, actual);
        String outputStr = actual.stream().map(i -> i != -1 && i < actual.size() ? input.get(i) : i).collect(Collectors.toList()).toString();
        log.debug(LOG_STR, indexMovement, input, actual, expected, outputStr);
        expectedValidator.accept(actual);
    }
}
