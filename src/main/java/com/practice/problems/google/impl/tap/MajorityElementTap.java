package com.practice.problems.google.impl.tap;

import com.practice.problems.google.MajorityElement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MajorityElementTap extends MajorityElement {

    @Override
    protected int majority(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> frequency = new HashMap<>();
        AtomicInteger maxCount = new AtomicInteger();
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            frequency.compute(num, (key, val) -> {
                if (val == null) return 1;

                if (++val > maxCount.get()) {
                    maxCount.set(val);
                    max.set(key);
                }
                return val;
            });

            if (maxCount.get() > nums.length / 2) return max.get();
        }
        return max.get();
    }

    protected int majority1(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            if (frequency.containsKey(num) && frequency.get(num) + 1 > nums.length / 2) return num;
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        return -1;
    }
}
