package com.practice.problems.adityavermapractice.recursion.tap;

import java.util.List;
import java.util.Stack;

public class Utils {

    public static List<Integer> insertElementInSortedList(Integer element, List<Integer> sortedList) {
        // BASE CONDITION
        if (sortedList.size() == 0 || element > sortedList.get(sortedList.size() - 1)) {
            sortedList.add(element);
            return sortedList;
        }

        // HYPOTHESIS
        int lastElement = sortedList.remove(sortedList.size() - 1);
        sortedList = insertElementInSortedList(element, sortedList);

        // INDUCTION
        sortedList.add(lastElement);
        return sortedList;
    }

    public static void insertElementInSortedStack(Integer element, Stack<Integer> stack) {
        // BASE CONDITION
        if (stack.size() == 0 || element > stack.peek()) {
            stack.push(element);
            return;
        }

        // HYPOTHESIS
        int stackTop = stack.pop();
        insertElementInSortedStack(element, stack);

        // INDUCTION
        stack.push(stackTop);
        return;
    }

    public static void insertToStacksBottom(Stack<Integer> stack, Integer element) {
        // BASE CONDITION
        if(stack.empty()) {
            stack.push(element);
            return;
        }

        // HYPOTHESIS
        int stackTop = stack.pop();
        insertToStacksBottom(stack, element);

        // INDUCTION
        stack.push(stackTop);
    }

    public static void movePlateFromSourceToDestination(int n, Character source, Character destination) {
        System.out.format("Moving %d plate %c ----> %c \n", n, source, destination);
    }
}
