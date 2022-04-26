package com.practice.problems.pepcoding.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class TowerOfHanoi {

    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int source = scn.nextInt();
        int destination = scn.nextInt();
        int helper = scn.nextInt();

        toh(n, source, destination, helper);
    }

    private static void toh(int n, int source, int destination, int helper) {
        if (n == 0) return;

        toh(n - 1, source, helper, destination);
        System.out.println(n + "[" + source + "--> " + destination + "]");
        toh(n - 1, helper, destination, source);
    }
}
