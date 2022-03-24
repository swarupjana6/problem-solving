package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.BinarySearch.binarySearchElement;

/**
 * Given an infinite sorted array (or an array with unknown size),
 * find if a given target value is present in the array.
 * Write a function to return the index of the target if it is present in the array,
 * otherwise return -1.
 * <p>
 * Input: [2, 5, 7, 9, 10, 12, 15, 16, 18, 20, 24, 28. 32, 35], target = 16
 * Output: 7
 * Explanation: The target is present at index '7' in the array.
 * <p>
 * Input: [2, 5, 7, 9, 10, 12, 15, 16, 18, 20, 24, 28. 32, 35], target = 19
 * Output: -1
 * Explanation: The target not present in the array
 **/

@Log4j2
public class FindPositionOfElementInfiniteSortedArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
        Integer search = 9;

        log.info("Input: {} | Search for: {}", list, search);
        log.info("Output: {} ", binarySearch(list, search));
    }

    public static Integer binarySearch(List<Integer> list, Integer search) {
        int start = 0;
        int end = 1;
        while (list.get(end) < search) {
            start = end;
            end = end * 2;
        }
        return binarySearchElement(list, search, start, end);
    }
}
