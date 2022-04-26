package com.practice.problems.pepcoding.recursion;

public class MaxOfAnArray {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{22, 33, 4, 19, 7};
        System.out.println(maxOfArr(arr, 0));
    }

    private static Integer maxOfArr(Integer[] input, int from) {
        if (from == input.length - 1) return input[input.length - 1];

        int maxInSmaller = maxOfArr(input, from + 1);
        if (maxInSmaller > input[from]) return maxInSmaller;
        else return input[from];
    }
}
