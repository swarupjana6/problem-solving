package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 **/

@Log4j2
public class FirstAndLastOccurrenceOfAnElement {

    public static void main(String[] args) {
        List<Integer> sortedList = List.of(2, 4, 10, 10, 10, 18, 20);
        Integer searchFor = 10;

        log.info("Input: {} | SearchFor: {}", sortedList, searchFor);
        log.info("Output: First Index of '{}' is {}", searchFor, firstOccurrence(sortedList, searchFor));
        log.info("Output: Last  Index of '{}' is {}", searchFor, lastOccurrence(sortedList, searchFor));
    }

    private static Integer firstOccurrence(List<Integer> sortedList, Integer searchFor) {
        int answer = -1;
        int start = 0;
        int end = sortedList.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */
            int midElement = sortedList.get(mid);
            if (midElement == searchFor) {
                answer = mid;
                end = mid - 1;
            } else if (midElement < searchFor) start = mid + 1;
            else end = mid - 1;
        }
        return answer;
    }

    private static Integer lastOccurrence(List<Integer> sortedList, Integer searchFor) {
        int answer = -1;
        int start = 0;
        int end = sortedList.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */
            int midElement = sortedList.get(mid);
            if (midElement == searchFor) {
                answer = mid;
                start = mid + 1;
            } else if (midElement < searchFor) start = mid + 1;
            else end = mid - 1;
        }
        return answer;
    }
}
