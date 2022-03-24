package com.practice.problems.adityaverma.heap;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 * Return the sorted array.
 * <p>
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * <p>
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * <p>
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 **/

@Log4j2
public class FrequencySort {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 1, 1, 3, 2, 2, 4, 3, 3, 3, 3);
        log.info("Input: {}", input);
        log.info("Output: {}", sortMaxHeap(input));
    }

    /**
     * MAX HEAP is required since more frequent element at the top
     **/
    private static List<Integer> sortMaxHeap(List<Integer> input) {
        Map<Integer, Integer> frequencyMap = getFrequencyMap(input);
        log.info("Frequency map: {}", frequencyMap);
        Comparator maxTop = Comparator.reverseOrder();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(maxTop);

        for (Map.Entry entry : frequencyMap.entrySet()) maxHeap.add(getPair(entry));

        List<Integer> answer = new ArrayList<>();
        while (maxHeap.size() > 0) answer.add(maxHeap.remove().getValue());
        return answer;
    }

    private static Map<Integer, Integer> getFrequencyMap(List<Integer> input) {
        return input.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }

    private static Pair getPair(Map.Entry<Integer, Integer> entry) {
        return new Pair(entry.getValue(), entry.getKey());
    }
}
