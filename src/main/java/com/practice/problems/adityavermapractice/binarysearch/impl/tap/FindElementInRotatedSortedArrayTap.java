package com.practice.problems.adityavermapractice.binarysearch.impl.tap;

import com.practice.problems.adityavermapractice.binarysearch.FindElementInRotatedSortedArray;

public class FindElementInRotatedSortedArrayTap extends FindElementInRotatedSortedArray {

    @Override
    public Integer rotationCount(Integer[] nums, int target) {
        int pivot = getPivot(nums);

        int start = 0;
        int end = pivot - 1;
        int result = binarySearch(nums, start, end, target);
        if (result == -1) {
            start = pivot;
            end = nums.length - 1;
            result = binarySearch(nums, start, end, target);
        }

        return result;
    }

    private int binarySearch(Integer[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;        /* LESS OPTIMIZED --> (start + end) / 2; */

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }

    private int getPivot(Integer[] nums) {
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

    private int getPivot1(Integer[] nums) {
        int size = nums.length;
        int start = 0;
        int end = size - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = ((mid - 1) + size) % size;
            int next = (mid + 1) % size;

            if (nums[prev] >= nums[mid] && nums[mid] <= nums[next]) return mid; /* Mid is smaller than prev & next */
            else if (nums[mid] <= nums[end]) end = mid - 1;         /* SECOND Half is SORTED hence Move after Mid */
            else if (nums[start] <= nums[mid]) start = mid + 1;     /* FIRST Half is SORTED hence Move before Mid */
        }

        return -1;
    }
}
