package com.practice.problems.adityaverma.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.LinkedList;
import java.util.List;

@Log4j2
public class Sort {

    public static void main(String[] args) {
        var input1 = new LinkedList<Integer>(List.of(2, 7, 5, 9, 3));
        var input = input1;

        log.info("Before : {}", input);
        sortList(input);
        log.info("After : {}", input);
    }

    private static void sortList(List<Integer> input) {
        // BASE CONDITION
        if (input.size() == 1) return;

        // HYPOTHESIS
        int removedElement = input.remove(input.size() - 1);
        sortList(input);

        // INDUCTION
        // Insert removedElement that was removed in HYPOTHESIS into the input list
        // insertIterative(input, removedElement);       // Instead of using the recursion again we can Iteratively solve the Induction step
        insertElement(input, removedElement);
    }

    private static void insertElement(List<Integer> subList, Integer element) {
        // BASE CONDITION
        if (subList.size() == 0 || subList.get(subList.size() - 1) <= element) {
            subList.add(subList.size(), element);
            return;
        }

        // HYPOTHESIS
        int removedElement = subList.remove(subList.size() - 1);

        // INDUCTION
        insertElement(subList, element);
        subList.add(removedElement);
    }

    private static void insertIterative(List<Integer> subList, Integer element) {
        if (subList.size() == 0 || element >= subList.get(subList.size() - 1)) {
            subList.add(subList.size(), element);
            return;
        }
        for (int i = subList.size() - 1; i >= 0; i--) {
            if (element > subList.get(i)) {
                subList.add(i + 1, element);
                return;
            }
        }
    }
}
