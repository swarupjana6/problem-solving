package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class FindTheDifference {

    final BiConsumer<Character, Character> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P String 1st  :: {}
            I/P String 2nd  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Character difference(String first, String second);

    public void execute() {
        String first;
        String second;
        Character actual;
        Character expected;

        first = "abc";
        second = "acbe";
        expected = 'e';
        actual = difference(first, second);
        log.debug(LOG_STR, getClass().getSimpleName(), first, second, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}

