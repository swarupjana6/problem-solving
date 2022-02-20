package com.practice.educative.grokking.slidingwindow.impl.tap;

import com.practice.educative.grokking.slidingwindow.MaxFruitCountOf2Types;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2TypesTap implements MaxFruitCountOf2Types {
    @Override
    public int findLength(char[] arr) {
        System.out.println("===============");
        Map<Character, Integer> countsMap = new HashMap<>();
        for(char character : arr) countsMap.put(character, countsMap.getOrDefault(character, 0) + 1);

        int firstMax = 0;
        int secondMax = 0;
        for(char ch : countsMap.keySet()) {
            System.out.println(countsMap.get(ch));
            if(firstMax < countsMap.get(ch)) firstMax = countsMap.get(ch);
            else if (secondMax < countsMap.get(ch)) secondMax = countsMap.get(ch);
        }
        return firstMax+secondMax;
    }
}
