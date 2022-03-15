package com.practice.problems.adityaverma.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Stack;

@Log4j2
public class DeleteMiddleElementStack {

    public static void main(String[] args) {
        var input1 = new Stack<Integer>();
        input1.addAll(List.of(1, 2, 3, 4, 5));
        var input = input1;

        log.info("Before : {}", input);
        deleteMid(input);
        log.info("After : {}", input);
    }

    public static void deleteMid(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int middle = (stack.size() / 2) + 1;
        remove(stack, middle);
    }

    private static void remove(Stack<Integer> stack, int middle) {
        // BASE CONDITION
        if (middle == 1) {
            stack.pop();
            return;
        }

        // HYPOTHESIS
        int removed = stack.pop();
        remove(stack, middle - 1);

        // INDUCTION
        stack.push(removed);
    }
}
