package com.practice.problems.adityavermapractice.dynamicprog.mcm.impl.tap;

import com.google.common.primitives.Ints;
import com.practice.problems.adityavermapractice.dynamicprog.mcm.MatrixChainMultiplication;

import java.util.List;

public class MatrixChainMultiplicationRecursiveTap extends MatrixChainMultiplication {

    private int[][] cached;

    @Override
    protected Integer recursiveMCM(List<Integer> inputList) {
        return recursiveMCM(Ints.toArray(inputList), 1, inputList.size() - 1);
    }

    @Override
    protected Integer memoizedMCM(List<Integer> inputList) {
        this.cached = new int[Ints.toArray(inputList).length + 1][Ints.toArray(inputList).length + 1];
        int xBound = cached[0].length;
        int yBound = cached.length;
        for (int y = 0; y < yBound; y++) for (int x = 0; x < xBound; x++) this.cached[x][y] = -1;
        return memoizedMCM(Ints.toArray(inputList), 1, inputList.size() - 1);
    }

    private Integer recursiveMCM(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int minPartitions = Integer.MAX_VALUE;

        for (int mid = low; mid < high; mid++) {
            int currentPartitions = arr[low - 1] * arr[mid] * arr[high];
            int minLeftPartitions = recursiveMCM(arr, low, mid);
            int minRightPartitions = recursiveMCM(arr, mid + 1, high);

            int totalPartition = minLeftPartitions + currentPartitions + minRightPartitions;
            minPartitions = Math.min(minPartitions, totalPartition);
        }

        return minPartitions;
    }

    private Integer memoizedMCM(int[] arr, int low, int high) {
        if (low >= high) return 0;
        if (cached[low][high] != -1) return cached[low][high];

        int minPartitions = Integer.MAX_VALUE;
        for (int mid = low; mid < high; mid++) {
            int currentPartitions = arr[low - 1] * arr[mid] * arr[high];
            int minLeftPartitions = memoizedMCM(arr, low, mid);
            int minRightPartitions = memoizedMCM(arr, mid + 1, high);

            int totalPartitions = minLeftPartitions + currentPartitions + minRightPartitions;
            minPartitions = Math.min(minPartitions, totalPartitions);
        }

        return cached[low][high] = minPartitions;
    }
}
