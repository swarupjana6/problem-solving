package com.practice.problems.others;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PreviousGreaterElementIndex {

    private static final Logger log = LogManager.getLogger(PreviousGreaterElementIndex.class);

    public List<Integer> prevMax1(List<Integer> inputList) {
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

        log.info("Brut force:: {}\n", counter);
        return outputList;
    }

    public List<Integer> prevMax2(List<Integer> inputList) {
        int n = inputList.size();
        Integer[] nextGreatest = new Integer[n];

        Stack<Integer> prevElements = new Stack<>();
        Stack<Integer> prevElementsIndex = new Stack<>();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int currentElement = inputList.get(i);
            nextGreatest[i] = i;

            while (!prevElements.empty()) {
                ++counter;
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

        log.info("StackImplementation:: {}\n", counter);
        return Arrays.asList(nextGreatest);
    }

    public static void main(String[] args) {
        List<Integer> inputList1 = List.of(10, 8, 11, 9, 5, 24, 19, 18, 17, 16, 17, 25);
        List<Integer> inputList2 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> inputList3 = IntStream.rangeClosed(1, 10).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<Integer> inputList = inputList3;
        log.info("InputList   :: " + inputList);
        log.info("OutputList  :: " + new PreviousGreaterElementIndex().prevMax1(inputList));
        log.info("OutputList  :: " + new PreviousGreaterElementIndex().prevMax2(inputList));
    }
}
