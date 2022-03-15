package com.practice.problems.adityaverma.slidingwindow.variablesize;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
public class MinimumWindowSubString {

    public static void main(String[] args) {
        String input1 = "timetopractice";
        String pattern1 = "toc";
        String input2 = "TOTMTAPTAT";
        String pattern2 = "TTA";

        String input = input2;
        String pattern = pattern2;
        Integer output = slidingWindow(input.toCharArray(), pattern.toCharArray());
        log.info("Input:    {}, Pattern:    {}", input.toCharArray(), pattern);
        log.info("Output:   {}", output);
    }

    private static int slidingWindow(char[] input, char[] pattern) {
        Integer answer = null;
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> patternMap = getPatternMap(pattern);
        AtomicInteger patternMapSize = new AtomicInteger(patternMap.size());

        while (windowEnd < input.length) {
            char currentElement = input[windowEnd];
            char[] currentWindow = Arrays.copyOfRange(input, windowStart, windowEnd + 1);

            patternMap.computeIfPresent(currentElement, (k, v) -> {
                if (v == 1) patternMapSize.decrementAndGet();
                return v - 1;
            });
            log.debug("{} {} {}", currentElement, currentWindow, (patternMapSize.get()));

            if (patternMapSize.get() > 0) {
                windowEnd++;
            } else if (patternMapSize.get() == 0) {

                while (patternMapSize.get() == 0) {
                    patternMap.computeIfPresent(input[windowStart], (k, v) -> {
                        if (v == 0) patternMapSize.incrementAndGet();
                        return v + 1;
                    });

                    windowStart++;
                }
                int currentWindowSize = windowEnd - windowStart + 1;
                answer = answer == null ? currentWindowSize : Math.min(currentWindowSize + 1, answer);

                //log.debug("{} | {} {} | {} {}", answer, windowStart, windowEnd, (patternMapSize.get()), Arrays.copyOfRange(input, windowStart - 1, windowEnd + 1));

                windowEnd++;
            }
        }

        return answer;
    }

    private static Map<Character, Integer> getPatternMap(char[] pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char ch : pattern) patternMap.merge(ch, 1, Integer::sum);
        return patternMap;
    }
}
