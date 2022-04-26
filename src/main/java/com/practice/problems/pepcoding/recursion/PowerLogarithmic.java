package com.practice.problems.pepcoding.recursion;

import java.util.Scanner;

public class PowerLogarithmic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer power = Integer.valueOf(scanner.next());
        Integer number = Integer.valueOf(scanner.next());
        System.out.println(power(number, power));
    }

    private static Integer power(Integer num, Integer power) {
        if (power == 0) return 1;

        int numRaiseToPowerBy2 = power(num, power / 2);
        int numRaiseToPower = numRaiseToPowerBy2 * numRaiseToPowerBy2;

        // power of num = num ^ power/2 X num ^ power/2
        if (power % 2 == 1) numRaiseToPower = numRaiseToPower * num;

        return numRaiseToPower;
    }
}
