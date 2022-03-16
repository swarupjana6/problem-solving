package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Given a sorted array of n elements, possibly with duplicates,
 * find the number of occurrences of the target element.
 * <p>
 * Input: arr = [4, 4, 8, 8, 8, 15, 16, 23, 23, 42], target = 8
 * Output: 3
 * <p>
 * Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 6
 * Output: 0
 * <p>
 * Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 5
 * Output: 4
 **/

@Log4j2
public class CountOfAnElementInASortedArray {

    public static void main(String[] args) {
        List<Integer> sortedList = List.of(2, 4, 10, 10, 10, 18, 20);
        Integer searchFor = 10;

        log.info("Input: {} | SearchFor: {}", sortedList, searchFor);
        log.info("Output: Count of '{}' is {}", searchFor, countOfAnElement(sortedList, searchFor));
    }

    private static Integer countOfAnElement(List<Integer> sortedList, Integer searchFor) {
        int first = firstOccurrence(sortedList, searchFor);
        int last = lastOccurrence(sortedList, searchFor);
        int count = last - first;
        return count > 0 ? count + 1 : 0;
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
