package com.practice.problems.amex;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Set1 {

    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }

    public static int[] productExceptSelf(int[] nums) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        List<Character> single = counts.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());

        int[] leftProducts = new int[nums.length];
        leftProducts[0] = nums[0];

        int[] rightProducts = new int[nums.length];
        rightProducts[nums.length - 1] = nums[nums.length - 1];

        int limit = nums.length - 1;
        int i = 1;
        for (i = 1; i < limit; i++) {
            leftProducts[i] = nums[i] * leftProducts[i - 1];
            rightProducts[nums.length - 1 - i] = nums[nums.length - 1 - i] * rightProducts[nums.length - 1 - (i - 1)];
        }
        leftProducts[i] = nums[i] * leftProducts[i - 1];
        rightProducts[nums.length - 1 - i] = nums[nums.length - 1 - i] * rightProducts[nums.length - 1 - (i - 1)];


        int[] result = new int[nums.length];
        result[0] = rightProducts[1];
        for (i = 1; i < nums.length - 1; i++) {
            result[i] = leftProducts[i - 1] * rightProducts[i + 1];
        }
        result[nums.length - 1] = leftProducts[nums.length - 2];


        return result;
    }
}
