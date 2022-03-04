package com.practice.javaconcepts.streams.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSample {

    /**
     * >>>>>>>>>> PREDICATE <<<<<<<<<<
     * <p>
     * A PREDICATE interface represents a boolean-valued-function of an argument.
     * This is mainly used to filter data from a Java Stream.
     **/
    public void testPredicate() {
        List<String> names = Arrays.asList("Swarup", "Tapan", "Mayur", "Milind", "Jaswinder", "Rahul", "Ganapathy");
        Predicate<String> nameStartsWithM = str -> str.startsWith("M");
        names.stream().filter(nameStartsWithM).forEach(System.out::println);
    }

    public void testPredicateAndComposition() {
        List<String> names = Arrays.asList("Swarup", "Tapan", "Mayur", "Milind", "Jaswinder", "Rahul", "Ganapathy");
        Predicate<String> startPredicate = str -> str.startsWith("M");
        Predicate<String> lengthPredicate = str -> str.length() > 5;
        names.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);
    }
}
