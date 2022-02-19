package com.practice.educative.grokking.slidingwindow;

import com.practice.educative.grokking.slidingwindow.impl.jan.CharacterReplacementJana;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterReplacementTest {

    @DisplayName("Test CharacterReplacementTest.findLength()")
    @Test
    public static void findLengthJana() {
        assertEquals(new CharacterReplacementJana().findLength("aabccbb", 2), 5);
        assertEquals(new CharacterReplacementJana().findLength("abbcb", 1), 4);
        assertEquals(new CharacterReplacementJana().findLength("abccde", 1), 0);
    }
}