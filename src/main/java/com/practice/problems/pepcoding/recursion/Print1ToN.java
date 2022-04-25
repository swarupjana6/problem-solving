package com.practice.problems.pepcoding.recursion;

import java.util.Scanner;

public class Print1ToN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.valueOf(scanner.next());
        print1ToN(input);
    }

    private static void print1ToN(Integer input) {
        if (input == 0) return;
        print1ToN(input - 1);
        System.out.println(input);
    }
}
