package com.practice.problems.adityaverma.heap;

import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
public class FrequencySort {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 1, 1, 3, 2, 2, 4, 3, 3, 3, 3, 3, 3);
        log.info("Input: {}", input);
        log.info("Output: {}", sortMaxHeap(input));
    }

    /**
     * MAX HEAP is required since more frequent elements is required at the top
     **/
    private static List<Integer> sortMaxHeap(List<Integer> input) {
        Map<Integer, Integer> frequencyMap = getFrequencyMap(input);
        log.info("Frequency map: {}", frequencyMap);
        Comparator maxTop = Comparator.reverseOrder();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(maxTop);

        for (Map.Entry entry : frequencyMap.entrySet()) maxHeap.add(getPair(entry));

        return maxHeap.stream().map(pair -> pair.getValue().intValue()).collect(Collectors.toList());
    }

    private static Map<Integer, Integer> getFrequencyMap(List<Integer> input) {
        return input.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }

    private static Pair getPair(Map.Entry<Integer, Integer> entry) {
        return new Pair(entry.getValue(), entry.getKey());
    }
}
