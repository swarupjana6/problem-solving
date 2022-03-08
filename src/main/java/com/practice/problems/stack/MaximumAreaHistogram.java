package com.practice.problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.practice.problems.stack.NearestSmallerOrGreater.nearestSmallerToLeft;
import static com.practice.problems.stack.NearestSmallerOrGreater.nearestSmallerToRight;

/**
 * <p>
 * This problem is SIMILAR to nearestSmallestLeft PLUS nearestSmallestRight
 **/
public class MaximumAreaHistogram {

    public static void main(String[] args) {
        System.out.format("MAXIMUM AREA IN HISTOGRAM :: %s\n", histogramArea(Arrays.asList(6, 2, 5, 4, 5, 1, 6)));
    }

    public static Integer histogramArea(List<Integer> inputList) {
        List<Integer> widthLeft = nearestSmallerToLeft(inputList, -1);
        List<Integer> widthRight = nearestSmallerToRight(inputList, inputList.size());
        List<Integer> area = new ArrayList<>();

        // (widthRight.get(i) - widthLeft.get(i) - 1)
        for (int i = 0; i < inputList.size(); i++) {
            int width = (widthRight.get(i) - widthLeft.get(i) - 1);
            int height = inputList.get(i);
            area.add(width * height);
        }
        return area.stream().mapToInt(v -> v).max().getAsInt();
    }
}
