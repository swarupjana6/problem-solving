package com.practice.problems.pepcoding.recursion;

import java.util.Scanner;

public class PowerLinear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer power = Integer.valueOf(scanner.next());
        Integer number = Integer.valueOf(scanner.next());

        int result = 1;
        for (int i = 1; i <= power; i++) result *= number;

        System.out.println(power(number, power));
    }

    private static Integer power(Integer number, Integer power) {
        if (power == 0) return 1;

        int prevResult = power(number, power - 1);

        // power of number = number X number ^ power-1
        return number * prevResult;
    }
}
