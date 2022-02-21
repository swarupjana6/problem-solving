package com.practice.designpattern.decorator;

import java.util.function.Function;

public class DecoratorViaComposability {

    private static void printIt(int n, String msg, Function<Integer, Integer> func) {
        System.out.println(n + " " + msg + " : " + func.apply(n));
    }

    public static void main(String[] args) {
        /********* Increment *********/
        Function<Integer, Integer> increment = e -> e + 1;
        printIt(5, "incremented", increment);
        printIt(10, "incremented", increment);

        /********* Increment *********/
        Function<Integer, Integer> doubled = e -> e * 1;
        printIt(5, "doubled", doubled);
        printIt(10, "doubled", doubled);

        /*********Increment and double*********/
        printIt(5, "incremented and doubled", increment.andThen(doubled));
    }
}
