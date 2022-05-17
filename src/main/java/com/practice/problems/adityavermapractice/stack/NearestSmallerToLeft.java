package com.practice.problems.adityavermapractice.stack;

import java.util.List;

public abstract class NearestSmallerToLeft extends NearestGreaterSmaller {

    public abstract List<Integer> nearestSmallerToLeft(List<Integer> inputList, int pseudoIndex);

    @Override
    public void execute() {
        List<Integer> input = List.of(6, 8, 7, 9);
        List<Integer> actual = nearestSmallerToLeft(input, -1);
        List<Integer> expected = List.of(-1, 0, 0, 2);
        test(input, actual, " 'i' moving from left2Right >>>>>>", expected);
    }
}
