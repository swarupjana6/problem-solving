/**
 * 
 */
package com.example.practice.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SKJ-PC
 * 
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * 
 * Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] nums, int target) {
		
		List<Integer> result = new ArrayList<>();
		List inputContainer = Arrays.asList(result);
		for (Object num : inputContainer) {
			int reminder = target - (Integer)num;
			if(inputContainer.contains(reminder)) {
				return new int [] {(int)num, reminder};
			}
		}
		return new int[] {};
    }

}
