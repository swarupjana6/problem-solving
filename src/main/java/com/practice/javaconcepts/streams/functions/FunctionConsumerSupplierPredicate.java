package com.practice.javaconcepts.streams.functions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionConsumerSupplierPredicate {

    /**
     * >>>>>>>>>> CONSUMER <<<<<<<<<<
     * <p>
     * A CONSUMER is a functional interface that accepts a single input and returns no output
     **/

    public static void whenNamesPresentConsumeAll() {
        List<String> cities = List.of("Sydney", "Mumbai", "New York", "London");
        Consumer<String> printConsumer = System.out::println;
        cities.stream().forEach(printConsumer);
    }

    public static void whenNamesPresentUseBothConsumer() {
        List<String> cities = List.of("Sydney", "Mumbai", "New York", "London");

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

    public static void consumerForRandomEntity() {
        List<RandomEntity> newClassList = List.of(new RandomEntity("abc"), new RandomEntity("pqr"), new RandomEntity("xyz"));
        Consumer<List<RandomEntity>> upperNewClass = list -> list.forEach(element -> element.setAttr(element.getAttr().toUpperCase()));
        Consumer<List<RandomEntity>> printNewClass = list -> list.stream().forEach(System.out::println);
        upperNewClass.andThen(printNewClass).accept(newClassList);
    }

    /**
     * >>>>>>>>>> FUNCTION <<<<<<<<<<
     * <p>
     * A FUNCTION<T,R> interface is more of a generic one that takes one argument and produces a result.
     * This has a Single Abstract Method (SAM) apply which accepts an argument of a type T and produces a result of type R
     * <p>
     * T -> parameter
     * R -> return type
     **/

    public static void testFunctions() {
        List<String> names = Arrays.asList("Swarup", "Tapan", "Mayur", "Milind", "Jaswinder", "Rahul", "Ganapathy");
        // Accepts String......Returns Integer
        Function<String, Integer> nameMappingFunction = String::length;
        List<Integer> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
        System.out.println(nameLength);
    }

    /**
     * >>>>>>>>>> PREDICATE <<<<<<<<<<
     * <p>
     * A PREDICATE interface represents a boolean-valued-function of an argument.
     * This is mainly used to filter data from a Java Stream.
     **/
    public static void testPredicate() {
        List<String> names = Arrays.asList("Swarup", "Tapan", "Mayur", "Milind", "Jaswinder", "Rahul", "Ganapathy");
        Predicate<String> nameStartsWithM = str -> str.startsWith("M");
        names.stream().filter(nameStartsWithM).forEach(System.out::println);
    }

    public static void testPredicateAndComposition() {
        List<String> names = Arrays.asList("Swarup", "Tapan", "Mayur", "Milind", "Jaswinder", "Rahul", "Ganapathy");
        Predicate<String> startPredicate = str -> str.startsWith("M");
        Predicate<String> lengthPredicate = str -> str.length() > 5;
        names.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);
    }

    /**
     * >>>>>>>>>> SUPPLIER <<<<<<<<<<
     * <p>
     * A SUPPLIER is a simple interface which indicates that this implementation is a supplier of results
     * One of the primary usage of this interface to enable deferred execution
     * <p>
     * accepts no parameter and returns generic type
     **/

    public static void testSupplier() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        DoubleSupplier primitiveDoubleSupplier = Math::random;
        Optional<Double> optionalDouble = Optional.empty();

        System.out.println(doubleSupplier.get());
        System.out.println(primitiveDoubleSupplier.getAsDouble());
        System.out.println(optionalDouble.orElseGet(doubleSupplier));
    }

    public static void main(String[] args) {
        whenNamesPresentConsumeAll();
        whenNamesPresentUseBothConsumer();
        consumerForRandomEntity();

        testPredicate();
        testPredicateAndComposition();

        testFunctions();

        testSupplier();
    }
}