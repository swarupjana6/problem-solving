package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Given a sorted array and a and a value x, find the ceiling of x in the array.
 * The ceiling of x is the smallest element in the array greater than or equal to x.
 * Output 1 if the ceiling doesn’t exist.
 * <p>
 * Input : a[] = {1, 3, 9, 15, 15, 18, 21}, x = 0
 * Output : 1
 * 1 is the smallest element in the array greater than or equal to 5.
 * <p>
 * Input : a[] = {1, 3, 9, 15, 15, 18, 21}, x = 1
 * Output : 1
 * 1 is the smallest element in the array greater than or equal to 1.
 * <p>
 * Input : a[] = {1, 3, 9, 15, 15, 18, 21}, x = 5
 * Output : 9
 * 9 is the smallest element in the array greater than or equal to 5.
 * <p>
 * Input : a[] = {1, 3, 9, 15, 15, 18, 21}, x = 25
 * Output : -1
 * Ceiling doesn't exist
 **/

@Log4j2
public class FindCeilOfAnElementInASortedArray {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 8, 10, 10, 12, 19);
        Integer ceilOf = 5;

        log.info("Input: {} | Search for: {}", list, ceilOf);
        log.info("Output: {} ", findCeil(list, ceilOf));
    }

    public static Integer findCeil(List<Integer> list, Integer ceilOf) {
        int ceil = Integer.MAX_VALUE;
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == ceilOf) return list.get(mid + 1);
            else if (list.get(mid) < ceilOf) {
                start = mid + 1;
            } else if (list.get(mid) > ceilOf) {
                ceil = list.get(mid);
                end = mid - 1;
            }
        }
        return ceil;
    }
}
