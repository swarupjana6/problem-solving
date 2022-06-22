package com.practice.problems.adityavermapractice.heap.impl.tap;

import com.practice.problems.adityavermapractice.heap.SumOfElementBetweenK1K2;

import java.util.List;

public class SumOfElementBetweenK1K2Tapan extends SumOfElementBetweenK1K2 {

    @Override
    protected Integer sumOfElementsBetween(List<Integer> numbers, Integer k1, Integer k2) {
        final int k1Element = new KthSmallestElementTapan().kthSmallest(numbers, k1);
        final int k2Element = new KthSmallestElementTapan().kthSmallest(numbers, k2);
        int sum = numbers.stream().filter(element -> element > k1Element && element < k2Element).reduce(0, Integer::sum);
        return sum;
    }
}
