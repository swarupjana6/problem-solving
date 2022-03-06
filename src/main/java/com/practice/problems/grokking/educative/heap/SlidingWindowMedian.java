package com.practice.problems.grokking.educative.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
	PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

	public static void main(String[] args) {
		SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
		double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
		System.out.println();

		slidingWindowMedian = new SlidingWindowMedian();
		result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");

	}

	private double[] findSlidingWindowMedian(int[] nums, int k) {

		List<Double> result = new ArrayList<>();

		for (int index = 0; index < nums.length; index++) {

			if (maxHeap.isEmpty() || maxHeap.peek() >= nums[index]) {
				maxHeap.add(nums[index]);
			} else {
				minHeap.add(nums[index]);
			}

			rebalanceHeap();

			if (maxHeap.size() + minHeap.size() == k) {
				result.add(findMedian(maxHeap, minHeap));

				if (maxHeap.peek() >= nums[index - k + 1]) {
					maxHeap.remove(nums[index - k + 1]);
				} else {
					minHeap.remove(nums[index - k + 1]);
				}
				rebalanceHeap();
			}

		}

		return result.stream().mapToDouble(m -> m).toArray();
	}

	public Double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {

		int twoHeapSize = maxHeap.size() + minHeap.size();
		Double medianNumber = Double.valueOf(0);

		if (twoHeapSize % 2 == 0) {
			medianNumber = (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			medianNumber = maxHeap.peek() / 1.0;
		}
		return medianNumber;
	}
	
	private void rebalanceHeap() {
		if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		} else if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		}
	}

}
