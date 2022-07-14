package com.practice.problems.adityavermapractice.slidingwindow.impl.tap;

import com.practice.problems.adityavermapractice.slidingwindow.FirstNegativeNumberInEveryWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNumberInEveryWindowTapan extends FirstNegativeNumberInEveryWindow {
    @Override
    protected List<Integer> firstNegativeNumberInEveryWindow(List<Integer> inputList, Integer window) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> negativesIndices = new LinkedList<>();

        int currWindowStart = 0;
        int currWindowEnd = 0;
        while (currWindowEnd < inputList.size()) {
            int windowEndElement = inputList.get(currWindowEnd);
            int currentWindow = currWindowEnd - currWindowStart + 1;

            if (windowEndElement < 0) negativesIndices.add(currWindowEnd);

            if (currentWindow == window) {
                if (negativesIndices.size() == 0) {
                    result.add(0);
                } else {
                    int negativeIndex = negativesIndices.peek();
                    if (negativeIndex == currWindowStart) negativesIndices.poll();
                    result.add(inputList.get(negativeIndex));
                }
                currWindowEnd++;
                currWindowStart++;
            } else {
                currWindowEnd++;
            }
        }
        return result;
    }
}
