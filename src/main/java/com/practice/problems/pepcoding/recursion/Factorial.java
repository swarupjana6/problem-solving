package com.practice.problems.pepcoding.recursion;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.valueOf(scanner.next());
        System.out.println(factorial(input));
    }

    private static Integer factorial(Integer input) {
        if (input == 1) return 1;
        int factPrevInput = factorial(input - 1);
        return input * factPrevInput;
    }
}
