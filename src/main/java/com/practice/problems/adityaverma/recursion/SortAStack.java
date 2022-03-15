package com.practice.problems.adityaverma.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Stack;

/**
 * Given a stack, sort it using recursion.
 * Use of any loop constructs like while, for..etc is not allowed.
 * We can only use the following ADT functions on Stack S:
 * <p>
 * push, pop, isEmpty, peek
 **/

@Log4j2
public class SortAStack {

    public static void main(String[] args) {
        var input1 = new Stack<Integer>();
        input1.addAll(List.of(5, 1, 0, 2));
        var input = input1;

        log.info("Before : {}", input);
        sortStack(input);
        log.info("After : {}", input);
    }

    public static void sortStack(Stack<Integer> stack) {
        // BASE CONDITION
        if (stack.size() == 1) return;

        // HYPOTHESIS
        int removedElement = stack.pop();
        sortStack(stack);

        // INDUCTION
        insertBackElement(stack, removedElement);
    }

    private static void insertBackElement(Stack<Integer> stack, Integer element) {
        // BASE CONDITION
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }

        // HYPOTHESIS
        int removedElement = stack.pop();

        // INDUCTION
        insertBackElement(stack, element);
        stack.push(removedElement);
    }
}
