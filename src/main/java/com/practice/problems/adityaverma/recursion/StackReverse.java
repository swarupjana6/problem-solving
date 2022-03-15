package com.practice.problems.adityaverma.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Stack;

/**
 * Write a program to reverse a stack using recursion.
 * You are not allowed to use loop constructs like while, for..etc
 * **/

@Log4j2
public class StackReverse {

    public static void main(String[] args) {
        var input1 = new Stack<Integer>();
        input1.addAll(List.of(1, 2, 3, 4, 5));
        var input = input1;

        log.info("Before : {}", input);
        reverse(input);
        log.info("After : {}", input);
    }

    public static void reverse(Stack<Integer> stack) {
        // BASE CONDITION
        if (stack.size() == 1) return;

        // HYPOTHESIS
        int removed = stack.pop();
        reverse(stack);

        // INDUCTION
        insert(stack, removed);
    }

    private static void insert(Stack<Integer> stack, Integer element) {
        // BASE CONDITION
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        // HYPOTHESIS
        int removed = stack.pop();
        insert(stack, element);

        // INDUCTION
        stack.push(removed);
    }
}
