package com.practice.designpattern.strategy;

import java.util.List;
import java.util.function.Predicate;

public class LambdaWay {

    /********************** GOOD Design **********************/
    public static int totalValueGOOD(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Lambda Good Design calls
        System.out.println(totalValueGOOD(numbers, e -> true));
        System.out.println(totalValueGOOD(numbers, e -> e % 2 == 0));
        System.out.println(totalValueGOOD(numbers, e -> e % 2 != 0));
    }
}




