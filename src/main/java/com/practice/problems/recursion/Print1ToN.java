package com.practice.problems.recursion;

public class Print1ToN {

    public static void main(String[] args) {
        print(7);
    }

    public static void print(int n) {
        if (n == 1) {
            System.out.format("%d ", n);
            return;
        }

        print(n - 1);

        System.out.format("%d ", n);
    }
}
