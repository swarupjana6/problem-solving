package com.practice.problems.google.impl.tap;

import com.practice.problems.google.ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateTap extends ContainsDuplicate {
    @Override
    protected boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int num : nums) {
            if (uniqueNums.contains(num)) return true;
            else uniqueNums.add(num);
        }
        return false;
    }
}
