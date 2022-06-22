package com.practice.problems.adityavermapractice.dynamicprog.mcm.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.mcm.ScrambledString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ScrambledStringTap extends ScrambledString {

    private Map<String, Boolean> cached = new HashMap<>();

    @Override
    protected Boolean memoizedMCM(String original, String scrambled) {
        if (original == null && scrambled == null) return true;
        if (original == null && scrambled != null || original != null && scrambled == null) return false;
        if (original.equals(scrambled)) return true;
        if (original.length() != scrambled.length()) return false;
        if (original.length() <= 1) return false;
        String key = original + "~" + scrambled;
        if (cached.containsKey(key)) return cached.get(key);

        int length = original.length();
        boolean isScrambled = false;

        for (int part = 1; part < length; part++) {
            boolean swapped = stringSwapped(original, scrambled, length, part, (org, scm) -> memoizedMCM(org, scm));
            boolean notSwapped = stringNotSwapped(original, scrambled, length, part, (org, scm) -> memoizedMCM(org, scm));
            if (swapped || notSwapped) return true;
        }

        cached.put(key, isScrambled);
        return isScrambled;
    }

    @Override
    protected Boolean recursiveMCM(String original, String scrambled) {
        if (original == null && scrambled == null) return true;
        if (original == null && scrambled != null || original != null && scrambled == null) return false;
        if (original.equals(scrambled)) return true;
        if (original.length() != scrambled.length()) return false;
        if (original.length() <= 1) return false;

        int length = original.length();
        boolean isScrambled = false;

        for (int part = 1; part < length; part++) {
            boolean swapped = stringSwapped(original, scrambled, length, part, (org, scm) -> recursiveMCM(org, scm));
            boolean notSwapped = stringNotSwapped(original, scrambled, length, part, (org, scm) -> recursiveMCM(org, scm));
            if (swapped || notSwapped) return true;
        }

        return isScrambled;
    }

    private boolean stringSwapped(String original, String scrambled, int length, int part, BiFunction<String, String, Boolean> isScrambled) {
        String orgLeft = original.substring(0, part);
        String orgRight = original.substring(part, length);
        String scramLeft = scrambled.substring(0, length - part);
        String scramRight = scrambled.substring(length - part, length);

        boolean isLeftScrambled = isScrambled.apply(orgLeft, scramRight);
        boolean isRightScrambled = isScrambled.apply(orgRight, scramLeft);
        return (isLeftScrambled && isRightScrambled);
    }

    private boolean stringNotSwapped(String original, String scrambled, int lastIndex, int part, BiFunction<String, String, Boolean> isScrambled) {
        String orgLeft = original.substring(0, part);
        String orgRight = original.substring(part, lastIndex);
        String scramLeft = scrambled.substring(0, part);
        String scramRight = scrambled.substring(part, lastIndex);

        boolean isLeftScrambled = isScrambled.apply(orgLeft, scramLeft);
        boolean isRightScrambled = isScrambled.apply(orgRight, scramRight);
        return (isLeftScrambled && isRightScrambled);
    }
}
