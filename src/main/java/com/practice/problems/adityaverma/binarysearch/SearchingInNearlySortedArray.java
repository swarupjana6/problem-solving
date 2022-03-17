package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions,
 * i.e., arr[i] may be present at arr[i+1] or arr[i-1].
 * Write an efficient function to search an element in this array.
 * Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 * For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
 * <p>
 * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
 * Output: 2
 * Output is index of 40 in given array
 * <p>
 * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
 * Output: -1
 * -1 is returned to indicate element is not present
 **/

@Log4j2
public class SearchingInNearlySortedArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 10, 30, 20, 40);
        Integer search = 20;

        log.info("Input: {} | search: {}", list, search);
        log.info("Output: {} ", binarySearch(list, search));
    }

    public static Integer binarySearch(List<Integer> list, Integer search) {
        int start = 0;
        int end = list.size() - 1;
        return binarySearchElement(list, search, start, end);
    }

    public static int binarySearchElement(List<Integer> list, Integer search, int start, int end) {
        int size = list.size();

        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == search) return mid;
            else if (mid != 0 && list.get(mid - 1) == search) return mid - 1;
            else if (mid != size - 1 && list.get(mid + 1) == search) return mid + 1;
            else if (list.get(mid) < search) start = mid + 2;
            else end = mid - 2;
        }
        return -1;
    }
}
