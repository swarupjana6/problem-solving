package com.practice.problems.adityavermapractice.heap.impl.tap;

import com.practice.problems.adityavermapractice.heap.KthSmallestElement;

import java.util.List;

public class KthSmallestElementTapan extends KthSmallestElement {
    @Override
    protected Integer kthSmallest(List<Integer> inputList, int k) {
        MaxHeap<Integer> heap = new MaxHeap<>(k);
        inputList.forEach(heap::add);
        return heap.poll();
    }
}
