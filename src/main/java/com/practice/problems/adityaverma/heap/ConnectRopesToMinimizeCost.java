package com.practice.problems.adityaverma.heap;

import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope.
 * The cost to connect two ropes is equal to the sum of their lengths.
 * We need to connect the ropes with minimum cost.
 * <p>
 * For example, if we are given 4 ropes of lengths 4, 3, 2, and 6. We can connect the ropes in the following ways.
 * 1) First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
 * 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 * 3) Finally connect the two ropes and all ropes have connected.
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes. Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first (we get three strings of 3, 2, and 10), then connect 10 and 3 (we get two strings of 13 and 2). Finally, we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
 **/

@Log4j2
public class ConnectRopesToMinimizeCost {

    public static void main(String[] args) {
        List<Integer> input1 = List.of(5, 3, 2, 4, 1);
        List<Integer> input = input1;
        log.info("Input: {} {}", input);
        log.info("Output: {}", sortMinHeap(input));
    }

    /**
     * MIN HEAP is required as we need minimum cost at the top
     **/
    private static Integer sortMinHeap(List<Integer> input) {
        Comparator<Integer> minTop = Comparator.naturalOrder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(minTop);

        minHeap.addAll(input);
        while (minHeap.size() > 1) minHeap.add(minHeap.remove() + minHeap.remove());

        return minHeap.remove();
    }
}
