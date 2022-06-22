package com.practice.problems.adityavermapractice.heap;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 * Return the sorted array.
 * <p>
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * <p>
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * <p>
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 **/

@Log4j2
public abstract class FrequencySort {
    final BiConsumer<List<Integer>, List<Integer>> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem         :: {}
            I/P input list  :: {}
            O/P actual      :: {}
            O/P expected    :: {}
            """;

    protected abstract List<Integer> frequencySort(List<Integer> inputList);

    public void execute() {
        List<Integer> input = List.of(1, 1, 1, 3, 2, 2, 4);
        List<Integer> actual = frequencySort(input);
        List<Integer> expected = List.of(1, 2, 3, 4);

        Collections.sort(actual);
        log.debug(LOG_STR, getClass().getSimpleName(), input, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}