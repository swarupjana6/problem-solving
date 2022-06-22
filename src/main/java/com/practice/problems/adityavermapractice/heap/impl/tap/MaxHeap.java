package com.practice.problems.adityavermapractice.heap.impl.tap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeap<T extends Comparable> {

    private int k;
    private final Comparator<T> MAX_TOP = Comparator.reverseOrder();
    private final PriorityQueue<T> MAX_HEAP = new PriorityQueue<>(MAX_TOP);

    public MaxHeap(int k) {
        this.k = k;
    }

    public void add(T element) {
        MAX_HEAP.add(element);
        if (MAX_HEAP.size() > k) MAX_HEAP.poll();
    }

    public T poll() {
        return MAX_HEAP.poll();
    }

    public Queue<T> getHeap() {
        return MAX_HEAP;
    }
}
