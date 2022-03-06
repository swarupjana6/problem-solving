package com.practice.problems.grokking.educative.subset;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> findSubsets(int[] nums) {
	    List<List<Integer>> subsets = new ArrayList<>();
	    List<Integer> EMPTY_LIST = new ArrayList<>();
	    subsets.add(EMPTY_LIST);
	    
	    if(nums.length == 0){
	    	return subsets;
	    }
	    
	    for(int index = 0; index < nums.length; index++){
	    	Integer levelSize = subsets.size();
	    	for(int j = 0; j < levelSize; j++){
	    		List<Integer> sets = new ArrayList<>(subsets.get(j));
	    		sets.add(nums[index]);
		    	subsets.add(sets);
	    	}
	    }
	    
	    return subsets;
	  }

	  public static void main(String[] args) {
	    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
	    System.out.println("Here is the list of subsets: " + result);

	    result = Subsets.findSubsets(new int[] { 1, 5, 3 });
	    System.out.println("Here is the list of subsets: " + result);
	    
	    result = Subsets.findSubsets(new int[] { 1, 5, 3, 7, 9 });
	    System.out.println("Here is the list of subsets: " + result);
	  }

}
