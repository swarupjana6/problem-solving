package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

@Log4j2
public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer search = 9;

        log.info("Input: {} | Search for: {}", list, search);
        log.info("Output: Index of '{}' is {} ", search, binarySearch(list, search));
    }

    public static Integer binarySearch(List<Integer> list, Integer search) {
        int start = 0;
        int end = list.size() - 1;
        return binarySearchElement(list, search, start, end);
    }

    public static int binarySearchElement(List<Integer> list, int search, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == search) return mid;
            else if (list.get(mid) < search) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static Map<String, Integer> binarySearch(List<Integer> list, int search, int start, int end) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == search) {
                ans = mid;
                break;
            } else if (list.get(mid) < search) start = mid + 1;
            else if (list.get(mid) > search) end = mid - 1;
        }
        return Map.of("answer", ans, "start", start, "end", end);
    }
}
