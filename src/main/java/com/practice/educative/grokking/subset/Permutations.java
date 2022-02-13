package com.practice.educative.grokking.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> findPermutations(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    result.add(new ArrayList<>());
	    if(nums.length < 1){
	    	result.add(new ArrayList<>(Arrays.asList(nums[0])));
	    	return result;
	    }
	    
	    for (Integer num : nums) {
			int levelSize = result.size();
			for (List<Integer> list : result) {
				
			}
		}
	    
	    
	    return result;
	  }

	  public static void main(String[] args) {
	    List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
	    System.out.print("Here are all the permutations: " + result);
	  }

}
