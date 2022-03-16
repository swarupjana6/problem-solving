package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static com.practice.problems.adityaverma.binarysearch.Constants.*;

@Log4j2
public class OrderAgnosticBinarySearch {

    private static final List<Integer> INPUT_LIST = List.of(20, 17, 15, 14, 13, 12, 10, 9, 8, 4);

    public static void main(String[] args) {
        List<Integer> sortedList = getAscendingList(INPUT_LIST);
        //List<Integer> sortedList = getDescendingList(INPUT_LIST);
        Integer searchFor = 9;

        log.info("Input: {} | SearchFor: {} ", sortedList, searchFor);
        log.info("Output: {} ", binarySearch(sortedList, searchFor));
    }

    private static Integer binarySearch(List<Integer> sortedList, Integer searchFor) {
        boolean isDsc = IS_DESC.test(sortedList);
        Function<Integer, Integer> lessThanMid = isDsc ? DECREASE_MID : INCREASE_MID;
        Function<Integer, Integer> moreThanMid = isDsc ? INCREASE_MID : DECREASE_MID;

        int start = 0;
        int end = sortedList.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */
            int midElement = sortedList.get(mid);
            if (midElement == searchFor) return mid;
            else if (midElement < searchFor) end = lessThanMid.apply(mid);
            else start = moreThanMid.apply(mid);
        }
        return -1;
    }

    private static List<Integer> getDescendingList(List<Integer> inputList) {
        List<Integer> descendingList = new ArrayList<>(inputList);
        descendingList.sort(Comparator.reverseOrder());
        return descendingList;
    }

    private static List<Integer> getAscendingList(List<Integer> inputList) {
        List<Integer> ascendingList = new ArrayList<>(inputList);
        ascendingList.sort(Comparator.naturalOrder());
        return ascendingList;
    }
}
