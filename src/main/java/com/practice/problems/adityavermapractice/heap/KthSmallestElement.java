package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.function.BiConsumer;


/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 **/
@Log4j2
public abstract class KthSmallestElement {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;

    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract Integer kthSmallest(List<Integer> inputList, int k);

    public void execute() {
        List<Integer> input = List.of(7, 10, 4, 3, 20, 15);
        Integer actual = kthSmallest(input, 3);
        Integer expected = 7;

        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
