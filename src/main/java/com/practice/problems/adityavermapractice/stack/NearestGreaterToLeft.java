package com.practice.problems.adityavermapractice.stack;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class NearestGreaterToLeft extends NearestGreaterSmaller {

    public abstract List<Integer> nearestGreaterToLeft(List<Integer> inputList, int pseudoIndex);

    protected void execute() {
        List<Integer> input = Arrays.asList(1, 3, 2, 4);
        List<Integer> actual = nearestGreaterToLeft(input, -1);
        Consumer<List<Integer>> expectedValidator = actualOutput -> assertEquals(List.of(-1, -1, 1, -1), actualOutput);
        test(input, actual, " 'i' moving from left2Right >>>>>>", expectedValidator);
    }
}
