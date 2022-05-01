package com.practice.problems.pepcoding.recursion;

public class LastIndexOfElement {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 6, 9, 4, 3, 2, 4, 2, 4};
        System.out.println(lastIndex(arr, 0, 2));
        System.out.println(lastIndexNew(arr, arr.length - 1, 2));
    }

    private static Integer lastIndex(Integer[] input, int from, int data) {
        if (from == input.length) return -1;

        int lastIndex = lastIndex(input, from + 1, data);
        if (lastIndex == -1) return data == input[from] ? from : -1;
        else return lastIndex;
    }

    private static Integer lastIndexNew(Integer[] input, int from, int data) {
        if (from == 0) {
            if (data == input[from]) return 0;
            else return -1;
        }

        int lastIndex = lastIndex(input, from - 1, data);
        return data == input[from] ? from : lastIndex;
    }
}
