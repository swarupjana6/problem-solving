package com.practice.others.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreviousGreaterElementIndex {

    public List<Integer> prevMax1(List<Integer> inputList) {
        List<Integer> outputList = new ArrayList<>();
        outputList.add(0);

        for (int i = 1; i < inputList.size(); i++) {
            int j = i - 1;

            //Check if previous nums has greater element
            while (j >= 0) {
                if (inputList.get(j) > inputList.get(i)) {
                    outputList.add(i - j);
                    break;
                }
                j--;
            }
            if (j == -1) outputList.add(i);
        }

        return outputList;
    }

    public List<Integer> prevMax2(List<Integer> inputList) {
        int n = inputList.size();
        Integer[] nextGreatest = new Integer[n];

        Stack<Integer> prevElements = new Stack<>();
        Stack<Integer> prevElementsIndex = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currentElement = inputList.get(i);
            nextGreatest[i] = i;
            while (!prevElements.empty()) {
                int top = prevElements.peek();
                int topIndex = prevElementsIndex.peek();
                if (top > currentElement) {
                    nextGreatest[i] = i - topIndex;
                    break;
                } else {
                    prevElements.pop();
                    prevElementsIndex.pop();
                }
            }
            prevElements.push(currentElement);
            prevElementsIndex.push(i);
        }

        return Arrays.asList(nextGreatest);
    }

    public static void main(String[] args) {
        List<Integer> inputList = List.of(10, 8, 11, 9, 5, 20, 15, 15);
        System.out.println("InputList   :: " + inputList);
        System.out.println("OutputList  :: " + new PreviousGreaterElementIndex().prevMax1(inputList));
        System.out.println("OutputList  :: " + new PreviousGreaterElementIndex().prevMax2(inputList));
    }
}
