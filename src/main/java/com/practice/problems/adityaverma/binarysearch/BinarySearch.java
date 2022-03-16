package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> sortedList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer searchFor = 9;

        log.info("Input: {} | SearchFor: {}", sortedList, searchFor);
        log.info("Output: {} ", binarySearch(sortedList, searchFor));
    }

    public static Integer binarySearch(List<Integer> sortedList, Integer searchFor) {
        int start = 0;
        int end = sortedList.size() - 1;
        return binarySearchElement(sortedList, searchFor, start, end);
    }

    public static int binarySearchElement(List<Integer> sortedList, Integer searchFor, int start, int end) {
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
