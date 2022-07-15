package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;
@Log4j2
public abstract class MajorityElement {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract int majority(int[] nums);
    public void execute() {
        int[] nums;
        Integer actual;
        Integer expected;

        nums = new int[]{3, 1, 10, 3, 5};
        actual = majority(nums);
        expected = 3;
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
