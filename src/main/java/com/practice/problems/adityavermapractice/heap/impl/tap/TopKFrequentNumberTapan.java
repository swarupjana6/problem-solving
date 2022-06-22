package com.practice.problems.adityavermapractice.heap.impl.tap;

import com.practice.problems.adityavermapractice.heap.TopKFrequentNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentNumberTapan extends TopKFrequentNumber {

    @Override
    protected List<Integer> kFrequentNumber(List<Integer> inputList, int k) {
        Map<Integer, Integer> frequency = getFrequencyMap(inputList);
        MinHeap<Pair> heap = new MinHeap<>(k);
        frequency.forEach((key, value) -> heap.add(new Pair(value, key)));
        return heap.getHeap().stream().map(Pair::value).collect(Collectors.toList());
    }

    private Map<Integer, Integer> getFrequencyMap(List<Integer> inputList) {
        //final Map<Integer, Integer> frequency = inputList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        final Map<Integer, Integer> frequency = new HashMap<>();
        inputList.stream().forEach(element -> frequency.merge(element, 1, Integer::sum));
        return frequency;
    }
}
