package com.practice.problems.adityavermapractice.binarysearch;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

import java.util.function.BiConsumer;


/**
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Input: nums = [1], target = 0
 * Output: -1
 **/
@Log4j2
public abstract class FindElementInRotatedSortedArray {

    final BiConsumer<Integer, Integer> IS_EXPECTED = Assertions::assertEquals;
    protected String LOG_STR = """
                        
            Problem             :: {}
            I/P Arr             :: {}
            I/P Target          :: {}
            O/P actual          :: {}
            O/P expected        :: {}
            """;

    public abstract Integer rotationCount(Integer[] nums, int target);

    public void execute() {
        Integer[] nums;
        int target;
        int actual;
        int expected;

        nums = new Integer[]{11, 12, 13, 2, 5, 6, 8};
        target = 12;
        expected = 1;
        actual = rotationCount(nums, target);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new Integer[]{11, 12, 15, 18, 2, 5, 6, 8};
        target = 122;
        expected = -1;
        actual = rotationCount(nums, target);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new Integer[]{4, 5, 6, 7, 0, 1, 2};
        target = 0;
        expected = 4;
        actual = rotationCount(nums, target);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new Integer[]{1, 2, 3, 4, 5, 6};
        target = 12;
        expected = -1;
        actual = rotationCount(nums, target);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new Integer[]{3, 1};
        target = 0;
        expected = -1;
        actual = rotationCount(nums, target);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new Integer[]{7, 6, 5, 4, 3, 2, 1};
        target = 0;
        expected = -1;
        actual = rotationCount(nums, target);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new Integer[]{4, 5, 6, 7, 0, 1, 2, 3};
        target = 0;
        expected = 4;
        actual = rotationCount(nums, target);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);

        nums = new Integer[]{1, 2, 3, 4};
        target = 4;
        expected = 3;
        actual = rotationCount(nums, target);
        log.debug(LOG_STR, getClass().getSimpleName(), nums, target, actual, expected);
        IS_EXPECTED.accept(expected, actual);
    }
}
