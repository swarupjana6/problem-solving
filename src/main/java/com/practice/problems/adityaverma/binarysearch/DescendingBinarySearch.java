package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.Constants.*;

@Log4j2
public class DescendingBinarySearch {

    private static final List<Integer> INPUT_LIST = List.of(20, 17, 15, 14, 13, 12, 10, 9, 8, 4);

    public static void main(String[] args) {
        List<Integer> list = getDescendingList(INPUT_LIST);
        Integer search = 10;

        log.info("Input: {} | Search for: {}", list, search);
        log.info("Output: Index of '{}' is {} ", search, binarySearch(list, search));
    }

    private static Integer binarySearch(List<Integer> list, Integer search) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (MIDDLE_EQUAL_TO_ELEMENT.test(list.get(mid), search)) return mid;
            else if (MIDDLE_LESS_THAN_ELEMENT.test(list.get(mid), search)) end = DECREASE_MID.apply(mid);
            else start = INCREASE_MID.apply(mid);
        }
        return -1;
    }
}
