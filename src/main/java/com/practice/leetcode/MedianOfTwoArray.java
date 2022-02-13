package com.practice.leetcode;

import java.util.Arrays;

public class MedianOfTwoArray {

	public static double medianOfTwoArray(int [] nums1, int [] nums2){
		
		double median = 0;
		int [] arrays = new int[nums1.length + nums2.length];
		System.arraycopy(nums1, 0, arrays, 0, nums1.length);
		System.arraycopy(nums2, 0, arrays, nums1.length, nums2.length);
		Arrays.sort(arrays);
		
		if(arrays.length == 1){
			return arrays[0];
		} else if((arrays.length - 1) % 2 == 0){
			return arrays[(arrays.length - 1)/2];
		} else {
			int pos = arrays.length/2;
			
			median = (arrays[pos - 1] + arrays[pos])/2.0;
			
		}
		
		return median;
	}
	
	public static void main(String[] args) {


		System.out.println(medianOfTwoArray(new int [] {1,2}, new int [] {3,4}));

	}

}
