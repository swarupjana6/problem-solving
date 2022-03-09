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
        int temp = input.get(input.size() - 1);
        input.remove(input.size() - 1);
        sort(input);

        // INDUCTION
        insert(input, temp);
    }

    private static void insert(List<Integer> subList, Integer element) {
        if (subList.size() == 0 || subList.get(subList.size() - 1) <= element) {
            subList.add(subList.size(), element);
            return;
        }

        int temp = subList.get(subList.size() - 1);
        subList.remove(subList.size() - 1);

        insert(subList, element);
        subList.add(temp);
    }
}
