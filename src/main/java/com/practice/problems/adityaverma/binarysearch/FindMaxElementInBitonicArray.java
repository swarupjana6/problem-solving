package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.PeakElement.peakElement;

/**
 * Given an array of integers which is initially increasing and then decreasing,
 * find the maximum value in the array.
 * <p>
 * Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
 * Output: 500
 * <p>
 * Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
 * Output: 50
 * <p>
 * Corner case (No decreasing part)
 * Input: arr[] = {10, 20, 30, 40, 50}
 * Output: 50
 * <p>
 * Corner case (No increasing part)
 * Input: arr[] = {120, 100, 80, 20, 0}
 * Output: 120
 **/

@Log4j2
public class FindMaxElementInBitonicArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 8, 12, 4, 2);

        log.info("Input: {} ", list);
        log.info("Output: Root element is {} ", peakElement(list));
    }
}
