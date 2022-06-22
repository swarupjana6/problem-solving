package com.practice.problems.adityavermapractice.heap.impl.tap;

import com.practice.problems.adityavermapractice.heap.KClosestNumbers;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestNumbersTapan extends KClosestNumbers {

    @Override
    public List<Integer> kClosest(List<Integer> inputList, int k, int x) {
        MaxHeap<Pair> MAX_HEAP = new MaxHeap<>(k);
        inputList.forEach(current -> MAX_HEAP.add(new Pair(Math.abs(current - x), current)));
        return MAX_HEAP.getHeap().stream().map(pair -> pair.value()).collect(Collectors.toList());
    }
}
