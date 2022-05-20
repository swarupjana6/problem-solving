package com.practice.problems.adityaverma.slidingwindow.variablesize;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 **/

@Log4j2
public class LargestSubArrayOfSumK {

    public static void main(String[] args) {
        List<Integer> input = List.of(4, 1, 1, 1, 2, 3, 5);
        int sum = 5;
        log.info("Input:{} , Sum:{}", input, sum);
        log.info("Output:{}", slidingWindow(input, sum));
    }

    public static Integer slidingWindow(List<Integer> input, int sum) {
        int answer = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int currentSum = 0;

        while (windowEnd < input.size()) {
            int currentElement = input.get(windowEnd);
            int currentWindow = windowEnd - windowStart + 1;

            /* STEP 1:: CALCULATION of the question asked, to be used for further steps */
            currentSum += currentElement;

            if (currentSum == sum) {                   /* STEP 3:: Window CONDITION reached !!!!! */
                /* STEP 4:: Get ANSWER from previous CALCULATION */
                answer = Math.max(currentWindow, answer);
            } else if (currentSum > sum) {                  /* STEP 4:: Window CONDITION not reached, increment windowStart && endWindow */
                while (currentSum > sum) currentSum -= input.get(windowStart++);
            } /* STEP 2:: Window CONDITION not reached, increment endWindow */

            windowEnd++;
        }

        return answer;
    }
}
