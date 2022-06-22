package com.practice.problems.adityavermapractice.heap.impl.tap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinHeap<T extends Comparable> {

    private int maxSize;
    private final Comparator<T> MIN_TOP = Comparator.naturalOrder();
    private final PriorityQueue<T> MIN_HEAP = new PriorityQueue<>(MIN_TOP);

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T element) {
        MIN_HEAP.add(element);
        if (MIN_HEAP.size() > maxSize) MIN_HEAP.poll();
    }

    public T poll() {
        return MIN_HEAP.poll();
    }

    public Queue<T> getHeap() {
        return MIN_HEAP;
    }
}
