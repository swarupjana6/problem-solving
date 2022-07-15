package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class ReverseInteger {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer reverseInteger(Integer num);

    public void execute() {
        Integer num;
        Integer actual;
        Integer expected;

        num = -123;
        expected = -321;
        actual = reverseInteger(num);
        log.debug(LOG_STR, getClass().getSimpleName(), num, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        num = -1200;
        expected = -21;
        actual = reverseInteger(num);
        log.debug(LOG_STR, getClass().getSimpleName(), num, actual, expected);
        IS_EXPECTED.accept(expected, actual);


        num = -1201;
        expected = -1021;
        actual = reverseInteger(num);
        log.debug(LOG_STR, getClass().getSimpleName(), num, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        num = 900000;
        expected = 9;
        actual = reverseInteger(num);
        log.debug(LOG_STR, getClass().getSimpleName(), num, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}

