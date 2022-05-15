package com.practice.problems.adityavermapractice.stack;

import java.util.Arrays;
import java.util.List;

public interface NearestGreaterToRight {

    List<Integer> nearestGreaterToRight(List<Integer> inputList, int pseudoIndex);

    default void call() {
        List<Integer> inputList = Arrays.asList(1, 3, 2, 4);
        nearestGreaterToRight(inputList, -1);
    }
}
