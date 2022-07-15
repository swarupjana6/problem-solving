package com.practice.problems.google.impl.tap;

import com.practice.problems.google.KthLargestElementInAnArray;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArrayTap extends KthLargestElementInAnArray {
    @Override
    protected Integer getKthLargest(int[] nums, int k) {
        Comparator<Integer> MIN_TOP = Comparator.naturalOrder();
        Queue<Integer> MIN_HEAP = new PriorityQueue<>(MIN_TOP);

        for (int num : nums) {
            MIN_HEAP.add(num);
            if (MIN_HEAP.size() > k) MIN_HEAP.remove();
        }

        return MIN_HEAP.remove();
    }
}
