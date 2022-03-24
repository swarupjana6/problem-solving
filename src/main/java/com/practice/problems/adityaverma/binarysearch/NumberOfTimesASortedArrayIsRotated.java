package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.Constants.*;

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
public class NumberOfTimesASortedArrayIsRotated {

    public static void main(String[] args) {
        List<Integer> list = List.of(11, 12, 15, 18, 2, 5, 6, 8);

        log.info("Input: {} ", list);
        log.info("Output: # of rotations required is '{}' ", findMinimumElement(list));
    }

    public static Integer findMinimumElement(List<Integer> list) {
        int size = list.size();
        int start = 0;
        int end = size - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (MID_LESS_THAN_PREV_NEXT.test(list, mid)) return mid; /* Minimum Element!! */
            else if (MID_LESS_THAN_EQUAL_END.test(list, mid, end)) end = mid - 1;                             /* Move after Mid */
            else if (MID_GREATER_THAN_EQUAL_START.test(list, mid, start)) start = mid + 1;                         /* Move before Mid */
        }
        return -1;
    }
}
