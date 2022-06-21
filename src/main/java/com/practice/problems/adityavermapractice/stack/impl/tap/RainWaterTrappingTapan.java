package com.practice.problems.adityavermapractice.stack.impl.tap;

import com.practice.problems.adityavermapractice.stack.RainWaterTrapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RainWaterTrappingTapan extends RainWaterTrapping {

    @Override
    public Integer rainWaterTrapping(List<Integer> buildingHeights) {
        int totalWater = 0;
        List<Integer> maxLefts = calculateMaxLefts(buildingHeights);
        List<Integer> maxRights = calculateMaxRights(buildingHeights);

        for (int i = 0; i < buildingHeights.size(); i++) {
            int buildingHeight = buildingHeights.get(i);
            totalWater += Math.min(maxLefts.get(i), maxRights.get(i)) - buildingHeight;
        }

        return totalWater;
    }

    private List<Integer> calculateMaxRights(List<Integer> buildingHeights) {
        Integer maxBuilding = buildingHeights.get(buildingHeights.size() - 1);
        List<Integer> maxRights = new ArrayList<>();

        for (int i = buildingHeights.size() - 1; i >= 0; i--) {
            maxBuilding = Math.max(maxBuilding, buildingHeights.get(i));
            maxRights.add(maxBuilding);
        }

        Collections.reverse(maxRights);
        return maxRights;
    }

    private List<Integer> calculateMaxLefts(List<Integer> buildingHeights) {
        Integer maxBuilding = buildingHeights.get(0);
        List<Integer> maxLefts = new ArrayList<>();

        for (int i = 0; i < buildingHeights.size(); i++) {
            maxBuilding = Math.max(maxBuilding, buildingHeights.get(i));
            maxLefts.add(maxBuilding);
        }

        return maxLefts;
    }
}
