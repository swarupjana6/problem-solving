package com.practice.problems.slidingwindow.fixedsize;

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
        log.info("Input:{} , Pattern:{}", input.toCharArray(), pattern.toCharArray());
        log.info("Output:{}", slidingWindow(input.toCharArray(), pattern));
    }

    private static Integer slidingWindow(char[] inputChars, String pattern) {
        Integer answer = 0;
        Integer window = pattern.length();
        Map<Character, Integer> charCounts = calculateCharCounts(pattern);
        int count = charCounts.size();

        int windowStart = 0;
        int windowEnd = 0;
        AtomicInteger currentCount = new AtomicInteger(count);
        while (windowEnd < inputChars.length) {
            char currentElement = inputChars[windowEnd];
            int currentWindow = windowEnd - windowStart + 1;

            /* STEP 1:: CALCULATION of the question asked, to be used for further steps */
            charCounts.computeIfPresent(currentElement, (k, v) -> {
                if (v == 1) currentCount.getAndDecrement();
                return v - 1;
            });


            if (currentWindow < window) windowEnd++;      /* STEP 2:: Window size not reached, increment endWindow */
            else if (currentWindow == window) {     /* STEP 3:: Window size REACHED **/

                log.debug("{} {}", Arrays.copyOfRange(inputChars, windowStart, windowEnd + 1), (currentCount.get() == 0));

                /* STEP 4:: Get ANSWER from previous CALCULATION */
                if (currentCount.get() == 0) answer++;
                charCounts.computeIfPresent(inputChars[windowStart], (k, v) -> {
                    if (v == 0) currentCount.getAndIncrement();
                    return v + 1;
                });

                /* STEP 5:: Move the Window, increment startWindow and endWindow */
                windowStart++;
                windowEnd++;
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
