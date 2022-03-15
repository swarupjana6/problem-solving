package com.practice.problems.adityaverma.slidingwindow.fixedsize;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 * <p>
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 * <p>
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 * Explanation:
 * Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e from index 1 to 4) is 10, So the sequence
 * generated is 10 10 10 15 15 90 90
 **/

@Log4j2
public class MaximumOfAllSubArraysOfSizeK {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, -1, -3, 5, 3, 6, 7);
        log.info("Input:: {}", input);
        log.info("Output:: {}", slidingWindow(input, 3));
    }

    private static List<Integer> slidingWindow(List<Integer> input, int windowSize) {
        List<Integer> answer = new ArrayList<>();
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
                answer.add(maxQueue.peek());
                if (maxQueue.peek() == input.get(windowStart)) maxQueue.remove();

                /* STEP 5:: Move the Window, increment startWindow and endWindow */
                windowStart++;
                windowEnd++;
            }
        }

        return answer;
    }
}
