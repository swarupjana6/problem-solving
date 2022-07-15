package com.practice.problems.google.impl.tap;

import com.practice.problems.google.LetterCombinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsTap extends LetterCombinations {
    @Override
    protected List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return List.of();
        List<String> result = new ArrayList<>();
        letterCombinations(digits, result, "", 0);
        return result;
    }

    Map<Character, String> digitToChars = Map.of('2', "abc"
            , '3', "def"
            , '4', "ghi"
            , '5', "jkl"
            , '6', "mno"
            , '7', "pqrs"
            , '8', "tuv"
            , '9', "wxyz");

    private void letterCombinations(String digits, List<String> result, String current, int index) {
        //BASE CONDITION
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        //HYPOTHESIS & INDUCTION
        String letter = digitToChars.get(digits.charAt(index));
        for (char ch : letter.toCharArray())
            letterCombinations(digits, result, current + ch, index + 1);
    }
}
