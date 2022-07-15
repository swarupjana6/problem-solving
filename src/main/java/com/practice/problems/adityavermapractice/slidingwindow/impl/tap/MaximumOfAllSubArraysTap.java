package com.practice.problems.adityavermapractice.slidingwindow.impl.tap;

import com.practice.problems.adityavermapractice.slidingwindow.MaximumOfAllSubArrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumOfAllSubArraysTap extends MaximumOfAllSubArrays {

    @Override
    public List<Integer> maxOfAllSubArrays(List<Integer> inputList, Integer window) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> maxQueue = new LinkedList<>();

        int windowStart = 0;
        int windowEnd = 0;

        while (windowEnd < inputList.size()) {
            int currentElement = inputList.get(windowEnd);
            int windowSize = windowEnd - windowStart + 1;

            while (maxQueue.size() > 0 && currentElement > maxQueue.peek()) maxQueue.remove();
            maxQueue.offer(currentElement);

            if (windowSize == window) {
                result.add(maxQueue.peek());
                if (maxQueue.peek() == inputList.get(windowStart)) maxQueue.remove();
                windowStart++;
            }
            windowEnd++;
        }

        return result;
    }
}
