package com.practice.javaconcepts.streams.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerSample {

    /**
     * >>>>>>>>>> CONSUMER <<<<<<<<<<
     * <p>
     * A CONSUMER is a functional interface that accepts a single input and returns no output
     **/

    public static void whenNamesPresentConsumeAll() {
        List<String> cities = Arrays.asList("Sydney", "Mumbai", "New York", "London");
        Consumer<String> printConsumer = System.out::println;
        cities.stream().forEach(printConsumer);
    }

    public static void whenNamesPresentUseBothConsumer() {
        List<String> cities = Arrays.asList("Sydney", "Mumbai", "New York", "London");

        // Consumers
        // uppercaseConsumer is ugly because of the String's immutability feature
        Consumer<List<String>> uppercaseConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

        uppercaseConsumer.andThen(printConsumer).accept(cities);
    }

    public static void main(String[] args) {
        whenNamesPresentConsumeAll();
        whenNamesPresentUseBothConsumer();
    }
}
