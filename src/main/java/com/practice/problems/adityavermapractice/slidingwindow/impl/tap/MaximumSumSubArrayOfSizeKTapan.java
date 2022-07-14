package com.practice.problems.adityavermapractice.slidingwindow.impl.tap;

import com.practice.problems.adityavermapractice.slidingwindow.MaximumSumSubArrayOfSizeK;

import java.util.List;

public class MaximumSumSubArrayOfSizeKTapan extends MaximumSumSubArrayOfSizeK {
    @Override
    protected Integer maximumSumSubArrayOfSizeK(List<Integer> input, Integer windowSize) {
        int answer = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;

        while (windowEnd < input.size()) {
            int currentElement = input.get(windowEnd);
            int currentWindow = windowEnd - windowStart + 1;

            sum += currentElement;

            if (currentWindow < windowSize) windowEnd++;
            else if (currentWindow == windowSize) {

                answer = Math.max(sum, answer);
                sum -= input.get(windowStart);

                windowStart++;
                windowEnd++;
            }
        }

        return answer;
    }
}
