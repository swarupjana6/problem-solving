package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class BackspaceStringCompare {

    final BiConsumer<Boolean, Boolean> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P String 1st  :: {}
            I/P String 2nd  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract boolean compare(String first, String second);

    public void execute() {
        String first;
        String second;
        Boolean actual;
        Boolean expected;

        first = "ab#c";
        second = "ad#c";
        expected = true;
        actual = compare(first, second);
        log.debug(LOG_STR, getClass().getSimpleName(), first, second, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        first = "bxj##tw";
        second = "bxj###tw";
        expected = false;
        actual = compare(first, second);
        log.debug(LOG_STR, getClass().getSimpleName(), first, second, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        first = "y#fo##f";
        second = "y#f#o##f";
        expected = true;
        actual = compare(first, second);
        log.debug(LOG_STR, getClass().getSimpleName(), first, second, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}

