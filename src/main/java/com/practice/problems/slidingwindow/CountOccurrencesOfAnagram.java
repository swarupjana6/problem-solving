package com.practice.problems.slidingwindow;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class CountOccurrencesOfAnagram {

    public static void main(String[] args) {
        String input = "aabaabaa";
        String pattern = "aaba";
        log.info(slidingWindow(input.toCharArray(), pattern));
    }

    private static Integer slidingWindow(char[] inputChars, String pattern) {
        Integer answer = 0;
        Integer window = pattern.length();
        Map<Character, Integer> charCounts = calculateCharCounts(pattern);
        int count = charCounts.size();

        int start = 0;
        int end = 0;
        AtomicInteger currentCount = new AtomicInteger(count);
        while (end < inputChars.length) {
            char currentElement = inputChars[end];
            int currentWindow = end - start + 1;

            // CALCULATION
            charCounts.computeIfPresent(currentElement, (k, v) -> {
                if (v == 1) currentCount.getAndDecrement();
                return v - 1;
            });


            if (currentWindow < window) end++;
            else if (currentWindow == window) {
                log.debug("{} {}", Arrays.copyOfRange(inputChars, start, end + 1), (currentCount.get() == 0));

                //ANSWER
                if (currentCount.get() == 0) answer++;

                // OPERATION for the start element since we are moving the window from the start
                charCounts.computeIfPresent(inputChars[start], (k, v) -> {
                    if (v == 0) currentCount.getAndIncrement();
                    return v + 1;
                });
                start++;
                end++;
            }
        }

        return answer;
    }

    private static Map<Character, Integer> calculateCharCounts(String pattern) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char ch : pattern.toCharArray()) charCounts.merge(ch, 1, Integer::sum);
        return charCounts;
    }
}
