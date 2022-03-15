package com.practice.problems.adityaverma.recursion;

public class Print1ToN {

    public static void main(String[] args) {
        print(7);
    }

    public static void print(int n) {
        // BASE CONDITION
        if (n == 1) {
            System.out.format("%d ", n);
            return;
        }

        // HYPOTHESIS
        print(n - 1);

        // INDUCTION
        System.out.format("%d ", n);
    }
}
