package com.practice.designpattern.strategy;

import java.util.List;

public class BadWay {

    /********************** BAD Design **********************/
    public static int totalValueBAD(List<Integer> values) {
        int total = 0;
        for (int e : values) total += e;
        return total;
    }

    public static int totalEvenValueBAD(List<Integer> values) {
        int total = 0;
        for (int e : values) if (e % 2 == 0) total += e;
        return total;
    }

    public static int totalOddValueBAD(List<Integer> values) {
        int total = 0;
        for (int e : values) if (e % 2 != 0) total += e;
        return total;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //BAD Design calls
        System.out.println(totalValueBAD(numbers));
        System.out.println(totalEvenValueBAD(numbers));
        System.out.println(totalOddValueBAD(numbers));
    }
}
