package com.practice.problems.google.impl.tap;

import com.practice.problems.google.ContainerWithMostWater;

public class ContainerWithMostWaterTap extends ContainerWithMostWater {
    @Override
    protected Integer maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length - 1;
        while (right > left) {
            int minHeight = Math.min(heights[left], heights[right]);
            int area = minHeight * (right - left);
            maxArea = Math.max(area, maxArea);

            if (heights[left] < heights[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
