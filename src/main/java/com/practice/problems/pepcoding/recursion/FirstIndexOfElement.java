package com.practice.problems.pepcoding.recursion;

public class FirstIndexOfElement {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 6, 9, 8, 3, 2, 6, 2, 4};
        System.out.println(firstIndex(arr, 0, 6));
    }

    private static Integer firstIndex(Integer[] input, int from, int data) {
        if (from == input.length - 1) {
            if (data == input[from]) return input.length - 1;
            else return -1;
        }

        int firstIndex = firstIndex(input, from + 1, data);
        return data == input[from] ? from : firstIndex;
    }
}
