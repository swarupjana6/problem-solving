package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.FirstAndLastOccurrenceOfAnElement.firstOccurrence;

/**
 * Given an infinite sorted array consisting 0s and 1s.
 * The problem is to find the index of first ‘1’ in that array.
 * As the array is infinite,
 * therefore it is guaranteed that number ‘1’ will be present in the array.
 * <p>
 * Input : arr[] = {0, 0, 1, 1, 1, 1}
 * Output : 2
 **/

@Log4j2
public class FindPositionOfFirstOneInBinaryInfiniteSortedArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1);

        log.info("Input: {} | Search for: 1st '1'", list);
        log.info("Output: First index of '1' is {} ", binarySearch(list));
    }

    public static Integer binarySearch(List<Integer> list) {
        int start = 0;
        int end = 1;
        while (list.get(end) == 0) {
            start = end;
            end = end * 2;
        }
        return firstOccurrence(list, 1, start, end);
    }
}
