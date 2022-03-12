package com.practice.problems.slidingwindow;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class FirstNegativeIntegerInEveryWindowSize {

    public static void main(String[] args) {
        List<Integer> input = List.of(12, -1, -7, 8, -15, 30, 16, 28);
        log.info(slidingWindow(input, 3));
    }

    private static List<Integer> slidingWindow(List<Integer> input, int window) {
        List<Integer> firstNegatives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int start = 0;
        int end = 0;

        while (end < input.size()) {
            int currentElement = input.get(end);
            int currentWindow = end - start + 1;

            if (currentElement < 0) negatives.add(end);

            if (currentWindow < window) end++;
            else if (currentWindow == window) {
                if (negatives.size() > 0) {
                    firstNegatives.add(input.get(negatives.get(0)));
                    if (start == negatives.get(0)) negatives.remove(0);
                } else {
                    firstNegatives.add(0);
                }
                start++;
                end++;
            }
        }

        return firstNegatives;
    }
}
