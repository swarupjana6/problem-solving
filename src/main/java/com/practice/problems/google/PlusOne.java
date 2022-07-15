package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.function.BiConsumer;

@Log4j2
public abstract class PlusOne {

    final BiConsumer<int[], int[]> IS_EXPECTED = Assertions::assertArrayEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract int[] plusOne(int[] num);

    public void execute() {
        int[] num;
        int[] actual;
        int[] expected;

        num = new int[]{1, 2, 3};
        expected = new int[]{1, 2, 4};
        actual = plusOne(Arrays.copyOf(num, num.length));
        log.debug(LOG_STR, getClass().getSimpleName(), num, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        num = new int[]{9, 9, 9};
        expected = new int[]{1, 0, 0, 0};
        actual = plusOne(Arrays.copyOf(num, num.length));
        log.debug(LOG_STR, getClass().getSimpleName(), num, actual, expected);
        IS_EXPECTED.accept(expected, actual);

    }
}

