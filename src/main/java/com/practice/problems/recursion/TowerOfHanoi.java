package com.practice.problems.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        char source = 'S';
        char destination = 'D';
        char helper = 'H';

        System.out.println("======================");
        moveDisk(3, source, destination, helper);
        System.out.println("======================");
        moveDisk(4, source, destination, helper);
    }

    private static void moveDisk(int noOfDisks, char source, char destination, char helper) {
        // BASE CONDITION
        if (noOfDisks == 1) {
            System.out.format("moving %d from %c --> %c \n", noOfDisks, source, destination);
            return;
        }

        // HYPOTHESIS
        moveDisk(noOfDisks - 1, source, helper, destination);
        System.out.format("moving %d from %c --> %c \n", noOfDisks, source, destination);

        // INDUCTION
        moveDisk(noOfDisks - 1, helper, destination, source);
    }
}
