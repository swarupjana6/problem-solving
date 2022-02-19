package com.practice.educative.grokking.slidingwindow;

import com.practice.educative.grokking.slidingwindow.impl.jan.NoRepeatSubstringJana;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NoRepeatSubstringTest {


    @DisplayName("Test NoRepeatSubstring.findLength()")
    @Test
    public static void findLengthJana() {
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringJana().findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringJana().findLength("abbbb"));
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringJana().findLength("abccde"));
    }
}