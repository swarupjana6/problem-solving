package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.Constants.*;

/**
 * Given an array of integers. Find a peak element in it.
 * An array element is a peak if it is NOT smaller than its neighbours.
 * For corner elements, we need to consider only one neighbour.
 * <p>
 * Input: array[]= {5, 10, 20, 15}
 * Output: 20
 * The element 20 has neighbours 10 and 15,
 * both of them are less than 20.
 * <p>
 * Input: array[] = {10, 20, 15, 2, 23, 90, 67}
 * Output: 20 or 90
 * The element 20 has neighbours 10 and 15,
 * both of them are less than 20, similarly 90 has neighbours 23 and 67.
 **/

@Log4j2
public class PeakElement {

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 10, 20, 15);

        log.info("Input: {} ", list);
        log.info("Output: Root element is {} ", binarySearch(list));
    }

    public static Integer binarySearch(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        int result = binarySearchElement(list, start, end);
        return result != -1 ? list.get(result) : result;
    }

    public static int binarySearchElement(List<Integer> list, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (MID_GREATER_THAN_PREV_NEXT.test(list, mid)) return mid;
            else if (MID_LESS_THAN_PREV.test(list, mid)) end = mid - 1;
            else if (MID_LESS_THAN_NEXT.test(list, mid)) start = mid + 1;
        }
        return -1;
    }
}
