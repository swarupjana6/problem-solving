package com.practice.problems.pepcoding.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintZigZag {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Integer number = Integer.parseInt(reader.readLine());
        printZigZag(number);
    }

    private static void printZigZag(Integer input) {
        if (input == 0) return;

        System.out.format("Pre: %d \n", input);
        printZigZag(input - 1);
        System.out.format("In: %d \n", input);
        printZigZag(input - 1);
        System.out.format("Post: %d \n", input);
    }

    /**
     * 2
     *
     *
     *
     *
     *
     * **/
}
