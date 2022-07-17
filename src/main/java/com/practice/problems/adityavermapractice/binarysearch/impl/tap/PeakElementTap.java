package com.practice.problems.adityavermapractice.binarysearch.impl.tap;

import com.practice.problems.adityavermapractice.binarysearch.PeakElement;

public class PeakElementTap extends PeakElement {
    @Override
    public Integer indexOfPeak(int[] nums) {
        int size = nums.length;
        int start = 0;
        int end = size - 1;

        while (end >- start) {
            int mid = start + (end - start)/2;

            if (mid > 0 && mid < size - 1) {
                if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
                else if(nums[mid - 1] > nums[mid]) end = mid - 1;
                else if(nums[mid + 1] > nums[mid]) start = mid + 1;
            } else if(mid == 0) {
                if(nums[mid] > nums[mid + 1]) return mid;
                else return mid + 1;
            } else if(mid == size - 1) {
                if(nums[mid] > nums[mid - 1]) return mid;
                else return mid - 1;
            }
        }
        return -1;
    }
}
