package com.practice.designpattern.strategy;

import java.util.List;
import java.util.function.Predicate;

public class LambdaWay {

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

    /********************** GOOD Design **********************/
    public static int totalValueGOOD(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //BAD Design calls
        System.out.println(totalValueBAD(numbers));
        System.out.println(totalEvenValueBAD(numbers));
        System.out.println(totalOddValueBAD(numbers));

        //BAD Design calls
        System.out.println(totalValueGOOD(numbers, e -> true));
        System.out.println(totalValueGOOD(numbers, e -> e % 2 == 0));
        System.out.println(totalValueGOOD(numbers, e -> e % 2 != 0));
    }
}




