package com.practice.problems.adityaverma.heap;

import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an 1D integer array A of size N you have to find and return the B largest elements of the array A.
 * NOTE: Return the largest B elements in any order you like.
 * <p>
 * Input 1: A = [11, 3, 4] B = 2
 * Output 1: [11, 4]
 * <p>
 * Input 2: A = [11, 3, 4, 6] B = 3
 * Output 2: [4, 6, 11]
 **/

@Log4j2
public class KLargestElement {

    public static void main(String[] args) {
        List<Integer> input = List.of(7, 10, 4, 3, 20, 15);
        int K = 3;
        log.info("Input: {}", input);
        log.info("Output: {}", sort(input, K));
    }

    private static Collection<Integer> sort(List<Integer> input, int k) {
        Comparator largest = Comparator.naturalOrder(); // Comparator.reverseOrder()
        PriorityQueue<Integer> answer = new PriorityQueue<>(largest);

        for (int i = 0; i < input.size(); i++) {
            answer.add(input.get(i));
            if (answer.size() > k) answer.remove();
        }

        return answer;
    }
}
