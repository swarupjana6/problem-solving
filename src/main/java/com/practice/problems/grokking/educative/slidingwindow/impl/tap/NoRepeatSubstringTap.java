package com.practice.problems.grokking.educative.slidingwindow.impl.tap;

import com.practice.problems.grokking.educative.slidingwindow.NoRepeatSubstring;

public class NoRepeatSubstringTap implements NoRepeatSubstring {
    @Override
    public int findLength(String str) {
        char[] chars = str.toCharArray();
        int maxCnt = 0; int count = 0;
        for(int i = 0; i < chars.length-1; i++) {
            count++;
            if(chars[i] == chars[i+1]) {
                if(count > maxCnt) {
                    maxCnt = count;
                    count = 0;
                }
            }
        }
        return maxCnt;
    }
}
