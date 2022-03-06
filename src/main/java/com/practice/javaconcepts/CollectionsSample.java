package com.practice.javaconcepts;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsSample {

    public static void main(String[] args) {
        Set<String> set = Set.of("tom", "dick", "harry");

        List<String> list = List.of("tom", "dick", "harry");

        List<String> list1 = Arrays.asList("tom", "dick", "harry");

        Map<String, Integer> map = Map.of("tom", 19, "dick", 21, "harry", 32);

        Map<String, Integer> map1 = Map.ofEntries(Map.entry("tom", 19), Map.entry("dick", 21), Map.entry("harry", 32));
    }
}
