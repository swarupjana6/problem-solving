package com.practice.others.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PreviousGreaterElementIndex {

    public static void prevMax(List<Integer> inputList) {
        List<Integer> outputList = new ArrayList<>();
        outputList.add(1);

        Map<Integer, List<Integer>> cache = new TreeMap<>();
        for (int i = 1; i < inputList.size(); i++) {
            Integer element = inputList.get(i);
            List<Integer> indexList = cache.get(element);
            if (indexList == null) {
                cache.put(element, List.of(i));
            } else {
                indexList.add(i);
                cache.put(element, indexList);
            }

            cache.keySet().stream();

            int j = i - 1;

            //Check if previous nums has greater element
            while (j >= 0) {
                if (inputList.get(j) > inputList.get(i)) {
                    outputList.add(i - j);
                    break;
                }
                j--;
            }
            if (j == -1) outputList.add(i + 1);
        }
    }
}
