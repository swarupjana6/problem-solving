package com.practice.problems.google.impl.tap;

import com.practice.problems.google.FindTheDifference;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifferenceTap extends FindTheDifference {
    @Override
    protected Character difference(String first, String second) {
        Map<Character, Integer> freqency = new HashMap<>();

        for (char ch : first.toCharArray()) freqency.merge(ch, 1, Integer::sum);
        for (char ch : second.toCharArray()) {
            if (freqency.containsKey(ch) && freqency.get(ch) == 0 || !freqency.containsKey(ch)) return ch;

            freqency.merge(ch, -1, Integer::sum);
        }

        return '!';
    }
}
