package com.practice.problems.adityavermapractice.binarysearch;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class PeakElement {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem             :: {}
            I/P Arr             :: {}
            O/P actual          :: {}
            O/P expected        :: {}
            """;

    public abstract Integer indexOfPeak(int[] nums);

    public void execute() {
        int[] nums;
        int actual;
        int expected;

        nums = new int[]{5, 10, 20, 15};
        expected = 2;
        actual = indexOfPeak(nums);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new int[]{10, 20, 15, 2, 23, 90, 67};
        expected = 1;
        actual = indexOfPeak(nums);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new int[]{10, 20, 30, 40, 50};
        expected = 4;
        actual = indexOfPeak(nums);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
