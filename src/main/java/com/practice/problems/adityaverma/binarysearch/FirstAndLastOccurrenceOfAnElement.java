package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.Constants.*;

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
        List<Integer> list = List.of(2, 4, 10, 10, 10, 18, 20);
        Integer search = 10;

        log.info("Input: {} | Search for: {}", list, search);
        log.info("Output: First Index of '{}' is {}", search, firstOccurrence(list, search));
        log.info("Output: Last  Index of '{}' is {}", search, lastOccurrence(list, search));
    }

    static Integer firstOccurrence(List<Integer> list, Integer search) {
        int start = 0;
        int end = list.size() - 1;

        return firstOccurrence(list, search, start, end);
    }

    public static int firstOccurrence(List<Integer> list, Integer search, int start, int end) {
        int answer = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == search) {
                answer = mid;
                end = DECREASE_MID.apply(mid);
            } else if (list.get(mid) < search) start = INCREASE_MID.apply(mid);
            else end = DECREASE_MID.apply(mid);
        }
        return answer;
    }

    static Integer lastOccurrence(List<Integer> list, Integer search) {
        int start = 0;
        int end = list.size() - 1;

        return lastOccurrence(list, search, start, end);
    }

    private static int lastOccurrence(List<Integer> list, Integer search, int start, int end) {
        int answer = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (MIDDLE_EQUAL_TO_ELEMENT.test(list.get(mid), search)) {
                answer = mid;
                start = INCREASE_MID.apply(mid);
            } else if (MIDDLE_LESS_THAN_ELEMENT.test(list.get(mid), search)) start = INCREASE_MID.apply(mid);
            else end = DECREASE_MID.apply(mid);
        }

        return answer;
    }
}
