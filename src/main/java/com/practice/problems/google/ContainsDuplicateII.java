package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class ContainsDuplicateII {

    final BiConsumer<Boolean, Boolean> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P String      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract boolean containsDuplicateII(int[] nums, int k);

    public void execute() {
        int[] nums;
        int k;
        boolean actual;
        boolean expected;

        nums = new int[]{1, 2, 3, 1};
        k = 3;
        expected = true;
        actual = containsDuplicateII(nums, k);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new int[]{1, 0, 1, 1};
        k = 1;
        expected = true;
        actual = containsDuplicateII(nums, k);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new int[]{1, 2, 3, 1, 2, 3};
        k = 2;
        expected = false;
        actual = containsDuplicateII(nums, k);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}

