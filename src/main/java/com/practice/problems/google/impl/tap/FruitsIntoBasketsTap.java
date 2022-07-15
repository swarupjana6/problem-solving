package com.practice.problems.google.impl.tap;

import com.practice.problems.google.FruitIntoBaskets;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasketsTap extends FruitIntoBaskets {
    @Override
    protected Integer totalFruits(int[] fruits, int count) {
        int maxCount = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int currentWindow = 0;
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        while (windowEnd < fruits.length) {
            int currentFruit = fruits[windowEnd];
            currentWindow = windowEnd - windowStart + 1;

            frequencyCount.merge(currentFruit, 1, Integer::sum);

            if(frequencyCount.size() == count) maxCount = Math.max(currentWindow, maxCount);
            else if(frequencyCount.size() > count) {
                while (frequencyCount.size() > count) {
                    int removeFruit = fruits[windowStart];
                    frequencyCount.merge(removeFruit, -1, Integer::sum);
                    if(frequencyCount.get(removeFruit) == 0) frequencyCount.remove(removeFruit);
                    windowStart++;
                }
            }

            if(frequencyCount.size() < count) maxCount = currentWindow;

            windowEnd++;
        }

        return maxCount;
    }
}
