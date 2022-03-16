package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

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
        List<Integer> sortedList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer searchFor = 9;

        log.info("Input: {} | SearchFor: {}", sortedList, searchFor);
        log.info("Output: {} ", binarySearch(sortedList, searchFor));
    }

    private static Integer binarySearch(List<Integer> sortedList, Integer searchFor) {
        int start = 0;
        int end = sortedList.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */
            int midElement = sortedList.get(mid);
            if (midElement == searchFor) return mid;
            else if (midElement < searchFor) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
