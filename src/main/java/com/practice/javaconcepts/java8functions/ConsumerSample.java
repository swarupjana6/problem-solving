package com.practice.javaconcepts.java8functions;

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


class RandomEntity {

    String attr;

    RandomEntity(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return attr;
    }

    public static void main(String[] args) {
        /******/
        List<RandomEntity> newClassList = Arrays.asList(new RandomEntity("abc"), new RandomEntity("pqr"), new RandomEntity("xyz"));
        Consumer<List<RandomEntity>> upperNewClass = list -> list.forEach(element -> element.setAttr(element.getAttr().toUpperCase()));
        Consumer<List<RandomEntity>> printNewClass = list -> list.stream().forEach(System.out::println);
        upperNewClass.andThen(printNewClass).accept(newClassList);
    }
}
