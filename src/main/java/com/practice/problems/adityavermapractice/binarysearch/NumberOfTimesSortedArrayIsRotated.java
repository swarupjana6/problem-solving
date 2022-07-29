package com.practice.problems.adityavermapractice.binarysearch;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in
 * the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * <p>
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * <p>
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 **/
@Log4j2
public abstract class NumberOfTimesSortedArrayIsRotated {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem             :: {}
            I/P Arr             :: {}
            O/P actual          :: {}
            O/P expected        :: {}
            """;

    public abstract Integer rotationCount(Integer[] nums);

    public void execute() {
        Integer[] nums;
        int actual;
        int expected;

        nums = new Integer[]{11, 12, 15, 18, 2, 5, 6, 8};
        expected = 4;
        actual = rotationCount(nums);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new Integer[]{12, 15, 18, 2, 5, 6, 8};
        expected = 3;
        actual = rotationCount(nums);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
