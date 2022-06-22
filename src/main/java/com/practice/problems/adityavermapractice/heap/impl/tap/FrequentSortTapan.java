package com.practice.problems.adityavermapractice.heap.impl.tap;

import com.practice.problems.adityavermapractice.heap.FrequencySort;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequentSortTapan extends FrequencySort {

    private final Comparator<Pair> MIN_TOP = Comparator.naturalOrder();

    private final Queue<Pair> MIN_HEAP = new PriorityQueue<>(MIN_TOP);

    @Override
    public List<Integer> frequencySort(List<Integer> inputList) {
        Map<Integer, Integer> frequency = getFrequencyMap(inputList);

        frequency.forEach((key, value) -> MIN_HEAP.add(new Pair(value, key)));

        return MIN_HEAP.stream().map(pair -> pair.value()).collect(Collectors.toList());
    }

    private Map<Integer, Integer> getFrequencyMap(List<Integer> inputList) {
        final Map<Integer, Integer> frequency = inputList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        return frequency;
    }
}
