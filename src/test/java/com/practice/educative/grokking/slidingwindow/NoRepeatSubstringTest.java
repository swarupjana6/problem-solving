package com.practice.educative.grokking.slidingwindow;

import com.practice.educative.grokking.slidingwindow.impl.jan.NoRepeatSubstringJana;
import com.practice.educative.grokking.slidingwindow.impl.tap.NoRepeatSubstringTap;
import org.junit.jupiter.api.Test;

class NoRepeatSubstringTest {

    @Test
    void findLengthJana() {
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringJana().findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringJana().findLength("abbbb"));
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringJana().findLength("abccde"));
    }

    @Test
    void findLengthTapan() {
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringTap().findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringTap().findLength("abbbb"));
        System.out.println("Length of the longest substring: " + new NoRepeatSubstringTap().findLength("abccde"));
    }
}