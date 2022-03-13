package com.practice.problems.slidingwindow;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class FirstNegativeIntegerInEveryWindowSize {

    public static void main(String[] args) {
        List<Integer> input = List.of(12, -1, -7, 8, -15, 30, 16, 28);
        int window = 3;

        log.info("Input::\t {}", input);
        log.info("Output::\t {}", slidingWindow(input, window));
    }

    private static List<Integer> slidingWindow(List<Integer> input, int window) {
        List<Integer> output = new ArrayList<>();
        List<Integer> negativeElements = new ArrayList<>();
        int startWindow = 0;
        int endWindow = 0;

        while (endWindow < input.size()) {
            int currentElement = input.get(endWindow);
            int currentWindow = endWindow - startWindow + 1;

            /* STEP 1:: CALCULATION of the question asked, to be used for further steps */
            if (currentElement < 0) negativeElements.add(endWindow);

            if (currentWindow < window) endWindow++;    /* STEP 2:: Window size not reached, increment endWindow */
            else if (currentWindow == window) {         /* STEP 3:: Window size REACHED **/

                /* STEP 4:: Get ANSWER from previous CALCULATION */
                if (negativeElements.size() == 0) {
                    output.add(0);  /* EDGE case **/
                } else {
                    output.add(negativeElements.get(0));
                    if (startWindow == negativeElements.get(0)) negativeElements.remove(0);
                }

                /* STEP 5:: Move the Window, increment startWindow and endWindow */
                startWindow++;
                endWindow++;
            }
        }

        return output;
    }

    private static List<Integer> mayur(List<Integer> input, int window) {
        List<Integer> negativeElements = new ArrayList<>();
        int startWindow = 0;
        int endWindow = 0;

        while (endWindow < input.size()) {
            int currentElement = input.get(endWindow);
            int currentWindow = endWindow - startWindow + 1;

            if (currentElement < 0 || currentWindow == window) {
                negativeElements.add(endWindow);
                startWindow++;
                endWindow++;
            }

            endWindow++;
        }

        return negativeElements;
    }
}
