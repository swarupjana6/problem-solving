package com.practice.problems.adityavermapractice.heap.impl.tap;

import com.practice.problems.adityavermapractice.heap.MinimizeCostOfConnectingRopes;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimizeCostOfConnectingRopesTapan extends MinimizeCostOfConnectingRopes {

    @Override
    protected Integer minimizeCost(List<Integer> ropes) {
        Integer cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        ropes.forEach(minHeap::add);
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int newRope = first + second;
            cost += newRope;
            minHeap.add(newRope);
        }

        return cost;
    }
}
