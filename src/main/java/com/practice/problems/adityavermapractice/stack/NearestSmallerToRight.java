package com.practice.problems.adityavermapractice.stack;

import java.util.Arrays;
import java.util.List;

public abstract class NearestSmallerToRight extends NearestGreaterSmaller {

    public abstract List<Integer> nearestSmallerToRight(List<Integer> inputList, int pseudoIndex);

    @Override
    public void execute() {
        List<Integer> input = Arrays.asList(6, 8, 7, 9);
        List<Integer> actual = nearestSmallerToRight(input, -1);
        List<Integer> expected = List.of(-1, 2, -1, -1);
        test(input, actual, " 'i' moving from right2Left <<<<<<", expected);
    }
}
