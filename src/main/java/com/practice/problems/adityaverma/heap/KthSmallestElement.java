package com.practice.problems.adityaverma.heap;

import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 **/

@Log4j2
public class KthSmallestElement {

    public static void main(String[] args) {
        List<Integer> input = List.of(7, 10, 4, 3, 20, 15);
        int K = 3;
        log.info("Input: {}", input);
        log.info("Output: {}", sortMaxHeap(input, K));
    }

    /**>>>>>>>>>>> MAX HEAP since smallest will be at the bottom after 'K' removal<<<<<<<<<<<<<**/
    private static Integer sortMaxHeap(List<Integer> input, int k) {
        Comparator maxTop = Comparator.reverseOrder();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxTop);

        for (int i = 0; i < input.size(); i++) {
            maxHeap.add(input.get(i));
            if (maxHeap.size() > k) maxHeap.remove();
        }

        return maxHeap.peek();
    }
}
