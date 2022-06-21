package com.practice.problems.adityavermapractice.stack.impl.tap;

import com.practice.problems.adityavermapractice.stack.MaximumAreaOfHistogram;

import java.util.List;

public class MaximumAreaOfHistogramTapan extends MaximumAreaOfHistogram {

    @Override
    public Integer maximumAreaOfHistogram(List<Integer> bars) {
        Integer maxArea = 0;
        List<Integer> widthsLeft = new NearestSmallerToLeftTapan().nearestSmallerToLeft(bars, -1);
        List<Integer> widthsRight = new NearestSmallerToRightTapan().nearestSmallerToRight(bars, bars.size());

        int size = bars.size();
        for (int i = 0; i < size; i++) {
            int barHeight = bars.get(i);
            int widthLeft = widthsLeft.get(i);
            int widthRight = widthsRight.get(i);

            widthLeft = widthLeft == -1 ? 0 : widthLeft;
            widthRight = widthRight == -1 ? 0 : widthRight;
            int area = barHeight * (Math.abs(widthRight - widthLeft - 1));
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
