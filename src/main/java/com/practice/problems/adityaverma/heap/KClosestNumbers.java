package com.practice.problems.adityaverma.heap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 **/

@Log4j2
public class KClosestNumbers {

    public static void main(String[] args) {
        List<Integer> input = List.of(5, 6, 7, 8, 9);
        int K = 3;
        int X = 7;
        log.info("Input: {}", input);
        log.info("Output: {}", sortMaxHeap(input, K, X));
    }

    /**
     * >>>>>>>>>>> MAX HEAP since smallest <<<<<<<<<<<<<
     **/
    private static List<Integer> sortMaxHeap(List<Integer> input, int k, int x) {
        Comparator smallest = Comparator.reverseOrder(); // Comparator.naturalOrder()  // For Largest use ASCENDING
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(smallest);

        for (int i = 0; i < input.size(); i++) {
            maxHeap.add(getPair(input.get(i), x));
            if (maxHeap.size() > k) maxHeap.remove();
        }

        return maxHeap.stream().map(pair -> pair.getValue()).collect(Collectors.toList());
    }

    private static Pair getPair(int value, int x) {
        return new Pair(Math.abs(value - x), value);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Pair implements Comparable<Pair> {

        Integer key;
        Integer value;


        @Override
        public int compareTo(Pair compareWith) {
            return this.key.compareTo(compareWith.getKey());
        }

        @Override
        public String toString() {
            return "Pair{" + key + ',' + value + '}';
        }
    }
}
