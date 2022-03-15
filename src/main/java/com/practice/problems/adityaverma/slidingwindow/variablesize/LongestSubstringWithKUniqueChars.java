package com.practice.problems.adityaverma.slidingwindow.variablesize;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

/**
 * Pick Toy
 * <p>
 * Given a string you need to print longest possible substring that has exactly M unique characters.
 * If there are more than one substring of longest possible length, then print any one of them.
 * <p>
 * "aabbcc", k = 1
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 * <p>
 * "aabbcc", k = 2
 * Max substring can be any one from {"aabb" , "bbcc"}.
 * <p>
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 * <p>
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message.
 **/

@Log4j2
public class LongestSubstringWithKUniqueChars {

    public static void main(String[] args) {
        String input = "aabacbebebe";
        int uniqueChar = 3;
        log.info("Input:{} , uniqueChar:{}", input.toCharArray(), uniqueChar);
        log.info("Output:{}", slidingWindow(input.toCharArray(), uniqueChar));
    }

    private static int slidingWindow(char[] input, int uniqueChar) {
        int answer = 0;
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> windowElements = new HashMap<>();

        /** Condition:: # of unique characters in a sliding window **/

        while (windowEnd < input.length) {
            char currentElement = input[windowEnd];

            windowElements.merge(currentElement, 1, Integer::sum);

            if (windowElements.size() < uniqueChar) {
                windowEnd++;
            } else if (windowElements.size() == uniqueChar) {
                answer = Math.max(answer, windowEnd - windowStart + 1);
                ++windowEnd;
            } else if (windowElements.size() > uniqueChar) {

                while (windowElements.size() > uniqueChar) {
                    char startElement = input[windowStart];
                    windowElements.merge(startElement, -1, Integer::sum);
                    if (windowElements.get(startElement) == 0) windowElements.remove(startElement);
                    windowStart++;
                }
                windowEnd++;
            }
        }

        return answer;
    }
}
