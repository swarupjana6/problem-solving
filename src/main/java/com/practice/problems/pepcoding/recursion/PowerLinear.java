package com.practice.problems.pepcoding.recursion;

import java.util.Scanner;

public class PowerLinear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer power = Integer.valueOf(scanner.next());
        Integer number = Integer.valueOf(scanner.next());
        System.out.println(power(number, power));
    }

    private static Integer power(Integer number, Integer power) {
        if (power == 1) return number;
        int prevPower = power(number, power - 1);
        return number * prevPower;
    }
}
