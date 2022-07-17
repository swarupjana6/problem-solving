package com.practice.problems.adityavermapractice.binarysearch;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class SearchElementInBitonicArray {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem             :: {}
            I/P Arr             :: {}
            O/P actual          :: {}
            O/P expected        :: {}
            """;

    public abstract Integer findElement(int[] nums, int search);

    public void execute() {
        int[] nums;
        int search;
        int actual;
        int expected;

        nums = new int[]{5, 10, 20, 15};
        search = 15;
        expected = 3;
        actual = findElement(nums, search);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new int[]{10, 20, 30, 40, 50, 90, 67};
        search = 30;
        expected = 2;
        actual = findElement(nums, search);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new int[]{10, 20, 30, 40, 50};
        search = 40;
        expected = 3;
        actual = findElement(nums, search);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
