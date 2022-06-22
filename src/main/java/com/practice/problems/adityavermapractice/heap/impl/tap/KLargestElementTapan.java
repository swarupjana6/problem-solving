package com.practice.problems.adityavermapractice.heap.impl.tap;


import com.practice.problems.adityavermapractice.heap.KLargestElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElementTapan extends KLargestElement {

    @Override
    public List<Integer> kLargest(List<Integer> inputList, int k) {
        final MinHeap heap = new MinHeap(k);
        inputList.forEach(heap::add);
        return new ArrayList<>(heap.getHeap());
    }
}


