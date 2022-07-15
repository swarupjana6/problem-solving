package com.practice.problems.google.impl.tap;

import com.practice.problems.google.BackspaceStringCompare;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompareTap extends BackspaceStringCompare {

    protected boolean compare1(String first, String second) {
        Deque<Character> firstResult = new ArrayDeque<>();
        Deque<Character> secondResult = new ArrayDeque<>();

        for (char ch : first.toCharArray()) operate(ch, firstResult);
        for (char ch : second.toCharArray()) operate(ch, secondResult);

        if (firstResult.size() != secondResult.size())
            return false;

        while (!firstResult.isEmpty()) if (firstResult.pop() != secondResult.pop())
            return false;

        return true;
    }
    @Override
    public boolean compare(String first, String second) {
        Deque<Character> firstResult = new ArrayDeque<>();
        Deque<Character> secondResult = new ArrayDeque<>();

        boolean firstBig = true;
        int minSize = 0;
        if (first.length() < second.length()) {
            minSize = first.length();
            firstBig = false;
        } else {
            minSize = second.length();
        }

        for (int i = 0; i < minSize; i++) {
            operate(first.charAt(i), firstResult);
            operate(second.charAt(i), secondResult);
        }

        if (firstBig) {
            for (int i = minSize; i < first.length(); i++)
                operate(first.charAt(i), firstResult);
        } else {
            for (int i = minSize; i < second.length(); i++)
                operate(second.charAt(i), secondResult);
        }

        if (firstResult.size() != secondResult.size())
            return false;

        while (!firstResult.isEmpty())
            if (firstResult.pop() != secondResult.pop())
                return false;

        return true;
    }

    private void operate(char ch, Deque<Character> resultStack) {
        if (ch == '#') {
            if (!resultStack.isEmpty()) resultStack.pop();
        }
        else resultStack.push(ch);
    }
}
