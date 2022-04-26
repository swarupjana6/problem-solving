package com.practice.problems.pepcoding.recursion;

public class FirstIndexOfElement {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 6, 9, 8, 3, 2, 6, 2, 4};
        System.out.println(maxOfArr(arr, 0, 6));
    }

    private static Integer maxOfArr(Integer[] input, int from, int data) {
        if (from == input.length - 1) {
            if (data == input[from]) return input.length - 1;
            else return Integer.MAX_VALUE;
        }

        int smallestIndex = maxOfArr(input, from + 1, data);
        if (data == input[from]) {
            return from;
        } else {
            return smallestIndex;
        }
    }
}
