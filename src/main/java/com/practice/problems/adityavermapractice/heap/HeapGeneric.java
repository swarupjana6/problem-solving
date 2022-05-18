package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class HeapGeneric<I, K, R> {

    private I input;

    private K k;
    private R expected;

    public HeapGeneric(I input, K k, R expected) {
        this.input = input;
        this.k = k;
        this.expected = expected;
    }

    final BiConsumer<R, R> IS_EXPECTED = Assertions::assertEquals;

    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract R solution(I input, K k);

    public void execute() {
        R actual = solution(input, k);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
