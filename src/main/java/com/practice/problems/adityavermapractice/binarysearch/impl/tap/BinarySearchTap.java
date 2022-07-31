package com.practice.problems.adityavermapractice.binarysearch.impl.tap;

import com.practice.problems.adityavermapractice.binarysearch.BinarySearch;

public class BinarySearchTap extends BinarySearch {

    @Override
    public Integer search(int[] nums, int search) {
        int start = 0;
        int end = nums.length - 1;
        return search(nums, search, start, end);
    }

    public int search(int[] nums, int search, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (nums[mid] == search) return mid;
            else if (nums[mid] < search) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
