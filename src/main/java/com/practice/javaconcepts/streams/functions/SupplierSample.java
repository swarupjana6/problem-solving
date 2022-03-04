package com.practice.javaconcepts.streams.functions;

import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierSample {

    /**
     * >>>>>>>>>> SUPPLIER <<<<<<<<<<
     * <p>
     * A SUPPLIER is a simple interface which indicates that this implementation is a supplier of results
     * One of the primary usage of this interface to enable deferred execution
     *
     * accepts no parameter and returns generic type
     **/

    public static void supplier() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        DoubleSupplier primitiveDoubleSupplier = Math::random;
        Optional<Double> optionalDouble = Optional.empty();

        System.out.println(doubleSupplier.get());
        System.out.println(primitiveDoubleSupplier.getAsDouble());
        System.out.println(optionalDouble.orElseGet(doubleSupplier));
    }

    public static void main(String[] args) {
        supplier();
    }
}
