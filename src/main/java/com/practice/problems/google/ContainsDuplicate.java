package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class ContainsDuplicate {

    final BiConsumer<Boolean, Boolean> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P String      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract boolean containsDuplicate(int[] nums);

    public void execute() {
        int[] nums;
        boolean actual;
        boolean expected;

        nums = new int[]{1, 2, 3};
        expected = false;
        actual = containsDuplicate(nums);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new int[]{1, 2, 3, 1};
        expected = true;
        actual = containsDuplicate(nums);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
