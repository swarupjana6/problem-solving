package com.practice.educative.grokking.slidingwindow;

import com.practice.educative.grokking.slidingwindow.impl.tap.MaxFruitCountOf2TypesTap;
import org.junit.jupiter.api.Test;

class MaxFruitCountOf2TypesTest {

    @Test
    public static void findLengthTapan() {
        System.out.println("Length of the longest substring: " + new MaxFruitCountOf2TypesTap().findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Length of the longest substring: " + new MaxFruitCountOf2TypesTap().findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}