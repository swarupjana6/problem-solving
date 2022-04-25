package com.practice.problems.pepcoding.recursion;

import java.util.Scanner;

public class PrintNto1And1ToN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.valueOf(scanner.next());
        printNTo1And1ToN(input);
    }

    private static void printNTo1And1ToN(Integer input) {
        if (input == 0  ) return;
        System.out.println(input);
        printNTo1And1ToN(input - 1);
        System.out.println(input);
    }
}
