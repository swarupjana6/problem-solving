package com.practice.problems.pepcoding.recursion;

import java.util.Scanner;

public class PrintNto1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.valueOf(scanner.next());
        printNTo1(input);
    }

    private static void printNTo1(Integer input) {
        if (input == 0) return;
        System.out.println(input);
        printNTo1(input - 1);
    }
}
