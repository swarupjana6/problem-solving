package com.practice.problems.adityaverma.heap;

import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an integer array nums and an integer k,
 * return the k most frequent elements.
 * You may return the answer in any order.
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 **/

@Log4j2
public class TopKFrequentNumber {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 1, 1, 3, 2, 2, 4, 3, 3, 3, 3);
        int K = 2;
        log.info("Input: {}", input);
        log.info("Output: {}", sortMaxHeap(input, K));
    }

    /**
     * MIN HEAP is required since less frequent elements will be removed from top,
     * only K elements will be kept in the collection
     **/
    private static List<Integer> sortMaxHeap(List<Integer> input, int k) {
        Map<Integer, Integer> frequencyMap = getFrequencyMap(input);
        log.info("Frequency map: {}", frequencyMap);
        Comparator minTop = Comparator.naturalOrder();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(minTop);

        for (Map.Entry entry : frequencyMap.entrySet()) {
            minHeap.add(getPair(entry));
            if (minHeap.size() > k) minHeap.remove();
        }

        return minHeap.stream().map(pair -> pair.getValue().intValue()).collect(Collectors.toList());
    }

    private static Map<Integer, Integer> getFrequencyMap(List<Integer> input) {
        return input.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }

    private static Pair getPair(Map.Entry<Integer, Integer> entry) {
        return new Pair(entry.getValue(), entry.getKey());
    }
}
