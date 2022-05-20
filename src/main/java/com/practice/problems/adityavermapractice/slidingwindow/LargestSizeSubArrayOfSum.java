package com.practice.problems.adityavermapractice.slidingwindow;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 **/


@Log4j2
public abstract class LargestSizeSubArrayOfSum {
    final BiConsumer<Long, Long> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Long largestSizeSubArrayOfSum(List<Integer> inputList, Integer sum);

    public void execute() {
        List<Integer> input = List.of(4, 1, 1, 1, 2, 3, 5);
        Integer sum = 5;
        Long actual = largestSizeSubArrayOfSum(input, sum);
        Long expected = 4l;

        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
