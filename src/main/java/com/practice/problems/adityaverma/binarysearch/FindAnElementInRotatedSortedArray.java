package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.practice.problems.adityaverma.binarysearch.BinarySearch.binarySearchElement;
import static com.practice.problems.adityaverma.binarysearch.NumberOfTimesASortedArrayIsRotated.findMinimumElement;

/**
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 * Devise a way to find an element in the rotated array in O(log n) time.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Input: nums = [1], target = 0
 * Output: -1
 **/

@Log4j2
public class FindAnElementInRotatedSortedArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(4, 5, 6, 7, 0, 1, 2);
        int search = 0;

        log.info("Input: {} | Search for: {} ", list, search);
        log.info("Output: '{}' is located at {} ", search, findElement(list, search));
    }

    private static Integer findElement(List<Integer> list, int search) {
        int minimumIndex = findMinimumElement(list);
        int firstHalf = binarySearchElement(list, search, 0, minimumIndex);
        int secondHalf = binarySearchElement(list, search, minimumIndex + 1, list.size() - 1);

        if (firstHalf == -1) return secondHalf;
        if (secondHalf == -1) return firstHalf;
        return -1;
    }
}
