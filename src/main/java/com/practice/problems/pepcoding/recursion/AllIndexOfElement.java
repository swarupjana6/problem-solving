package com.practice.problems.pepcoding.recursion;

import java.util.Arrays;

public class AllIndexOfElement {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 6, 9, 4, 3, 2, 4, 2, 4};
        System.out.println(Arrays.toString(allIndices(arr, 0, 2, 0)));
    }

    private static Integer[] allIndices(Integer[] input, int from, int data, int foundSoFar) {
        if (from == input.length) return new Integer[foundSoFar];

        Integer[] found = null;
        if (input[from] == data) {
            found = allIndices(input, from + 1, data, foundSoFar + 1);
            found[foundSoFar] = from;
        } else {
            found = allIndices(input, from + 1, data, foundSoFar);
        }
        return found;
    }
}
