package com.practice.problems.adityaverma.slidingwindow.fixedsize;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Given an array of integers and a number k, find the maximum sum of a subarray of size k.
 * <p>
 * Input  : arr[] = {100, 200, 300, 400}
 * k = 2
 * Output : 700
 * <p>
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 * k = 4
 * Output : 39
 * We get maximum sum by adding subarray {4, 2, 10, 23}
 * of size 4.
 * <p>
 * Input  : arr[] = {2, 3}
 * k = 3
 * Output : Invalid
 * There is no subarray of size 3 as size of whole
 * array is 2.
 */

@Log4j2
public class MaximumSumSubArrayOfSizeK {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        log.info(slidingWindow(input, 3));
    }

    private static Integer slidingWindow(List<Integer> input, int windowSize) {
        int answer = 0;
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
                answer = Math.max(sum, answer);
                sum -= input.get(windowStart);

                /* STEP 5:: Move the Window, increment startWindow and endWindow */
                windowStart++;
                windowEnd++;
            }
        }

        return answer;
    }
}
