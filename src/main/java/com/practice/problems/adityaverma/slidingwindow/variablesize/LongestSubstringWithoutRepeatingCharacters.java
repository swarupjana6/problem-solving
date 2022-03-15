package com.practice.problems.adityaverma.slidingwindow.variablesize;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String input1 = "pwwkew";
        String input2 = "aabacbbbebe";
        String input = input1;
        log.info("Input:    {}", input.toCharArray());
        log.info("Output:   {}", slidingWindow(input.toCharArray()));
    }

    private static int slidingWindow(char[] input) {
        int answer = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int uniqueChar = 0;
        Map<Character, Integer> windowElements = new HashMap<>();

        /** Condition:: # of unique characters in a sliding window **/

        while (windowEnd < input.length) {
            char currentElement = input[windowEnd];
            int currentWindowSize = windowEnd - windowStart + 1;

            windowElements.merge(currentElement, 1, Integer::sum);
            uniqueChar = windowElements.size();

            if (currentWindowSize == uniqueChar) {
                answer = Math.max(answer, windowEnd - windowStart + 1);
                ++windowEnd;
            } else if (currentWindowSize > uniqueChar) {

                while (currentWindowSize > uniqueChar) {
                    char startElement = input[windowStart];
                    windowElements.merge(startElement, -1, Integer::sum);
                    if (windowElements.get(startElement) == 0) windowElements.remove(startElement);
                    windowStart++;
                    currentWindowSize--;
                }
                windowEnd++;
            }
        }

        return answer;
    }
}
