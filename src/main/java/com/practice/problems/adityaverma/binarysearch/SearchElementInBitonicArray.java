package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.BinarySearch.binarySearchElement;
import static com.practice.problems.adityaverma.binarysearch.PeakElement.peakElement;

/**
 * Given a bitonic sequence of n distinct elements, and an integer x,
 * the task is to write a program to find given element x in the bitonic sequence in O(log n) time.
 * <p>
 * A Bitonic Sequence is a sequence of numbers that is first strictly increasing then after a point decreasing.
 * <p>
 * Input :  arr[] = {-3, 9, 18, 20, 17, 5, 1}, key = 20
 * Output : Found at index 3
 * <p>
 * Input :  arr[] = {5, 6, 7, 8, 9, 10, 3, 2, 1}, key = 30
 * Output : Not Found
 **/

@Log4j2
public class SearchElementInBitonicArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 8, 12, 7, 2);
        int searchFor = 7;

        log.info("Input: {} | Search for {} ", list, searchFor);
        log.info("Output: Index of '{}' is {} ", searchFor, getElementIndexInBitonicArray(list, searchFor));
    }

    public static Integer getElementIndexInBitonicArray(List<Integer> list, Integer searchFor) {
        int peak = peakElement(list, 0, list.size() - 1);
        int firstHalf = binarySearchElement(list, searchFor, 0, peak);
        int secondHalf = binarySearchElement(list, searchFor, peak + 1, list.size() - 1);
        return firstHalf == -1 ? secondHalf : firstHalf;
    }
}
