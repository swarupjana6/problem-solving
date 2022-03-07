package com.practice.problems.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


public class NearestSmallerOrGreater {

    /*
     * nearestGreatest and nearestSmallest returns the index list
     * if we are unable to find then -1
     *
     * */
    public static final String LOG_STR = "\n%s %s\n I/P \t\t:: %s \n O/P Index \t:: %s \n O/P \t\t:: %s \n-------";

    private static void greatest(List<Integer> inputList, Stack<Integer> indexStack, List<Integer> outputList, int i, int pseudoIndex) {
        int resultIndex = i;
        int current = inputList.get(i);

        if (indexStack.isEmpty()) resultIndex = pseudoIndex;
        else if (inputList.get(indexStack.peek()) > current) resultIndex = indexStack.peek();
        else if (inputList.get(indexStack.peek()) <= current) {
            while (!indexStack.isEmpty() && inputList.get(indexStack.peek()) <= current) indexStack.pop();

            if (indexStack.isEmpty()) resultIndex = -1;
            else resultIndex = indexStack.peek();
        }

        indexStack.push(i);
        outputList.add(resultIndex);
    }

    private static void smallest(List<Integer> inputList, Stack<Integer> indexStack, List<Integer> outputList, int i, int pseudoIndex) {
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

    public static List<Integer> nearestGreatest(List<Integer> inputList, boolean isToLeft) {
        return nearestGreatest(inputList, isToLeft, -1);
    }

    public static List<Integer> nearestGreatest(List<Integer> inputList, boolean isToLeft, int pseudoIndex) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        if (isToLeft) {
            for (int i = 0; i <= inputList.size() - 1; i++)
                greatest(inputList, indexStack, outputList, i, pseudoIndex);
        } else {
            for (int i = inputList.size() - 1; i >= 0; i--)
                greatest(inputList, indexStack, outputList, i, pseudoIndex);
            Collections.reverse(outputList);
        }

        return outputList;
    }

    public static List<Integer> nearestSmallest(List<Integer> inputList, boolean isToLeft) {
        return nearestSmallest(inputList, isToLeft, -1);
    }

    public static List<Integer> nearestSmallest(List<Integer> inputList, boolean isToLeft, int pseudoIndex) {
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        if (isToLeft) {
            for (int i = 0; i <= inputList.size() - 1; i++)
                smallest(inputList, indexStack, outputList, i, pseudoIndex);
        } else {
            for (int i = inputList.size() - 1; i >= 0; i--)
                smallest(inputList, indexStack, outputList, i, pseudoIndex);

            Collections.reverse(outputList);
        }

        return outputList;
    }

    private static List<Integer> nearestGreaterToLeft(List<Integer> inputList) {
        List<Integer> outputList = nearestGreatest(inputList, true);
        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from left2right >>>>>>", inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestGreaterToRight(List<Integer> inputList) {
        List<Integer> outputList = nearestGreatest(inputList, false);
        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from right2left <<<<<<<", inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestSmallerToLeft(List<Integer> inputList) {
        List<Integer> outputList = nearestSmallest(inputList, true);
        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), " 'i' moving from left2right >>>>>>", inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestSmallerToRight(List<Integer> inputList) {
        List<Integer> outputList = nearestSmallest(inputList, false);
        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from right2left <<<<<<<", inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    public static void main(String[] args) {
        //call(Arrays.asList(1, 3, 2, 4));
        //call(Arrays.asList(1, 3, 0, 0, 1, 2, 4));
        call(Arrays.asList(4, 5, 2, 10, 8));
        //call(Arrays.asList(10, 8, 11, 9, 5, 24, 19, 18, 17, 16, 17, 25));
        //call(IntStream.rangeClosed(1, 10).boxed().collect(toList()));
        //call(IntStream.rangeClosed(1, 10).boxed().sorted(Collections.reverseOrder()).collect(toList()));
    }

    private static void call(List<Integer> inputList) {
        nearestGreaterToRight(inputList);
        nearestGreaterToLeft(inputList);
        nearestSmallerToRight(inputList);
        nearestSmallerToLeft(inputList);
    }
}
