/**
 * 
 */
package com.practice.educative.grokking.sliding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author SKJ-PC
 *
 *Example 1:

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
Example 2:

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
Example 3:

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class CharacterReplacement {
	
	public static int findLength(String str, int k) {
	    
		int maxCnt = 0;
		int count = 0;
		int windowStart = 0;
		Map<Character, Integer> characterMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			Character character = str.charAt(windowEnd);
			characterMap.put(character, characterMap.getOrDefault(character, 0) + 1);
			
			while(characterMap.size() > 2) {
				
				Character startChar = str.charAt(windowStart);
				
				if(characterMap.get(startChar) == 1) {
					characterMap.remove(startChar);
				} else {
					characterMap.put(startChar, characterMap.get(startChar) - 1);
				}
				windowStart++;
			}
			
			if(characterMap.size() > 1) {
				List<Character> chars = characterMap.keySet().stream().filter(key -> characterMap.get(key) == k).collect(Collectors.toList());
				
				if(chars.size() > 0) {
					count = windowEnd - windowStart + 1;
					maxCnt = Math.max(maxCnt, count);
				}
			}
			
		}
		
	    return maxCnt;
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(CharacterReplacement.findLength("aabccbb", 2));
	    System.out.println(CharacterReplacement.findLength("abbcb", 1));
	    System.out.println(CharacterReplacement.findLength("abccde", 1));
	}

}
