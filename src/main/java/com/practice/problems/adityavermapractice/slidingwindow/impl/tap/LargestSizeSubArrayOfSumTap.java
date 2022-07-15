package com.practice.problems.adityavermapractice.slidingwindow.impl.tap;


import com.practice.problems.adityavermapractice.slidingwindow.LargestSizeSubArrayOfSum;

import java.util.List;
import java.util.stream.IntStream;

public class LargestSizeSubArrayOfSumTap extends LargestSizeSubArrayOfSum {
    @Override
    public Long largestSizeSubArrayOfSum(List<Integer> numbers, Integer sum) {
        return solution1(numbers, sum);
    }

    private Long solution1(List<Integer> nums, Integer sum) {
        Integer[] numbers = nums.toArray(new Integer[0]);
        int windowStart = 0;
        int windowEnd = 0;
        long answer = 0;
        long currentSum = 0;
        while (windowEnd < numbers.length) {
            int currentElement = numbers[windowEnd];
            int currentWindow = windowEnd - windowStart + 1;

            currentSum += currentElement;

            if (currentSum == sum) answer = Math.max(currentWindow, answer);
            else {
                while (currentSum > sum) currentSum -= numbers[windowStart++];
                currentWindow = windowEnd - windowStart + 1;
                if (currentSum == sum) answer = Math.max(currentWindow, answer);
            }

            windowEnd++;
        }

        return answer;
    }

    private void log(Integer[] numbers, int windowStart, int windowEnd) {
        IntStream.rangeClosed(windowStart, windowEnd).mapToObj(index -> numbers[index]).forEach(s -> System.out.print(s + " "));
        System.out.println("----");
    }
}
