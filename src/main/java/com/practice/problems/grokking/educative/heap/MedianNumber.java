package com.practice.problems.grokking.educative.heap;

import java.util.PriorityQueue;

public class MedianNumber {
	
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
	PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
	
	public void insertNum(Integer num) {

		if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		} else if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		}
	}
	
	public Double findMedian() {
		
		int twoHeapSize = maxHeap.size() + minHeap.size();
		Double medianNumber = Double.valueOf(0);
		
		if (twoHeapSize  % 2 == 0) {
			medianNumber = (maxHeap.peek() + minHeap.peek())/2.0;
		} else {
			medianNumber = maxHeap.peek()/1.0;
		}
		return medianNumber;
	}

	public static void main(String[] args) {

		MedianNumber medianNumber = new MedianNumber();
		medianNumber.insertNum(3);
		medianNumber.insertNum(1);
		System.out.println("The median is: " + medianNumber.findMedian());
		medianNumber.insertNum(5);
		System.out.println("The median is: " + medianNumber.findMedian());
		medianNumber.insertNum(4);
		System.out.println("The median is: " + medianNumber.findMedian());
	}

}
