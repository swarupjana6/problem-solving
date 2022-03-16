package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.Constants.DECREASE_MID;
import static com.practice.problems.adityaverma.binarysearch.Constants.INCREASE_MID;

@Log4j2
public class DescendingBinarySearch {

    private static final List<Integer> INPUT_LIST = List.of(20, 17, 15, 14, 13, 12, 10, 9, 8, 4);

    public static void main(String[] args) {
        List<Integer> sortedList = getDescendingList(INPUT_LIST);
        Integer searchFor = 10;

        log.info("Input: {} | SearchFor: {}", sortedList, searchFor);
        log.info("Output: Index of '{}' is {} ", searchFor, binarySearch(sortedList, searchFor));
    }

    private static Integer binarySearch(List<Integer> sortedList, Integer searchFor) {
        int start = 0;
        int end = sortedList.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */
            int midElement = sortedList.get(mid);
            if (midElement == searchFor) return mid;
            else if (midElement < searchFor) end = DECREASE_MID.apply(mid);
            else start = INCREASE_MID.apply(mid);
        }
        return -1;
    }

    private static List<Integer> getDescendingList(List<Integer> inputList) {
        List<Integer> descendingList = new ArrayList<>(inputList);
        descendingList.sort(Comparator.reverseOrder());
        return descendingList;
    }
}
