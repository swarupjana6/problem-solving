package com.practice;

import java.util.Arrays;

public class RandomPickWeight {

    private int[] cumulative;

    private int sum;

    public RandomPickWeight(int[] wts) {
        int total = 0;
        cumulative = new int[wts.length];

        for (int i = 0; i < wts.length; i++) {
            total += wts[i];
            cumulative[i] = total;
        }
        System.out.println(Arrays.toString(wts));
        System.out.println(Arrays.toString(cumulative));
        sum = total;
    }

    public int pickIndex() {
        int random = 1 + (int) Math.random() * sum;
        return binarySearch(random);
    }

    public int binarySearch(int random) {
        int start = 0, end = cumulative.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (cumulative[mid] < random)
                start = mid + 1;
            else
                end = mid;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 14, 1, 7};
        System.out.println(new RandomPickWeight(nums).pickIndex());
    }
}
