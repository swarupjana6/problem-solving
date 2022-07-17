package com.practice.problems.adityavermapractice.binarysearch.impl.tap;

import com.practice.problems.adityavermapractice.binarysearch.MaximumElementInBitonicArray;

public class MaximumElementInBitonicArrayTap extends MaximumElementInBitonicArray {
    @Override
    public Integer findMaxElement(int[] nums) {
        return new PeakElementTap().indexOfPeak(nums);
    }
}
