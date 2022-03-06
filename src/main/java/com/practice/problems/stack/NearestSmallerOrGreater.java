package com.practice.problems.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NearestSmallerOrGreater {

    private static List<Integer> nearestGreatest(IntStream stream, List<Integer> inputList, String nearestLabel) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> nextGreatest = new LinkedList<>();

        stream.forEach(i -> {
            counter.incrementAndGet();
            int resultIndex = i;
            int current = inputList.get(i);

            if (indexStack.size() == 0) resultIndex = i;
            else if (inputList.get(indexStack.peek()) > current) resultIndex = i - indexStack.peek();
            else if (inputList.get(indexStack.peek()) <= current) {
                while (indexStack.size() > 0 && inputList.get(indexStack.peek()) <= current) indexStack.pop();

                if (indexStack.size() == 0) resultIndex = i;
                else resultIndex = i - indexStack.peek();
            }

            indexStack.push(i);
            nextGreatest.add(resultIndex);
        });

        System.out.format("%s\t|| Time Complexity :: %d\t|| I/P :: %s\t|| O/P :: %s \n", nearestLabel, counter.get(), inputList.toString(), nextGreatest);
        return nextGreatest;
    }

    private static List<Integer> nearestSmallest(IntStream stream, List<Integer> inputList, String nearestLabel) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Integer> indexStack = new Stack<>();
        List<Integer> nextGreatest = new LinkedList<>();

        stream.forEach(i -> {
            counter.incrementAndGet();
            int resultIndex = i;
            int current = inputList.get(i);

            if (indexStack.size() == 0) resultIndex = i;
            else if (inputList.get(indexStack.peek()) < current) resultIndex = i - indexStack.peek();
            else if (inputList.get(indexStack.peek()) >= current) {
                while (indexStack.size() > 0 && inputList.get(indexStack.peek()) <= current) indexStack.pop();

                if (indexStack.size() == 0) resultIndex = i;
                else resultIndex = i - indexStack.peek();
            }

            indexStack.push(i);
            nextGreatest.add(resultIndex);
        });

        System.out.format("%s\t|| Time Complexity :: %d\t|| I/P :: %s\t|| O/P :: %s \n", nearestLabel, counter.get(), inputList.toString(), nextGreatest);
        return nextGreatest;
    }

    public static void main(String[] args) {
        //call(Arrays.asList(10, 8, 11, 9, 5, 24, 19, 18, 17, 16, 17, 25));
        call(IntStream.rangeClosed(1, 10).boxed().collect(toList()));
        //call(IntStream.rangeClosed(1, 10).boxed().sorted(Collections.reverseOrder()).collect(toList()));
    }

    private static void call(List<Integer> inputList) {
        List<Integer> reverseList = new ArrayList<>(inputList);
        Collections.reverse(reverseList);

        nearestGreatest(IntStream.rangeClosed(0, inputList.size() - 1), new ArrayList<>(inputList), "nearestGreaterToLeft");
        nearestGreatest(IntStream.rangeClosed(0, inputList.size() - 1), reverseList, "nearestGreaterToRight");
        nearestSmallest(IntStream.rangeClosed(0, inputList.size() - 1), new ArrayList<>(inputList), "nearestSmallerToLeft");
        nearestSmallest(IntStream.rangeClosed(0, inputList.size() - 1), reverseList, "nearestSmallerToRight");

        System.out.println("================================");
    }
}
