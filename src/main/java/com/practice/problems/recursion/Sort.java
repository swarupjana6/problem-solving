package com.practice.problems.recursion;

import lombok.extern.log4j.Log4j2;

import java.util.LinkedList;
import java.util.List;

@Log4j2
public class Sort {

    public static void main(String[] args) {
        var input1 = new LinkedList<Integer>(List.of(2, 7, 5, 9, 3));
        var input = input1;

        log.info("Before : {}", input);
        sort(input);
        log.info("After : {}", input);
    }

    private static void sort(List<Integer> input) {
        // BASE CONDITION
        if (input.size() == 0) return;

        // HYPOTHESIS
        int temp = input.remove(input.size() - 1);
        sort(input);

        // INDUCTION
        // Insert temp that was removed in HYPOTHESIS into the input list
        // insertIterative(input, temp);       // Instead of using the recursion again we can Iteratively solve the Induction step
        insertRecursively(input, temp);
    }

    private static void insertRecursively(List<Integer> subList, Integer element) {
        // BASE CONDITION
        if (subList.size() == 0 || subList.get(subList.size() - 1) <= element) {
            subList.add(subList.size(), element);
            return;
        }

        // HYPOTHESIS
        int temp = subList.remove(subList.size() - 1);

        // INDUCTION
        insertRecursively(subList, element);
        subList.add(temp);
    }

    private static void insertIterative(List<Integer> subList, int element) {
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
