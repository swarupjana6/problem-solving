package com.practice.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubStringWithoutRepeat {
	
	public static int longestSubStringWithoutRepeat(String s){
		
		int slideWindow = 0;
		char[] stringArray = s.toCharArray();
		int longestStreak = 0;
		for(int index = 0; index < s.length(); index++){
			List<Character> alphabet = new ArrayList<>();		
			while(index < s.length()){
				char character = stringArray[index];
				if(alphabet.contains(character)){
					break;
				}
				alphabet.add(character);
				index++;
			}
			if(longestStreak < alphabet.size()){
				longestStreak = alphabet.size();
			}
			index=slideWindow;
			slideWindow++;
		}
		
		return longestStreak;
	}
	
	 public int lengthOfLongestSubstring(String s) {
	        
	        int slideWindow = 0;
			char[] stringArray = s.toCharArray();
			int longestStreak = 0;
			for(int index = 0; index < s.length(); index++){
				List<Character> alphabet = new ArrayList<>();
				for(int index2 = 0; index2 < s.length() - slideWindow; index2++){
					char character = stringArray[index2 + slideWindow];
					if(alphabet.contains(character)){
						break;
					}
					alphabet.add(character);
				}
				if(longestStreak < alphabet.size()){
					longestStreak = alphabet.size();
				}
				slideWindow++;
			}
			
			
			return longestStreak;
	    }

	public static void main(String[] args) {


		System.out.println(longestSubStringWithoutRepeat("aabcdab"));

	}

}
