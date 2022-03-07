package com.practice.problems.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    public static Map<String, Object> nearestGreatest(List<Integer> inputList, boolean isToLeft) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        if (isToLeft)
            for (int i = 0; i <= inputList.size() - 1; i++) greatest(inputList, counter, indexStack, outputList, i);
        else for (int i = inputList.size() - 1; i >= 0; i--) greatest(inputList, counter, indexStack, outputList, i);

        return Map.of("OUTPUT", outputList, "COUNTER", counter.get());
    }

    private static void greatest(List<Integer> inputList, AtomicInteger counter, Stack<Integer> indexStack, List<Integer> outputList, int i) {
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

    public static Map<String, Object> nearestSmallest(List<Integer> inputList, boolean isToLeft) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> outputList = new LinkedList<>();

        if (isToLeft)
            for (int i = 0; i <= inputList.size() - 1; i++) smallest(inputList, counter, indexStack, outputList, i);
        else for (int i = inputList.size() - 1; i >= 0; i--) smallest(inputList, counter, indexStack, outputList, i);

        return Map.of("OUTPUT", outputList, "COUNTER", counter.get());
    }

    private static void smallest(List<Integer> inputList, AtomicInteger counter, Stack<Integer> indexStack, List<Integer> outputList, int i) {
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
        Map<String, Object> outputMap = nearestGreatest(inputList, true);
        Integer counter = (Integer) outputMap.get("COUNTER");
        List<Integer> outputList = (List<Integer>) outputMap.get("OUTPUT");
        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from left2right >>>>>>", counter, inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestGreaterToRight(List<Integer> inputList) {
        Map<String, Object> outputMap = nearestGreatest(inputList, false);
        Integer counter = (Integer) outputMap.get("COUNTER");
        List<Integer> outputList = (List<Integer>) outputMap.get("OUTPUT");

        Collections.reverse(outputList);

        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from right2left <<<<<<<", counter, inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestSmallerToLeft(List<Integer> inputList) {
        Map<String, Object> outputMap = nearestSmallest(inputList, true);
        Integer counter = (Integer) outputMap.get("COUNTER");
        List<Integer> outputList = (List<Integer>) outputMap.get("OUTPUT");

        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), " 'i' moving from left2right >>>>>>", counter, inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
        return outputList;
    }

    private static List<Integer> nearestSmallerToRight(List<Integer> inputList) {
        Map<String, Object> outputMap = nearestSmallest(inputList, false);
        Integer counter = (Integer) outputMap.get("COUNTER");
        List<Integer> outputList = (List<Integer>) outputMap.get("OUTPUT");

        Collections.reverse(outputList);
        System.out.format(LOG_STR, new Exception().getStackTrace()[0].getMethodName(), "'i' moving from right2left <<<<<<<", counter, inputList, outputList, outputList.stream().map(i -> i != -1 ? inputList.get(i) : i).collect(Collectors.toList()));
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
        //nearestGreaterToRight(inputList);
        //nearestGreaterToLeft(inputList);
        nearestSmallerToRight(inputList);
        nearestSmallerToLeft(inputList);
    }
}
