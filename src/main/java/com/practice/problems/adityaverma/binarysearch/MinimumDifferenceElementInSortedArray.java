package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.FindCeilOfAnElementInASortedArray.findCeiling;
import static com.practice.problems.adityaverma.binarysearch.FindFloorOfAnElementInASortedArray.findFloor;

/**
 * Given an unsorted array, find the minimum difference between any pair in given array.
 * <p>
 * Input  : {1, 5, 3, 19, 18, 25};
 * Output : 1
 * Minimum difference is between 18 and 19
 * <p>
 * Input  : {30, 5, 20, 9};
 * Output : 4
 * Minimum difference is between 5 and 9
 * <p>
 * Input  : {1, 19, -4, 31, 38, 25, 100};
 * Output : 5
 * Minimum difference is between 1 and -4
 **/

@Log4j2
public class MinimumDifferenceElementInSortedArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 8, 10, 15);
        Integer element = 12;

        log.info("Input: {} | Search for: {}", list, element);
        log.info("Output: {} ", minimumDifference_1(list, element));
    }

    private static Integer minimumDifference_1(List<Integer> list, Integer element) {
        int floor = findFloor(list, element);
        int ceiling = findCeiling(list, element);

        return Math.min(floor, ceiling);
    }

    private static Integer minimumDifference_2(List<Integer> list, Integer element) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == element) return list.get(mid);
            else if (list.get(mid) < element) {
                start = mid + 1;
            } else if (list.get(mid) > element) {
                end = mid - 1;
            }
        }

        int startMin = Math.abs(list.get(start) - element);
        int endMin = Math.abs(list.get(end) - element);


        return startMin < endMin ? list.get(start) : list.get(end);
    }
}