package com.practice.javaconcepts.java8functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionSample {

    /**
     * >>>>>>>>>> FUNCTION <<<<<<<<<<
     * <p>
     * A FUNCTION<T,R> interface is more of a generic one that takes one argument and produces a result.
     * This has a Single Abstract Method (SAM) apply which accepts an argument of a type T and produces a result of type R
     *
     * T -> parameter
     * R -> return type
     **/

    public void testFunctions() {
        List<String> names = Arrays.asList("Swarup", "Tapan", "Mayur", "Milind", "Jaswinder", "Rahul", "Ganapathy");
        // Accepts String......Returns Integer
        Function<String, Integer> nameMappingFunction = String::length;
        List<Integer> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
        System.out.println(nameLength);
    }
}
