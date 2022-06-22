package com.practice.problems.adityavermapractice.heap.impl.tap;

import com.practice.problems.adityavermapractice.heap.KSortedArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArrayTapan extends KSortedArray {

    @Override
    public List<Integer> kSortedArray(List<Integer> inputList, int k) {
        MinHeap<Integer> heap = new MinHeap<>(k);
        inputList.forEach(heap::add);
        return new ArrayList<>(heap.getHeap());
    }
}
