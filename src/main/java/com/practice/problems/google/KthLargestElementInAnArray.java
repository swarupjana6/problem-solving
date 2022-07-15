package com.practice.problems.google;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

@Log4j2
public abstract class KthLargestElementInAnArray {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P Number      :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer getKthLargest(int[] nums, int k);

    public void execute() {
        int[] nums;
        Integer actual;
        Integer expected;
        Integer k;

        nums = new int[]{3, 4, 6, 7, 2};
        k = 2;
        expected = 6;
        actual = getKthLargest(nums, k);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
