package com.practice.javaconcepts.java8functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerSample {

    /**
     * >>>>>>>>>> CONSUMER <<<<<<<<<<
     * <p>
     * A CONSUMER is a functional interface that accepts a single input and returns no output
     **/

    public void whenNamesPresentConsumeAll() {
        Stream<String> cities = Stream.of("Sydney", "Mumbai", "New York", "London");

        Consumer<String> printConsumer = System.out::println;
        cities.forEach(printConsumer);
    }

    public void whenNamesPresentUseBothConsumer() {
        List<String> cities = Arrays.asList("Sydney", "Mumbai", "New York", "London");

        Consumer<List<String>> uppercaseConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        };

        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

        uppercaseConsumer.andThen(printConsumer).accept(cities);
    }
}
