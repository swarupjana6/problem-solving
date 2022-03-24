package com.practice.problems.adityaverma.recursion;

import lombok.extern.log4j.Log4j2;

/**
 * Tower of Hanoi is a mathematical puzzle where we have three rods and n disks.
 * The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
 * <p>
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 * Approach :
 * <p>
 * <p>
 * Take an example for 2 disks :
 * Let rod 1 = 'A', rod 2 = 'B', rod 3 = 'C'.
 * <p>
 * Step 1 : Shift first disk from 'A' to 'B'.
 * Step 2 : Shift second disk from 'A' to 'C'.
 * Step 3 : Shift first disk from 'B' to 'C'.
 * <p>
 * The pattern here is :
 * Shift 'n-1' disks from 'A' to 'B'.
 * Shift last disk from 'A' to 'C'.
 * Shift 'n-1' disks from 'B' to 'C'.
 **/

@Log4j2
public class TowerOfHanoi {

    public static void main(String[] args) {
        char source = 'S';
        char destination = 'D';
        char helper = 'H';

        log.info("======================");
        moveDisk(3, source, destination, helper);
        log.info("======================");
        moveDisk(4, source, destination, helper);
    }

    private static void moveDisk(int noOfDisks, char source, char destination, char helper) {
        // BASE CONDITION
        if (noOfDisks == 1) {
            log.info("moving {} from {} --> {} ", noOfDisks, source, destination);
            return;
        }

        // HYPOTHESIS
        moveDisk(noOfDisks - 1, source, helper, destination);
        log.info("moving {} from {} --> {} ", noOfDisks, source, destination);

        // INDUCTION
        moveDisk(noOfDisks - 1, helper, destination, source);
    }
}
