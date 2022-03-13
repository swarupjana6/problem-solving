package com.practice.problems.slidingwindow;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class MaximumSubArrayOfSizeK {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        log.info(slidingWindow(input, 3));
    }

    private static Integer slidingWindow(List<Integer> input, int windowSize) {
        int max = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;

        while (windowEnd < input.size()) {
            int currentElement = input.get(windowEnd);
            int currentWindow = windowEnd - windowStart + 1;

            /* STEP 1:: CALCULATION of the question asked, to be used for further steps */
            sum += currentElement;

            if (currentWindow < windowSize) windowEnd++;  /* STEP 2:: Window size not reached, increment endWindow */
            else if (currentWindow == windowSize) {       /* STEP 3:: Window size REACHED */

                /* STEP 4:: Get ANSWER from previous CALCULATION **/
                max = Math.max(sum, max);
                sum -= input.get(windowStart);

                /* STEP 5:: Move the Window, increment startWindow and endWindow */
                windowStart++;
                windowEnd++;
            }
        }

        return max;
    }
}
