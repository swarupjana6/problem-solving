package com.practice.problems.adityavermapractice.binarysearch.impl.tap;


import com.practice.problems.adityavermapractice.binarysearch.SearchElementInBitonicArray;

public class SearchElementInBitonicArrayTap extends SearchElementInBitonicArray {
    @Override
    public Integer findElement(int[] nums, int element) {
        int indexPeak = new PeakElementTap().indexOfPeak(nums);

        int firstHalf = new BinarySearchTap().search(nums, element, 0, indexPeak);
        if(firstHalf != -1)
            return firstHalf;

        int secondHalf = -1;
        if(indexPeak < nums.length - 1)
            secondHalf = new BinarySearchTap().search(nums, element, indexPeak + 1, nums.length - 1);

        return secondHalf;
    }
}
