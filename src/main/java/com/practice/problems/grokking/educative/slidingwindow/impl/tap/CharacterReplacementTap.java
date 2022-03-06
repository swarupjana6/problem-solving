package com.practice.problems.grokking.educative.slidingwindow.impl.tap;

import com.practice.problems.grokking.educative.slidingwindow.CharacterReplacement;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacementTap implements CharacterReplacement {

    @Override
    public int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatCharCnt = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatCharCnt = Math.max(maxRepeatCharCnt, charFreqMap.get(rightChar));

            // Non repeating char count = window size - repeating char cnt
            int nonRepeatingCharCnt = (windowEnd - windowStart + 1) - maxRepeatCharCnt;
            if (nonRepeatingCharCnt > k) {
                char leftChar = str.charAt(windowStart);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                windowStart++;
            }
        }

        return maxLength;
    }
}
