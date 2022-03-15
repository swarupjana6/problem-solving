package com.practice.problems.adityaverma.stack;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@Log4j2
public class NearestSmallerOrGreater {

    /*
     * nearestGreatest and nearestSmallest returns the index list
     * if we are unable to find then -1
     *
     * */
    public static final String LOG_STR = "{} {}\n I/P List \t\t\t:: {} \n O/P Indexes \t\t:: {} \n O/P Elements \t\t:: {} \n-------\n";

    public static List<Integer> nearestGreaterToLeft(List<Integer> inputList, int pseudoIndex) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = 0; i <= inputList.size() - 1; i++) {
            int resultIndex = i;
            int current = inputList.get(i);

            if (indexStack.isEmpty()) resultIndex = pseudoIndex;
            else if (inputList.get(indexStack.peek()) > current) resultIndex = indexStack.peek();
            else {
                while (!indexStack.isEmpty() && inputList.get(indexStack.peek()) <= current) indexStack.pop();

                if (indexStack.isEmpty()) resultIndex = -1;
                else resultIndex = indexStack.peek();
            }

            indexStack.push(i);
            outputList.add(resultIndex);
        }

        String outputStr = outputList.stream().map(i -> i != -1 && i < outputList.size() ? inputList.get(i) : i).collect(Collectors.toList()).toString();
        log.debug(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from left2right >>>>>>", inputList, outputList, outputStr);
        return outputList;
    }

    public static List<Integer> nearestGreaterToRight(List<Integer> inputList, int pseudoIndex) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = inputList.size() - 1; i >= 0; i--) {
            int resultIndex = i;
            int current = inputList.get(i);

            if (indexStack.isEmpty()) resultIndex = pseudoIndex;
            else if (inputList.get(indexStack.peek()) > current) resultIndex = indexStack.peek();
            else {
                while (!indexStack.isEmpty() && inputList.get(indexStack.peek()) <= current) indexStack.pop();

                if (indexStack.isEmpty()) resultIndex = -1;
                else resultIndex = indexStack.peek();
            }

            indexStack.push(i);
            outputList.add(resultIndex);
        }

        Collections.reverse(outputList);

        String outputStr = outputList.stream().map(i -> i != -1 && i < outputList.size() ? inputList.get(i) : i).collect(Collectors.toList()).toString();
        log.debug(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from right2left <<<<<<<", inputList, outputList, outputStr);
        return outputList;
    }

    public static List<Integer> nearestSmallerToLeft(List<Integer> inputList, int pseudoIndex) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = 0; i <= inputList.size() - 1; i++) {
            int resultIndex = i;
            int current = inputList.get(i);

            if (indexStack.isEmpty()) resultIndex = pseudoIndex;
            else if (inputList.get(indexStack.peek()) < current) resultIndex = indexStack.peek();
            else {
                while (!indexStack.isEmpty() && inputList.get(indexStack.peek()) >= current) indexStack.pop();

                if (indexStack.isEmpty()) resultIndex = -1;
                else resultIndex = indexStack.peek();
            }

            indexStack.push(i);
            outputList.add(resultIndex);
        }

        String outputStr = outputList.stream().map(i -> i != -1 && i < outputList.size() ? inputList.get(i) : i).collect(Collectors.toList()).toString();
        log.debug(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), " 'i' moving from left2right >>>>>>", inputList, outputList, outputStr);
        return outputList;
    }

    public static List<Integer> nearestSmallerToRight(List<Integer> inputList, int pseudoIndex) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = inputList.size() - 1; i >= 0; i--) {
            int resultIndex = i;
            int current = inputList.get(i);

            if (indexStack.isEmpty()) resultIndex = pseudoIndex;
            else if (inputList.get(indexStack.peek()) < current) resultIndex = indexStack.peek();
            else if (inputList.get(indexStack.peek()) >= current) {
                while (!indexStack.isEmpty() && inputList.get(indexStack.peek()) >= current) indexStack.pop();

                if (indexStack.isEmpty()) resultIndex = -1;
                else resultIndex = indexStack.peek();
            }

            indexStack.push(i);
            outputList.add(resultIndex);
        }

        Collections.reverse(outputList);

        String outputStr = outputList.stream().map(i -> i != -1 && i < outputList.size() ? inputList.get(i) : i).collect(Collectors.toList()).toString();
        log.debug(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from right2left <<<<<<<", inputList, outputList, outputStr);
        return outputList;
    }

    public static void main(String[] args) {
        call(Arrays.asList(1, 3, 2, 4));
        //call(Arrays.asList(1, 3, 0, 0, 1, 2, 4));
        //call(Arrays.asList(4, 5, 2, 10, 8));
        //call(Arrays.asList(10, 8, 11, 9, 5, 24, 19, 18, 17, 16, 17, 25));
        //call(IntStream.rangeClosed(1, 10).boxed().collect(toList()));
        //call(IntStream.rangeClosed(1, 10).boxed().sorted(Collections.reverseOrder()).collect(toList()));
    }

    private static void call(List<Integer> inputList) {
        nearestGreaterToRight(inputList, -1);
        nearestGreaterToLeft(inputList, -1);
        nearestSmallerToRight(inputList, -1);
        nearestSmallerToLeft(inputList, -1);
    }
}
