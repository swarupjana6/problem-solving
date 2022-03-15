package com.practice.problems.adityaverma.heap;

import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a k–sorted array that is almost sorted
 * such that each of the n elements may be misplaced by no more than k positions from the correct sorted order.
 * Input: arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9] k = 2
 * Output:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 **/

@Log4j2
public class NearlySortedArray {

    public static void main(String[] args) {
        List<Integer> input = List.of(6, 5, 3, 2, 8, 10, 9);
        int K = 3;
        log.info("Input: {}", input);
        log.info("Output: {}", sortMinHeap(input, K));
    }

    /**
     * >>>>>>>>>>> MIN HEAP since largest <<<<<<<<<<<<<
     **/
    private static Collection<Integer> sortMinHeap(List<Integer> input, int k) {
        Comparator largest = Comparator.naturalOrder(); // Comparator.reverseOrder() // For Smallest use DESCENDING
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(largest);
        List<Integer> answer = new LinkedList<>();

        for (int i = 0; i < input.size(); i++) {
            minHeap.add(input.get(i));
            if (minHeap.size() > k) answer.add(minHeap.remove());
        }
        answer.addAll(minHeap);

        return answer;
    }
}
