package com.practice.problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.practice.problems.stack.NearestSmallerOrGreater.nearestSmallest;

/**
 * <p>
 * This problem is SIMILAR to nearestSmallestLeft PLUS nearestSmallestRight
 **/
public class MaximumAreaHistogram {

    public static void main(String[] args) {
        System.out.println(area(Arrays.asList(6, 2, 5, 4, 5, 1, 6)));
    }

    private static Integer area(List<Integer> inputList) {
        List<Integer> widthLeft = nearestSmallest(inputList, true, -1);
        List<Integer> widthRight = nearestSmallest(inputList, false, inputList.size());
        List<Integer> area = new ArrayList<>();
        // (widthRight.get(i) - widthLeft.get(i) - 1)
        int bound = inputList.size();
        for (int i = 0; i < bound; i++) {
            int width = (widthRight.get(i) - widthLeft.get(i) - 1);
            int height = inputList.get(i);
            area.add(width * height);
        }
        return area.stream().mapToInt(v -> v).max().getAsInt();
    }
}
