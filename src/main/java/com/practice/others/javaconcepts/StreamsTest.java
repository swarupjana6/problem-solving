package com.practice.others.javaconcepts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsTest {

    public static Map<String, Long> secondSolution(List<String> contents) {

        Map<String, Long> fruitCount = contents
                .stream()
                .collect(Collectors.groupingBy(Function.identity()
                        , HashMap::new
                        , Collectors.counting()));

        fruitCount.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

        return fruitCount;
    }

    public static void main(String[] args) {
        System.out.println(secondSolution(List.of("Apple", "Orange", "Orange", "Banana", "Apple", "Orange")));
    }
}
