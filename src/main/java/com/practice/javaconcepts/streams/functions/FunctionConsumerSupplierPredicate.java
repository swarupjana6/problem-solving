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

    private static final Consumer<String> PRINT_STRING_CONSUMER = System.out::println;

    private static final Function<String, Integer> STRING_LENGTH_FUNCTION = String::length; // Accepts String......Returns Integer

    private static final Predicate<String> STARTS_WITH_M_PREDICATE = str -> "M".startsWith(str);

    private static final Predicate<String> LENGTH_GREATER_THAN_5_PREDICATE = str -> str.length() > 5;

    private static final Supplier<Double> RANDOM_DOUBLE_SUPPLIER = () -> Math.random();

    private static final DoubleSupplier PRIMITIVE_DOUBLE_SUPPLIER = Math::random;

    private static final Optional<Double> OPTIONAL_DOUBLE = Optional.empty();

    /**
     * >>>>>>>>>> CONSUMER <<<<<<<<<<
     * <p>
     * A CONSUMER is a functional interface that accepts a single input and returns no output
     **/

    public static void testConsumer() {
        /**Print all cities**/
        List<String> cities = Arrays.asList("Sydney", "Mumbai", "New York", "London");
        cities.stream().forEach(PRINT_STRING_CONSUMER);

        /**Uppercase and Print all cities**/
        // uppercaseConsumer is ugly because of the String's immutability feature
        Consumer<List<String>> uppercaseConsumer = list -> {
            for (int i = 0; i < list.size(); i++) list.set(i, list.get(i).toUpperCase());
        };
        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);
        uppercaseConsumer.andThen(printConsumer).accept(cities);

        /**Uppercase attr and Print all Random Entities**/
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
        List<String> names = List.of("Swarup", "Tapan", "Mayur", "Milind", "Jaswinder", "Rahul", "Ganapathy");

        /**Collect of length of names from the names list**/
        List<Integer> nameLength = names.stream().map(STRING_LENGTH_FUNCTION).collect(Collectors.toList());
        System.out.println(nameLength);
    }

    /**
     * >>>>>>>>>> PREDICATE <<<<<<<<<<
     * <p>
     * A PREDICATE interface represents a boolean-valued-function of an argument.
     * This is mainly used to filter data from a Java Stream.
     **/
    public static void testPredicate() {
        List<String> names = List.of("Swarup", "Tapan", "Mayur", "Milind", "Jaswinder", "Rahul", "Ganapathy");

        /**Print names that starts-with M**/
        names.stream().filter(STARTS_WITH_M_PREDICATE).forEach(System.out::println);

        /**Print names that starts-with M and length greater than 5**/
        Predicate<String> andPredicate = STARTS_WITH_M_PREDICATE.and(LENGTH_GREATER_THAN_5_PREDICATE);
        names.stream().filter(andPredicate).forEach(System.out::println);
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
        System.out.println(RANDOM_DOUBLE_SUPPLIER.get());
        System.out.println(PRIMITIVE_DOUBLE_SUPPLIER.getAsDouble());
        System.out.println(OPTIONAL_DOUBLE.orElseGet(RANDOM_DOUBLE_SUPPLIER));
    }

    public static void main(String[] args) {
        testConsumer();

        testPredicate();

        testFunctions();

        testSupplier();
    }
}