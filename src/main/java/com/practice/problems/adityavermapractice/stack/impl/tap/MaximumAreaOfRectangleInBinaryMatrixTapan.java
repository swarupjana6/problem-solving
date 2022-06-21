package com.practice.problems.adityavermapractice.stack.impl.tap;

import com.practice.problems.adityavermapractice.stack.MaximumAreaOfRectangleInBinaryMatrix;

import java.util.ArrayList;
import java.util.List;

public class MaximumAreaOfRectangleInBinaryMatrixTapan extends MaximumAreaOfRectangleInBinaryMatrix {
    @Override
    public Integer maximumAreaOfRectangleInBinaryMatrix(List<List<Integer>> matrix) {
        List<Integer> firstBar = matrix.get(0);
        List<Integer> bars = new ArrayList<>(firstBar);

        Integer maxArea = new MaximumAreaOfHistogramTapan().maximumAreaOfHistogram(bars);

        for (int i = 1; i < matrix.size(); i++) {
            List<Integer> currentBar = matrix.get(i);

            for (int j = 0; j < currentBar.size(); j++) {
                int value = currentBar.get(j);
                value = value > 0 ? value + bars.get(j) : 0;
                bars.set(j , value);
            }

            Integer area = new MaximumAreaOfHistogramTapan().maximumAreaOfHistogram(bars);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
