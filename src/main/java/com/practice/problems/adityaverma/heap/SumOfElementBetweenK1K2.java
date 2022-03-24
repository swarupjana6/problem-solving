package com.practice.problems.adityaverma.heap;

import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of integers and two numbers k1 and k2.
 * Find the sum of all elements between given two k1’th and k2’th smallest elements of the array.
 * It may be assumed that (1 <= k1 < k2 <= n) and all elements of array are distinct.
 * <p>
 * Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6
 * Output : 26
 * 3rd smallest element is 10. 6th smallest element
 * is 20. Sum of all element between k1 & k2 is
 * 12 + 14 = 26
 * <p>
 * Input : arr[] = {10, 2, 50, 12, 48, 13}, k1 = 2, k2 = 6
 * Output : 73
 **/

@Log4j2
public class SumOfElementBetweenK1K2 {

    public static void main(String[] args) {
        List<Integer> input1 = List.of(1, 3, 5, 11, 12, 15);
        List<Integer> input = input1;
        int k1 = 3;
        int k2 = 6;
        log.info("Input: {} {}", input);
        log.info("Output: {}", sortMinHeap(input, k1, k2));
    }

    /**
     * MIN HEAP is required as we need minimum cost at the top
     **/
    private static Integer sortMinHeap(List<Integer> input, int k1, int k2) {
        int sum = 0;
        Comparator<Integer> minTop = Comparator.naturalOrder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(minTop);

        for (int i = 0; i < input.size(); i++) {
            minHeap.add(input.get(i));
            if (i < k1 || i >= k2 - 1) minHeap.remove();
            else sum += minHeap.remove();
        }

        return sum;
    }
}
