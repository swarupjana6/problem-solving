package com.practice.problems.adityavermapractice.slidingwindow.impl.tap;

import com.practice.problems.adityavermapractice.slidingwindow.LongestSubstringWithKUniqueCharacters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharactersTapan extends LongestSubstringWithKUniqueCharacters {
    @Override
    protected Integer LongestStringWithUniqueChars(String input, Integer count) {
        char[] inputArr = input.toCharArray();
        int answer = 0;
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> windowChars = new HashMap<>();

        while (windowEnd < inputArr.length) {
            char currentElement = inputArr[windowEnd];
            int currentWindow = windowEnd - windowStart + 1;

            windowChars.merge(currentElement, 1, Integer::sum);

            if (windowChars.size() == count) answer = Math.max(currentWindow, answer);
            else if (windowChars.size() > count) {
                while (windowChars.size() > count) {
                    windowChars.merge(inputArr[windowStart], -1, Integer::sum);
                    if (windowChars.get(inputArr[windowStart]) == 0) windowChars.remove(inputArr[windowStart]);
                    windowStart++;
                }
            }

            windowEnd++;
        }

        return answer;
    }
}
