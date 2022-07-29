package com.practice.problems.adityavermapractice.binarysearch.impl.tap;

import com.practice.problems.adityavermapractice.binarysearch.NumberOfTimesSortedArrayIsRotated;

public class NumberOfTimesSortedArrayIsRotatedTap extends NumberOfTimesSortedArrayIsRotated {
    @Override
    public Integer rotationCount(Integer[] nums) {
        //return rotationCount1(nums);
        return rotationCount2(nums);
    }

    public Integer rotationCount1(Integer[] nums) {
        int start = 0;
        int end =  nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid - 1] >= nums[mid] && nums[mid] <= nums[mid + 1]) return mid;
            else if(nums[mid] <= nums[end]) end = mid - 1;
            else if(nums[mid] >= nums[start]) start = mid + 1;
        }

        return -1;
    }

    public Integer rotationCount2(Integer[] nums) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;

        if(nums[0] <= nums[length - 1]) return 0;

        int mid = start + (end - start) / 2;
        while (start < end) {
            if (nums[0] <= nums[mid]) start = mid + 1;  /* MID is smaller than FIRST */
            else end = mid;

            mid = start + (end - start) / 2;
        }
        return start;
    }




}
