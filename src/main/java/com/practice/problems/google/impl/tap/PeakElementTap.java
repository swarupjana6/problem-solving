package com.practice.problems.google.impl.tap;

import com.practice.problems.google.PeakElement;

public class PeakElementTap extends PeakElement {

    @Override
    protected Integer peak(Integer[] nums) {
        int size = nums.length;
        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < size - 1) {
                int prev = (mid - 1 + size) % size;
                int next = (mid + 1) % size;

                if (nums[prev] <= nums[mid] && nums[mid] >= nums[next]) return mid;
                else if (nums[mid] <= nums[next]) start = mid + 1;
                else if (nums[mid] <= nums[prev]) end = mid - 1;
                continue;
            }

            if (mid == 0) {
                return (nums[mid] > nums[mid + 1]) ? mid : mid + 1;
            }

            if (mid == size - 1) {
                return (nums[mid] > nums[mid - 1]) ? mid : mid - 1;
            }
        }
        return -1;
    }
}
