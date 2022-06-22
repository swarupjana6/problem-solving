package com.practice.problems.adityavermapractice.dynamicprog.mcm.impl.tap;

import com.practice.problems.adityavermapractice.dynamicprog.mcm.PalindromePartitioning;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PalindromePartitioningTap extends PalindromePartitioning {

    private int[][] cached;

    @Override
    protected Integer recursiveMCM(char[] inputArr) {
        return recursiveMCM(inputArr, 0, inputArr.length - 1);
    }

    @Override
    protected Integer memoizedMCM(char[] inputArr) {
        this.cached = new int[inputArr.length + 1][inputArr.length + 1];
        int xBound = cached[0].length;
        int yBound = cached.length;
        for (int y = 0; y < yBound; y++) for (int x = 0; x < xBound; x++) this.cached[x][y] = -1;
        return memoizedMCM(inputArr, 0, inputArr.length - 1);
    }

    private Integer recursiveMCM(char[] arr, int low, int high) {
        if (low >= high) return 0;
        if (isPalindrome(arr, low, high)) return 0;

        int minimumPart = Integer.MAX_VALUE;
        for (int mid = low; mid < high; mid++) {
            int minimumPartCurrent = 1;
            int minimumPartForLeft = recursiveMCM(arr, low, mid);
            int minimumPartForRight = recursiveMCM(arr, mid + 1, high);

            int totalMinimumPart = minimumPartForLeft + minimumPartCurrent + minimumPartForRight;
            minimumPart = Math.min(minimumPart, totalMinimumPart);
        }
        return minimumPart;
    }

    private Integer memoizedMCM(char[] arr, int low, int high) {
        if (low >= high) return 0;
        if (cached[low][high] != -1) return cached[low][high];
        if (isPalindrome(arr, low, high)) return 0;

        int minimumPart = Integer.MAX_VALUE;
        int minimumPartCurrent;
        int minimumPartForLeft;
        int minimumPartForRight;
        for (int mid = low; mid < high; mid++) {
            minimumPartCurrent = 1;

            if (cached[low][mid] != -1) minimumPartForLeft = cached[low][mid];
            else minimumPartForLeft = cached[low][mid] = recursiveMCM(arr, low, mid);

            if (cached[mid + 1][high] != -1) minimumPartForRight = cached[mid + 1][high];
            else minimumPartForRight = cached[mid + 1][high] = recursiveMCM(arr, mid + 1, high);

            int totalMinimumPart = minimumPartForLeft + minimumPartCurrent + minimumPartForRight;
            minimumPart = Math.min(minimumPart, totalMinimumPart);
        }
        return cached[low][high] = minimumPart;
    }

    private boolean isPalindrome(char[] arr, int low, int high) {
        while (low <= high) if (arr[low++] != arr[high--]) return false;
        return true;
    }
}
