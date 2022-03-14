package com.practice.problems.slidingwindow;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Log4j2
public class MaximumOfAllSubArraysOfSizeK {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, -1, -3, 5, 3, 6, 7);
        log.info("Input:: {}", input);
        log.info("Output:: {}", slidingWindow(input, 3));
    }

    private static List<Integer> slidingWindow(List<Integer> input, int windowSize) {
        List<Integer> maxs = new ArrayList<>();
        int windowStart = 0;
        int windowEnd = 0;
        Queue<Integer> maxQueue = new LinkedList<>();

        while (windowEnd < input.size()) {
            int currentElement = input.get(windowEnd);
            int currentWindow = windowEnd - windowStart + 1;

            /* STEP 1:: CALCULATION of the question asked, to be used for further steps */
            while (maxQueue.size() > 0 && currentElement > maxQueue.peek()) maxQueue.remove();
            maxQueue.offer(currentElement);

            if (currentWindow < windowSize) windowEnd++;  /* STEP 2:: Window size not reached, increment endWindow */
            else if (currentWindow == windowSize) {       /* STEP 3:: Window size REACHED */
                log.debug("max:{}   window:{}\tMaxQueue:{}", maxQueue.peek(), Arrays.copyOfRange(input.toArray(), windowStart, windowEnd + 1), maxQueue);

                /* STEP 4:: Get ANSWER from previous CALCULATION **/
                maxs.add(maxQueue.peek());
                if (maxQueue.peek() == input.get(windowStart)) maxQueue.remove();

                /* STEP 5:: Move the Window, increment startWindow and endWindow */
                windowStart++;
                windowEnd++;
            }
        }

        return maxs;
    }
}
