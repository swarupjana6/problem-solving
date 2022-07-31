package com.practice.problems.adityavermapractice.binarysearch.impl.tap;

import com.practice.problems.adityavermapractice.binarysearch.SearchInRowWiseAndColumnWise;

import java.util.List;

public class SearchInRowWiseAndColumnWiseTap extends SearchInRowWiseAndColumnWise {
    @Override
    public List<Integer> findElement(int[][] nums, int search) {
        int length = nums[0].length;
        int breadth = nums.length;
        int start = 0;
        int end = length - 1;

        while (start >= 0 && start < breadth && end >= 0 && end < length) {
            if(nums[start][end] == search) return List.of(start, end);
            else if(nums[start][end] > search) end--;
            else if(nums[start][end] < search) start++;
        }

        return List.of(-1,-1);
    }
}
