package com.practice.designpattern.proxy;

import java.util.function.Supplier;

public class LazyEvaluationSample {
    public static int compute(int n) {
        System.out.println("Compute called...");
        return n * 2;
    }

    public static void main(String[] args) {
        int x = 14;
        //int temp = compute(x);                /// WITHOUT LAZY INITIALIZATION
        var temp = new Lazy<Integer>(() -> compute(x));

        if (x > 5 && temp.get() > 7) {
            System.out.println("Path 1");
        } else {
            System.out.println("Path 2");
        }
    }
}

class Lazy<T> {
    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    private void before() {
        System.out.println("Initializing before compute call");
    }

    public T get() {
        if (instance == null) {
            before();
            instance = supplier.get();
            supplier = null;
            after();
        }

        return instance;
    }

    private void after() {
        System.out.println("Clean up/Logging after compute..");
    }
}
