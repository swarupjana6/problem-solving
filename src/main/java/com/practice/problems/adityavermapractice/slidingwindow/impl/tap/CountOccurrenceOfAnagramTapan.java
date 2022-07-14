package com.practice.problems.adityavermapractice.slidingwindow.impl.tap;

import com.practice.problems.adityavermapractice.slidingwindow.CountOccurrenceOfAnagram;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CountOccurrenceOfAnagramTapan extends CountOccurrenceOfAnagram {
    protected Integer anagramCount(String inputString, String pattern) {
        Integer answer = 0;
        char[] inputChars = inputString.toCharArray();
        Map<Character, Integer> charCounts = countChars(pattern);

        int windowStart = 0;
        int windowEnd = 0;
        AtomicInteger currentCount = new AtomicInteger(charCounts.size());
        while (windowEnd < inputChars.length) {
            int windowSize = windowEnd - windowStart + 1;

            charCounts.computeIfPresent(inputChars[windowEnd], (k, v) -> {
                if (v == 1) currentCount.getAndDecrement();
                return v - 1;
            });

            if (windowSize == pattern.length()) {

                if (currentCount.get() == 0) answer++;

                // INCREMENT because we are moving the start pointer forwards
                charCounts.computeIfPresent(inputChars[windowStart], (k, v) -> {
                    if (v == 0) currentCount.getAndIncrement();
                    return v + 1;
                });

                windowStart++;
            }

            windowEnd++;
        }

        return answer;
    }

    private Map<Character, Integer> countChars(String pattern) {
        Map<Character, Integer> charCounts = new HashMap<>();
        char[] chars = pattern.toCharArray();
        for (char ch : chars) {
            if (!charCounts.containsKey(ch)) charCounts.put(ch, 1);
            else charCounts.computeIfPresent(ch, (key, count) -> count + 1);
        }
        return charCounts;
    }
}
