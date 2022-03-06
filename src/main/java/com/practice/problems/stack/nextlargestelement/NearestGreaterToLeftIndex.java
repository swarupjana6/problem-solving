package com.practice.problems.stack.nextlargestelement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NearestGreaterToLeftIndex {

    public List<Integer> bruteForce(List<Integer> inputList) {
        List<Integer> outputList = new ArrayList<>();
        outputList.add(0);

        int counter = 0;
        for (int i = 1; i < inputList.size(); i++) {
            int j = i - 1;

            //Check if previous nums has greater element
            while (j >= 0) {
                ++counter;
                if (inputList.get(j) > inputList.get(i)) {
                    outputList.add(i - j);
                    break;
                }
                j--;
            }
            if (j == -1) outputList.add(i);
        }

        System.out.format("Brut force::  %s\n", counter);
        return outputList;
    }

    public List<Integer> stackImplementation(List<Integer> inputList) {
        int n = inputList.size();
        Integer[] nextGreatest = new Integer[n];

        Stack<Integer> prevElementsIndex = new Stack<>();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int currentElement = inputList.get(i);
            nextGreatest[i] = i;

            while (!prevElementsIndex.empty()) {
                ++counter;
                int topIndex = prevElementsIndex.peek();
                int topElem = inputList.get(topIndex);
                if (topElem > currentElement) {
                    nextGreatest[i] = i - topIndex;
                    break;
                } else {
                    prevElementsIndex.pop();
                }
            }

            prevElementsIndex.push(i);
        }

        System.out.format("StackImplementation:: %s\n", counter);
        return Arrays.asList(nextGreatest);
    }

    public static void main(String[] args) {
        List<Integer> inputList1 = List.of(10, 8, 11, 9, 5, 24, 19, 18, 17, 16, 17, 25);
        List<Integer> inputList2 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> inputList3 = IntStream.rangeClosed(1, 10).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<Integer> inputList = inputList3;
        System.out.println("InputList   :: " + inputList);
        System.out.println("OutputList  :: " + new NearestGreaterToLeftIndex().bruteForce(inputList));
        System.out.println("OutputList  :: " + new NearestGreaterToLeftIndex().stackImplementation(inputList));
    }
}
