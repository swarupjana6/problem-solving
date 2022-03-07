package com.practice.problems.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class NearestSmallerOrGreater {

    /*
     * nearestGreatest and nearestSmallest returns the index list
     * if we are unable to find then -1
     *
     * */
    public static final String LOG_STR = "\n%s %s\n Time Complexity :: %d \n I/P \t\t:: %s \n O/P Index \t:: %s \n O/P \t\t:: %s \n-------";

    private static void nearestGreatest(int i, List<Integer> inputList, Stack<Integer> indexStack, List<Integer> outputList, AtomicInteger counter) {
        counter.incrementAndGet();
        int resultIndex = i;
        int current = inputList.get(i);

        if (indexStack.isEmpty()) resultIndex = -1;
        else if (inputList.get(indexStack.peek()) > current) resultIndex = indexStack.peek();
        else if (inputList.get(indexStack.peek()) <= current) {
            while (!indexStack.isEmpty() && inputList.get(indexStack.peek()) <= current) indexStack.pop();

            if (indexStack.isEmpty()) resultIndex = -1;
            else resultIndex = indexStack.peek();
        }

        indexStack.push(i);
        outputList.add(resultIndex);
    }

    private static void nearestSmallest(int i, List<Integer> inputList, Stack<Integer> indexStack, List<Integer> outputList, AtomicInteger counter) {
        counter.incrementAndGet();
        int resultIndex = i;
        int current = inputList.get(i);

        if (indexStack.isEmpty()) resultIndex = -1;
        else if (inputList.get(indexStack.peek()) < current) resultIndex = indexStack.peek();
        else if (inputList.get(indexStack.peek()) >= current) {
            while (!indexStack.isEmpty() && inputList.get(indexStack.peek()) >= current) indexStack.pop();

            if (indexStack.isEmpty()) resultIndex = -1;
            else resultIndex = indexStack.peek();
        }

        indexStack.push(i);
        outputList.add(resultIndex);
    }

    private static List<Integer> nearestGreaterToLeft(List<Integer> inputList) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = 0; i <= inputList.size() - 1; i++)
            nearestGreatest(i, inputList, indexStack, outputList, counter);

        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from left2right >>>>>>", counter.get(), inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestGreaterToRight(List<Integer> inputList) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = inputList.size() - 1; i >= 0; i--)
            nearestGreatest(i, inputList, indexStack, outputList, counter);

        Collections.reverse(outputList);
        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from right2left <<<<<<<", counter.get(), inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestSmallerToLeft(List<Integer> inputList) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = 0; i <= inputList.size() - 1; i++)
            nearestSmallest(i, inputList, indexStack, outputList, counter);

        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), " 'i' moving from left2right >>>>>>", counter.get(), inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestSmallerToRight(List<Integer> inputList) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        for (int i = inputList.size() - 1; i >= 0; i--)
            nearestSmallest(i, inputList, indexStack, outputList, counter);

        Collections.reverse(outputList);
        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from right2left <<<<<<<", counter.get(), inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
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
        nearestGreaterToRight(inputList);
        nearestGreaterToLeft(inputList);
        nearestSmallerToRight(inputList);
        nearestSmallerToLeft(inputList);
        //nearestGreatest(new ArrayList<>(inputList), "nearestGreaterToLeft", false);
        //nearestSmallest(IntStream.rangeClosed(0, inputList.size() - 1), new ArrayList<>(inputList), "nearestSmallerToLeft");
        //nearestSmallest(IntStream.rangeClosed(0, inputList.size() - 1), inputList, "nearestSmallerToRight");

        System.out.println("================================");
    }
}
