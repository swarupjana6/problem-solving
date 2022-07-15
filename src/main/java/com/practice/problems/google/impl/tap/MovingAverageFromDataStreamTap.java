package com.practice.problems.google.impl.tap;

import com.practice.problems.google.MovingAverageFromDataStream;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverageFromDataStreamTap extends MovingAverageFromDataStream {

    private Deque<Integer> window = new ArrayDeque<>();
    private int maxSize;
    private double sum;

    @Override
    protected void init(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected Double next(int val) {
        add(val);
        int size = window.size();
        double average = Double.valueOf(sum / size);
        System.out.print(window + "avg:" + average + " || ");
        return average;
    }

    private void add(int val) {
        if (window.size() == maxSize) sum -= window.remove();
        sum += val;
        window.add(val);
    }
}
