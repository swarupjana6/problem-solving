package com.practice.problems.grokking.educative.subset;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithDuplicates {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
	    List<Integer> EMPTY_LIST = new ArrayList<>();
	    subsets.add(EMPTY_LIST);
	    
	    if(nums.length == 0){
	    	return subsets;
	    }
	    
	    for(int index = 0; index < nums.length; index++){
	    	Integer levelSize = subsets.size();
	    	int startIndex = 0;
	    	if(index > 0 && nums[index] == nums[index - 1]){
	    		startIndex = subsets.size()/2;
	    	}
	    	for(int j = startIndex; j < levelSize; j++){
	    		List<Integer> sets = new ArrayList<>(subsets.get(j));
	    		sets.add(nums[index]);
	    		subsets.add(sets);
	    	}
	    }
	    
	    return subsets;
	  }

	  public static void main(String[] args) {
	    List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
	    System.out.println(result.size() + " Here is the list of subsets: " + result);

	    result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
	    System.out.println(result.size() + " Here is the list of subsets: " + result);
	  }

}
