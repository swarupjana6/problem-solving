package com.practice.problems.google.impl.tap;

import com.practice.problems.google.RainWaterTrapping;

public class RainWaterTrappingTap extends RainWaterTrapping {
    @Override
    protected Integer trap(int[] heights) {
        int totalWater = 0;

        var leftMaxs = maxLefts(heights);
        var rightMaxs = maxRights(heights);

        for (int i = 0; i < heights.length; i++) {
            int building = heights[i];
            int limit = Math.min(leftMaxs[i], rightMaxs[i]);
            int buildingWater = limit - building;
            totalWater += buildingWater;
        }

        return totalWater;
    }

    private int[] maxLefts(int[] heights) {
        int[] maxs = new int[heights.length];

        int max = heights[0];
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i]);
            maxs[i] = max;
        }
        return maxs;
    }

    private int[] maxRights(int[] heights) {
        int[] maxs = new int[heights.length];

        int max = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            max = Math.max(max, heights[i]);
            maxs[i] = max;
        }

        return maxs;
    }
}
