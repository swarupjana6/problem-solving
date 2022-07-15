package com.practice.problems.google.impl.tap;

import com.practice.problems.google.ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIITap extends ContainsDuplicateII {
    @Override
    protected boolean containsDuplicateII(int[] nums, int k) {
        Map<Integer, Integer> numIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(numIndex.containsKey(nums[i]) && i - numIndex.get(nums[i]) <= k) return true;

            numIndex.put(nums[i], i);
        }
        return false;
    }
}
