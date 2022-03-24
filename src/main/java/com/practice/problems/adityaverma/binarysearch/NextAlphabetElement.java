package com.practice.problems.adityaverma.binarysearch;

import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Given a characters array letters that is sorted in non-decreasing order and a character target,
 * return the smallest character in the array that is larger than target.
 * <p>
 * Note that the letters wrap around.
 * <p>
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 * <p>
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * <p>
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * <p>
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 **/

@Log4j2
public class NextAlphabetElement {

    public static void main(String[] args) {
        List<Character> list = List.of('a', 'c', 'f', 'h');
        Character ceilOf = 'g';

        log.info("Input: {} | Search for: {}", list, ceilOf);
        log.info("Output: {} ", findCeil(list, ceilOf));
    }

    public static Character findCeil(List<Character> list, Character ceilOf) {
        Character ceil = null;
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (list.get(mid) == ceilOf) {
                start = mid + 1;
            } else if (list.get(mid) < ceilOf) {
                start = mid + 1;
            } else if (list.get(mid) > ceilOf) {
                ceil = list.get(mid);
                end = mid - 1;
            }
        }
        return ceil;
    }
}
