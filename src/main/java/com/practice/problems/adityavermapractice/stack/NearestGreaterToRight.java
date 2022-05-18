package com.practice.problems.adityavermapractice.stack;

import java.util.List;

public abstract class NearestGreaterToRight extends NearestGreaterSmaller {

    public abstract List<Integer> nearestGreaterToRight(List<Integer> inputList, int pseudoIndex);

    @Override
    public void execute() {
        List<Integer> input = List.of(6, 8, 7, 9);
        List<Integer> actual = nearestGreaterToRight(input, -1);
        List<Integer> expected = List.of(1, 3, 3, -1);
        test(input, actual, " 'i' moving from right2Left >>>>>>", expected);
    }
}
