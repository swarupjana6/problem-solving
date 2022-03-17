package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

import static com.practice.problems.adityaverma.binarysearch.BinarySearch.binarySearch;

/**
 * Given a sorted array and a and a value x, find the floor of x in the array.
 * The floor of x is the largest element in the array smaller than or equal to x.
 * Output 1 if the floor doesn’t exist.
 * <p>
 * Input : a[] = {1, 3, 9, 15, 15, 18, 21}, x = 5
 * Output : 3
 * 3 is the largest element in the array smaller than or equal to 5.
 * <p>
 * Input : a[] = {1, 3, 9, 15, 15, 18, 21}, x = 25
 * Output : 21
 * 21 is the largest element in the array smaller than or equal to 25.
 * <p>
 * Input : a[] = {1, 3, 9, 15, 15, 18, 21}, x = 0
 * Output : -1
 * Since floor doesn't exist, output is -1.
 **/

@Log4j2
public class FindFloorOfAnElementInASortedArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 8, 10, 10, 12, 19);
        Integer floorOf = 5;

        log.info("Input: {} | Search for: {}", list, floorOf);
        log.info("Output: {} ", findFloor_1(list, floorOf));
        log.info("Output: {} ", findFloor_2(list, floorOf));
    }

    public static Integer findFloor_1(List<Integer> list, Integer floorOf) {
        int floor = Integer.MAX_VALUE;
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == floorOf) return list.get(mid);
            else if (list.get(mid) < floorOf) {
                floor = list.get(mid);
                start = mid + 1;
            } else if (list.get(mid) > floorOf) {
                end = mid - 1;
            }
        }
        return floor;
    }

    public static Integer findFloor_2(List<Integer> list, Integer floorOf) {
        Map<String, Integer> response = binarySearch(list, floorOf, 0, list.size() - 1);
        Integer answer = response.get("answer");
        Integer start = response.get("start");

        if (answer == -1) {
            start = (start != 0 ? start - 1 : start);
            return list.get(start);
        } else {
            return list.get(answer);
        }
    }
}
