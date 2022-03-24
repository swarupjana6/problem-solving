package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.function.Function;

import static com.practice.problems.adityaverma.binarysearch.Constants.*;

@Log4j2
public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {
        List<Integer> INPUT_LIST = List.of(20, 17, 15, 14, 13, 12, 10, 9, 8, 4);
        List<Integer> list = getAscendingList(INPUT_LIST);
        //List<Integer> list = getDescendingList(INPUT_LIST);
        Integer search = 9;

        log.info("Input: {} | search: {} ", list, search);
        log.info("Output: {} ", binarySearch(list, search));
    }

    private static Integer binarySearch(List<Integer> list, Integer search) {
        boolean isDsc = IS_DESC.test(list);
        Function<Integer, Integer> lessThanMid = isDsc ? DECREASE_MID : INCREASE_MID;
        Function<Integer, Integer> moreThanMid = isDsc ? INCREASE_MID : DECREASE_MID;

        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == search) return mid;
            else if (list.get(mid) < search) end = lessThanMid.apply(mid);
            else start = moreThanMid.apply(mid);
        }
        return -1;
    }
}
