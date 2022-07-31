package com.practice.problems.google.impl.tap;

import com.practice.problems.google.ShortestWayToFormString;

public class ShortestWayToFormStringTap extends ShortestWayToFormString {
    @Override
    protected Integer shortestWay(String source, String target) {
        Integer subSequencesCount = 0;
        int sourceIndex = 0;
        int targetIndex = 0;

        while (targetIndex < target.length() && sourceIndex < source.length()) {

            if(source.charAt(sourceIndex) == target.charAt(targetIndex++)) {
                sourceIndex++;
            }
        }


        return subSequencesCount;
    }
}
