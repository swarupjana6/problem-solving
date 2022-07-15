package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class FizzBuzz {

    final BiConsumer<String[], String[]> IS_EXPECTED = (expected, actual) -> Assertions.assertArrayEquals(expected, actual);
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract String[] fizzBuzz(Integer num);

    public void execute() {
        Integer num;
        String[] actual;
        String[] expected;

        num = 15;
        expected = new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"};
        actual = fizzBuzz(num);
        log.debug(LOG_STR, getClass().getSimpleName(), num, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        num = 3;
        expected = new String[]{"1", "2", "Fizz"};
        actual = fizzBuzz(num);
        log.debug(LOG_STR, getClass().getSimpleName(), num, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
