package com.practice.problems.pepcoding.recursion;

public class PrintNto1 {

    public static void main(String[] args) {
        String name = System.console().readLine();
        System.out.println("You entered string " + name);
    }

    private static void printNTo1(Integer input) {
        if (input == 0) return;
        System.out.println(input);
        printNTo1(input - 1);
    }
}
