package com.practice.problems.stack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.practice.problems.stack.NearestSmallerOrGreater.nearestGreaterToLeft;
import static java.util.stream.Collectors.toList;

/**
 * CONSECUTIVE SMALLER OR EQUAL BEFORE IT
 * <p>
 * This problem is SIMILAR to NearestSmallerOrGreater::nearestGreaterToRight
 **/
public class StockSpanProblem {

    public static final String LOG_STR = "\n%s %s\n I/P \t\t:: %s \n O/P \t\t:: %s \n-------";

    private static List<Integer> stockSpan(List<Integer> inputList) {
        List<Integer> outputList = nearestGreaterToLeft(inputList, -1);

        // Nearest Greatest MINUS Current Index
        List<Integer> finalResults = IntStream.rangeClosed(0, outputList.size() - 1).map(index -> index - outputList.get(index)).boxed().collect(toList());

        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from left2right >>>>>>", inputList, finalResults);
        return finalResults;
    }

    public static void main(String[] args) {
        stockSpan(Arrays.asList(100, 80, 60, 70, 60, 75, 85)); // (1, 1, 1, 2, 1, 4, 6)
    }
}