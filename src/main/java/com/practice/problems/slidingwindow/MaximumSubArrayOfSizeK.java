package com.practice.problems.slidingwindow;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class MaximumSubArrayOfSizeK {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        log.info(slidingWindow(input, 3));
    }

    private static Integer slidingWindow(List<Integer> input, int window) {
        Integer max = 0;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < input.size()) {
            int currentElement = input.get(end);
            sum += currentElement;

            int currentWindow = end - start + 1;

            if (currentWindow < window) end++;
            else if (currentWindow == window) {
                max = Math.max(sum, max);
                sum -= input.get(start);
                start++;
                end++;
            }
        }

        return max;
    }
}
