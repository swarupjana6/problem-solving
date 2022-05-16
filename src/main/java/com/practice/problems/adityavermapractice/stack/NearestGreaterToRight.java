package com.practice.problems.adityavermapractice.stack;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class NearestGreaterToRight extends NearestGreaterSmaller {

    public abstract List<Integer> nearestGreaterToRight(List<Integer> inputList, int pseudoIndex);

    @Override
    protected void execute() {
        List<Integer> input = Arrays.asList(6, 8, 7, 9);
        List<Integer> actual = nearestGreaterToRight(input, -1);
        Consumer<List<Integer>> expectedValidator = actualOutput -> assertEquals(List.of(1, 3, 3, -1), actualOutput);
        test(input, actual, " 'i' moving from right2Left >>>>>>", expectedValidator);
    }
}
