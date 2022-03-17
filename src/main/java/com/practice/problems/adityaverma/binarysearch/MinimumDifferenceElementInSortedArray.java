package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

import static com.practice.problems.adityaverma.binarysearch.BinarySearch.binarySearch;
import static com.practice.problems.adityaverma.binarysearch.FindCeilOfAnElementInASortedArray.findCeiling_1;
import static com.practice.problems.adityaverma.binarysearch.FindFloorOfAnElementInASortedArray.findFloor_1;

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
        //log.info("Output: {} ", minimumDifference_1(list, element));
        log.info("Output: {} ", minimumDifference_2(list, element));
    }

    private static Integer minimumDifference_1(List<Integer> list, Integer element) {
        int floor = findFloor_1(list, element);
        int ceiling = findCeiling_1(list, element);

        return Math.min(floor, ceiling);
    }

    private static Integer minimumDifference_2(List<Integer> list, Integer element) {
        Map<String, Integer> response = binarySearch(list, element, 0, list.size() - 1);

        Integer answer = response.get("answer");
        Integer start = response.get("start");
        Integer end = response.get("end");

        if (answer == -1) {
            int startMin = Math.abs(list.get(start) - element);
            int endMin = Math.abs(list.get(end) - element);
            return startMin < endMin ? list.get(start) : list.get(end);
        } else {
            return list.get(answer);
        }
    }
}